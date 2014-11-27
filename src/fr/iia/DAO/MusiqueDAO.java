/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Musique;
import fr.iia.Class.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Enzo
 */
public class MusiqueDAO {
    public static void creer(Connection cnx, Musique mus, Utilisateur util) throws Exception{
               
        Musique m = trouver(cnx, mus.getTitre(), mus.getArtiste());
        
        if(m != null){
            throw new Exception("'" + mus.getTitre()+ "' '" + mus.getArtiste()+ "' existe déja !");
        }
        
        Statement stmt = null;

        try{
            stmt = stmt = cnx.createStatement();
            stmt.executeUpdate("INSERT INTO musique (titre, artiste, description, genre, id_utilisateur) Values ('" + mus.getTitre() + "', '" + mus.getArtiste() + "', '" +  mus.getDescription() + "', '" + mus.getGenre() + "', '" + mus.getUtilisateur().getId() + ")" );

            ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM musique");
            if (rs.next()){
                int id = rs.getInt(1);
                mus.setId(id);

            System.out.println("Création réussie.");
            }	 
        }

        catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Echec creer musique");
        }

        finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    } 
    
    public static Musique trouver(Connection cnx, String titre, String artiste){
        
        Musique musique = null;
        
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select id_musique, description, genre, nom_artiste From musique m, utilisateur u WHERE m.id_utilisateur = u.id_utilisateur AND titre = '" + titre + "' AND artiste = '" + artiste + "';");
            if(rs.next()){
                
                String nomArtiste = rs.getString("nom_artiste");

                Utilisateur utilisateur = UtilisateurDAO.trouver(cnx, nomArtiste);
                
                int id = rs.getInt("id_musique");
                String description = rs.getString("description");
                String genre = rs.getString("genre");
                

                musique = new Musique(titre, artiste, description, genre, utilisateur);
                //personne.setAge(age);
                musique.setId(id);
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec trouver musique");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return musique;
    }
    
    public static void supprimer(Connection cnx, Musique musique){

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE FROM musique WHERE id = " + musique.getId() );

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec supprimer musique");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static ArrayList<Musique> lister(Connection cnx){

        ArrayList<Musique> liste = new ArrayList<>();

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_musique, titre, artiste, description, genre, nom_artiste FROM musique, utilisateur Where musique.id_utilisateur = utilisateur.id_utilisateur");
            while(rs.next()){
                int id = rs.getInt("id_musique");
                String titre = rs.getString("titre");
                String artiste = rs.getString("artiste");
                String description = rs.getString("description");
                String genre = rs.getString("genre");
               
              
                String nom_artiste = rs.getString("nom_artiste");

                Utilisateur utilisateur = UtilisateurDAO.trouver(cnx, nom_artiste);

                Musique musique = new Musique(titre, artiste, description, genre, utilisateur);
                musique.setId(id);

                liste.add(musique);				
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec lister musique");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return liste;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Media;
import fr.iia.Class.TypeMedia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Enzo
 */
public class MediaDAO {
    
    public static void creer(Connection cnx, Media med, TypeMedia typeMedia){
               
        Statement stmt = null;

        try{
            stmt = stmt = cnx.createStatement();
            stmt.executeUpdate("INSERT INTO media (nom, taille, id_type) Values ('" + med.getNom() + "', '" + med.getTaille()+ "', " + med.getTypeMedia() + ")" );

            ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM media");
            if (rs.next()){
                    int id = rs.getInt(1);
                    med.setId(id);

            System.out.println("Création réussie.");
            }	 
        }
        
        catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Echec creer metier");
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
    
    public static Media trouver(Connection cnx, int id){
        Media media = null;
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select nom, taille, id_type From media WHERE id_media = '" + id + "';");
            if(rs.next()){
                
                int idType = rs.getInt("id_type");

                TypeMedia typeMedia = TypeMediaDAO.trouver(cnx, idType);
                
                String nom = rs.getString("nom");
                int taille = rs.getInt("taille");

                media = new Media(nom, taille, typeMedia);
                //personne.setAge(age);
                media.setId(id);
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec trouver metier");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return media;
    }
    
    public static void supprimer(Connection cnx, Media media){

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE FROM media WHERE id = " + media.getId() );

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec supprimer media");
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
    
    public static ArrayList<Media> lister(Connection cnx){

        ArrayList<Media> liste = new ArrayList<>();

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_media, nom, taille, id_type FROM media");
            while(rs.next()){
                int id = rs.getInt("id_media");
                String nom = rs.getString("nom");
                int taille = rs.getInt("taille");
                int idType = rs.getInt("id_type");

                TypeMedia typeMedia = TypeMediaDAO.trouver(cnx, idType);

                Media media= new Media(nom, taille, typeMedia);
                media.setTaille(taille);
                media.setId(id);

                liste.add(media);				
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec lister media");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Adresse;
import fr.iia.Class.Annonceur;
import fr.iia.Class.Media;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Enzo
 */
public class AnnonceursDAO {
    
    public static void creer(Connection cnx, Annonceur annonceur) throws Exception{

        Annonceur ann = trouver(cnx, annonceur.getNom());
        if(ann != null){
            throw new Exception("'" + annonceur.getNom() + "' existe déja !");
        }

        AdresseDAO.creer(cnx, annonceur.getAdresse());

        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            String sql = "INSERT INTO annonceur (nom, mail, telephone, id_adresse) "
                + "Values ('" + annonceur.getNom() + "', '" + annonceur.getMail() + "', '" + annonceur.getNumeroTel() + "', " + annonceur.getAdresse().getId()  + ")" ;
            stmt.executeUpdate(sql);                 

            ResultSet rs = stmt.executeQuery("SELECT MAX(id_annonceur) FROM annonceur");
            if (rs.next()){
                int id = rs.getInt(1);
                annonceur.setId(id);
            }



        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec creer annonceur");
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
        
    public static Annonceur trouver(Connection cnx, String nom){
        Annonceur annonceur = null;
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select id_annonceur, mail, telephone, id_adresse, id_media From annonceur WHERE nom = '" + nom + "';");
            if(rs.next()){
                int idAdr = rs.getInt("id_adresse");
                int idMedia = rs.getInt("id_media");

                Adresse adr = AdresseDAO.trouver(cnx, idAdr);
                Media med = MediaDAO.trouver(cnx, idMedia);
                int id = rs.getInt("id_annonceur");
                String mail = rs.getString("mail");
                String numeroTel = rs.getString("telephone");

                annonceur = new Annonceur(nom, mail, numeroTel, adr, med);

                annonceur.setId(id);				
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec trouver annonceur");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }		
        return annonceur;
    }
        
    public static Annonceur trouver(Connection cnx, int id){
        Annonceur annonceur = null;
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select nom, mail, telephone, id_adresse, id_media From annonceur WHERE id_annonceur = '" + id + "';");
            if(rs.next()){
                int idAdr = rs.getInt("id_adresse");
                int idMed = rs.getInt("id_media");

                Adresse adr = AdresseDAO.trouver(cnx, idAdr);
                Media med = MediaDAO.trouver(cnx, idMed);

                String nom = rs.getString("nom");
                String mail = rs.getString("mail");
                String numeroTel = rs.getString("telephone");
                annonceur = new Annonceur(nom, mail, numeroTel, adr, med);

                annonceur.setId(id);				
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec trouver annonceur");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }		
        return annonceur;
    }
        
    public static void modifier(Connection cnx, Annonceur annonceur) throws Exception{
        Annonceur a = trouver(cnx, annonceur.getNom());

        if(a != null){
            try{
                throw new Exception(annonceur.getNom() + " existe déja !");
            }
            catch(Exception ex){	

            }
        }		

        AdresseDAO.modifier(cnx, annonceur.getAdresse());
        MediaDAO.modifier(cnx, annonceur.getMedia());
        
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            stmt.executeUpdate("UPDATE annonceur "
                + "SET nom = '" + annonceur.getNom() + "', mail = '" + annonceur.getMail() + "', telephone = " + annonceur.getNumeroTel() + "', id_adresse = " + annonceur.getAdresse() + "', id_media = " + annonceur.getMedia() + " "
                + "WHERE id_annonceur = " + annonceur.getId());


        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec modifier annonceur");
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

    public static void supprimer(Connection cnx, Annonceur annonceur){

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE FROM annonceur WHERE id_annonceur = " + annonceur.getId() );

            AdresseDAO.supprimer(cnx, annonceur.getAdresse());
            MediaDAO.supprimer(cnx, annonceur.getMedia());
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec supprimer annonceur");
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



    public static ArrayList<Annonceur> lister(Connection cnx){

        ArrayList<Annonceur> liste = new ArrayList<>();

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_annonceur, nom, mail, telephone, id_adresse, id_media FROM annonceur");
            while(rs.next()){
                int idAdr = rs.getInt("id_adresse");
                int idMed = rs.getInt("id_media");

                int id = rs.getInt("id_annonceur");
                String nom = rs.getString("nom");
                String mail = rs.getString("mail");
                String numeroTel = rs.getString("telephone");

                Adresse adresse =AdresseDAO.trouver(cnx, idAdr);
                Media media = MediaDAO.trouver(cnx, idMed);

                Annonceur annonceur= new Annonceur(nom, mail, numeroTel, adresse, media);
                annonceur.setMail(mail);
                annonceur.setId(id);

                liste.add(annonceur);				
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec lister annonceur");
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

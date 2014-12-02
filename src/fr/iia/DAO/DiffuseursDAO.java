/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Adresse;
import fr.iia.Class.Diffuseur;
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
public class DiffuseursDAO {
    
    public static void creer(Connection cnx, Diffuseur diffuseur) throws Exception{
            
        Diffuseur dif = trouver(cnx, diffuseur.getNom());
        if(dif != null){
            throw new Exception("'" + diffuseur.getNom() + "' existe déja !");
        }

        AdresseDAO.creer(cnx, diffuseur.getAdresse());

        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            stmt.executeUpdate("INSERT INTO diffuseur (nom, mail, telephone, id_adresse, id_media) "
                    + "Values ('" + diffuseur.getNom() + "', '" + diffuseur.getMail() + "', '" + diffuseur.getNumeroTel() + "', '" + diffuseur.getAdresse() + "', '" + diffuseur.getMedia() + "')" );                 

            ResultSet rs = stmt.executeQuery("SELECT MAX(id_diffuseur) FROM diffuseur");
            if (rs.next()){
                int id = rs.getInt(1);
                diffuseur.setId(id);
            }

        }catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Echec creer diffuseur");
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
        
    public static Diffuseur trouver(Connection cnx, String nom){
        Diffuseur diffuseur = null;
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select id_diffuseur, mail, telephone, id_adresse, id_media From diffuseur WHERE nom = '" + nom + "';");
            if(rs.next()){
                int idAdr = rs.getInt("id_adresse");
                int idMedia = rs.getInt("id_media");

                Adresse adr = AdresseDAO.trouver(cnx, idAdr);
                Media med = MediaDAO.trouver(cnx, idAdr);
                int id = rs.getInt("id_diffuseur");
                String mail = rs.getString("mail");
                String numeroTel = rs.getString("telephone");
                diffuseur = new Diffuseur(id, nom, mail, numeroTel, adr, med);

                diffuseur.setId(id);				
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec trouver diffuseur");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }		
        return diffuseur;
    }
    
       public static Diffuseur trouver(Connection cnx, int id){
        Diffuseur diffuseur = null;
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select nom, mail, telephone, id_adresse, id_media From diffuseur WHERE id_diffuseur = '" + id + "';");
            if(rs.next()){
                int idAdr = rs.getInt("id_adresse");
                int idMedia = rs.getInt("id_media");

                Adresse adr = AdresseDAO.trouver(cnx, idAdr);
                Media med = MediaDAO.trouver(cnx, idAdr);
                String nom = rs.getString("nom");
                String mail = rs.getString("mail");
                String numeroTel = rs.getString("telephone");
                diffuseur = new Diffuseur(id, nom, mail, numeroTel, adr, med);

                diffuseur.setId(id);				
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec trouver diffuseur");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }		
        return diffuseur;
    }
       
    public static void modifier(Connection cnx, Diffuseur diffuseur) throws Exception{
        Diffuseur d = trouver(cnx, diffuseur.getNom());

        if(d != null){
            try{
                throw new Exception(diffuseur.getNom() + " existe déja !");
            }
            catch(Exception ex){	

            }
        }		

        AdresseDAO.modifier(cnx, diffuseur.getAdresse());
        MediaDAO.modifier(cnx, diffuseur.getMedia());
        
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            stmt.executeUpdate("UPDATE annonceur "
                + "SET nom = '" + diffuseur.getNom() + "', mail = '" + diffuseur.getMail() + "', telephone = " + diffuseur.getNumeroTel() + "', id_adresse = " + diffuseur.getAdresse() + "', id_media = " + diffuseur.getMedia() + " "
                + "WHERE id_diffuseur = " + diffuseur.getId());


        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec modifier diffuseur");
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
        
    public static void supprimer(Connection cnx, Diffuseur diffuseur){

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE FROM diffuseur WHERE id_diffuseur = " + diffuseur.getId());

            AdresseDAO.supprimer(cnx, diffuseur.getAdresse());
            MediaDAO.supprimer(cnx, diffuseur.getMedia());
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec supprimer diffuseur");
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

    public static ArrayList<Diffuseur> lister(Connection cnx){

        ArrayList<Diffuseur> liste = new ArrayList<>();

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_diffuseur, nom, mail, numeroTel, id_adresse, id_media FROM diffuseur");
            while(rs.next()){
                int id = rs.getInt("id_diffuseur");
                String nom = rs.getString("nom");
                String mail = rs.getString("mail");
                String numeroTel = rs.getString("numeroTel");
                int idAdr = rs.getInt("id_adresse");
                int idMed = rs.getInt("id_media");

                Adresse adresse = AdresseDAO.trouver(cnx, idAdr);
                Media media = MediaDAO.trouver(cnx, idMed);

                Diffuseur diffuseur= new Diffuseur(id, nom, mail, numeroTel, adresse, media);
                diffuseur.setMail(mail);
                diffuseur.setId(id);

                liste.add(diffuseur);				
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec lister diffuseur");
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

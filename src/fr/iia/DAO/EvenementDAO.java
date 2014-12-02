/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Adresse;
import fr.iia.Class.Annonceur;
import fr.iia.Class.Evenement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Enzo
 */
public class EvenementDAO {
    public static void creer(Connection cnx, Evenement evenement) throws Exception{
            
        Evenement eve = trouver(cnx, evenement.getNom());
        if(eve != null){
            throw new Exception("'" + evenement.getNom() + "' existe déjà !");
        }

        AdresseDAO.creer(cnx, evenement.getAdresse());
        AnnonceursDAO.creer(cnx, evenement.getAnnonceur());

        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            stmt.executeUpdate("INSERT INTO diffuseur (nom, mail, telephone, id_adresse, id_annonceur) "
                    + "Values ('" + evenement.getNom() + "', '" + evenement.getDescription() + "', '" + evenement.getDate() + "', '" + evenement.getAdresse() + "', '" + evenement.getAnnonceur() + "')" );                 

            ResultSet rs = stmt.executeQuery("SELECT MAX(id_evenement) FROM evenement");
            if (rs.next()){
                int id = rs.getInt(1);
                evenement.setId(id);
            }

        }catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Echec creer evenement");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } 
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }		
    }
    
    public static void supprimer(Connection cnx, Evenement eve){
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE From evenement Where id_evenement = " + eve.getId());

            System.out.println("Suppression réussie.");	
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Suppression échouée.");
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

    public static void modifier(Connection cnx, Evenement evenement) throws Exception {
        Evenement event = trouver(cnx, evenement.getId());

        if(event != null){
            try{
                throw new Exception(evenement.getId() + " existe déja !");
            }
            catch(Exception ex){	

            }
        }		

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            stmt.executeUpdate("UPDATE media "
                + "SET nom = '" + evenement.getNom() + "', description = '" + evenement.getDescription() + "', date = '" + evenement.getDate() + "', id_adresse = '" + evenement.getAdresse() + "', id_annonceur = '" + evenement.getAnnonceur()+ " "
                + "WHERE id_evenement = " + evenement.getId());


        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec modifier evenement");
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

    public static ArrayList<Evenement> lister(Connection cnx){
        ArrayList<Evenement> ListEvenement = new ArrayList();
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_evenement, nom, description, date, id_adresse, id_annonceur FROM evenement");

            while(rs.next()){
                int id = rs.getInt("id_evenement");
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                Date date = rs.getDate("date");
                Adresse adresse = AdresseDAO.trouver(cnx, id);
                Annonceur annonceur = AnnonceursDAO.trouver(cnx, nom);

                Evenement evenement = new Evenement(nom, description, date, adresse, annonceur);
                evenement.setId(id);
            }	
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec lister");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ListEvenement;
    }

    public static Evenement trouver(Connection cnx, String nom){
        Evenement evenement = null;
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_evenement, description, date, id_adresse, id_annonceur FROM evenement WHERE nom = " + nom + ";");

            if(rs.next()){
                String libelle = rs.getString("libelle");
                
                int id = rs.getInt("id_evenement");
                String description = rs.getString("description");
                Date date = rs.getDate("date");
                Adresse adresse = AdresseDAO.trouver(cnx, id);
                Annonceur annonceur = AnnonceursDAO.trouver(cnx, nom);

                Evenement eveResult = new Evenement(nom, description, date, adresse, annonceur);
                
                eveResult = new Evenement(nom, description, date, adresse, annonceur);
            }	

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec trouver");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return evenement;
    }
    
    public static Evenement trouver(Connection cnx, int id){
        Evenement evenement = null;
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nom, description, date, id_adresse, id_annonceur FROM evenement WHERE id_evenement = " + id + ";");

            if(rs.next()){
                String libelle = rs.getString("libelle");
                
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                Date date = rs.getDate("date");
                Adresse adresse = AdresseDAO.trouver(cnx, id);
                Annonceur annonceur = AnnonceursDAO.trouver(cnx, nom);

                Evenement eveResult = new Evenement(nom, description, date, adresse, annonceur);
                
                eveResult = new Evenement(nom, description, date, adresse, annonceur);
            }	

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec trouver");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return evenement;
    }
}

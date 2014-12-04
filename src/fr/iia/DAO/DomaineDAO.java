/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Domaine;
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
public class DomaineDAO {
    public static void supprimer(Connection cnx, Domaine dom){
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE domaine WHERE id_domaine = " + dom.getId() + "'");

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


    public static ArrayList<Domaine> lister(Connection cnx){
        ArrayList<Domaine> ListAdresse = new ArrayList();
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_domaine, libelle FROM domaine");

            while(rs.next()){
                int id = rs.getInt(1);
                String domaine = rs.getString(2);

                Domaine domResult = new Domaine(domaine);
                domResult.setId(id);
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
        return ListAdresse;
    }

    public static Domaine trouver(Connection cnx, int id){
        Domaine domaine = null;
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT libelle FROM domaine WHERE id_domaine = " + id);

            if(rs.next()){
                String libelle = rs.getString("libelle");
                
                domaine = new Domaine(libelle);
                domaine.setId(id);
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
        return domaine;
    }
}

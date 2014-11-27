/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Domaine;
import fr.iia.Class.Metier;
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
public class MetierDAO {
    public static void creer(Connection cnx, Metier met, Domaine dom) throws Exception{
               
        
        Metier m = trouver(cnx, met.getLibelle());
        try {
            if(m == null){
                Statement stmt = null;

                try{
                    stmt = stmt = cnx.createStatement();
                    stmt.executeUpdate("INSERT INTO metier (libelle, id_domaine) Values ('" + met.getLibelle() + "', '" + met.getDomaine() + ")" );

                    ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM metier");
                    if (rs.next()){
                            int id = rs.getInt(1);
                            met.setId(id);

                    System.out.println("Création réussie.");
                    }	 
                }

                catch(Exception ex){
                        ex.printStackTrace();
                        System.out.println("Echec creer metiers");
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
        }    
        catch (Exception e) {
            throw new Exception("'" + met.getLibelle() + "' existe déja !");
        }  
    }
    
    public static Metier trouver(Connection cnx, String libelle){
        Metier metier = null;
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select id_metier, id_domaine From metier WHERE libelle = '" + libelle + "';");
            if(rs.next()){
                
                int idDom = rs.getInt("id_domaine");

                Domaine domaine = DomaineDAO.trouver(cnx, idDom);
                
                int id = rs.getInt("id_metier");

                metier = new Metier(libelle, domaine);
                //personne.setAge(age);
                metier.setId(id);
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

        return metier;
    }
    
    public static Metier trouver(Connection cnx, int id){
        Metier metier = null;
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select libelle, id_domaine From metier WHERE id_metier = '" + id + "';");
            if(rs.next()){
                
                int idDom = rs.getInt("id_domaine");

                Domaine domaine = DomaineDAO.trouver(cnx, idDom);
                
                String libelle = rs.getString("libelle");

                metier = new Metier(libelle, domaine);
                //personne.setAge(age);
                metier.setId(id);
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

        return metier;
    }
    
    public static void supprimer(Connection cnx, Metier metier){

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE FROM metier WHERE id = " + metier.getId() );

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec supprimer metier");
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
    
    public static ArrayList<Metier> lister(Connection cnx){

        ArrayList<Metier> liste = new ArrayList<>();

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_metier, libelle, id_domaine FROM metier");
            while(rs.next()){
                int id = rs.getInt("id_metier");
                String libelle = rs.getString("libelle");
                int idDom = rs.getInt("id_domaine");

                Domaine domaine = DomaineDAO.trouver(cnx, idDom);

                Metier metier= new Metier(libelle, domaine);
                metier.setId(id);

                liste.add(metier);				
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec lister metier");
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

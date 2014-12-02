/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;


import fr.iia.Class.Contrat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Flo
 */
public class ContratDAO {
    
    public static Contrat trouver(Connection cnx, int id){
        Contrat contrat = null;
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select libelle From contrat WHERE id__contrat = '" + id + "';");
            if(rs.next()){
                String libelle = rs.getString("libelle");

                contrat = new Contrat(libelle);
                contrat.setId(id);				
            }
        }catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Echec trouver contrat");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }		
        return contrat;
    }
    
    public static Contrat trouver(Connection cnx, String libelle){
        Contrat contrat = null;
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select id_contrat From contrat WHERE libelle = '" + libelle + "';");
            if(rs.next()){
                int id = rs.getInt("id_contrat");

                contrat = new Contrat(libelle);

                contrat.setId(id);				
            }

        }catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Echec trouver contrat");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }		
        return contrat;
    }

    public static void supprimer(Connection cnx, Contrat contrat){

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE FROM contrat WHERE id_contrat = " + contrat.getId() );


        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec supprimer contrat");
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

    public static ArrayList<Contrat> lister(Connection cnx){

        ArrayList<Contrat> liste = new ArrayList<>();

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_contrat, libelle FROM contrat");
            while(rs.next()){
                int id = rs.getInt("id_contrat");
                String libelle = rs.getString("libelle");

                Contrat contrat= new Contrat(libelle);
                contrat.setId(id);

                liste.add(contrat);				
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec lister contrat");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Compte;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Enzo
 */
public class CompteDAO {
    public static ArrayList<Compte> lister(Connection cnx){
        ArrayList<Compte> ListCompte = new ArrayList();
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_compte, login, password FROM compte");

            while(rs.next()){
                int id = rs.getInt(1);
                String login = rs.getString(2);
                String password = rs.getString(3);
                

                Compte compteResult = new Compte(login, password);
                compteResult.setId(id);
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
        return ListCompte;
    }

    public static Compte trouver(Connection cnx, int id){
        Compte compte = null;
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT login, password FROM compte WHERE id_compte = " + id);

            if(rs.next()){
                String login = rs.getString("login");
                String password = rs.getString("password");
                
                compte = new Compte(login, password);
                compte.setId(id);
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
        return compte;
    }
}

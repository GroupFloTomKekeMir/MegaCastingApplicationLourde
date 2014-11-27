/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Adresse;
import fr.iia.Class.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Enzo
 */
public class UtilisateurDAO {
    public static Utilisateur trouver(Connection cnx, String nom_artiste){
        Utilisateur utilisateur = null;
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select nom, prenom, age, mail, telephone, id_adresse, descr_util From utilisateur WHERE nom_artiste = '" + nom_artiste + "';");
            if(rs.next()){
                int idAdr = rs.getInt("idAdr");

                Adresse adresse = AdresseDAO.trouver(cnx , idAdr);
                String login = rs.getString("login");
                String password = rs.getString("password");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String mail = rs.getString("mail");
                String telephone = rs.getString("telephone");
                String descr_util = rs.getString("descr_util");
                int age = rs.getInt("age");
                int id = rs.getInt("id");

                utilisateur = new Utilisateur(login, password, nom, prenom, nom_artiste, age, mail, telephone, adresse, descr_util);
                utilisateur.setId(id);
            }	
        }
        catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Echec trouver utilisateur");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return utilisateur;
    }
    
    public static Utilisateur trouver(Connection cnx, int id){
        Utilisateur utilisateur = null;
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select nom, prenom, nom_artiste, age, mail, telephone, id_adresse, descr_util From utilisateur WHERE id_utilisateur = '" + id + "';");
            if(rs.next()){
                int idAdr = rs.getInt("idAdr");

                Adresse adresse = AdresseDAO.trouver(cnx , idAdr);
                String login = rs.getString("login");
                String password = rs.getString("password");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String nomArtiste = rs.getString("nom_artiste");
                String mail = rs.getString("mail");
                String telephone = rs.getString("telephone");
                String descr_util = rs.getString("descr_util");
                int age = rs.getInt("age");

                utilisateur = new Utilisateur(login, password, nom, prenom, nomArtiste, age, mail, telephone, adresse, descr_util);
                utilisateur.setId(id);
            }	
        }
        catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Echec trouver utilisateur");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return utilisateur;
    }
}

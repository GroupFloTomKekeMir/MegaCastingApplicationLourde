/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Adresse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Enzo
 */
public class UtilisateurDAO {
    public static Utilisateur trouver(Connection cnx, String nom, String prenom){
		Utilisateur Utilisateur = null;
		Statement stmt = null;
		try{			
			stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery("Select id, age, idAdr From Personne WHERE nom = '" + nom + "' AND prenom = '" + prenom + "';");
			if(rs.next()){
				int idAdr = rs.getInt("idAdr");
				
				Adresse adresse = AdresseDAO.trouver(cnx , idAdr);
				int age = rs.getInt("age");
				int id = rs.getInt("id");
				
				utilisateur = new Utilisateur(nom, prenom, age, adresse);
				//personne.setAge(age);
				utilisateur.setId(id);
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Echec trouver personne");
		}finally{
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		return personne;
	}
}

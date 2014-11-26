/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Adresse;
import fr.iia.Class.Diffuseur;
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
			stmt.executeUpdate("INSERT INTO diffuseur (nom, adresse, mail, telephone) Values ('" + diffuseur.getNom() + "', '" + diffuseur.getAdresse().getId() + "', " + diffuseur.getMail() + ", " + diffuseur.getNumeroTel()+ ")" );                 
			
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM diffuseur");
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
			ResultSet rs = stmt.executeQuery("Select id, adresse, mail, telephone From diffuseur WHERE nom = '" + nom + "';");
			if(rs.next()){
				int idAdr = rs.getInt("adresse");
				
				Adresse adr = AdresseDAO.trouver(cnx, idAdr);
				int id = rs.getInt("id");
				String mail = rs.getString("mail");
                                String numeroTel = rs.getString("telephone");
				diffuseur = new Diffuseur(nom, adr, mail, numeroTel);
				
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
        
        public static void supprimer(Connection cnx, Diffuseur diffuseur){
		
		Statement stmt = null;
		try{			
			stmt = cnx.createStatement();
			stmt.executeUpdate("DELETE FROM diffuseur WHERE id = " + diffuseur.getId() );
		
			AdresseDAO.supprimer(cnx, diffuseur.getAdresse());
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
			ResultSet rs = stmt.executeQuery("SELECT id_diffuseur, nom, adresse, mail, numeroTel FROM diffuseur");
			while(rs.next()){
				int id = rs.getInt("id_diffuseur");
				String nom = rs.getString("nom");
				String mail = rs.getString("mail");
				String numeroTel = rs.getString("numeroTel");
				
				Adresse adresse =AdresseDAO.trouver(cnx, id);
				
				Diffuseur diffuseur= new Diffuseur(nom, adresse, mail, numeroTel);
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

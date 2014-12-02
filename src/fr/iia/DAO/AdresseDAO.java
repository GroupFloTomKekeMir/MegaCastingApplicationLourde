package fr.iia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.iia.Class.Adresse;

public class AdresseDAO {
	
    public static void creer(Connection cnx, Adresse adr){

        PreparedStatement pstmt = null;
        try{
            pstmt = cnx.prepareStatement("INSERT INTO adresse"
                + " (numero, rue, code_postal, ville, localisation)"
                + " VALUES (?, ?, ?, ?)");

            pstmt.setInt(1, adr.getNumero() );
            pstmt.setString(2, adr.getRue());
            pstmt.setInt(3, adr.getCodePostal());
            pstmt.setString(4, adr.getVille() );
            pstmt.setString(5, adr.getLocalisation());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.executeQuery("SELECT MAX(id_adr) FROM adresse");
            if(rs.next()){
                int id = rs.getInt(1);
                adr.setId(id);
            }

            System.out.println("Création réussie.");

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Création échouée.");
        }finally{
            if(pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }	

    public static void modifier(Connection cnx, Adresse adr){

        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            stmt.executeUpdate("UPDATE adresse "
                    + "SET numero = " + adr.getNumero() + ", code_postal = " + adr.getCodePostal() + ", rue = '" + adr.getRue() + "', ville = '" + adr.getVille() + "', localisation = '" + adr.getLocalisation() + "' "
                    + "WHERE id_adr = " + adr.getId());
            System.out.println("Modification réussie.");


        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Modification échouée.");
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

    public static void supprimer(Connection cnx, Adresse adr){
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE From adresse where id_adr = " + adr.getId());

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


    public static ArrayList<Adresse> lister(Connection cnx){
        ArrayList<Adresse> ListAdresse = new ArrayList();
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_adr, numero, rue, code_postal, ville, localisation FROM adresse");

            while(rs.next()){
                int id = rs.getInt(1);
                int numero = rs.getInt(2);
                String rue = rs.getString(3);
                int codePostal = rs.getInt(4);
                String ville = rs.getString(5);
                String localisation = rs.getString(6);

                Adresse adrResult = new Adresse(numero, codePostal, rue, ville, localisation);
                adrResult.setNumero(numero);
                adrResult.setId(id);
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

    public static Adresse trouver(Connection cnx, int id){
        Adresse adresse = null;
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT numero, rue, code_postal, ville, localisation FROM adresse WHERE id_adr = " + id);

            if(rs.next()){
                int numero = rs.getInt("numero");
                String rue = rs.getString("rue");
                int codePostal = rs.getInt("code_postal");
                String ville = rs.getString("ville");
                String localisation = rs.getString("localisation");

                adresse = new Adresse(numero, codePostal, rue, ville, localisation);
                adresse.setId(id);
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
        return adresse;
    }
}
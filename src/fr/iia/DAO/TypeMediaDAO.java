/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.TypeMedia;
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
public class TypeMediaDAO {
    	
    public static ArrayList<TypeMedia> lister(Connection cnx){
        ArrayList<TypeMedia> ListAdresse = new ArrayList();
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_type, format FROM type_media");

            while(rs.next()){
                int id = rs.getInt(1);
                String format = rs.getString(2);

                TypeMedia typResult = new TypeMedia(format);
                typResult.setFormat(format);
                typResult.setId(id);
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
	
    public static TypeMedia trouver(Connection cnx, int id){
        TypeMedia typemedia = null;
        Statement stmt = null;
        try{

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT format FROM type_media WHERE id_type = " + id);

            if(rs.next()){
                String format = rs.getString("format");

                typemedia = new TypeMedia(format);
                typemedia.setId(id);
            }		
        }
        catch(Exception ex){
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
        return typemedia;
    }
}

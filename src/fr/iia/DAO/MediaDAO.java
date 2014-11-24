/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Media;
import fr.iia.Class.TypeMedia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Enzo
 */
public class MediaDAO {
    
    public static void creer(Connection cnx, Media med){
			
		PreparedStatement pstmt = null;
		try{
			pstmt = cnx.prepareStatement("INSERT INTO media"
                                                    + " (nom, taille, id_type)"
                                                    + " VALUES (?, ?)");
				
			pstmt.setString(1, med.getNom() );
			pstmt.setInt(2, med.getTaille());
						
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.executeQuery("SELECT MAX(id) FROM media");
			if(rs.next()){
				int id = rs.getInt(1);
				med.setId(id);
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
}

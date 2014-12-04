/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.Connection;

/**
 *
 * @author Enzo
 */

import java.sql.Connection;
import java.sql.DriverManager;


public class JavaConnect {
    public static void ImportDriver() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }

        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
    
    public static Connection ConnectDB() {   
        Connection cnx = null;
        String url = "jdbc:mysql://localhost/megacasting";

        try {

            cnx = DriverManager.getConnection(url, "root", "");
            return cnx;
        } 
        catch(Exception ex) {

            ex.printStackTrace();
            System.out.println("Connexion échouée !");
        } 
        
        return cnx;
    }
}

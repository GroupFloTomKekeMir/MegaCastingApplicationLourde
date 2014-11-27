/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Annonceur;
import fr.iia.Class.Contrat;
import fr.iia.Class.Diffuseur;
import fr.iia.Class.Metier;
import fr.iia.Class.Offre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Enzo
 */
public class OffreDAO {
    public static void creer(Connection cnx, Offre off) throws Exception{
               
        Offre o = trouver(cnx, off.getReference());
        
        if(o != null){
            throw new Exception("'" + off.getReference() + "' existe déja !");
        }
        
        Statement stmt = null;

        try{
            stmt = stmt = cnx.createStatement();
            stmt.executeUpdate("INSERT INTO offre (titre, reference, date_debut_publi, fin_publi, nbr_poste, descr_poste, descr_profil, duree_contrat, "
                    + "id_contrat, id_annonceur, id_difuseur, id_metier) "
                    + "Values ('" + off.getTitre() + "', '" 
                    + off.getReference() + "', '" 
                    +  off.getDate_debut_publi() + "', '" 
                    + off.getFin_publi() + "', '" 
                    + off.getNbr_poste() + "', '" 
                    + off.getDescription_poste() + "', '" 
                    + off.getDescription_profil() + "', '" 
                    + off.getContrat().getId() + "', '" 
                    + off.getAnnonceur().getId() + "', '" 
                    + off.getDiffuseur().getId() + "', '" 
                    + off.getMetier().getId() + ")" );

            ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM offre");
            if (rs.next()){
                int id = rs.getInt(1);
                off.setId(id);

            System.out.println("Création réussie.");
            }	 
        }

        catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Echec creer offre");
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
    
    public static Offre trouver(Connection cnx, String reference){
        
        Offre offre = null;
        
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select id_offre, titre, date_debut_publi, fin_publi, nbr_poste, descr_poste, descr_profil, duree_contrat, "
                    + "id_contrat, id_annonceur, id_diffuseur, id_metier "
                    + "From offre "
                    + "WHERE reference = '" + reference + "';");
            if(rs.next()){
                
                int idContrat = rs.getInt("id_contrat");
                int idAnnonceur = rs.getInt("id_annonceur");
                int idDiffuseur = rs.getInt("id_diffuseur");
                int idMetier = rs.getInt("id_metier");
               
                Metier metier = MetierDAO.trouver(cnx, idContrat);
                Contrat contrat = ContratDAO.trouver(cnx, idAnnonceur);
                Annonceur annonceur = AnnonceursDAO.trouver(cnx, idDiffuseur);
                Diffuseur diffuseur = DiffuseursDAO.trouver(cnx, idMetier);

                
                int id = rs.getInt("id_offre");
                String titre = rs.getString("titre");
                Date dateDebutPubli = rs.getDate("date_debut_publi");
                Date dateFinPubli = rs.getDate("fin_publi");
                int nbrPoste = rs.getInt("nbr_poste");
                String descrPoste = rs.getString("descr_poste");
                String descrProfil = rs.getString("descr_profil");
                int dureeContrat = rs.getInt("duree_contrat");
                
                offre = new Offre(titre, reference, dateDebutPubli, dateFinPubli, nbrPoste, descrPoste, descrProfil, nbrPoste, contrat, annonceur, diffuseur, metier);
                //personne.setAge(age);
                offre.setId(id);
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec trouver musique");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return offre;
    }
    
    public static void supprimer(Connection cnx, Offre offre){

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE FROM offre WHERE id = " + offre.getId() );

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec supprimer offre");
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
    
    public static ArrayList<Offre> lister(Connection cnx){

        ArrayList<Offre> liste = new ArrayList<>();

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_offre, titre, reference, date_debut_publi, fin_publi, nbr_poste, descr_poste, descr_profil, duree_contrat, "
                    + "id_contrat, id_diffuseur, id_annonceur, id_metier "
                    + "From offre");
            
            while(rs.next()){
                int id = rs.getInt("id_offre");
                String titre = rs.getString("titre");
                String reference = rs.getString("reference");
                Date dateDebutPubli = rs.getDate("date_debut_publi");
                Date dateFinPubli = rs.getDate("fin_publi");
                int nbrPoste = rs.getInt("nbr_poste");               
                String descrPoste = rs.getString("descr_poste");
                String descrProfil = rs.getString("descr_profil");
                int dureeContrat = rs.getInt("duree_contrat");
               
                int idContrat = rs.getInt("id_contrat");
                int idAnnonceur = rs.getInt("id_annonceur");
                int idDiffuseur = rs.getInt("id_diffuseur");
                int idMetier = rs.getInt("id_metier");
               
                Metier metier = MetierDAO.trouver(cnx, idContrat);
                Contrat contrat = ContratDAO.trouver(cnx, idAnnonceur);
                Annonceur annonceur = AnnonceursDAO.trouver(cnx, idDiffuseur);
                Diffuseur diffuseur = DiffuseursDAO.trouver(cnx, idMetier);

                Offre offre = new Offre(titre, reference, dateDebutPubli, dateFinPubli, nbrPoste, descrPoste, descrProfil, nbrPoste, contrat, annonceur, diffuseur, metier);
                offre.setId(id);

                liste.add(offre);				
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec lister musique");
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

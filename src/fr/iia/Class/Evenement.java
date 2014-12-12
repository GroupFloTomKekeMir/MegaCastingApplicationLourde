/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.Class;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Enzo
 */
public class Evenement {
    private int id;
    private String nom;
    private String description;
    private String dateEvenement;
    private Adresse Adresse;
    private Annonceur Annonceur;
    private Media Media;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(String dateEvenement) {
        this.dateEvenement = dateEvenement;
    }
    
    public Adresse getAdresse() {
        return Adresse;
    }

    public void setAnnonceur(Adresse Adresse) {
        this.Adresse = Adresse;
    }

    public Annonceur getAnnonceur() {
        return Annonceur;
    }

    public void setAnnonceur(Annonceur Annonceur) {
        this.Annonceur = Annonceur;
    }

    public Evenement(String nom, String description, String dateEvenement, Adresse Adresse, Annonceur Annonceur) {
        this.nom = nom;
        this.description = description;
        this.dateEvenement = dateEvenement;
        this.Adresse = Adresse;
        this.Annonceur = Annonceur;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.dateEvenement, other.dateEvenement)) {
            return false;
        }
        if (!Objects.equals(this.Adresse, other.Adresse)) {
            return false;
        }
        if (!Objects.equals(this.Annonceur, other.Annonceur)) {
            return false;
        }
        return true;
    }
}

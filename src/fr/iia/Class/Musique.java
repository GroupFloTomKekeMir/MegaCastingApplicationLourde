/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.Class;

import java.util.Objects;

/**
 *
 * @author Enzo
 */
public class Musique {
    private int id;
    private String titre;
    private String genre;
    private String description;
    private Utilisateur Utilisateur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Utilisateur getUtilisateur() {
        return Utilisateur;
    }

    public void setUtilisateur(Utilisateur Utilisateur) {
        this.Utilisateur = Utilisateur;
    }

    public Musique(String titre, String genre, String description, Utilisateur Utilisateur) {
        this.titre = titre;
        this.genre = genre;
        this.description = description;
        this.Utilisateur = Utilisateur;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Musique other = (Musique) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.Utilisateur, other.Utilisateur)) {
            return false;
        }
        return true;
    }
    
    
}

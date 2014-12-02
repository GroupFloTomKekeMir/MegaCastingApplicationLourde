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
public class Annonceur {
    private int id;
    private String nom;
    private String mail;
    private String numeroTel;
    private Adresse Adresse;
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

    public Adresse getAdresse() {
        return Adresse;
    }

    public void setAdresse(Adresse Adresse) {
        this.Adresse = Adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public Media getMedia() {
        return Media;
    }

    public void setMedia(Media Media) {
        this.Media = Media;
    }

    public Annonceur(String nom, String mail, String numeroTel, Adresse Adresse, Media Media) {
        this.nom = nom;
        this.mail = mail;
        this.numeroTel = numeroTel;
        this.Adresse = Adresse;
        this.Media = Media;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Annonceur other = (Annonceur) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.Adresse, other.Adresse)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (this.numeroTel != other.numeroTel) {
            return false;
        }
        
        return true;
    }
}

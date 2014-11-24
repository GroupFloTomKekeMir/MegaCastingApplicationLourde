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
public class Media {
    private int id;
    private String nom;
    private int taille;
    private TypeMedia TypeMedia;

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

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public TypeMedia getTypeMedia() {
        return TypeMedia;
    }

    public void setTypeMedia(TypeMedia TypeMedia) {
        this.TypeMedia = TypeMedia;
    }

    public Media(String nom, int taille, TypeMedia TypeMedia) {
        this.nom = nom;
        this.taille = taille;
        this.TypeMedia = TypeMedia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Media other = (Media) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (this.taille != other.taille) {
            return false;
        }
        if (!Objects.equals(this.TypeMedia, other.TypeMedia)) {
            return false;
        }
        return true;
    }
}

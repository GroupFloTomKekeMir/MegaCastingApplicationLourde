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
public class Metier {
    private int id;
    private String libelle;
    private Domaine Domaine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Domaine getDomaine() {
        return Domaine;
    }

    public void setDomaine(Domaine Domaine) {
        this.Domaine = Domaine;
    }

    public Metier(String libelle, Domaine Domaine) {
        this.libelle = libelle;
        this.Domaine = Domaine;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Metier other = (Metier) obj;
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (!Objects.equals(this.Domaine, other.Domaine)) {
            return false;
        }
        return true;
    }
    
    
}

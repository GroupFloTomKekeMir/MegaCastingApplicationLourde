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
public class Offre {
    private int id;
    private String titre;
    private String reference;
    private Date date_debut_publi;
    private Date fin_publi;
    private int nbr_poste;
    private String description_poste;
    private String description_profil;
    private int telephone;
    private int duree;
    private Contrat Contrat;
    private Annonceur Annonceur;
    private Diffuseur Diffuseur;
    private Metier Metier;

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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDate_debut_publi() {
        return date_debut_publi;
    }

    public void setDate_debut_publi(Date date_debut_publi) {
        this.date_debut_publi = date_debut_publi;
    }

    public Date getFin_publi() {
        return fin_publi;
    }

    public void setFin_publi(Date fin_publi) {
        this.fin_publi = fin_publi;
    }

    public int getNbr_poste() {
        return nbr_poste;
    }

    public void setNbr_poste(int nbr_poste) {
        this.nbr_poste = nbr_poste;
    }

    public String getDescription_poste() {
        return description_poste;
    }

    public void setDescription_poste(String description_poste) {
        this.description_poste = description_poste;
    }

    public String getDescription_profil() {
        return description_profil;
    }

    public void setDescription_profil(String description_profil) {
        this.description_profil = description_profil;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Contrat getContrat() {
        return Contrat;
    }

    public void setContrat(Contrat Contrat) {
        this.Contrat = Contrat;
    }

    public Annonceur getAnnonceur() {
        return Annonceur;
    }

    public void setAnnonceur(Annonceur Annonceur) {
        this.Annonceur = Annonceur;
    }

    public Diffuseur getDiffuseur() {
        return Diffuseur;
    }

    public void setDiffuseur(Diffuseur Diffuseur) {
        this.Diffuseur = Diffuseur;
    }

    public Metier getMetier() {
        return Metier;
    }

    public void setMetier(Metier Metier) {
        this.Metier = Metier;
    }

    public Offre(String titre, String reference, Date date_debut_publi, Date fin_publi, int nbr_poste, String description_poste, String description_profil, int telephone, Contrat Contrat, Annonceur Annonceur, Diffuseur Diffuseur, Metier Metier) {
        this.titre = titre;
        this.reference = reference;
        this.date_debut_publi = date_debut_publi;
        this.fin_publi = fin_publi;
        this.nbr_poste = nbr_poste;
        this.description_poste = description_poste;
        this.description_profil = description_profil;
        this.telephone = telephone;
        this.Contrat = Contrat;
        this.Annonceur = Annonceur;
        this.Diffuseur = Diffuseur;
        this.Metier = Metier;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Offre other = (Offre) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.reference, other.reference)) {
            return false;
        }
        if (!Objects.equals(this.date_debut_publi, other.date_debut_publi)) {
            return false;
        }
        if (!Objects.equals(this.fin_publi, other.fin_publi)) {
            return false;
        }
        if (this.nbr_poste != other.nbr_poste) {
            return false;
        }
        if (!Objects.equals(this.description_poste, other.description_poste)) {
            return false;
        }
        if (!Objects.equals(this.description_profil, other.description_profil)) {
            return false;
        }
        if (this.telephone != other.telephone) {
            return false;
        }
        if (!Objects.equals(this.Contrat, other.Contrat)) {
            return false;
        }
        if (!Objects.equals(this.Annonceur, other.Annonceur)) {
            return false;
        }
        if (!Objects.equals(this.Diffuseur, other.Diffuseur)) {
            return false;
        }
        if (!Objects.equals(this.Metier, other.Metier)) {
            return false;
        }
        return true;
    } 
}

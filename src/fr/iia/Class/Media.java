/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.Class;

/**
 *
 * @author Enzo
 */
public class Media {
    private int id;
    private String nom;
    private int taille;
    private Offre Offre;
    private Utilisateur Utilisateur;
    private TypeMedia TypeMedia;
    private Annonceur Annonceur;
    private Musique Musique;
    private Evenement Evenement;

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

    public Offre getOffre() {
        return Offre;
    }

    public void setOffre(Offre Offre) {
        this.Offre = Offre;
    }

    public Utilisateur getUtilisateur() {
        return Utilisateur;
    }

    public void setUtilisateur(Utilisateur Utilisateur) {
        this.Utilisateur = Utilisateur;
    }

    public TypeMedia getTypeMedia() {
        return TypeMedia;
    }

    public void setTypeMedia(TypeMedia TypeMedia) {
        this.TypeMedia = TypeMedia;
    }

    public Annonceur getAnnonceur() {
        return Annonceur;
    }

    public void setAnnonceur(Annonceur Annonceur) {
        this.Annonceur = Annonceur;
    }

    public Musique getMusique() {
        return Musique;
    }

    public void setMusique(Musique Musique) {
        this.Musique = Musique;
    }

    public Evenement getEvenement() {
        return Evenement;
    }

    public void setEvenement(Evenement Evenement) {
        this.Evenement = Evenement;
    }

    public Media(String nom, int taille, Offre Offre, Utilisateur Utilisateur, TypeMedia TypeMedia, Annonceur Annonceur, Musique Musique, Evenement Evenement) {
        this.nom = nom;
        this.taille = taille;
        this.Offre = Offre;
        this.Utilisateur = Utilisateur;
        this.TypeMedia = TypeMedia;
        this.Annonceur = Annonceur;
        this.Musique = Musique;
        this.Evenement = Evenement;
    }
}

package fr.iia.Class;

import java.util.Objects;


public class Adresse {

    private int id;
    private int numero;
    private int codePostal;
    private String rue;
    private String ville;
    private String localisation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Adresse(int numero, int codePostal, String rue, String ville, String localisation) {
        this.numero = numero;
        this.codePostal = codePostal;
        this.rue = rue;
        this.ville = ville;
        this.localisation = localisation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adresse other = (Adresse) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.codePostal != other.codePostal) {
            return false;
        }
        if (!Objects.equals(this.rue, other.rue)) {
            return false;
        }
        if (!Objects.equals(this.ville, other.ville)) {
            return false;
        }
        if (!Objects.equals(this.localisation, other.localisation)) {
            return false;
        }
        return true;
    }
}

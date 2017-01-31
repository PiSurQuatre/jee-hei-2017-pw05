package hei.tp05.contract.dto;

public class ClientDTO {
    private String nom;
    private String prenom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String ToString()
    {
        return "Nom: "+this.nom+"\t Prénom: "+this.prenom;
    }
}

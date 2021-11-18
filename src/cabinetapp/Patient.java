
package cabinetapp;

import java.sql.Date;

public class Patient {
   private String ncin;
   private String  nom; 
   private String  prenom;
   private String date_nais;
   private String sexe;
   private String tel;
   private String alergie;
   private String adresse;

    public Patient(String ncin, String nom, String prenom, String date_nais, String sexe, String tel, String alergie,String adresse) {
        this.ncin = ncin;
        this.nom = nom;
        this.prenom = prenom;
        this.date_nais = date_nais;
        this.sexe = sexe;
        this.tel = tel;
        this.alergie = alergie;
        this.adresse=adresse;
    }

    public String getNcin() {
        return ncin;
    }

    public void setNcin(String ncin) {
        this.ncin = ncin;
    }

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

    public String getDate_nais() {
        return date_nais;
    }

    public void setDate_nais(String date_nais) {
        this.date_nais = date_nais;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAlergie() {
        return alergie;
    }

    public void setAlergie(String alergie) {
        this.alergie = alergie;
    }
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = alergie;
    }
  
  
    
}

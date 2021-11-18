/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinetapp;

import java.sql.Date;

/**
 *
 * @author MouNa
 */
public class Consultation {
   private int num_c;
   private Date date_c;
   private String commentaire;
   private String ordonnace;
   private int ncin;

    public int getNum_c() {
        return num_c;
    }

    public void setNum_c(int num_c) {
        this.num_c = num_c;
    }

    public Date getDate_c() {
        return date_c;
    }

    public void setDate_c(Date date_c) {
        this.date_c = date_c;
    }

    

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getOrdonnace() {
        return ordonnace;
    }

    public void setOrdonnace(String ordonnace) {
        this.ordonnace = ordonnace;
    }

    public int getNcin() {
        return ncin;
    }

    public void setNcin(int ncin) {
        this.ncin = ncin;
    }

    public Consultation(Date date_c,String commentaire, String ordonnace) {
       
        this.date_c = date_c;
        this.commentaire = commentaire;
        this.ordonnace = ordonnace;
        
    }
}

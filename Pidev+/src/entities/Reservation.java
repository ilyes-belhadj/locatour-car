/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class Reservation {
    private int idR;
    private Date datedebut;
    private Date datefin;
    private String voiture;
    private String nom;
    private String prenom;
    private String email;
    private int numtel;
     public Reservation(int idR, Date datedebut, Date datefin,String voiture, String nom, String prenom, String email, int numtel) {
        this.idR = idR;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.voiture=voiture;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numtel = numtel;
    }
 public Reservation( Date datedebut, Date datefin,String voiture, String nom,String prenom, String email, int numtel) {
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.voiture =voiture;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numtel = numtel;
    }
    public Reservation() {
        
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

     public String getVoiture() {
        return voiture;
    }

    public void setVoiture(String voiture) {
        this.voiture = voiture;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }
}

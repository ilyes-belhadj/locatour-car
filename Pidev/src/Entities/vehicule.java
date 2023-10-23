/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ahmed
 */
public class vehicule {
    private int id_v;
    private String matricule;
    private String modele;
    private String marque;
    private String couleur;
    private String carburant;
    private String annee;
    private String kilometrage;

    public vehicule(int id_v, String matricule, String modele, String marque, String couleur, String carburant, String annee, String kilometrage) {
        this.id_v = id_v;
        this.matricule = matricule;
        this.modele = modele;
        this.marque = marque;
        this.couleur = couleur;
        this.carburant = carburant;
        this.annee = annee;
        this.kilometrage = kilometrage;
    }

    public vehicule() {
    }

    

    public int getId_v() {
        return id_v;
    }

    public void setId_v(int id_v) {
        this.id_v = id_v;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    
    }
    

    
    
   
    
              
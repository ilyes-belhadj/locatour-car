/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental;

/**
 *
 * @author 21698
 */
public class voiture {
    private int id;
    private int age;
    private String categorie;
    private String etat;
    private String imatriculation;
    private String kilometrage;
    private String marque;
    private String modele;
    private String numVoiture;
    private String validitecart;
    
    
    

    public voiture(int id, int age, String categorie, String etat, String imatriculation, String kilometrage, String marque, String modele, String numVoiture, String validitecart) {
        this.id = id;
        this.age = age;
        this.categorie = categorie;
        this.etat = etat;
        this.imatriculation = imatriculation;
        this.kilometrage = kilometrage;
        this.marque = marque;
        this.modele = modele;
        this.numVoiture = numVoiture;
        this.validitecart = validitecart;
    }

    public voiture(int age, String categorie, String etat, String imatriculation, String kilometrage, String marque, String modele, String numVoiture, String validitecart) {
        this.age = age;
        this.categorie = categorie;
        this.etat = etat;
        this.imatriculation = imatriculation;
        this.kilometrage = kilometrage;
        this.marque = marque;
        this.modele = modele;
        this.numVoiture = numVoiture;
        this.validitecart = validitecart;
    }
    

   
    

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getEtat() {
        return etat;
    }

    public String getImatriculation() {
        return imatriculation;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getNumVoiture() {
        return numVoiture;
    }

    public String getValiditecart() {
        return validitecart;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setImatriculation(String imatriculation) {
        this.imatriculation = imatriculation;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setNumVoiture(String numVoiture) {
        this.numVoiture = numVoiture;
    }

    public void setValiditecart(String validitecart) {
        this.validitecart = validitecart;
    }

    @Override
    public String toString() {
        return "voiture{" + "id=" + id + ", age=" + age + ", categorie=" + categorie + ", etat=" + etat + ", imatriculation=" + imatriculation + ", kilometrage=" + kilometrage + ", marque=" + marque + ", modele=" + modele + ", numVoiture=" + numVoiture + ", validitecart=" + validitecart + '}';
    }
    
    
}

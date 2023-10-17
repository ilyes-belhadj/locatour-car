/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Asus
 */
public class Avis {
    private int id;
    private int rating;
    private String nom;
     private String url_image;
    private String commentaire;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire= commentaire;
    }

    
    

    

    public Avis() {
    }

    public Avis(int id, int rating, String nom, String url_image, String commentaire) {
        this.id = id;
        this.rating = rating;
        this.nom = nom;
        this.url_image = url_image;
        this.commentaire=commentaire;
    }
    
      public Avis( int rating, String nom, String url_image, String commentaire) {
        this.rating = rating;
        this.nom = nom;
        this.url_image = url_image;
        this.commentaire=commentaire;
    }
    
    
    

}

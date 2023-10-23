/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author ahmed
 */
public class marketplace {
    private int id;
    private int id_v;
    private String description;
    private String prix_vente;
    private Date date_vente;
    private String image;

    public marketplace(int id, int id_v, String description, String prix_vente, Date date_vente, String image) {
        this.id = id;
        this.id_v = id_v;
        this.description = description;
        this.prix_vente = prix_vente;
        this.date_vente = date_vente;
        this.image = image;
    }

    public marketplace(int id_v, String description, String prix_vente, Date date_vente, String image) {
        this.id_v = id_v;
        this.description = description;
        this.prix_vente = prix_vente;
        this.date_vente = date_vente;
        this.image = image;
    }

    public marketplace() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_v() {
        return id_v;
    }

    public void setId_v(int id_v) {
        this.id_v = id_v;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(String prix_vente) {
        this.prix_vente = prix_vente;
    }

    public Date getDate_vente() {
        return date_vente;
    }

    public void setDate_vente(Date date_vente) {
        this.date_vente = date_vente;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "marketplace{" + "id=" + id + ", id_v=" + id_v + ", description=" + description + ", prix_vente=" + prix_vente + ", date_vente=" + date_vente + ", image=" + image + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final marketplace other = (marketplace) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
    

   
   
}


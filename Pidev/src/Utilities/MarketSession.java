/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Entities.vehicule;
import java.util.Date;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
/**
 *
 * @author ahmed
 */
public class MarketSession {
    private static MarketSession instance;
    private static String description,prix_vente;
    private static int id,id_v;
    private static Date date_vente;
    private static String image;

    public MarketSession(int id, int id_v, String description, String prix_vente, Date date_vente, String image) {
        this.id = id;
        this.id_v = id_v;
        this.description = description;
        this.prix_vente = prix_vente;
        this.date_vente = date_vente;
        this.image = image;
    }
    public static synchronized MarketSession getInstance(int id, int id_v, String description, String prix_vente, Date date_vente, String image) {
        if (instance == null) {
            instance = new MarketSession(id,id_v,description,prix_vente,date_vente,image);
        }
        return instance;
    }
    public static MarketSession EndSession(){
    instance =null;
    return instance;
    }
    public static MarketSession getInstance() {
        return instance;
    }
    public static void setInstance(MarketSession instance) {
        MarketSession.instance = instance;
    }
    
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        MarketSession.id = id;
    }

    public static int getId_v() {
        return id_v;
    }

    public static void setVehicule(int id_v) {
        MarketSession.id_v = id_v;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        MarketSession.description = description;
    }

    public static String getPrix_vente() {
        return prix_vente;
    }

    public static void setPrix_vente(String prix_vente) {
        MarketSession.prix_vente = prix_vente;
    }

    public static Date getDate_vente() {
        return date_vente;
    }

    public static void setDate_vente(Date date_vente) {
        MarketSession.date_vente = date_vente;
    }


    public static String getImage() {
        return image;
    }

   public static void setImage(String image) {
        MarketSession.image = image;
    }
    
}

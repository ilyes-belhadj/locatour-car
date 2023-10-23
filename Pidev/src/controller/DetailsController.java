/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Entities.marketplace;

import Entities.marketplace;
import gui.myListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Utilities.MarketSession;
/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class DetailsController implements Initializable {
     @FXML
    private Button R;

    @FXML
    private ImageView imgprofile;

    @FXML
    private Label marque;

    @FXML
    private Label modele;

    @FXML
    private Label annee;

    @FXML
    private Label Carburant;

    @FXML
    private Label Couleur;

    @FXML
    private Label Kilometrage;

    @FXML
    private Label Description;

    @FXML
    private Label Prix;

    @FXML
    private Button mod;

    @FXML
    private Button sup;
    
    
    private myListener myListener;
    private marketplace m;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    /**
     * Initializes the controller class.
     */
   /* @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* marque.setText(MarketSession.getVehicule().getMarque());
        modele.serText(MarketSession.getVehicule().getModele());
        
    } 
    public void setData(marketplace m, myListener myListener) {
        this.m = m;
        this.myListener = myListener;
}
    @FXML
    void Modifier(ActionEvent event) {

    }

    @FXML
    void Retour(ActionEvent event) {

    }

    @FXML
    void Supprimer(ActionEvent event) {

    }
    */


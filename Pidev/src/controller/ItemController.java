/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entities.marketplace;
import Services.vehiculeservice;
import Utilities.MarketSession;
import gui.myListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
 * FXML Controller class
 *
 * @author ahmed
 */

public class ItemController implements Initializable {
    
    private Stage primaryStage;
    private myListener myListener;
    private marketplace m;
    
    
    @FXML
    private ImageView imgvoiture;

    @FXML
    private Label marqueLabel;

    @FXML
    private Label modeleLabel;

    @FXML
    private Label prixLabel;

    @FXML
    private Button P;

   vehiculeservice vs= new vehiculeservice();
    
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
  
    public void setData(marketplace m, myListener myListener) {
        this.m = m;
        this.myListener = myListener;
         marqueLabel.setText(m.getDescription());
        modeleLabel.setText(m.getDescription());
        prixLabel.setText(m.getDescription()); 
        Image newImage = new Image(m.getImage());
        imgvoiture.setImage(newImage);
    }
    
    @FXML
    void Details(ActionEvent event) throws IOException {
        MarketSession K = new MarketSession(m.getId(),m.getId_v(),m.getDescription(),m.getPrix_vente(),m.getDate_vente(),m.getImage());
         System.out.println(MarketSession.getId());
            Parent root = FXMLLoader.load(getClass().getResource("../gui/Details.fxml"));            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    
}

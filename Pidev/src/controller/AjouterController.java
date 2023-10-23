/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entities.marketplace;
import Entities.vehicule;
import Services.marketplaceservice;
import Services.vehiculeservice;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AjouterController implements Initializable {

    @FXML
    private ComboBox matriculeComboBox;
    @FXML
    private TextArea champDescription;
    @FXML
    private TextField champPrixVente;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ImageView imagePreview;
    private Stage primaryStage;

     marketplaceservice fs = new marketplaceservice();
     marketplace f= new marketplace();   
     vehiculeservice vs =new vehiculeservice();
     vehicule v = new vehicule();
    
    /**
     * Initializes the controller class.
     * @param primaryStage
     */
        public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list;
        list = FXCollections.observableList(importMat());
        matriculeComboBox.setItems(list);
    
    }    
    private List importMat(){
    vehiculeservice vs = new vehiculeservice();
    List<vehicule> L;
        L = vs.affichervehicule();
    List<String> matricules = new ArrayList<>();
    for (vehicule v : L) {
     matricules.add(v.getMatricule());
    }
    return matricules;
    }
    @FXML
    private void parcourirPhoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
    );
    File selectedFile = fileChooser.showOpenDialog(primaryStage);
    
    if (selectedFile != null) {
        // Ici, nous mettons le chemin du fichier sélectionné dans une variable
        String selectedImagePath = selectedFile.toURI().toString();
        
        //afficher l'image dans un ImageView si vous le souhaitez
        Image image = new Image(selectedImagePath);
        imagePreview.setImage(image);
        
        //attribuer le chemin du fichier à l'objet marketplace f
        f.setImage(selectedImagePath);
    }
    }
      

    @FXML
    private void ajoutervehicule(ActionEvent event) {
        //String s="";
        // int k;
        //s=(String) matriculeComboBox.getValue();
        // v=vs.getVehiculeParMat(s);
        //f.setId_v(v.getId_v());
        
        String matricule = (String) matriculeComboBox.getValue();
        vehicule vehicule = vs.getVehiculeParMat(matricule);
        f.setId_v(vehicule.getId_v());
        f.setDescription(champDescription.getText());
        f.setPrix_vente(champPrixVente.getText());
        LocalDate ddl = datePicker.getValue();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date ddd = Date.from(ddl.atStartOfDay(defaultZoneId).toInstant());
        f.setDate_vente(ddd);
        
        fs.ajouter(f);
                       

        Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
        confirmation.setContentText(" voiture est ajouté avec succes");
        confirmation.show();
          
                }

   

    

    @FXML
    private void Select(ActionEvent event) {
        String s = matriculeComboBox.getSelectionModel().getSelectedItem().toString();
      
}
    
    
}
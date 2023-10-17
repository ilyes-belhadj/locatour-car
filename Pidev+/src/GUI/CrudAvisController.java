/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import Services.ServiceAvis;
import entities.Avis;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CrudAvisController implements Initializable {

    @FXML
    private ComboBox<Integer> cb_rating;
    @FXML
    private TextField et_nom;
    @FXML
    private TextArea et_comment;
    @FXML
    private Button btn_add;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private TableView<Avis> table;
    @FXML
    private TableColumn<Avis, Integer> col_id;
    @FXML
    private TableColumn<Avis, String> col_nom;
    @FXML
    private TableColumn<Avis, Integer> col_rating;
    @FXML
    private TableColumn<Avis, String> col_commentaire;
    @FXML
    private Button btnback;

    ObservableList<Avis> avislist = FXCollections.observableArrayList();
    
    ServiceAvis sa = new ServiceAvis();

    public String msgError = "Veuillez remplir tous les champs correctement !";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        for (int i = 1; i <= 5; i++) {
            cb_rating.getItems().add(i);
        }
        cb_rating.getSelectionModel().select(0);

        btnEdit.setDisable(true);
        btnDelete.setDisable(true);

        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Avis>() {
            @Override
            public void changed(ObservableValue<? extends Avis> observable, Avis oldValue, Avis newValue) {
                if (newValue != null) {
                    btnEdit.setDisable(false);
                    btnDelete.setDisable(false);

                    setDataIntoFields(newValue);

                    deleteAvis();
                    editReservation();

                } else {
                    btnEdit.setDisable(true);
                    btnDelete.setDisable(true);
                }
            }

        });

        showAvis();

        btnback.setOnMouseClicked((t) -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CrudReservation.fxml"));
            try {
                Parent root = loader.load();
                table.getScene().setRoot(root);
            } catch (IOException e) {
            }
        });
    }

    private void setDataIntoFields(Avis v) {
        et_nom.setText(v.getNom());
        et_comment.setText(v.getCommentaire());
        cb_rating.setValue(v.getRating());

    }

    private void showAvis() {
        avislist = FXCollections.observableArrayList(sa.listerAvis());
        table.setItems(avislist);
        col_id.setCellValueFactory(new PropertyValueFactory<Avis, Integer>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Avis, String>("nom"));
        col_rating.setCellValueFactory(new PropertyValueFactory<Avis, Integer>("rating"));
        col_commentaire.setCellValueFactory(new PropertyValueFactory<Avis, String>("commentaire"));

    }

    @FXML
    private void addAvis(ActionEvent event) {

        String nom = et_nom.getText();
        String commentaire = et_comment.getText();
        int rating = cb_rating.getValue();

        if (!isValidNom(nom)
                || !isValidCommentaire(commentaire)) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(msgError);
            alert.showAndWait();
        } else {
            Avis avis = new Avis();

            avis.setNom(nom);
            avis.setCommentaire(commentaire);
            avis.setRating(rating);

            if (sa.ajouterAvis(avis)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Avis a été ajouté");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) // alert is exited, no button has been pressed.
                {
                    showAvis();

                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Avis n'a pas été ajouté");
                alert.showAndWait();
            }

        }
    }

    private void deleteAvis() {
        btnDelete.setOnMouseClicked((MouseEvent event) -> {
            //alert
            Avis selectedAvis = table.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Supprimer l'avis");
            alert.setHeaderText(null);
            alert.setContentText("Etes vous sur de vouloir supprimer l'avis " + selectedAvis.getId() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) // alert is exited, no button has been pressed.
            {

                if (sa.SupprimerAvis(selectedAvis.getId())) {
                    Alert alerts = new Alert(Alert.AlertType.INFORMATION);
                    alerts.initStyle(StageStyle.UTILITY);
                    alerts.setTitle("Success");
                    alerts.setHeaderText(null);
                    alerts.setContentText("L'avis " + selectedAvis.getId() + " a été supprimé");
                    alerts.showAndWait();
                    et_nom.setText(null);
                    et_comment.setText(null);
                    et_nom.setText(null);
                    cb_rating.setValue(1);
                    showAvis();
                } else {
                    Alert alertz = new Alert(Alert.AlertType.ERROR);
                    alertz.initStyle(StageStyle.UTILITY);
                    alertz.setTitle("Error");
                    alertz.setHeaderText(null);
                    alertz.setContentText("L'avis n'a pas été supprimé");
                    alertz.showAndWait();
                }

            }
        });
    }

    private void editReservation() {
        msgError = "Veuillez remplir tous les champs correctement !";
        btnEdit.setOnMouseClicked((MouseEvent event) -> {
            Avis selectedAvis = table.getSelectionModel().getSelectedItem();            //alert
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Modifier la reservation");
            alert.setHeaderText(null);
            alert.setContentText("Etes vous sur de vouloir modifier l'avis " + selectedAvis.getId()+ " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) // alert is exited, no button has been pressed.
            {
                String nom = et_nom.getText();
                String comentiare = et_comment.getText();
                int rating = cb_rating.getValue();
             

                if (!isValidNom(nom)
                        || !isValidCommentaire(comentiare)) {

                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.initStyle(StageStyle.UTILITY);
                    alert1.setTitle("Error");
                    alert1.setHeaderText(null);
                    alert1.setContentText(msgError);
                    alert1.showAndWait();
                } else {
                    Avis avis = new Avis();

                    avis.setNom(nom);
                    avis.setCommentaire(comentiare);
                    avis.setRating(rating);
                    

                    if (sa.modifierAvis(avis, selectedAvis.getId())) {
                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.initStyle(StageStyle.UTILITY);
                        alert2.setTitle("Success");
                        alert2.setHeaderText(null);
                        alert2.setContentText("Avis a été modifié");
                        Optional<ButtonType> result1 = alert2.showAndWait();
                        if (result1.get() == ButtonType.OK) // alert is exited, no button has been pressed.
                        {
                            et_nom.setText(null);
                            et_comment.setText(null);
                            cb_rating.setValue(1);
                           

                        }
                        showAvis();
                    } else {
                        Alert alert3 = new Alert(Alert.AlertType.ERROR);
                        alert3.initStyle(StageStyle.UTILITY);
                        alert3.setTitle("Error");
                        alert3.setHeaderText(null);
                        alert3.setContentText("Avis n'a pas été modifié");
                        alert3.showAndWait();
                    }

                }

            }
        }
        );
    }

    ;
     public boolean isValidNom(String str) {
        if (str == null || str.isEmpty()) {
            msgError = "Nom Invalide";
            return false;
        } else {
            return true;
        }

    }

    public boolean isValidCommentaire(String str) {
        if (str == null || str.isEmpty()) {
            msgError = "Commentaire Invalide";
            return false;
        } else {
            return true;
        }

    }

}

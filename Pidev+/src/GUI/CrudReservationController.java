/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import Services.ServiceReservation;
import entities.Reservation;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author َAsus
 */
public class CrudReservationController implements Initializable {

    @FXML
    private Button btn_ajouter;
    @FXML
    private TextField et_nom;
    @FXML
    private TextField et_prenom;
    @FXML
    private TextField et_email;
    @FXML
    private TextField et_numero;
    @FXML
    private DatePicker dp_debut;
    @FXML
    private DatePicker dp_fin;
    @FXML
    private TableColumn<Reservation, String> col_date_debut;
    @FXML
    private TableColumn<Reservation, String> col_date_fin;
    @FXML
    private TableColumn<Reservation, String> col_nom;
    @FXML
    private TableColumn<Reservation, String> col_prenom;
    @FXML
    private TableColumn<Reservation, String> col_email;
    @FXML
    private TableColumn<Reservation, Integer> col_numero;
    @FXML
    private TableView<Reservation> table;
    @FXML
    private TableColumn<Reservation, Integer> col_idR;

    ObservableList<Reservation> reservationlist = FXCollections.observableArrayList();
    ServiceReservation sr = new ServiceReservation();

    public String msgError = "Veuillez remplir tous les champs correctement !";
    @FXML
    private Button btn_edit;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btnAvis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        showReservations();

        btn_edit.setDisable(true);
        btn_delete.setDisable(true);
        
        btnAvis.setOnMouseClicked((t) -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CrudAvis.fxml"));
        try {
            Parent root = loader.load();
            table.getScene().setRoot(root);
        } catch (IOException e) {
        }
        });
        
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Reservation>() {
            @Override
            public void changed(ObservableValue<? extends Reservation> observable, Reservation oldValue, Reservation newValue) {
                if (newValue != null) {
                    btn_edit.setDisable(false);
                    btn_delete.setDisable(false);

                    setDataIntoFields(newValue);

                    deleteReservation();
                    editReservation();

                } else {
                    btn_edit.setDisable(true);
                    btn_delete.setDisable(true);
                }
            }

        });
    }

    private void showReservations() {
        reservationlist = FXCollections.observableArrayList(sr.AfficherReservations());
        table.setItems(reservationlist);
        col_idR.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("idR"));
        col_date_debut.setCellValueFactory(new PropertyValueFactory<Reservation, String>("datedebut"));
        col_date_fin.setCellValueFactory(new PropertyValueFactory<Reservation, String>("datefin"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Reservation, String>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<Reservation, String>("prenom"));
        col_email.setCellValueFactory(new PropertyValueFactory<Reservation, String>("email"));
        col_numero.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("numtel"));

    }

    private void setDataIntoFields(Reservation r) {
        dp_debut.setValue(new Date(r.getDatedebut().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        dp_fin.setValue(new Date(r.getDatefin().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        et_nom.setText(r.getNom());
        et_prenom.setText(r.getPrenom());
        et_email.setText(r.getEmail());
        et_numero.setText(r.getNumtel() + "");
    }

    @FXML
    private void deleteReservation() {
        btn_delete.setOnMouseClicked((MouseEvent event) -> {
            //alert
            Reservation selectedReservation = table.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Supprimer la Reservation");
            alert.setHeaderText(null);
            alert.setContentText("Etes vous sur de vouloir supprimer la Reservation " + selectedReservation.getIdR() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) // alert is exited, no button has been pressed.
            {

                if (sr.SupprimerReservation(selectedReservation.getIdR())) {
                    Alert alerts = new Alert(Alert.AlertType.INFORMATION);
                    alerts.initStyle(StageStyle.UTILITY);
                    alerts.setTitle("Success");
                    alerts.setHeaderText(null);
                    alerts.setContentText("La Reservation " + selectedReservation.getIdR() + " a été supprimée");
                    alerts.showAndWait();
                    et_nom.setText(null);
                    et_prenom.setText(null);
                    et_email.setText(null);
                    et_numero.setText(null);
                    dp_debut.setValue(null);
                    dp_fin.setValue(null);
                    showReservations();
                } else {
                    Alert alertz = new Alert(Alert.AlertType.ERROR);
                    alertz.initStyle(StageStyle.UTILITY);
                    alertz.setTitle("Error");
                    alertz.setHeaderText(null);
                    alertz.setContentText("La Reservation n'a pas été supprimée");
                    alertz.showAndWait();
                }

            }
        });
    }

    @FXML
    private void editReservation() {
        msgError = "Veuillez remplir tous les champs correctement !";
        btn_edit.setOnMouseClicked((MouseEvent event) -> {
            Reservation selectedReservation = table.getSelectionModel().getSelectedItem();
            //alert
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Modifier la reservation");
            alert.setHeaderText(null);
            alert.setContentText("Etes vous sur de vouloir modifier la reservation " + selectedReservation.getIdR() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) // alert is exited, no button has been pressed.
            {
                String nom = et_nom.getText();
                String prenom = et_prenom.getText();
                String email = et_email.getText();
                String numero = et_numero.getText();
                LocalDate datedebut = dp_debut.getValue();
                LocalDate datefin = dp_fin.getValue();

                if (!isValidDates(datedebut, datefin)
                        || !isValidNom(nom)
                        || !isValidPrenom(prenom)
                        || !isValidEmail(email)
                        || !isValidPhone(numero)) {

                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.initStyle(StageStyle.UTILITY);
                    alert1.setTitle("Error");
                    alert1.setHeaderText(null);
                    alert1.setContentText(msgError);
                    alert1.showAndWait();
                } else {
                    Reservation res = new Reservation();

                    res.setDatedebut(java.sql.Date.valueOf(datedebut));
                    res.setDatefin(java.sql.Date.valueOf(datefin));
                    res.setEmail(email);
                    res.setNom(nom);
                    res.setPrenom(prenom);
                    res.setNumtel(Integer.parseInt(numero));

                    if (sr.modifierReservation(res, selectedReservation.getIdR())) {
                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.initStyle(StageStyle.UTILITY);
                        alert2.setTitle("Success");
                        alert2.setHeaderText(null);
                        alert2.setContentText("Reservation a été modifiée");
                        Optional<ButtonType> result1 = alert2.showAndWait();
                        if (result1.get() == ButtonType.OK) // alert is exited, no button has been pressed.
                        {
                            et_nom.setText(null);
                            et_prenom.setText(null);
                            et_email.setText(null);
                            et_numero.setText(null);
                            dp_debut.setValue(null);
                            dp_fin.setValue(null);
                            showReservations();

                        }
                    } else {
                        Alert alert3 = new Alert(Alert.AlertType.ERROR);
                        alert3.initStyle(StageStyle.UTILITY);
                        alert3.setTitle("Error");
                        alert3.setHeaderText(null);
                        alert3.setContentText("Reservation n'a pas été modifiée");
                        alert3.showAndWait();
                    }

                }

            }
        }
        );
    }

    ;

    @FXML
    private void addReservation(ActionEvent event) {

        String nom = et_nom.getText();
        String prenom = et_prenom.getText();
        String email = et_email.getText();
        String numero = et_numero.getText();
        LocalDate datedebut = dp_debut.getValue();
        LocalDate datefin = dp_fin.getValue();

        if (!isValidDates(datedebut, datefin)
                || !isValidNom(nom)
                || !isValidPrenom(prenom)
                || !isValidEmail(email)
                || !isValidPhone(numero)) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(msgError);
            alert.showAndWait();
        } else {
            Reservation res = new Reservation();

            res.setDatedebut(java.sql.Date.valueOf(datedebut));
            res.setDatefin(java.sql.Date.valueOf(datefin));
            res.setEmail(email);
            res.setNom(nom);
            res.setPrenom(prenom);
            res.setNumtel(Integer.parseInt(numero));

            if (sr.ajouter(res)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Reservation a été ajoutée");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) // alert is exited, no button has been pressed.
                {
                    showReservations();

                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Reservation n'a pas été ajoutée");
                alert.showAndWait();
            }

        }
    }

    public boolean isValidNom(String str) {
        if (str == null || str.isEmpty()) {
            msgError = "Nom Invalide";
            return false;
        } else {
            return true;
        }

    }

    public boolean isValidPrenom(String str) {
        if (str == null || str.isEmpty()) {
            msgError = "Prenom Invalide";
            return false;
        } else {
            return true;
        }

    }

    public boolean isValidEmail(String email) {
        // Regular expression for  email 
        String regex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            msgError = "Email Invalide";
            return false;
        }
    }

    public boolean isValidPhone(String input) {
        if (input == null || input.length() != 8) {
            msgError = "Le telephone  doit contenir 8 chiffres";
            return false; 
        }

        char firstChar = input.charAt(0); 

        
        if (firstChar != '2' && firstChar != '5' && firstChar != '9') {
            msgError = "Le telephone  doit commencer par 2 - 5 - 9";
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidDates(LocalDate datedebut, LocalDate datefin) {

        if (datedebut == null || datefin == null) {
            return false;
        } else {
            Date date1 = java.sql.Date.valueOf(datedebut);
            Date date2 = java.sql.Date.valueOf(datefin);

            int comparisonResult = date1.compareTo(date2);

            if (comparisonResult < 0) {
             
                return true;
            } else {
                msgError = "La date de debut doit etre < a la date de fin";
                return false;
            }
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author 21698
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txt_age;
    @FXML
    private TextField txt_imatriculation;
    @FXML
    private TextField txt_etat;
    @FXML
    private ComboBox<?> combo_categorie;
    @FXML
    private TextField txt_kilometrage;
    @FXML
    private TextField txt_marque;
    @FXML
    private TextField txt_modele;
    @FXML
    private TextField txt_numVoiture;
    @FXML
    private TextField txt_validitecarte;

    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_modifier;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_clear;
    @FXML
    private TableView<voiture> table_voiture;
    @FXML
    private TableColumn<voiture, Integer> col_age;
    @FXML
    private TableColumn<voiture, String> col_categorie;
    @FXML
    private TableColumn<voiture, String> col_etat;
    @FXML
    private TableColumn<voiture, String> col_imatriculation;
    @FXML
    private TableColumn<voiture, String> col_kilometrage;
    @FXML
    private TableColumn<voiture, String> col_marque;
    @FXML
    private TableColumn<voiture, String> col_modele;
    @FXML
    private TableColumn<voiture, String> col_numvoiture;
    @FXML
    private TableColumn<voiture, String> col_validitecarte;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Alert alert;
    private String[] categorieList = {"A ", "B", "C", "D"};
    @FXML
    private Button btn_afficher;

    public void voitureCategorieList() {
        List<String> yList = new ArrayList<>();

        for (String data : categorieList) {
            yList.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(yList);
        combo_categorie.setItems(listData);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        voitureCategorieList();
        // TODO
    }

    @FXML
    private void btn_ajouter(ActionEvent event) {
        connect = database.connect();

        try {

            if (txt_age.getText().isEmpty()
                    || txt_imatriculation.getText().isEmpty()
                    || combo_categorie.getSelectionModel().getSelectedItem() == null
                    || txt_kilometrage.getText().isEmpty()
                    || txt_marque.getText().isEmpty()
                    || txt_modele.getText().isEmpty()
                    || txt_numVoiture.getText().isEmpty()
                    || txt_validitecarte.getText().isEmpty()
                    || txt_etat.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {

                String checkData = "SELECT * FROM voiture WHERE age = "
                        + txt_age.getText();
                prepare = connect.prepareStatement(checkData);
                result = prepare.executeQuery();

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("Student number : " + txt_age.getText() + "is alredy taken");
                    alert.showAndWait();
                } else {
                    String insertData = "INSERT INTO voiture (age,categorie,etat,imatriculation,kilometrage,marque,modele,numVoiture,validitecarte)"
                            + "VALUES (?,?,?,?,?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);

                    prepare.setString(1, txt_age.getText());
                    prepare.setString(2, (String) combo_categorie.getSelectionModel().getSelectedItem());
                    prepare.setString(3, txt_etat.getText());

                    prepare.setString(4, txt_imatriculation.getText());
                    prepare.setString(5, txt_kilometrage.getText());
                    prepare.setString(6, txt_marque.getText());
                    prepare.setString(7, txt_modele.getText());
                    prepare.setString(8, txt_numVoiture.getText());
                    prepare.setString(9, txt_validitecarte.getText());

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMATION MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("Succfully added");
                    alert.showAndWait();

                    prepare.executeUpdate();
                    // to update the table view
                    voitureShowData();
                    // to clear the fields
                    btn_clear();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private ObservableList<voiture> voiture;

    public ObservableList<voiture> voitureListData() {

        ObservableList<voiture> listData = FXCollections.observableArrayList();

        String selectData = "SELECT * FROM voiture";
        connect = database.connect();

        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();
            voiture sData;

            while (result.next()) {

                sData = new voiture(result.getInt("age"), result.getString("categorie"),
                        result.getString("etat"), result.getString("imatriculation"), result.getString("kilometrage"),
                        result.getString("marque"), result.getString("modele"), result.getString("numVoiture"), result.getString("validitecarte"));
                listData.add(sData);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void voitureShowData() {

        voiture = voitureListData();

        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        col_categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        col_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        col_imatriculation.setCellValueFactory(new PropertyValueFactory<>("imatriculation"));
        col_kilometrage.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        col_marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        col_modele.setCellValueFactory(new PropertyValueFactory<>("modele"));
        col_numvoiture.setCellValueFactory(new PropertyValueFactory<>("numVoiture"));
        col_validitecarte.setCellValueFactory(new PropertyValueFactory<>("validitecarte"));

        table_voiture.setItems(voiture);

    }

    @FXML
    private void btn_modifier(ActionEvent event) {
        connect = database.connect();
        try {

            if (txt_age.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRMATION MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE student Number :"
                        + txt_age.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    String updateData = "UPDATE voiture SET "
                            + "etat = '" + txt_etat.getText() + "'"
                            + "',categorie = '" + combo_categorie.getSelectionModel().getSelectedItem()
                            + "etat = '" + txt_etat.getText()
                            + "imatriculation = '" + txt_imatriculation.getText()
                            + "kilometrage = '" + txt_kilometrage.getText()
                            + "marque = '" + txt_marque.getText()
                            + "modele = '" + txt_modele.getText()
                            + "numVoiture = '" + txt_numVoiture.getText()
                            + "validitecarte = '" + txt_validitecarte.getText()
                            
                            
                            
                            
                            
                            
                            + "'WHERE age = " + txt_age.getText();

                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMATION MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("succfully Updated");
                    alert.showAndWait();

                    // to update the table view
                    voitureShowData();
                    // to clear the fields
                    btn_clear();

                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled.");
                    alert.showAndWait();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
     @FXML
    public void voitureSelectData(ActionEvent event) {

        voiture sData = table_voiture.getSelectionModel().getSelectedItem();

        int num = table_voiture.getSelectionModel().getFocusedIndex();

        if ((num - 1) < -1) {
            return;
        }

        txt_age.setText(String.valueOf(sData.getAge()));
        

    }

    @FXML
    private void btn_delete(ActionEvent event) {
        connect = database.connect();

        try {

            if (txt_age.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRMATION MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE student Number :"
                        + txt_age.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    String deleteData = "DELETE FROM voiture WHERE age = "
                            + txt_age.getText();

                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMATION MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("succfully deleted");
                    alert.showAndWait();

                    // to update the table view
                    voitureShowData();
                    // to clear the fields
                    btn_clear();

                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled.");
                    alert.showAndWait();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void btn_clear() {

        txt_age.setText("");
        txt_etat.setText("");
        txt_kilometrage.setText("");
        txt_marque.setText("");
        txt_modele.setText("");
        txt_numVoiture.setText("");
        txt_validitecarte.setText("");
        txt_imatriculation.setText("");
        combo_categorie.getSelectionModel().clearSelection();

    }

    private void btn_clear(ActionEvent event) {

        txt_age.setText("");
        txt_etat.setText("");
        txt_kilometrage.setText("");
        txt_marque.setText("");
        txt_modele.setText("");
        txt_numVoiture.setText("");
        txt_validitecarte.setText("");
        txt_imatriculation.setText("");
        combo_categorie.getSelectionModel().clearSelection();

    }

    @FXML
    private void btn_afficher(ActionEvent event) {
        voiture = voitureListData();

        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        col_categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        col_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        col_imatriculation.setCellValueFactory(new PropertyValueFactory<>("imatriculation"));
        col_kilometrage.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        col_marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        col_modele.setCellValueFactory(new PropertyValueFactory<>("modele"));
        col_numvoiture.setCellValueFactory(new PropertyValueFactory<>("numVoiture"));
        col_validitecarte.setCellValueFactory(new PropertyValueFactory<>("validitecarte"));

        table_voiture.setItems(voiture);
    }

  

}

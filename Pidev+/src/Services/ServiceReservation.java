/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import entities.Reservation;
import Utils.Myconnection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Asus
 */
public class ServiceReservation implements Ireservation<Reservation> {

    Connection cnx;

    public ServiceReservation() {
        this.cnx = Myconnection.getInstance().getCnx();
    }

    @Override
    public boolean ajouter(Reservation r) {
        boolean res = false;
        try {
            String req = "INSERT INTO Reservation (idR, datedebut, datefin, nom, prenom, email, numtel) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = Myconnection.getInstance().getCnx().prepareStatement(req);
            preparedStatement.setInt(1, r.getIdR());
            preparedStatement.setDate(2, new java.sql.Date(r.getDatedebut().getTime())); // Assuming r.getDatedebut() returns a LocalDate
            preparedStatement.setDate(3, new java.sql.Date(r.getDatefin().getTime())); // Assuming r.getDatefin() returns a LocalDate
            preparedStatement.setString(4, r.getNom());
            preparedStatement.setString(5, r.getPrenom());
            preparedStatement.setString(6, r.getEmail());
            preparedStatement.setInt(7, r.getNumtel());
            preparedStatement.executeUpdate();
            res = true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return res;
    }

    @Override
    public boolean modifierReservation(Reservation r, int idR) {
        boolean res = false;
        try {
            String req = "UPDATE Reservation set datedebut = ?, datefin = ?, nom = ?, prenom = ?, email = ?, numtel = ? WHERE idR = ?";
            PreparedStatement preparedStatement = Myconnection.getInstance().getCnx().prepareStatement(req);

            preparedStatement.setDate(1, new java.sql.Date(r.getDatedebut().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(r.getDatefin().getTime()));
            preparedStatement.setString(3, r.getNom());
            preparedStatement.setString(4, r.getPrenom());
            preparedStatement.setString(5, r.getEmail());
            preparedStatement.setInt(6, r.getNumtel());
            preparedStatement.setInt(7, idR); // Use the id parameter to identify the reservation to update

            preparedStatement.executeUpdate();
            System.out.println("modifier reservation");
            res = true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }

    @Override
    public boolean SupprimerReservation(int id) {
        boolean res = false;
        try {
            String requete = "DELETE  FROM Reservation where idR=" + id;
            PreparedStatement st = Myconnection.getInstance().getCnx().prepareStatement(requete);
            st.executeUpdate();
            System.out.println("reservation supprimée");
            res = true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }

    /* public static List<Voiture> rechercherVoiture(List<Voiture> vs) {
        List<Voiture> disponibleCars = new ArrayList<>();
        for (Voiture v : vs) {
        if (v.isDisponible()) {
            disponibleCars.add(v);
        }
     }
        return disponibleCars;
    }*/
    @Override
    public List<Reservation> AfficherReservations() {
        List<Reservation> myList = new ArrayList<>();

        try {
            String query = "SELECT * FROM Reservation";
            Statement statement = Myconnection.getInstance().getCnx().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Reservation r = new Reservation();
                r.setIdR(resultSet.getInt("idR"));
                r.setDatedebut(resultSet.getDate("datedebut"));
                r.setDatefin(resultSet.getDate("datefin"));
                r.setNom(resultSet.getString("nom"));
                r.setPrenom(resultSet.getString("prenom"));
                r.setEmail(resultSet.getString("email"));
                r.setNumtel(resultSet.getInt("numtel"));
                myList.add(r);
                System.out.println(r.getNom());
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return myList;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.vehicule;
import Utilities.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class vehiculeservice implements IService<vehicule, String> {
  Connection cnx = MaConnexion.getInstance().getCnx();
    
    /**
     *
     * @param v
     */
    @Override
    public void ajoutervehicule(vehicule v) {
    String sql = "INSERT INTO vehicule(matricule, modele, marque, couleur, carburant, annee, kilometrage) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement ste = cnx.prepareStatement(sql);
        ste.setString(1, v.getMatricule());
        ste.setString(2, v.getModele());
        ste.setString(3, v.getMarque());
        ste.setString(4, v.getCouleur());
        ste.setString(5, v.getCarburant());
        ste.setString(6, v.getAnnee());
        ste.setString(7, v.getKilometrage());
        ste.executeUpdate();
        System.out.println("Véhicule ajouté avec succès!");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}

    /**
     *
     *
     * @param mat */
     @Override
    public void supprimervehicule(String mat) {
    String request = "DELETE FROM vehicule WHERE matricule = '" + mat + "';";
    try {
        Statement st = cnx.createStatement();
        st.executeUpdate(request);
        System.out.println("Véhicule supprimé avec succès!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
          

    @Override
   public void modifiervehicule(vehicule v) {
        String req = "UPDATE vehicule SET modele=?, marque=?, couleur=?, carburant=?, annee=?, kilometrage=? WHERE matricule=?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, v.getModele());
        ps.setString(2, v.getMarque());
        ps.setString(3, v.getCouleur());
        ps.setString(4, v.getCarburant());
        ps.setString(5, v.getAnnee());
        ps.setString(6, v.getKilometrage());
        ps.setString(7, v.getMatricule());
        ps.executeUpdate();
        System.out.println("Véhicule modifié avec succès!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @return
     */
    @Override
   public List<vehicule> affichervehicule() {
    List<vehicule> vehicules = new ArrayList<>();
    String request = "SELECT * FROM vehicule";
    try {
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(request);
        while (rs.next()) {
            vehicule v = new vehicule();
            v.setId_v(rs.getInt("id_v"));
            v.setMatricule(rs.getString("matricule"));
            v.setModele(rs.getString("modele"));
            v.setMarque(rs.getString("marque"));
            v.setCouleur(rs.getString("couleur"));
            v.setCarburant(rs.getString("carburant"));
            v.setAnnee(rs.getString("annee"));
            v.setKilometrage(rs.getString("kilometrage"));
            vehicules.add(v);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return vehicules;
}

    /**
     *
     * @param mat
     * @return
     */
    public vehicule getVehiculeParMat(String mat) {
    String sql = "SELECT * FROM vehicule WHERE matricule = ?";
    PreparedStatement ste;
    try {
        ste = cnx.prepareStatement(sql);
        ste.setString(1, mat);
        ResultSet rs = ste.executeQuery();
        if (rs.next()) {
            vehicule v = new vehicule(
                    rs.getInt("id_v"),
                    rs.getString("matricule"),
                    rs.getString("modele"),
                    rs.getString("marque"),rs.getString("couleur"),
                    rs.getString("carburant"),
                    rs.getString("annee"),
                    rs.getString("kilometrage")
            );
            return v;
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return null;
}
    public vehicule getVehiculeParId(int id) {
    String sql = "SELECT * FROM vehicule WHERE id_v = ?";
    PreparedStatement ste;
    try {
        ste = cnx.prepareStatement(sql);
        ste.setInt(1, id);
        ResultSet rs = ste.executeQuery();
        if (rs.next()) {
            vehicule v = new vehicule(
                    rs.getInt("id_v"),
                    rs.getString("matricule"),
                    rs.getString("modele"),
                    rs.getString("marque"),rs.getString("couleur"),
                    rs.getString("carburant"),
                    rs.getString("annee"),
                    rs.getString("kilometrage")
            );
            return v;
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return null;
}

   
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entities.Avis;
import Utils.Myconnection;

/**
 *
 * @author Asus
 */
public class ServiceAvis {

    public boolean ajouterAvis(Avis a) {
        boolean res = false;
        try {
            String requete = "INSERT INTO Avis (rating,nom,url_image,commentaire) VALUES(?,?,?,?)";
            PreparedStatement st = Myconnection.getInstance().getCnx().prepareStatement(requete);
            st.setInt(1, a.getRating());
            st.setString(2, a.getNom());
            st.setString(3, a.getUrl_image());
            st.setString(4, a.getCommentaire());
            st.executeUpdate();
            System.out.println("Avis ajouté");
            res = true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }

    public boolean modifierAvis(Avis a, int id) {
        boolean res = false;
        try {
            String requete = "UPDATE Avis set rating=?,nom=?,url_image=?,commentaire=? where id=?";
            PreparedStatement st = Myconnection.getInstance().getCnx().prepareStatement(requete);
            st.setInt(5, id);
            st.setInt(1, a.getRating());
            st.setString(2, a.getNom());
            st.setString(3, a.getUrl_image());
            st.setString(4, a.getCommentaire());
            st.executeUpdate();
            System.out.println("Avis modifié");

            res = true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }

    public boolean SupprimerAvis(int id) {
        boolean res = false;
        try {
            String requete = "DELETE FROM Avis where id=?";
            PreparedStatement st = Myconnection.getInstance().getCnx().prepareStatement(requete);
            st.setInt(1, id);
            st.executeUpdate();
            res = true;
            System.out.println("Avis ajouté");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;

    }

    public List<Avis> listerAvis() {
        List<Avis> myList = new ArrayList<>();

        try {
            String requete3 = "SELECT * From Avis";
            Statement st3 = Myconnection.getInstance().getCnx().createStatement();
            ResultSet rs = st3.executeQuery(requete3);
            while (rs.next()) {
                Avis a = new Avis();
                a.setId(rs.getInt("id"));
                a.setRating(rs.getInt("rating"));
                a.setNom(rs.getString("nom"));
                a.setUrl_image(rs.getString("url_image"));
                a.setCommentaire(rs.getString("commentaire"));
                myList.add(a);
                System.out.println(a.getNom());

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return myList;

    }

    public List<Avis> listerAvisParId(int id) {
        List<Avis> myList = new ArrayList<>();

        try {
            String requete3 = "SELECT * From Avis where id=" + id;
            Statement st3 = Myconnection.getInstance().getCnx().createStatement();
            ResultSet rs = st3.executeQuery(requete3);
            while (rs.next()) {
                Avis a = new Avis();
                a.setId(rs.getInt(1));
                a.setRating(rs.getInt(6));
                a.setNom(rs.getString(4));
                a.setUrl_image(rs.getString(5));
                a.setCommentaire(rs.getString(8));
                myList.add(a);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return myList;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.marketplace;
import Utilities.MaConnexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed
 */
public class marketplaceservice implements ImarketplaceService<marketplace, Integer>  {
      Connection cnx = MaConnexion.getInstance().getCnx();

    /**
     *
     * @param m
     */
    @Override
    public void ajouter(marketplace m) {
        System.out.println(m);
        String req = "INSERT INTO marketplace (id_v, description, prix_vente, date_vente, image) VALUES (?,?,?,?,?)";
        PreparedStatement ste;
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, m.getId_v());
            ste.setString(2, m.getDescription());
            ste.setString(3, m.getPrix_vente());
            ste.setDate(4, new java.sql.Date(m.getDate_vente().getTime()));
            ste.setString(5, m.getImage());
            ste.executeUpdate();
            System.out.println("Marketplace item created!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
      @Override
    public void modifier(marketplace m) {
    String sql = "UPDATE marketplace SET id_v=?, description=?, prix_vente=?, date_vente=?, image=? WHERE id=?";
    PreparedStatement ste;
    try {
        ste = cnx.prepareStatement(sql);
        ste.setInt(1, m.getId_v()); 
        ste.setString(2, m.getDescription());
        ste.setString(3, m.getPrix_vente());
        ste.setDate(4, (Date) m.getDate_vente());
        ste.setString(5, m.getImage());
        ste.setInt(6, m.getId());
        ste.executeUpdate();
        System.out.println("Marketplace item modifié");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
    
      @Override
    public void supprimer(marketplace m) {
    String sql = "DELETE FROM marketplace WHERE id=?";
    PreparedStatement ste;
    try {
        ste = cnx.prepareStatement(sql);
        ste.executeUpdate();
        System.out.println("Marketplace item supprimé avec succès");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
    
    public List<marketplace> afficher() {
    List<marketplace> marketplaces = new ArrayList<>();
    String sql = "SELECT * FROM marketplace";
    try {
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            marketplace m = new marketplace(rs.getInt(1),rs.getInt(1),rs.getString("description"),rs.getString("prix_vente"),rs.getDate("date_vente"),rs.getString("image"));
            marketplaces.add(m);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return marketplaces;
}
          public List<marketplace> FiltrerParRole(int role) {
        List<marketplace> marketplaces = new ArrayList<>();
        String request = "SELECT * FROM user WHERE id_v = '"+role+"';";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
            marketplace m = new marketplace(rs.getInt(1),rs.getInt(1),rs.getString("description"),rs.getString("prix_vente"),rs.getDate("date_vente"),rs.getString("image"));
            marketplaces.add(m);
        }
        } catch (SQLException ex) {
            Logger.getLogger(marketplaceservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return marketplaces;
    }
      
      
      
      
      
      
      
}

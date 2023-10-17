/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class Myconnection {
    Connection cnx;
   private static Myconnection instance;

    private Myconnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/esprit"; 
            String login = "root";
            String pwd = "";

            cnx = DriverManager.getConnection(url, login, pwd); 
            System.out.println("Connection etablie");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public Connection getCnx() {
        return cnx;
    }

    public static Myconnection getInstance() {
        if (instance == null) {
            instance = new Myconnection();

        }

        return instance;
    }

}

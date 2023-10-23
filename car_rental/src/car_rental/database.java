/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 21698
 */
public class database {
        public static Connection connect(){
    
     
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/projet", "root","");
            
           return connect; 
            
        } catch (Exception e)
        {e.printStackTrace();
        }
            
        
        return null;
    }
    
}

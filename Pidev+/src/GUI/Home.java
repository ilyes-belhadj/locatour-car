/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.ServiceAvis;
import Services.ServiceReservation;
import entities.Avis;
import entities.Reservation;
import java.io.IOException;
import java.util.Date;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Home extends Application {

    @Override
  
    public void start(Stage primaryStage) {

            try {
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/CrudReservation.fxml")); 
                Scene scene = new Scene(root);
                primaryStage.setTitle("Locatour Car");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

         
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* ServiceReservation s = new ServiceReservation();
        Reservation r= new Reservation( new Date(), new Date(), "xxxx", "xxxx", "xxxx", 99999999);
        
        s.ajouter(r);
        */
       
       /*
       ServiceAvis a = new ServiceAvis();
        Avis av= new Avis(0 ,"xxxx", "xxxx", "xxxx");
        
        a.ajouterAvis(av);
*/
        launch(args);
    }

}

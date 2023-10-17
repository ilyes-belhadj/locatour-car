
package graphique;

/**
 *
 * @author 21698
 */
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javax.lang.model.element.Element;


public class controleur {

@FXML
    private Button boutonAjouter;

    @FXML
    private Button boutonModifier;

    @FXML
    private Button boutonSupprimer;

    @FXML
    private Button boutonAfficher;

    @FXML
    private ListView<String> listeView;

    @FXML
    private Label labelParc;

    // Les méthodes pour gérer les interactions avec les éléments FXML
    @FXML
    public void onAjouterClic() {
       try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaceajout.fxml"));
        Parent interfaceajout = loader.load();

      
        Stage stage = new Stage();
        stage.setScene(new Scene(interfaceajout));
        stage.show();

        // Fermer la page actuelle (facultatif)
        Stage stageActuelle = (Stage) boutonAjouter.getScene().getWindow(); // monBouton est le bouton "ajouter"
        stageActuelle.close();
    } catch (IOException e) {
        e.printStackTrace();
        // Gérer les erreurs éventuelles lors du chargement de la nouvelle page
    }
    }

    @FXML
    public void onModifierClic() {
         try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modification.fxml"));
        Parent modification = loader.load();

      
        Stage stage = new Stage();
        stage.setScene(new Scene(modification));
        stage.show();

        // Fermer la page actuelle (facultatif)
        Stage stageActuelle = (Stage) boutonModifier.getScene().getWindow(); // monBouton est le bouton "ajouter"
        stageActuelle.close();
    } catch (IOException e) {
        e.printStackTrace();
        // Gérer les erreurs éventuelles lors du chargement de la nouvelle page
    }
    }

    @FXML
    public void onSupprimerClic() {
    // Récupérez l'élément à supprimer (par exemple, l'élément sélectionné dans une liste)
    String elementASupprimer = listeView.getSelectionModel().getSelectedItem(); // Utilisez le composant approprié pour obtenir l'élément sélectionné

    if (elementASupprimer != null) {
        // Appelez une méthode ou une fonction pour effectuer la suppression
        boolean suppressionReussie = supprimerElement(elementASupprimer);

        if (suppressionReussie) {
            // Mettez à jour l'interface utilisateur après la suppression
            actualiserInterface();
        } else {
            // Gérez le cas où la suppression a échoué (par exemple, affichez un message d'erreur)
            afficherMessageErreur("La suppression a échoué.");
        }
    } else {
        // Gérez le cas où aucun élément n'a été sélectionné pour la suppression
        afficherMessageErreur("Veuillez sélectionner un élément à supprimer.");
    }
}

// Méthode pour effectuer la suppression de l'élément
private boolean supprimerElement(Element elementASupprimer) {
    // Ajoutez la logique pour supprimer l'élément ici
    // Renvoyez true si la suppression a réussi, sinon renvoyez false
    // Par exemple : return maListe.remove(elementASupprimer);
    return false;
    // Ajoutez la logique pour supprimer l'élément ici
    // Renvoyez true si la suppression a réussi, sinon renvoyez false
    // Par exemple : return maListe.remove(elementASupprimer);
}

// Méthode pour afficher un message d'erreur (personnalisez selon vos besoins)
private void afficherMessageErreur(String message) {
    // Ajoutez la logique pour afficher un message d'erreur à l'utilisateur
}

    @FXML
    public void onAfficherClic() {
        // Ajoutez ici la logique pour le bouton "afficher"
    }

    private void actualiserInterface() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean supprimerElement(String elementASupprimer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

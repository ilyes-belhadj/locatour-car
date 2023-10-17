/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maintenance;

/**
 *
 * @author 21698
 */
import java.util.ArrayList;
import java.util.List;

public class GestionMaintenanceParc {
    private final List<MaintenanceParc> maintenanceParcList = new ArrayList<>();
    private int nextId = 1; // Utilisé pour attribuer un ID unique à chaque enregistrement de maintenance.

    // Méthode pour ajouter une entrée de maintenance
    public void ajouterMaintenance(MaintenanceParc maintenance) {
        maintenance.setId(nextId++);
        maintenanceParcList.add(maintenance);
    }

    // Méthode pour afficher toutes les entrées de maintenance
    public List<MaintenanceParc> getMaintenanceParcList() {
        return maintenanceParcList;
    }

    // Méthode pour rechercher une entrée de maintenance par ID
    public MaintenanceParc trouverMaintenanceParId(int id) {
        for (MaintenanceParc maintenance : maintenanceParcList) {
            if (maintenance.getId() == id) {
                return maintenance;
            }
        }
        return null;
    }

    // Méthode pour mettre à jour les informations d'une entrée de maintenance
    public void mettreAJourMaintenance(MaintenanceParc maintenance) {
        MaintenanceParc existante = trouverMaintenanceParId(maintenance.getId());
        if (existante != null) {
            // Mettre à jour les propriétés de l'entrée de maintenance existante avec celles de la nouvelle entrée
            // ex : existante.setDescription(maintenance.getDescription());
        }
    }

    // Méthode pour supprimer une entrée de maintenance
    public void supprimerMaintenance(int id) {
        MaintenanceParc maintenanceASupprimer = trouverMaintenanceParId(id);
        if (maintenanceASupprimer != null) {
            maintenanceParcList.remove(maintenanceASupprimer);
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maintenance;

/**
 *
 * @author 21698
 */
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestionMaintenanceParc gestionMaintenanceParc = new GestionMaintenanceParc();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Ajouter une entrée de maintenance");
            System.out.println("2. Afficher toutes les entrées de maintenance");
            System.out.println("3. Mettre à jour une entrée de maintenance");
            System.out.println("4. Supprimer une entrée de maintenance");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Pour consommer la fin de la ligne

            switch (choix) {
                case 1:
                    MaintenanceParc nouvelleMaintenance = saisirNouvelleMaintenance(scanner);
                    gestionMaintenanceParc.ajouterMaintenance(nouvelleMaintenance);
                    System.out.println("Entrée de maintenance ajoutée avec succès !");
                    break;
                case 2:
                    afficherToutesLesMaintenances(gestionMaintenanceParc.getMaintenanceParcList());
                    break;
                case 3:
                    System.out.print("Entrez l'ID de l'entrée de maintenance à mettre à jour : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    MaintenanceParc maintenanceAMettreAJour = gestionMaintenanceParc.trouverMaintenanceParId(id);
                    if (maintenanceAMettreAJour != null) {
                        saisirInformationsMiseAJour(scanner, maintenanceAMettreAJour);
                        gestionMaintenanceParc.mettreAJourMaintenance(maintenanceAMettreAJour);
                        System.out.println("Entrée de maintenance mise à jour avec succès !");
                    } else {
                        System.out.println("Entrée de maintenance non trouvée.");
                    }
                    break;
                case 4:
                    System.out.print("Entrez l'ID de l'entrée de maintenance à supprimer : ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    gestionMaintenanceParc.supprimerMaintenance(id);
                    System.out.println("Entrée de maintenance supprimée avec succès !");
                    break;
                case 5:
                    System.out.println("Programme terminé.");
                    System.exit(0);
                default:
                    System.out.println("Option non valide.");
            }
        }
    }

    // Méthode pour saisir les informations d'une nouvelle entrée de maintenance
    private static MaintenanceParc saisirNouvelleMaintenance(Scanner scanner) {
        MaintenanceParc nouvelleMaintenance = new MaintenanceParc();
        System.out.print("Description : ");
        nouvelleMaintenance.setDescription(scanner.nextLine());
        // Saisir les autres propriétés de l'entrée de maintenance
        return nouvelleMaintenance;
    }

    // Méthode pour afficher toutes les entrées de maintenance
    private static void afficherToutesLesMaintenances(List<MaintenanceParc> maintenances) {
        System.out.println("Liste des entrées de maintenance :");
        for (MaintenanceParc maintenance : maintenances) {
            System.out.println("ID : " + maintenance.getId());
            System.out.println("Description : " + maintenance.getDescription());
            // Afficher les autres propriétés
            System.out.println();
        }
    }

    // Méthode pour saisir les informations de mise à jour d'une entrée de maintenance
    private static void saisirInformationsMiseAJour(Scanner scanner, MaintenanceParc maintenance) {
        System.out.print("Description : ");
        maintenance.setDescription(scanner.nextLine());
        // Saisir les autres propriétés à mettre à jour
    }
}
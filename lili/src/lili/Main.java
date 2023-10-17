/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lili;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GestionVoiture gestionVoitures = new GestionVoiture();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Ajouter une voiture");
            System.out.println("2. Afficher les voitures");
            System.out.println("3. Mettre à jour une voiture");
            System.out.println("4. Supprimer une voiture");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Pour consommer la fin de la ligne

            switch (choix) {
                case 1:
                    Voiture nouvelleVoiture = saisirNouvelleVoiture(scanner);
                    gestionVoitures.ajouterVoiture(nouvelleVoiture);
                    System.out.println("Voiture ajoutée avec succès !");
                    break;
                case 2:
                    afficherToutesLesVoitures(gestionVoitures);
                    break;
                case 3:
                    System.out.print("Entrez l'immatriculation de la voiture à mettre à jour : ");
                    String immatriculation = scanner.nextLine();
                    Voiture voitureAMettreAJour = gestionVoitures.trouverVoitureParImmatriculation(immatriculation);
                    if (voitureAMettreAJour != null) {
                        saisirInformationsMiseAJour(scanner, voitureAMettreAJour);
                        gestionVoitures.mettreAJourVoiture(voitureAMettreAJour);
                        System.out.println("Voiture mise à jour avec succès !");
                    } else {
                        System.out.println("Voiture non trouvée.");
                    }
                    break;
                case 4:
                    System.out.print("Entrez l'immatriculation de la voiture à supprimer : ");
                    immatriculation = scanner.nextLine();
                    gestionVoitures.supprimerVoiture(immatriculation);
                    System.out.println("Voiture supprimée avec succès !");
                    break;
                case 5:
                    System.out.println("Programme terminé.");
                    System.exit(0);
                default:
                    System.out.println("Option non valide.");
            }
        }
    }

    // Méthode pour saisir les informations d'une nouvelle voiture
    private static Voiture saisirNouvelleVoiture(Scanner scanner) {
        Voiture nouvelleVoiture = new Voiture();
        System.out.print("Immatriculation : ");
        nouvelleVoiture.setImatriculation(scanner.nextLine());
        // Saisir les autres propriétés de la voiture
        return nouvelleVoiture;
    }

    // Méthode pour afficher toutes les voitures
    private static void afficherToutesLesVoitures(GestionVoiture gestionVoitures) {
        System.out.println("Liste des voitures :");
        for (Voiture voiture : gestionVoitures.getVoitures()) {
            System.out.println(voiture.getImatriculation() + " - " + voiture.getMarque() + " " + voiture.getModele());
        }
    }

    // Méthode pour saisir les informations de mise à jour d'une voiture
    private static void saisirInformationsMiseAJour(Scanner scanner, Voiture voiture) {
        System.out.print("Kilométrage : ");
        voiture.setKilometrage(scanner.nextInt());
        // Saisir d'autres propriétés à mettre à jour
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package lili;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author 21698
 */
public class GestionVoiture {
    private final List<Voiture> voitures = new ArrayList<>();

    // Méthode pour ajouter une voiture
    public void ajouterVoiture(Voiture voiture) {
        voitures.add(voiture);
    }

    // Méthode pour afficher toutes les voitures
    public List<Voiture> getVoitures() {
        return voitures;
    }

    // Méthode pour rechercher une voiture par immatriculation
    public Voiture trouverVoitureParImmatriculation(String immatriculation) {
        for (Voiture voiture : voitures) {
            if (voiture.getImatriculation().equals(immatriculation)) {
                return voiture;
            }
        }
        return null;
    }

    // Méthode pour mettre à jour les informations d'une voiture
    public void mettreAJourVoiture(Voiture voiture) {
        Voiture existante = trouverVoitureParImmatriculation((String) voiture.getImatriculation());
        if (existante != null) {
            // Mettre à jour les propriétés de la voiture existante avec celles de la nouvelle voiture
            // ex : existante.setKilometrage(voiture.getKilometrage());
        }
    }

    // Méthode pour supprimer une voiture
    public void supprimerVoiture(String immatriculation) {
        Voiture voitureASupprimer = trouverVoitureParImmatriculation(immatriculation);
        if (voitureASupprimer != null) {
            voitures.remove(voitureASupprimer);
        }
    }
}

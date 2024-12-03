

import java.util.ArrayList;

import creatures.Lycanthrope;
import maladies.Maladie;

public class Main {
    public static void main(String[] args) {
        // Création d'une liste de maladies pour tester
        ArrayList<Maladie> maladies = new ArrayList<>();
        maladies.add(new Maladie("Grippe"));
        maladies.add(new Maladie("Fièvre Lunaire"));

        // Création d'une instance de Lycanthrope
        Lycanthrope lycan = new Lycanthrope(
            "Jean Lupin", // Nom complet
            "Masculin",   // Sexe
            85,           // Poids en kg
            180,          // Taille en cm
            25,           // Âge en années
            50,           // Indicateur moral
            maladies      // Liste des maladies
        );

        // Afficher les caractéristiques du Lycanthrope
        System.out.println("=== Caractéristiques du Lycanthrope ===");
        System.out.println(lycan.afficherCaracteristiques());

        // Tester la méthode attendre()
        System.out.println("\n=== Test de la méthode attendre() ===");
        System.out.println("Indicateur moral avant : " + lycan.indicateurMoral);
        lycan.attendre();
        System.out.println("Indicateur moral après : " + lycan.indicateurMoral);
    }
}

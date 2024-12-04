
package menu;

import creatures.*;
import hopital.Hopital;
import hopital.NullPointerListeServicesMedicauxException;
import hopital.TropDeServicesMedicauxException;
import maladies.Maladie;
import serviceMedical.ServiceMedical;
import serviceMedical.TropDeCreaturesException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe qui permet d'afficher le menu pour les services médicaux
 * @see MenuInterface
 */
public class MenuServiceMedical implements MenuInterface {

    private ServiceMedical serviceMedicalSelectionne;

    /**
     * Instance de la classe Hopital
     */
    public Hopital hopital;

    private static MenuServiceMedical instanceMenuServiceMedical;

    /**
     * Entrée utilisateur. C'est cette variable de type Scanner qui lira les entrées de l'utilisateur
     */
    private Scanner entreeUtilisateur;

    /**
     * Chaine qui réceptionne l'entrée de l'utilisateur.
     */
    private String chaineEntreeUtilisateur;

    // Constructeur

    /**
     * Constructeur privé pour le singleton
     */
    private MenuServiceMedical() {
        this.entreeUtilisateur = new Scanner(System.in);
        this.chaineEntreeUtilisateur = "";
    }

    /**
     * Sélectionne un service médical en fonction de l'entrée utilisateur
     */
    public void selectionServiceMedical() {
        System.out.println("Vous devez choisir un service médical. Entrez son nom:");
        this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
        this.serviceMedicalSelectionne = hopital.getServiceMedical(this.chaineEntreeUtilisateur);
        if (this.serviceMedicalSelectionne == null) {
            System.out.println("Service médical non trouvé. Veuillez réessayer.");
            selectionServiceMedical();
        }
    }

    /**
     * Affiche le menu principal des services médicaux
     * @throws MauvaiseEntreeException
     * @throws NullPointerListeServicesMedicauxException
     * @throws TropDeServicesMedicauxException
     * @throws TropDeCreaturesException
     */
    @Override
    public void afficherMenu() throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, TropDeServicesMedicauxException, TropDeCreaturesException {
        selectionServiceMedical();
        System.out.println("Vous êtes dans le menu des services médicaux. Veuillez faire un choix:");
        menuDeChoix();
    }

    /**
     * Affiche les choix du menu et traite les entrées utilisateur
     * @throws MauvaiseEntreeException
     * @throws NullPointerListeServicesMedicauxException
     * @throws TropDeServicesMedicauxException
     * @throws TropDeCreaturesException
     */
    @Override
    public void menuDeChoix() throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, TropDeServicesMedicauxException, TropDeCreaturesException {
        boolean quitter = false;
        while (!quitter) {
            System.out.println("Choisissez une option dans le menu principal:");
            System.out.println("1. Créer/Ajouter une créature");
            System.out.println("2. Supprimer une créature");
            System.out.println("3. Afficher les créatures");
            System.out.println("4. Réviser le budget");
            System.out.println("5. Afficher les caractéristiques");
            System.out.println("6. Quitter");

            this.chaineEntreeUtilisateur = entreeUtilisateur.nextLine();
            switch (this.chaineEntreeUtilisateur) {
                case "1":
                    creerAjouterCreature();
                    break;
                case "2":
                    supprimerCreature();
                    break;
                case "3":
                    afficherCreatures();
                    break;
                case "4":
                    reviserBudget();
                    break;
                case "5":
                    afficherCaracteristiques();
                    break;
                case "6":
                    quitter = true;
                    break;
                default:
                    System.out.println("Entrée incorrecte. Veuillez réessayer.");
            }
        }
        entreeUtilisateur.close();
    }

    /**
     * Crée et ajoute une créature en fonction des entrées utilisateur
     * @throws TropDeCreaturesException
     */
    private void creerAjouterCreature() throws TropDeCreaturesException {
        System.out.println("Entrer le nom de la créature:");
        String creatureNom = this.entreeUtilisateur.nextLine();
        System.out.println("Entrer le sexe de la créature:");
        String sexe = this.entreeUtilisateur.nextLine();
        System.out.println("Entrer le poids de la créature:");
        int poids = Integer.parseInt(this.entreeUtilisateur.nextLine());
        System.out.println("Entrer la taille de la créature:");
        int taille = Integer.parseInt(this.entreeUtilisateur.nextLine());
        System.out.println("Entrer l'âge de la créature:");
        int age = Integer.parseInt(this.entreeUtilisateur.nextLine());

        String type = "";
        while (!type.matches("[cehnozv]")) {
            System.out.println("Choisissez le type de créature (c: CreatureBestiale, e: Elfe, h: HommeBete, n: Nain, o: Orque, v: Vampire, z: Zombie):");
            type = this.entreeUtilisateur.nextLine();
        }

        switch (type) {
            case "c":
                serviceMedicalSelectionne.ajouterCreature(new CreatureBestiale(creatureNom, sexe, poids, taille, age, new ArrayList<Maladie>()));
                break;
            case "e":
                serviceMedicalSelectionne.ajouterCreature(new Elfe(creatureNom, sexe, poids, taille, age, new ArrayList<Maladie>()));
                break;
            case "h":
                serviceMedicalSelectionne.ajouterCreature(new HommeBete(creatureNom, sexe, poids, taille, age, new ArrayList<Maladie>()));
                break;
            case "n":
                System.out.println("Donner son indicateur moral:");
                int indicateurMoral = Integer.parseInt(this.entreeUtilisateur.nextLine());
                serviceMedicalSelectionne.ajouterCreature(new Nain(creatureNom, sexe, poids, taille, age, indicateurMoral, new ArrayList<Maladie>()));
                break;
            case "o":
                serviceMedicalSelectionne.ajouterCreature(new Orque(creatureNom, sexe, poids, taille, age, new ArrayList<Maladie>()));
                break;
            case "v":
                serviceMedicalSelectionne.ajouterCreature(new Vampire(creatureNom, sexe, poids, taille, age, new ArrayList<Maladie>()));
                break;
            case "z":
                System.out.println("Donner son indicateur moral:");
                indicateurMoral = Integer.parseInt(this.entreeUtilisateur.nextLine());
                serviceMedicalSelectionne.ajouterCreature(new Zombie(creatureNom, sexe, poids, taille, age, indicateurMoral, new ArrayList<Maladie>()));
                break;
        }
    }

    /**
     * Supprime une créature en fonction de l'entrée utilisateur
     */
    private void supprimerCreature() {
        System.out.println("Entrer le nom de la créature que vous voulez supprimer:");
        this.chaineEntreeUtilisateur = entreeUtilisateur.nextLine();
        Creature creature = this.serviceMedicalSelectionne.getCreature(this.chaineEntreeUtilisateur);
        if (creature != null) {
            this.serviceMedicalSelectionne.retirerCreature(creature);
            System.out.println("Créature supprimée avec succès.");
        } else {
            System.out.println("Créature non trouvée.");
        }
    }

    /**
     * Affiche la liste des créatures
     */
    private void afficherCreatures() {
        ArrayList<Creature> creaturesListe = this.serviceMedicalSelectionne.getListeCreatures();
        for (Creature uneCreature : creaturesListe) {
            uneCreature.afficherCaracteristiques();
        }
    }

    /**
     * Révise le budget du service médical
     */
    private void reviserBudget() {
        this.serviceMedicalSelectionne.reviserBudget();
        System.out.println("Budget révisé: " + this.serviceMedicalSelectionne.getBudget());
    }

    /**
     * Affiche les caractéristiques du menu de l'hôpital
     * @throws TropDeServicesMedicauxException 
     * @throws NullPointerListeServicesMedicauxException 
     * @throws MauvaiseEntreeException 
     */
    private void afficherCaracteristiques() throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, TropDeServicesMedicauxException {
        MenuHopital menuHopital = MenuHopital.getInstanceMenuHopital();
        menuHopital.afficherMenu();
    }

    /**
     * Retourne l'instance unique de MenuServiceMedical
     * @return instanceMenuServiceMedical
     */
    public static MenuServiceMedical getInstanceMenuServiceMedical() {
        if (instanceMenuServiceMedical == null) {
            instanceMenuServiceMedical = new MenuServiceMedical();
        }
        return instanceMenuServiceMedical;
    }
}

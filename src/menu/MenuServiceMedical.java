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
 * */
public class MenuServiceMedical implements MenuInterface {

    private ServiceMedical serviceMedicalSelectionne;

    /**
     * Instance de la classe Hopital
     * */
    public Hopital hopital;

    private static MenuServiceMedical instanceMenuServiceMedical;

    /**
     * Entrée utilisateur. C'est cette variable de type Scanner qui lira les entrées de l'utilisateur
     * */
    private Scanner entreeUtilisateur;

    /**
     * Chaine qui réceptionne l'entrée de l'utilisateur.
     * */
    private String chaineEntreeUtilisateur;

    //Constructeur

    /***/
    private MenuServiceMedical() {
        this.entreeUtilisateur = new Scanner(System.in);
        this.chaineEntreeUtilisateur = "";
    }

    /***/
    public void selectionServiceMedical() {;
        System.out.println("Vous devez choisir un service médical. Entrez son nom:");
        this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
        this.serviceMedicalSelectionne = hopital.getServiceMedical(this.chaineEntreeUtilisateur);
    }

    /**
     *
     */
    @Override
    public void afficherMenu() throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, TropDeServicesMedicauxException, TropDeCreaturesException {
        selectionServiceMedical();
        System.out.println("Vous êtes dans le menu des services médicaux: Veuillez faire un choix:");
        menuDeChoix();
    }

    /**
     *
     */
    @Override
    public void menuDeChoix() throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, TropDeServicesMedicauxException, TropDeCreaturesException {
        boolean quitter = false;
        while (!quitter) {
            System.out.println("Choisissez votre choix dans le menu principal:");
            this.chaineEntreeUtilisateur = entreeUtilisateur.next();
            switch (this.chaineEntreeUtilisateur) {
                case "creerAjouterCreature":
                    System.out.println("Entrer le nom de la créature");
                    String creatureNom = this.entreeUtilisateur.nextLine();
                    System.out.println("Entrer le sexe de la créature");
                    String sexe = this.entreeUtilisateur.nextLine();
                    System.out.println("Entrer le poids de la créature");
                    int poids = this.entreeUtilisateur.nextInt();
                    System.out.println("Entrer la taille de la créature");
                    int taille = this.entreeUtilisateur.nextInt();
                    System.out.println("Entrer l'âge de la créature");
                    int age = this.entreeUtilisateur.nextInt();

                    String type = "";
                    while (!type.equals("c") && !type.equals("e") && !type.equals("h") && !type.equals("n") && !type.equals ("o") && !type.equals("v") && !type.equals("z")) {
                        System.out.println("Choississez le type de créatures:");
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
                            System.out.println("Donner son indicateur moral");
                            int indicateurMoral = this.entreeUtilisateur.nextInt();
                            serviceMedicalSelectionne.ajouterCreature(new Nain(creatureNom, sexe, poids, taille, age, indicateurMoral, new ArrayList<Maladie>()));
                            break;
                        case "o":
                            serviceMedicalSelectionne.ajouterCreature(new Orque(creatureNom, sexe, poids, taille, age, new ArrayList<Maladie>()));
                            break;
                        case "v":
                            serviceMedicalSelectionne.ajouterCreature(new Vampire(creatureNom, sexe, poids, taille, age, new ArrayList<Maladie>()));
                            break;
                        case "z":
                            System.out.println("Donner son indicateur moral");
                            indicateurMoral = this.entreeUtilisateur.nextInt();
                            serviceMedicalSelectionne.ajouterCreature(new Zombie(creatureNom, sexe, poids, taille, age, indicateurMoral, new ArrayList<Maladie>()));
                            break;
                    }
                    break;

                case "supprimerCreature":
                    System.out.println("Entrer le nom de la créature que vous voulez supprimer: ");
                    this.chaineEntreeUtilisateur = entreeUtilisateur.nextLine();
                    Creature creature = this.serviceMedicalSelectionne.getCreature(this.chaineEntreeUtilisateur);
                    this.serviceMedicalSelectionne.retirerCreature(creature);
                    break;

                case "afficherCreatures":
                    ArrayList<Creature> creaturesListe = this.serviceMedicalSelectionne.getListeCreatures();
                    for (Creature uneCreature : creaturesListe) {
                        uneCreature.afficherCaracteristiques();
                    }
                    break;

                case "reviserBudget":
                    this.serviceMedicalSelectionne.reviserBudget();
                    System.out.println(this.serviceMedicalSelectionne.getBudget());
                    break;

                case "afficherCaracteristiques":
                    MenuHopital menuHopital = MenuHopital.getInstanceMenuHopital();
                    menuHopital.afficherMenu();
                    break;
                case "quitter":
                    quitter = true;
                    break;
                default:
                    throw new MauvaiseEntreeException();
            }
        }
        entreeUtilisateur.close();
    }

    /***/
    public static MenuServiceMedical getInstanceMenuServiceMedical() {
        if (instanceMenuServiceMedical == null) {
            instanceMenuServiceMedical = new MenuServiceMedical ();
        }
        return instanceMenuServiceMedical;
    }
}

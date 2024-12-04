package menu;

import hopital.Hopital;
import medecins.Medecin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe qui permet d'afficher le menu pour les médecins
 * @see MenuInterface
 * */
public class MenuMedecin implements MenuInterface {

    private Medecin medecinSelectionne;

    private static MenuMedecin instanceMenuMedecin;

    /**
     * Entrée utilisateur. C'est cette variable de type Scanner qui lira les entrées de l'utilisateur
     * */
    private Scanner entreeUtilisateur;

    /**
     * Chaine qui réceptionne l'entrée de l'utilisateur.
     * */
    private String chaineEntreeUtilisateur;

    /**
     * Instance de l'hôpital utilisé dans le modèle Singleton
     * */
    private Hopital hopital;

    //Constructeur

    /***/
    private MenuMedecin() {
        this.hopital = Hopital.getInstance();
        this.entreeUtilisateur = new Scanner(System.in);
        this.chaineEntreeUtilisateur = " ";
    }

    public void selectionMedecin() {
        System.out.println("Vous devez choisir un médecin. Entrez son nom:");
        this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
        this.hopital.getMedecin(this.chaineEntreeUtilisateur);
    }

    /**
     *
     */
    @Override
    public void afficherMenu () throws MauvaiseEntreeException {
        System.out.println("Vous êtes dans le menu de configuration des médecins: Veuillez faire un choix:");
        selectionMedecin();
        menuDeChoix();
    }

    /**
     *
     */
    @Override
    public void menuDeChoix () throws MauvaiseEntreeException {
        boolean quitter = false;
        while (!quitter) {
            System.out.println("Choisissez votre choix dans le menu principal:");
            this.chaineEntreeUtilisateur = entreeUtilisateur.next();
            switch (chaineEntreeUtilisateur) {
                case "modifierNom":
                    System.out.println("Entrer un nom: ");
                    this.chaineEntreeUtilisateur = entreeUtilisateur.nextLine();
                    medecinSelectionne.setNom(this.chaineEntreeUtilisateur);
                    break;

                case "modifierAge":
                    System.out.println("Entrer l'âge du médecin: ");
                    int ageMedecin = entreeUtilisateur.nextInt();
                    medecinSelectionne.setAge(ageMedecin);
                    break;

                case "modifierSexe":
                    System.out.println("Entrer le sexe du médecin: ");
                    this.chaineEntreeUtilisateur = entreeUtilisateur.nextLine();
                    medecinSelectionne.setSexe(this.chaineEntreeUtilisateur);
                    break;

                case "quitter":
                    quitter = true;
                    break;
                default:
                    throw new MauvaiseEntreeException ();
            }
        }
        this.entreeUtilisateur.close();
    }

    /***/
    public static MenuMedecin getInstanceMenuMedecin() {
        if (instanceMenuMedecin == null) {
            instanceMenuMedecin = new MenuMedecin ();
        }
        return instanceMenuMedecin;
    }
}

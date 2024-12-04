package menu;

import creatures.Creature;
import hopital.Hopital;

import java.util.Scanner;

/**
 * Classe qui permet d'afficher le menu pour les créatures
 * @see MenuInterface
 * */
public class MenuCreatures implements MenuInterface {

    private Creature creatureSelectionne;

    private static MenuCreatures instanceMenuCreatures;

    /**
     * Entrée utilisateur. C'est cette variable de type Scanner qui lira les entrées de l'utilisateur
     * */
    private Scanner entreeUtilisateur;

    /**
     * Chaine qui réceptionne l'entrée de l'utilisateur.
     * */
    private String chaineEntreeUtilisateur;

    private Hopital hopital;

    //Constructeur

    /***/
    private MenuCreatures() {
        this.hopital = Hopital.getInstance();
        this.entreeUtilisateur = new Scanner(System.in);
        this.chaineEntreeUtilisateur = "";
    }

    /**
     *
     */
    @Override
    public void afficherMenu () throws MauvaiseEntreeException {
        System.out.println("Vous êtes dans le menu des services médicaux: Veuillez faire un choix:");
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
            switch (this.chaineEntreeUtilisateur) {
                case "modifierNom":
                    System.out.println("Entrez le nouveau nom de cette créature: ");
                    this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
                    this.creatureSelectionne.setNomComplet(this.chaineEntreeUtilisateur);
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
    public static MenuCreatures getInstanceMenuCreatures() {
        if (instanceMenuCreatures == null) {
            instanceMenuCreatures = new MenuCreatures();
        }
        return instanceMenuCreatures;
    }
}

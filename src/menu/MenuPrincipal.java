
package menu;

import hopital.NullPointerListeServicesMedicauxException;
import hopital.TropDeServicesMedicauxException;
import maladies.ErreurChangementNiveauException;
import serviceMedical.TropDeCreaturesException;

import java.util.Scanner;

/**
 * Menu principal qui implémente l'interface MenuInterface
 * @see MenuInterface
 */
public class MenuPrincipal implements MenuInterface {
    /**
     * Variable statique de l'instance du menu principal
     */
    private static MenuPrincipal instanceMenuPrincipal;

    /**
     * Entrée utilisateur. C'est cette variable de type Scanner qui lira les entrées de l'utilisateur
     */
    private Scanner entreeUtilisateur;

    /**
     * Chaine qui réceptionne l'entrée de l'utilisateur.
     */
    private String chaineEntreeUtilisateur;

    // Constructeur
    private MenuPrincipal() {
        entreeUtilisateur = new Scanner(System.in);
        this.chaineEntreeUtilisateur = "";
    }

    /**
     * Affiche le menu de démarrage de l'application
     */
    public void afficherMenuDemarrageApplication() {
        System.out.println("Bienvenue sur le système de gestion du menu principal. Configuration par défaut votre hôpital de base...");
        MenuHopital menuHopital = MenuHopital.getInstanceMenuHopital();
    }

    /**
     * Affiche le menu principal
     */
    @Override
    public void afficherMenu() throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, ErreurChangementNiveauException, TropDeServicesMedicauxException, TropDeCreaturesException {
        System.out.println("Bienvenue sur le système de gestion du menu principal:");
        this.chaineEntreeUtilisateur = entreeUtilisateur.next();
        menuDeChoix();
    }

    @Override
    public void menuDeChoix() throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, ErreurChangementNiveauException, TropDeServicesMedicauxException, TropDeCreaturesException {
        boolean quitter = false;
        while (!quitter) {
            System.out.println("Choisissez une option dans le menu principal:");
            System.out.println("1 - Gestion des hôpitaux");
            System.out.println("2 - Gestion des maladies");
            System.out.println("3 - Gestion des médecins");
            System.out.println("4 - Gestion des services médicaux");
            System.out.println("5 - Gestion des créatures");
            System.out.println("6 - Quitter");

            this.chaineEntreeUtilisateur = entreeUtilisateur.next();

            switch (this.chaineEntreeUtilisateur) {
                case "1" -> MenuHopital.getInstanceMenuHopital().afficherMenu();
                case "2" -> MenuMaladie.getInstanceMenuMaladie().afficherMenu();
                case "3" -> MenuMedecin.getInstanceMenuMedecin().afficherMenu();
                case "4" -> MenuServiceMedical.getInstanceMenuServiceMedical().afficherMenu();
                case "5" -> MenuCreatures.getInstanceMenuCreatures().afficherMenu();
                case "6" -> quitter = true;
                default -> throw new MauvaiseEntreeException();
            }
        }
    }

    /**
     * Renvoie une instance du menu principal
     * @return MenuPrincipal: instance du menu principal
     */
    public static MenuPrincipal getInstanceMenuPrincipal() {
        if (instanceMenuPrincipal == null) {
            instanceMenuPrincipal = new MenuPrincipal();
        }
        return instanceMenuPrincipal;
    }

    /**
     * Ferme le Scanner
     */
    public void closeScanner() {
        if (entreeUtilisateur != null) {
            entreeUtilisateur.close();
        }
    }
}

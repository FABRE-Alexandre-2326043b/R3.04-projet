
package menu;

import creatures.Creature;
import hopital.Hopital;
import maladies.*;
import serviceMedical.ServiceMedical;

import java.util.Scanner;

/**
 * Classe qui permet d'afficher le menu pour les maladies
 * @see MenuInterface
 */
public class MenuMaladie implements MenuInterface {

    private Maladie maladieSelectionnee;

    private static MenuMaladie instanceMenuMaladie;

    /**
     * Entrée utilisateur. C'est cette variable de type Scanner qui lira les entrées de l'utilisateur
     */
    private Scanner entreeUtilisateur;

    /**
     * Chaine qui réceptionne l'entrée de l'utilisateur.
     */
    private String chaineEntreeUtilisateur;

    private Hopital hopital;

    // Constructeur

    /**
     * Constructeur privé pour le singleton
     */
    private MenuMaladie() {
        this.entreeUtilisateur = new Scanner(System.in);
        this.chaineEntreeUtilisateur = "";
    }

    /**
     * Sélectionne une maladie en fonction de l'entrée utilisateur
     */
    public void selectionMaladie() {
        System.out.println("Vous devez choisir une maladie. Tapez le nom d'un service médical où une créature est contaminée:");
        try {
            this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
            ServiceMedical serviceMedical = this.hopital.getServiceMedical(this.chaineEntreeUtilisateur);
            System.out.println("Entrez le nom de la créature qui possède la maladie que vous cherchez:");
            this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
            Creature creature = serviceMedical.getCreature(this.chaineEntreeUtilisateur);
            System.out.println("Votre créature a attrapé les maladies suivantes, choisissez laquelle en entrant le nom abrégé:");
            for (Maladie maladie : creature.getListeMaladies()) {
                System.out.println(maladie.toString() + "\n");
            }
            this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
            for (Maladie maladie : creature.getListeMaladies()) {
                if (maladie.getNomAbrege().equals(this.chaineEntreeUtilisateur)) {
                    maladieSelectionnee = maladie;
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    /**
     * Affiche le menu principal des maladies
     * @throws MauvaiseEntreeException
     * @throws ErreurChangementNiveauException
     */
    @Override
    public void afficherMenu() throws MauvaiseEntreeException, ErreurChangementNiveauException {
        selectionMaladie();
        System.out.println("Vous êtes dans le menu des maladies. Veuillez faire un choix:");
        menuDeChoix();
    }

    /**
     * Affiche les choix du menu et traite les entrées utilisateur
     * @throws MauvaiseEntreeException
     * @throws ErreurChangementNiveauException
     */
    @Override
    public void menuDeChoix() throws MauvaiseEntreeException, ErreurChangementNiveauException {
        boolean quitter = false;
        while (!quitter) {
            System.out.println("Choisissez une option dans le menu principal:");
            System.out.println("1. Augmenter le niveau actuel");
            System.out.println("2. Réduire le niveau actuel");
            System.out.println("3. Vérifier la létalité");
            System.out.println("4. Vérifier le type de maladie et calculer le coefficient");
            System.out.println("5. Arrêter la maladie");
            System.out.println("6. Quitter");

            this.chaineEntreeUtilisateur = entreeUtilisateur.nextLine();
            switch (this.chaineEntreeUtilisateur) {
                case "1":
                    augmenterNiveauActuel();
                    break;
                case "2":
                    reduireNiveauActuel();
                    break;
                case "3":
                    verifierLetalite();
                    break;
                case "4":
                    verifierTypeMaladieetCalculerCoeff();
                    break;
                case "5":
                    arreterMaladie();
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

    private void augmenterNiveauActuel() throws ErreurChangementNiveauException {
        System.out.println("Entrer de combien voulez-vous augmenter le niveau actuel:");
        int niv = this.entreeUtilisateur.nextInt();
        this.entreeUtilisateur.nextLine();
        this.maladieSelectionnee.augmenterNiveauActuel(niv);
    }

    private void reduireNiveauActuel() throws ErreurChangementNiveauException {
        System.out.println("Entrer de combien voulez-vous réduire le niveau actuel:");
        int niveau = this.entreeUtilisateur.nextInt();
        this.entreeUtilisateur.nextLine();
        this.maladieSelectionnee.reduireNiveauActuel(niveau);
    }

    private void verifierLetalite() {
        if (this.maladieSelectionnee.estLetal()) {
            System.out.println("La maladie est létale.");
        } else {
            System.out.println("La maladie n'est pas létale.");
        }
    }

    private void verifierTypeMaladieetCalculerCoeff() {
        if (this.maladieSelectionnee instanceof BalonnementGastrique) {
            System.out.println("La maladie est " + this.maladieSelectionnee.getNomAbrege() +
                    " et son coefficient de dégradation est: " +
                    ((BalonnementGastrique) this.maladieSelectionnee).calculerCoefficientDegradationMaladie());
        } else if (this.maladieSelectionnee instanceof DependanceAuxReseauxSociaux) {
            System.out.println("La maladie est " + this.maladieSelectionnee.getNomAbrege() +
                    " et son coefficient de dégradation est: " +
                    ((DependanceAuxReseauxSociaux) this.maladieSelectionnee).calculerCoefficientDegradationMaladie());
        } else if (this.maladieSelectionnee instanceof MaladieDebilitanteChronique) {
            System.out.println("La maladie est " + this.maladieSelectionnee.getNomAbrege() +
                    " et son coefficient de dégradation est: " +
                    ((MaladieDebilitanteChronique) this.maladieSelectionnee).calculerCoefficientDegradationMaladie());
        } else if (this.maladieSelectionnee instanceof ProphyrieErythropoietiqueCongenitale) {
            System.out.println("La maladie est " + this.maladieSelectionnee.getNomAbrege() +
                    " et son coefficient de dégradation est: " +
                    ((ProphyrieErythropoietiqueCongenitale) this.maladieSelectionnee).calculerCoefficientDegradationMaladie());
        } else if (this.maladieSelectionnee instanceof SyndromeFearOfMissingOut) {
            System.out.println("La maladie est " + this.maladieSelectionnee.getNomAbrege() +
                    " et son coefficient de dégradation est: " +
                    ((SyndromeFearOfMissingOut) this.maladieSelectionnee).calculerCoefficientDegradationMaladie());
        } else if (this.maladieSelectionnee instanceof ZoopathiePaeaphreniqueLycanthropique) {
            System.out.println("La maladie est " + this.maladieSelectionnee.getNomAbrege() +
                    " et son coefficient de dégradation est: " +
                    ((ZoopathiePaeaphreniqueLycanthropique) this.maladieSelectionnee).calculerCoefficientDegradationMaladie());
        }
    }

    private void arreterMaladie() throws ErreurChangementNiveauException {
        this.maladieSelectionnee.reduireNiveauActuel(this.maladieSelectionnee.getNiveauActuel());
    }

    /**
     * Retourne l'instance unique de MenuMaladie
     * @return instanceMenuMaladie
     */
    public static MenuMaladie getInstanceMenuMaladie() {
        if (instanceMenuMaladie == null) {
            instanceMenuMaladie = new MenuMaladie();
        }
        return instanceMenuMaladie;
    }
}

package menu;

import creatures.Creature;
import hopital.Hopital;
import maladies.*;
import serviceMedical.ServiceMedical;

import java.util.Scanner;

/**
 * Classe qui permet d'afficher le menu pour les maladies
 * @see MenuInterface
 * */
public class MenuMaladie  implements MenuInterface {

    private Maladie maladieSelectionnee;

    private static MenuMaladie instanceMenuMaladie;

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
    private MenuMaladie() {
        this.entreeUtilisateur = new Scanner(System.in);
        this.chaineEntreeUtilisateur = "";
    }

    public void selectionMaladie() {;
        System.out.println("Vous devez choisir une maladie. Taper le nom d'un service médical où une créature est contaminée:");
        try {
            this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine ();
            ServiceMedical serviceMedical = this.hopital.getServiceMedical (this.chaineEntreeUtilisateur);
            System.out.println ("Entrer le nom de la créature qui possède la maladie que vous cherchez");
            this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine ();
            Creature creature = serviceMedical.getCreature(this.chaineEntreeUtilisateur);
            System.out.println("Votre créature a attrapé les maladies suivantes, choisissez laquelle en entrant le nom abrégé:");
            for (Maladie maladie: creature.getListeMaladies()) {
                System.out.println(maladie.toString() + "\n");
            }
            this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
            for (Maladie maladie: creature.getListeMaladies()) {
                if (maladie.getNomAbrege().equals(this.chaineEntreeUtilisateur)) {
                    maladieSelectionnee = maladie;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     */
    @Override
    public void afficherMenu () throws MauvaiseEntreeException, ErreurChangementNiveauException {
        selectionMaladie();
        System.out.println("Vous êtes dans le menu des maladies: Veuillez faire un choix:");
        menuDeChoix();
    }

    /**
     *
     */
    @Override
    public void menuDeChoix () throws MauvaiseEntreeException, ErreurChangementNiveauException {
        boolean quitter = false;
        while (!quitter) {
            System.out.println("Choisissez votre choix dans le menu principal:");
            this.chaineEntreeUtilisateur = entreeUtilisateur.next();
            switch (this.chaineEntreeUtilisateur) {
                case "augmenterNiveauActuel":
                    System.out.println("Entrer de combien voulez-vous augmenter le niveau actuel:");
                    int niv = this.entreeUtilisateur.nextInt();
                    this.maladieSelectionnee.augmenterNiveauActuel(niv);
                    break;

                case "reduireNiveauActuel":
                    System.out.println("Entrer de combien voulez-vous réduire le niveau actuel:");
                    int niveau = this.entreeUtilisateur.nextInt();
                    this.maladieSelectionnee.reduireNiveauActuel(niveau);
                    break;

                case "verifierLetalite":
                    if (this.maladieSelectionnee.estLetal()) {
                        System.out.println("La maladie est létal.");
                    }
                    else {
                        System.out.println("La maladie n'est pas létal.");
                    }
                    break;

                case "verifierTypeMaladieetCalculerCoeff":
                    if (this.maladieSelectionnee instanceof BalonnementGastrique) {
                        System.out.println ("La maladie est " + this.maladieSelectionnee.getNomAbrege () +
                                "et son coefficient de dégradadation est: " +
                                ((BalonnementGastrique) this.maladieSelectionnee).calculerCoefficientDegradationMaladie ());
                    }
                    else if (this.maladieSelectionnee instanceof DependanceAuxReseauxSociaux) {
                            System.out.println("La maladie est " + this.maladieSelectionnee.getNomAbrege() +
                                    "et son coefficient de dégradadation est: " +
                                    ((DependanceAuxReseauxSociaux) this.maladieSelectionnee).calculerCoefficientDegradationMaladie());
                    }
                    else if (this.maladieSelectionnee instanceof MaladieDebilitanteChronique) {
                            System.out.println ("La maladie est " + this.maladieSelectionnee.getNomAbrege () +
                                    "et son coefficient de dégradadation est: " +
                                    ((MaladieDebilitanteChronique) this.maladieSelectionnee).calculerCoefficientDegradationMaladie ());
                    }
                    else if (this.maladieSelectionnee instanceof ProphyrieErythropoietiqueCongenitale) {
                                System.out.println ("La maladie est " + this.maladieSelectionnee.getNomAbrege () +
                                        "et son coefficient de dégradadation est: " +
                                        ((ProphyrieErythropoietiqueCongenitale) this.maladieSelectionnee).calculerCoefficientDegradationMaladie ());
                    }
                    else if (this.maladieSelectionnee instanceof SyndromeFearOfMissingOut) {
                        System.out.println("La maladie est " + this.maladieSelectionnee.getNomAbrege() +
                                "et son coefficient de dégradadation est: " +
                                ((SyndromeFearOfMissingOut) this.maladieSelectionnee).calculerCoefficientDegradationMaladie());
                    }
                    else if (this.maladieSelectionnee instanceof ZoopathiePaeaphreniqueLycanthropique) {
                        System.out.println("La maladie est " + this.maladieSelectionnee.getNomAbrege() +
                                "et son coefficient de dégradadation est: " +
                                ((ZoopathiePaeaphreniqueLycanthropique) this.maladieSelectionnee).calculerCoefficientDegradationMaladie());
                    }
                    break;

                case "arreterMaladie":
                    this.maladieSelectionnee.reduireNiveauActuel(this.maladieSelectionnee.getNiveauActuel());
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
    public static MenuMaladie getInstanceMenuMaladie() {
        if (instanceMenuMaladie == null) {
            instanceMenuMaladie = new MenuMaladie();
        }
        return instanceMenuMaladie;
    }
}

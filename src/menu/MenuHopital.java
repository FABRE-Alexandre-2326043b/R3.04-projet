package menu;

import hopital.Hopital;
import hopital.NullPointerListeServicesMedicauxException;
import hopital.TropDeServicesMedicauxException;
import medecins.Medecin;
import serviceMedical.CentreQuarantaine;
import serviceMedical.Crypte;
import serviceMedical.ServiceMedical;

import java.io.IOException;
import java.util.Scanner;

/**
 * Classe qui permet d'afficher le menu pour les hôpitaux
 * @see MenuInterface
 * */
public class MenuHopital implements MenuInterface {


    private static MenuHopital instanceMenuHopital;

    /**
     * Entrée utilisateur. C'est cette variable de type Scanner qui lira les entrées de l'utilisateur
     * */
    private Scanner entreeUtilisateur;

    /**
     * Chaine qui réceptionne l'entrée de l'utilisateur.
     * */
    String chaineEntreeUtilisateur;

    private Hopital hopital;

    //Constructeur

    /***/
    private MenuHopital() {
        this.hopital = Hopital.getInstance();
        this.entreeUtilisateur = new Scanner(System.in);
        this.chaineEntreeUtilisateur = " ";
    }

    /**
     *
     */
    @Override
    public void afficherMenu () throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, TropDeServicesMedicauxException {
        System.out.println("Vous êtes dans le menu de l'hôpital: Veuillez faire un choix:");
        menuDeChoix();
    }

    /**
     *
     */
    @Override
    public void menuDeChoix () throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, TropDeServicesMedicauxException {
        boolean quitter = false;
        while (!quitter) {
            System.out.println("Choisissez votre choix dans le menu principal:");
            this.chaineEntreeUtilisateur = entreeUtilisateur.next();
            switch (chaineEntreeUtilisateur) {
                case "modifierNomHopital":
                    System.out.println ("Entrer le nouveau nom de l'hôpital");
                    this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
                    this.hopital.setNom(this.chaineEntreeUtilisateur);
                    break;

                case "modfifierMaximumServiceMedical":
                    System.out.println ("Entrer le nouveau maximum de services médicaux");
                    hopital.setNbServicesMedicauxMax(this.entreeUtilisateur.nextInt());

                case "modifierNombreMaximumDeServicesMedicaux":
                    System.out.println ("Entrer le nombre de services médicaux maximum");
                    this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
                    this.hopital.setNom(this.chaineEntreeUtilisateur);
                    break;

                case "ajouterMedecin":
                    System.out.println ("Entrer le nom de medecin");
                    String nomMedecin = this.entreeUtilisateur.nextLine();
                    System.out.println ("Entrer l'âge du médecin");
                    int ageMedecin = this.entreeUtilisateur.nextInt();
                    System.out.println ("Entrer le sexe du médecin");
                    String sexeMedecin = this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
                    hopital.ajouterMedecin(new Medecin(nomMedecin, sexeMedecin, ageMedecin));
                    break;

                case "chercherMedecin":
                    System.out.println ("Entrer le nom du médecin que vous cherchez: ");
                    nomMedecin = this.entreeUtilisateur.nextLine();
                    try {
                        hopital.getMedecin(nomMedecin);
                        System.out.println("Le médecin '" + nomMedecin + "' existe.");
                    }
                    catch (NullPointerException e) {
                        System.out.println("Le médecin n'existe pas");
                    }

                case "supprimerMedecin":
                    System.out.println ("Entrer le nom de medecin");
                    this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
                    try {
                        this.hopital.supprimerMedecin (this.hopital.getMedecin (this.chaineEntreeUtilisateur));
                    }
                    catch (NullPointerException e) {
                        System.out.println ("Le médecin n'existe pas");
                    }
                    break;

                case "ajouterServiceMedical":
                    String typeSM = "";
                    while (!typeSM.equals("q") && !typeSM.equals("c")) {
                        System.out.println ("Voulez-vous que votre système médical soit une crypte ou un centre de quarantaine? Tapez c pour la première option et q pour la deuxième.");
                        typeSM = this.entreeUtilisateur.nextLine();
                    }
                    System.out.println("Entrer le nom du nouveau service médical");
                    this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
                    System.out.println("Entrez la superficie:");
                    int superficie = this.entreeUtilisateur.nextInt();
                    System.out.println("Entrez le nombre de créatures max:");
                    int nbCreaturesMax = this.entreeUtilisateur.nextInt();
                    try {
                        if (typeSM.equals ("c")) {
                            hopital.ajouterServiceMedical(new Crypte(this.chaineEntreeUtilisateur, superficie, nbCreaturesMax));
                        }
                        else {
                            hopital.ajouterServiceMedical(new CentreQuarantaine(this.chaineEntreeUtilisateur, superficie, nbCreaturesMax));
                        }
                    }
                    catch (TropDeServicesMedicauxException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case "chercherServiceMedical":
                    System.out.println ("Entrer le nom du service médical que vous cherchez: ");
                    this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
                    ServiceMedical serviceMedical = hopital.getServiceMedical(this.chaineEntreeUtilisateur);
                    System.out.println("Le service médical " + serviceMedical.getNom () + " existe.");
                    if (serviceMedical == null) {
                        throw new NullPointerListeServicesMedicauxException();
                    }

                case "supprimerServiceMedical":
                    System.out.println ("Entrer le nom du service médical à supprimer");
                    this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
                    try {
                        hopital.supprimerServiceMedical(hopital.getServiceMedical(this.chaineEntreeUtilisateur));
                    }
                    catch (NullPointerListeServicesMedicauxException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "afficherCreatures":
                    hopital.afficherCreatures();
                    break;

                case "compterCreatures":
                    int nbCreatures = hopital.connaitreNombreCreatures();
                    System.out.println("Il y a " + nbCreatures + " créatures dans l'hôpital");

                case "examinerServiceMedical":
                    System.out.println ("Entrer le nom de médecin qui examine le service médical:");
                    String medecinExamen = this.entreeUtilisateur.nextLine();
                    System.out.println ("Choississez le service médical à examiner");
                    String serviceMedicalExamen = this.entreeUtilisateur.nextLine();
                    hopital.examinerServiceMedical(hopital.getMedecin(medecinExamen), hopital.getServiceMedical (serviceMedicalExamen));
                    break;

                case "quitter":
                    quitter = true;
                    break;
                default:
                    throw new MauvaiseEntreeException();
            }
        }
        this.entreeUtilisateur.close();
    }

    /***/
    public static MenuHopital getInstanceMenuHopital() {
        if (instanceMenuHopital == null) {
            instanceMenuHopital = new MenuHopital();
        }
        return instanceMenuHopital;
    }
}


package menu;

import hopital.Hopital;
import hopital.NullPointerListeServicesMedicauxException;
import hopital.TropDeServicesMedicauxException;
import medecins.Medecin;
import serviceMedical.CentreQuarantaine;
import serviceMedical.Crypte;
import serviceMedical.ServiceMedical;

import java.util.Scanner;

/**
 * Classe qui permet d'afficher le menu pour les hôpitaux
 * @see MenuInterface
 */
public class MenuHopital implements MenuInterface {

    private static MenuHopital instanceMenuHopital;

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
    private MenuHopital() {
        this.hopital = Hopital.getInstance();
        this.entreeUtilisateur = new Scanner(System.in);
        this.chaineEntreeUtilisateur = "";
    }

    /**
     * Affiche le menu principal de l'hôpital
     * @throws MauvaiseEntreeException
     * @throws NullPointerListeServicesMedicauxException
     * @throws TropDeServicesMedicauxException
     */
    @Override
    public void afficherMenu() throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, TropDeServicesMedicauxException {
        System.out.println("Vous êtes dans le menu de l'hôpital. Veuillez faire un choix:");
        menuDeChoix();
    }

    /**
     * Affiche les choix du menu et traite les entrées utilisateur
     * @throws MauvaiseEntreeException
     * @throws NullPointerListeServicesMedicauxException
     * @throws TropDeServicesMedicauxException
     */
    @Override
    public void menuDeChoix() throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, TropDeServicesMedicauxException {
        boolean quitter = false;
        while (!quitter) {
            System.out.println("Choisissez une option dans le menu principal:");
            System.out.println("1. Modifier le nom de l'hôpital");
            System.out.println("2. Modifier le nombre maximum de services médicaux");
            System.out.println("3. Ajouter un médecin");
            System.out.println("4. Chercher un médecin");
            System.out.println("5. Supprimer un médecin");
            System.out.println("6. Ajouter un service médical");
            System.out.println("7. Chercher un service médical");
            System.out.println("8. Supprimer un service médical");
            System.out.println("9. Afficher les créatures");
            System.out.println("10. Compter les créatures");
            System.out.println("11. Examiner un service médical");
            System.out.println("12. Quitter");

            this.chaineEntreeUtilisateur = entreeUtilisateur.nextLine();
            switch (this.chaineEntreeUtilisateur) {
                case "1":
                    modifierNomHopital();
                    break;
                case "2":
                    modifierNombreMaximumDeServicesMedicaux();
                    break;
                case "3":
                    ajouterMedecin();
                    break;
                case "4":
                    chercherMedecin();
                    break;
                case "5":
                    supprimerMedecin();
                    break;
                case "6":
                    ajouterServiceMedical();
                    break;
                case "7":
                    chercherServiceMedical();
                    break;
                case "8":
                    supprimerServiceMedical();
                    break;
                case "9":
                    afficherCreatures();
                    break;
                case "10":
                    compterCreatures();
                    break;
                case "11":
                    examinerServiceMedical();
                    break;
                case "12":
                    quitter = true;
                    break;
                default:
                    System.out.println("Entrée incorrecte. Veuillez réessayer.");
            }
        }
        entreeUtilisateur.close();
    }

    private void modifierNomHopital() {
        System.out.println("Entrer le nouveau nom de l'hôpital:");
        this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
        this.hopital.setNom(this.chaineEntreeUtilisateur);
        System.out.println("Nom de l'hôpital modifié avec succès.");
    }

    private void modifierNombreMaximumDeServicesMedicaux() {
        System.out.println("Entrer le nouveau nombre maximum de services médicaux:");
        int nbServicesMedicauxMax = this.entreeUtilisateur.nextInt();
        this.entreeUtilisateur.nextLine(); // Consommer la nouvelle ligne
        this.hopital.setNbServicesMedicauxMax(nbServicesMedicauxMax);
        System.out.println("Nombre maximum de services médicaux modifié avec succès.");
    }

    private void ajouterMedecin() {
        System.out.println("Entrer le nom du médecin:");
        String nomMedecin = this.entreeUtilisateur.nextLine();
        System.out.println("Entrer l'âge du médecin:");
        int ageMedecin = this.entreeUtilisateur.nextInt();
        this.entreeUtilisateur.nextLine(); // Consommer la nouvelle ligne
        System.out.println("Entrer le sexe du médecin:");
        String sexeMedecin = this.entreeUtilisateur.nextLine();
        this.hopital.ajouterMedecin(new Medecin(nomMedecin, sexeMedecin, ageMedecin));
        System.out.println("Médecin ajouté avec succès.");
    }

    private void chercherMedecin() {
        System.out.println("Entrer le nom du médecin que vous cherchez:");
        String nomMedecin = this.entreeUtilisateur.nextLine();
        try {
            Medecin medecin = this.hopital.getMedecin(nomMedecin);
            System.out.println("Le médecin '" + nomMedecin + "' existe.");
        } catch (NullPointerException e) {
            System.out.println("Le médecin n'existe pas.");
        }
    }

    private void supprimerMedecin() {
        System.out.println("Entrer le nom du médecin à supprimer:");
        String nomMedecin = this.entreeUtilisateur.nextLine();
        try {
            this.hopital.supprimerMedecin(this.hopital.getMedecin(nomMedecin));
            System.out.println("Médecin supprimé avec succès.");
        } catch (NullPointerException e) {
            System.out.println("Le médecin n'existe pas.");
        }
    }

    private void ajouterServiceMedical() {
        String typeSM = "";
        while (!typeSM.equals("c") && !typeSM.equals("q")) {
            System.out.println("Voulez-vous que votre service médical soit une crypte ou un centre de quarantaine? Tapez 'c' pour la première option et 'q' pour la deuxième.");
            typeSM = this.entreeUtilisateur.nextLine();
        }
        System.out.println("Entrer le nom du nouveau service médical:");
        String nomService = this.entreeUtilisateur.nextLine();
        System.out.println("Entrer la superficie:");
        int superficie = this.entreeUtilisateur.nextInt();
        System.out.println("Entrer le nombre de créatures max:");
        int nbCreaturesMax = this.entreeUtilisateur.nextInt();
        this.entreeUtilisateur.nextLine(); // Consommer la nouvelle ligne
        try {
            if (typeSM.equals("c")) {
                this.hopital.ajouterServiceMedical(new Crypte(nomService, superficie, nbCreaturesMax));
            } else {
                this.hopital.ajouterServiceMedical(new CentreQuarantaine(nomService, superficie, nbCreaturesMax));
            }
            System.out.println("Service médical ajouté avec succès.");
        } catch (TropDeServicesMedicauxException e) {
            System.out.println(e.getMessage());
        }
    }

    private void chercherServiceMedical() {
        System.out.println("Entrer le nom du service médical que vous cherchez:");
        String nomService = this.entreeUtilisateur.nextLine();
        ServiceMedical serviceMedical = this.hopital.getServiceMedical(nomService);
        if (serviceMedical != null) {
            System.out.println("Le service médical '" + nomService + "' existe.");
        } else {
            System.out.println("Le service médical n'existe pas.");
        }
    }

    private void supprimerServiceMedical() {
        System.out.println("Entrer le nom du service médical à supprimer:");
        String nomService = this.entreeUtilisateur.nextLine();
        try {
            this.hopital.supprimerServiceMedical(this.hopital.getServiceMedical(nomService));
            System.out.println("Service médical supprimé avec succès.");
        } catch (NullPointerListeServicesMedicauxException e) {
            System.out.println(e.getMessage());
        }
    }

    private void afficherCreatures() {
        this.hopital.afficherCreatures();
    }

    private void compterCreatures() {
        int nbCreatures = this.hopital.connaitreNombreCreatures();
        System.out.println("Il y a " + nbCreatures + " créatures dans l'hôpital.");
    }

    private void examinerServiceMedical() {
        System.out.println("Entrer le nom du médecin qui examine le service médical:");
        String medecinExamen = this.entreeUtilisateur.nextLine();
        System.out.println("Choisissez le service médical à examiner:");
        String serviceMedicalExamen = this.entreeUtilisateur.nextLine();
        this.hopital.examinerServiceMedical(this.hopital.getMedecin(medecinExamen), this.hopital.getServiceMedical(serviceMedicalExamen));
        System.out.println("Examen du service médical effectué avec succès.");
    }

    /**
     * Retourne l'instance unique de MenuHopital
     * @return instanceMenuHopital
     */
    public static MenuHopital getInstanceMenuHopital() {
        if (instanceMenuHopital == null) {
            instanceMenuHopital = new MenuHopital();
        }
        return instanceMenuHopital;
    }
}

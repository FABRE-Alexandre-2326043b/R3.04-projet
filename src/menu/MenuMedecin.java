
package menu;

import hopital.Hopital;
import medecins.Medecin;

import java.util.Scanner;

/**
 * Classe qui permet d'afficher le menu pour les médecins
 * @see MenuInterface
 */
public class MenuMedecin implements MenuInterface {

    private Medecin medecinSelectionne;

    private static MenuMedecin instanceMenuMedecin;

    /**
     * Entrée utilisateur. C'est cette variable de type Scanner qui lira les entrées de l'utilisateur
     */
    private Scanner entreeUtilisateur;

    /**
     * Chaine qui réceptionne l'entrée de l'utilisateur.
     */
    private String chaineEntreeUtilisateur;

    /**
     * Instance de l'hôpital utilisé dans le modèle Singleton
     */
    private Hopital hopital;

    // Constructeur

    /**
     * Constructeur privé pour le singleton
     */
    private MenuMedecin() {
        this.hopital = Hopital.getInstance();
        this.entreeUtilisateur = new Scanner(System.in);
        this.chaineEntreeUtilisateur = "";
    }

    /**
     * Sélectionne un médecin en fonction de l'entrée utilisateur
     */
    public void selectionMedecin() {
        System.out.println("Vous devez choisir un médecin. Entrez son nom:");
        this.chaineEntreeUtilisateur = this.entreeUtilisateur.nextLine();
        this.medecinSelectionne = this.hopital.getMedecin(this.chaineEntreeUtilisateur);
        if (this.medecinSelectionne == null) {
            System.out.println("Médecin non trouvé. Veuillez réessayer.");
            selectionMedecin();
        }
    }

    /**
     * Affiche le menu principal des médecins
     * @throws MauvaiseEntreeException
     */
    @Override
    public void afficherMenu() throws MauvaiseEntreeException {
        System.out.println("Vous êtes dans le menu de configuration des médecins. Veuillez faire un choix:");
        selectionMedecin();
        menuDeChoix();
    }

    /**
     * Affiche les choix du menu et traite les entrées utilisateur
     * @throws MauvaiseEntreeException
     */
    @Override
    public void menuDeChoix() throws MauvaiseEntreeException {
        boolean quitter = false;
        while (!quitter) {
            System.out.println("Choisissez une option dans le menu principal:");
            System.out.println("1. Modifier le nom du médecin");
            System.out.println("2. Modifier l'âge du médecin");
            System.out.println("3. Modifier le sexe du médecin");
            System.out.println("4. Quitter");

            this.chaineEntreeUtilisateur = entreeUtilisateur.nextLine();
            switch (this.chaineEntreeUtilisateur) {
                case "1":
                    modifierNom();
                    break;
                case "2":
                    modifierAge();
                    break;
                case "3":
                    modifierSexe();
                    break;
                case "4":
                    quitter = true;
                    break;
                default:
                    System.out.println("Entrée incorrecte. Veuillez réessayer.");
            }
        }
        this.entreeUtilisateur.close();
    }

    private void modifierNom() {
        System.out.println("Entrer le nouveau nom du médecin:");
        this.chaineEntreeUtilisateur = entreeUtilisateur.nextLine();
        medecinSelectionne.setNom(this.chaineEntreeUtilisateur);
        System.out.println("Nom du médecin modifié avec succès.");
    }

    private void modifierAge() {
        System.out.println("Entrer l'âge du médecin:");
        int ageMedecin = entreeUtilisateur.nextInt();
        entreeUtilisateur.nextLine(); // Consommer la nouvelle ligne
        medecinSelectionne.setAge(ageMedecin);
        System.out.println("Âge du médecin modifié avec succès.");
    }

    private void modifierSexe() {
        System.out.println("Entrer le sexe du médecin:");
        this.chaineEntreeUtilisateur = entreeUtilisateur.nextLine();
        medecinSelectionne.setSexe(this.chaineEntreeUtilisateur);
        System.out.println("Sexe du médecin modifié avec succès.");
    }

    /**
     * Retourne l'instance unique de MenuMedecin
     * @return instanceMenuMedecin
     */
    public static MenuMedecin getInstanceMenuMedecin() {
        if (instanceMenuMedecin == null) {
            instanceMenuMedecin = new MenuMedecin();
        }
        return instanceMenuMedecin;
    }
}

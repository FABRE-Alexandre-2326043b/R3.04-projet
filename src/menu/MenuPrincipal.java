package menu;

import hopital.Hopital;
import hopital.NullPointerListeServicesMedicauxException;
import hopital.TropDeServicesMedicauxException;
import maladies.ErreurChangementNiveauException;
import serviceMedical.TropDeCreaturesException;

import java.util.Scanner;

/**
 * Menu principal qui implémente l'interface MenuInterface
 * @see MenuInterface
 * */
public class MenuPrincipal implements MenuInterface {
	/**
	 * Variable statique de l'instance du menu principal
	 * */
	private static MenuPrincipal instanceMenuPrincipal;

	/**
	 * Entrée utilisateur. C'est cette variable de type Scanner qui lira les entrées de l'utilisateur
	 * */
	private Scanner entreeUtilisateur;

	/**
	 * Chaine qui réceptionne l'entrée de l'utilisateur.
	 * */
	private String chaineEntreeUtilisateur;

	//Constructeur
	private MenuPrincipal() {
		entreeUtilisateur = new Scanner(System.in);
		this.chaineEntreeUtilisateur = "";
	}

	/**
	 *
	 */
	public void afficherMenuDemarrageApplication() {
		System.out.println("Bienvenue sur le système de gestion du menu principal. Configuration par défaut votre hôpital de base...");
		MenuHopital menuHopital = MenuHopital.getInstanceMenuHopital();
	}

	/**
	 *
	 */
	@Override
	public void afficherMenu () throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, ErreurChangementNiveauException, TropDeServicesMedicauxException, TropDeCreaturesException {
		System.out.println("Bienvenue sur le système de gestion du menu principal:");
		this.chaineEntreeUtilisateur = entreeUtilisateur.next();
		menuDeChoix();
	}

	/**
	 *
	 */
	@Override
	public void menuDeChoix () throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, ErreurChangementNiveauException, TropDeServicesMedicauxException, TropDeCreaturesException {
		boolean quitter = false;
		while (!quitter) {
			System.out.println("Choisissez votre choix dans le menu principal:");
			this.chaineEntreeUtilisateur = entreeUtilisateur.next();
			switch (this.chaineEntreeUtilisateur) {
				case "hopital":
					MenuHopital menuHopital = MenuHopital.getInstanceMenuHopital();
					menuHopital.afficherMenu();
					break;
				case "maladie":
					MenuMaladie menuMaladie = MenuMaladie.getInstanceMenuMaladie();
					menuMaladie.afficherMenu();
					break;
				case "medecin":
					MenuMedecin menuMedecin = MenuMedecin.getInstanceMenuMedecin();
					menuMedecin.afficherMenu();
					break;
				case "serviceMedical":
					MenuServiceMedical menuServiceMedical = MenuServiceMedical.getInstanceMenuServiceMedical();
					menuServiceMedical.afficherMenu();
					break;
				case "creature":
					MenuCreatures menuCreatures = MenuCreatures.getInstanceMenuCreatures();
					menuCreatures.afficherMenu();
				case "quitter":
					quitter = true;
					break;
				default:
					throw new MauvaiseEntreeException();
			}
		}
		entreeUtilisateur.close();
	}

	/**
	 * Renvoie une instance du menu principal
	 * @return MenuPrincipal: instance du menu principal
	 * */
	public static MenuPrincipal getInstanceMenuPrincipal() {
		if (instanceMenuPrincipal == null) {
			instanceMenuPrincipal = new MenuPrincipal();
		}
		return instanceMenuPrincipal;
	}


}

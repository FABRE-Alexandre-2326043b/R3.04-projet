package hopital;

import maladies.ErreurChangementNiveauException;
import menu.*;
import serviceMedical.TropDeCreaturesException;

/**
 * Classe pricipale du programme
 * Elle permet d'exécuter l'application
 * */
public class Main implements Runnable {

	/**
	 * Permet de gérer les threads
	 * @see Runnable
	 */
	@Override
	public void run () {

	}

	//main

	/**
	 * Programme principale main() qui permet l'exécution du programme
	 * @param args String[] arguments de la fonction main
	 * */
	public static void main(String[] args) throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, ErreurChangementNiveauException, TropDeServicesMedicauxException, TropDeCreaturesException {
		MenuPrincipal menuPrincipal = MenuPrincipal.getInstanceMenuPrincipal();
		menuPrincipal.afficherMenuDemarrageApplication();
		System.out.println("Configuration initiale terminée!");
		menuPrincipal.afficherMenu();
		System.out.println("Merci d'avoir utilisé le logiciel de gestion de l'hôpital fantastique.");
	}
}

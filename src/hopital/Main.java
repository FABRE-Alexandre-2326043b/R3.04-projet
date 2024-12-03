package hopital;

import menu.*;

/**
 * Classe pricipale du programme
 * Elle permet d'exécuter l'application
 * */
public class Main implements Runnable {
	/**
	 *
	 */
	@Override
	public void run () {

	}

	//main

	/**
	 * Programme principale main() qui permet l'exécution du programme
	 * @param args String[] arguments de la fonction main
	 * */
	public static void main(String[] args) throws MauvaiseEntreeException {
		MenuPrincipal menuPrincipal = MenuPrincipal.getInstanceMenuPrincipal();
		menuPrincipal.afficherMenuDemarrageApplication();
		System.out.println("Vous avez configuré votre hôpital, vous pouvez commencez.");
		menuPrincipal.afficherMenu();
		System.out.println("Merci d'avoir utilisé le logiciel de gestion de l'hôpital fantastique.");
	}
}

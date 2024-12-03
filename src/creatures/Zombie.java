package creatures;

import java.util.ArrayList;

import maladies.Maladie;

public class Zombie extends Creature {
	public Zombie(String nomComplet, String sexe, int poids, int taille, int age, int indicateurMoral,
			ArrayList<Maladie> listeMaladies) {
		super(nomComplet, sexe, poids, taille, age, listeMaladies);
	}

	public void trépasser() {
        System.out.println(nomComplet + "trépasse");
        System.out.println(nomComplet + "régénère");
	}	
	
	public void attendre() {
		if (representants) {
			indicateurMoral-=0.5;
		}
	}
}

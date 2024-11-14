package creatures;

import java.util.ArrayList;

import maladies.Maladie;

public class Lycanthrope extends CreatureBestiale {
	public boolean representants;

	public Lycanthrope(String nomComplet, String sexe, int poids, int taille, int age, int indicateurMoral,
			ArrayList<Maladie> listeMaladies) {
		super(nomComplet, sexe, poids, taille, age, listeMaladies);
	}
	
	public void attendre() {
		if (representants) {
			indicateurMoral-=0.5;
		}
	}
}

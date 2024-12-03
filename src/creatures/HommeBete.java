package creatures;

import java.util.ArrayList;

import maladies.Maladie;

public class HommeBete extends CreatureBestiale{
	public HommeBete(String nomComplet, String sexe, int poids, int taille, int age, ArrayList<Maladie> listeMaladies) {
		super(nomComplet, sexe, poids, taille, age, listeMaladies);
	}
	
	public void attendre() {
		if (representants) {
			indicateurMoral-=0.5;
		}
	}
}

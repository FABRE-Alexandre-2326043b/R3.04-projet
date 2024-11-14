package creatures;

import java.util.ArrayList;

import maladies.Maladie;

public class Vampire extends CreatureBestiale{
	public Vampire(String nomComplet, String sexe, int poids, int taille, int age,
			ArrayList<Maladie> listeMaladies) {
		super(nomComplet, sexe, poids, taille, age, listeMaladies);
		indicateurMoral=50;
	}

	public void trépasser() {
        System.out.println(nomComplet + "trépasse");
        System.out.println(nomComplet + "régénère");
	}
}

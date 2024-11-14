package creatures;

import java.util.ArrayList;

import maladies.Maladie;

public class Nain  extends Creature{

	public Nain(String nomComplet, String sexe, int poids, int taille, int age, int indicateurMoral,
			ArrayList<Maladie> listeMaladies) {
		super(nomComplet, sexe, poids, taille, age, listeMaladies);
		indicateurMoral=50;
	}

}

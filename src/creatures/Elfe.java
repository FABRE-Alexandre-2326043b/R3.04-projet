package creatures;

import java.util.ArrayList;

import maladies.Maladie;

public class Elfe extends Creature{
	public Elfe(String nomComplet, String sexe, int poids, int taille, int age, ArrayList<Maladie> listeMaladies) {
		super(nomComplet, sexe, poids, taille, age, listeMaladies);
		indicateurMoral=50;
	}

	public void trepasser(Creature creature) {
        System.out.println(nomComplet + "trépasse");
		creature.etreDemoralise();
	}
}

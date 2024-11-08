package creatures;

import java.util.ArrayList;

import maladies.Maladie;

public class CreatureBestiale extends Creature {
	public CreatureBestiale(String nomComplet, String sexe, int poids, int taille, int age,
			ArrayList<Maladie> listeMaladies) {
		super(nomComplet, sexe, poids, taille, age, listeMaladies);
		// TODO Auto-generated constructor stub
	}

	public void contaminer(Creature creature) {
		creature.tomberMalade(listeMaladies.get((int)(Math.random()*listeMaladies.size())));
	}
}

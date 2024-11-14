package serviceMedical;

import java.util.ArrayList;
import java.util.Arrays;

import creatures.Creature;
import maladies.Maladie;

public class ServiceMedical {
	public String nom;
	public int superficie;
	public int nbCreaturesMax;
	public int nbCreatures;
	public ArrayList<Creature> listeCreatures;
	public String budget;
	
	public void afficherCaractéristiquesCreatures() {
		System.out.println("Nom : " + nom);
		System.out.println("Superficie : " + superficie);
		System.out.println("Nombres de créatures/maximum" + nbCreaturesMax + "/" + nbCreatures);
		System.out.println("Créatures présentes :");
		for (int i=0; i<nbCreatures;++i) {
			listeCreatures.get(i).afficherCaractéristiques();
		}
		System.out.println("Budget : " + budget);
	}
	
	public void ajouterCreature(Creature creature) {
		listeCreatures.add(creature);
		if (Arrays.asList("Orque","HommeBete","Lycanthrope","Vampire").contains(creature.getClass().getSimpleName())) {
			creature.setRepresentants(true);
		}
	}
	
	public void retirerCreature(Creature creature) {
		listeCreatures.remove(creature);
	}
	
	public void soignerCreature(Creature creature, Maladie maladie) {
		creature.etreSoigne(maladie);
	}
	
	public void reviserBudget() {
		int place = nbCreatures/nbCreaturesMax;
		if(place == 0.0) {
			budget="inexistant";
		}else if(place < 0.16) {
			budget="insuffisant";
		}else if(place < 0.33) {
			budget="faible";
		}else if(place < 0.5) {
			budget="médiocre";
		}else if(place < 0.66) {
			budget="bien";
		}else if(place < 0.83) {
			budget="très bien";
		}else {
			budget="excellent";
		}
	}
	
}

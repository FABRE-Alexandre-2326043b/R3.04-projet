package creatures;

import java.util.ArrayList;

import maladies.Maladie;

public class Lycanthrope extends CreatureBestiale {
	public Lycanthrope(String nomComplet, String sexe, int poids, int taille, int age, int indicateurMoral,
			ArrayList<Maladie> listeMaladies) {
		
		super(nomComplet, sexe, poids, taille, age, listeMaladies);
	}
	
	public void attendre() {
        if (indicateurMoral>0) {
            if (representants) {
                indicateurMoral-=0.5;
            }
        }else {
            hurler();
        }
    }
	
	
	
	public String afficherCaracteristiques() {
	    String caracteristiques = "Nom : " + nomComplet + "\n" +
	                              "Sexe : " + sexe + "\n" +
	                              "Poids : " + poids + " kg\n" +
	                              "Taille : " + taille + " cm\n" +
	                              "Âge : " + age + " ans\n" +
	                              "Indicateur Moral : " + indicateurMoral + "\n" +
	                              "Maladies : " + (listeMaladies.isEmpty() ? "Aucune" : listeMaladies.toString());
	    return caracteristiques;
	}

}

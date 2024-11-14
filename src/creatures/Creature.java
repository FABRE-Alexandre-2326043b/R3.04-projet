package creatures;

import java.util.ArrayList;

import maladies.Maladie;

public abstract class Creature {
    public String nomComplet ;
    public String sexe ;
    public int poids ;
    public int taille ;
    public int age ;
    public int indicateurMoral ;
    public int nbHurlements;
    public ArrayList<Maladie> listeMaladies ;
	public boolean representants;

    public Creature(String nomComplet, String sexe, int poids, int taille, int age, ArrayList<Maladie> listeMaladies) {
		super();
		this.nomComplet = nomComplet;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
		this.indicateurMoral = 50;
		this.nbHurlements = 0;
		this.listeMaladies = listeMaladies;
	}
    
    public ArrayList<Maladie> getListeMaladies() {
		return listeMaladies;
	}
    
	public void setRepresentants(boolean representants) {
		this.representants = representants;
	}

	public void attendre () {
    	if (indicateurMoral>0) {
    		indicateurMoral-=1;
    	}else {
    		hurler();
    	}        
    }
	
	public void hurler () {
        System.out.println(nomComplet + " hurle");
        nbHurlements+=1;
        if (nbHurlements>5){
        	sEmporter();
        }
    }
	
    public void sEmporter (){
        System.out.println(nomComplet + " s'emporte");
        
    }
    
    public void tomberMalade (Maladie maladie){
        System.out.println(nomComplet + " tombe malade de " + maladie.getNomComplet());
        listeMaladies.add(maladie);
    }
    
    public void etreSoigne (Maladie maladie) {
        System.out.println(nomComplet + "est guéri de " + maladie.getNomComplet());
        listeMaladies.remove(maladie);
    }
    
    public void trepasser(){
        System.out.println(nomComplet + "trépasse");
    }
    
	public void etreDemoralise() {
        indicateurMoral-=5;
	}
	
	public void afficherCaractéristiques() {
		System.out.println();
		System.out.print("Nom complet : " + nomComplet);
		System.out.print("Sexe : " + sexe);
		System.out.print("Poids : " + poids);
		System.out.print("Taille : " + taille);
		System.out.print("Âge : " + age);
		System.out.print("Indiacteur de moral : " + indicateurMoral);
		System.out.print("Liste de maladies : " + listeMaladies);
	}
}

package creatures;

import java.util.ArrayList;
import maladies.Maladie;
/**
 * Classe abstraite représentant une créature quelconque. Elle permet de décrire le fonctionnement basique d'une créature.
 * Une créature possède un nom complet, un sexe, un poids, une taille, un âge et une liste de maladies
 * Une créature possède un indicateur de moral qui indique le moral de la créature. Plus l'indicateur est haut, plus la créature peut attendre longtemps. 
 * Si cet indicateur est nul, la créature hurle.
 * Si une créature hurle 5 fois de suite, elle s'emporte et a de bonnes chances de contaminer une autre créature.
 * */
public abstract class Creature {
	/**
	 * Nom complet de la créature
	 */
    public String nomComplet;
    /**
     * Sexe de la créature
     */
    public String sexe;
    /**
     * Poids de la créature en kg
     */
    public int poids;
    /**
     * Taille de la créature en cm
     */
    public int taille;
    /**
     * Âge de la créature en années
     */
    public int age;
    /**
     * Indicateur de moral de la créature
     * @value 100:int par défaut
     */
    public int indicateurMoral;
    /**
     * Nombre de hurlements de la créature   
     * @value 0:int par défaut
     */
    public int nbHurlements;
    /**
     * Liste des maladies de la créature
     */
    public ArrayList<Maladie> listeMaladies;
    /**
     * Présence ou absence de représentants de l'espèce de la créature dans son service médical
     * pour que les orques, homme-bêtes, zombies et lycanthropes attendent plus patiemment si oui
     */
	public boolean representants;

	/**
	 * Constructeur de la classe créature non-effective.<br>
	 * Elle permet d'attribuer les valeurs des paramètres à tout type de créature,
	 * avec un indicateur de moral de la créature à 100 et un nombre de hurlements de la créature à 0, 
	 * c'est-à-dire que la la créature peut attendre longtemps 
	 * et l'attribut representants à false, ce qui veut dire que la créature n'attend pas plus patiemment.
	 * @param nomComplet String: nom complet de la créature
	 * @param sexe String: sexe de la créature
	 * @param poids int: poids de la créature
	 * @param taille int: taille de la créature
	 * @param age int: âge de la créature
	 * @param listeMaladies ArrayList<Maladie>: liste des maladies de la créature
	 * */
    public Creature(String nomComplet, String sexe, int poids, int taille, int age, ArrayList<Maladie> listeMaladies) {
		super();
		this.nomComplet = nomComplet;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
		this.indicateurMoral = 100;
		this.nbHurlements = 0;
		this.listeMaladies = listeMaladies;
		this.representants = false;
	}
    
    //Getters/Setters
	/**
	 * Renvoie la liste des maladies de la créature
	 * @return listeMaladies String: Liste des maladies de la créature sous forme d'ArrayList<Maladie>
	 * */
    public ArrayList<Maladie> getListeMaladies() {
		return listeMaladies;
	}
    
    /**
	 * Renvoie la présence ou absence de représentants de l'espèce de la créature dans son service médical
	 * @return representants boolean: présence ou absence de représentants de l'espèce de la créature dans son service médical sous forme de boolean
	 * */
	public void setRepresentants(boolean representants) {
		this.representants = representants;
	}

	/**
	 * Permet de baisser l'indicateur de moral d'une créature
	 * Appelle hurler() s'il est à 0 
	 */
	public void attendre () {
    	if (indicateurMoral>0) {
    		indicateurMoral-=1;
    	}else {
    		hurler();
    	}        
    }
	
	/**
	 * Permet à la créature de hurler
	 * Appelle sEmporter() après 5 hurlements successifs
	 */
	public void hurler () {
        System.out.println(nomComplet + " hurle");
        nbHurlements+=1;
        if (nbHurlements>5){
        	sEmporter();
        }
    }
	
	/**
	 * Permet à la créature de s'emporter
	 */
    public void sEmporter (){
        System.out.println(nomComplet + " s'emporte");
        
    }
    
    /**
     * Permet à la créature de tomber malade en ajoutant une maladie spécifiée en paramètre à listeMaladies
     * @param maladie: La maladie à ajouter à listeMaladies
     */
    public void tomberMalade (Maladie maladie){
        System.out.println(nomComplet + " tombe malade de " + maladie.getNomComplet());
        listeMaladies.add(maladie);
    }
    
    /**
     * Permet à la créature d'être soignée en enlevant une maladie spécifiée en paramètre à listeMaladies
     * @param maladie: La maladie à retirer à listeMaladies
     */
    public void etreSoigne (Maladie maladie) {
        System.out.println(nomComplet + " est guéri de " + maladie.getNomComplet());
        listeMaladies.remove(maladie);
        indicateurMoral += 30;
        nbHurlements = 0;
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
		System.out.print(", Sexe : " + sexe);
		System.out.print(", Poids : " + poids);
		System.out.print(" kg, Taille : " + taille);
		System.out.print(" cm, Âge : " + age);
		System.out.print(" ans, Indicateur de moral : " + indicateurMoral);
		System.out.print("%, Liste de maladies : [");
		for (Maladie maladie : listeMaladies) {
			System.out.print(maladie.getNomAbrege());
			if (!listeMaladies.get(listeMaladies.size() - 1).equals(maladie)) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIndicateurMoral() {
		return indicateurMoral;
	}

	public void setIndicateurMoral(int indicateurMoral) {
		this.indicateurMoral = indicateurMoral;
	}

	public int getNbHurlements() {
		return nbHurlements;
	}

	public void setNbHurlements(int nbHurlements) {
		this.nbHurlements = nbHurlements;
	}

	public boolean isRepresentants() {
		return representants;
	}

	public void setListeMaladies(ArrayList<Maladie> listeMaladies) {
		this.listeMaladies = listeMaladies;
	}
	
	
	
}

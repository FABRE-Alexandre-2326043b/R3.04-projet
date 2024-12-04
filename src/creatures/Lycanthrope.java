package creatures;

import java.util.ArrayList;
import java.util.List;
import maladies.Maladie;

/**
 * Représente un lycanthrope avec ses caractéristiques et ses interactions dans une meute.
 */
public class Lycanthrope {
    public String getNomComplet() {
		return nomComplet;
	}

    
	private String nomComplet;
    private String sexe;
    private int poids;
    private int taille;
    private int age;
    private double indicateurMoral;
    private List<Maladie> listeMaladies;
    private String categorieAge;
    private int force;
    private int facteurDomination;
    private String rang;
    private int niveau;
    private double facteurImpétuosité;
    private Meute meute;

    /**
     * Constructeur pour créer un lycanthrope.
     * 
     * @param nomComplet        Nom complet du lycanthrope.
     * @param sexe              Sexe du lycanthrope (M/F).
     * @param poids             Poids du lycanthrope en kg.
     * @param taille            Taille du lycanthrope en cm.
     * @param age               Âge du lycanthrope en années.
     * @param indicateurMoral   Moral du lycanthrope.
     * @param listeMaladies     Liste des maladies du lycanthrope.
     * @param categorieAge      Catégorie d'âge (jeune, adulte, vieux).
     * @param force             Force physique du lycanthrope.
     * @param facteurDomination Facteur de domination.
     * @param rang              Rang dans la hiérarchie.
     * @param niveau            Niveau global du lycanthrope.
     * @param facteurImpétuosité Facteur d'impétuosité.
     * @param meute             Meute à laquelle le lycanthrope appartient (ou null s'il est solitaire).
     */
    public Lycanthrope(String nomComplet, String sexe, int poids, int taille, int age, double indicateurMoral,
                       List<Maladie> listeMaladies, String categorieAge, int force, int facteurDomination,
                       String rang, int niveau, double facteurImpétuosité, Meute meute) {
        this.nomComplet = nomComplet;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.indicateurMoral = indicateurMoral;
        this.listeMaladies = listeMaladies != null ? listeMaladies : new ArrayList<>();
        this.categorieAge = categorieAge;
        this.force = force;
        this.facteurDomination = facteurDomination;
        this.rang = rang;
        this.niveau = niveau;
        this.facteurImpétuosité = facteurImpétuosité;
        this.meute = meute;
    }

    /**
     * Fait hurler le lycanthrope.
     */
    public void hurler() {
        System.out.println(nomComplet + " hurle pour exprimer sa présence.");
        if (meute != null) {
            meute.reagirHurlement(this);
        }
    }

    /**
     * Permet au lycanthrope d'entendre un hurlement.
     * 
     * @param hurlement Le hurlement entendu.
     */
    public void entendreHurlement(Hurlement hurlement) {
        if (!estTropMalade()) {
            System.out.println(nomComplet + " entend le hurlement : " + hurlement.getType());
        }
    }

    /**
     * Vérifie si le lycanthrope est trop malade pour continuer à interagir normalement.
     * 
     * @return true si au moins une maladie est létale, sinon false.
     */
    public boolean estTropMalade() {
        return listeMaladies.stream().anyMatch(maladie -> maladie.estLetal());
    }


    /**
     * Fait quitter la meute au lycanthrope.
     */
    public void quitterMeute() {
        if (meute != null) {
            meute.retirerLycanthrope(this);
            meute = null;
            System.out.println(nomComplet + " a quitté la meute.");
        }
    }

    /**
     * Transforme le lycanthrope en humain s'il remplit les conditions.
     */
    public void seTransformerEnHumain() {
        if (niveau > 50) {
            System.out.println(nomComplet + " se transforme en humain et quitte la colonie.");
            quitterMeute();
        }
    }

    /**
     * Affiche les caractéristiques détaillées du lycanthrope.
     * 
     * @return Une chaîne de caractères représentant les caractéristiques.
     */
    public String afficherCaracteristiques() {
        return "Nom : " + nomComplet + "\n" +
               "Sexe : " + sexe + "\n" +
               "Poids : " + poids + " kg\n" +
               "Taille : " + taille + " cm\n" +
               "Âge : " + age + " ans\n" +
               "Catégorie d'âge : " + categorieAge + "\n" +
               "Force : " + force + "\n" +
               "Facteur Domination : " + facteurDomination + "\n" +
               "Rang : " + rang + "\n" +
               "Niveau : " + niveau + "\n" +
               "Moral : " + indicateurMoral + "\n" +
               "Meute : " + (meute != null ? "Partie d'une meute" : "Solitaires") + "\n" +
               "Maladies : " + (listeMaladies.isEmpty() ? "Aucune" : listeMaladies.toString());
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

	public double getIndicateurMoral() {
		return indicateurMoral;
	}

	public void setIndicateurMoral(double indicateurMoral) {
		this.indicateurMoral = indicateurMoral;
	}

	public List<Maladie> getListeMaladies() {
		return listeMaladies;
	}

	public void setListeMaladies(List<Maladie> listeMaladies) {
		this.listeMaladies = listeMaladies;
	}

	public String getCategorieAge() {
		return categorieAge;
	}

	public void setCategorieAge(String categorieAge) {
		this.categorieAge = categorieAge;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getFacteurDomination() {
		return facteurDomination;
	}

	public void setFacteurDomination(int facteurDomination) {
		this.facteurDomination = facteurDomination;
	}

	public String getRang() {
		return rang;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public double getFacteurImpétuosité() {
		return facteurImpétuosité;
	}

	public void setFacteurImpétuosité(double facteurImpétuosité) {
		this.facteurImpétuosité = facteurImpétuosité;
	}

	public Meute getMeute() {
		return meute;
	}

	public void setMeute(Meute meute) {
		this.meute = meute;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
    
   
}

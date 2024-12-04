package creatures;

import java.util.ArrayList;
import java.util.List;
import maladies.Maladie;

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
    private double facteurImpetuosite;
    private Meute meute;

    public Lycanthrope(String nomComplet, String sexe, int poids, int taille, int age, double indicateurMoral,
                       List<Maladie> listeMaladies, String categorieAge, int force, int facteurDomination,
                       String rang, int niveau, double facteurImpetuosite, Meute meute) {
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
        this.facteurImpetuosite = facteurImpetuosite;
        this.meute = meute;
    }

    public void hurler() {
        System.out.println(nomComplet + " hurle pour exprimer sa présence.");
        if (meute != null) {
            meute.reagirHurlement(this);
        }
    }

    public void entendreHurlement(Hurlement hurlement) {
        if (!estTropMalade()) {
            System.out.println(nomComplet + " entend le hurlement : " + hurlement.getType());
        }
    }

    public boolean estTropMalade() {
        return listeMaladies.stream().anyMatch(maladie -> maladie.estLetal());
    }


    public void quitterMeute() {
        if (meute != null) {
            meute.retirerLycanthrope(this);
            meute = null;
            System.out.println(nomComplet + " a quitté la meute.");
        }
    }

    public void seTransformerEnHumain() {
        if (niveau > 50) {
            System.out.println(nomComplet + " se transforme en humain et quitte la colonie.");
            quitterMeute();
        }
    }

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

	public double getFacteurImpetuosite() {
		return facteurImpetuosite;
	}

	public void setFacteurImpetuosite(double facteurImpetuosite) {
		this.facteurImpetuosite = facteurImpetuosite;
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

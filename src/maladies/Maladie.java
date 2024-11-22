package maladies;


/**
 * Classe abstraite représentant une maladie quelconque. Elle permet de décrire le fonctionnement basique d'une maladie.
 * Une maladie possède un nom complet et un nom abrégé, représentant la même maladie.<br>
 * Une maladie possède un niveau qui représente la gravité actuelle de la maladie. Plus le niveau est haut, plus la maladie est grave.
 * Si ce niveau est nul, cela veut dire que la maladie ne touche aucune créature.
 * Si une maladie dépasse une certain niveau, le niveau maximum, la maladie est létale et la créature trépasse.
 * */
public abstract class Maladie {
	//Attributs
	
	/**
	 * Nom complet de la maladie
	 * */
	private String nomComplet;
	
	/**
	 * Nom abrégé de la maladie
	 * */
	private String nomAbrege;
	
	
	/**
	 * Niveau actuel de la maladie
	 * @value 0:int par défaut si non initialisation à la base
	 * */
	private int niveauActuel;
	
	/**
	 * Niveau maximum de la maladie avant trépas
	 * */
	private int niveauMaximum;
	
	//Constructeurs
	
	/**
	 * Constructeur de la classe maladie non-effective.<br>
	 * Elle permet d'attribuer les valeurs des paramètres à tout type de maladie,
	 * avec un niveau actuel à 0, c'est-à-dire que la maladie n'a pas infecté une créature.
	 * @param nomComplet String: nom complet de la maldie
	 * @param nomAbrege String: nom abrégé de la maladie
	 * @param niveauMaximum int: niveau maximum de la maladie
	 * */
	public Maladie(String nomComplet, String nomAbrege, int niveauMaximum) {
		this.nomComplet = nomComplet;
		this.nomAbrege = nomAbrege;
		this.niveauMaximum = niveauMaximum;
		this.niveauActuel = 0;
	}
	
	/**
	 * Constructeur de la classe maladie effective.<br>
	 * Elle permet d'attribuer les valeurs des paramètres à tout type de maladie.
	 * @param nomComplet String: nom complet de la maldie
	 * @param nomAbrege String: nom abrégé de la maladie
	 * @param niveauActuel int: niveau actuel de la maladie
	 * @param niveauMaximum int: niveau maximum de la maladie
	 * */
	public Maladie(String nomComplet, String nomAbrege, int niveauActuel, int niveauMaximum) {
		this(nomComplet, nomAbrege, niveauMaximum);
		this.niveauActuel = niveauActuel;
	}
	
	//Getters/Setters
	/**
	 * Renvoie le nom complet de la maladie
	 * @return nomComplet String: Nom complet de la maladie sous forme de chaîne de caractères
	 * */
    public String getNomComplet() {
        return this.nomComplet;
    }
    
    /**
     * Renvoie le nom abregé de la maladie
     * @return nomAbrege String: Nom abrégé de la maladie sous forme de chaîne de caractères
     * */
    public String getNomAbrege() {
    	return this.nomAbrege;
    }
    
    //Méthodes
    
    /**
     * Permet d'augmenter le niveau actuel de la maladie en entrant la valeur correspondante
     * @param niveau int: Le nombre de niveau à augmenter
     * */
    public void augmenterNiveauActuel(int niveau) {
    	if (this.niveauActuel + niveau < Integer.MAX_VALUE) {
    		this.niveauActuel += niveau;
    	}
    	else {
    		System.err.println("La valeur que vous avez entrée provoque un dépassement de la limite des entiers.");
    	}
    }
    
    /**
     * Permet de réduire le niveau actuel de la maladie en entrant la valeur correspondante
     * @param niveau int: Le nombre de niveau à réduire
     * */
    public void reduireNiveauActuel(int niveau) {
    	if (this.niveauActuel-niveau >= 0) {
    		this.niveauActuel -= niveau;
    	}
    	else {
    		System.err.println("La valeur que vous avez entrée est invalide.");
    	}
    }
    
    /**
     * Renvoie vrai si le niveau de la maladie est létal, faux sinon
     * @return estLetal boolean: Si le niveau actuel est supérieure ou égale au niveau maximum, la maladie est létal. Sinon, elle n'est pas létale.
     * */
    public boolean estLetal() {
    	if (this.niveauActuel >= this.niveauMaximum) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    //toString
    
    /**
     * <p>Redéfinition de la méthode <strong>toString</strong> de la classe <strong>Object</strong>.</p>
     * Renvoie une chaîne de caractères représentant les informations sur une maladie de type Maladie.
     * @return String: Chaîne de caractères représentant l'objet Maladie avec les valeurs de l'instance
     * */
    @Override
    public String toString() {
    	return "Maladie[nomComplet=" + this.nomComplet + ", nomAgrege=" + this.nomAbrege +
    			", niveauActuel=" + this.niveauActuel + ", niveauMaximum=" + this.niveauMaximum + "]";
    }
}
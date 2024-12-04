package maladies;

/**
 * Classe abstraite représentant une maladie quelconque. Elle permet de décrire le fonctionnement basique d'une maladie.
 * Une maladie possède un nom complet et un nom abrégé, représentant la même maladie.<br>
 * Une maladie possède un niveau qui représente la gravité actuelle de la maladie. Plus le niveau est haut, plus la maladie est grave.
 * Si ce niveau est nul, cela veut dire que la maladie ne touche aucune créature.<br>
 * Les niveaux actuels et maximums doivent être entre 0 et 1000 inclus.
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

	/**
	 * Le coefficient de dégradation de la maladie
	 * */
	private double coeffDegradation;
	
	//Constructeurs
	
	/**
	 * Constructeur de la classe maladie non-effective.<br>
	 * Elle permet d'attribuer les valeurs des paramètres à tout type de maladie,
	 * avec un niveau actuel à 0, c'est-à-dire que la maladie n'a pas infecté une créature.
	 * @param nomComplet String: nom complet de la maldie
	 * @param nomAbrege String: nom abrégé de la maladie
	 * @param niveauMaximum int: niveau maximum de la maladie
	 * @throws ErreurChangementNiveauException Erreur si le niveau maximal de la maladie est entre 0 et 1000
	 * */
	public Maladie(String nomComplet, String nomAbrege, int niveauMaximum) throws ErreurChangementNiveauException {
		this.nomComplet = nomComplet;
		this.nomAbrege = nomAbrege;
		if (0 < niveauMaximum && niveauMaximum <= 1000) {
			this.niveauMaximum = niveauMaximum;
		}
		else {
			throw new ErreurChangementNiveauException();
		}
		this.niveauActuel = 0;
		this.coeffDegradation = 0;
	}
	
	/**
	 * Constructeur de la classe maladie effective.<br>
	 * Elle permet d'attribuer les valeurs des paramètres à tout type de maladie.
	 * @param nomComplet String: nom complet de la maldie
	 * @param nomAbrege String: nom abrégé de la maladie
	 * @param niveauActuel int: niveau actuel de la maladie
	 * @param niveauMaximum int: niveau maximum de la maladie
   * @throws ErreurChangementNiveauException Erreur si le niveau actuel de la maladie est entre 0 et le niveau maximum
	 * */
	public Maladie(String nomComplet, String nomAbrege, int niveauActuel, int niveauMaximum) throws ErreurChangementNiveauException {
		this(nomComplet, nomAbrege, niveauMaximum);
		if (0 < niveauActuel && niveauActuel <= niveauMaximum) {
			this.niveauActuel = niveauActuel;
		}
		else {
			throw new ErreurChangementNiveauException();
		}
	}
    
    //Méthodes
    
    /**
     * Permet d'augmenter le niveau actuel de la maladie en entrant la valeur correspondante
     * @param niveau int: Le nombre de niveau à augmenter
     * */
    public void augmenterNiveauActuel(int niveau) throws ErreurChangementNiveauException {
    	if (this.niveauActuel + niveau <= 1000) {
    		this.niveauActuel += niveau;
    	}
    	else {
    		throw new ErreurChangementNiveauException();
    	}
    }
    
    /**
     * Permet de réduire le niveau actuel de la maladie en entrant la valeur correspondante
     * @param niveau int: Le nombre de niveau à réduire
     * */
    public void reduireNiveauActuel(int niveau) throws ErreurChangementNiveauException {
    	if (this.niveauActuel-niveau >= 0) {
    		this.niveauActuel -= niveau;
    	}
    	else {
    		throw new ErreurChangementNiveauException();
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

	/**
	 * Permet de calculer le coefficient de dégradation de la maladie. Fonction abstraite car cela dépend de la maladie.
	 * */
	abstract double calculerCoefficientDegradationMaladie();
    
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

    //Getters/Setters

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getNomAbrege() {
		return nomAbrege;
	}

	public void setNomAbrege(String nomAbrege) {
		this.nomAbrege = nomAbrege;
	}

	public int getNiveauActuel() {
		return niveauActuel;
	}

	public void setNiveauActuel(int niveauActuel) {
		this.niveauActuel = niveauActuel;
	}

	public int getNiveauMaximum() {
		return niveauMaximum;
	}

	public void setNiveauMaximum(int niveauMaximum) {
		this.niveauMaximum = niveauMaximum;
	}

	public double getCoeffDegradation() {
		return coeffDegradation;
	}

	public void setCoeffDegradation(double coeffDegradation) {
		this.coeffDegradation = coeffDegradation;
	}
    
    
  	
}
package maladies;

/**
 * Classe dérivée de la classe abstraite <strong>Maladie</strong> qui décrit une certaine maladie,
 * la maladie Syndrome fear of missing out (FOMO).
 * */
public class SyndromeFearOfMissingOut extends Maladie {
	//Attributs
	
	/**
	 * Niveau actuel de la maladie
	 * @value 0: int par défaut si non initialisation à la base
	 * */
	private int niveauActuel;
	
	//Constructeurs
	public SyndromeFearOfMissingOut(int niveauMaximum) {
		super("Syndrome fear of missing out","FOMO", niveauMaximum);
	}
	public SyndromeFearOfMissingOut(int niveauActuel, int niveauMaximum) {
		this(niveauMaximum);
		this.niveauActuel = niveauActuel;
	}
}

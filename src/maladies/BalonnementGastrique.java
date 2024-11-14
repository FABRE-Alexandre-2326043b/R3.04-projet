package maladies;

/**
 * Classe dérivée de la classe abstraite <strong>Maladie</strong> qui décrit une certaine maladie,
 * la maladie BalonnementGastrique (BG).
 * @see Maladie
 * */
public class BalonnementGastrique extends Maladie {
	//Attributs
	
	/**
	 * Niveau actuel de la maladie
	 * @value 0: int par défaut si non initialisation à la base
	 * */
	private int niveauActuel;
	
	//Constructeurs
	
	
	public BalonnementGastrique(int niveauMaximum) {
		super("Balonnement Gastrique","BG", niveauMaximum);
	}
	public BalonnementGastrique(int niveauActuel, int niveauMaximum) {
		this(niveauMaximum);
		this.niveauActuel = niveauActuel;
	}
}

package maladies;

/**
 * Classe dérivée de la classe abstraite <strong>Maladie</strong> qui décrit une certaine maladie,
 * la maladie Maladie débilitante chronique (MDC).
 * @see Maladie
 * */
public class MaladieDebilitanteChronique extends Maladie {
	//Attributs
	
	/**
	 * Niveau actuel de la maladie
	 * @value 0: int par défaut si non initialisation à la base
	 * */
	private int niveauActuel;
	
	//Constructeurs
	public MaladieDebilitanteChronique(int niveauMaximum) {
		super("Maladie débilitante chronique","MDC", niveauMaximum);
	}
	public MaladieDebilitanteChronique(int niveauActuel, int niveauMaximum) {
		this(niveauMaximum);
		this.niveauActuel = niveauActuel;
	}
}

package maladies;

/**
 * Classe dérivée de la classe abstraite <strong>Maladie</strong> qui décrit une certaine maladie,
 * la maladie Prophyrie érythropoïétique congénitale (PEC).
 * @see Maladie
 * */
public class ProphyrieErythropoietiqueCongenitale extends Maladie {
	//Attributs
	
	/**
	 * Niveau actuel de la maladie
	 * @value 0: int par défaut si non initialisation à la base
	 * */
	private int niveauActuel;
	
	//Constructeurs
	
	
	public ProphyrieErythropoietiqueCongenitale(int niveauMaximum) {
		super("Prophyrie érythropoïétique congénitale","PEC", niveauMaximum);
	}
	public ProphyrieErythropoietiqueCongenitale(int niveauActuel, int niveauMaximum) {
		this(niveauMaximum);
		this.niveauActuel = niveauActuel;
	}
}

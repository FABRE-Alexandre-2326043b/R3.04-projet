package maladies;

/**
 * Classe dérivée de la classe abstraite <strong>Maladie</strong> qui décrit une certaine maladie,
 * la maladie Zoopathie Paraphrénique lycanthropique (ZPL).
 * @see Maladie
 * */
public class ZoopathiePaeaphréniqueLycanthropique extends Maladie {
	//Attributs
	
	/**
	 * Niveau actuel de la maladie
	 * @value 0: int par défaut si non initialisation à la base
	 * */
	private int niveauActuel;
	
	//Constructeurs
	
	
	public ZoopathiePaeaphréniqueLycanthropique(int niveauMaximum) {
		super("Zoopathie Paraphrénique lycanthropique","ZPL", niveauMaximum);
	}
	public ZoopathiePaeaphréniqueLycanthropique(int niveauActuel, int niveauMaximum) {
		this(niveauMaximum);
		this.niveauActuel = niveauActuel;
	}	
}

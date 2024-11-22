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
	
	/**
	 * Constructeur de la classe pour la maladie ZPL sans affecter de créatures, c'est à dire que le niveau actuel de la maladie est nul.
	 * @param niveauMaximum: int niveau maximum de la maladie avant qu'elle ne soit létale.
	 * */
	public ZoopathiePaeaphréniqueLycanthropique(int niveauMaximum) {
		super("Zoopathie Paraphrénique lycanthropique","ZPL", niveauMaximum);
	}
	
	/**
	 * Constructeur de la classe pour la maladie ZPL avec un niveau de gravité qui affecte une créature.
	 * @param niveauActuel: int niveau actuel de la maladie qui touche une créature
	 * @param niveauMaximum: int niveau maximum de la maladie avant qu'elle ne soit létale.
	 * */
	public ZoopathiePaeaphréniqueLycanthropique(int niveauActuel, int niveauMaximum) {
		this(niveauMaximum);
		this.niveauActuel = niveauActuel;
	}	
}

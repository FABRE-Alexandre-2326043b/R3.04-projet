package maladies;

/**
 * Classe dérivée de la classe abstraite <strong>Maladie</strong> qui décrit une certaine maladie,
 * la maladie Dépendance aux réseaux sociaux (DRS).
 * @see Maladie
 * */
public class DependanceAuxReseauxSociaux extends Maladie {
	//Attributs
	
	/**
	 * Niveau actuel de la maladie
	 * @value 0: int par défaut si non initialisation à la base
	 * */
	private int niveauActuel;
	
	//Constructeurs
	
	
	public DependanceAuxReseauxSociaux(int niveauMaximum) {
		super("Maladie débilitante chronique","MDC", niveauMaximum);
	}
	public DependanceAuxReseauxSociaux(int niveauActuel, int niveauMaximum) {
		this(niveauMaximum);
		this.niveauActuel = niveauActuel;
	}
}

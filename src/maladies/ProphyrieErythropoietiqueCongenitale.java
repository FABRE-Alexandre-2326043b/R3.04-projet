package maladies;

import java.util.Random;

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

	/**
	 * Le coefficient de dégradation de la maladie BalonnementGastrique
	 * */
	private double coeffDegradation;
	
	//Constructeurs
	
	/**
	 * Constructeur de la classe pour la maladie PEC sans affecter de créatures, c'est à dire que le niveau actuel de la maladie est nul.
	 * @param niveauMaximum: int niveau maximum de la maladie avant qu'elle ne soit létale.
	 * */
	public ProphyrieErythropoietiqueCongenitale(int niveauMaximum) throws ErreurChangementNiveauException {
		super("Prophyrie érythropoïétique congénitale","PEC", niveauMaximum);
	}
	
	/**
	 * Constructeur de la classe pour la maladie PEC avec un niveau de gravité qui affecte une créature.
	 * @param niveauActuel: int niveau actuel de la maladie qui touche une créature
	 * @param niveauMaximum: int niveau maximum de la maladie avant qu'elle ne soit létale.
	 * */
	public ProphyrieErythropoietiqueCongenitale(int niveauActuel, int niveauMaximum) throws ErreurChangementNiveauException {
		this(niveauMaximum);
		this.niveauActuel = niveauActuel;
	}

	/**
	 * Renvoie le coefficient de dégradation de la maladie.<br>
	 * Cette fonction permet de calculer comment la maladie se dégrade avec le temps, qui est différent entre chaque maladie.
	 * @return double
	 */
	@Override
	public double calculerCoefficientDegradationMaladie () {
		this.coeffDegradation = new Random().nextDouble() * 0.4;
		return this.coeffDegradation;
	}
}

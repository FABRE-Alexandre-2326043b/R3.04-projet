package medecins;

/**
 * Classe représentant un médecin.
 * */
public class Medecin {
	//Attributs
	
	/**
	 * Attribut représentant le nom du médecin.
	 * */
	private String nom;
	
	/**
	 * Attribut représentant le sexe du médecin.
	 * */
	private String sexe;
	
	/**
	 * Attribut représentant l'âge du médecin.
	 * */
	private int age;
	
	//Constructeur
	
	/**
	 * Constructeur de la classe Medecin pour créer une instance de cette classe.
	 * On définit son nom, sexe et âge pour chaque médecin.
	 * @param nom String: nom du médecin
	 * @param sexe String: sexe du médecin
	 * @param age int: âge du médecin
	 * */
	public Medecin(String nom, String sexe, int age) {
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
	}
	
	//toString
	
	/**
	 * Renvoie une chaîne de caractères qui présente toutes les valeures de tous les attributs
	 * d'une instance de la classe Medecin.
	 * @return String chaîne de caractères présentant toutes les valeurs
	 * de l'instance de la classe
	 * */
	@Override
	public String toString() {
		return "Medecin[nom=" + this.nom + ", sexe=" + this.sexe +
				", age=" + this.age + "]";
	}
}

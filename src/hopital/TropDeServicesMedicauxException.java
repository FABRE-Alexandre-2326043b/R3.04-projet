package hopital;

/**
 * Une exception qui est renvoyée s'il y a trop de services médicaux acceptables dans l'hôpital
 * @see Exception
 * */
public class TropDeServicesMedicauxException extends Exception {
	/**
	 * Méthode permettant l'affichage de l'erreur TropDeServicesMedicauxException
	 * */
	public TropDeServicesMedicauxException() {
		System.out.println("Vous ne pouvez pas ajouter un nouveau service médical car vous êtes déjà atteint la limite de service médicaux." +
							"\nSi vous souhaitez ajouter ce service médical, veuillez modifier le nombre maximum de services médicaux.");
	}
}

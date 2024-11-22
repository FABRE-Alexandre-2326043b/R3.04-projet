package hopital;

public class TropDeServicesMedicauxException extends Exception {
	private static final long serialVersionUID = 1L;

	public TropDeServicesMedicauxException() {
		System.err.println("Vous ne pouvez pas ajouter un nouveau service médical car vous êtes déjà atteint la limite de service médicaux." +
							"\nSi vous souhaitez ajouter ce service médical, veuillez modifier le nombre maximum de services médicaux.");
	}
	
	public TropDeServicesMedicauxException(String message) {
		super(message);
	}
}

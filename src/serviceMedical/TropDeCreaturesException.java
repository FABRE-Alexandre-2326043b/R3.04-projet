package serviceMedical;

/**
 * Une exception qui est lever s'il y a trop de créatures acceptables dans le service médical
 * @see Exception
 * */
public class TropDeCreaturesException extends Exception {
    /**
     * Méthode permettant l'affichage de l'erreur TropDeCreaturesException
     * */
    public TropDeCreaturesException() {
        System.out.println("TropDeCreaturesException: Vous dépassez la limite de créatures disponibles dans le service médical.");
    }
}

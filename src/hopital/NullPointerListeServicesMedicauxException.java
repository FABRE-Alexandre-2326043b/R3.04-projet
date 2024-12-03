package hopital;

/**
 * Une exception qui est renvoyée si on essaie de supprimer un service médical alors qu'il y en a pas
 * @see Exception
 * */
public class NullPointerListeServicesMedicauxException extends Exception {
    /**
     * Méthode permettant l'affichage de l'erreur NullPointerListeServicesMedicauxException
     * */
    public NullPointerListeServicesMedicauxException() {
        System.out.println("Vous ne pouvez pas supprimer de service médical car l'hôpital n'en possède pas");
    }
}

package menu;

/**
 * Une exception qui est renvoyée si l'entrée utilisateur est invalide
 * @see Exception
 * */
public class MauvaiseEntreeException extends Exception {
  /**
   * Méthode permettant l'affichage de l'erreur MauvaiseEntreeException
   * */
  public MauvaiseEntreeException() {
    System.out.println("Votre entrée utilisateur est invalide. Veuillez réessayer!");
  }
}

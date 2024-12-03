package maladies;

/**
 * Une exception qui est renvoyée s'il y a une erreur dans la modification du niveau actuel d'une maladie
 * @see Exception
 * */
public class ErreurChangementNiveauException extends Exception {

    /**
     * Méthode permettant l'affichage de l'erreur ErreurChangementNiveauException
     * */
    public ErreurChangementNiveauException() {
        System.out.println("Vous ne pouvez pas modifier la valeur du niveau de la maladie car le nombre que vous souhaitez ajouté ou soustraire fait sortir le nombre de l'intervalle [0,1000].");
    }
}

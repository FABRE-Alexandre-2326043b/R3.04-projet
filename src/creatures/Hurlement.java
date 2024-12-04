package creatures;

/**
 * Représente un hurlement émis par un lycanthrope.
 */
public class Hurlement {
    private String type;
    private Lycanthrope emetteur;

    /**
     * Constructeur pour créer un hurlement.
     * 
     * @param type     Le type du hurlement (ex. domination, soumission, etc.).
     * @param emetteur Le lycanthrope émetteur.
     */
    public Hurlement(String type, Lycanthrope emetteur) {
        this.type = type;
        this.emetteur = emetteur;
    }

    /**
     * Retourne le type de hurlement.
     * 
     * @return Le type de hurlement.
     */
    public String getType() {
        return type;
    }

    /**
     * Retourne le lycanthrope émetteur du hurlement.
     * 
     * @return Le lycanthrope émetteur.
     */
    public Lycanthrope getEmetteur() {
        return emetteur;
    }

    /**
     * Affiche les caractéristiques du hurlement.
     * 
     * @return Une chaîne décrivant le hurlement.
     */
    public String afficherCaracteristiques() {
        return "Type : " + type + "\n" + "Émetteur : " + emetteur.getNomComplet();
    }
}

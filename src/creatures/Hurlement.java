package creatures;

public class Hurlement {
    private String type;
    private Lycanthrope emetteur;

    public Hurlement(String type, Lycanthrope emetteur) {
        this.type = type;
        this.emetteur = emetteur;
    }

    public String getType() {
        return type;
    }

    public Lycanthrope getEmetteur() {
        return emetteur;
    }

    public String afficherCaracteristiques() {
        return "Type : " + type + "\n" + "Émetteur : " + emetteur.getNomComplet();
    }
}

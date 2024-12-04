package creatures;

import java.util.List;
import java.util.ArrayList;

/**
 * Représente le couple alpha d'une meute.
 */
public class CoupleAlpha {
    private Lycanthrope maleAlpha;
    private Lycanthrope femelleAlpha;

    /**
     * Constructeur pour créer un couple alpha.
     * 
     * @param maleAlpha   Le mâle alpha.
     * @param femelleAlpha La femelle alpha.
     */
    public CoupleAlpha(Lycanthrope maleAlpha, Lycanthrope femelleAlpha) {
        this.maleAlpha = maleAlpha;
        this.femelleAlpha = femelleAlpha;
    }

    /**
     * Lance une reproduction entre le mâle et la femelle alpha.
     * 
     * @return Une liste de nouveaux lycanthropes issus de la reproduction.
     */
    public List<Lycanthrope> reproduire() {
        List<Lycanthrope> enfants = new ArrayList<>();
        int nombreEnfants = (int) (Math.random() * 7) + 1;
        for (int i = 0; i < nombreEnfants; i++) {
            enfants.add(new Lycanthrope("Enfant" + (i + 1), "M", 30, 50, 1, 10, new ArrayList<>(),
                    "jeune", 10, 0, "γ", 10, 0.5, null));
        }
        return enfants;
    }

    /**
     * Affiche les caractéristiques du couple alpha.
     * 
     * @return Une chaîne décrivant le couple alpha.
     */
    public String afficherCaracteristiques() {
        return "Mâle Alpha : " + maleAlpha.getNomComplet() + "\n" +
               "Femelle Alpha : " + femelleAlpha.getNomComplet();
    }
}

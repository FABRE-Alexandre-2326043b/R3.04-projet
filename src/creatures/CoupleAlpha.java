package creatures;

import java.util.List;
import java.util.ArrayList;

public class CoupleAlpha {
    private Lycanthrope maleAlpha;
    private Lycanthrope femelleAlpha;

    public CoupleAlpha(Lycanthrope maleAlpha, Lycanthrope femelleAlpha) {
        this.maleAlpha = maleAlpha;
        this.femelleAlpha = femelleAlpha;
    }

    public List<Lycanthrope> reproduire() {
        List<Lycanthrope> enfants = new ArrayList<>();
        int nombreEnfants = (int) (Math.random() * 7) + 1;
        for (int i = 0; i < nombreEnfants; i++) {
            enfants.add(new Lycanthrope("Enfant" + (i + 1), "M", 30, 50, 1, 10, new ArrayList<>(),
                    "jeune", 10, 0, "γ", 10, 0.5, null));
        }
        return enfants;
    }

    public String afficherCaracteristiques() {
        return "Mâle Alpha : " + maleAlpha.getNomComplet() + "\n" +
               "Femelle Alpha : " + femelleAlpha.getNomComplet();
    }
}

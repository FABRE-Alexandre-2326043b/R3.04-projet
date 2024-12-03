package creatures;

import java.util.ArrayList;
import java.util.List;

public class Meute {
    private CoupleAlpha coupleAlpha;
    private List<Lycanthrope> membres;

    public Meute(CoupleAlpha coupleAlpha) {
        this.coupleAlpha = coupleAlpha;
        this.membres = new ArrayList<>();
    }

    public void ajouterLycanthrope(Lycanthrope lycanthrope) {
        membres.add(lycanthrope);
    }

    public void retirerLycanthrope(Lycanthrope lycanthrope) {
        membres.remove(lycanthrope);
    }

    public void reconstituerHiérarchie() {
        membres.sort((a, b) -> Integer.compare(b.getForce(), a.getForce()));
    }

    public void reproduction() {
        if (coupleAlpha != null) {
            List<Lycanthrope> nouveauxMembres = coupleAlpha.reproduire();
            membres.addAll(nouveauxMembres);
        }
    }

    public void reagirHurlement(Lycanthrope lycanthrope) {
        System.out.println("Les membres de la meute réagissent au hurlement de " + lycanthrope.getNomComplet());
    }

    public void afficherCaracteristiques() {
        System.out.println("Couple Alpha : " + (coupleAlpha != null ? coupleAlpha.afficherCaracteristiques() : "Aucun"));
        System.out.println("Membres de la meute :");
        membres.forEach(membre -> System.out.println(membre.afficherCaracteristiques()));
    }
}

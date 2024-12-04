package creatures;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente une meute de lycanthropes avec ses membres et son couple alpha.
 */
public class Meute {
    private CoupleAlpha coupleAlpha;
    private List<Lycanthrope> membres;

    /**
     * Constructeur pour créer une meute avec un couple alpha.
     * 
     * @param coupleAlpha Le couple alpha dirigeant la meute.
     */
    public Meute(CoupleAlpha coupleAlpha) {
        this.coupleAlpha = coupleAlpha;
        this.membres = new ArrayList<>();
    }

    /**
     * Ajoute un lycanthrope à la meute.
     * 
     * @param lycanthrope Le lycanthrope à ajouter.
     */
    public void ajouterLycanthrope(Lycanthrope lycanthrope) {
        membres.add(lycanthrope);
    }

    /**
     * Retire un lycanthrope de la meute.
     * 
     * @param lycanthrope Le lycanthrope à retirer.
     */
    public void retirerLycanthrope(Lycanthrope lycanthrope) {
        membres.remove(lycanthrope);
    }

    /**
     * Reconstitue la hiérarchie de la meute en fonction des forces des lycanthropes.
     */
    public void reconstituerHiérarchie() {
        membres.sort((a, b) -> Integer.compare(b.getForce(), a.getForce()));
    }

    /**
     * Lance une reproduction entre le couple alpha pour générer de nouveaux membres.
     */
    public void reproduction() {
        if (coupleAlpha != null) {
            List<Lycanthrope> nouveauxMembres = coupleAlpha.reproduire();
            membres.addAll(nouveauxMembres);
        }
    }
    
	/**
	 * Fait réagir les membres de la meute à un hurlement.
	 * 
	 * @param lycanthrope Le lycanthrope ayant hurlé.
	 */
    public void reagirHurlement(Lycanthrope lycanthrope) {
        System.out.println("Les membres de la meute réagissent au hurlement de " + lycanthrope.getNomComplet());
    }

    /**
     * Affiche les caractéristiques détaillées de la meute.
     */
    public void afficherCaracteristiques() {
        System.out.println("Couple Alpha : " + (coupleAlpha != null ? coupleAlpha.afficherCaracteristiques() : "Aucun"));
        System.out.println("Membres de la meute :");
        membres.forEach(membre -> System.out.println(membre.afficherCaracteristiques()));
    }

	public CoupleAlpha getCoupleAlpha() {
		return coupleAlpha;
	}

	public void setCoupleAlpha(CoupleAlpha coupleAlpha) {
		this.coupleAlpha = coupleAlpha;
	}

	public List<Lycanthrope> getMembres() {
		return membres;
	}

	public void setMembres(List<Lycanthrope> membres) {
		this.membres = membres;
	}
    
    
}

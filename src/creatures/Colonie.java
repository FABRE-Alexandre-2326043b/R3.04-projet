package creatures;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente une colonie composée de plusieurs meutes de lycanthropes.
 */
public class Colonie {
    private List<Meute> meutes;

    /**
     * Constructeur pour créer une colonie vide.
     */
    public Colonie() {
        this.meutes = new ArrayList<>();
    }

    /**
     * Ajoute une meute à la colonie.
     * 
     * @param meute La meute à ajouter.
     */
    public void ajouterMeute(Meute meute) {
        meutes.add(meute);
    }

    /**
     * Affiche les caractéristiques des lycanthropes de toutes les meutes.
     */
    public void afficherLycanthropes() {
        meutes.forEach(Meute::afficherCaracteristiques);
    }

	public List<Meute> getMeutes() {
		return meutes;
	}

	public void setMeutes(List<Meute> meutes) {
		this.meutes = meutes;
	}
    
    
}

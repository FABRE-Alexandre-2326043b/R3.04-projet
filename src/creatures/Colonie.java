package creatures;

import java.util.ArrayList;
import java.util.List;

public class Colonie {
    private List<Meute> meutes;

    public Colonie() {
        this.meutes = new ArrayList<>();
    }

    public void ajouterMeute(Meute meute) {
        meutes.add(meute);
    }

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

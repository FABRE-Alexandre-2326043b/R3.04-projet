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
}

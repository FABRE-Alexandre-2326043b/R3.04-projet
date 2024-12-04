package r304projet.creatures;


import org.junit.jupiter.api.Test;

import creatures.Colonie;
import creatures.Meute;

import static org.junit.jupiter.api.Assertions.*;

class ColonieTest {

    @Test
    void testAjouterMeute() {
        Colonie colonie = new Colonie();
        Meute meute = new Meute(null);
        colonie.ajouterMeute(meute);
        assertTrue(colonie.getMeutes().contains(meute));
    }

    @Test
    void testAfficherLycanthropes() {
        Colonie colonie = new Colonie();
        Meute meute = new Meute(null);
        colonie.ajouterMeute(meute);
        assertDoesNotThrow(colonie::afficherLycanthropes);
    }
}

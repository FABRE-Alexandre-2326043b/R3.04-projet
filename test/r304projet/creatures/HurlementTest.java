package r304projet.creatures;


import org.junit.jupiter.api.Test;

import creatures.Hurlement;
import creatures.Lycanthrope;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class HurlementTest {

    @Test
    void testAfficherCaracteristiques() {
        Lycanthrope lycanthrope = new Lycanthrope("John", "M", 80, 180, 30, 50,
                new ArrayList<>(), "adulte", 70, 5, "β", 100, 0.5, null);
        Hurlement hurlement = new Hurlement("Domination", lycanthrope);
        String details = hurlement.afficherCaracteristiques();
        assertTrue(details.contains("Domination"));
        assertTrue(details.contains("John"));
    }
}

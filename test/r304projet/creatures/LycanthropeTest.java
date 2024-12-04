package r304projet.creatures;
import org.junit.jupiter.api.Test;

import creatures.Hurlement;
import creatures.Lycanthrope;
import creatures.Meute;
import maladies.ErreurChangementNiveauException;
import maladies.Maladie;
import maladies.MaladieDebilitanteChronique;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LycanthropeTest {

    @Test
    void testHurler() {
        Lycanthrope lycanthrope = new Lycanthrope("John", "M", 80, 180, 30, 50,
                new ArrayList<>(), "adulte", 70, 5, "β", 100, 0.5, null);
        assertDoesNotThrow(lycanthrope::hurler);
    }

    @Test
    void testEntendreHurlement() {
        Lycanthrope lycanthrope = new Lycanthrope("John", "M", 80, 180, 30, 50,
                new ArrayList<>(), "adulte", 70, 5, "β", 100, 0.5, null);
        Hurlement hurlement = new Hurlement("Domination", lycanthrope);
        assertDoesNotThrow(() -> lycanthrope.entendreHurlement(hurlement));
    }

    @Test
    void testEstTropMalade() {
        List<Maladie> maladies = new ArrayList<>();
        try {
            maladies.add(new MaladieDebilitanteChronique(15, 10));
        } catch (ErreurChangementNiveauException e) {
            fail("Erreur lors de la création de la maladie : " + e.getMessage());
        }

        Lycanthrope lycanthrope = new Lycanthrope("John", "M", 80, 180, 30, 50,
                maladies, "adulte", 70, 5, "β", 100, 0.5, null);

        assertTrue(lycanthrope.estTropMalade());
    }

    @Test
    void testQuitterMeute() {
        Meute meute = new Meute(null);
        Lycanthrope lycanthrope = new Lycanthrope("John", "M", 80, 180, 30, 50,
                new ArrayList<>(), "adulte", 70, 5, "β", 100, 0.5, meute);
        meute.ajouterLycanthrope(lycanthrope);

        lycanthrope.quitterMeute();
        assertNull(lycanthrope.getMeute());
        assertFalse(meute.getMembres().contains(lycanthrope));
    }

    @Test
    void testSeTransformerEnHumain() {
        Lycanthrope lycanthrope = new Lycanthrope("John", "M", 80, 180, 30, 50,
                new ArrayList<>(), "adulte", 70, 5, "β", 100, 0.5, null);
        assertDoesNotThrow(lycanthrope::seTransformerEnHumain);
    }
}
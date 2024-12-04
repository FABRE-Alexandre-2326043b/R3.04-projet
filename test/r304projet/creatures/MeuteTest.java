package r304projet.creatures;

import org.junit.jupiter.api.Test;

import creatures.Lycanthrope;
import creatures.Meute;

import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class MeuteTest {

    @Test
    void testAjouterLycanthrope() {
        Meute meute = new Meute(null);
        Lycanthrope lycanthrope = new Lycanthrope("John", "M", 80, 180, 30, 50,
                new ArrayList<>(), "adulte", 70, 5, "β", 100, 0.5, null);
        meute.ajouterLycanthrope(lycanthrope);
        assertTrue(meute.getMembres().contains(lycanthrope));
    }

    @Test
    void testRetirerLycanthrope() {
        Meute meute = new Meute(null);
        Lycanthrope lycanthrope = new Lycanthrope("John", "M", 80, 180, 30, 50,
                new ArrayList<>(), "adulte", 70, 5, "β", 100, 0.5, null);
        meute.ajouterLycanthrope(lycanthrope);
        meute.retirerLycanthrope(lycanthrope);
        assertFalse(meute.getMembres().contains(lycanthrope));
    }

    @Test
    void testReconstituerHiérarchie() {
        Meute meute = new Meute(null);
        Lycanthrope weak = new Lycanthrope("Weak", "M", 70, 170, 25, 50,
                new ArrayList<>(), "adulte", 50, 0, "γ", 70, 0.3, null);
        Lycanthrope strong = new Lycanthrope("Strong", "M", 90, 190, 35, 50,
                new ArrayList<>(), "adulte", 90, 0, "β", 100, 0.5, null);

        meute.ajouterLycanthrope(weak);
        meute.ajouterLycanthrope(strong);
        meute.reconstituerHiérarchie();

        List<Lycanthrope> membres = meute.getMembres();
        assertEquals("Strong", membres.get(0).getNomComplet());
        assertEquals("Weak", membres.get(1).getNomComplet());
    }
}

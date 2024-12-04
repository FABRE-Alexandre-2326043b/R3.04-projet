package r304projet.creatures;

import org.junit.jupiter.api.Test;

import creatures.CoupleAlpha;
import creatures.Lycanthrope;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CoupleAlphaTest {

    @Test
    void testReproduire() {
        Lycanthrope maleAlpha = new Lycanthrope("Alpha Male", "M", 90, 190, 35, 50,
                new ArrayList<>(), "adulte", 90, 0, "α", 100, 0.5, null);
        Lycanthrope femelleAlpha = new Lycanthrope("Alpha Female", "F", 80, 180, 30, 50,
                new ArrayList<>(), "adulte", 80, 0, "α", 95, 0.4, null);
        CoupleAlpha coupleAlpha = new CoupleAlpha(maleAlpha, femelleAlpha);

        List<Lycanthrope> enfants = coupleAlpha.reproduire();
        assertNotNull(enfants);
        assertFalse(enfants.isEmpty());
    }
}

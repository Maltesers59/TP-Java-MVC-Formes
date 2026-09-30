package modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests unitaires des calculs de la classe Rond
 * Avec π, le résultat n'est jamais exact : on compare avec une marge d'erreur (DELTA)
 */
public class RondTest {

    private static final float DELTA = 0.0001f;

    @Test
    public void testGetRayon() {
        Rond unRond = new Rond(3);
        assertEquals(3f, unRond.getRayon());
    }

    @Test
    public void testPerimetre() {
        Rond unRond = new Rond(3);
        assertEquals(18.849556f, unRond.perimetre(), DELTA);   // 2 × π × 3
    }

    @Test
    public void testSurface() {
        Rond unRond = new Rond(3);
        assertEquals(28.274334f, unRond.surface(), DELTA);     // π × 3 × 3
    }

    @Test
    public void testRayonUn() {
        Rond unRond = new Rond(1);
        assertEquals((float) (2 * Math.PI), unRond.perimetre(), DELTA);
        assertEquals((float) Math.PI, unRond.surface(), DELTA);
    }
}

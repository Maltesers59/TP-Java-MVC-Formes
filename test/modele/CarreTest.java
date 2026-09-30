package modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests unitaires des calculs de la classe Carre
 */
public class CarreTest {

    @Test
    public void testGetCote() {
        Carre unCarre = new Carre(5);
        assertEquals(5f, unCarre.getCote());
    }

    @Test
    public void testPerimetre() {
        Carre unCarre = new Carre(5);
        assertEquals(20f, unCarre.perimetre());       // 4 × 5
    }

    @Test
    public void testSurface() {
        Carre unCarre = new Carre(5);
        assertEquals(25f, unCarre.surface());         // 5 × 5
    }

    @Test
    public void testAvecVirgule() {
        Carre unCarre = new Carre(2.5f);
        assertEquals(10f, unCarre.perimetre());       // 4 × 2,5
        assertEquals(6.25f, unCarre.surface());       // 2,5 × 2,5
    }
}

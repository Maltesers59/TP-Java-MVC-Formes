package modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests unitaires des calculs de la classe Rectangle
 */
public class RectangleTest {

    @Test
    public void testGetters() {
        Rectangle unRectangle = new Rectangle(4, 3);
        assertEquals(4f, unRectangle.getLongueur());
        assertEquals(3f, unRectangle.getLargeur());
    }

    @Test
    public void testPerimetre() {
        Rectangle unRectangle = new Rectangle(4, 3);
        assertEquals(14f, unRectangle.perimetre());      // 2 × (4 + 3)
    }

    @Test
    public void testSurface() {
        Rectangle unRectangle = new Rectangle(4, 3);
        assertEquals(12f, unRectangle.surface());        // 4 × 3
    }

    @Test
    public void testRectangleCarre() {
        // un rectangle dont les 2 côtés sont égaux donne les mêmes résultats qu'un carré
        Rectangle unRectangle = new Rectangle(5, 5);
        Carre unCarre = new Carre(5);
        assertEquals(unCarre.perimetre(), unRectangle.perimetre());
        assertEquals(unCarre.surface(), unRectangle.surface());
    }
}

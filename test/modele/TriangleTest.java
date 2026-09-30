package modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests unitaires des calculs de la classe Triangle
 */
public class TriangleTest {

    private static final float DELTA = 0.0001f;

    @Test
    public void testGetCotes() {
        Triangle unTriangle = new Triangle(3, 4, 5);
        assertEquals(3f, unTriangle.getCote1());
        assertEquals(4f, unTriangle.getCote2());
        assertEquals(5f, unTriangle.getCote3());
    }

    @Test
    public void testPerimetre() {
        Triangle unTriangle = new Triangle(3, 4, 5);
        assertEquals(12f, unTriangle.perimetre());                // 3 + 4 + 5
    }

    @Test
    public void testSurfaceTriangleRectangle() {
        // triangle rectangle 3-4-5 : surface = (3 × 4) / 2 = 6
        Triangle unTriangle = new Triangle(3, 4, 5);
        assertEquals(6f, unTriangle.surface(), DELTA);
    }

    @Test
    public void testSurfaceTriangleEquilateral() {
        // triangle équilatéral de côté 2 : surface = racine(3) ≈ 1,7320508
        Triangle unTriangle = new Triangle(2, 2, 2);
        assertEquals(6f, unTriangle.perimetre());
        assertEquals((float) Math.sqrt(3), unTriangle.surface(), DELTA);
    }

    @Test
    public void testCotesImpossibles() {
        // 1 + 2 < 10 : ces longueurs ne peuvent pas former un triangle
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 10));
    }

    @Test
    public void testTriangleAplati() {
        // 1 + 2 = 3 : triangle "plat", refusé aussi
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 3));
    }
}

package modele;

/**
 * Forme rectangle, définie par sa longueur et sa largeur
 */
public class Rectangle implements Forme {

    private float longueur;
    private float largeur;

    public Rectangle(float longueur, float largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    // getters
    public float getLongueur() {
        return this.longueur;
    }

    public float getLargeur() {
        return this.largeur;
    }

    @Override
    public float perimetre() {
        return 2 * (longueur + largeur);
    }

    @Override
    public float surface() {
        return longueur * largeur;
    }
}

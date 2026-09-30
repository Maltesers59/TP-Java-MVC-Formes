package modele;

/**
 * Forme triangle, définie par la longueur de ses 3 côtés
 */
public class Triangle implements Forme {

    private float cote1;
    private float cote2;
    private float cote3;

    /**
     * Constructeur
     * Refuse 3 longueurs qui ne peuvent pas former un triangle :
     * chaque côté doit être plus petit que la somme des deux autres
     */
    public Triangle(float cote1, float cote2, float cote3) {
        if (cote1 + cote2 <= cote3 || cote1 + cote3 <= cote2 || cote2 + cote3 <= cote1) {
            throw new IllegalArgumentException("Ces 3 longueurs ne forment pas un triangle.");
        }
        this.cote1 = cote1;
        this.cote2 = cote2;
        this.cote3 = cote3;
    }

    // getters
    public float getCote1() {
        return this.cote1;
    }

    public float getCote2() {
        return this.cote2;
    }

    public float getCote3() {
        return this.cote3;
    }

    @Override
    public float perimetre() {
        return cote1 + cote2 + cote3;
    }

    /**
     * Formule de Héron : s = demi-périmètre
     * surface = racine( s × (s-a) × (s-b) × (s-c) )
     */
    @Override
    public float surface() {
        float s = perimetre() / 2;
        return (float) Math.sqrt(s * (s - cote1) * (s - cote2) * (s - cote3));
    }
}

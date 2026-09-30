package modele;

public class Carre implements Forme {

    private float cote;              // attribut privé : encapsulation

    public Carre(float cote) {       // constructeur
        this.cote = cote;
    }

    public float getCote() {         // getter : lecture de l'attribut depuis l'extérieur
        return this.cote;
    }

    @Override
    public float perimetre() {
        return 4 * cote;
    }

    @Override
    public float surface() {
        return cote * cote;
    }
}

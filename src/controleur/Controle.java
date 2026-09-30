package controleur;

import java.util.ArrayList;

import modele.Carre;
import modele.Forme;
import modele.Rectangle;
import modele.Rond;
import modele.Triangle;
import vue.FrmFormes;

public class Controle {

    // la fenêtre que le contrôleur pilote
    private FrmFormes frmFormes;
    private ArrayList<Forme> lesFormes = new ArrayList<Forme>();

    // point de départ du programme
    public static void main(String[] args) {
        new Controle();
    }

    // constructeur
    public Controle() {
        frmFormes = new FrmFormes(this);
        frmFormes.setVisible(true);
    }

    // demande de la vue : calculer périmètre et surface
    // typeForme : "carre", "rond", "triangle" ou "rectangle"
    // valeurs : les mesures tapées (1 pour carré et rond, 3 pour triangle, 2 pour rectangle)
    public void demandeFrmFormesValeurs(String typeForme, float... valeurs) {
        Forme uneForme;
        if (typeForme.equals("carre")) {
            uneForme = new Carre(valeurs[0]);
            frmFormes.afficheResultCarre(uneForme.perimetre(), uneForme.surface());
        } else if (typeForme.equals("rond")) {
            uneForme = new Rond(valeurs[0]);
            frmFormes.afficheResultRond(uneForme.perimetre(), uneForme.surface());
        } else if (typeForme.equals("triangle")) {
            uneForme = new Triangle(valeurs[0], valeurs[1], valeurs[2]);
            frmFormes.afficheResultTriangle(uneForme.perimetre(), uneForme.surface());
        } else {
            uneForme = new Rectangle(valeurs[0], valeurs[1]);
            frmFormes.afficheResultRectangle(uneForme.perimetre(), uneForme.surface());
        }
        lesFormes.add(uneForme);             // ajout dans l'historique
        frmFormes.majLstFormes(lesFormes);   // la vue réaffiche la liste
    }

    // demande de la vue : supprimer la forme n° indice
    public void demandeFrmFormesDel(int indice) {
        lesFormes.remove(indice);            // suppression dans l'historique
        frmFormes.majLstFormes(lesFormes);   // la vue réaffiche la liste
    }
}

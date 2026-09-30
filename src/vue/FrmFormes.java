package vue;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controleur.Controle;
import modele.Carre;
import modele.Forme;
import modele.Rectangle;
import modele.Rond;
import modele.Triangle;

public class FrmFormes extends JFrame {

    // ----- ATTRIBUTS : les composants utilisés par plusieurs méthodes -----
    private JTextField txtCote;
    private JTextField txtRayon;
    private JLabel lblPerimetreCarre;
    private JLabel lblSurfaceCarre;
    private JLabel lblPerimetreRond;
    private JLabel lblSurfaceRond;
    private JTextField txtTriangleCote1;
    private JTextField txtTriangleCote2;
    private JTextField txtTriangleCote3;
    private JLabel lblPerimetreTriangle;
    private JLabel lblSurfaceTriangle;
    private JTextField txtLongueur;
    private JTextField txtLargeur;
    private JLabel lblPerimetreRectangle;
    private JLabel lblSurfaceRectangle;
    private JList<String> lstFormes;
    private DefaultListModel<String> contenuLstFormes = new DefaultListModel<String>();
    private Controle controle;

    // ----- CONSTRUCTEUR : construit la fenêtre -----
    public FrmFormes(Controle controle) {
        this.controle = controle;

        // la fenêtre elle-même
        setTitle("Formes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 560);   // fenêtre 2 fois plus large : 2 colonnes de formes
        setResizable(false);

        // le panneau qui contient tous les composants
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        Font gras = new Font("Tahoma", Font.BOLD, 11);

        // ===== PARTIE CARRÉ =====
        JLabel lblImgCarre = new JLabel();
        lblImgCarre.setIcon(new ImageIcon(FrmFormes.class.getResource("/media/carre.png")));
        lblImgCarre.setBounds(10, 10, 140, 140);
        contentPane.add(lblImgCarre);

        JLabel lblCote = new JLabel("côté =");
        lblCote.setFont(gras);
        lblCote.setBounds(170, 25, 80, 20);
        contentPane.add(lblCote);

        txtCote = new JTextField();
        txtCote.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCote.setBounds(270, 25, 90, 22);
        contentPane.add(txtCote);

        JButton btnCalculCarre = new JButton("Calcul");
        btnCalculCarre.setBounds(370, 24, 90, 24);
        btnCalculCarre.addActionListener(e -> cmdCalculCarre());
        contentPane.add(btnCalculCarre);

        JLabel lblTxtPerimetreCarre = new JLabel("perimetre =");
        lblTxtPerimetreCarre.setFont(gras);
        lblTxtPerimetreCarre.setBounds(170, 70, 90, 20);
        contentPane.add(lblTxtPerimetreCarre);

        lblPerimetreCarre = new JLabel("");
        lblPerimetreCarre.setFont(gras);
        lblPerimetreCarre.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPerimetreCarre.setBounds(270, 70, 90, 20);
        contentPane.add(lblPerimetreCarre);

        JLabel lblTxtSurfaceCarre = new JLabel("surface =");
        lblTxtSurfaceCarre.setFont(gras);
        lblTxtSurfaceCarre.setBounds(170, 110, 90, 20);
        contentPane.add(lblTxtSurfaceCarre);

        lblSurfaceCarre = new JLabel("");
        lblSurfaceCarre.setFont(gras);
        lblSurfaceCarre.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSurfaceCarre.setBounds(270, 110, 90, 20);
        contentPane.add(lblSurfaceCarre);

        // ===== PARTIE ROND (même chose, 150 pixels plus bas) =====
        JLabel lblImgRond = new JLabel();
        lblImgRond.setIcon(new ImageIcon(FrmFormes.class.getResource("/media/rond.png")));
        lblImgRond.setBounds(10, 160, 140, 140);
        contentPane.add(lblImgRond);

        JLabel lblRayon = new JLabel("rayon =");
        lblRayon.setFont(gras);
        lblRayon.setBounds(170, 175, 80, 20);
        contentPane.add(lblRayon);

        txtRayon = new JTextField();
        txtRayon.setHorizontalAlignment(SwingConstants.RIGHT);
        txtRayon.setBounds(270, 175, 90, 22);
        contentPane.add(txtRayon);

        JButton btnCalculRond = new JButton("Calcul");
        btnCalculRond.setBounds(370, 174, 90, 24);
        btnCalculRond.addActionListener(e -> cmdCalculRond());
        contentPane.add(btnCalculRond);

        JLabel lblTxtPerimetreRond = new JLabel("perimetre =");
        lblTxtPerimetreRond.setFont(gras);
        lblTxtPerimetreRond.setBounds(170, 220, 90, 20);
        contentPane.add(lblTxtPerimetreRond);

        lblPerimetreRond = new JLabel("");
        lblPerimetreRond.setFont(gras);
        lblPerimetreRond.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPerimetreRond.setBounds(270, 220, 90, 20);
        contentPane.add(lblPerimetreRond);

        JLabel lblTxtSurfaceRond = new JLabel("surface =");
        lblTxtSurfaceRond.setFont(gras);
        lblTxtSurfaceRond.setBounds(170, 260, 90, 20);
        contentPane.add(lblTxtSurfaceRond);

        lblSurfaceRond = new JLabel("");
        lblSurfaceRond.setFont(gras);
        lblSurfaceRond.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSurfaceRond.setBounds(270, 260, 90, 20);
        contentPane.add(lblSurfaceRond);

        // ===== PARTIE TRIANGLE (colonne de droite, 480 pixels plus à droite) =====
        JLabel lblImgTriangle = new JLabel();
        lblImgTriangle.setIcon(new ImageIcon(FrmFormes.class.getResource("/media/triangle.png")));
        lblImgTriangle.setBounds(490, 10, 140, 140);
        contentPane.add(lblImgTriangle);

        JLabel lblCotesTriangle = new JLabel("côtés =");
        lblCotesTriangle.setFont(gras);
        lblCotesTriangle.setBounds(650, 25, 55, 20);
        contentPane.add(lblCotesTriangle);

        // 3 petites zones de saisie, une par côté
        txtTriangleCote1 = new JTextField();
        txtTriangleCote1.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTriangleCote1.setBounds(710, 25, 40, 22);
        contentPane.add(txtTriangleCote1);

        txtTriangleCote2 = new JTextField();
        txtTriangleCote2.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTriangleCote2.setBounds(755, 25, 40, 22);
        contentPane.add(txtTriangleCote2);

        txtTriangleCote3 = new JTextField();
        txtTriangleCote3.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTriangleCote3.setBounds(800, 25, 40, 22);
        contentPane.add(txtTriangleCote3);

        JButton btnCalculTriangle = new JButton("Calcul");
        btnCalculTriangle.setBounds(850, 24, 90, 24);
        btnCalculTriangle.addActionListener(e -> cmdCalculTriangle());
        contentPane.add(btnCalculTriangle);

        JLabel lblTxtPerimetreTriangle = new JLabel("perimetre =");
        lblTxtPerimetreTriangle.setFont(gras);
        lblTxtPerimetreTriangle.setBounds(650, 70, 90, 20);
        contentPane.add(lblTxtPerimetreTriangle);

        lblPerimetreTriangle = new JLabel("");
        lblPerimetreTriangle.setFont(gras);
        lblPerimetreTriangle.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPerimetreTriangle.setBounds(750, 70, 90, 20);
        contentPane.add(lblPerimetreTriangle);

        JLabel lblTxtSurfaceTriangle = new JLabel("surface =");
        lblTxtSurfaceTriangle.setFont(gras);
        lblTxtSurfaceTriangle.setBounds(650, 110, 90, 20);
        contentPane.add(lblTxtSurfaceTriangle);

        lblSurfaceTriangle = new JLabel("");
        lblSurfaceTriangle.setFont(gras);
        lblSurfaceTriangle.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSurfaceTriangle.setBounds(750, 110, 90, 20);
        contentPane.add(lblSurfaceTriangle);

        // ===== PARTIE RECTANGLE (colonne de droite, sous le triangle) =====
        JLabel lblImgRectangle = new JLabel();
        lblImgRectangle.setIcon(new ImageIcon(FrmFormes.class.getResource("/media/rectangle.png")));
        lblImgRectangle.setBounds(490, 160, 140, 140);
        contentPane.add(lblImgRectangle);

        JLabel lblLongueur = new JLabel("longueur =");
        lblLongueur.setFont(gras);
        lblLongueur.setBounds(650, 170, 90, 20);
        contentPane.add(lblLongueur);

        txtLongueur = new JTextField();
        txtLongueur.setHorizontalAlignment(SwingConstants.RIGHT);
        txtLongueur.setBounds(750, 170, 90, 22);
        contentPane.add(txtLongueur);

        JLabel lblLargeur = new JLabel("largeur =");
        lblLargeur.setFont(gras);
        lblLargeur.setBounds(650, 200, 90, 20);
        contentPane.add(lblLargeur);

        txtLargeur = new JTextField();
        txtLargeur.setHorizontalAlignment(SwingConstants.RIGHT);
        txtLargeur.setBounds(750, 200, 90, 22);
        contentPane.add(txtLargeur);

        JButton btnCalculRectangle = new JButton("Calcul");
        btnCalculRectangle.setBounds(850, 184, 90, 24);
        btnCalculRectangle.addActionListener(e -> cmdCalculRectangle());
        contentPane.add(btnCalculRectangle);

        JLabel lblTxtPerimetreRectangle = new JLabel("perimetre =");
        lblTxtPerimetreRectangle.setFont(gras);
        lblTxtPerimetreRectangle.setBounds(650, 235, 90, 20);
        contentPane.add(lblTxtPerimetreRectangle);

        lblPerimetreRectangle = new JLabel("");
        lblPerimetreRectangle.setFont(gras);
        lblPerimetreRectangle.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPerimetreRectangle.setBounds(750, 235, 90, 20);
        contentPane.add(lblPerimetreRectangle);

        JLabel lblTxtSurfaceRectangle = new JLabel("surface =");
        lblTxtSurfaceRectangle.setFont(gras);
        lblTxtSurfaceRectangle.setBounds(650, 265, 90, 20);
        contentPane.add(lblTxtSurfaceRectangle);

        lblSurfaceRectangle = new JLabel("");
        lblSurfaceRectangle.setFont(gras);
        lblSurfaceRectangle.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSurfaceRectangle.setBounds(750, 265, 90, 20);
        contentPane.add(lblSurfaceRectangle);

        // ===== LISTE + BOUTON DEL (sur toute la largeur) =====
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 310, 930, 170);
        contentPane.add(scrollPane);

        lstFormes = new JList<String>(contenuLstFormes);
        scrollPane.setViewportView(lstFormes);

        JButton btnDel = new JButton("del");
        btnDel.setBounds(850, 490, 90, 24);
        btnDel.addActionListener(e -> cmdDel());
        contentPane.add(btnDel);
    }
    // ----- CLIC SUR LES BOUTONS CALCUL -----
    public void cmdCalculCarre() {
        try {
            float cote = Float.parseFloat(txtCote.getText());
            controle.demandeFrmFormesValeurs("carre", cote);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Veuillez saisir un nombre pour le côté.");
        }
    }

    public void cmdCalculRond() {
        try {
            float rayon = Float.parseFloat(txtRayon.getText());
            controle.demandeFrmFormesValeurs("rond", rayon);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Veuillez saisir un nombre pour le rayon.");
        }
    }

    public void cmdCalculTriangle() {
        try {
            float cote1 = Float.parseFloat(txtTriangleCote1.getText());
            float cote2 = Float.parseFloat(txtTriangleCote2.getText());
            float cote3 = Float.parseFloat(txtTriangleCote3.getText());
            controle.demandeFrmFormesValeurs("triangle", cote1, cote2, cote3);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Veuillez saisir un nombre dans chacun des 3 côtés.");
        } catch (IllegalArgumentException e) {
            // levée par le constructeur de Triangle si les côtés sont impossibles
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void cmdCalculRectangle() {
        try {
            float longueur = Float.parseFloat(txtLongueur.getText());
            float largeur = Float.parseFloat(txtLargeur.getText());
            controle.demandeFrmFormesValeurs("rectangle", longueur, largeur);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Veuillez saisir un nombre pour la longueur et la largeur.");
        }
    }

    // ----- AFFICHAGE DES RÉSULTATS (appelées par le contrôleur) -----
    public void afficheResultCarre(float perimetre, float surface) {
        lblPerimetreCarre.setText("" + perimetre);
        lblSurfaceCarre.setText("" + surface);
    }

    public void afficheResultRond(float perimetre, float surface) {
        lblPerimetreRond.setText("" + perimetre);
        lblSurfaceRond.setText("" + surface);
    }

    public void afficheResultTriangle(float perimetre, float surface) {
        lblPerimetreTriangle.setText("" + perimetre);
        lblSurfaceTriangle.setText("" + surface);
    }

    public void afficheResultRectangle(float perimetre, float surface) {
        lblPerimetreRectangle.setText("" + perimetre);
        lblSurfaceRectangle.setText("" + surface);
    }
    // ----- LISTE -----
    // remplit la liste à partir de la collection du contrôleur
    public void majLstFormes(ArrayList<Forme> lesFormes) {
        contenuLstFormes.clear();                         // 1. on vide la liste
        for (Forme uneForme : lesFormes) {                // 2. pour chaque forme...
            String ligne;
            if (uneForme instanceof Carre) {
                ligne = "CARRE : cote=" + ((Carre) uneForme).getCote();
            } else if (uneForme instanceof Rond) {
                ligne = "ROND : rayon=" + ((Rond) uneForme).getRayon();
            } else if (uneForme instanceof Triangle) {
                Triangle unTriangle = (Triangle) uneForme;
                ligne = "TRIANGLE : cotes=" + unTriangle.getCote1() + " / " + unTriangle.getCote2() + " / " + unTriangle.getCote3();
            } else {
                Rectangle unRectangle = (Rectangle) uneForme;
                ligne = "RECTANGLE : longueur=" + unRectangle.getLongueur() + " largeur=" + unRectangle.getLargeur();
            }
            ligne += " périmètre=" + uneForme.perimetre() + " surface=" + uneForme.surface();
            contenuLstFormes.addElement(ligne);           // 3. ...on ajoute sa ligne
        }
    }

    // clic sur le bouton del
    public void cmdDel() {
        int[] lesIndices = lstFormes.getSelectedIndices();
        for (int k = lesIndices.length - 1; k >= 0; k--) {
            controle.demandeFrmFormesDel(lesIndices[k]);
        }
    }
}
# TP MVC Java – Formes

Application Java Swing en architecture **MVC** qui calcule le périmètre et la surface de formes géométriques et garde l'historique des calculs.

![formes](src/media/carre.png) ![](src/media/rond.png) ![](src/media/triangle.png) ![](src/media/rectangle.png)

## Consignes du TP

- Ajouter les formes **triangle** et **rectangle** ✅
- Ajouter les **tests unitaires** des calculs du package `modele` ✅

## Fonctionnalités

| Forme | Saisie | Périmètre | Surface |
|---|---|---|---|
| Carré | côté | 4 × c | c² |
| Rond | rayon | 2 × π × r | π × r² |
| Triangle | 3 côtés | a + b + c | formule de Héron |
| Rectangle | longueur, largeur | 2 × (L + l) | L × l |

- Chaque calcul est ajouté à la liste (historique).
- Le bouton **del** supprime les lignes sélectionnées.
- Un triangle impossible (un côté ≥ somme des deux autres) est refusé avec un message.
- Une saisie non numérique affiche un message d'erreur.

## Structure MVC

```
src/
├── controleur/   Controle.java      → point d'entrée (main), fait le lien vue ↔ modèle, garde l'historique
├── modele/       Forme.java         → interface (perimetre(), surface())
│                 Carre, Rond, Triangle, Rectangle
├── vue/          FrmFormes.java     → fenêtre Swing
└── media/        images des formes
test/
└── modele/       CarreTest, RondTest, TriangleTest, RectangleTest (JUnit 5)
```

## Lancer le projet

1. Ouvrir le dossier dans **IntelliJ IDEA**.
2. Lancer `controleur.Controle` (méthode `main`).

## Lancer les tests

Clic droit sur le dossier `test` → **Run 'All Tests'**.
Les bibliothèques JUnit 5 sont fournies dans `lib/`.

Résultat : **18 tests, 18 réussis**.

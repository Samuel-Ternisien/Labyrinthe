package Tests;

import grafix.interfaceGraphique.IG;

public class MaDemoIG {
    public static void main(String[] args) {

        // Ouvrir l'interface graphique
        Object parametres[];

        parametres=IG.saisirParametres();
        //Une fenêtre s'ouvre pour paramettrer le jeu

        //on creer la fenêtre de jeu et on affiche la fenêtre
        int nbJoueurs=((Integer)parametres[0]).intValue();  //Nb de joueur
        IG.creerFenetreJeu("MaDemoIG", nbJoueurs); // Création de la fenêtre
        IG.rendreVisibleFenetreJeu(); // rendre la fenêtre de jeu visible


        //creation de la map
        for(int i = 0; i<=6; i++){
            for(int j = 0; j<=6; j++) {
                IG.changerPiecePlateau(i,j,2,0);

            }
        }
        IG.miseAJourAffichage();


        // Changement des caractéristiques du premier joueur avec les paramètres saisis (nom, image)
        for (int p = 0; p < nbJoueurs; p++) {
            int numImageJoueur = ((Integer) parametres[3 + p * 3]).intValue();
            String nomJoueur0 = (String) parametres[1 + p * 3];
            String categorieJoueur0 = (String) parametres[2 + p * 3];
            IG.changerNomJoueur(p, nomJoueur0 + " (" + categorieJoueur0 + ")");
            IG.changerImageJoueur(p, numImageJoueur);
        }


        // Set les bon item dans les bonnes positions

        for (int i = 0; i < nbJoueurs; i++){
            if (nbJoueurs == 3) {
                for (int j = 0; j < 6; j++) {
                    IG.changerObjetJoueur(i, j + (i * 6), j);
                }
            }
            else {
                for (int j = 0; j < 9; j++) {
                    IG.changerObjetJoueur(i, j + (i * 9), j);
                }
            }
        }
        IG.changerPieceHorsPlateau(1,0);


        IG.miseAJourAffichage();

        // Place des objets sur le plateau

        int numObjet=0;
        int c = 0;
        int l = 0;

        while(numObjet<18){
            c = (numObjet / 7);
            l = (numObjet % 7);
            IG.placerObjetPlateau(numObjet, c, l);
            numObjet++;
        }

        // Place les joueurs sur le plateau

        IG.placerJoueurPrecis(0,3,0,1,0);
        IG.placerJoueurPrecis(1,3,6,1,2);


        //message affichié en bas a droite
        String message[]={
                "",
                "Bonjour !",
                "Cliquez pour continuer !"
        };

        IG.afficherMessage(message); //affiche le message

        IG.miseAJourAffichage();

        IG.attendreClic();

        //bouge les pieces 1 fois et le bonhome de 1 vers le centre
        String message1[]={
                "Cliquez et",
                "Vous allez tournez les",
                "pieces vers la droite 1 fois !"
        };

        IG.afficherMessage(message1); //affiche le message

        IG.miseAJourAffichage();

        IG.attendreClic();

        for(int i = 0; i<=6; i++){
            for(int j = 0; j<=6; j++) {
                IG.changerPiecePlateau(i, j, 2, 1);
            }
        }

        IG.placerJoueurPrecis(0,3,0,1,1);
        IG.placerJoueurPrecis(1,3,6,1,1);

        IG.placerBilleSurPlateau(3,0,1,0,0);
        IG.placerBilleSurPlateau(3,6,1,2,0);

        IG.changerPieceHorsPlateau(1,1);

        IG.enleverObjetPlateau(0,0);
        IG.changerObjetJoueurAvecTransparence(0,0,0);



        //bouge les pieces 2 fois et le bonhome de 1 vers le centre
        String message2[]={
                "Cliquez et",
                "Vous allez tournez les",
                "pieces vers la droite 2 fois !"
        };

        IG.afficherMessage(message2); //affiche le message

        IG.miseAJourAffichage();

        IG.attendreClic();
        for(int i = 0; i<=6; i++){
            for(int j = 0; j<=6; j++) {
                IG.changerPiecePlateau(i, j, 2, 2);
            }
        }

        IG.placerJoueurPrecis(0,3,0,1,2);
        IG.placerJoueurPrecis(1,3,6,1,0);

        IG.placerBilleSurPlateau(3,0,1,1,0);
        IG.placerBilleSurPlateau(3,6,1,1,0);

        IG.changerPieceHorsPlateau(1,2);

        IG.enleverObjetPlateau(0,1);
        IG.changerObjetJoueurAvecTransparence(0,1,1);


        //bouge les pieces 3 fois et le bonhome de 1 vers le centre
        String message3[]={
                "Cliquez et",
                "Vous allez tournez les",
                "pieces vers la droite 3 fois !"
        };

        IG.afficherMessage(message3); //affiche le message

        IG.miseAJourAffichage();

        IG.attendreClic();

        for(int i = 0; i<=6; i++) {
            for (int j = 0; j <= 6; j++) {
                IG.changerPiecePlateau(i, j, 2, 3);
            }
        }

        IG.placerJoueurPrecis(0,3,1,1,0);
        IG.placerJoueurPrecis(1,3,5,1,2);

        IG.placerBilleSurPlateau(3,0,1,2,0);
        IG.placerBilleSurPlateau(3,6,1,0,0);

        IG.changerPieceHorsPlateau(1,3);

        IG.enleverObjetPlateau(0,2);
        IG.changerObjetJoueurAvecTransparence(0,2,2);

        //remet les pieces a leur place et le bonhome de 1 vers le centre
        String message4[]={
                "Cliquez et",
                "Vous allez tournez les",
                "pieces vers la droite 4 fois !"
        };

        IG.afficherMessage(message4); //affiche le message

        IG.miseAJourAffichage();

        IG.attendreClic();

        for(int i = 0; i<=6; i++){
            for(int j = 0; j<=6; j++) {
                IG.changerPiecePlateau(i, j, 2, 0);
            }
        }

        IG.placerJoueurPrecis(0,3,1,1,1);
        IG.placerJoueurPrecis(1,3,5,1,1);

        IG.placerBilleSurPlateau(3,1,1,0,0);
        IG.placerBilleSurPlateau(3,5,1,2,0);

        IG.changerPieceHorsPlateau(1,0);

        IG.enleverObjetPlateau(0,3);
        IG.changerObjetJoueurAvecTransparence(0,3,3);

        //Explication de se qui a etait fait
        String message5[]={
                "Et voilà les pièces",
                "sont revenuesau point de départ",
                "et les bonhome on bouger !",
                "Cliquez pour continuer !"
        };

        IG.afficherMessage(message5); //affiche le message

        IG.miseAJourAffichage();

        IG.attendreClic();

        IG.afficherGagnant(0);

        IG.miseAJourAffichage();

        System.out.println(IG.attendreChoixEntree());

        IG.miseAJourAffichage();

        long timer = System.currentTimeMillis(); //on récupère le temps d’exécution du programme au lancement du timer
        int delay = 2000; //on veut attendre 2000 ms

        while (System.currentTimeMillis() - timer < delay) {  }

        IG.fermerFenetreJeu();
        System.exit(0);


    }
}

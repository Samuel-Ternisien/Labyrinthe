package Tests;

import Composants.Piece;
import grafix.interfaceGraphique.IG;

public class TestPieces {

    /** Fini **/

    public static void main(String[] args) {
        // Ouvrir l'interface graphique
        Object parametres[];

        parametres= IG.saisirParametres();
        //Une fenêtre s'ouvre pour paramettrer le jeu

        //on creer la fenêtre de jeu et on affiche la fenêtre
        int nbJoueurs=((Integer)parametres[0]).intValue();  //Nb de joueur
        IG.creerFenetreJeu("MaDemoIG", nbJoueurs); // Création de la fenêtre
        IG.rendreVisibleFenetreJeu(); // rendre la fenêtre de jeu visible

        //creation tableau carte
        Piece[] Map = Piece.nouvellesPieces();

        //creation de la map
        IG.changerPieceHorsPlateau(Map[49].getModelePiece(),Map[49].getOrientationPiece());
        for(int i = 0; i<=6; i++){
            for(int j = 0; j<=6; j++) {
                IG.changerPiecePlateau(i,j,Map[j+i*7].getModelePiece(),Map[j+i*7].getOrientationPiece());
            }
        }

        // Changement des caractéristiques du premier joueur avec les paramètres saisis (nom, image)
        for (int p = 0; p < nbJoueurs; p++) {
            int numImageJoueur = ((Integer) parametres[3 + p * 3]).intValue();
            String nomJoueur0 = (String) parametres[1 + p * 3];
            String categorieJoueur0 = (String) parametres[2 + p * 3];
            IG.changerNomJoueur(p, nomJoueur0 + " (" + categorieJoueur0 + ")");
            IG.changerImageJoueur(p, numImageJoueur);
        }

        //message affiché en bas a droite
        String message[]={
                "",
                "Bonjour !",
                "Cliquez pour continuer !"
        };
        IG.afficherMessage(message); //affiche le message

        IG.miseAJourAffichage();



        for (int c = 0; c < 4; c++){
            IG.attendreClic();
            for(int i = 0; i < 7; i++){
                for(int j = 0; j < 7; j++) {
                    int OrientationActuelle = Map[i*7+j].getOrientationPiece();
                    Map[i*7+j].setOrientation((OrientationActuelle+1)%4);
                    IG.changerPiecePlateau(i,j,Map[j+i*7].getModelePiece(),Map[j+i*7].getOrientationPiece());
                }
            }
            Map[49].setOrientation((Map[49].getOrientationPiece()+1)%4);
            IG.changerPieceHorsPlateau(Map[49].getModelePiece(),Map[49].getOrientationPiece());
            System.out.println(Map[49].toString()+"\n");
            IG.miseAJourAffichage();
        }
        IG.attendreClic();

        IG.fermerFenetreJeu();
        System.exit(0);
    }
}

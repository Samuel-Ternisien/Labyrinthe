package Tests;

import Composants.Piece;
import Composants.PieceM0;
import Composants.Plateau;
import Composants.Utils;
import grafix.interfaceGraphique.IG;

public class testPlateau {
    public static void main(String[] args) {
        Object parametres[];
        parametres = IG.saisirParametres();

        IG.creerFenetreJeu("Test de la classe Plateau", ((Integer) parametres[0]).intValue());
        IG.rendreVisibleFenetreJeu();

        // Création du plateau initiale
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 6; j++) {
                IG.changerPiecePlateau(i, j, 2, 0);

            }
        }
        IG.miseAJourAffichage();
        String message[] = {
                " ",
                "Cliquez pour continuer !"
        };
        IG.afficherMessage(message);
        IG.miseAJourAffichage();


        Plateau plateau = new Plateau();
        Piece piecehorsplateau = plateau.placerPiecesAleatoirment();
        for (int i = 0;i < 7 ;i ++){
            for (int j = 0; j< 7;j ++){
                IG.changerPiecePlateau(i, j, plateau.getPiece(i,j).getModelePiece(), plateau.getPiece(i,j).getOrientationPiece());
            }
        }


        IG.changerPieceHorsPlateau(piecehorsplateau.getModelePiece(),piecehorsplateau.getOrientationPiece());

        System.out.println("Haut: "+plateau.haut(5,5));
        //System.out.println("Droite: "+plateau.droite(5,5));
        //System.out.println("Bas: "+plateau.bas(5,5));
        //System.out.println("Gauche: "+plateau.gauche(5,5));
        IG.attendreClic();
        IG.miseAJourAffichage();
        String message2[] = {
                " ",
                "Cliquez pour fermer !"
        };
        IG.afficherMessage(message2);
        IG.miseAJourAffichage();
        IG.attendreClic();
        IG.fermerFenetreJeu();
    }
}

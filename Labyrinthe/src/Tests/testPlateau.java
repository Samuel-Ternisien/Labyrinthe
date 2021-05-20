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
        for (int i = 0;i < 6 ;i ++){
            for (int j = 0; j< 6;j ++){
                IG.changerPiecePlateau(i, j, plateau.getPiece(i,j).getModelePiece(), plateau.getPiece(i,j).getOrientationPiece());
            }
        }


        IG.changerPieceHorsPlateau(piecehorsplateau.getModelePiece(),piecehorsplateau.getOrientationPiece());

        System.out.println("Haut: "+plateau.passageEntreCases(5,5,4,5));
        System.out.println("Droite: "+plateau.passageEntreCases(5,5,5,6));
        System.out.println("Bas: "+plateau.passageEntreCases(5,5,6,5));
        System.out.println("Gauche: "+plateau.passageEntreCases(5,5,5,4));
        IG.attendreClic();
        IG.miseAJourAffichage();
        String message2[] = {
                " ",
                "Cliquez pour fermer !"
        };
        IG.afficherMessage(message2);
        IG.attendreClic();
        IG.fermerFenetreJeu();
    }
}

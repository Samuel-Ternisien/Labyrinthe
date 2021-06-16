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
        System.out.println("Liste des chemins trouvés depuis la pièce (3,3):");
        int[][] maxchemin={{0,0}};
        int countm=0;
        for (int i=0;i<7;i++) {
            int count = 0;
            for (int j = 0; j < 7; j++) {
                int[][] chemin = plateau.calculeChemin(3, 3, i, j);
                if (chemin != null) {
                    System.out.println("Chemin entre les cases (3,3) et (" + i + "," + j + ") : " + chemin);
                    if (count > countm) {
                        maxchemin = chemin;
                        countm = count;
                    }
                }
                count = 0;
            }
        }
        System.out.println(plateau.calculeChemin(3,3,3,4));
        IG.changerPieceHorsPlateau(piecehorsplateau.getModelePiece(),piecehorsplateau.getOrientationPiece());


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

package Tests;

import Composants.Piece;
import Composants.Plateau;
import grafix.interfaceGraphique.IG;
import Joueurs.Joueur;
import Partie.ElementsPartie;
/**
 *
 * Cette classe permet de tester les différents éléments d'une partie.
 * Fait par A.B le 09/06
 *
 */
public class testElementsPartie {

    public static void main(String[] args) {

        Object parametresJeu[];
        parametresJeu=IG.saisirParametres();
        int  nbJoueurs=((Integer)parametresJeu[0]).intValue();
        IG.creerFenetreJeu("- TestElementsPartie",nbJoueurs);
        Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
        ElementsPartie elementsPartie=new ElementsPartie(joueurs);
        IG.creerFenetreJeu("Test de la classe Joueurs", nbJoueurs); // Création de la fenêtre
        IG.rendreVisibleFenetreJeu(); // rendre la fenêtre de jeu visible

        // création du plateau
        Plateau plateau = new Plateau();
        Piece pieceHorsPlateau=plateau.placerPiecesAleatoirment();
        for(int i = 0; i<=6; i++){
            for(int j = 0; j<=6; j++) {
                Piece piece = plateau.getPiece(i,j);
                IG.changerPiecePlateau(i,j,piece.getModelePiece(),piece.getOrientationPiece());
                IG.miseAJourAffichage();
            }
        }
        for(int i=0;i<3;i++) {
            int numImageJoueur = joueurs[i].getNumJoueur();
            String nomJoueur = joueurs[i].getNomJoueur();
            String categorieJoueur = joueurs[i].getCategorie();
            IG.changerNomJoueur(i, nomJoueur + " (" + categorieJoueur + ")");
            IG.changerImageJoueur(i, numImageJoueur);
            if(i==0){joueurs[i].setPosition(i,i);
                IG.placerJoueurPrecis(i,joueurs[i].getPosLigne(),joueurs[i].getPosColonne(),1,1);
            }
            if(i==1){
                joueurs[i].setPosition(0,6);
                IG.placerJoueurPrecis(i,joueurs[i].getPosLigne(),joueurs[i].getPosColonne(),1,1);
            }
            if(i==2){joueurs[i].setPosition(6,6);
                IG.placerJoueurPrecis(i,joueurs[i].getPosLigne(),joueurs[i].getPosColonne(),1,1);
            }
            IG.miseAJourAffichage();
            IG.attendreClic();
        }
        String message[]={
                "",
                "",
                "Cliquez pour continuer !"
        };
        int i=0;
        while(i<3){
            int[] choix=joueurs[i].choisirCaseArrivee(null);
            IG.placerJoueurPrecis(i,choix[0],choix[1],1,1);
            i++;
            IG.attendreClic();
        }

        IG.afficherMessage(message);
        IG.miseAJourAffichage();
        IG.attendreClic();

    }

}
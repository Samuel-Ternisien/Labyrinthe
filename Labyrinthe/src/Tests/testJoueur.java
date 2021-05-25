package Tests;

import Composants.Plateau;
import Composants.Piece;
import Joueurs.Joueur;
import grafix.interfaceGraphique.IG;

/**
 * Class permettant le test de la classe Joueur
 * Fait par T.S le 22/05
 * Besoin d'ajout
 */
public class testJoueur {
    public static void main(String[] args) {
        // Classe de test réalisé par nous afin de prendre en main la librairie IG19
        // Ouvrir l'interface graphique
        Object parametres[];

        parametres=IG.saisirParametres();
        // Une fenêtre s'ouvre pour parametrer le jeu

        // Création d'une fenêtre et affichage
        int nbJoueurs=((Integer)parametres[0]).intValue();  //Nb de joueur
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
        Joueur joueurs[]=Joueur.nouveauxJoueurs(parametres);
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

        IG.afficherMessage(message);
        IG.miseAJourAffichage();
        IG.attendreClic();
        //A compléter
    }


}

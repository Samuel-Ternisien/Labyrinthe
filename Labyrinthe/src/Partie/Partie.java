package Partie;

import Composants.Objet;
import Composants.Piece;
import Composants.Plateau;
import grafix.interfaceGraphique.IG;
import Joueurs.Joueur;

public class Partie {
	static double version=0.0;


	private ElementsPartie elementsPartie; // Les éléments de la partie.

	/**
	 * 
	 * (08/06 T.S Fini)
	 * 
	 * Constructeur permettant de créer et d'initialiser une nouvelle partie.
	 */
	public Partie(){
		// Initialisation de la partie
		parametrerEtInitialiser();

		// On affiche l'ensemble des éléments
		for(int i = 0; i<=6; i++){
			for(int j = 0; j<=6; j++) {
				IG.changerPiecePlateau(i,j,elementsPartie.getPlateau().getPiece(i,j).getModelePiece(),elementsPartie.getPlateau().getPiece(i,j).getOrientationPiece());
			}
		}
		//Joueurs
		int c=0;
		for (Joueur joueur:elementsPartie.getJoueurs()) {
			if (c==0){
				joueur.setPosition(0,0);
				c++;
				IG.placerJoueurPrecis(0,0,0,1,1);
			}
			else if (c==1){
				joueur.setPosition(0,6);
				c++;
				IG.placerJoueurPrecis(1,0,6,1,1);
			}
			else if(c==2){
				joueur.setPosition(6,6);
				c++;
				IG.placerJoueurPrecis(2,6,6,1,1);
			}
		}
		//Objet
		for (Objet obj:elementsPartie.getObjets()) {
			IG.placerObjetPlateau(obj.getNumeroObjet(),obj.getPosLignePlateau(),obj.getPosColonnePlateau());
		}
		int cpt=0;
		for (Joueur joueur:elementsPartie.getJoueurs()) {
			int cptObj=0;
			for (Objet obj:joueur.getObjetsJoueur()) {
				IG.changerObjetJoueur(cpt,obj.getNumeroObjet(),cptObj);
				cptObj++;
			}
			cpt++;
		}
		IG.rendreVisibleFenetreJeu();
	}

	/**
	 * Méthode permettant de paramètrer et initialiser les éléments de la partie.
	 */
	private void parametrerEtInitialiser(){
		// Saisie des différents paramètres
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		int nombreJoueurs=((Integer)parametresJeu[0]).intValue();
		IG.creerFenetreJeu("- Version "+version, nombreJoueurs);
		// Création des joueurs
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		// Création des éléments de la partie
		this.elementsPartie=new ElementsPartie(joueurs);
	}


	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de lancer une partie.
	 */
	public void lancer(){

		// A Compléter
	}

	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		Partie partie=new Partie();
		partie.lancer();

	}

}

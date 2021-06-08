package Partie;

import Composants.Objet;
import Composants.Piece;
import Composants.Plateau;
import grafix.interfaceGraphique.IG;
import Joueurs.Joueur;
import Joueurs.JoueurOrdinateur;

public class Partie {
	static double version=0.0;


	//private ElementsPartie elementsPartie; // Les éléments de la partie.

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Constructeur permettant de créer et d'initialiser une nouvelle partie.
	 */
	public Partie(){
		// Initialisation de la partie
		parametrerEtInitialiser();

		// On affiche l'ensemble des éléments
		
		// A Compléter

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
		ElementsPartie elementsPartie=new ElementsPartie(joueurs);
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
		while(true){
			Partie partie=new Partie();
			partie.lancer();
		}
	}

}

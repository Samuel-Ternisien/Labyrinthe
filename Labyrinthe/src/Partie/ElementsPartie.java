package Partie;

import Composants.Objet;
import Composants.Piece;
import Composants.Plateau;
import Composants.Utils;
import Joueurs.Joueur;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 
 * Cette classe permet de représenter un ensemble d'élements composant une partie de jeu.
 * 
 */
public class ElementsPartie {

	private Joueur[] joueurs; 	// Les joueurs de la partie.
	private Objet[] objets; 	// Les 18 objets de la partie dans l'ordre de leurs numéros.
	private Plateau plateau; 	// Le plateau des pièces.
	private Piece pieceLibre; 	// La pièce libre.
	private int nombreJoueurs; 	// Le nombre de joueurs.

	/**
	 * 
	 * (31/05 T.S Fini)
	 * A Faire (31/05 T.S Fini)
	 *
	 * Constructeur permettant de générer et d'initialiser l'ensemble des éléments d'une partie (sauf les joueurs qui sont donnés en paramètres).
	 * 
	 * Un plateau est créé en placant 49 pièces de manière aléatoire (utilisation de la méthode placerPiecesAleatoierment de la classe Plateau).
	 * La pièce restante (celle non présente sur le plateau) est affectée à la pièce libre.
	 * Les 18 objets sont créés avec des positions aléatoires sur le plateau (utilisation de la méthode Objet.nouveauxObjets)
	 * et distribuées aux différents joueurs (utilisation de la méthode attribuerObjetsAuxJoueurs).
	 * 
	 * @param joueurs Les joueurs de la partie. Les objets des joueurs ne sont pas encore attribués (c'est au constructeur de le faire).
	 */
	public ElementsPartie(Joueur[] joueurs) {
		this.joueurs=joueurs;
		this.objets=Objet.nouveauxObjets();
		this.plateau=new Plateau();
		this.pieceLibre=plateau.placerPiecesAleatoirment();
		this.nombreJoueurs=joueurs.length;
		attribuerObjetsAuxJoueurs();
	}

	/**
	 * Un simple constructeur.
	 * 
	 * @param joueurs Les joueurs de la partie.
	 * @param objets Les 18 objets de la partie.
	 * @param plateau Le plateau de jeu.
	 * @param pieceLibre La pièce libre (la pièce hors plateau).
	 */
	public ElementsPartie(Joueur[] joueurs,Objet[] objets,Plateau plateau,Piece pieceLibre) {
		this.joueurs=joueurs;
		nombreJoueurs=joueurs.length;
		this.objets=objets;
		this.plateau=plateau;
		this.pieceLibre=pieceLibre;
	}

	/**
	 * (31/05 T.S a test)
	 * 
	 * Méthode permettant d'attribuer les objets aux différents joueurs de manière aléatoire.
	 */
	private void attribuerObjetsAuxJoueurs() {
		if (this.nombreJoueurs == 2) {
			int nbrObjet = 9;
			Vector<Integer> objAjout = new Vector<>(18);
			Objet[] joueur1 = new Objet[nbrObjet+1];
			int cpt1 = 0;
			int cpt2 = 0;
			Objet[] joueur2 = new Objet[nbrObjet+1];
			while (objAjout.size() != 18) {
				int random = Utils.genererEntier(18);
				if (!(objAjout.contains(random))) {
					if (objAjout.size() < nbrObjet) {
						joueur1[cpt1] = new Objet(random);
						objAjout.add(random);
						cpt1++;
					} else {
						joueur2[cpt2] = new Objet(random);
						objAjout.add(random);
						cpt2++;
					}
				}
			}
			joueurs[0].setObjetsJoueur(joueur1);
			joueurs[1].setObjetsJoueur(joueur2);
		} else if (this.nombreJoueurs == 3) {
			int nbrObjet = 6;
			Vector<Integer> objAjout = new Vector<>(18);
			Objet[] joueur1 = new Objet[nbrObjet];
			int cpt1 = 0;
			int cpt2 = 0;
			Objet[] joueur2 = new Objet[nbrObjet];
			Objet[] joueur3 = new Objet[nbrObjet];
			int cpt3 = 0;
			while (objAjout.size() != 18) {
				int random = Utils.genererEntier(18);
				if (!(objAjout.contains(random))) {
					if (objAjout.size() < 6) {
						joueur1[cpt1] = new Objet(random);
						objAjout.add(random);
						cpt1++;
					} else if (objAjout.size() < 12) {
						joueur2[cpt2] = new Objet(random);
						cpt2++;
						objAjout.add(random);
					} else {
						joueur3[cpt3] = new Objet(random);
						cpt3++;
						objAjout.add(random);
					}
				}
			}
			joueurs[0].setObjetsJoueur(joueur1);
			joueurs[1].setObjetsJoueur(joueur2);
			joueurs[2].setObjetsJoueur(joueur3);
		}
	}

	/**
	 * (20/05/21 B.B Effectué)
	 * 
	 * Méthode permettant de récupérer les joueurs de la partie.
	 * @return Les joueurs de la partie.
	 */
	public Joueur[] getJoueurs() {
		return this.joueurs;
	}


	/**
	 * (20/05/21 B.B Effectué)
	 * 
	 * Méthode permettant de récupérer les pièces de la partie.
	 * @return Les objets de la partie.
	 */
	public Objet[] getObjets() {
		return this.objets;
	}


	/**
	 * (20/05/21 B.B Effectué)
	 * 
	 * Méthode permettant de récupérer le plateau de pièces de la partie.
	 * @return Le plateau de pièces.
	 */
	public Plateau getPlateau() {
		return this.plateau;
	}


	/**
	 * (20/05/21 B.B Effectué)
	 * 
	 * Méthode permettant de récupérer la pièce libre de la partie.
	 * @return La pièce libre.
	 */
	public Piece getPieceLibre() {
		return this.pieceLibre;
	}


	/**
	 * (20/05/21 B.B Effectué)
	 * 
	 * Méthode permettant de récupérer le nombre de joueurs de la partie.
	 * @return Le nombre de joueurs.
	 */
	public int getNombreJoueurs() {
		return this.nombreJoueurs;
	}

	/**
	 * (06/06 T.S Ajouté)
	 * Méthode supplémentaire déplacement la pièce 1 dans la position 2
	 * @param posLig,posCol,posLig2,posCol2 ligne et colonnes des pieces a déplacer
	 * @return la piece déplacer
	 */
	public Piece bougePiece(int posLig,int posCol,int posLig2,int posCol2){
		Piece pieceTemp=plateau.getPiece(posLig2,posCol2);
		plateau.positionnePiece(plateau.getPiece(posLig,posCol2),posLig2,posCol2);
		return pieceTemp;
	}
	public Piece bougePiece(int posLig,int posCol,Piece piece){
		Piece pieceTemp=plateau.getPiece(posLig,posCol);
		plateau.positionnePiece(piece,posLig,posCol);
		return pieceTemp;
	}

	/**
	 * (08/06 T.S Fini)
	 * 
	 * Méthode modifiant les différents éléments de la partie suite à l'insertion de la pièce libre dans le plateau.
	 * 
	 * @param choixEntree L'entrée choisie pour réaliser l'insertion (un nombre entre 0 et 27).
	 */
	public void insertionPieceLibre(int choixEntree){
		List<Integer> haut=new ArrayList<Integer>(7);
		List<Integer> droite=new ArrayList<Integer>(7);
		List<Integer> bas=new ArrayList<Integer>(7);
		List<Integer> gauche=new ArrayList<Integer>(7);
		for (int i = 0; i < 7; i++) {
			haut.add(i);
		}
		for (int i = 7; i < 14; i++) {
			droite.add(i);
		}
		for (int i = 14; i < 21; i++) {
			bas.add(i);
		}
		for (int i = 21; i < 28; i++) {
			gauche.add(i);
		}

		if (haut.contains(choixEntree)) {
			for (int i = 6; i >= 0; i--) {
				Piece temp = plateau.getPiece(choixEntree-1,6);
				if (i==0){
					plateau.positionnePiece(temp,i,choixEntree);
				}
				else if (i==6){
					pieceLibre= plateau.getPiece(i,choixEntree);
					plateau.positionnePiece(plateau.getPiece(6,choixEntree),i,choixEntree );
				}
				else{
					plateau.positionnePiece(plateau.getPiece(i-1,choixEntree),i,choixEntree);
				}
			}
		} else if (droite.contains(choixEntree)) {
			for (int i = 0; i <= 6; i++) {
				Piece temp = plateau.getPiece(choixEntree-7,0);
				if (i==6){
					plateau.positionnePiece(temp,choixEntree-7,i);
				}
				else if (i==0){
					pieceLibre= plateau.getPiece(choixEntree-7,i);
					plateau.positionnePiece(plateau.getPiece(choixEntree-7,0),choixEntree-7,i);
				}
				else{
					plateau.positionnePiece(plateau.getPiece(choixEntree-7,i+1),choixEntree-7,i);
				}
			}
		} else if (bas.contains(choixEntree)) {
			for (int i = 0; i <= 6; i++) {
				Piece temp = plateau.getPiece(choixEntree-14,0);
				if (i==6){
					plateau.positionnePiece(temp,i,choixEntree-14);
				}
				else if (i==0){
					pieceLibre= plateau.getPiece(i,choixEntree-14);
					plateau.positionnePiece(plateau.getPiece(0,choixEntree-14),i,choixEntree-14 );
				}
				else{
					plateau.positionnePiece(plateau.getPiece(i-1,choixEntree-14),i,choixEntree-14);
				}
			}

		} else if (gauche.contains(choixEntree)) {
			for (int i = 6; i >= 0; i--) {
				Piece temp = plateau.getPiece(choixEntree-21,6);
				if (i==6){
					pieceLibre= plateau.getPiece(choixEntree-21,i);
					plateau.positionnePiece(plateau.getPiece(choixEntree-21,6),choixEntree-21,i);
				}
				else if (i==0){
					System.out.println(plateau.getPiece(choixEntree-21,i));
					plateau.positionnePiece(temp,choixEntree-21,i);
					System.out.println(plateau.getPiece(choixEntree-21,i));
				}
				else{
					plateau.positionnePiece(plateau.getPiece(choixEntree-21,i-1),choixEntree-21,i);
				}
			}
		}



	}


	/**
	 * Méthode retournant une copie.
	 * 
	 * @return Une copie des éléments.

	public ElementsPartie copy(){
		Objet[] nouveauxObjets=new Objet[(this.objets).length];
		for (int i=0;i<objets.length;i++)
			nouveauxObjets[i]=(this.objets[i]).copy();
		Joueur[] nouveauxJoueurs=new Joueur[nombreJoueurs];
		for (int i=0;i<nombreJoueurs;i++)
			nouveauxJoueurs[i]=(this.joueurs[i]).copy(objets);
		Plateau nouveauPlateau=(this.plateau).copy();
		Piece nouvellePieceLibre=(this.pieceLibre).copy();
		ElementsPartie nouveauxElements=new  ElementsPartie(nouveauxJoueurs,nouveauxObjets,nouveauPlateau,nouvellePieceLibre); 
		return nouveauxElements;
	}
	 */
}

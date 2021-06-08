package Partie;

import Composants.Objet;
import Composants.Piece;
import Composants.Plateau;
import Composants.Utils;
import Joueurs.Joueur;
import java.util.ArrayList;
import java.util.List;

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

		this.joueurs=joueurs;
		this.objets=Objet.nouveauxObjets();
		this.plateau=new Plateau();
		this.pieceLibre=plateau.placerPiecesAleatoirment();
		this.nombreJoueurs=joueurs.length;


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
	private void attribuerObjetsAuxJoueurs(){
		if(this.nombreJoueurs==2){
			int nbrObjet=9;
			int cpt=0;
			int[] obj=new int[nbrObjet];
			for(int i=0;i<nombreJoueurs;i++){
				int[] tbl=Utils.genereTabIntAleatoirement(nbrObjet);
				Objet[] objTemp= new Objet[nbrObjet];
				for (int j:tbl) {
					objTemp[cpt]=new Objet(j);
					cpt++;
					if(cpt==nbrObjet){
						cpt=0;
					}
				}
			}
		}else if(this.nombreJoueurs==3) {
			int nbrObjet = 9;
			int cpt = 0;
			int[] obj = new int[nbrObjet];
			for (int i = 0; i < nombreJoueurs; i++) {
				int[] tbl = Utils.genereTabIntAleatoirement(nbrObjet);
				Objet[] objTemp = new Objet[nbrObjet];
				for (int j : tbl) {
					objTemp[cpt] = new Objet(j);
					cpt++;
					if (cpt == nbrObjet) {
						cpt = 0;
					}
				}
			}
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
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode modifiant les différents éléments de la partie suite à l'insertion de la pièce libre dans le plateau.
	 * 
	 * @param choixEntree L'entrée choisie pour réaliser l'insertion (un nombre entre 0 et 27).
	 */
	/**public void insertionPieceLibre(int choixEntree){
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
		System.out.println(haut);
		System.out.println(droite);
		System.out.println(gauche);
		System.out.println(bas);

		if (haut.contains(choixEntree)){
			for (int i = 0; i < 7; i++) {
				if (i==0){
					Piece temp=bougePiece(choixEntree,i,choixEntree,i+1);
					plateau.positionnePiece(pieceLibre,choixEntree,0);
				}else if(i==5){
						pieceLibre=bougePiece(choixEntree,i,choixEntree,i+1);
				}else{
					Piece temp=bougePiece(choixEntree,i,temp);
				}
			}
		}else if (droite.contains(choixEntree)){
			for (int i = 7; i > 7; i--) {
				if (i==5){
					Piece temp=bougePiece(i,choixEntree,i-1,choixEntree);
					plateau.positionnePiece(pieceLibre,i,choixEntree);
				}else if(i==5){
					pieceLibre=bougePiece(i,choixEntree,i-1,choixEntree);
				}else{
					Piece temp=bougePiece(i,choixEntree,temp);
				}
			}
		}else if (bas.contains(choixEntree)){
			for (int i = 7; i > 7; i--) {
				if (i==0){
					Piece temp=bougePiece(choixEntree,i,choixEntree,i-1);
					plateau.positionnePiece(pieceLibre,choixEntree,0);
				}else if(i==5){
					pieceLibre=bougePiece(choixEntree,i,choixEntree,i-1);
				}else{
					Piece temp=bougePiece(choixEntree,i,temp);
				}
			}

		}else if (gauche.contains(choixEntree)){
			for (int i = 0; i < 7; i++) {
				if (i==5){
					Piece temp=bougePiece(i,choixEntree,i+1,choixEntree);
					plateau.positionnePiece(pieceLibre,i,choixEntree);
				}else if(i==5){
					pieceLibre=bougePiece(i,choixEntree,i+1,choixEntree);
				}else{
					Piece temp=bougePiece(i,choixEntree,temp);
				}
			}
		}
		// A Compléter
	}
**/


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

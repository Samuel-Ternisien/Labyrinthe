package Joueurs;

import Composants.Objet;
import Composants.Piece;
import Composants.Plateau;
import Composants.Utils;
import Partie.ElementsPartie;

/**
 * 
 * Cette classe permet de représenter un joueur ordinateur de type T2.
 * 
 * @author Jean-François Condotta - 2021
 *
 */

public class JoueurOrdinateurT2 extends JoueurOrdinateur {

	/**
	 * Constructeur permettant de créer un joueur.
	 *
	 * @param numJoueur Le numéro du joueur.
	 * @param nomJoueur Le nom du joueur.
	 * @param numeroImagePersonnage Le numéro de l'image représentant le joueur.
	 * @param posLignePlateau La ligne du plateau sur laquelle est positionnée le joueur.
	 * @param posColonnePlateau La colonne du plateau sur laquelle est positionnée le joueur.

	 */
	public JoueurOrdinateurT2(int numJoueur,String nomJoueur, int numeroImagePersonnage,int posLignePlateau,int posColonnePlateau) {
		super(numJoueur,nomJoueur, numeroImagePersonnage,posLignePlateau,posColonnePlateau);
	}

	@Override
	public String getCategorie() {
		return "OrdiType2";
	}


	@Override
	public Joueur copy(Objet objets[]){
		Joueur nouveauJoueur=new JoueurOrdinateurT2(getNumJoueur(),getNomJoueur(), getNumeroImagePersonnage(),getPosLigne(),getPosColonne());
		nouveauJoueur.setObjetsJoueur(this.getObjetsJoueurGeneral(objets));
		while (nouveauJoueur.getNombreObjetsRecuperes()!=this.getNombreObjetsRecuperes())
			nouveauJoueur.recupererObjet();
		return nouveauJoueur;
	}

	private int[] RechercheObjet(){
		Objet objet = this.getObjetsJoueur()[0];
		int [] res = new int[2];
		if(objet.surPlateau()) {
			int x = objet.getPosColonnePlateau();
			int y = objet.getPosLignePlateau();
			res[0]=x;
			res[1]=y;
			return res;
		}
		return res;

	}

	public void VaChercher(int [] coordonnée) {
		int [][] chemin = Plateau.calculeChemin(this.getPosLigne(), this.getPosColonne(), coordonnée[1], coordonnée[0]);
		for(int i = 0; i < chemin.length; i++){
			this.setPosition(chemin[i][0],chemin[i][1]);
		}

	}
}
package Composants;

/**
 * 
 * Cette classe permet de représenter chacun des objets du jeu.
 *
 */
public class Objet {

	private int numObjet; // Le numéro de l'objet (un entier entre 0 et 17).
	private int posLignePlateau; // La ligne du plateau sur laquelle est éventuellement posé l'objet (un entier entre -1 et 6, -1:lorsqu'il n'est pas sur le plateau).
	private int posColonnePlateau; // La colonne du plateau sur laquelle est éventuellement posé l'objet (un entier entre -1 et 6, -1:lorsqu'il n'est pas sur le plateau).
	private boolean surPlateau; // Indique si l'objet est sur le plateau ou non (true : sur le plateau, false : hors du plateau).

	/**
	 * 
	 *  (18/05/21 B.B Effectué)
	 * 
	 * Constructeur permettant de construire un objet qui est initialement hors du plateau.
	 * 
	 * @param numObjet Le numéro de l'objet.
	 */
	public Objet(int numObjet) {
		this.numObjet=numObjet;
		this.posColonnePlateau=-1;
		this.posLignePlateau=-1;
		this.surPlateau=false;
	}

	/**
	 * 
	 *  (18/05/21 T.S Fini)
	 * 
	 * Méthode permettant de générer un tableau contenant les 18 objets du jeu.
	 * Les objets seront postionnées aléatoirement sur le plateau.  Deux objets ne pourront pas être sur une même case (même ligne et même colonne).
	 * 
	 * @return Un tableau de 18 objets initialisés pour une partie du jeu. Chaque objet a une position générée aléatoirement. Les positions sont différentes pour deux objets distincts.
	 *
	 */
	/**
	 if (obj.surPlateau()==false) {
	 for (Objet objt : tablObjet) {
	 if (objt != null) {
	 if (obj.getPosLignePlateau() == randomc && obj.getPosColonnePlateau() == randoml) {
	 i--;
	 }else {
	 tablObjet[i]= new Objet(i);
	 tablObjet[i].positionneObjet(randoml, randomc);
	 }
	 }
	 }
	 } else {
	 tablObjet[i] = new Objet(i);
	 tablObjet[i].positionneObjet(randoml, randomc);
	 }
	 **/
	public static Objet[] nouveauxObjets() {
		Objet[] tablObjet = new Objet[18];
		boolean placementok=false;
		for (int i = 0; i < 18; i++) {
			tablObjet[i] = new Objet(i);
		}
		for (int i = 0; i < 18; i++) {
			while (tablObjet[i].surPlateau() == false) {
				int randoml = Utils.genererEntier(7);
				int randomc = Utils.genererEntier(7);
				for (Objet obj:tablObjet) {
					if(obj.getPosColonnePlateau()!=randomc && obj.getPosLignePlateau()!=randoml){
						placementok= true;
					}else if(obj.getPosColonnePlateau()==randomc && obj.getPosLignePlateau()==randoml){
						placementok=false;
						break;}
				}
				if(placementok){
					tablObjet[i].positionneObjet(randoml,randomc);}
			}
		}
		return tablObjet;
	}


	/**
	 * 
	 *  (18/05/21 B.B Effectué)
	 * 
	 * Méthode retournant le numéro de l'objet.
	 * 
	 * @return Le numéro de l'objet.
	 */
	public int getNumeroObjet(){
		return this.numObjet;
	}


	/**
	 * 
	 *  (18/05/21 B.B Effectué)
	 * 
	 * Méthode retournant le numéro de la ligne sur laquelle se trouve l'objet.
	 * 
	 * @return Le numéro de la ligne sur laquelle se trouve l'objet.
	 */
	public int getPosLignePlateau() {
		return this.posLignePlateau;
	}

	/**
	 * 
	 *  (18/05/21 B.B Effectué)
	 * 
	 * Méthode retournant le numéro de la colonne sur laquelle se trouve l'objet.
	 * 
	 * @return Le numéro de la colonne sur laquelle se trouve l'objet.
	 */
	public int getPosColonnePlateau() {
		return this.posColonnePlateau;
	}
	
	
	/**
	 * 
	 *  ( 18/05/21 T.S Fini)
	 * 
	 * Méthode permettant de positionner l'objet sur une ligne et une colonne données en paramètre.
	 * 
	 * @param lignePlateau Un entier compris entre 0 et 6.
	 * @param colonnePlateau Un entier compris entre 0 et 6.
	 */
	public void positionneObjet(int lignePlateau,int colonnePlateau){
		this.posColonnePlateau=colonnePlateau;
		this.posLignePlateau=lignePlateau;
		this.surPlateau=true;
	}

	/**
	 * 
	 * (18/05/21 T.S Fini)
	 * 
	 * Méthode permettant d'enlever l'objet du plateau.
	 * 
	 */
	public void enleveDuPlateau(){
		this.posColonnePlateau=-1;
		this.posLignePlateau=-1;
		this.surPlateau=false;
	}
	
	/**
	 * 
	 * (18/05/21 B.B Effectué)
	 * 
	 * Méthode indiquant si l'objet est sur le plateau au non.
	 * 
	 * @return true si l'objet est sur le plateau, false sinon.
	 */
	public boolean surPlateau() {
		return surPlateau;
	}
	
	/**
	 * 
	 * Méthode permettant de copier l'objet.
	 * 
	 * @return Une copie de l'objet.
	 */
	public Objet copy(){
		Objet objet=new Objet(numObjet);
		objet.posLignePlateau=posLignePlateau;
		objet.posColonnePlateau=posColonnePlateau;
		objet.surPlateau=surPlateau;
		return objet;
	}

	/**
	 * Methode toString ajouté par Ternisien Samuel le 18/05
	 * @return tout les attributs de l'objet
	 */
	@Override
	public String toString() {
		return "Objet{" +
				"numObjet=" + numObjet +
				", posLignePlateau=" + posLignePlateau +
				", posColonnePlateau=" + posColonnePlateau +
				", surPlateau=" + surPlateau +
				'}';
	}

	/**
	 * Programme testant quelques méthodes de la classe Objet.
	 * @param args arguments du programme
	 */
	public static void main(String[] args) {
		// Un petit test ...
		System.out.println("*** Génération et affichage des 18 objets ... ***");
		Objet objetsJeu[]=nouveauxObjets();
		for (int i=0;i<objetsJeu.length;i++)
			System.out.println(objetsJeu[i]);
		System.out.println("*** On enlève les 18 objets du plateau ... ***");
		for (int i=0;i<objetsJeu.length;i++)
			 objetsJeu[i].enleveDuPlateau();
		System.out.println("*** On affiche de nouveau les 18 objets ... ***");
		for (int i=0;i<objetsJeu.length;i++)
			System.out.println(objetsJeu[i]);
	}
	
}

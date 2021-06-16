package Composants;

/**
 *
 * Cette classe permet de représenter les différentes piéces du jeu.
 *
 */
public class Piece {

    private int modelePiece; 		// Le modéle de la pièce
    private int orientationPiece; 	// L'orientation de la pièce
    private boolean[] pointsEntree = new boolean[4]; // Les points d'entrée indice 0 pour le haut, 1 pour la droite, 2 pour le bas et 3 pour la gauche.

    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Constructeur permettant de créer une piéce d'un modéle avec l'orientation 0.
     * @param modelePiece Le modéle de la pièce.
     * @param pointEntreeHaut Un booléen indiquant si la pièce a un point d'entrée en haut.
     * @param pointEntreeDroite Un booléen indiquant si la pièce a un point d'entrée à  droite.
     * @param pointEntreeBas Un booléen indiquant si la pièce a un point d'entrée en bas.
     * @param pointEntreeGauche Un booléen indiquant si la piéce a un point d'entrée à  gauche.
     */

    public Piece(int modelePiece,boolean pointEntreeHaut,boolean pointEntreeDroite,boolean pointEntreeBas,boolean pointEntreeGauche){
        this.modelePiece = modelePiece;
        this.orientationPiece = 0;
        this.pointsEntree[0] = pointEntreeHaut;
        this.pointsEntree[1] = pointEntreeDroite;
        this.pointsEntree[2] = pointEntreeBas;
        this.pointsEntree[3] = pointEntreeGauche;
    }

    /**
     * Méthode retournant un String représentant la piéce.
     */
    @Override
    public String toString() {
        return "[m:"+modelePiece+"|o:"+orientationPiece+"|pe:"+pointsEntree[0]+" "+pointsEntree[1]+" "+pointsEntree[2]+" "+pointsEntree[3]+"]";
    }

    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Méthode permettant de rotationner une pièce dans le sens horaire.
     */

    public void rotation(){
        this.orientationPiece = (this.orientationPiece + 1) % 4;

        boolean e = pointsEntree[0];
        for ( int i = 0; i<4; i++) {
            if (e == true) {
                e = this.pointsEntree[(i+1)%4];
                this.pointsEntree[(i+1)%4] = true;
                            }
            else {
                e = this.pointsEntree[(i+1)%4];
                this.pointsEntree[(i+1)%4] = false;
            }
        }
    }

    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Méthode permettant d'orienter une pièce vers une orientation spécifique.
     * @param orientationPiece Un entier correspondant à la nouvelle orientation de la pièce.
     */
    public void setOrientation(int orientationPiece){
        while (this.orientationPiece != orientationPiece){
            this.rotation();
        }
    }

    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Méthode retournant le modèle de la pièce.
     * @return Un entier corrspondant au modèle de la pièce.
     */
    public int getModelePiece() {
        return this.modelePiece;
    }

    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Méthode retournant l'orientation de la pièce.
     * @return un entier retournant l'orientation de la pièce.
     */
    public int getOrientationPiece() {
        return this.orientationPiece;
    }

    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Méthode indiquant si il existe un point d'entrée à une certaine position (0: en haut, 1: à droite, 2: en bas, 3: à gauche).
     * @param pointEntree L'indice/la position du point d'entrée.
     * @return true si il y a un point d'entrée, sinon false.
     */
    public boolean getPointEntree(int pointEntree){
        return this.pointsEntree[pointEntree];
    }

    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Méthode permettant de créer un tableau contenant toutes les piéces du jeu (les 50 pièces).
     * Le tableau contiendra 20 pièces du modéle 0, 12 pièces du modéle 1 et 18 pièces du modéle 2.
     * L'orientation de chaque pièce sera aléatoire.
     * @return Un tableau contenant toutes les pièces du jeu.
     */
    public static Piece[] nouvellesPieces(){
        Piece pieces[]= new Piece[50];
        for (int i = 0; i <50; i++){
            if (i < 20) {
                Piece piece = new Piece(0,false,true,true,false);
                int aleatoire = Utils.genererEntier(4);
                piece.setOrientation(aleatoire);
                pieces[i] = piece;
            }
            else {
                if (i >= 20 && i < 32){
                    Piece piece = new Piece(1,true,false,true,false);
                    int aleatoire = Utils.genererEntier(4);
                    piece.setOrientation(aleatoire);
                    pieces[i] = piece;
                }
                else {
                    Piece piece = new Piece(2,true,true,false,true);
                    int aleatoire = Utils.genererEntier(4);
                    piece.setOrientation(aleatoire);
                    pieces[i] = piece;
                }
            }
        }
        return pieces;
    }

}
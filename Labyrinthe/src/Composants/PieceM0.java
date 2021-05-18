package Composants;

/**
 *
 * Cette classe permet de représenter les pièces du jeu de modéle 0.
 *
 */
public class PieceM0 extends Piece {

    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Constructeur permettant de construire une pièce de modéle 0 et d'orientation 0.
     */
    public PieceM0() {
        super(0,false,true,true,false);
    }
    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Méthode permettant de créer une copie de la pièce (un nouvelle objet Java).
     * @return Une copie de la pièce.
     */

    public Piece copy(){
        Piece pieceCopy=new PieceM0();
        return pieceCopy;
    }
}
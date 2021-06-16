package Composants;

/**
 *
 * Cette classe permet de représenter les piéces du jeu de modéle 2.
 *
 */
public class PieceM2 extends Piece {

    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Constructeur permettant de construire une piéce de modéle 2 et d'orientation 0.
     */
    public PieceM2() {
        super(2,true,true,false,true);
    }
    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Méthode permettant de créer une copie de la piéce (un nouvelle objet Java).
     * @return Une copie de la piéce.
     */
    public Piece copy(){
        Piece pieceCopy=new PieceM2();
        return pieceCopy;
    }
}

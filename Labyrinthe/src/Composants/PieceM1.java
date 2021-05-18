package Composants;

/**
 *
 * Cette classe permet de représenter les piéces du jeu de modéle 1.
 *
 */
public class PieceM1 extends Piece {

    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Constructeur permettant de construire une piéce de modéle 1 et d'orientation 0.
     */
    public PieceM1() {
        // A Modifier !!!
        super(1,true,false,true,false);
    }
    /**
     * (23/04/2021  / L.A. / Fini)
     *
     * Méthode permettant de créer une copie de la piéce (un nouvelle objet Java).
     * @return Une copie de la piéce.
     */
    public Piece copy(){
        Piece pieceCopy=new PieceM1();
        return pieceCopy;
    }
}

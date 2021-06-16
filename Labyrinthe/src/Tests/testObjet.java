package Tests;

import Composants.Objet;
import grafix.interfaceGraphique.IG;

/**
 * Classe de test pour la classe objet
 * Cette classe ne contient qu'un main avec pour simple utilité l'affichage d'un plateau de jeu et le placement de 18 objets
 * Les objets sont générés aléatoirement via la méthode NouveauxObjets de la classe Objet
 *
 * Fait par Ternisien Samuel le 18/05
 */

public class testObjet {
    public static void main(String[] args) {
        Object parametres[];
        parametres=IG.saisirParametres();

        IG.creerFenetreJeu("Test de la classe Objet",((Integer)parametres[0]).intValue());
        IG.rendreVisibleFenetreJeu();
        String message[]={
                "Pour chaque nouvel objet",
                "Un clic est demandé",
                "Cliquez pour continuer !"
        };
        IG.afficherMessage(message);
        IG.miseAJourAffichage();
        Objet[] objets = Objet.nouveauxObjets();
        for (Objet obj:objets) {
            IG.placerObjetPlateau(obj.getNumeroObjet(),obj.getPosLignePlateau(),obj.getPosColonnePlateau());
            IG.miseAJourAffichage();
            String m[]= {"",
                    "En attente d'un clic"
            };
            IG.afficherMessage(m);
            IG.attendreClic();
            System.out.println(obj);
        }
        String messagefin[]={
                "",
                "Fini",
                "Cliquez pour fermer !"
        };
        IG.afficherMessage(messagefin);
        IG.miseAJourAffichage();
        IG.attendreClic();

        IG.fermerFenetreJeu();
        System.exit(0);


    }

}

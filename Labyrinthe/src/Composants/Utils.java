package Composants;

import java.util.Date;
import java.util.Random;

/**
 *
 * Classe contenant quelques fonctions utilitaires.
 *
 */
public class Utils {

    private static Random generateur = new Random((new Date().getTime()));

    /**
     * (21/04/2021 / L.A / Fini)
     * <p>
     * Méthode permettant de générer aléatoirement un nombre entier.
     *
     * @param max Le nombre entier maximal pouvant être retourné.
     * @return Un nombre entier compris entre 0 et max (inclus).
     */

    public static int genererEntier(int max) {
        int nbAleatoire = 0;
        if (max <= 0) return -1;
        else {
            Random generateur = new Random();
            nbAleatoire = generateur.nextInt(max);
        }
        return nbAleatoire;
    }

    /**
     * (23/04/2021 / L.A / Fini)
     * <p>
     * Méthode permettant de générer un tableau d'entiers dont la longueur longTab
     * est donnée en paramêtre.
     * Le tableau généré doit contenir chaque entier compris entre 0 et longTab-1.
     * La position de ces entiers dans le tableau doit être aléatoire.
     *
     * @param longTab La longueur du tableau.
     * @return Un tableau contenant les entiers 0,...,longTab-1 placés aléatoirement dans le tableau.
     */
    public static int[] genereTabIntAleatoirement(int longTab) {
        int[] tb = new int[longTab];
        for (int i = 1; i < longTab; i++) {
            boolean placer = false;
            while (placer != true) {
                int placementAleatoire = genererEntier(longTab);
                if (tb[placementAleatoire] == 0) {
                    tb[placementAleatoire] = i;
                    placer = true;
                }
            }
        }
        return tb;
    }

    public static boolean inList(int[] list, int intt) {
        for (int intl : list) {
            if (intl == intt) {
                return true;
            }
        }
        return false;
    }


    /**
     * Programme testant la méthode genereTabIntAleatoirement.
     *
     * @param args arguments du programme
     */
    public static void main(String[] args) {
        // Un petit test ...
        int tab[] = genereTabIntAleatoirement(18);
        for (int i = 0; i < tab.length; i++)
            System.out.print(tab[i] + " ");

    }
}

/**
 * 
 */
package labo1;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Pierrick BOBET - 17 131 792
 * @author Bebo
 *
 */
public class Polygone extends Dessin
{
    private NuagePoints monPolygonePoints;
    private ArrayList<Ligne> monPolygoneLignes;

    Polygone()
    {
        monPolygonePoints = new NuagePoints();
        monPolygoneLignes = new ArrayList<Ligne>();
    }

    public void dessiner(Graphics2D graph)
    {
        monPolygonePoints.dessiner(graph);

        for (int boucleLignes = 0; boucleLignes < monPolygoneLignes.size(); boucleLignes++)
        {
            monPolygoneLignes.get(boucleLignes).dessiner(graph);
        }
    }

    /*
     * Fonction qui obtient les coordonn�es du point � partir d'un flot
     * d'entiers
     */
    public void lire(Scanner reader) throws Exception
    {
        monPolygonePoints.lire(reader);

        for (int bouclePoints = 0; bouclePoints < monPolygonePoints.lenuage.size() - 1; bouclePoints++)
        {
            monPolygoneLignes.add(new Ligne(monPolygonePoints.lenuage.get(bouclePoints),
                    monPolygonePoints.lenuage.get(bouclePoints + 1)));
        }

        monPolygoneLignes.add(
                new Ligne(monPolygonePoints.lenuage.get(monPolygoneLignes.size()), monPolygonePoints.lenuage.get(0)));
    }

    public String toString()
    {
        StringBuffer chaine = new StringBuffer();

        for (int boucle = 0; boucle < monPolygoneLignes.size(); boucle++)
        {
            chaine.append(("\nPolygome : \n\tNuage de points :\n" + monPolygonePoints.toString() + "\n\tLignes :\n"));

            for (int boucleLignes = 0; boucleLignes < monPolygoneLignes.size(); boucleLignes++)
                chaine.append(monPolygoneLignes.get(boucleLignes).toString());
        }

        return chaine.append("\n").toString();
    }
}

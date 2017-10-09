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
public class NuagePoints extends Dessin
{
    private int nombrePoint;
    protected ArrayList<Point> lenuage;

    /**
     * Constructeur par défaut
     */
    public NuagePoints()
    {
        nombrePoint = 0;
        lenuage = new ArrayList<Point>();
    }

    public void dessiner(Graphics2D graph)
    {
        for (int boucle = 0; boucle < lenuage.size(); boucle++)
        {
            lenuage.get(boucle).dessiner(graph);
        }
    }

    /*
     * Fonction qui obtient les coordonn�es du point � partir d'un flot
     * d'entiers
     */
    public void lire(Scanner reader) throws Exception
    {
        Point tempPoint;

        nombrePoint = reader.nextInt();

        // Verification de la quantité de points
        if (nombrePoint <= 0)
            throw new Exception(
                    "Le nombre indicant la quantité de points est incorrect (Doit être positif et différent de 0) !");

        for (int boucle = 0; boucle < nombrePoint; boucle++)
        {
            tempPoint = new Point();
            tempPoint.lire(reader);

            boolean test = lenuage.contains(tempPoint);
            if (test)
                throw new Exception("Duplication de points dans le nuage !");
            else
                lenuage.add(boucle, tempPoint);
        }
    }

    public String toString()
    {
        StringBuffer chaine = new StringBuffer();

        for (int boucle = 0; boucle < nombrePoint; boucle++)
        {
            chaine.append((lenuage.get(boucle).toString() + "\n"));
        }

        return chaine.toString();
    }
}

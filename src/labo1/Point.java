package labo1;

import java.awt.Graphics2D;
import java.util.Scanner;

/**
 * Pierrick BOBET - 17 131 792
 * @author Bebo
 *
 */
public class Point extends Dessin
{

    protected int x;
    protected int y;
    private final static int crossSize = 10;

    /**
     * Constructeur par défaut
     */
    public Point()
    {
        x = 0;
        y = 0;
    }

    /*
     * Fonction qui dessine le point sur la surface 2D.
     */

    public void dessiner(Graphics2D graph)
    {
        graph.drawLine(x - crossSize, y - crossSize, x + crossSize, y + crossSize);
        graph.drawLine(x + crossSize, y - crossSize, x - crossSize, y + crossSize);
    }

    /*
     * Fonction qui obtient les coordonn�es du point � partir d'un flot
     * d'entiers
     */
    public void lire(Scanner reader)
    {
        x = reader.nextInt();
        y = reader.nextInt();
    }

    public String toString()
    {
        return new String("(" + x + "," + y + ")");
    }

    @Override
    public boolean equals(Object toCompare)
    {
        Point toComparePoint = (Point) toCompare;
        boolean compareState = true;

        if (this.x != toComparePoint.x || this.y != toComparePoint.y)
            compareState = false;

        return compareState;
    }
}

/**
 * 
 */
package labo1;

import java.awt.Graphics2D;
import java.util.Scanner;

/**
 * Pierrick BOBET - 17 131 792
 * @author Bebo
 *
 */
public class Ligne extends Dessin
{
    protected Point point1;
    protected Point point2;

    /**
     * Constructeur par défaut
     */
    public Ligne()
    {
        point1 = new Point();
        point2 = new Point();
    }

    /**
     * Constructeur de confort
     * 
     * @param point1
     * @param point2
     */
    public Ligne(Point point1, Point point2)
    {
        this.point1 = point1;
        this.point2 = point2;
    }

    public void dessiner(Graphics2D graph)
    {
        graph.drawLine(point1.x, point1.y, point2.x, point2.y);
    }

    /*
     * Fonction qui obtient les coordonn�es du point � partir d'un flot
     * d'entiers
     */
    public void lire(Scanner reader)
    {
        point1.lire(reader);
        point2.lire(reader);
    }

    public String toString()
    {
        return new String(point1.toString() + " -> " + point2.toString());
    }
}

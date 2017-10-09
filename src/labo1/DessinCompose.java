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
public class DessinCompose extends Dessin
{
    private int infoData;
    private ArrayList<Dessin> listeDessin;

    /**
     * Constructeur par défaut
     */
    public DessinCompose()
    {
        listeDessin = new ArrayList<Dessin>();
    }

    /*
     * Fonction qui dessine le point sur la surface 2D.
     */

    public void dessiner(Graphics2D graph)
    {
        for (int boucle = 0; boucle < listeDessin.size(); boucle++)
            listeDessin.get(boucle).dessiner(graph);
    }

    /*
     * Fonction qui obtient les coordonnées du point à partir d'un flot
     * d'entiers
     */
    public void lire(Scanner reader) throws Exception
    {    
        do
        {      
            infoData = reader.nextInt();
            switch (infoData)
            {
                case (-1):
                    listeDessin.add(new Point());
                    listeDessin.get(listeDessin.size() - 1).lire(reader);
                    break;
                case (-2):
                    listeDessin.add(new Ligne());
                    listeDessin.get(listeDessin.size() - 1).lire(reader);
                    break;
                case (-3):
                    listeDessin.add(new NuagePoints());
                    listeDessin.get(listeDessin.size() - 1).lire(reader);
                    break;
                case (-4):
                    listeDessin.add(new Polygone());
                    listeDessin.get(listeDessin.size() - 1).lire(reader);
                    break;
                default:
                    infoData = reader.nextInt();
            }
        }
        while (reader.hasNextInt());
    }

    public String toString()
    {
        StringBuffer chaine = new StringBuffer();

        for (int boucle = 0; boucle < listeDessin.size(); boucle++)
            chaine.append(("Dessin Composé : " + listeDessin.get(boucle).toString() + "\n"));
        return chaine.toString();
    }
}

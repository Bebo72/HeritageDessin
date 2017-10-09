package labo1;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFrame;

/**
 * Pierrick BOBET - 17 131 792
 * @author Bebo
 *
 */
public class Exercice1Test extends JFrame
{

    private static final long serialVersionUID = 1L;
    private static final String choixString = "<choix: -1 Point(s)|-2 Ligne(s)|-3 nuage de points|-4 polygone|-5 dessin composé>";
    private Integer choice = 0;

    /*
     * Initialisation de la classe de test. On obtient un nom de fichier des
     * param�tres d'ex�cution. Si on n'a pas de param�tre ou un fichier
     * inexistant, on utilise le clavier comme flot d'entr�e.
     */

    /**
     * Init dessin méthode
     * 
     * @param reader
     * @return dessin
     * @throws Exception
     */
    public Dessin initDessin(Scanner reader) throws Exception
    {
        Dessin dessin;

        do
        {
            if (choice > -1 && choice < -5)
                throw new Exception("Erreur de saisie du choix - Merci de recommencer");
            else
                break;

        }
        while (true);

        switch (choice)
        {
            case -1:
                dessin = new Point();
                break;
            case -2:
                dessin = new Ligne();
                break;
            case -3:
                dessin = new NuagePoints();
                break;
            case -4:
                dessin = new Polygone();
                break;
            case -5:
                dessin = new DessinCompose();
                break;
            default:
                throw new Exception("Erreur de saisie - Merci de recommencer");
        }

        dessin.lire(reader);

        return dessin;
    }

    /**
     * Exercice 1 test
     * 
     * @param args
     * @throws Exception
     */
    public Exercice1Test(String[] args) throws Exception
    {
        Scanner reader = new Scanner(System.in);

        if (args.length == 1)
        {
            String file = args[0];

            try
            {
                System.out.println("Saisir : " + choixString + "\nVotre saisie :");
                choice = reader.nextInt();
                System.out.println("Lecture du fichier " + file + "...");
                reader = new Scanner(new FileReader(file));
            }

            catch (FileNotFoundException e)
            {
                System.out.println("Fichier non trouv�...");
                reader = new Scanner(new InputStreamReader(System.in));
            }
        }
        else
        {
            System.out.println("Aucun fichier en paramètre. Entrez les données dans la console :");
            reader = new Scanner(System.in);
        }

        initUI(reader);
    }

    /*
     * Initialisation de la fen�tre.
     */
    private void initUI(Scanner reader) throws Exception
    {

        // Obtention des données à partir du fichier ou du clavier
        Dessin dessin = initDessin(reader);

        System.out.println("Valeur(s) du dessin :\n" + dessin);
        PanneauDessin surface = new PanneauDessin(dessin);

        // La surface de dessin est plac�e dans la fen�tre.
        add(surface);

        // Configurations relatives � la fen�tre.
        setTitle("Labo 1");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Fonction principale
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        /*
         * Mise en file de l'ex�cution de l'interface graphique pour le
         * EventDispatchThread (gestionnaire de fen�tres).
         */
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                Exercice1Test ex;

                try
                {
                    if (args.length == 1 || args.length == 0)
                    {
                        ex = new Exercice1Test(args);
                        ex.setVisible(true);
                    }
                    else
                        System.out.println("Usage: Exercice1Test.java " + choixString + "<fichier>");

                }
                catch (NoSuchElementException exception)
                {
                    System.err.println("Erreur - problème de coordonnées. " + exception.getMessage());
                    exception.printStackTrace();
                }
                catch (Exception e)
                {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}

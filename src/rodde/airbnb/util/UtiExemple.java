package rodde.airbnb.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.nio.file.Files.*;

public class UtiExemple{
   public  Scanner  sc;
    public static void arrondi(){
        Uti.info("UtiExemple","arrondi()","");
        // avec arrondi:
        double dnombre = 1.00001;
        /*
         le nombre de zéro aprés le point donne les chiffres affichés
         */
        String masque1 = new String("#0.0#");
        DecimalFormat form1 = new DecimalFormat(masque1); // import java.text.DecimalFormat;
        System.out.println("dnombre: " + form1.format(dnombre));
        String masque2 = new String("#0.000000#"); // ajoute un zéro
        DecimalFormat form2 = new DecimalFormat(masque2); // import java.text.DecimalFormat;
        System.out.println("dnombre: " + form2.format(dnombre));
        String masque3 = new String("#0.00#");
        DecimalFormat form3 = new DecimalFormat(masque3); // import java.text.DecimalFormat;
        System.out.println("dnombre: " + form3.format(dnombre));
        // ne pas oublier de gerer les exceptions
    }
    public static void troncatature(){
        Uti.info("UtiExemple","troncatature()","");
        // avec arrondi:
        double dnombre = 0.45657;
        // sans arrondi (tronqué):
        // par exemple
        String Snombre = Double.toString(dnombre); // a partir de java 1.4
        System.out.println("Snombre: " + Snombre);
        int index = Snombre.indexOf(".");
        if (index != -1)
        {
            String SnombreTronque = Snombre.substring(0, index +3);
            System.out.println("Snombre tronqué: " + SnombreTronque + " (String)");
            double result = Double.parseDouble(SnombreTronque); // a partir de java 1.4
            System.out.println("Resultat: " + result +" (double)");
        }
        else
            System.out.println("Pas de .");
        // ne pas oublier de gerer les exceptions
    }
    public void UtilisationDeDates(){
        /*
        TestApiGestionDateJava8 tagdj8 = new TestApiGestionDateJava8();
        tagdj8.gestionDuTempsMachine();
        tagdj8.gestionDuTempsMachine();
        tagdj8.deJavaDateVersJavaApi8();
        tagdj8.deJavaApi8VersJavaDate();
         */
    }
    public void exception(){
        /*
            try {
                //
            } catch (ArithmeticException e) {
                e.printStackTrace();
            } catch (typeException2 e) {
                System.out.println(e2.getMessage());
            } catch (typeException3 e) {
                e.printStackTrace();
            } finally {

            }
        */
    }
    public void saisieControle(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // if the next is a Int,
            // print found and the Int
            if (sc.hasNextInt()) {
                System.out.println("Found Int value :"+ sc.nextInt());
            }
            // if no Int is found,
            // print "Not Found:" and the token
            else {
                System.out.println("Not found Int value :" + sc.next());
            }
        }
        sc.close();
    }
    public void saisieRepeteeMalgreException(){
        /* choix appelle listerMenu et gère la saisie,
        l'utilisateur recommence jusqu'à ce que sa
        saisie soit un chiffre entre 1 et 5.*/
        choix(5);
        sc.close();
    }
    int choix(int maxValue){
        boolean ok= false;
        String sChoix = "";
        int iChoix=0;
        // cette boucle permet de refaire sa saisie si l'exception ne stoppe pas le programme
        while(!ok) {
            try {
                sChoix = sc.next();
                iChoix = Integer.parseInt(sChoix);
                if (iChoix >= 1 && iChoix <= maxValue) {
                    ok = true;
                } else {
                    System.out.println("il faut choisir entre 1 et " + maxValue);
                    listerMenu();
                }
            } catch (NumberFormatException nfe) {
                // affiche un message d'erreur et poursuit le programme
                System.out.println("NumberFormatException: " + nfe.getMessage());
                System.out.println("Entrer un chiffre compris entre 1 et " + maxValue);
            } catch (InputMismatchException e) {  // non utilisée car la précédente exception réagit avant
                // affiche un message d'erreur et stoppe le programme
                System.out.println(e);
                e.printStackTrace(); // donne la pile
                System.out.println("Entrer un chiffre compris entre 1 et " + maxValue);
            }
        }
        return iChoix;
    }
    static protected void listerMenu(){
        System.out.println("Saisir une option:");
        System.out.println("1. Liste des hôtes");
        System.out.println("2. Liste des logements");
        System.out.println("3. Liste des voyageurs");
        System.out.println("4. Liste des réservations");
        System.out.println("5. Fermer le programme");
    }

    public static void tutoCreationDossiers() {

        File file = new File("C:\\Directory1");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

        File files = new File("C:\\Directory2\\Sub2\\Sub-Sub2");
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }
    }
    public static void tutoPath() {

        Path path = Paths.get("C:\\Directory2\\Sub2\\Sub-Sub2");
        //if directory exists?
        if (!exists(path)) {
            try {
                createDirectories(path);
            } catch (IOException e) {
                //fail to create directory
                e.printStackTrace();
            }
        }
    }
}

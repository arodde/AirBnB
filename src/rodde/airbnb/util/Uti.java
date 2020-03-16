package rodde.airbnb.util;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import static java.util.Locale.*;

public class Uti{
    public static void info(String sClasse, String sMethode, String sCommentaire){
        String sLaClasse = sClasse;
        String sLaMethode = sMethode;
        String sLeCommentaire = sCommentaire;
        System.out.print("====> "+sLaClasse+" ");
        System.out.print("====> "+sLaMethode);
        if(sLeCommentaire!=""){
            System.out.print(" ====> "+sLeCommentaire);
        }
        System.out.println(".");
    }
    public static void mess(String message){
        System.out.println("---------->     "+message);
    }
    public static void sep(String motif, int repetition){
        for (int i = 0; i<repetition;i++){
            System.out.print(motif);
        }
        System.out.println("");
    }
    public static <T> void affichageListe(List<T> liste){
        Uti.info("UtiExemple","affichageListe()","");
        if(liste.size()>0){
            for (int elt = 0; elt < liste.size(); elt++){
                System.out.println(liste.get(elt).toString());
            }
        }
        else
        {
            System.out.println("Liste vide!!!");
        }
    }

    public static void conversionSimpleFormatDateEnString (Date date,String pattern) {
//        String pattern = "MM/dd/yyyy HH:mm:ss";

        // Create an instance of SimpleDateFormat used for formatting
        // the string representation of date according to the chosen pattern
        DateFormat df = new SimpleDateFormat(pattern);

        // Get the today date using Calendar object.
//        Date today = Calendar.getInstance().getTime();
        // Using DateFormat format method we can create a string
        // representation of a date with the defined format.
        String todayAsString = df.format(date);
//        String todayAsString = df.format(today);

        // Print the result!
        System.out.println("Today is: " + todayAsString);
    }
    public static void conversionStringEnLocaleDateTime (String pattern) {
//        String pattern = "yyyy-MM-ddT00:00:00";
        LocalDateTime localDateTime = LocalDateTime.parse(pattern);

    }
    public static void convertStringEnZoneDateTime(String szdt){
        // exemple chaîne "2018-09-16T08:00:00+00:00[Europe/London]"
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(szdt);
    }
    public static void fichierLire(){
        int n=0;
        try {
            // Le fichier que l’on souhaite ouvrir
            File f = new File("mydatajava.txt");
            // Création d’un flux en entrée
            FileInputStream fis = new FileInputStream(f);
            // Création d’un lecteur du flux
            InputStreamReader isr = new InputStreamReader(fis);
            // Mise en mémoire tampon
            BufferedReader br = new BufferedReader(isr);
            String ligne = br.readLine();
            while (ligne!= null) {
                System.out.printf((++n) + " " + ligne);
                ligne = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.err.println("error");
        }
    }
    public static void fichierEcrire(){
        try {
            FileWriter fw = new FileWriter("mydatajava.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print("Hello ");
            pw.println("world !!!");
            pw.println("Fin du fichier");
            pw.close();
        } catch (Exception e) {
            System.err.println("error");
        }
    }
}


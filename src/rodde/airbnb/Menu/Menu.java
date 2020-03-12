package rodde.airbnb.Menu;

import rodde.airbnb.logements.Logement;
import rodde.airbnb.logements.Maison;
import rodde.airbnb.reservations.Reservation;
import rodde.airbnb.util.LesIO;
import rodde.airbnb.util.Uti;
import rodde.airbnb.util.UtiExemple;
import rodde.airbnb.utilisateurs.Hote;
import rodde.airbnb.utilisateurs.Voyageur;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static Scanner sc;
    private static int optionChoisie;

    public static ArrayList<Hote> getListeHotes() {
        Uti.info("Menu","getListeHotes","");
        return listeHotes;
    }

    public static void setListeHotes(ArrayList<Hote> listeHotes) {
        Uti.info("Menu","setListeHotes","");
        Menu.listeHotes = listeHotes;
    }

    private static ArrayList<Hote> listeHotes;
    private static ArrayList<Voyageur> listeVoyageurs;
    private static ArrayList<Logement> listeLogements;
    private static ArrayList<Reservation> listeReservations;
    private static  GestionReservations gestionReservations;
    private static  GestionVoyageurs gestionVoyageurs;
    private static GestionHotes gestionHotes;
    private static  GestionLogements gestionLogements;
    public static ArrayList<Reservation> getListeReservations() {
        Uti.info("Menu","getListeReservations","");
        return listeReservations;
    }

    public static void setListeReservations(ArrayList<Reservation> listeReservations) {
        Uti.info("Menu","setListeReservations","");
        Menu.listeReservations = listeReservations;
    }

    public static GestionReservations getGestionReservations() {
        Uti.info("Menu","getGestionReservations","");
        return gestionReservations;
    }

    public static void setGestionReservations(GestionReservations gestionReservations) {
        Uti.info("Menu","setGestionReservations","");
        Menu.gestionReservations = gestionReservations;
    }


    public static GestionHotes getGestionHotes() {
        Uti.info("Menu","getGestionHotes","");
        return gestionHotes;
    }

    public static void setGestionHotes(GestionHotes gestionHotes) {
        Uti.info("Menu","setGestionHotes","");
        Menu.gestionHotes = gestionHotes;
    }

    public static GestionLogements getGestionLogements() {
        Uti.info("Menu","getGestionLogements","");
        return gestionLogements;
    }

    public static void setGestionLogements(GestionLogements gestionLogements) {
        Uti.info("Menu","setGestionLogements","");
        Menu.gestionLogements = gestionLogements;
    }



    public static GestionVoyageurs getGestionVoyageurs() {
        Uti.info("Menu","getGestionVoyageurs","");
        return gestionVoyageurs;
    }

    public static void setGestionVoyageurs(GestionVoyageurs gestionVoyageurs) {
        Uti.info("Menu","setGestionVoyageurs","");
        Menu.gestionVoyageurs = gestionVoyageurs;
    }

    public static ArrayList<Voyageur> getListeVoyageurs() {
        Uti.info("Menu","getListeVoyageurs","");
        return listeVoyageurs;
    }

    public static void setListeVoyageurs(ArrayList<Voyageur> listeVoyageurs)    {
        Uti.info("Menu","setListeVoyageurs","");
        Menu.listeVoyageurs = listeVoyageurs;
    }


    public static ArrayList<Logement> getListeLogements() {
        Uti.info("Menu","getListeLogements","");
        return listeLogements;
    }

    public static void setListeLogements(ArrayList<Logement> listeLogements) {
        Uti.info("Menu","setListeLogements","");
        Menu.listeLogements = listeLogements;
    }
    public static void airBnB(){
        Uti.info("Menu","airBnB","");

        System.out.println( "Bienvenue chez AirBnB" );

        listeHotes = new ArrayList<Hote>();
        listeVoyageurs = new ArrayList<Voyageur>();
        listeLogements = new ArrayList<Logement>();
        listeReservations = new ArrayList<Reservation>();
        gestionHotes = new GestionHotes();
        gestionLogements = new GestionLogements();
        gestionVoyageurs = new GestionVoyageurs();
        gestionReservations= new GestionReservations();

        Hote h1 = new Hote("zz","rr",1,12);
        listeHotes.add(h1);
        Voyageur v1 = new Voyageur("zo","rp",55);
        listeVoyageurs.add(v1);
        Maison m1 = new Maison(h1,89,"ert",752,10,1700,true);
        listeLogements.add(m1);

        while(optionChoisie<1||optionChoisie>5){
            optionChoisie = 0;
//            sc.useDelimiter("\n");
            listerMenu();
            optionChoisie = choix(5);
            switch(optionChoisie){
                case 1 :
                    gestionHotes.listerHotes();
                    optionChoisie = 0;
                    break;
                case 2 :
                    gestionLogements.listerLogements();
                    optionChoisie = 0;
                    break;
                case 3 :
                    gestionVoyageurs.listerVoyageurs();
                    optionChoisie = 0;
                    break;
                case 4 :
                    gestionReservations.listerReservations();
                    optionChoisie = 0;
                    break;
                default:
                    System.out.println("A bientôt.");
                    break;
            }
        }

    }

    public static void main(String[] args) {
        Uti.info("Menu","main","");
        sc = new Scanner( System .in);

          airBnB();


        sc.close();
    }
    static protected void listerMenu(){
        Uti.info("Menu","listerMenu()","");


        System.out.println("Saisir une option:");
        System.out.println("1. Liste des hôtes");
        System.out.println("2. Liste des logements");
        System.out.println("3. Liste des voyageurs");
        System.out.println("4. Liste des réservations");
        System.out.println("5. Fermer le programme");
    }
    static int choix(int maxValue){
        Uti.info("Menu","choix()","");
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
//                    listerMenu();
                }

            } catch (NumberFormatException nfe) {
                // affiche un message d'erreur et poursuit le programme
                System.out.println("NumberFormatException: " + nfe.getMessage());
                System.out.println("Entrer un chiffre compris entre 1 et " + maxValue);
//            } catch (InputMismatchException e) {
//                // affiche un message d'erreur et stoppe le programme
//                System.out.println(e);
//                e.printStackTrace(); // donne la pile
//                System.out.println("Entrer un chiffre compris entre 1 et " + maxValue);
            }
        }
        return iChoix;
    }
    // ------------------------------------------------------------------------------------- //
    public static void progJavaDebutant14(){
        Uti.info("Menu","progJavaDebutant14()","");
        int n=0;
        String str1 = "";
        String str2 = "";

        System.out.println("Veuillez entrer un entier");
        n= sc.nextInt();
        sc.nextLine(); // lit la fin de la ligne où le chiffre est lu
        System.out.println("Veuillez entrer une chaîne de caractères");
        str1 = sc.nextLine();
        System.out.println("Veuillez entrer une chaîne de caractères");
        str2 = sc.nextLine();

        System.out.println("n  : "+n);
        System.out.println("str1  : "+str1);
        System.out.println("str2  : "+str2);

    }
    public static void progJavaDebutant13(){
        Uti.info("Menu","progJavaDebutant13()","");
        // lire une chaîne
        String s;
        System.out.print("Entrez du texte : ");
        s = sc.nextLine();
        System.out.println("Vous avez tapé : "+s);
        // lire un réel
        Double var;
        System.out.print("Entrez un réel (avec la virgule pour séparer!!!) : ");
        var = sc.nextDouble();
        System.out.println("Vous avez tapé : "+var);
    }
    public static void lesTeacherDuNetDebutant(){
        Uti.info("Menu","lesTeacherDuNetDebutant()","");
        progJavaDebutant13(); // lire un réel ou une chaine de caractères
        progJavaDebutant14(); // nextInt et ses caprices
    }
}

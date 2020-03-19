package rodde.airbnb.Menu;

import rodde.airbnb.logements.Appartment;
import rodde.airbnb.logements.Housing;
import rodde.airbnb.logements.House;
import rodde.airbnb.reservations.*;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;
import rodde.airbnb.utilisateurs.Traveler;
import rodde.airbnb.vues.ViewMenu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static Scanner sc;
    private static int selectedOption;

    public static ArrayList<Host> getHostArrayList() {
        Uti.info("Menu","getListeHotes","");
        return hostArrayList;
    }

    public static void setHostArrayList(ArrayList<Host> hostArrayList) {
        Uti.info("Menu","setListeHotes","");
        Menu.hostArrayList = hostArrayList;
    }

    private static ArrayList<Host> hostArrayList;
    private static ArrayList<Traveler> travelerArrayList;
    private static ArrayList<Housing> housingArrayList;
    private static ArrayList<Booking> bookingArrayList;
    private static BookingManagement bookingManagement;
    private static TravellersManagement travellersManagement;
    private static HostsManagement hostsManagement;
    private static HousingManagement housingManagement;
    public static ArrayList<Booking> getBookingArrayList() {
        Uti.info("Menu","getListeReservations","");
        return bookingArrayList;
    }
    public static void displayBookings(){
        if(bookingArrayList.size()>0){
        for (int i = 0; i < bookingArrayList.size(); i++){
            bookingArrayList.get(i).display();
            System.out.println("\n");
        }
    }
        else
        {
            System.out.println("liste réservations vide");
        }
    }
    public static void displayHosts(){
        if(hostArrayList.size()>0){
            for (int i = 0; i < hostArrayList.size(); i++){
                hostArrayList.get(i).display();
                System.out.println("\n");
            }
        }
        else
        {
            System.out.println("liste hôtes vide");
        }
    }
    public static void displayTravelers(){
        if(travelerArrayList.size()>0){
            for (int i = 0; i < travelerArrayList.size(); i++){
                travelerArrayList.get(i).display();
                System.out.println("\n");
            }
        }
        else
        {
            System.out.println("liste voyageurs vide");
        }
    }
    public static void displayHousings(){
        // todo afficher liste
        if(housingArrayList.size()>0){
            for (int i = 0; i < housingArrayList.size(); i++){
                housingArrayList.get(i).display();
                System.out.println("\n");
            }
        }
        else
        {
            System.out.println("liste logement vide");
        }
    }
    public static void setBookingArrayList(ArrayList<Booking> bookingArrayList) {
        Uti.info("Menu","setListeReservations","");
        Menu.bookingArrayList = bookingArrayList;
    }

    public static BookingManagement getBookingManagement() {
        Uti.info("Menu","getGestionReservations","");
        return bookingManagement;
    }

    public static void setBookingManagement(BookingManagement bookingManagement) {
        Uti.info("Menu","setGestionReservations","");
        Menu.bookingManagement = bookingManagement;
    }


    public static HostsManagement getHostsManagement() {
        Uti.info("Menu","getGestionHotes","");
        return hostsManagement;
    }

    public static void setHostsManagement(HostsManagement hostsManagement) {
        Uti.info("Menu","setGestionHotes","");
        Menu.hostsManagement = hostsManagement;
    }

    public static HousingManagement getHousingManagement() {
        Uti.info("Menu","getGestionLogements","");
        return housingManagement;
    }

    public static void setHousingManagement(HousingManagement housingManagement) {
        Uti.info("Menu","setGestionLogements","");
        Menu.housingManagement = housingManagement;
    }



    public static TravellersManagement getTravellersManagement() {
        Uti.info("Menu","getGestionVoyageurs","");
        return travellersManagement;
    }

    public static void setTravellersManagement(TravellersManagement travellersManagement) {
        Uti.info("Menu","setGestionVoyageurs","");
        Menu.travellersManagement = travellersManagement;
    }

    public static ArrayList<Traveler> getTravelerArrayList() {
        Uti.info("Menu","getListeVoyageurs","");
        return travelerArrayList;
    }

    public static void setTravelerArrayList(ArrayList<Traveler> travelerArrayList)    {
        Uti.info("Menu","setListeVoyageurs","");
        Menu.travelerArrayList = travelerArrayList;
    }


    public static ArrayList<Housing> getHousingArrayList() {
        Uti.info("Menu","getListeLogements","");
        return housingArrayList;
    }

    public static void setHousingArrayList(ArrayList<Housing> housingArrayList) {
        Uti.info("Menu","setListeLogements","");
        Menu.housingArrayList = housingArrayList;
    }
    public static void airBnB()  {
        Uti.info("Menu","airBnB","");

        System.out.println( "Bienvenue chez AirBnB" );

        hostArrayList = new ArrayList<Host>();
        travelerArrayList = new ArrayList<Traveler>();
        housingArrayList = new ArrayList<Housing>();
        bookingArrayList = new ArrayList<Booking>();
        hostsManagement = new HostsManagement();
        housingManagement = new HousingManagement();
        travellersManagement = new TravellersManagement();
        bookingManagement = new BookingManagement();


displayBookings();
        Host h1 = new Host("zz","rr",1,12);
        hostArrayList.add(h1);
        Traveler v1 = new Traveler("zo","rp",55);
        travelerArrayList.add(v1);
        House m1 = new House(h1,89,"ert",752,10,1700,true);
        Appartment a1 = new Appartment(h1,88,"ab cdefg hijk lmnopqr stu vwxyz",45,4,7,3);

        LocalDate dateArrivee = LocalDate.of(2020, 4, 3);
     Stay s1 = null;
     int dureeSejour =3;
        if (dureeSejour < 6) {
            s1 = new ShortStay(dateArrivee, dureeSejour, m1, 5);
        } else {
            s1 = new LongStay(dateArrivee, dureeSejour, m1, 5);
        }
        try {
            Booking r1 = new Booking(s1,v1);
            bookingArrayList.add(r1);
        } catch (instantiationBookingException e) {
            System.out.println("réservation impossible à prendre!!!");
            e.printStackTrace();
        }
        housingArrayList.add(m1);
        housingArrayList.add(a1);

displayBookings();

        while(selectedOption <1|| selectedOption >5){
            selectedOption = 0;
//            sc.useDelimiter("\n");
            listMenu();
            selectedOption = choice(5);
            switch(selectedOption){
                case 1 :
                    hostsManagement.listHostsMenu();
                    selectedOption = 0;
                    break;
                case 2 :
                    housingManagement.listHousingsMenu();
                    selectedOption = 0;
                    break;
                case 3 :
                    travellersManagement.listTravelersMenu();
                    selectedOption = 0;
                    break;
                case 4 :
                    bookingManagement.listBookingsMenu();
                    selectedOption = 0;
                    break;
                default:
                    System.out.println("A bientôt.");
                    break;
            }
        }

    }

    public static void main(String[] args)  {
        Uti.info("Menu","main","");
        sc = new Scanner( System .in);
        ViewMenu vueMenu = new ViewMenu();
//          airBnB();


        sc.close();
    }
    static protected void listMenu(){
        Uti.info("Menu","listerMenu()","");


        System.out.println("Saisir une option:");
        System.out.println("1. Liste des hôtes");
        System.out.println("2. Liste des logements");
        System.out.println("3. Liste des voyageurs");
        System.out.println("4. Liste des réservations");
        System.out.println("5. Fermer le programme");
    }
    static int choice(int maxValue){
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

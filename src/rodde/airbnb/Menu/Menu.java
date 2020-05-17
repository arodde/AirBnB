package rodde.airbnb.Menu;

import rodde.airbnb.logements.Housing;
import rodde.airbnb.reservations.*;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;
import rodde.airbnb.utilisateurs.Traveler;
import rodde.airbnb.vues.ViewHostCreation;
import rodde.airbnb.vues.ViewHouseCreation;
import rodde.airbnb.vues.ViewMenu;
import rodde.airbnb.vues.ViewTravelerCreation;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    /**
     this class displays the list of host, Travelers, housing, and booking
     */
    public static Scanner sc;
    private static int selectedOption;


    private static ArrayList<Host> hostArrayList;
    private static ArrayList<Traveler> travelerArrayList;
    private static ArrayList<Housing> housingArrayList;
    private static ArrayList<Booking> bookingArrayList;
    private static BookingManagement bookingManagement;
    private static TravellersManagement travellersManagement;
    private static HostsManagement hostsManagement;
    private static HousingManagement housingManagement;
    private static ViewMenu viewMenu;
    private static ViewHostCreation viewHostCreation;
    private static ViewTravelerCreation viewTravelerCreation;
    private static ViewHouseCreation viewHouseCreation;
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
    public static void airBnB()  {
        Uti.info("Menu","airBnB","");

        System.out.println( "Bienvenue chez AirBnB" );
        while(selectedOption <1|| selectedOption >6){
            selectedOption = 0;
//            sc.useDelimiter("\n");
            listMenu();
            selectedOption = choiceValueInTheList(6);
            switch(selectedOption){
                case 1 :
                    hostsManagement.listHostsMenu();
                    selectedOption = 0;
                    break;
                case 2 :
                    housingManagement.listHousingsMenu();
                    // where the housing is a house
                    selectedOption = 0;
                    break;
                case 3 :
                    housingManagement.listHousingsMenu();
                    // where the housing is an appartment
                    selectedOption = 0;
                    break;
                case 4 :
                    travellersManagement.listTravelersMenu();
                    selectedOption = 0;
                    break;
                case 5 :
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
        airBnB();


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
    static int choiceValueInTheList(int maxValue){
        Uti.info("Menu","choix()","");
        boolean ok= false;
        String sChoix = "";
        int iChoix=0;
        while(!ok) {
            try {
                sChoix = sc.next();
                iChoix = Integer.parseInt(sChoix);
                if (iChoix >= 1 && iChoix <= maxValue) {
                    ok = true;
                } else {
                    System.out.println("il faut choisir entre 1 et " + maxValue);
                }

            } catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: " + nfe.getMessage());
                System.out.println("Entrer un chiffre compris entre 1 et " + maxValue);
//            } catch (InputMismatchException e) {
//                System.out.println(e);
//                e.printStackTrace();
//                System.out.println("Entrer un chiffre compris entre 1 et " + maxValue);
            }
        }
        return iChoix;
    }
    // ------------------------------- getter and setter ---------------------------- //
    public static ArrayList<Host> getHostArrayList() {
        Uti.info("Menu","getListeHotes","");
        return hostArrayList;
    }
    public  void setHostArrayList(ArrayList<Host> hostArrayList) {
        Uti.info("Menu","setListeHotes","");
        Menu.hostArrayList = hostArrayList;
    }
    public static ArrayList<Booking> getBookingArrayList() {
        Uti.info("Menu","getListeReservations","");
        return bookingArrayList;
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
}

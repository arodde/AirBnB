package rodde.airbnb.Menu;

import rodde.airbnb.logements.Housing;
import rodde.airbnb.reservations.*;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;
import rodde.airbnb.vues.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    /**
     this class displays the list of host, Travelers, housing, and booking
     */
    public static Scanner sc;
    private static int selectedOption;
    private static ArrayList<Host> hostArrayList;
    private static ArrayList<rodde.airbnb.utilisateurs.Traveler> travelerArrayList;
    private static ArrayList<Housing> housingArrayList;
    private static ArrayList<Booking> bookingArrayList;
    private static BookingsManagement bookingsManagement;
    private static TravelersManagement travelersManagement;
    private static HostsManagement hostsManagement;
    private static HousingsManagement housingsManagement;
    private static ViewMenu viewMenu;
    private static ViewHostCreation viewHostCreation;
    private static ViewTravelerCreation viewTravelerCreation;
    private static ViewHouseCreation viewHouseCreation;
    private static ViewAppartmentCreation viewAppartmentCreation;
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
                    housingsManagement.listHousingsMenu();
                    // where the housing is a house
                    selectedOption = 0;
                    break;
                case 3 :
                    housingsManagement.listHousingsMenu();
                    // where the housing is an appartment
                    selectedOption = 0;
                    break;
                case 4 :
                    travelersManagement.listTravelersMenu();
                    selectedOption = 0;
                    break;
                case 5 :
                    bookingsManagement.listBookingsMenu();
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
        String sChoice = "";
        int indexChoice=0;
        while(!ok) {
            try {
                sChoice = sc.next();
                indexChoice = Integer.parseInt(sChoice);
                if (indexChoice >= 1 && indexChoice <= maxValue) {
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
        return indexChoice;
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
    public static BookingsManagement getBookingsManagement() {
        Uti.info("Menu","getGestionReservations","");
        return bookingsManagement;
    }
    public static void setBookingsManagement(BookingsManagement bookingsManagement) {
        Uti.info("Menu","setGestionReservations","");
        Menu.bookingsManagement = bookingsManagement;
    }
    public static HostsManagement getHostsManagement() {
        Uti.info("Menu","getGestionHotes","");
        return hostsManagement;
    }
    public static void setHostsManagement(HostsManagement hostsManagement) {
        Uti.info("Menu","setGestionHotes","");
        Menu.hostsManagement = hostsManagement;
    }
    public static HousingsManagement getHousingsManagement() {
        Uti.info("Menu","getGestionLogements","");
        return housingsManagement;
    }
    public static void setHousingsManagement(HousingsManagement housingsManagement) {
        Uti.info("Menu","setGestionLogements","");
        Menu.housingsManagement = housingsManagement;
    }
    public static TravelersManagement getTravelersManagement() {
        Uti.info("Menu","getGestionVoyageurs","");
        return travelersManagement;
    }
    public static void setTravelersManagement(TravelersManagement travelersManagement) {
        Uti.info("Menu","setGestionVoyageurs","");
        Menu.travelersManagement = travelersManagement;
    }
    public static ArrayList<rodde.airbnb.utilisateurs.Traveler> getTravelerArrayList() {
        Uti.info("Menu","getListeVoyageurs","");
        return travelerArrayList;
    }
    public static void setTravelerArrayList(ArrayList<rodde.airbnb.utilisateurs.Traveler> travelerArrayList)    {
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

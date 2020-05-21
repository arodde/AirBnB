package rodde.airbnb.Menu;

import rodde.airbnb.reservations.Booking;
import rodde.airbnb.reservations.Stay;
import rodde.airbnb.reservations.ShortStay;
import rodde.airbnb.reservations.LongStay;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Traveler;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class BookingManagement {
    /**
     this class manages the menu in console menu for add, delete operations
     */
    public static void listBookingsMenu() {
        /**
         displays the bookings' menu
         */
        Uti.info("GestionReservations","listerReservations()","");
        Uti.sep("-", 50);
        System.out.println("Saisir une option");
        System.out.println("1 : Ajouter une réservation");
        System.out.println("2 : Supprimer une réservation");
        System.out.println("3 : Retour");
        switch (Menu.choiceValueInTheList(3)) {
            case 1:
                Menu.sc.nextLine();
                try {
                    addBooking();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    listBookingsMenu();
                }
                break;
            case 2:
                Menu.sc.nextLine();
                try {
                    deleteBooking();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    listBookingsMenu();
                }
                break;
            case 3:
                Menu.sc.nextLine();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Menu.choiceValueInTheList(3));
        }
    }
    protected static void addBooking() throws Exception {
        Uti.info("GestionReservations", "addBooking()", "");
        boolean bOk = false;
        int numbersOfOvernights = -1;
        int travelersNumber = -1;
        int housingsNumber = -1;
        Traveler traveler  = null;
        Stay stay;
        Booking bookingAdded;
        LocalDate dateOfStay = null;
//        Path path = Paths.get("C:\\Directory2\\Sub2\\Sub-Sub2");
        Path path = null;
        File file = null;
        TravellersManagement travellersManagement = null;
        indexOfDisplayedBooking();
        //
        if (Menu.getTravelerArrayList().isEmpty()) {
            System.out.println("Aucun voyageur enregistré, Toute réservation doit être rattachée à un voyageur");
            Menu.listMenu();
        } else {
            TravellersManagement.indexOfDisplayedTraveler();
            bOk = false;
            while (!bOk) {
                try {
                    System.out.print("Entrer le numéro du voyageur dans la liste: ");
                    travelersNumber = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (travelersNumber >= 0 && travelersNumber <= (Menu.getTravelerArrayList().size() - 1)) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un numero de voyageur saisi en chiffre(s) et positif");
                }
            }
            traveler = Menu.getTravelerArrayList().get(travelersNumber);
        }
        if (Menu.getHousingArrayList().isEmpty()) {
            System.out.println("Aucun logement enregistré, Toute séjour doit doit être rattaché à un logement.");
            Menu.listMenu();
        } else {
            HousingManagement.indexOfDisplayedHousing();
            bOk = false;
            while (!bOk) {
                try {
                    System.out.println("Entrer le numéro du logement choisi dans la liste: ");
                    housingsNumber = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (housingsNumber >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un numero de logement saisi en chiffre(s) et positif");
                }
            }

        }
        Menu.getBookingArrayList().forEach(reservation -> reservation.display());
        bOk = false;
        while (!bOk) {
            try {
                System.out.print("Entrer le nombre de nuits : ");
                numbersOfOvernights = Menu.sc.nextInt();
                Menu.sc.nextLine();
                if (numbersOfOvernights >= 0) {
                    bOk = true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("il faut un nombre du nuit saisi en chiffre(s) et positif");
            }
        }
        bOk = false;
        while (!bOk) {
            int year = -1;
            int month = -1;
            int day = -1;
            while (!bOk) {
                try {
                    System.out.println("Année de réservation? : ");
                    year = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (year >= LocalDate.now().getYear()) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut une année saisie en chiffre(s) et actuelle ou future.");
                }
            }
            bOk = false;
            while (!bOk) {
                try {
                    System.out.println("Mois de réservation? : ");
                    month = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (month >= 1 && month <= 12) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un mois saisi en chiffre(s) entre 1 et 12");
                }
            }

            while (day < 1 || day > 31) {
                System.out.println("Jour de réservation? : ");
                day = Menu.sc.nextInt();
            }
            dateOfStay = dateOfStay.of(year, month, day);
            bOk = false;
            if (dateOfStay.isAfter(LocalDate.now())) {
                bOk = true;
            } else {
                System.out.println("Cette date de réservation est impossible retenir car antérieure à la date actuelle.");
            }
        }


        if (numbersOfOvernights < 6) {
            stay = new ShortStay(dateOfStay, numbersOfOvernights, Menu.getHousingArrayList().get(housingsNumber), Menu.getHousingArrayList().get(housingsNumber).getMaxTravelersNumber());
        } else {
            stay = new LongStay(dateOfStay, numbersOfOvernights, Menu.getHousingArrayList().get(housingsNumber), Menu.getHousingArrayList().get(housingsNumber).getMaxTravelersNumber());

        }
        bookingAdded = new Booking(stay, traveler);
        Menu.getBookingArrayList().add(bookingAdded);

//        indexOfDisplayedBooking();


    }
    protected static void indexOfDisplayedBooking(){
        /**
         * display the list's element with index and call the
         * display method of this element and go to the next line
         */
        Uti.info("GestionReservations","indiceReservationAffiche()","");
        // affiche la liste de tous les hôtes
        int displayedIndex=0;
        for(Booking booking:Menu.getBookingArrayList()){
            System.out.print("n° "+displayedIndex+" : ");
            booking.display();
            System.out.println();
            displayedIndex++;
        }
    }

    protected static void deleteBooking() throws Exception{
        Uti.info("GestionReservations","supprimerReservation()","");
        if(Menu.getBookingArrayList().isEmpty()){
            System.out.println("Aucune réservation à supprimer, la liste est vide.");
        }
        else
        {
            boolean bOk = false;

            int deletedIndex=0;
            indexOfDisplayedBooking();
            // saisie indice
            while (!bOk) {
                try {
                    System.out.print("Entrer l'indice : ");
                    deletedIndex = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (deletedIndex >= 0 && deletedIndex <= (Menu.getBookingArrayList().size()-1)) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un indice compris entre 0 et "+ (Menu.getBookingArrayList().size()-1));
                }
                // affiche la liste de tous les réservations
                indexOfDisplayedBooking();
            }
            System.out.println();
            Menu.getBookingArrayList().remove(deletedIndex);
            indexOfDisplayedBooking();
        }

    }

}

package rodde.airbnb;
import rodde.airbnb.logements.Appartment;
import rodde.airbnb.logements.House;
import rodde.airbnb.reservations.Stay;
import rodde.airbnb.reservations.ShortStay;
import rodde.airbnb.reservations.LongStay;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;
import rodde.airbnb.utilisateurs.Traveler;
import rodde.airbnb.vues.ViewHostCreation;
import rodde.airbnb.vues.ViewHouseCreation;
import rodde.airbnb.vues.ViewMenu;
import rodde.airbnb.vues.ViewTravelerCreation;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Scanner;




public class Main {
    public static Scanner sc;
    public static void main(String[] args)  {
        Uti.info("Main","main","");
        sc = new Scanner( System .in);
        ViewMenu viewMenu = new ViewMenu();
        sc.close();
    }
//    public static void main2(String[] args) {
//
//
//        Uti.info("Main", "main", "");
//        sc = new Scanner(System.in);
//ViewMenu viewMenu= new ViewMenu();
////        ViewHostCreation vch = new ViewHostCreation(viewMenu);
////        ViewTravelerCreation vcv = new ViewTravelerCreation(viewMenu);
////        ViewHouseCreation vhc = new ViewHouseCreation(viewMenu);
//        //
//        // les personnes
//        //
//        Host personne1 = new Host("RODDE", "Alain", 37, 12);
//        Host personne5 = new Host("RODDE", "Léon", 72, 24);
//        Traveler personne2 = new Traveler("LESDEMA", "Fabien", 37);
//        Host personne3 = new Host("Commençais", "Sabrina", 39, 15);
//        Traveler personne4 = new Traveler("Boureaud", "Nicolas", 37);
//        //
//        // les logements
//        //
//        House house1 = new House(personne1, 85,
//                "11 Rue Georges Clémenceau, 36000 CHATEAUROUX", 80, 2,
//                700, false
//        );
//        House house2 = new House(personne5, 200,
//                "19 Bis Avenue de la Châtre, 36000 CHATEAUROUX", 200, 6,
//                1000, true
//        );
//        Appartment appartement1 = new Appartment(personne3, 60,
//                "appart. 12, 159 Rue Victor Hugo, 37000 TOURS", 45, 1,
//                3, 6
//        );
//        //
//        // les séjours
//        //
//        LocalDate dateArrivee1 = LocalDate.of(2019, 10, 18);// date future
//        LocalDate dateArrivee2 = LocalDate.of(2019, 11, 18);
//        LocalDate dateArrivee3 = LocalDate.of(2019, 12, 18);
//        int dureeSejour1 = 9;
//        int dureeSejour2 = 5;
//        int dureeSejour3 = 3;
//        Stay sejour1 = null;
//        Stay sejour2 = null;
//        Stay sejour3 = null;
//        if (dureeSejour1 < 6) {
//            sejour1 = new ShortStay(dateArrivee1, dureeSejour1, house1, 2);
//        } else {
//            sejour1 = new LongStay(dateArrivee1, dureeSejour1, house1, 2);
//        }
//        if (dureeSejour2 < 6) {
//
//            sejour2 = new ShortStay(dateArrivee2, dureeSejour2, appartement1, 1);
//        } else {
//
//            sejour2 = new LongStay(dateArrivee2, dureeSejour2, appartement1, 1);
//        }
//        if (dureeSejour3 < 6) {
//            sejour3 = new ShortStay(dateArrivee3, dureeSejour3, house2, 5);
//        } else {
//            sejour3 = new LongStay(dateArrivee3, dureeSejour3, house2, 5);
//        }
//// conversion en sejour du séjour court ou long pour que la réservation accepte les deux types enfants
//        sejour1 = (Stay) sejour1;
//        sejour2 = (Stay) sejour2;
//        sejour3 = (Stay) sejour3;
//
//
////        //
////        // les réservations
////        //
////
////        Reservation reservation1 = new Reservation(/*1,*/ sejour1, personne2);
////        System.out.println("\nRéservation numéro " + reservation1.getIdentifiant() + ":");
////        reservation1.afficher();
////        personne1.afficher();
////
////
////        Reservation reservation2 = new Reservation(/*2,*/ sejour2, personne4);
////        System.out.println("\nRéservation numéro " + reservation2.getIdentifiant() + ":");
////        reservation2.afficher();
////        personne3.afficher();
////
////
////        Reservation reservation3 = new Reservation(/*3,*/sejour3, personne4);
////        System.out.println("\nRéservation numéro " + reservation3.getIdentifiant() + ":");
////        reservation3.afficher();
////        personne5.afficher();
//
//        //        personne1.afficher();
//        //        logement1.afficher();
//        //        sejour1.afficher();
//        sc.close();
//    }
}




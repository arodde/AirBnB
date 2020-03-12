package rodde.airbnb;
import rodde.airbnb.Menu.Menu;
import rodde.airbnb.logements.Appartement;
import rodde.airbnb.logements.Maison;
import rodde.airbnb.reservations.Reservation;
import rodde.airbnb.reservations.Sejour;
import rodde.airbnb.reservations.SejourCourt;
import rodde.airbnb.reservations.SejourLong;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Hote;
import rodde.airbnb.utilisateurs.Voyageur;
import rodde.airbnb.vues.VueCreationHote;
import rodde.airbnb.vues.VueCreationVoyageur;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Main {
        public static Scanner sc;
    public static void main(String[] args) {


        Uti.info("Main", "main", "");
        sc = new Scanner(System.in);
        VueCreationHote vch = new VueCreationHote();
        VueCreationVoyageur vcv = new VueCreationVoyageur();
        //
        // les personnes
        //
        Hote personne1 = new Hote("RODDE", "Alain", 37, 12);
        Hote personne5 = new Hote("RODDE", "Léon", 72, 24);
        Voyageur personne2 = new Voyageur("LESDEMA", "Fabien", 37);
        Hote personne3 = new Hote("Commençais", "Sabrina", 39, 15);
        Voyageur personne4 = new Voyageur("Boureaud", "Nicolas", 37);
        //
        // les logements
        //
        Maison maison1 = new Maison(personne1, 85,
                "11 Rue Georges Clémenceau, 36000 CHATEAUROUX", 80, 2,
                700, false
        );
        Maison maison2 = new Maison(personne5, 200,
                "19 Bis Avenue de la Châtre, 36000 CHATEAUROUX", 200, 6,
                1000, true
        );
        Appartement appartement1 = new Appartement(personne3, 60,
                "appart. 12, 159 Rue Victor Hugo, 37000 TOURS", 45, 1,
                3, 6
        );
        //
        // les séjours
        //
        LocalDate dateArrivee1 = LocalDate.of(2019, 10, 18);// date future
        LocalDate dateArrivee2 = LocalDate.of(2019, 11, 18);
        LocalDate dateArrivee3 = LocalDate.of(2019, 12, 18);
        int dureeSejour1 = 9;
        int dureeSejour2 = 5;
        int dureeSejour3 = 3;
        Sejour sejour1 = null;
        Sejour sejour2 = null;
        Sejour sejour3 = null;
        if (dureeSejour1 < 6) {
            sejour1 = new SejourCourt(dateArrivee1, dureeSejour1, maison1, 2);
        } else {
            sejour1 = new SejourLong(dateArrivee1, dureeSejour1, maison1, 2);
        }
        if (dureeSejour2 < 6) {

            sejour2 = new SejourCourt(dateArrivee2, dureeSejour2, appartement1, 1);
        } else {

            sejour2 = new SejourLong(dateArrivee2, dureeSejour2, appartement1, 1);
        }
        if (dureeSejour3 < 6) {
            sejour3 = new SejourCourt(dateArrivee3, dureeSejour3, maison2, 5);
        } else {
            sejour3 = new SejourLong(dateArrivee3, dureeSejour3, maison2, 5);
        }
// conversion en sejour du séjour court ou long pour que la réservation accepte les deux types enfants
        sejour1 = (Sejour) sejour1;
        sejour2 = (Sejour) sejour2;
        sejour3 = (Sejour) sejour3;


//        //
//        // les réservations
//        //
//
//        Reservation reservation1 = new Reservation(/*1,*/ sejour1, personne2);
//        System.out.println("\nRéservation numéro " + reservation1.getIdentifiant() + ":");
//        reservation1.afficher();
//        personne1.afficher();
//
//
//        Reservation reservation2 = new Reservation(/*2,*/ sejour2, personne4);
//        System.out.println("\nRéservation numéro " + reservation2.getIdentifiant() + ":");
//        reservation2.afficher();
//        personne3.afficher();
//
//
//        Reservation reservation3 = new Reservation(/*3,*/sejour3, personne4);
//        System.out.println("\nRéservation numéro " + reservation3.getIdentifiant() + ":");
//        reservation3.afficher();
//        personne5.afficher();

        //        personne1.afficher();
        //        logement1.afficher();
        //        sejour1.afficher();
        sc.close();
    }
}




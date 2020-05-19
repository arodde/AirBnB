package rodde.airbnb;
import rodde.airbnb.logements.Appartment;
import rodde.airbnb.logements.House;
import rodde.airbnb.reservations.*;
import rodde.airbnb.util.LesIO;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;
import rodde.airbnb.utilisateurs.Traveler;

import java.time.*;
import java.util.*;


public class Main {
    public static Scanner sc;


    public static void main3(String[] args)  {
        /**
         * creates and opens the main window
         */
        Uti.info("Main","main","");
//        sc = new Scanner( System .in);
//        ViewMenu viewMenu = new ViewMenu();
//        sc.close();


    }
    public static void main2(String[] args) throws instantiationBookingException {
/**
 * main function of console airBnB application
 */

        Uti.info("Main", "main", "");
        sc = new Scanner(System.in);
//ViewMenu viewMenu= new ViewMenu();
//        ViewHostCreation vch = new ViewHostCreation(viewMenu);
//        ViewTravelerCreation vcv = new ViewTravelerCreation(viewMenu);
//        ViewHouseCreation vhc = new ViewHouseCreation(viewMenu);
        //
        // les personnes
        //
        Host personne1 = new Host("RODDE", "Alain", 37, 12);
        Host personne5 = new Host("RODDE", "Léon", 72, 24);
        Traveler personne2 = new Traveler("LESDEMA", "Fabien", 37);
        Host personne3 = new Host("Commençais", "Sabrina", 39, 15);
        Traveler personne4 = new Traveler("Boureaud", "Nicolas", 37);
        //
        // les logements
        //
        House house1 = new House(personne1, 85,
                "11 Rue Georges Clémenceau, 36000 CHATEAUROUX", 80, 2,
                700, false
        );
        House house2 = new House(personne5, 200,
                "19 Bis Avenue de la Châtre, 36000 CHATEAUROUX", 200, 6,
                1000, true
        );
        Appartment appartement1 = new Appartment(personne3, 60,
                "appart. 12, 159 Rue Victor Hugo, 37000 TOURS", 45, 1,
                3, 6
        );
        //
        // les séjours
        //
        LocalDate dateArrivee1 = LocalDate.of(2021, 10, 18);// date future
        LocalDate dateArrivee2 = LocalDate.of(2021, 11, 18);
        LocalDate dateArrivee3 = LocalDate.of(2020, 12, 18);
        int dureeSejour1 = 9;
        int dureeSejour2 = 5;
        int dureeSejour3 = 3;
        Stay sejour1 = null;
        Stay sejour2 = null;
        Stay sejour3 = null;
        if (dureeSejour1 < 6) {
            sejour1 = new ShortStay(dateArrivee1, dureeSejour1, house1, 2);
        } else {
            sejour1 = new LongStay(dateArrivee1, dureeSejour1, house1, 2);
        }
        if (dureeSejour2 < 6) {

            sejour2 = new ShortStay(dateArrivee2, dureeSejour2, appartement1, 1);
        } else {

            sejour2 = new LongStay(dateArrivee2, dureeSejour2, appartement1, 1);
        }
        if (dureeSejour3 < 6) {
            sejour3 = new ShortStay(dateArrivee3, dureeSejour3, house2, 5);
        } else {
            sejour3 = new LongStay(dateArrivee3, dureeSejour3, house2, 5);
        }
// conversion en sejour du séjour court ou long pour que la réservation accepte les deux types enfants
        sejour1 = (Stay) sejour1;
        sejour2 = (Stay) sejour2;
        sejour3 = (Stay) sejour3;


        //
        // les réservations
        //

        Booking reservation1 = new Booking(sejour1, personne2);
        System.out.println("\nRéservation numéro " + reservation1.getId() + ":");
        reservation1.display();
        personne1.display();


        Booking reservation2 = new Booking(sejour2, personne4);
        System.out.println("\nRéservation numéro " + reservation2.getId() + ":");
        reservation2.display();
        personne3.display();


        Booking reservation3 = new Booking(sejour3, personne4);
        System.out.println("\nRéservation numéro " + reservation3.getId() + ":");
        reservation3.display();
        personne5.display();

        //        personne1.display();
        //        logement1.display();
        //        sejour1.display();
        sc.close();
    }
    public static void gestiondedates(){
        /**
         * function for study about the api date
         */
        Uti.info("Main","gestiondedates","");
        sc = new Scanner( System .in);

        System.out.println("Test de dat 1");
//         dateSaisie = new LocalDate(1992, 03, 21);
//        Instant instant =  Instant.now();
//        if (instant.isAfter(Instant.from(dateSaisie))){
//            System.out.println("GAGNE!! La date saisie est postérieure à celle d'aujourd'hui.");
//        }
//        else
//            {
//                System.out.println("PERDU!! La date saisie est antérieure à celle d'aujourd'hui.");
//            }

        System.out.println("Test de date 2");

        Uti.mess("Temps machine");
        Instant instant1 = Instant.EPOCH;
        Instant instant2 = Instant.now();
        System.out.println(instant1 + "  " + instant2);
        if(instant1.isAfter(instant2))
        {
            System.out.println("Le temps s'est inversé : Instant.EPOCH est après Intant.now()");
        }
        else
        {
            System.out.println("Le temps suit son cours : Instant.EPOCH est avant Intant.now()");
        }
        if(instant1.isBefore(instant2))
        {
            System.out.println("Le temps suit son cours : Instant.EPOCH est avant Intant.now()");
        }
        else
        {
            System.out.println("Le temps s'est inversé : Instant.EPOCH est après Intant.now()");
        }

        Uti.mess("Temps humain");

        System.out.println("LocaleDate et LocalDateTime");
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Date et heure courante : " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("Date courante : " + date1);

        Month mois = currentTime.getMonth();
        int moisNombre = currentTime.getMonth().ordinal();
        int jour = currentTime.getDayOfMonth();
        int heure = currentTime.getHour();

        System.out.println("Mois : " + mois +", jour : " + jour +", heure : " + heure);
        System.out.println("Mois : " + (moisNombre+1) +", jour : " + jour +", heure : " + heure);

        //Avoir le 25 décembre 2023
        LocalDateTime date2 = currentTime.withDayOfMonth(25).withYear(2023).withMonth(12);
        System.out.println("Date modifiée : " + date2);

        //une autre façon
        LocalDate date3 = LocalDate.of(2023, Month.DECEMBER, 25);
        System.out.println("Autre façon de faire : " + date3);

        //On peut même parser une date depuis un String
        LocalTime parsed = LocalTime.parse("20:15:30");
        System.out.println("Date parsée : " + parsed);
        Uti.mess("les fuseaux horaires");
        Map<String, String> maps = ZoneId.SHORT_IDS;
        maps.values().stream().forEach((x) -> {System.out.println(x + " -- " + ZoneId.of(x).getRules());});

        //Et connaître notre fuseau
        System.out.println("");
        System.out.println("Fuseau horaire courant : "+ZoneId.systemDefault());
        System.out.println("Règle appliquer aux heures : " + ZoneId.systemDefault().getRules());
        Uti.mess("application des changements de règles d'heures");
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.parse(ldt.now().toString());
        List<ZoneId> lzi = Arrays.asList(
                ZoneId.of("Europe/Paris"),
                ZoneId.of("Asia/Tokyo"),
                ZoneId.of("America/Anchorage")
        );

        lzi	.stream()
                .forEach((x) -> {
                    System.out.println(x + " : \t" + ldt2.atZone(x).toInstant());
                });

        Uti.mess("date locale vers date universelle");

        Uti.mess("date universelle date locale vers");

        Uti.mess("Temps humain vers temps machine");

        Uti.mess("Temps machine vers temps humain");
        sc.close();
    }

    public static void main(String[] args)  {
        /**
         * creates and opens the main window
         */
        Uti.info("Main","main","");
        LesIO lesIO = new LesIO();
//        lesIO.mlio1a();
//        lesIO.mlio1b();
//        lesIO.mlio2();
//        lesIO.mlio3();
//        lesIO.copyFileInAnother();
        lesIO.test();
    }
}





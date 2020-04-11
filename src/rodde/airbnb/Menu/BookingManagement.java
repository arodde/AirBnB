package rodde.airbnb.Menu;

import rodde.airbnb.reservations.Booking;
import rodde.airbnb.reservations.Stay;
import rodde.airbnb.reservations.ShortStay;
import rodde.airbnb.reservations.LongStay;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Traveler;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;

public class BookingManagement {

    public static void listBookingsMenu() {
        Uti.info("GestionReservations","listerReservations()","");
        Uti.sep("-", 50);

//        System.out.println("les listes");
//        System.out.println(Menu.getListeHotes().size());
//        System.out.println(Menu.getListeLogements().size());
//        System.out.println(Menu.getListeReservations().size());
//        System.out.println(Menu.getListeVoyageurs().size());
        System.out.println("Saisir une option");
        System.out.println("1 : Ajouter une réservation");
        System.out.println("2 : Supprimer une réservation");
        System.out.println("3 : Retour");
        switch (Menu.choice(3)) {
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
                throw new IllegalStateException("Unexpected value: " + Menu.choice(3));
        }
    }
    protected static void addBooking() throws Exception {
        Uti.info("GestionReservations","ajouterReservation()","");
        boolean bOk = false;
        int nombreNuit =-1;
        int numeroVoyageur=-1;
        int numeroLogement= -1;
        Traveler voyageur=null;
        Stay sejour ;
        Booking reservationAjoutee;
        LocalDate dateSejour = null;
//        Path path = Paths.get("C:\\Directory2\\Sub2\\Sub-Sub2");
        Path path = null;
        File file = null;
        TravellersManagement gestionVoyageurs =null;
        // voyageur affichage des voyageurs et choix de l'indice
        indexOfDisplayedBooking();
        //
        if (Menu.getTravelerArrayList().isEmpty()) {
            System.out.println("Aucun voyageur enregistré, Toute réservation doit être rattachée à un voyageur");
            Menu.listMenu();
        }
        else
        {
            // afficher la liste des voyageurs
            TravellersManagement.indexOfDisplayedTraveler();
            // saisie nombre de voyageurs
            bOk=false;
            while (!bOk) {
                try {
                    System.out.print("Entrer le numéro du voyageur dans la liste: ");
                    numeroVoyageur = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (numeroVoyageur >= 0 && numeroVoyageur<= (Menu.getTravelerArrayList().size()-1)) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un numero de voyageur saisi en chiffre(s) et positif");
                }
            }
            voyageur = Menu.getTravelerArrayList().get(numeroVoyageur);
        }

        // détermination numéro du logement
        if (Menu.getHousingArrayList().isEmpty()) {
            System.out.println("Aucun logement enregistré, Toute séjour doit doit être rattaché à un logement.");
            Menu.listMenu();
        }
        else
        {
            // afficher la liste des logements
            HousingManagement.indexOfDisplayedHousing();
            // saisie nombre de logements
            bOk=false;
            while (!bOk) {
                try {
                    System.out.println("Entrer le numéro du logement choisi dans la liste: ");
                    numeroLogement = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (numeroLogement >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un numero de logement saisi en chiffre(s) et positif");
                }
            }

        }
        // affichage liste des réservations
        Menu.getBookingArrayList().forEach(reservation->reservation.display());

        // determination du nombre de nuits
        bOk = false;
        while (!bOk) {
            try {
                System.out.print("Entrer le nombre de nuits : ");
                nombreNuit = Menu.sc.nextInt();
                Menu.sc.nextLine();
                if (nombreNuit >= 0) {
                    bOk = true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("il faut un nombre du nuit saisi en chiffre(s) et positif");
            }
        }
        // détermination de la date du séjour
        bOk = false;
        while(!bOk){
            int annee =-1;
            int mois =-1;
            int jour =-1;
//            while( annee < LocalDate.now().getYear()){
            // saisie annee
            while (!bOk) {
                try {
                    System.out.println("Année de réservation? : ");
                    annee =Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (annee >= LocalDate.now().getYear()) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut une année saisie en chiffre(s) et actuelle ou future.");
                }
            }
//            }
            bOk = false;
//            while( mois < LocalDate.now().getMonth().ordinal()){

            // saisie mois
            while (!bOk) {
                try {
                    System.out.println("Mois de réservation? : ");
                    mois =Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (mois >= 1&& mois <=12) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un mois saisi en chiffre(s) entre 1 et 12");
                }
            }
//            }

            while( jour < 1 || jour > 31){
                System.out.println("Jour de réservation? : ");
                jour = Menu.sc.nextInt();
            }
            dateSejour= dateSejour.of(annee,mois,jour);
            bOk=false;
            if( dateSejour.isAfter(LocalDate.now())){
                bOk=true;
            }
            else
            {
                System.out.println("Cette date de réservation est impossible retenir car antérieure à la date actuelle.");
            }
        }


        // ajout du séjour court ou longs
        if (nombreNuit < 6) {
            sejour = new ShortStay(dateSejour, nombreNuit, Menu.getHousingArrayList().get(numeroLogement), Menu.getHousingArrayList().get(numeroLogement).getMaxTravelersNumber());
        } else {
            sejour = new LongStay(dateSejour, nombreNuit, Menu.getHousingArrayList().get(numeroLogement), Menu.getHousingArrayList().get(numeroLogement).getMaxTravelersNumber());

        }
        // instanciation Réservation
        reservationAjoutee =new Booking(sejour,voyageur);
        // ajout d'une réservation à la liste des réservations
        Menu.getBookingArrayList().add(reservationAjoutee);
        // affiche la liste de tous les réservations

        indexOfDisplayedBooking();

        // sauvegarde dans un fichier de la réservation
  /*      try {
//            String racine ="D:\\Users\\demon\\Documents\\cdsm_cours\\peter_bardu\\java\\TPs\\TP 6 - Le menu\\";
            // création dossier de sauvegarde
            path = Paths.get("D:\\Users\\demon\\Documents\\cdsm_cours\\peter_bardu\\java\\TPs\\TP 6 - Le menu\\xyzreservationsfaites");

            //if directory exists?
            if (!exists(path)) {
                try {
                    Files.createFile(path);
//                    createDirectories(path);
                } catch (IOException e) {
                    //fail to create directory
                    e.printStackTrace();
                }
            }*/
            ////

            ////
//Files.createDirectories("D:\\Users\\demon\\Documents\\cdsm_cours\\peter_bardu\\java\\TPs\\TP 6 - Le menu\\xyzreservationsfaites\\xyzmydatajava.txt");
//            String fichier = "D:\\Users\\demon\\Documents\\cdsm_cours\\peter_bardu\\java\\TPs\\TP 6 - Le menu\\xyzreservationsfaites\\xyzmydatajava.txt";
//            FileWriter fw = new FileWriter("D:\\Users\\demon\\Documents\\cdsm_cours\\peter_bardu\\java\\TPs\\TP 6 - Le menu\\xyzreservationsfaites\\xyzmydatajava.txt");



        File doss = new File("D:\\Users\\demon\\Documents\\cdsm_cours\\peter_bardu\\java\\TPs\\TP 6 - Le menu\\xyzdoss");
        if (!doss.exists()) {
            if (doss.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }
        FileWriter fw = new FileWriter("xyzmydatajava.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print("Numéro du Voyageur : " + numeroVoyageur + "\n");
            pw.print("Numéro du logement : " + numeroLogement + "\n");
            pw.print("Date d'arrivée (DD/MM/YYYY) : " + dateSejour + "\n");
            pw.print("Nombre de nuits : " + nombreNuit + "\n");
            pw.print("Nombre de personnes : " + sejour.getTravelersNumber() + "\n");
            pw.close();
//        } catch (Exception e) {
//            System.err.println("error");
//        }
//        } catch (FileNotFoundException e){
//            System.out.println("=======> Impossible ouvrir fichier :"+ e.getMessage());
//        } catch (IOException e){
//            System.out.println("=======> Erreur lecture/écriture"+ e.getMessage());
//        }
    }
    protected static void indexOfDisplayedBooking(){
        /**
         * display the list's element with index and call the
         * display method of this element and go to the next line
         */
        Uti.info("GestionReservations","indiceReservationAffiche()","");
        // affiche la liste de tous les hôtes
        int indiceAffi=0;
        for(Booking reservation:Menu.getBookingArrayList()){
            System.out.print("n° "+indiceAffi+" : ");
            reservation.display();
            System.out.println();
            indiceAffi++;
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

            int indiceSuppr=0;
            indexOfDisplayedBooking();
            // saisie indice
            while (!bOk) {
                try {
                    System.out.print("Entrer l'indice : ");
                    indiceSuppr = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (indiceSuppr >= 0 && indiceSuppr <= (Menu.getBookingArrayList().size()-1)) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un indice compris entre 0 et "+ (Menu.getBookingArrayList().size()-1));
                }
                // affiche la liste de tous les réservations
                indexOfDisplayedBooking();
            }
            System.out.println();
            Menu.getBookingArrayList().remove(indiceSuppr);
            indexOfDisplayedBooking();
        }

    }

}
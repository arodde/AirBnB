package rodde.airbnb.reservations;

import rodde.airbnb.util.Uti;

public class InstanciationReservationException extends Exception {
    public InstanciationReservationException(){

        Uti.info("InstanciationReservationException","InstanciationReservationException()","");
        System.out.println("La réservation ne peut être créé si :");
        System.out.println("\t - la date de séjour est passée");
        System.out.println("\t - la duree du séjour n'est pas comprise entre 1 et 31 jours");
        System.out.println("\t - le nombre de voyageurs excède le nombre de place dans le logement réservé");
    }
}

package rodde.airbnb.reservations;

import rodde.airbnb.util.Uti;

public class instantiationBookingException extends Exception {
    /**
     return an exception if the conditions of intantiation of the  stay aren't got
     */
    public instantiationBookingException(){

        Uti.info("InstanciationReservationException","InstanciationReservationException()","");
        System.out.println("La réservation ne peut être créée si :");
        System.out.println("\t - la date de séjour est passée");
        System.out.println("\t - la duree du séjour n'est pas comprise entre 1 et 31 jours");
        System.out.println("\t - le nombre de voyageurs excède le nombre de place dans le logement réservé");
    }
}

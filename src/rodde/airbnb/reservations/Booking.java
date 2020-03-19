package rodde.airbnb.reservations;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Traveler;

import java.time.LocalDate;

public class Booking {

    private static int id =-1;
    private Stay stay;
    private Traveler traveler;
    private boolean isValidated;
    private LocalDate bookingDate;

    public Booking(/*int identifiant, */Stay sejour, Traveler voyageur ) throws instantiationBookingException {
        Uti.info("Reservation", "Reservation()","2 p");

        // Tests de validation sur le séjour
        if((!sejour.arrivalDateVerification())||(!sejour.checkTravelersNumber())||(!sejour.overnightsNumberVerification())){
            throw new instantiationBookingException();
        }
        // si les conditions à la créations d'un séjour sont correctes
        Booking.id = id++;
        this.stay = sejour;
        this.traveler = voyageur;
        this.isValidated = false;
        this.bookingDate = LocalDate.now();

    }
    public void display(){
        Uti.info("Reservation", "afficher()","");
        traveler.display();
        System.out.print(" a fait une réservation chez ");
        stay.display();
    }


    public int getId() {
        Uti.info("Reservation", "getIdentifiant()","");
        return id;
    }
}

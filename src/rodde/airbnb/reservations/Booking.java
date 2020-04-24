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

    public Booking(/*int identifiant, */Stay stay, Traveler traveler ) throws instantiationBookingException {
        Uti.info("Reservation", "Reservation()","2 p");
        // Tests de validation sur le séjour
        if((!stay.arrivalDateVerification())||(!stay.checkTravelersNumber())||(!stay.overnightsNumberVerification())){
            throw new instantiationBookingException();
        }
        else
        {
            // si les conditions à la créations d'un séjour sont correctes
            Booking.id = id++;
            this.stay = stay;
            this.traveler = traveler;
            this.isValidated = false;
            this.bookingDate = LocalDate.now();
        }
    }
    public void display(){
        Uti.info("Reservation", "display()","");
        traveler.display();
        System.out.print(" a fait une réservation chez ");
        stay.display();
    }


    public int getId() {
        Uti.info("Reservation", "getId()","");
        return id;
    }
}

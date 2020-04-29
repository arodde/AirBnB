package rodde.airbnb.reservations;

import org.w3c.dom.ls.LSOutput;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Traveler;

import java.time.LocalDate;

public class Booking {

    private  int id =0;
    private static int index =-1;
    private Stay stay;
    private Traveler traveler;

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    private boolean isValidated;
    private LocalDate bookingDate;

    public Booking(/*int identifiant,*/ Stay stay, Traveler traveler ) throws instantiationBookingException {
        Uti.info("Reservation", "Reservation()","2 p");
        // Tests de validation sur le séjour
        if((!stay.arrivalDateVerification())||(!stay.checkTravelersNumber())||(!stay.overnightsNumberVerification())){
            throw new instantiationBookingException();
        }
        else
        {
            // si les conditions à la créations d'un séjour sont correctes
            this.id = index + 1;
            index ++;
            this.stay = stay;
            this.traveler = traveler;
            this.isValidated = false;
            this.bookingDate = LocalDate.now();
        }
    }
    public void display(){
        Uti.info("Reservation", "display()","");
        System.out.println("\nRéservation n° "+this.getId()+":\n");
        traveler.display();
        System.out.print(" a fait une réservation chez ");
        if(isValidated)
            System.out.println("RESERVATION ACCEPTEE");
        else
            System.out.println("RESERVATION EN ATTENTE D'ACCEPTATION");
        stay.display();
    }
    public String stringDisplay(){
        Uti.info("Reservation", "display()","");
        String textOfReservation =this.getId()+":\n";
//        String textOfReservation ="\nRéservation n° "+this.getId()+":\n";
//        textOfReservation += traveler.stringDisplay();
//        textOfReservation += " a fait une réservation chez ";
//        textOfReservation += stay.stringDisplay();
        textOfReservation +=  traveler.stringDisplay();
        textOfReservation += " a fait une réservation chez ";
        textOfReservation += stay.stringDisplay();
        return textOfReservation;
    }

    public int getId() {
//        Uti.info("Reservation", "getId()","");
        return id;
    }
}

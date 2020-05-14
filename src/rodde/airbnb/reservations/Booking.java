package rodde.airbnb.reservations;

import org.w3c.dom.ls.LSOutput;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Traveler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Booking {

    public void setId(int id) {
        this.id = id;
    }

    private  int id =0;
    private static int index =-1;
    private Stay stay;
    private Traveler traveler;
    private boolean isValidated;

//    public String getBookingState() {
//        return bookingState;
//    }
//
//    public void setBookingState(String bookingState) {
//        this.bookingState = bookingState;
//    }

    private String bookingState;
    private Booking bookingAdded;
    public boolean isValidated() {
        return isValidated;
    }
    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    private LocalDate bookingDate;
    public Booking(/*int identifiant,*/ Stay stay, Traveler traveler ) throws instantiationBookingException {
        /**
          the booking's constructor instantiates a booking if the stay respects several conditions:
           - the arrivalDate have to be  posterior the instantiation
           - the travelersNumber have to be equal or inferior of the maximum traveler's Number of the housing
           - the otherNightsNumber have to be between 1 nights and the end of the month
         */
        Uti.info("Reservation", "Reservation()","2 p");
        if((!stay.arrivalDateVerification())||(!stay.checkTravelersNumber())||(!stay.overnightsNumberVerification())){
            throw new instantiationBookingException();
        }
        else
        {
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
        this.bookingAdded = bookingAdded;
        String textOfReservation =this.getId()+":\n";
        textOfReservation +=  traveler.stringDisplay();
        textOfReservation += " a fait ";
        editBookingState();
        textOfReservation += bookingState+ "chez ";
        textOfReservation += stay.stringDisplay();
        System.out.println(textOfReservation);
        stay.display();
    }
    public void editBookingState(){
        if(isValidated)
            bookingState ="une réservation acceptée ";
        else
            bookingState ="une demande de réservation en attente de confirmation ";
    }
    public String stringDisplay(){
        Uti.info("Reservation", "stringDisplay()","");
        String textOfReservation =this.getId()+":\n";

        textOfReservation +=  traveler.stringDisplay();
        textOfReservation += " a fait ";
        editBookingState();
//        if(isValidated)
//            bookingState +="une réservation acceptée";
//        else
//            bookingState +="une demande de réservation en attente de confirmation";
        textOfReservation += bookingState+"chez ";
        textOfReservation += stay.stringDisplay();
        return textOfReservation;
    }

    public int getId() {
//        Uti.info("Reservation", "getId()","");
        return id;
    }


}

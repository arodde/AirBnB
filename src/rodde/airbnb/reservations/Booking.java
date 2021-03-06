package rodde.airbnb.reservations;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Traveler;

import java.time.LocalDate;

public class Booking {
    /**
     creates a booking with a stay and a traveler if the booking is accepted by the host
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    private  int id =0;
    private static int index =-1;
    private Stay stay;
    private Traveler traveler;
    private boolean isValidated;
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
        /**
         give the description of the booking and display it in the console
         */
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
        /**
         * change the booking's description according to the boolean isValided
         */
        if(isValidated)
            bookingState ="une réservation acceptée ";
        else
            bookingState ="une demande de réservation en attente de confirmation ";
    }
    public String stringDisplay(){
        /**
         give the description of the booking and display it in the window
         */
        Uti.info("Reservation", "stringDisplay()","");
        editBookingState();
        String textOfReservation ="\n\n"+this.getId()+" ";
        textOfReservation +="("+ this.bookingState.toUpperCase()+"):\n";
        textOfReservation +=  traveler.stringDisplay();
        textOfReservation += " a fait ";
        textOfReservation += bookingState+" chez ";
        textOfReservation += stay.stringDisplay();
        return textOfReservation;
    }

    public int getId() {
//        Uti.info("Reservation", "getId()","");
        return id;
    }


}

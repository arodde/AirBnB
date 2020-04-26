package rodde.airbnb.vues;

import rodde.airbnb.reservations.Booking;

import javax.swing.*;
import java.util.ArrayList;

public class ViewBookingDisplay extends JFrame {
    public ViewBookingDisplay(ArrayList<Booking> bookings){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("lister les réservation");
        setName("AirBnBdisplayBooking");
        setResizable(false);
        setBounds(300,100,600,500);


        setVisible(true);
    }
}

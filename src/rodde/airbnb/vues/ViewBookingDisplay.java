package rodde.airbnb.vues;

import rodde.airbnb.reservations.Booking;

import javax.swing.*;
import java.util.ArrayList;

public class ViewBookingDisplay extends JFrame {
    public JPanel jPanel;
    public JScrollPane jScrollPane;
    public JTextPane jTextPane;
    public ViewBookingDisplay(ArrayList<Booking> bookings){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("lister les réservations");
        setName("AirBnBDisplayBooking");
        setResizable(true);
        setBounds(300,100,600,500);
        jPanel = new JPanel();
        jScrollPane = new JScrollPane(jPanel);
        jScrollPane.createVerticalScrollBar();
        jScrollPane.createHorizontalScrollBar();
//        jTextPane = new JTextPane();
        JTextPane jTextPane ;
        for (int i = 0 ; i < bookings.size(); i++) {
            jTextPane = new JTextPane();
            jTextPane.setText(bookings.get(i).stringDisplay());
            jPanel.add(jTextPane );
        }
//        jPanel.add(jTextPane);
        this.setContentPane(jPanel);
        setVisible(true);
    }
}

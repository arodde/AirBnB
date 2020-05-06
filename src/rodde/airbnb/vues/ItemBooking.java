package rodde.airbnb.vues;

import com.sun.javaws.IconUtil;
import rodde.airbnb.reservations.Booking;
import rodde.airbnb.util.Uti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class ItemBooking {
    public JPanel jPanelSon = new JPanel();
    public JTextPane jTextPane = new JTextPane();
    public Booking booking ;
    public JCheckBox jCheckBoxConfirm= new JCheckBox("Réserver");
    public JCheckBox jCheckBoxDelete= new JCheckBox("Supprimer");
    BookingConfirmListener bookingConfirmListener = new BookingConfirmListener();

    ItemBooking(Booking booking){
        this.booking = booking;
        jCheckBoxConfirm.addActionListener(bookingConfirmListener);
        Uti.mess("Item booking créé.");
    }
    class BookingConfirmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { ;
            Uti.info("BookingConfirmListener","actionPerformed","");
            Uti.mess("action sur jCheckboxConfirm "+booking.getId()+" "+(booking.isValidated()?"coché":"decoché"));
            if(!booking.isValidated())
            {
                jTextPane.setBackground(Color.GREEN);
                System.out.println(booking.getId()+" "+booking.isValidated());
                booking.setValidated(true);
                System.out.println(booking.getId()+" "+booking.isValidated());
            }
            else
            {
                jTextPane.setBackground(Color.red);
                System.out.println(booking.getId()+" "+booking.isValidated());
                booking.setValidated(false);
                System.out.println(booking.getId()+" "+booking.isValidated());
            }

        }
    }
//    class BookingDeleteListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Uti.info("BookingDeleteListener","actionPerformed","");
//        }
//    }
}


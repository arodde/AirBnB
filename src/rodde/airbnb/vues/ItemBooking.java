package rodde.airbnb.vues;

import com.sun.javaws.IconUtil;
import rodde.airbnb.reservations.Booking;
import rodde.airbnb.util.Uti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemBooking {
    public JPanel jPanelSon = new JPanel();
    public JPanel jPanelCommand;
    public JTextPane jTextPane ;
    public Booking booking ;
    public JCheckBox jCheckBoxConfirm= new JCheckBox("Réserver");
    public JCheckBox jCheckBoxDelete= new JCheckBox("Supprimer");
    BookingConfirmListener bookingConfirmListener = new BookingConfirmListener();
    BookingDeleteListener bookingDeleteListener = new BookingDeleteListener();

    ItemBooking(Booking booking){
        this.booking = booking;
        jCheckBoxConfirm.addActionListener(bookingConfirmListener);
        jCheckBoxDelete.addActionListener(bookingDeleteListener);
    }
    public void organizeJPanelSon(){
        Uti.info("ItemBooking","public void organizeJPanelSon(){\n","");
        jPanelSon.setLayout(new BorderLayout());
        jPanelSon.add(jTextPane, BorderLayout.WEST);
        jPanelSon.add(jPanelCommand, BorderLayout.EAST);
        positionCheckButton();
    }
    public void positionCheckButton(){
        /**
         * organize the position of jCheckBox
         */
        Uti.info("ItemBooking","positionCheckButton","");
//        jPanelCommand.setLayout(new BorderLayout());
//        jPanelCommand.add(jCheckBoxConfirm, BorderLayout.NORTH);
//        jPanelCommand.add(jCheckBoxDelete, BorderLayout.SOUTH);
        jPanelCommand.setLayout(new GridLayout(2,1));
        jPanelCommand.add(jCheckBoxConfirm);
        jPanelCommand.add(jCheckBoxDelete);
    }

    class BookingConfirmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
    class BookingDeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Uti.info("BookingDeleteListener","actionPerformed","");

        }
    }
}


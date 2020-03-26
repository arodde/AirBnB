package rodde.airbnb.vues;

import rodde.airbnb.Menu.BookingManagement;
import rodde.airbnb.Menu.HostsManagement;
import rodde.airbnb.Menu.HousingManagement;
import rodde.airbnb.Menu.TravellersManagement;
import rodde.airbnb.logements.Housing;
import rodde.airbnb.reservations.Booking;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;
import rodde.airbnb.utilisateurs.Traveler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewMenu extends JFrame {
    public static Scanner sc;
    public JPanel jPanel;
    public JMenuBar jMenuBar;
    public JMenu jMenuAdd ;
    public JMenu jMenuDisplay ;
    public JMenuItem jMenuItemClose ;
    public JMenuItem jMenuItemDisplayReservation ;
    public JMenu jMenuAddHost;
    public JMenu jMenuAddTraveler;
    public JMenu jMenuAddHouse;
    public JMenu jMenuAddAppartment;
    public JMenu jMenuAddBooking;
    public JComboBox jComboBoxTravelers;
    public JComboBox jComboBoxHousings;
    public JComboBox jComboBoxBookings;

    //    private Menu menu;
    private static ArrayList<Traveler> travelerArrayList = new ArrayList<Traveler>();
    private static ArrayList<Housing> housingArrayList = new ArrayList<Housing>();
    private static ArrayList<Booking> bookingArrayList  = new ArrayList<Booking>();
    private static BookingManagement bookingManagement = new BookingManagement();
    private static TravellersManagement travelersManagement =  new TravellersManagement();
    private static HostsManagement hostsManagement = new HostsManagement();
    private static HousingManagement housingManagement= new HousingManagement();
    private static ViewMenu viewMenu;
    private static ViewHostCreation viewHostCreation;
    private static ViewTravellerCreation viewTravellerCreation;
    private static ViewHouseCreation viewHouseCreation;

    public static void main(String[] args)  {
        Uti.info("Menu","main","");
        sc = new Scanner( System .in);
        ViewMenu vueMenu = new ViewMenu();
//        airBnB();
        travelerArrayList = new ArrayList<Traveler>();
        housingArrayList = new ArrayList<Housing>();
        bookingArrayList = new ArrayList<Booking>();
        hostsManagement = new HostsManagement();
        housingManagement = new HousingManagement();
        travelersManagement = new TravellersManagement();
        bookingManagement = new BookingManagement();




        sc.close();
    }
    public ViewMenu(){
        // doit remplacer menu
        // todo fen menu pour ajouter voyageurs, hôtes, logements, réservations
        // add characteristics to The window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AirBnB");
        setResizable(false);
        setSize(600,500);
        setLocationRelativeTo(null);

        initMenu();
        // todo revoir logique  ajouter hôte voyageur logement tenter de prendre un séjour et voir pour avoir une réservation
        jPanel = new JPanel();
        jPanel.setBackground(Color.blue);
        this.setContentPane(jPanel);
        setVisible(true);
    }

    public void initMenu(){
        /**
         * create the menu bar with all JMenu and JMenuItem with their specific action
         */
        Uti.info("ViewMenu","initMenu","");
        jMenuBar = new JMenuBar();
        jMenuAdd = new JMenu("Ajouter");
        jMenuDisplay = new JMenu("Afficher");
        jMenuItemDisplayReservation = new JMenuItem("Afficher les réservations");
//        jMenuItemAddHost = new JMenuItem("Ajouter un hôte");
        jMenuAddHost = new JMenu("Ajouter un hôte");
        jMenuAddTraveler = new JMenu("Ajouter un voyageur");
        jMenuAddHouse = new JMenu("Ajouter une maison");
        jMenuAddAppartment = new JMenu("Ajouter un appartement");
        jMenuAddBooking = new JMenu("Ajouter un séjour");
        jMenuItemClose = new JMenuItem("Fermer");
        jComboBoxTravelers = new JComboBox();
        jComboBoxHousings = new JComboBox();
        jComboBoxBookings = new JComboBox();
        jMenuItemClose.addActionListener(new ActionListener(){
                                             @Override
                                             public void actionPerformed(ActionEvent e) {
                                                 System.exit(0);
                                             }
                                         }
        );
        viewHouseCreation = new ViewHouseCreation();
        jMenuAdd.add(jMenuAddHost);
        jMenuAdd.add(jMenuAddHouse);
        jMenuAdd.add(jMenuAddAppartment);
        jMenuAdd.add(jMenuAddTraveler);
        jMenuAdd.add(jMenuAddBooking);
        jMenuDisplay.add(jMenuItemDisplayReservation);
        jMenuBar.add(jMenuAdd);
        jMenuBar.add(jMenuDisplay);
        jMenuBar.add(jMenuItemClose);
        setJMenuBar(jMenuBar);
    }


}
// todo vue création logements
// todo vue création séjours
// todo vue création réservation
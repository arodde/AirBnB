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
    public JMenuItem jMenuAddHost;
    public JMenuItem jMenuAddTraveler;
    public JMenuItem jMenuAddHouse;
    public JMenuItem jMenuAddAppartment;
    public JMenuItem jMenuAddStay;
    public JComboBox jComboBoxTravelers;
    public JComboBox jComboBoxHousings;
    public JComboBox jComboBoxStays;

    //    private Menu menu;
    public static ArrayList<Traveler> travelerArrayList = new ArrayList<Traveler>();
    public static ArrayList<Host> hostArrayList = new ArrayList<Host>();
    public static ArrayList<Housing> housingArrayList = new ArrayList<Housing>();
    public static ArrayList<Booking> bookingArrayList  = new ArrayList<Booking>();
    public static BookingManagement bookingManagement = new BookingManagement();
    public static TravellersManagement travelersManagement =  new TravellersManagement();
    public static HostsManagement hostsManagement = new HostsManagement();
    public static HousingManagement housingManagement= new HousingManagement();
    public static ViewMenu viewMenu;
    public static ViewHostCreation viewHostCreation;
    public static ViewTravelerCreation viewTravelerCreation;
    public static ViewHouseCreation viewHouseCreation;

    public static void main(String[] args)  {
        Uti.info("ViewMenu","main","");
        sc = new Scanner( System .in);
        ViewMenu vueMenu = new ViewMenu();
//        airBnB();
        hostsManagement = new HostsManagement();
        housingManagement = new HousingManagement();
        travelersManagement = new TravellersManagement();
        bookingManagement = new BookingManagement();
        hostArrayList = new ArrayList<Host>();



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
        jMenuAddHost = new JMenuItem("Ajouter un hôte");
        jMenuAddTraveler = new JMenuItem("Ajouter un voyageur");
        jMenuAddHouse = new JMenuItem("Ajouter une maison");
        jMenuAddAppartment = new JMenuItem("Ajouter un appartement");
        jMenuAddStay = new JMenuItem("Ajouter un séjour");
        jMenuItemClose = new JMenuItem("Fermer");
        jComboBoxTravelers = new JComboBox();
        jComboBoxHousings = new JComboBox();
        jComboBoxStays = new JComboBox();

        jMenuItemClose.addActionListener(new ActionListener(){
                                             @Override
                                             public void actionPerformed(ActionEvent e) {
                                                 System.exit(0);
                                             }
                                         }
        );
        jMenuAddHost.addActionListener(new ViewCreationHostListener());
        jMenuAddHouse.addActionListener(new ViewCreationHouseListener());
        jMenuAddTraveler.addActionListener(new ViewCreationTravelersListener());
        jMenuAdd.add(jMenuAddHost);
        jMenuAdd.add(jMenuAddHouse);
        jMenuAdd.add(jMenuAddAppartment);
        jMenuAdd.add(jMenuAddTraveler);
        jMenuAdd.add(jMenuAdd);
        jMenuDisplay.add(jMenuItemDisplayReservation);
        jMenuBar.add(jMenuAdd);
        jMenuBar.add(jMenuDisplay);
        jMenuBar.add(jMenuItemClose);
        setJMenuBar(jMenuBar);
    }

    class ViewCreationHouseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewHouseCreation = new ViewHouseCreation();
        }
    }
//    class ViewCreationAppartmentListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            viewAppartmentCreation = new ViewAppartmentCreation();
//        }
//    }
    class ViewCreationHostListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewHostCreation = new ViewHostCreation();
        }
    }
    class ViewCreationTravelersListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewTravelerCreation = new ViewTravelerCreation();
        }
    }
}
// todo vue création logements
// todo vue création séjours
// todo vue création réservation
package rodde.airbnb.vues;

import rodde.airbnb.logements.Appartment;
import rodde.airbnb.logements.House;
import rodde.airbnb.logements.Housing;
import rodde.airbnb.reservations.Booking;
import rodde.airbnb.reservations.Stay;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;
import rodde.airbnb.utilisateurs.Traveler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewMenu extends JFrame {

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
    //    private Menu menu;
    public ViewHostCreation viewHostCreation;
    public ViewTravelerCreation viewTravelerCreation;
    public ViewHouseCreation viewHouseCreation;
    public ViewAppartmentCreation viewAppartmentCreation;
    public ViewStayCreation viewStayCreation;
    public ArrayList<Traveler> travelerArrayList;
    public ArrayList<Host> hostArrayList ;
    public ArrayList<Housing> housingArrayList;
    public ArrayList<Booking> bookingArrayList;

    public void initArrayAndManagment(){
        /**
         * creates the lists if they don't created before
         * created lists :
         * - booking
         * - Hosts
         * - Housings
         * - Travelers
         */
        Uti.info("ViewMenu","initArrayAndManagment()","");
        if(travelerArrayList== null)
            travelerArrayList = new ArrayList<Traveler>();
        if(hostArrayList== null)
            hostArrayList = new ArrayList<Host>();
        if(housingArrayList== null)
            housingArrayList = new ArrayList<Housing>();
        if(bookingArrayList== null)
            bookingArrayList  = new ArrayList<Booking>();
    }
    public ViewMenu(){
        /**
         * this constructor create the main window
         * call
         *  - initArrayAnManagment
         *  - initMenu
         */
        // todo fen menu pour ajouter voyageurs,  réservations
        // add characteristics to The window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AirBnB");
        setResizable(false);
        setSize(600,500);
        setLocationRelativeTo(null);
        initArrayAndManagment();
        initMenu();
        jPanel = new JPanel();
        jPanel.setBackground(Color.blue);
        this.setContentPane(jPanel);
        setVisible(true);
        provisoireRemplissageListes();// todo
    }

    private void provisoireRemplissageListes() {
        /**
         * this function prevents the developper to create a
         * data set before each try of the the piece of
         * software he is developping
         */

        hostArrayList.add(new Host("aa","aaa",12,11));
        hostArrayList.add(new Host("ab","abb",13,12));
        hostArrayList.add(new Host("ac","acc",14,13));
        hostArrayList.add(new Host("ad","add",15,14));
        travelerArrayList.add(new Traveler("zz","zzz",22));
        travelerArrayList.add(new Traveler("zy","zyy",23));
        travelerArrayList.add(new Traveler("zx","zxx",24));
        travelerArrayList.add(new Traveler("zw","zww",25));
        housingArrayList.add((Housing) new House(hostArrayList.get(0),3,"3ddd3",66,3,99,true));
        housingArrayList.add((Housing) new House(hostArrayList.get(1),4,"3dgfsfhs",76,8,46,false));
        housingArrayList.add((Housing) new Appartment(hostArrayList.get(2),5,"3ddffffffffd3",76,8,1,23));
        housingArrayList.add((Housing) new Appartment(hostArrayList.get(3),6,"3dhhdd3",86,11,0,0));


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
        jMenuItemClose.addActionListener(new ActionListener(){
                                             @Override
                                             public void actionPerformed(ActionEvent e) {
                                                 System.exit(0);
                                             }
                                         }
        );
        jMenuAddHost.addActionListener(new ViewCreationHostListener());
        jMenuAddHouse.addActionListener(new ViewCreationHouseListener());
        jMenuAddAppartment.addActionListener(new ViewCreationAppartmentListener());
        jMenuAddTraveler.addActionListener(new ViewCreationTravelersListener());
        jMenuAddStay.addActionListener(new ViewCreationStayListener());
        jMenuAdd.add(jMenuAddHost);
        jMenuAdd.add(jMenuAddHouse);
        jMenuAdd.add(jMenuAddAppartment);
        jMenuAdd.add(jMenuAddTraveler);
        jMenuAdd.add(jMenuAddStay);
        jMenuAdd.add(jMenuAdd);
        jMenuDisplay.add(jMenuItemDisplayReservation);
        jMenuBar.add(jMenuAdd);
        jMenuBar.add(jMenuDisplay);
        jMenuBar.add(jMenuItemClose);
        setJMenuBar(jMenuBar);
    }

    class ViewCreationHouseListener implements ActionListener {
        /**
         * creates and opens the window to add an house
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Uti.info("ViewCreationHouseListener","actionPerformed()","");
            if (housingArrayList == null)
                Uti.mess("liste de séjour nulle.");
            viewHouseCreation = new ViewHouseCreation(hostArrayList,housingArrayList);
        }
    }
    class ViewCreationAppartmentListener implements ActionListener {
        /**
         * creates and opens the window to add an appartement
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Uti.info("ViewCreationAppartmentListener","actionPerformed()","");
            if (hostArrayList == null)
                Uti.mess("liste d'hôtes nulle.");
            viewAppartmentCreation = new ViewAppartmentCreation(hostArrayList,housingArrayList);
        }
    }
    class ViewCreationHostListener implements ActionListener {
        /**
         * creates and opens the window to add an host
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Uti.info("ViewCreationHostListener","actionPerformed()","");
            if (hostArrayList == null)
                Uti.mess("liste d'hôtes nulle.");
            viewHostCreation = new ViewHostCreation(hostArrayList);
        }
    }
    class ViewCreationTravelersListener implements ActionListener {
        /**
         * creates and opens the window to add a traveler
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Uti.info("ViewCreationTravelersListener","actionPerformed()","");
            if (travelerArrayList == null)
                Uti.mess("liste de voyageurs nulle.");
            viewTravelerCreation = new ViewTravelerCreation(travelerArrayList);
        }
    }
    class ViewCreationStayListener implements ActionListener {

        /**
         * creates and opens the window to add a stay
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Uti.info("ViewCreationStayListener","actionPerformed()","");
            if (bookingArrayList == null)
                Uti.mess("liste de séjour nulle.");
            viewStayCreation = new ViewStayCreation(travelerArrayList,housingArrayList,bookingArrayList);
        }
    }
}
// todo vue création réservation
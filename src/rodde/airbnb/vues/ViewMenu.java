package rodde.airbnb.vues;

import rodde.airbnb.logements.Appartment;
import rodde.airbnb.logements.House;
import rodde.airbnb.logements.Housing;
import rodde.airbnb.reservations.*;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;
import rodde.airbnb.utilisateurs.Traveler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
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
    public JScrollPane jScrollPane;
    public ViewHostCreation viewHostCreation;
    public ViewTravelerCreation viewTravelerCreation;
    public ViewHouseCreation viewHouseCreation;
    public ViewAppartmentCreation viewAppartmentCreation;
    public ViewStayCreation viewStayCreation;
    public ViewBookingDisplay viewBookingDisplay;
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
        setSize(600,400);
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

        hostArrayList.add(new Host("Martial","CLOCHETTE",35,12));
        hostArrayList.add(new Host("Pénélope","FUYONS",70,96));
        hostArrayList.add(new Host("Thierry","BRUME",14,13));
        hostArrayList.add(new Host("Albus Percival Wulferic Brian","DUMBLEDORE",450,1));
        travelerArrayList.add(new Traveler("Harry","POTTER",18));
        travelerArrayList.add(new Traveler("Arya","STARK",12));
        travelerArrayList.add(new Traveler("Ronald","WEASLEY",18));
        travelerArrayList.add(new Traveler("Tin","TIN",25));
        housingArrayList.add((Housing) new House(hostArrayList.get(0),200,"69 impasse de la Chapelle Fistine 80000 DANS-L-OIGNON",666,69,100,true));
        housingArrayList.add((Housing) new House(hostArrayList.get(1),150,"Château de Poudlard 86000 LA SORCELLERIE",2000,400,7000,false));
        housingArrayList.add((Housing) new Appartment(hostArrayList.get(2),350,"224 Boulevard de la Métropolitaine 75012 PARIS",150,8,2,40));
        housingArrayList.add((Housing) new Appartment(hostArrayList.get(3),25,"7 Tour du guet 19000 LACATAPULTE",35,8,0,0));
//        LocalDate dateArrivee1 = LocalDate.of(2021, 1, 18);// date future
//        LocalDate dateArrivee2 = LocalDate.of(2021, 11, 18);
//        LocalDate dateArrivee3 = LocalDate.of(2021, 12, 18);
//        LocalDate dateArrivee4 = LocalDate.of(2021, 05, 18);
//        int dureeSejour1 = 9;
//        int dureeSejour2 = 5;
//        int dureeSejour3 = 3;
//        int dureeSejour4 = 12;
//        Stay sejour1 = null;
//        Stay sejour2 = null;
//        Stay sejour3 = null;
//        Stay sejour4 = null;
//        if (dureeSejour1 < 6) {
//            sejour1 = new ShortStay(dateArrivee1, dureeSejour1, housingArrayList.get(0), 2);
//        } else {
//            sejour1 = new LongStay(dateArrivee1, dureeSejour1, housingArrayList.get(0), 2);
//        }
//        if (dureeSejour2 < 6) {
//
//            sejour2 = new ShortStay(dateArrivee2, dureeSejour2, housingArrayList.get(2), 1);
//        } else {
//
//            sejour2 = new LongStay(dateArrivee2, dureeSejour2, housingArrayList.get(2), 1);
//        }
//        if (dureeSejour3 < 6) {
//            sejour3 = new ShortStay(dateArrivee3, dureeSejour3,housingArrayList.get(3) , 5);
//        } else {
//            sejour3 = new LongStay(dateArrivee3, dureeSejour3, housingArrayList.get(3), 5);
//        }
//        if (dureeSejour4 < 6) {
//            sejour4= new ShortStay(dateArrivee4, dureeSejour4,housingArrayList.get(1) , 9);
//        } else {
//            sejour4 = new LongStay(dateArrivee4, dureeSejour4, housingArrayList.get(1), 9);
//        }
//// conversion en sejour du séjour court ou long pour que la réservation accepte les deux types enfants
//        sejour1 = (Stay) sejour1;
//        sejour2 = (Stay) sejour2;
//        sejour3 = (Stay) sejour3;
//        sejour4 = (Stay) sejour4;
//        try {
//            bookingArrayList.add(new Booking(sejour1,travelerArrayList.get(0)));
//
//        } catch (instantiationBookingException e) {
//            e.printStackTrace();
//        }
//        try {
//            bookingArrayList.add(new Booking(sejour2,travelerArrayList.get(2)));
//        } catch (instantiationBookingException e) {
//            e.printStackTrace();
//        }
//        try {
//            bookingArrayList.add(new Booking(sejour3,travelerArrayList.get(3)));
//        } catch (instantiationBookingException e) {
//            e.printStackTrace();
//        }
//        try {
//            bookingArrayList.add(new Booking(sejour4,travelerArrayList.get(1)));
//        } catch (instantiationBookingException e) {
//            e.printStackTrace();
//        }
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
        jMenuItemClose.addActionListener(
                new ActionListener(){
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
        jMenuItemDisplayReservation.addActionListener(new ViewDisplayReservationListener());
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
    public void displayBooking(){
        /**
         * displays bookings in the panel
         */

 /*
            private JPanel container = new JPanel();
            private JRadioButton jr1 = new JRadioButton("Radio 1");
            private JRadioButton jr2 = new JRadioButton("Radio 2");
            private ButtonGroup bg = new ButtonGroup();

        public FenetreCFBoutonsRadio(){
            Uti.info("FenetreCFBoutonsRadio","FenetreCFBoutonsRadio","");
            this.setSize(300, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            container.setBackground(Color.white);
            container.setLayout(new BorderLayout());
            JPanel top = new JPanel();
            jr1.addActionListener(new StateListener());
            jr2.addActionListener(new StateListener());
            // ajout des boutons au groupe et dans le top
            bg.add(jr1);
            bg.add(jr2);
            top.add(jr1);
            top.add(jr2);
            container.add(top, BorderLayout.NORTH);
            this.setContentPane(container);
            this.setVisible(true);
        }

        class StateListener implements ActionListener{
            public void actionPerformed(ActionEvent e) {
               // System.out.println("source : " + ((JRadioButton)e.getSource()).getText() + " - état : " + ((JRadioButton)e.getSource()).isSelected());
                System.out.println("source : " + jr1.getText() + " - état : " + jr1.isSelected());
                System.out.println("source : " + jr2.getText() + " - état : " + jr2.isSelected());
            }
        }
*/
//        private   JPanel jPanelTop = new JPanel();
//
//        private    ButtonGroup bg = new ButtonGroup();
//        private      JLabel jLabelReservationStatus = new JLabel("Afficher la réservation?");
//        private   JRadioButton jRadioButtonYes = new JRadioButton("oui");
//  private      JRadioButton jRadioButtonNo = new JRadioButton("non");

        jPanel = new JPanel();
        jScrollPane = new JScrollPane(jPanel);
        for (int i = 0 ; i < bookingArrayList.size(); i++) {
            JPanel jPanelSon = new JPanel();
            JTextPane jTextPane = new JTextPane();
            jTextPane.setText(bookingArrayList.get(i).stringDisplay());
            jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            jPanelSon.add(jTextPane ); // todo display reservation
            jPanelSon.setBackground(Color.gray);
            jTextPane.setBackground(Color.white);
            jTextPane.setPreferredSize(new Dimension(580, 180));
            jPanel.add(jPanelSon);
            if(bookingArrayList.get(i).isValidated()){
                jTextPane.setBackground(Color.MAGENTA);
            }
        }
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        this.setContentPane(jScrollPane);
        setVisible(true);
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
    class ViewDisplayReservationListener implements ActionListener {
        /**
         * creates and opens the window to add a stay
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Uti.info("ViewDisplayReservationListener","actionPerformed()","");
            if (bookingArrayList == null)
                Uti.mess("liste de réservation nulle.");
//            viewBookingDisplay = new ViewBookingDisplay(bookingArrayList);
            displayBooking();
        }
    }
}
// todo vue création réservation
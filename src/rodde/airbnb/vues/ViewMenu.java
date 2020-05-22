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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class ViewMenu extends JFrame {


    public JPanel jPanel;
    public JMenuBar jMenuBar;
    public JMenu jMenuAdd ;
    public JMenu jMenuDisplay ;
    public JMenuItem jMenuItemClose ;
    public JMenuItem jMenuItemDisplayTraveler;
    public JMenuItem jMenuItemDisplayHost;
    public JMenuItem jMenuItemDisplayHousing;
    public JMenuItem jMenuItemDisplayBooking;
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
    public ArrayList<Traveler> travelerArrayList;
    public ArrayList<Booking> bookingArrayList;
    public ArrayList<Host> hostArrayList ;
    public ArrayList<Housing> housingArrayList;
    public ArrayList<ItemBooking> itemsBookingArrayList ;
    public ArrayList<ItemTraveler> itemsTravelerArrayList ;
    //    public ArrayList<ItemHost> itemsHostArrayList ;
//    public ArrayList<ItemHousing> itemsHousingArrayList ;
    public Persistence persistence = new Persistence();
    public  ItemBooking currentItemBooking;
    public  ItemTraveler currentItemTraveler;
    //    public  ItemHost currentItemHost;
//    public  ItemHousing currentItemHousing;
//    public  ItemHost currentItemHost;
    public ItemBooking getCurrentItemBooking() {
        return currentItemBooking;
    }
    public ItemTraveler getCurrentItemTraveler() {
        return currentItemTraveler;
    }
//    public ItemHost getCurrentItemHost() {
//        return currentItemHost;
//    }
//    public ItemHousing getCurrentItemHousing() {
//        return currentItemHousing;
//    }

//    public void setCurrentItemBooking(ItemBooking currentItemBooking) {
//        this.currentItemBooking = currentItemBooking;
//    }


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
        if(travelerArrayList == null)
            travelerArrayList = new ArrayList<Traveler>();
        if(hostArrayList== null)
            hostArrayList = new ArrayList<Host>();
        if(housingArrayList== null)
            housingArrayList = new ArrayList<Housing>();
        if(bookingArrayList== null)
            bookingArrayList  = new ArrayList<Booking>();
        if(itemsTravelerArrayList== null)
            itemsTravelerArrayList  = new ArrayList<ItemTraveler>();
//        if(itemsHostArrayList== null)
//            itemsHostArrayList  = new ArrayList<ItemHost>();
//        if(itemsHousingArrayList== null)
//            itemsHousingArrayList  = new ArrayList<ItemHousing>();
        if(itemsBookingArrayList== null)
            itemsBookingArrayList  = new ArrayList<ItemBooking>();
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
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("AirBnB");
        setResizable(false);
        setSize(600,400);
        System.out.println(this.getX()+" "+this.getY());
        setLocationRelativeTo(null);
        persistence.createNewRealFile();
        // persistence.load booking
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
        LocalDate dateArrivee1 = LocalDate.of(2021, 1, 18);// date future
        LocalDate dateArrivee2 = LocalDate.of(2021, 11, 18);
        LocalDate dateArrivee3 = LocalDate.of(2021, 12, 18);
        LocalDate dateArrivee4 = LocalDate.of(2021, 05, 18);
        int dureeSejour1 = 9;
        int dureeSejour2 = 5;
        int dureeSejour3 = 3;
        int dureeSejour4 = 12;
        Stay sejour1 = null;
        Stay sejour2 = null;
        Stay sejour3 = null;
        Stay sejour4 = null;
        if (dureeSejour1 < 6) {
            sejour1 = new ShortStay(dateArrivee1, dureeSejour1, housingArrayList.get(0), 2);
        } else {
            sejour1 = new LongStay(dateArrivee1, dureeSejour1, housingArrayList.get(0), 2);
        }
        if (dureeSejour2 < 6) {

            sejour2 = new ShortStay(dateArrivee2, dureeSejour2, housingArrayList.get(2), 1);
        } else {

            sejour2 = new LongStay(dateArrivee2, dureeSejour2, housingArrayList.get(2), 1);
        }
        if (dureeSejour3 < 6) {
            sejour3 = new ShortStay(dateArrivee3, dureeSejour3,housingArrayList.get(3) , 5);
        } else {
            sejour3 = new LongStay(dateArrivee3, dureeSejour3, housingArrayList.get(3), 5);
        }
        if (dureeSejour4 < 6) {
            sejour4= new ShortStay(dateArrivee4, dureeSejour4,housingArrayList.get(1) , 9);
        } else {
            sejour4 = new LongStay(dateArrivee4, dureeSejour4, housingArrayList.get(1), 9);
        }
// conversion en sejour du séjour court ou long pour que la réservation accepte les deux types enfants
        sejour1 = (Stay) sejour1;
        sejour2 = (Stay) sejour2;
        sejour3 = (Stay) sejour3;
        sejour4 = (Stay) sejour4;
        try {
            bookingArrayList.add(new Booking(sejour1, travelerArrayList.get(0)));

        } catch (instantiationBookingException e) {
            e.printStackTrace();
        }
        try {
            bookingArrayList.add(new Booking(sejour2, travelerArrayList.get(2)));
            bookingArrayList.get(1).setValidated(true);
        } catch (instantiationBookingException e) {
            e.printStackTrace();
        }
        try {
            bookingArrayList.add(new Booking(sejour3, travelerArrayList.get(3)));
            bookingArrayList.get(2).setValidated(true);
        } catch (instantiationBookingException e) {
            e.printStackTrace();
        }
        try {
            bookingArrayList.add(new Booking(sejour4, travelerArrayList.get(1)));
        } catch (instantiationBookingException e) {
            e.printStackTrace();
        }
    }
    public void initMenu(){
        /**
         * create the menu bar with all JMenu and JMenuItem with their specific action
         */
        Uti.info("ViewMenu","initMenu","");
        jMenuBar = new JMenuBar();
        jMenuAdd = new JMenu("Ajouter");
        jMenuDisplay = new JMenu("Afficher");
        jMenuItemDisplayTraveler = new JMenuItem("Afficher les voyageurs");
        jMenuItemDisplayHost = new JMenuItem("Afficher les hôtes");
        jMenuItemDisplayHousing = new JMenuItem("Afficher les logements");
        jMenuItemDisplayBooking = new JMenuItem("Afficher les réservations");
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
                        Uti.info("ViewMenu", "initMenu","");
                        //persistence save

                        persistence.saveBookings();
                        System.exit(0);
                    }
                }
        );
        jMenuAddHost.addActionListener(new ViewCreationHostListener());
        jMenuAddHouse.addActionListener(new ViewCreationHouseListener());
        jMenuAddAppartment.addActionListener(new ViewCreationAppartmentListener());
        jMenuAddTraveler.addActionListener(new ViewCreationTravelersListener());
        jMenuAddStay.addActionListener(new ViewCreationStayListener());
        jMenuItemDisplayTraveler.addActionListener(new ViewDisplayTravelerListener());
//        jMenuItemDisplayHost.addActionListener(new ViewDisplayHostListener());
//        jMenuItemDisplayHousing.addActionListener(new ViewDisplayHousingListener());
        jMenuItemDisplayBooking.addActionListener(new ViewDisplayBookingListener());
        jMenuAdd.add(jMenuAddHost);
        jMenuAdd.add(jMenuAddHouse);
        jMenuAdd.add(jMenuAddAppartment);
        jMenuAdd.add(jMenuAddTraveler);
        jMenuAdd.add(jMenuAddStay);
        jMenuAdd.add(jMenuAdd);
        jMenuDisplay.add(jMenuItemDisplayTraveler);
        jMenuDisplay.add(jMenuItemDisplayHost);
        jMenuDisplay.add(jMenuItemDisplayHousing);
        jMenuDisplay.add(jMenuItemDisplayBooking);
        jMenuBar.add(jMenuAdd);
        jMenuBar.add(jMenuDisplay);
        jMenuBar.add(jMenuItemClose);
        setJMenuBar(jMenuBar);
    }
    public void displayTraveler(){
        /**
         * displays travelers in the panel
         */
        jPanel = new JPanel();
        jPanel.setBackground(Color.blue);
        jScrollPane = new JScrollPane(jPanel);
        itemsTravelerArrayList.removeAll(itemsTravelerArrayList);
        for (int i = 0; i < travelerArrayList.size(); i++) {
            currentItemTraveler = new ItemTraveler(travelerArrayList.get(i),this);
            itemsTravelerArrayList.add(currentItemTraveler);
            Uti.mess("Longueur liste itemTravelers : "+ itemsTravelerArrayList.size());
            currentItemTraveler.jPanelSon = new JPanel();
            currentItemTraveler.jTextPane = new JTextPane();
            currentItemTraveler.jPanelCommand = new JPanel();
            currentItemTraveler.organizeJPanelSon();
            jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            currentItemTraveler.jTextPane.setBackground(Color.white);
            currentItemTraveler.jCheckBoxDelete.setVisible(true);
            currentItemTraveler.jTextPane.setText(currentItemTraveler.traveler.getId()+" "+ currentItemTraveler.traveler.stringDisplay());
            currentItemTraveler.jPanelSon.add(currentItemTraveler.jTextPane );
            currentItemTraveler.jTextPane.setPreferredSize(new Dimension(480, 5));
            jPanel.add(currentItemTraveler.jPanelSon);
        }
//        currentItemTraveler = itemsTravelerArrayList.get(0);
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        this.setContentPane(jScrollPane);
        setVisible(true);

    }
    //    public void displayBooking(){
//        /**
//         * displays bookings in the panel
//         */
//
//
//        jPanel = new JPanel();
//        jPanel.setBackground(Color.blue);
//        jScrollPane = new JScrollPane(jPanel);
//        itemsBookingArrayList.removeAll(itemsBookingArrayList);
//
//        for (int i = 0 ; i < bookingArrayList.size(); i++) {
//            currentItemBooking = new ItemBooking(bookingArrayList.get(i),this);
//            itemsBookingArrayList.add(currentItemBooking);
//            Uti.mess("Longueur liste itemBooking : "+ itemsBookingArrayList.size());
//            currentItemBooking.jPanelSon = new JPanel();
//            currentItemBooking.jTextPane = new JTextPane();
//            currentItemBooking.jPanelCommand = new JPanel();
//            currentItemBooking.organizeJPanelSon();
//            jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//            jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//            if(bookingArrayList.get(i).isValidated()){
//                currentItemBooking.jTextPane.setBackground(Color.green);
//                currentItemBooking.jCheckBoxConfirm.setSelected(true);
//                currentItemBooking.jCheckBoxDelete.setVisible(false);
////                currentItemBooking.booking.editBookingState();
//            }
//            else
//            {
//                currentItemBooking.jTextPane.setBackground(Color.red);
//                currentItemBooking.jCheckBoxConfirm.setSelected(false);
//                currentItemBooking.jCheckBoxDelete.setVisible(true);
////                currentItemBooking.booking.editBookingState();
//            }
//            currentItemBooking.jTextPane.setText(currentItemBooking.booking.stringDisplay());
//            currentItemBooking.jPanelSon.add(currentItemBooking.jTextPane ); // todo display reservation
//            currentItemBooking.jTextPane.setPreferredSize(new Dimension(480, 180));
//            jPanel.add(currentItemBooking.jPanelSon);
//        }
////        currentItemBooking = itemsBookingArrayList.get(0);
//        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
//        this.setContentPane(jScrollPane);
//        setVisible(true);
//
//    }
//    public void displayBooking(){
//        /**
//         * displays bookings in the panel
//         */
//
//
//        jPanel = new JPanel();
//        jPanel.setBackground(Color.blue);
//        jScrollPane = new JScrollPane(jPanel);
//        itemsBookingArrayList.removeAll(itemsBookingArrayList);
//
//        for (int i = 0 ; i < bookingArrayList.size(); i++) {
//            currentItemBooking = new ItemBooking(bookingArrayList.get(i),this);
//            itemsBookingArrayList.add(currentItemBooking);
//            Uti.mess("Longueur liste itemBooking : "+ itemsBookingArrayList.size());
//            currentItemBooking.jPanelSon = new JPanel();
//            currentItemBooking.jTextPane = new JTextPane();
//            currentItemBooking.jPanelCommand = new JPanel();
//            currentItemBooking.organizeJPanelSon();
//            jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//            jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//            if(bookingArrayList.get(i).isValidated()){
//                currentItemBooking.jTextPane.setBackground(Color.green);
//                currentItemBooking.jCheckBoxConfirm.setSelected(true);
//                currentItemBooking.jCheckBoxDelete.setVisible(false);
////                currentItemBooking.booking.editBookingState();
//            }
//            else
//            {
//                currentItemBooking.jTextPane.setBackground(Color.red);
//                currentItemBooking.jCheckBoxConfirm.setSelected(false);
//                currentItemBooking.jCheckBoxDelete.setVisible(true);
////                currentItemBooking.booking.editBookingState();
//            }
//            currentItemBooking.jTextPane.setText(currentItemBooking.booking.stringDisplay());
//            currentItemBooking.jPanelSon.add(currentItemBooking.jTextPane ); // todo display reservation
//            currentItemBooking.jTextPane.setPreferredSize(new Dimension(480, 180));
//            jPanel.add(currentItemBooking.jPanelSon);
//        }
////        currentItemBooking = itemsBookingArrayList.get(0);
//        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
//        this.setContentPane(jScrollPane);
//        setVisible(true);
//
//    }
    public void displayBooking(){
        /**
         * displays bookings in the panel
         */


        jPanel = new JPanel();
        jPanel.setBackground(Color.blue);
        jScrollPane = new JScrollPane(jPanel);
        itemsBookingArrayList.removeAll(itemsBookingArrayList);

        for (int i = 0 ; i < bookingArrayList.size(); i++) {
            currentItemBooking = new ItemBooking(bookingArrayList.get(i),this);
            itemsBookingArrayList.add(currentItemBooking);
            Uti.mess("Longueur liste itemBooking : "+ itemsBookingArrayList.size());
            currentItemBooking.jPanelSon = new JPanel();
            currentItemBooking.jTextPane = new JTextPane();
            currentItemBooking.jPanelCommand = new JPanel();
            currentItemBooking.organizeJPanelSon();
            jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            if(bookingArrayList.get(i).isValidated()){
                currentItemBooking.jTextPane.setBackground(Color.green);
                currentItemBooking.jCheckBoxConfirm.setSelected(true);
                currentItemBooking.jCheckBoxDelete.setVisible(false);
            }
            else
            {
                currentItemBooking.jTextPane.setBackground(Color.red);
                currentItemBooking.jCheckBoxConfirm.setSelected(false);
                currentItemBooking.jCheckBoxDelete.setVisible(true);
            }
            currentItemBooking.jTextPane.setText(currentItemBooking.booking.stringDisplay());
            currentItemBooking.jPanelSon.add(currentItemBooking.jTextPane ); // todo display reservation
            currentItemBooking.jTextPane.setPreferredSize(new Dimension(480, 180));
            jPanel.add(currentItemBooking.jPanelSon);
        }
//        currentItemBooking = itemsBookingArrayList.get(0);
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
    class ViewDisplayTravelerListener implements ActionListener {
        /**
         * creates and opens the window to see the travelers
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Uti.info("ViewDisplayTravelerListener","actionPerformed()","");
            if (travelerArrayList == null)
                Uti.mess("liste de Voyageurs nulle.");
            displayTraveler();
        }
    }
    //    class ViewDisplayHostListener implements ActionListener {
//        /**
//         * creates and opens the window to see the hosts
//         */
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Uti.info("ViewDisplayHostListener","actionPerformed()","");
//            if (hostArrayList == null)
//                Uti.mess("liste d'hôtes nulle.");
//            displayHost();
//        }
//    }
//    class ViewDisplayHousingListener implements ActionListener {
//        /**
//         * creates and opens the window to see the Housing
//         */
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Uti.info("ViewDisplayHousingListener","actionPerformed()","");
//            if (housingArrayList == null)
//                Uti.mess("liste de logements nulle.");
//            displayHousing();
//        }
//    }
    class ViewDisplayBookingListener implements ActionListener {
        /**
         * creates and opens the window to see the bookings
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Uti.info("ViewDisplayBookingListener","actionPerformed()","");
            if (bookingArrayList == null)
                Uti.mess("liste de réservation nulle.");
            displayBooking();
        }
    }
    public class Persistence{
        //        public File parentFile = new File("C:\\Users\\demon\\IdeaProjects\\AirBnB\\miscelleanous\\");
        public File parentFile = new File("miscelleanous/");
        String fileName ="bookings.txt";

        public void createNewRealFile(){
            /**
             creates a new file if the file doesn't exist in the path.
             the path is composed of rootProject and the additionalPath.
             */

            Uti.info("Persistence","createNewRealFile","");
            String s="";
            try {
                s = parentFile.getPath()+"/"+fileName;
                File f = new File(s);
                if (f.createNewFile())
                    System.out.println("File created");
                else
                    System.out.println("File already exists");
            } catch (Exception e) {
                System.out.println("Chemin : "+ s );
                System.err.println(e);
            }
        }
        public void saveBookings(){
            Uti.info("Persistence","saveBookings","");
            try {
                FileWriter fw = new FileWriter(parentFile.getPath()+"/"+fileName);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.print("Réservations");
                for(int i =0; i<bookingArrayList.size();i++){
                    pw.print(bookingArrayList.get(i).stringDisplay());
                }
                pw.print("\nFin du fichier");
                pw.close();
            } catch (Exception e) {
                System.err.println("error");
            }
        }
    }
    public class ItemBooking {
        public JPanel jPanelSon = new JPanel();
        public JPanel jPanelCommand;
        public JTextPane jTextPane ;
        public Booking booking ;
        public JCheckBox jCheckBoxConfirm= new JCheckBox("Réserver");
        public JCheckBox jCheckBoxDelete= new JCheckBox("Supprimer");
        public ViewMenu viewMenu;
        BookingConfirmListener bookingConfirmListener = new BookingConfirmListener();
        BookingDeleteListener bookingDeleteListener = new BookingDeleteListener();

        ItemBooking(Booking booking, ViewMenu viewMenu){
            /**
             connects the booking provides by parameter with the checkBoxs
             and the actions of confirmation and deletion
             */
            this.booking = booking;
            this.viewMenu = viewMenu;
            jCheckBoxConfirm.addActionListener(bookingConfirmListener);
            jCheckBoxDelete.addActionListener(bookingDeleteListener);
        }
        public void updateItemBooking(){
            /**
             * the current itemBooking becomes the currentItemBooking of viewMenu.
             */
            viewMenu.currentItemBooking = this;
        }
        public void organizeJPanelSon(){
            /**
             defines jTextPane's position and te jPanelCommand's
             position in the jPanelSon.
             */
            Uti.info("ItemBooking","public void organizeJPanelSon(){\n","");
            jPanelSon.setLayout(new BorderLayout());
            jPanelSon.add(jTextPane, BorderLayout.WEST);
            jPanelSon.add(jPanelCommand, BorderLayout.EAST);
            positionCheckButton();
        }
        public void positionCheckButton(){
            /**
             * organize the position of jCheckBox in the jPanelCommand
             */
            Uti.info("ItemBooking","positionCheckButton","");
            jPanelCommand.setLayout(new GridLayout(2,1));
            jPanelCommand.add(jCheckBoxConfirm);
            jPanelCommand.add(jCheckBoxDelete);
        }
        class BookingConfirmListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
            /**
             an event creates for validate the confirmation of a specific
             booking or cancell the confirmation.
             the confirmation change the apparence of the graphical item
             and the boolean in the booking. this boolean precises if the
             booking is or not  confirmed. the booking is a property of
             the itemBooking object
             * @param e
             */
                Uti.info("BookingConfirmListener","actionPerformed","");
                Uti.mess("action sur jCheckboxConfirm "+booking.getId()+" "+(booking.isValidated()?"coché":"decoché"));

                updateItemBooking();
                if(!booking.isValidated())
                {
                    System.out.println(booking.getId()+" "+booking.isValidated());
                    booking.setValidated(true);
                    currentItemBooking.booking.editBookingState();
                    currentItemBooking.jTextPane.setText(currentItemBooking.booking.stringDisplay());
                    jTextPane.setBackground(Color.GREEN);
                    currentItemBooking.jCheckBoxDelete.setVisible(false);
                    currentItemBooking.jCheckBoxConfirm.setSelected(true);
                    System.out.println(booking.getId()+" "+booking.isValidated());
                }
                else
                {
                    System.out.println(booking.getId()+" "+booking.isValidated());
                    booking.setValidated(false);
                    currentItemBooking.booking.editBookingState();
                    currentItemBooking.jTextPane.setText(currentItemBooking.booking.stringDisplay());
                    jTextPane.setBackground(Color.red);
                    currentItemBooking.jCheckBoxDelete.setVisible(true);
                    currentItemBooking.jCheckBoxConfirm.setSelected(false);
                    System.out.println(booking.getId()+" "+booking.isValidated());
                }
            }
        }
        class BookingDeleteListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 deletes the booking if it has been asked by selecting
                 checkboxConfirm but only if the checkboxDelete is
                 unselected
                 */
                Uti.info("BookingDeleteListener","actionPerformed","");
                if(currentItemBooking.booking.isValidated()){
//                    jCheckBoxDelete.setVisible(false);
//                    currentItemBooking.jCheckBoxDelete.setVisible(false);
                    System.out.println("impossible supprimer réservation confirmée");
                }
                else {
//                    jCheckBoxDelete.setVisible(true);
//                    currentItemBooking.jCheckBoxDelete.setVisible(false);

//                    updateItemBooking();
                    deleteBooking();
                }
                updateItemBooking();
            }
            public void deleteBooking(){
                /**
                 comparates the booking of the currentItembooking with the bookingArrayList.
                 If the equality is found the booking is delete in the bookingArrayList.
                 the itemBooking at the same position in tne itemBookingArrayList is
                 deleted
                 actualise the currentItemBooking
                 */
                Uti.info("BookingDeleteListener","deleteBooking","");
                updateItemBooking();
                displayListItemBookingAndBooking();
                for(int i = 0; i< bookingArrayList.size(); i++){
                    System.out.println("itemBooking indice : "+i);
                    if( currentItemBooking.booking.equals(bookingArrayList.get(i))){
                        System.out.println(bookingArrayList.size()+" "+bookingArrayList.get(i).getId());
                        Uti.mess("Je supprime la réservation");
                        bookingArrayList.remove(bookingArrayList.get(i));
                        deleteItemBooking(i);
                        System.out.println((currentItemBooking.booking != null)?"réservation courante détruite":"anomalie réservation subsiste");
                        System.out.println(bookingArrayList.size());
//                        currentItemBooking= null;
                        updateItemBooking();
                        displayListItemBookingAndBooking();
                        displayBooking();
                        break;
                    }
                }
            }
            public void deleteItemBooking(int index){
                /**
                 deletes the itembooking in the itemsBookingArrayList() at the position
                 given by the first parameter
                 */
                Uti.info("BookingDeleteListener","deleteItemBooking","");
                System.out.println("indice itemBooking: "+ index);
                Uti.mess("je supprime l'itembooking au même rang de liste");
                itemsBookingArrayList.remove(itemsBookingArrayList.get(index));
//                for(int j=0;j<itemsBookingArrayList.size();j++){
//                    if(currentItemBooking.equals(itemsBookingArrayList.get(j))){
//                        System.out.println(itemsBookingArrayList.size());
//                        itemsBookingArrayList.remove(itemsBookingArrayList.get(j));
//                        System.out.println((currentItemBooking != null)?"élément graphique réservation courante détruit":"anomalie élément graphique réservation subsiste");
//                        System.out.println(itemsBookingArrayList.size());
//                    }
//                }
            }
            public void displayListItemBookingAndBooking() {
                /**
                 checks if the itemsBookingArrayList and the
                 bookingArrayList have the same size and display
                 a message displays for each itemBooking in the
                 ArrayList the ID of the booking of the ItemBooking
                 */
                Uti.info("BookingDeleteListener","displayListItemBookingAndBooking","");
                if (itemsBookingArrayList.size() == bookingArrayList.size()) {
                    System.out.println("égalité taille listes");
                } else
                    System.out.println("inégalité longueur listes");
                System.out.println("itemb "+itemsBookingArrayList.size());
                System.out.println("b "+bookingArrayList.size());
                for (int i = 0 ; i< itemsBookingArrayList.size(); i++){
                    System.out.print("itemB : "+i+" - b : "+bookingArrayList.get(i).getId()+" ");
                }
                System.out.println();
            }
        }
    }
    public class ItemTraveler {
        /**
         an instance of this class represents a graphical item of traveler displayed in a list.
         each item is linked to a traveler
         */
        //todo vérifier pourquoi les fonctions ne sont pas identiques entre itemtraveler et itembooking
        public JPanel jPanelSon = new JPanel();
        public JPanel jPanelCommand;
        public JTextPane jTextPane ;
        public Traveler traveler;
        public JCheckBox jCheckBoxDelete= new JCheckBox("Supprimer");
        public ViewMenu viewMenu;
        TravelerDeleteListener travelerDeleteListener = new TravelerDeleteListener();

        ItemTraveler(rodde.airbnb.utilisateurs.Traveler traveler, ViewMenu viewMenu){
            /**
             connects the traveler provides by parameter with the checkBox
             and the travelerDeleteListener
             */
            this.traveler = traveler;
            this.viewMenu = viewMenu;
            jCheckBoxDelete.addActionListener(travelerDeleteListener);
        }

        public void organizeJPanelSon(){
            /**
             defines jTextPane's position and te jPanelCommand's
             position in the jPanelSon.
             */
            Uti.info("ItemTraveler","public void organizeJPanelSon(){\n","");
            jPanelSon.setLayout(new BorderLayout());
            jPanelSon.add(jTextPane, BorderLayout.WEST);
            jPanelSon.add(jPanelCommand, BorderLayout.EAST);
            positionCheckButton();
        }
        public void positionCheckButton(){
            /**
             * organize the position of jCheckBox in the jPanelCommand
             */
            Uti.info("ItemTraveler","positionCheckButton","");
            jPanelCommand.setLayout(new GridLayout(2,1));
            jPanelCommand.add(jCheckBoxDelete);
        }

        //        class BookingConfirmListener implements ActionListener {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Uti.info("BookingConfirmListener","actionPerformed","");
//                Uti.mess("action sur jCheckboxConfirm "+ traveler.getId()+" "+(traveler.isValidated()?"coché":"decoché"));
//
//                updateItemBooking();
//                if(!traveler.isValidated())
//                {
//                    System.out.println(traveler.getId()+" "+ traveler.isValidated());
//                    traveler.setValidated(true);
//                    currentItemBooking.booking.editBookingState();
//                    currentItemBooking.jTextPane.setText(currentItemBooking.booking.stringDisplay());
//                    jTextPane.setBackground(Color.GREEN);
//                    currentItemBooking.jCheckBoxDelete.setVisible(false);
//                    currentItemBooking.jCheckBoxConfirm.setSelected(true);
//                    System.out.println(traveler.getId()+" "+ traveler.isValidated());
//                }
//                else
//                {
//                    System.out.println(traveler.getId()+" "+ traveler.isValidated());
//                    traveler.setValidated(false);
//                    currentItemBooking.booking.editBookingState();
//                    currentItemBooking.jTextPane.setText(currentItemBooking.booking.stringDisplay());
//                    jTextPane.setBackground(Color.red);
//                    currentItemBooking.jCheckBoxDelete.setVisible(true);
//                    currentItemBooking.jCheckBoxConfirm.setSelected(false);
//                    System.out.println(traveler.getId()+" "+ traveler.isValidated());
//                }
//            }
//        }
        class TravelerDeleteListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 deletes the traveler if it has been asked by selecting
                 checkboxConfirm but only if the checkboxDelete is
                 unselected
                 */
                Uti.info("TravelerDeleteListener","actionPerformed","");

//                    jCheckBoxDelete.setVisible(true);
//                    currentItemTraveler.jCheckBoxDelete.setVisible(false);

//                    updateItemTraveler();
                deleteTraveler();
                updateItemTraveler();
            }

        public void deleteTraveler(){
            /**
             comparates the Traveler of the currentItemTraveler with the TravelerArrayList.
             If the equality is found the Traveler is delete in the TravelerArrayList.
             the itemTraveler at the same position in tne itemTravelerArrayList is
             deleted
             actualise the currentItemTraveler
             */
            Uti.info("TravelerDeleteListener","deleteTraveler","");
            updateItemTraveler();
            displayListItemTravelerAndTraveler();
            for(int i = 0; i< travelerArrayList.size(); i++){
                System.out.println("itemTraveler indice : "+i);
                if( currentItemTraveler.traveler.equals(travelerArrayList.get(i))){
                    System.out.println(travelerArrayList.size()+" "+travelerArrayList.get(i).getId());
                    Uti.mess("Je supprime le voyageur");
                    travelerArrayList.remove(travelerArrayList.get(i));
                    deleteItemTraveler(i);
                    System.out.println((currentItemTraveler.traveler != null)?"Voyageur courant détruit":"anomalie voyageur subsiste");
                    System.out.println(travelerArrayList.size());
//                        currentItemTraveler= null;
                    updateItemTraveler();
                    displayListItemTravelerAndTraveler();
                    displayTraveler();
                    break;
                }
            }
        }
            public void deleteItemTraveler(int index){
                /**
                 deletes the itemTraveler in the itemsTravelerArrayList() at the position
                 given by the first parameter
                 */
                Uti.info("TravelerDeleteListener","deleteItemTraveler","");
                System.out.println("indice itemTraveler: "+ index);
                Uti.mess("je supprime l'itemTraveler au même rang de liste");
                itemsTravelerArrayList.remove(itemsTravelerArrayList.get(index));
//                for(int j=0;j<itemsTravelerArrayList.size();j++){
//                    if(currentItemTraveler.equals(itemsTravelerArrayList.get(j))){
//                        System.out.println(itemsTravelerArrayList.size());
//                        itemsTravelerArrayList.remove(itemsTravelerArrayList.get(j));
//                        System.out.println((currentItemTraveler != null)?"élément graphique voyageur courant détruit":"anomalie élément graphique voyageur subsiste");
//                        System.out.println(itemsTravelerArrayList.size());
//                    }
//                }
            }
            public void displayListItemTravelerAndTraveler() {
                /**
                 checks if the itemsTravelerArrayList and the
                 TravelerArrayList have the same size and display
                 a message displays for each itemTraveler in the
                 ArrayList the ID of the Traveler of the ItemTraveler
                 */
                Uti.info("TravelerDeleteListener","displayListItemTravelerAndTraveler","");
                if (itemsTravelerArrayList.size() == bookingArrayList.size()) {
                    System.out.println("égalité taille listes");
                } else
                    System.out.println("inégalité longueur listes");
                System.out.println("itemb "+itemsTravelerArrayList.size());
                System.out.println("b "+ travelerArrayList.size());
                for (int i = 0 ; i< itemsTravelerArrayList.size(); i++){
                    System.out.print("itemB : "+i+" - b : "+ travelerArrayList.get(i).getId()+" ");
                }
                System.out.println();
            }
        }
        public void updateItemTraveler(){
            /**
             * the current itemTraveler becomes the currentItemTraveler of viewMenu.
             */
            viewMenu.currentItemTraveler = this;
        }

    }

//    public class ItemHost {
//        public JPanel jPanelSon = new JPanel();
//        public JPanel jPanelCommand;
//        public JTextPane jTextPane ;
//        public Host host ;
//        public JCheckBox jCheckBoxConfirm= new JCheckBox("Réserver");
//        public JCheckBox jCheckBoxDelete= new JCheckBox("Supprimer");
//        public ViewMenu viewMenu;
////        BookingConfirmListener bookingConfirmListener = new BookingConfirmListener();
//        HostDeleteListener hostDeleteListener = new BookingDeleteListener();
//
//        ItemHost(Host host, ViewMenu viewMenu){
//            this.host = host;
//            this.viewMenu = viewMenu;
////            jCheckBoxConfirm.addActionListener(bookingConfirmListener);
//            jCheckBoxDelete.addActionListener(hostDeleteListener);
//        }
//        public void updateItemHost(){
//            /**
//             * the current ItemHost becomes the currentItemHost of viewMenu.
//             */
//            viewMenu.currentItemHost = this;
//        }
//        public void organizeJPanelSon(){
//            Uti.info("ItemHost","public void organizeJPanelSon(){\n","");
//            jPanelSon.setLayout(new BorderLayout());
//            jPanelSon.add(jTextPane, BorderLayout.WEST);
//            jPanelSon.add(jPanelCommand, BorderLayout.EAST);
//            positionCheckButton();
//        }
//        public void positionCheckButton(){
//            /**
//             * organize the position of jCheckBox
//             */
//            Uti.info("ItemHost","positionCheckButton","");
//            jPanelCommand.setLayout(new GridLayout(2,1));
//            jPanelCommand.add(jCheckBoxConfirm);
//            jPanelCommand.add(jCheckBoxDelete);
//        }
//
////        class BookingConfirmListener implements ActionListener {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                Uti.info("BookingConfirmListener","actionPerformed","");
////                Uti.mess("action sur jCheckboxConfirm "+host.getId()+" "+(host.isValidated()?"coché":"decoché"));
////
////                updateItemHost();
////                if(!host.isValidated())
////                {
////                    System.out.println(host.getId()+" "+host.isValidated());
////                    host.setValidated(true);
////                    currentItemBooking.booking.editBookingState();
////                    currentItemBooking.jTextPane.setText(currentItemBooking.booking.stringDisplay());
////                    jTextPane.setBackground(Color.GREEN);
////                    currentItemBooking.jCheckBoxDelete.setVisible(false);
////                    currentItemBooking.jCheckBoxConfirm.setSelected(true);
////                    System.out.println(host.getId()+" "+host.isValidated());
////                }
////                else
////                {
////                    System.out.println(host.getId()+" "+host.isValidated());
////                    host.setValidated(false);
////                    currentItemBooking.booking.editBookingState();
////                    currentItemBooking.jTextPane.setText(currentItemBooking.booking.stringDisplay());
////                    jTextPane.setBackground(Color.red);
////                    currentItemBooking.jCheckBoxDelete.setVisible(true);
////                    currentItemBooking.jCheckBoxConfirm.setSelected(false);
////                    System.out.println(host.getId()+" "+host.isValidated());
////                }
////            }
////        }
//        class HostDeleteListener implements ActionListener {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                /**
//                 delete the host in the list
//                 */
//                Uti.info("HostDeleteListener","actionPerformed","");
//                if(currentItemHost.host.isValidated()){
////                    jCheckBoxDelete.setVisible(false);
////                    currentItemBooking.jCheckBoxDelete.setVisible(false);
//                    System.out.println("impossible supprimer réservation confirmée");
//                }
//                else {
////                    jCheckBoxDelete.setVisible(true);
////                    currentItemBooking.jCheckBoxDelete.setVisible(false);
//
////                    updateItemBooking();
//                    deleteHost();
//                }
//                updateItemHost();
//            }
//            public void deleteHost(){
//                /**
//                 comparates the booking of the currentItembooking with the bookingArrayList.
//                 If the equality is found the booking is delete in the bookingArrayList.
//                 the itemBooking at the same position in tne itemBookingArrayList is
//                 deleted
//                 actualise the currentItemBooking
//                 */
//                Uti.info("BookingDeleteListener","deleteBooking","");
//                updateItemHost();
//                displayListItemBookingAndBooking();
//                for(int i = 0; i< bookingArrayList.size(); i++){
//                    System.out.println("itemBooking indice : "+i);
//                    if( currentItemBooking.booking.equals(bookingArrayList.get(i))){
//                        System.out.println(bookingArrayList.size()+" "+bookingArrayList.get(i).getId());
//                        Uti.mess("Je supprime la réservation");
//                        bookingArrayList.remove(bookingArrayList.get(i));
//                        deleteItemHost(i);
//                        System.out.println((currentItemBooking.booking != null)?"réservation courante détruite":"anomalie réservation subsiste");
//                        System.out.println(bookingArrayList.size());
////                        currentItemBooking= null;
//                        updateItemHost();
//                        displayListItemBookingAndBooking();
//                        displayBooking();
//                        break;
//                    }
//                }
//            }
//            public void deleteItemHost(int index){
//                /**
//                 deletes the itemHost in the itemsBookingArrayList() at the position
//                 given by the first parameter
//                 */
//                Uti.info("HostDeleteListener","deleteItemHost","");
//                System.out.println("indice itemHost: "+ index);
//                Uti.mess("je supprime l'itemHost au même rang de liste");
//                itemsHostArrayList.remove(itemsHostArrayList.get(index));
////                for(int j=0;j<itemsBookingArrayList.size();j++){
////                    if(currentItemHost.equals(itemsHostArrayList.get(j))){
////                        System.out.println(itemsHostArrayList.size());
////                        itemsHostArrayList.remove(itemsHostArrayList.get(j));
////                        System.out.println((currentItemHost != null)?"élément graphique hôte courante détruit":"anomalie élément graphique réservation subsiste");
////                        System.out.println(itemsHostArrayList.size());
////                    }
////                }
//            }
//            public void displayListItemHostAndBooking() {
//                /**
//                 checks if the itemsHostArrayList and the
//                 HostArrayList have the same size and display
//                 a message displays for each itemHost in the
//                 ArrayList the ID of the Host of the ItemHost
//                 */
//                Uti.info("HostDeleteListener","displayListItemHostAndHost","");
//                if (itemsHostArrayList.size() == HostArrayList.size()) {
//                    System.out.println("égalité taille listes");
//                } else
//                    System.out.println("inégalité longueur listes");
//                System.out.println("itemH "+itemsHostBookingArrayList.size());
//                System.out.println("h "+HostArrayList.size());
//                for (int i = 0 ; i< itemsHostArrayList.size(); i++){
//                    System.out.print("itemH : "+i+" - h : "+HostArrayList.get(i).getId()+" ");
//                }
//                System.out.println();
//            }
//        }
//    }
}
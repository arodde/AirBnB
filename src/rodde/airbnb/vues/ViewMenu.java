package rodde.airbnb.vues;

import com.sun.javaws.IconUtil;
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
    public ArrayList<Traveler> travelerArrayList;
    public ArrayList<Host> hostArrayList ;
    public ArrayList<Housing> housingArrayList;
    public ArrayList<Booking> bookingArrayList;
    public ArrayList<ItemBooking> itemsBookingArrayList ;

    public  ItemBooking currentItemBooking;
    public ItemBooking getCurrentItemBooking() {
        return currentItemBooking;
    }

    public void setCurrentItemBooking(ItemBooking currentItemBooking) {
        this.currentItemBooking = currentItemBooking;
    }


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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AirBnB");
        setResizable(false);
        setSize(600,400);
        System.out.println(this.getX()+" "+this.getY());
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
            bookingArrayList.add(new Booking(sejour1,travelerArrayList.get(0)));

        } catch (instantiationBookingException e) {
            e.printStackTrace();
        }
        try {
            bookingArrayList.add(new Booking(sejour2,travelerArrayList.get(2)));
            bookingArrayList.get(1).setValidated(true);
        } catch (instantiationBookingException e) {
            e.printStackTrace();
        }
        try {
            bookingArrayList.add(new Booking(sejour3,travelerArrayList.get(3)));
            bookingArrayList.get(2).setValidated(true);
        } catch (instantiationBookingException e) {
            e.printStackTrace();
        }
        try {
            bookingArrayList.add(new Booking(sejour4,travelerArrayList.get(1)));
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
//      /*  private */  JPanel jPanelTop = new JPanel();
//
//        private    ButtonGroup bg = new ButtonGroup();
//        private      JLabel jLabelReservationStatus = new JLabel("Afficher la réservation?");
//     /*   private */  JRadioButton jRadioButtonBooked = new JRadioButton("Réservé");
//  private      JRadioButton jRadioButtonNo = new JRadioButton("non");

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
            currentItemBooking.jTextPane.setText(currentItemBooking.booking.stringDisplay());
            currentItemBooking.jPanelSon.add(currentItemBooking.jTextPane ); // todo display reservation
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

        ItemBooking(Booking booking,ViewMenu viewMenu){
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

                updateItemBooking();
                if(!booking.isValidated())
                {
                    System.out.println(booking.getId()+" "+booking.isValidated());
                    booking.setValidated(true);
                    jTextPane.setBackground(Color.GREEN);
                    currentItemBooking.jCheckBoxDelete.setVisible(false);
                    currentItemBooking.jCheckBoxConfirm.setSelected(true);
                    System.out.println(booking.getId()+" "+booking.isValidated());
                }
                else
                {
                    System.out.println(booking.getId()+" "+booking.isValidated());
                    booking.setValidated(false);
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
}
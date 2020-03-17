package rodde.airbnb.vues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueMenu extends JFrame {
    public JPanel jPanel;
    public JMenuBar jMenuBar;
    public JMenu jMenuAdd ;
    public JMenu jMenuDisplay ;
    public JMenuItem jMenuItemClose ;
    public JMenuItem jMenuItemDisplayReservation ;
    public JMenuItem jMenuItemAddHost ;
    public JMenuItem jMenuItemAddTraveler ;
    public JMenuItem jMenuItemAddHouse ;
    public JMenuItem jMenuItemAddAppartement ;
    public JMenuItem jMenuItemAddStay ;


    public VueMenu(){
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
        jMenuBar = new JMenuBar();
        jMenuAdd = new JMenu("Ajouter");
        jMenuDisplay = new JMenu("Afficher");
        jMenuItemDisplayReservation = new JMenuItem("Afficher les réservations");
        jMenuItemAddHost = new JMenuItem("Ajouter un hôte");
        jMenuItemAddTraveler = new JMenuItem("Ajouter un hôte");
        jMenuItemAddHost = new JMenuItem("Ajouter un hôte");
        jMenuItemAddTraveler = new JMenuItem("Ajouter un voyageur");
        jMenuItemAddHouse = new JMenuItem("Ajouter une maison");
        jMenuItemAddAppartement = new JMenuItem("Ajouter un appartement");
        jMenuItemAddStay = new JMenuItem("Ajouter un séjour");
        jMenuItemClose = new JMenuItem("Fermer");

        jMenuItemClose.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        

        jMenuAdd.add(jMenuItemAddHost);
        jMenuAdd.add(jMenuItemAddHouse);
        jMenuAdd.add(jMenuItemAddAppartement);
        jMenuAdd.add(jMenuItemAddTraveler);
        jMenuAdd.add(jMenuItemAddStay);
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
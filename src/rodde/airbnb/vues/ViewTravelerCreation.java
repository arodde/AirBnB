package rodde.airbnb.vues;

import rodde.airbnb.utilisateurs.Traveler;

import javax.swing.*;
import java.awt.event.ActionEvent;
public class ViewTravellerCreation extends JFrame {

    private JLabel jLabelSurname;
    private JTextField jTextFieldSurname;
    private JButton jButtonValidate;
    private JLabel jLabelFirstName;
    private JTextField jTextFieldFirstName;
    private JLabel jLabelAge;
    private JTextField jTextFieldAge;

    public ViewTravellerCreation(){
        // ajout de caractéristiques à la fenêtre
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AirBnB");
        setName("AirBnBAjoutVoyageur");
        setResizable(false);
        setBounds(600,300,300,250);
        // rend la fenêtre visible
        setVisible(true);
        // instanciation des propriétés de la classe
        jLabelSurname = new JLabel("Nom :");
        jTextFieldSurname = new JTextField();
        jLabelFirstName = new JLabel("Prenom :");
        jTextFieldFirstName = new JTextField();
        jLabelAge = new JLabel("Age :");
        jTextFieldAge = new JTextField();
        jButtonValidate = new JButton("Valider");
        // ajout d'un conteneur de vues
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(jLabelSurname);
        panel.add(jTextFieldSurname);
        panel.add(jLabelFirstName);
        panel.add(jTextFieldFirstName);
        panel.add(jLabelAge);
        panel.add(jTextFieldAge);
        panel.add(jButtonValidate);
        // modifie la mise en page de la fenêtre avec le panel
        getContentPane().add(panel);
        // rafraichit la vue de la fenêtre
        setVisible(true);
        // gestion du clic du bouton
        jButtonValidate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Création du voyageur
                Traveler voyageurVue = new Traveler(
                        (String) jTextFieldSurname.getText(),
                        (String) jTextFieldFirstName.getText(),
                        Integer.parseInt(jTextFieldAge.getText())
                );
                voyageurVue.display();
            }
        });
    }

}
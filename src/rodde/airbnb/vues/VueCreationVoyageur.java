package rodde.airbnb.vues;

import rodde.airbnb.utilisateurs.Hote;
import rodde.airbnb.utilisateurs.Voyageur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class VueCreationVoyageur  extends JFrame {

    private JLabel labelNom;
    private JTextField textFieldNom;
    private JButton buttonValider;
    private JLabel labelPrenom;
    private JTextField textFieldPrenom;
    private JLabel labelAge;
    private JTextField textFieldAge;

    public VueCreationVoyageur(){
        // ajout de caractéristique à la fenêtre
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AirBnB");
        setName("AirBnBAjoutVoyageur");
        setResizable(false);
        setBounds(600,300,300,250);
        // rend la fenêtre visible
        setVisible(true);
        // instanciation des propriétés de la classe
        labelNom = new JLabel("Nom :");
        textFieldNom = new JTextField();
        labelPrenom = new JLabel("Prenom :");
        textFieldPrenom = new JTextField();
        labelAge = new JLabel("Age :");
        textFieldAge = new JTextField();
        buttonValider = new JButton("Valider");
        // ajout d'un conteneur de vues
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(labelNom);
        panel.add(textFieldNom);
        panel.add(labelPrenom);
        panel.add(textFieldPrenom);
        panel.add(labelAge);
        panel.add(textFieldAge);
        panel.add(buttonValider);
        // modifie la mise en page de la fenêtre avec le panel
        getContentPane().add(panel);
        // rafraichit la vue de la fenêtre
        setVisible(true);
        // gestion du clic du bouton
        buttonValider.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Création du voyageur
                Voyageur voyageurVue = new Voyageur(
                        (String)textFieldNom.getText(),
                        (String) textFieldPrenom.getText(),
                        Integer.parseInt(textFieldAge.getText())
                );
                voyageurVue.afficher();
            }
        });
    }

}
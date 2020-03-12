package rodde.airbnb.vues;

import rodde.airbnb.utilisateurs.Hote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VueCreationHote extends JFrame {
    private JLabel labelNom;
    private JTextField textFieldNom;
    private JButton buttonValider;
    private JLabel labelPrenom;
    private JTextField textFieldPrenom;
    private JLabel labelAge;
    private JTextField textFieldAge;
    private JLabel labelDelaiReponse;
    private JTextField textFieldDelaiReponse;
    public VueCreationHote(){
        // ajout de caractéristique à la fenêtre
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AirBnB");
        setName("AirBnBAjoutHote");
        setResizable(false);
        setBounds(500,200,300,250);
        // rend la fenêtre visible
        setVisible(true);
        // instanciation des propriétés de la classe
        labelNom = new JLabel("Nom :");
        textFieldNom = new JTextField();
        labelPrenom = new JLabel("Prenom :");
        textFieldPrenom = new JTextField();
        labelAge = new JLabel("Age :");
        textFieldAge = new JTextField();
        labelDelaiReponse = new JLabel("Délai de réponse :");
        textFieldDelaiReponse = new JTextField();
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
        panel.add(labelDelaiReponse);
        panel.add(textFieldDelaiReponse);
        panel.add(buttonValider);
        // modifie la mise en page de la fenêtre avec le panel
        getContentPane().add(panel);
        // rafraichit la vue de la fenêtre
        setVisible(true);
        // gestion du clic du bouton
        buttonValider.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Création de l'hôte
                Hote hoteVue = new Hote(
                        (String)textFieldNom.getText(),
                        (String) textFieldPrenom.getText(),
                        Integer.parseInt(textFieldAge.getText()),
                        Integer.parseInt(textFieldDelaiReponse.getText())
                );
                hoteVue.afficher();
            }
        });
    }

}

package rodde.airbnb.vues;

import rodde.airbnb.utilisateurs.Host;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ViewHostCreation extends JFrame {
    private JLabel jLabelSurname;
    private JTextField jTextFieldSurname;
    private JButton jButtonValidate;
    private JLabel jLabelFirstName;
    private JTextField jTextFieldFirstName;
    private JLabel jLabelAge;
    private JTextField jTextFieldAge;
    private JLabel jLabelResponseTime;
    private JTextField jTextFieldResponseTime;
    public ViewHostCreation(){
        // ajout de caractéristique à la fenêtre
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AirBnB");
        setName("AirBnBAjoutHote");
        setResizable(false);
        setBounds(500,200,300,250);
        // rend la fenêtre visible
        setVisible(true);
        // instanciation des propriétés de la classe
        jLabelSurname = new JLabel("Nom :");
        jTextFieldSurname = new JTextField();
        jLabelFirstName = new JLabel("Prenom :");
        jTextFieldFirstName = new JTextField();
        jLabelAge = new JLabel("Age :");
        jTextFieldAge = new JTextField();
        jLabelResponseTime = new JLabel("Délai de réponse :");
        jTextFieldResponseTime = new JTextField();
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
        panel.add(jLabelResponseTime);
        panel.add(jTextFieldResponseTime);
        panel.add(jButtonValidate);
        // modifie la mise en page de la fenêtre avec le panel
        getContentPane().add(panel);
        // rafraichit la vue de la fenêtre
        setVisible(true);
        // gestion du clic du bouton
        jButtonValidate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Création de l'hôte
                Host hoteVue = new Host(
                        (String) jTextFieldSurname.getText(),
                        (String) jTextFieldFirstName.getText(),
                        Integer.parseInt(jTextFieldAge.getText()),
                        Integer.parseInt(jTextFieldResponseTime.getText())
                );
                hoteVue.display();
            }
        });
    }

}

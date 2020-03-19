package rodde.airbnb.vues;

import rodde.airbnb.utilisateurs.Host;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ViewHouseCreation extends JFrame {
    private JLabel jLabelHost;
    private JTextField jTextFieldHost; // combo
    private JLabel jLabelDailyRate;
    private JTextField jTextFieldDailyRate;
    private JLabel jLabelAddress;
    private JTextField jTextFieldAddress;
    private JLabel jLabelResponseTime;
    private JTextField jTextFieldResponseTime;
    private JButton jButtonValidate;
    public ViewHouseCreation(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AirBnB");
        setName("AirBnBAjoutHote");
        setResizable(false);
        setBounds(500,200,300,250);
        // rend la fenêtre visible
        setVisible(true);
        // instanciation des propriétés de la classe
        jLabelHost = new JLabel("Nom :");
        jTextFieldHost = new JTextField();
        jLabelDailyRate = new JLabel("Prenom :");
        jTextFieldDailyRate = new JTextField();
        jLabelAddress = new JLabel("Age :");
        jTextFieldAddress = new JTextField();
        jLabelResponseTime = new JLabel("Délai de réponse :");
        jTextFieldResponseTime = new JTextField();
        jButtonValidate = new JButton("Valider");
        // ajout d'un conteneur de vues
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(jLabelHost);
        panel.add(jTextFieldHost);
        panel.add(jLabelDailyRate);
        panel.add(jTextFieldDailyRate);
        panel.add(jLabelAddress);
        panel.add(jTextFieldAddress);
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
                        (String) jTextFieldHost.getText(),
                        (String) jTextFieldDailyRate.getText(),
                        Integer.parseInt(jTextFieldAddress.getText()),
                        Integer.parseInt(jTextFieldResponseTime.getText())
                );
                hoteVue.display();
            }
        });
    }

}

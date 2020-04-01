package rodde.airbnb.vues;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewHostCreation extends JFrame {
    public JLabel jLabelSurname;
    public JTextField jTextFieldSurname;
    public JButton jButtonValidate;
    public JButton jButtonFastImput;
    public JLabel jLabelFirstName;
    public JTextField jTextFieldFirstName;
    public JLabel jLabelAge;
    public JTextField jTextFieldAge;
    public JLabel jLabelResponseTime;
    public JTextField jTextFieldResponseTime;

    public ViewHostCreation(ArrayList<Host> hosts){

        // ajout de caractéristique à la fenêtre
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter un hôte");
        setName("AirBnBAjoutHote");
        setResizable(false);

        setBounds(500,200,300,250);
        // rend la fenêtre visible
        setVisible(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        jButtonFastImput = new JButton("saisie rapide");
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
        jButtonValidate.setEnabled(false);
        panel.add(jButtonFastImput);
        // modifie la mise en page de la fenêtre avec le panel
        getContentPane().add(panel);
        // rafraichit la vue de la fenêtre
        setVisible(true);
        // gestion du clic du bouton
        jButtonValidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Uti.info("jButtonValidate","actionPerformed","");
                // Création de l'hôte
                Host currentHost = new Host(
                        jTextFieldSurname.getText(),
                        (String) jTextFieldFirstName.getText(),
                        Integer.parseInt(jTextFieldAge.getText()),
                        Integer.parseInt(jTextFieldResponseTime.getText())
                );
                if( hosts == null)
                        Uti.mess("hosts est null");
                hosts.add(currentHost);
                jButtonValidate.setEnabled(false);
                toRemoveAfter1();
                Uti.mess((hosts.size())+" hôte(s) dans la liste");
            }
            public void toRemoveAfter1(){
                Uti.info("jButtonValidate","toRemoveAfter1","");
                jTextFieldSurname.setEnabled(false);
                jTextFieldFirstName.setEnabled(false);
                jTextFieldAge.setEnabled(false);
                jTextFieldResponseTime.setEnabled(false);
            }
        });
        jButtonFastImput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Uti.info("jButtonFastImput","actionPerformed","a retirer");
                jTextFieldSurname.setText("BUR");
                jTextFieldFirstName.setText("Max");
                jTextFieldAge.setText("51");
                jTextFieldResponseTime.setText("48");
                jButtonValidate.setEnabled(true);
               jButtonFastImput.setEnabled(false);
            }
        });
    }
}

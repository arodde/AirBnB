package rodde.airbnb.vues;

import org.apache.commons.lang3.StringUtils;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewHostCreation extends JFrame {
    public JLabel jLabelSurname;
    public JTextField jTextFieldSurname;
    public JLabel jLabelFirstName;
    public JTextField jTextFieldFirstName;
    public JLabel jLabelAge;
    public JTextField jTextFieldAge;
    public JLabel jLabelResponseTime;
    public JTextField jTextFieldResponseTime;
    public JButton jButtonValidate;
    public JButton jButtonFastInput;// todo remove this line
    public ViewHostCreation(ArrayList<Host> hosts){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter un hôte");
        setName("AirBnBAddHost");
        setResizable(false);

        setBounds(500,200,300,250);
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
//        jButtonFastInput = new JButton("saisie rapide");// todo remove this line
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
//        panel.add(jButtonFastInput);// todo remove this line
        getContentPane().add(panel);
        setVisible(true);
        jButtonValidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Uti.info("jButtonValidate","actionPerformed","");
                boolean correctHost = false;
                Boolean verifications[]= new Boolean[3];
                for(int i = 0; i<verifications.length;i++){
                    verifications[i]=false;
                }
                if(!jTextFieldSurname.getText().isEmpty() &&
                        !jTextFieldFirstName.getText().isEmpty() &&
                        !jTextFieldAge.getText().isEmpty() &&
                        StringUtils.isNumeric(jTextFieldAge.getText()) &&
                        !jTextFieldResponseTime.getText().isEmpty() &&
                        StringUtils.isNumeric(jTextFieldResponseTime.getText())
                ){
                    Host currentHost = new Host(
                            jTextFieldSurname.getText(),
                            (String) jTextFieldFirstName.getText(),
                            Integer.parseInt(jTextFieldAge.getText()),
                            Integer.parseInt(jTextFieldResponseTime.getText())
                    );
                    if( hosts == null)
                        Uti.mess("hosts est null");
                    hosts.add(currentHost);
                    inactiveFieldsViewHosts();
                    jButtonValidate.setEnabled(false);
                } else {
                    checkFieldsHost(correctHost);
                    activeFieldsViewHosts();
                }
//                toRemoveAfter1();// todo remove this line
                Uti.mess((hosts.size())+" hôte(s) dans la liste");
            }

            public Boolean checkFieldsHost(Boolean correctHost){
                Uti.info("jButtonValidate","checkFieldsTraveler","");
                Boolean verifications[]= new Boolean[4];
                for(int i = 0; i<verifications.length;i++){
                    verifications[i]=false;
                }
                if(!jTextFieldSurname.getText().isEmpty()){
                    verifications[0]=true;
                    jTextFieldSurname.setBackground(Color.white);
                } else {
                    jTextFieldSurname.setBackground(Color.red);
                    jTextFieldSurname.setText("");
                }
                if(!jTextFieldFirstName.getText().isEmpty()){
                    verifications[1]=true;
                    jTextFieldFirstName.setBackground(Color.white);
                } else {
                    jTextFieldFirstName.setBackground(Color.red);
                    jTextFieldFirstName.setText("");
                }
                if((!jTextFieldAge.getText().isEmpty() &&
                        StringUtils.isNumeric(jTextFieldAge.getText()) &&
                        Integer.parseInt(jTextFieldAge.getText())>0)){
                    verifications[2]=true;
                    jTextFieldAge.setBackground(Color.white);
                } else {
                    jTextFieldAge.setBackground(Color.red);
                    jTextFieldAge.setText("");
                }
                if((!jTextFieldResponseTime.getText().isEmpty() &&
                        StringUtils.isNumeric(jTextFieldResponseTime.getText()) &&
                        Integer.parseInt(jTextFieldResponseTime.getText())>0)){
                    verifications[2]=true;
                    jTextFieldResponseTime.setBackground(Color.white);
                } else {
                    jTextFieldResponseTime.setBackground(Color.red);
                    jTextFieldResponseTime.setText("");
                }
                for(int i=0; i<(verifications.length);i++){
                    if(verifications[i]==true){
                        correctHost= true;

                        jButtonValidate.setEnabled(true);
                    }
                    else{
                        i=verifications.length;
                        correctHost = false;
//                        jButtonValidate.setEnabled(false);
                    }
                }
                return correctHost;
            }
            public void inactiveFieldsViewHosts(){
                Uti.info("jButtonValidate","inactiveFieldsViewTravelers","");
                jTextFieldSurname.setEnabled(false);
                jTextFieldSurname.setBackground(Color.white);
                jTextFieldFirstName.setEnabled(false);
                jTextFieldFirstName.setBackground(Color.white);
                jTextFieldAge.setEnabled(false);
                jTextFieldAge.setBackground(Color.white);
                jTextFieldResponseTime.setEnabled(false);
                jTextFieldResponseTime.setBackground(Color.white);
            }
            public void activeFieldsViewHosts(){
                Uti.info("jButtonValidate","activeFieldsViewTravelers","");
                jTextFieldSurname.setEnabled(true);
                jTextFieldFirstName.setEnabled(true);
                jTextFieldAge.setEnabled(true);
                jTextFieldResponseTime.setEnabled(true);
            }
            public void toRemoveAfter1() {
                Uti.info("jButtonValidate", "toRemoveAfter1", "");
                if(!jTextFieldSurname.getText().isEmpty() &&
                        !jTextFieldFirstName.getText().isEmpty() &&
                        !jTextFieldAge.getText().isEmpty() &&
                        !jTextFieldResponseTime.getText().isEmpty()){
                    jTextFieldSurname.setEnabled(false);
                    jTextFieldFirstName.setEnabled(false);
                    jTextFieldAge.setEnabled(false);
                    jTextFieldResponseTime.setEnabled(false);
                } else {
                    jButtonValidate.setEnabled(false);
                    jButtonFastInput.setEnabled(true); //todo remove this line
                }
            }
        });
        jButtonFastInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Uti.info("jButtonFastImput","actionPerformed","a retirer");
                jTextFieldSurname.setText("BUR");
                jTextFieldFirstName.setText("Max");
                jTextFieldAge.setText("51");
                jTextFieldResponseTime.setText("48");
                jButtonValidate.setEnabled(true);
                jButtonFastInput.setEnabled(false);
            }
        });
    }
}

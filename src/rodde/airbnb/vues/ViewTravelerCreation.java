package rodde.airbnb.vues;

import org.apache.commons.lang3.StringUtils;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Traveler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewTravelerCreation extends JFrame {

    private JLabel jLabelSurname;
    private JTextField jTextFieldSurname;
    private JLabel jLabelFirstName;
    private JTextField jTextFieldFirstName;
    private JLabel jLabelAge;
    private JTextField jTextFieldAge;
    private JButton jButtonValidate;
//    private JButton jButtonFastImput;// todo remove this line

    public ViewTravelerCreation(ArrayList<Traveler> travelers){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter un voyageur");
        setName("AirBnBAddTraveler");
        setResizable(false);
        setBounds(600,300,300,250);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jLabelSurname = new JLabel("Nom :");
        jTextFieldSurname = new JTextField();
        jLabelFirstName = new JLabel("Prenom :");
        jTextFieldFirstName = new JTextField();
        jLabelAge = new JLabel("Age :");
        jTextFieldAge = new JTextField();
        jButtonValidate = new JButton("Valider");
//        jButtonFastImput = new JButton("saisie rapide");// todo remove this line
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(jLabelSurname);
        panel.add(jTextFieldSurname);
        panel.add(jLabelFirstName);
        panel.add(jTextFieldFirstName);
        panel.add(jLabelAge);
        panel.add(jTextFieldAge);
        panel.add(jButtonValidate);
//        panel.add(jButtonFastImput);// todo remove this line
        getContentPane().add(panel);
        setVisible(true);
        // gestion du clic du bouton
        jButtonValidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Uti.info("jButtonValidate", "actionPerformed()", "");
                boolean correctTraveler = false;
                Boolean verifications[]= new Boolean[3];
                for(int i = 0; i<verifications.length;i++){
                    verifications[i]=false;
                }
                if(!jTextFieldSurname.getText().isEmpty() &&
                        !jTextFieldFirstName.getText().isEmpty() &&
                        !jTextFieldAge.getText().isEmpty() &&
                        StringUtils.isNumeric(jTextFieldAge.getText())){
                    Traveler currentTraveler = new Traveler(
                            jTextFieldSurname.getText(),
                            jTextFieldFirstName.getText(),
                            Integer.parseInt(jTextFieldAge.getText())
                    );

                    if (travelers == null)
                        Uti.mess("travelers est null");
                    travelers.add(currentTraveler);
                    inactiveFieldsViewTravelers();
                    jButtonValidate.setEnabled(false);
                } else {
                    checkFieldsTraveler(correctTraveler);
                    activeFieldsViewTravelers();
                }
//                toRemoveAfter1();// todo remove this line
                Uti.mess((travelers.size())+" voyageur(s) dans la liste.");
            }
            public Boolean checkFieldsTraveler(Boolean correctTraveler){
                Uti.info("jButtonValidate","checkFieldsTraveler","");
                Boolean verifications[]= new Boolean[3];
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
                for(int i=0; i<(verifications.length);i++){
                    if(verifications[i]==true){
                        correctTraveler= true;

                        jButtonValidate.setEnabled(true);
                    }
                    else{
                        i=verifications.length;
                        correctTraveler = false;
//                        jButtonValidate.setEnabled(false);
                    }
                }
                return correctTraveler;
            }
            public void inactiveFieldsViewTravelers(){
                Uti.info("jButtonValidate","inactiveFieldsViewTravelers","");
                jTextFieldSurname.setEnabled(false);
                jTextFieldSurname.setBackground(Color.white);
                jTextFieldFirstName.setEnabled(false);
                jTextFieldFirstName.setBackground(Color.white);
                jTextFieldAge.setEnabled(false);
                jTextFieldAge.setBackground(Color.white);
            }
            public void activeFieldsViewTravelers(){
                Uti.info("jButtonValidate","activeFieldsViewTravelers","");
                jTextFieldSurname.setEnabled(true);
                jTextFieldFirstName.setEnabled(true);
                jTextFieldAge.setEnabled(true);
            }
            public void toRemoveAfter1(){
                Uti.info("jButtonValidate","toRemoveAfter1","");
                if(!jTextFieldSurname.getText().isEmpty() &&
                        !jTextFieldFirstName.getText().isEmpty() &&
                        !jTextFieldAge.getText().isEmpty()){
                    jTextFieldSurname.setEnabled(false);
                    jTextFieldFirstName.setEnabled(false);
                    jTextFieldAge.setEnabled(false);
                }
                else
                {
                    jButtonValidate.setEnabled(false);
//                    jButtonFastImput.setEnabled(true); // todo remove this line
                }

            }
        });
//        jButtonFastImput.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Uti.info("jButtonFastImput","actionPerformed","a retirer");
//                jTextFieldSurname.setText("CHAUVINARDEAU Du MAZELONICAN DE VENDOMOISETTE");
//                jTextFieldFirstName.setText("Hubert-Stanislas-Edmond-Rodrigues-Jacques-Henri");
//                jTextFieldAge.setText("69");
//                jButtonValidate.setEnabled(true);
//            }
//        });
    }
}
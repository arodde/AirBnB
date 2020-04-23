package rodde.airbnb.vues;

;
import org.apache.commons.lang3.StringUtils;
import rodde.airbnb.logements.Housing;
import rodde.airbnb.reservations.Stay;
import rodde.airbnb.util.Uti;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;

//import static com.sun.deploy.util.StringUtils.*;


public class ViewStayCreation extends JFrame {
    public Housing currentHousing;
    public JLabel jLabelArrivalDate;
    public JTextField jTextFieldArrivalDate;
    public JFormattedTextField jFormattedTextFieldArrivalDate;
    public JLabel jLabelTravelersNumber;
    public JTextField jTextFieldTravelersNumber;
    public JLabel jLabelOvernightsNumber;
    public JTextField jTextFieldOvernightsNumber;
    public JLabel jLabelHousing;
    public JComboBox jComboBoxHousings;
    private  ArrayList<Housing> housings = new ArrayList<Housing>();
    public AddEltStayListener addEltStayListener;
    public JButton jButtonValidate ;
    public JButton jButtonFastImput; // todo delete this line  // jbfi
    public ViewStayCreation( ArrayList<Housing> housings, ArrayList<Stay> stays){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter un séjour");
        setName("window for add stay");
        setResizable(false);
        setBounds(500,200,300,250);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.housings = housings;
        jLabelArrivalDate = new JLabel("Date d'arrivée");
        MaskFormatter maskFormatterArrivalDate= null;
        try {
            maskFormatterArrivalDate = new MaskFormatter("##/##/####");
            jFormattedTextFieldArrivalDate = new JFormattedTextField(maskFormatterArrivalDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jLabelOvernightsNumber = new JLabel("Nombre de nuits");
        jTextFieldOvernightsNumber = new JTextField();
        jLabelTravelersNumber = new JLabel("Nombre de voyageurs :");
        jTextFieldTravelersNumber = new JTextField();
        jLabelHousing =new JLabel("logements");
        jComboBoxHousings = new JComboBox();
        addEltStayListener = new AddEltStayListener();
        fillHousingsComboItem();
        jButtonValidate = new JButton("Valider");
        jButtonFastImput = new JButton("Saisie Rapide"); // jbfi
        // ajout d'un conteneur de vues
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(jLabelArrivalDate);
        panel.add(jFormattedTextFieldArrivalDate);
        panel.add(jLabelOvernightsNumber);
        panel.add(jTextFieldOvernightsNumber);
        panel.add(jLabelHousing);
        panel.add(jComboBoxHousings);
        panel.add(jLabelTravelersNumber);
        panel.add(jTextFieldTravelersNumber);
        panel.add(jButtonValidate);
        panel.add(jButtonFastImput); // jbfi
        getContentPane().add(panel);
        setVisible(true);
        jButtonValidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Uti.info("jButtonValidate","actionPerformed()","");
                boolean correctHousing = false;
                inactiveFieldsViewHousing();
                System.out.println(" liste Logements : "+housings.size());
                if(checkFieldsHousing(correctHousing)){
                    System.out.println("ici se passe ce doit se faire lorsque la validation est obtenue.");
                    jButtonValidate.setEnabled(false);
                } else {
                    activeFieldsViewHousing();
                    jButtonValidate.setEnabled(true);
                }
            }
            public void inactiveFieldsViewHousing(){
                Uti.info("jButtonValidate","inactiveFieldsViewHousing","");
                jComboBoxHousings.setEnabled(false);
                jTextFieldTravelersNumber.setEnabled(false);
                jTextFieldOvernightsNumber.setEnabled(false);
                jFormattedTextFieldArrivalDate.setEnabled(false);
            }
            public void activeFieldsViewHousing(){
                Uti.info("jButtonValidate","activeFieldsViewHousing","");
                jComboBoxHousings.setEnabled(true);
                jTextFieldTravelersNumber.setEnabled(true);
                jTextFieldOvernightsNumber.setEnabled(true);
                jFormattedTextFieldArrivalDate.setEnabled(true);
            }
        });
        jButtonFastImput.addActionListener(new ActionListener() { // jbfi
            @Override
            public void actionPerformed(ActionEvent e) {
                Uti.info("jButtonFastImput","actionPerformed()","");
                jFormattedTextFieldArrivalDate.setText("28/03/2021");
                jTextFieldOvernightsNumber.setText("5");
                jTextFieldTravelersNumber.setText("2");
                jButtonValidate.setEnabled(true);
                jButtonFastImput.setEnabled(false);
            }
        });
    }

    public Boolean checkFieldsHousing(Boolean correctHousing){
        /**
         * checks the necessary fields before validation:
         * - present host
         * - correct daylyRate
         * - address not empty
         * - correct area
         * - correct travelersNumber
         * - correct gardenArea
         *
         * the function returns true if all checked fiels are true.
         */
        Uti.info("ViewHouseCreation","checkFieldsHouse","");

        Boolean verifications[]= new Boolean[4];
        for(int i = 0; i<verifications.length;i++){
            verifications[i]=false;
        }

        if((!jFormattedTextFieldArrivalDate.getText().isEmpty() /*&&
                StringUtils.isNumeric(jFormattedTextFieldArrivalDate.getText())*/)){
            String aTester = jFormattedTextFieldArrivalDate.getText();
            if (!aTester.isEmpty()){

                String day = aTester.substring(0,2);
                String month = aTester.substring(3,5);
                String year = aTester.substring(6,10);
                System.out.println(day+" "+month+" "+year);// todo à supprimer

            }
            verifications[0]=true;
            jFormattedTextFieldArrivalDate.setBackground(Color.white);
        } else {
            jFormattedTextFieldArrivalDate.setBackground(Color.red);
            jFormattedTextFieldArrivalDate.setText("");
        }
        if((!jTextFieldOvernightsNumber.getText().isEmpty() &&
                StringUtils.isNumeric(jTextFieldOvernightsNumber.getText()) &&
                Integer.parseInt(jTextFieldOvernightsNumber.getText())>0)){
            verifications[1]=true;
            jTextFieldOvernightsNumber.setBackground(Color.white);
        } else {
            jTextFieldOvernightsNumber.setBackground(Color.red);
            jTextFieldOvernightsNumber.setText("");
        }
        verifications[2] = currentHousing != null ? true:false;
        System.out.println(this.housings.get(0).getAddress()); // todo delete this line
        if(!verifications[2])
            jComboBoxHousings.setBackground(Color.RED);
        if((!jTextFieldTravelersNumber.getText().isEmpty() &&
                StringUtils.isNumeric(jTextFieldTravelersNumber.getText()) &&
                Integer.parseInt(jTextFieldTravelersNumber.getText())>0)){
            verifications[3]=true;
            jTextFieldTravelersNumber.setBackground(Color.white);
        } else {
            jTextFieldTravelersNumber.setBackground(Color.red);
            jTextFieldTravelersNumber.setText("");
        }
        for(int i=0; i<verifications.length;i++){
            if(verifications[i]==true)
                correctHousing = true;
            else{
                i=verifications.length;
                correctHousing = false;
            }
        }
        return correctHousing;
    }

    public void fillHousingsComboItem(){
        /**
         * give combo item content
         */
        Uti.info("ViewStayCreation","fillHousingsComboItem","");
        Uti.mess("dans la liste de logement : "+ housings.size());
//        toRemoveAfter3();
        if(housings != null){
            for(int i = 0; i< housings.size(); i++){
               jComboBoxHousings.addItem(i+" "+ housings.get(i).getDaylyRate()+ " "+ housings.get(i).getMaxTravelersNumber());
            }
        }
    }


    class AddEltStayListener implements ItemListener {
        /**
         * @param
         */

        @Override
        public void itemStateChanged(ItemEvent e) {
            /**
             * the item's number gives the index of object in the list.
             *  the jComboBox object doesn't support the List or ArrayList Objects
             */
            Uti.info("AddEltHostListener", "AddEltStayListener", "");
            // combo
            if (e.getSource() == jComboBoxHousings) {
                jComboBoxHousings.setBackground(Color.white);
                String recup="";
                int index = -1;
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    recup = (String) e.getItem();
                    System.out.println();
                    index = Integer.parseInt(returnFirstWord(recup));
                    currentHousing = housings.get(index);
                    System.out.println(recup+"  " +index+ "  "+ housings.get(index).getClass().toString()+" "+ currentHousing.getAddress());

                }
            } else {
                System.out.println("Ca ne passe pas!");
            }
        }
        public String returnFirstWord(String severalWords){
            Uti.info("AddEltHostListener","returnFirstWord()","");
            int i = severalWords.indexOf(" ");
            String returnedWord="";
            if(i!=-1 && i!=0){
                returnedWord = severalWords.substring(0,i);
                Uti.mess(returnedWord + " "+"longueur : "+returnedWord.length());
                return returnedWord;
            } else {
                return severalWords;
            }
        }
    }
}

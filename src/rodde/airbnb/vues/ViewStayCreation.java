package rodde.airbnb.vues;


import org.apache.commons.lang3.StringUtils;
import rodde.airbnb.logements.Appartment;
import rodde.airbnb.logements.House;
import rodde.airbnb.logements.Housing;
import rodde.airbnb.reservations.LongStay;
import rodde.airbnb.reservations.ShortStay;
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
import java.time.LocalDate;
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
        setBounds(500,200,400,250);
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
        jComboBoxHousings.addItemListener(addEltStayListener);
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
                    System.out.println("ici se passe ce qui doit se faire lorsque la validation est obtenue.");
                    // stay creation
                    Stay currentStay = null;
                    if (Integer.parseInt(jTextFieldOvernightsNumber.getText()) < 6) {
                        currentStay = new ShortStay(
                                stringToLocalDate(jFormattedTextFieldArrivalDate.getText()),
                                Integer.parseInt(jTextFieldOvernightsNumber.getText()),
                                currentHousing,
                                Integer.parseInt(jTextFieldTravelersNumber.getText()));
//                        Uti.mess("séjour court");
                    } else {
                        currentStay = new LongStay(
                                stringToLocalDate(jFormattedTextFieldArrivalDate.getText()),
                                Integer.parseInt(jTextFieldOvernightsNumber.getText()),
                                currentHousing, 
                                Integer.parseInt(jTextFieldTravelersNumber.getText()));
//                        Uti.mess("séjour long");
                    }
                    //
                    inactiveFieldsViewHousing();
                    jButtonValidate.setEnabled(false);
                    jButtonFastImput.setEnabled(false);
                } else {
                    activeFieldsViewHousing();
                    jButtonFastImput.setEnabled(true); // todo retrie after
                    jButtonValidate.setEnabled(true);
                }
            }
            public LocalDate stringToLocalDate(String stringLocalDate){
                /**
                 * this function converts a string dd/MM/yyyy in LocalDate
                 */
                int d=Integer.parseInt(jFormattedTextFieldArrivalDate.getText().substring(0,2));
                int m=Integer.parseInt(jFormattedTextFieldArrivalDate.getText().substring(3,5));
                int y=Integer.parseInt(jFormattedTextFieldArrivalDate.getText().substring(6,10));
                LocalDate localDate = LocalDate.of(y,m,d);
                return  localDate;
            }
            public void inactiveFieldsViewHousing(){
                /**
                 * this function desactivates the fiels
                 */
                Uti.info("jButtonValidate","inactiveFieldsViewHousing","");
                jComboBoxHousings.setEnabled(false);
                jTextFieldTravelersNumber.setEnabled(false);
                jTextFieldOvernightsNumber.setEnabled(false);
                jFormattedTextFieldArrivalDate.setEnabled(false);
            }
            public void activeFieldsViewHousing(){
                /**
                 * this function activates the fiels
                 */
                Uti.info("jButtonValidate","activeFieldsViewHousing","");
                jComboBoxHousings.setEnabled(true);
                jTextFieldTravelersNumber.setEnabled(true);
                jTextFieldOvernightsNumber.setEnabled(true);
                jFormattedTextFieldArrivalDate.setEnabled(true);
            }
        });
        jButtonFastImput.addActionListener(new ActionListener() { //todo retrieve jbfi
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
        String checkedDateStringIni = jFormattedTextFieldArrivalDate.getText();
        String checkedDateString = jFormattedTextFieldArrivalDate.getText();
        checkedDateString = checkedDateStringIni.trim();
        if (checkedDateString.length()==10){
            System.out.println("longueur "+ checkedDateString.length());
            String day = checkedDateString.substring(0,2);
            String month = checkedDateString.substring(3,5);
            String year = checkedDateString.substring(6,10);
            if (validationDate(Integer.parseInt(day),Integer.parseInt(month),Integer.parseInt(year))){
                verifications[0]=true;
                jFormattedTextFieldArrivalDate.setBackground(Color.white);
            }else{
                jFormattedTextFieldArrivalDate.setBackground(Color.red);
                jFormattedTextFieldArrivalDate.setText("");
            }
        }else{
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
    public boolean validationDate(int iDay,int iMonth, int iYear) {
        /**
         * validate a date if the value of day is between 1 and 28 or 29 or 30 or 31,
         * if the value of month is between 1 and 12
         * if the value of year is between 2020 and 2100
         * if the date is validated the fonction returns true othewhise false
         */
        int iMaxDay=0;
        if(iMonth==2){
            if (((iYear % 100)!=0)&&((iYear % 400)==0)||((iYear % 4)==0)){
                iMaxDay = 29;
//                    System.out.println("février 29 jours");
            }else{
                iMaxDay = 28;
//                    System.out.println("février 29 jours");
            }
        } else if(iMonth==4 || iMonth==6 || iMonth==9 || iMonth == 11){
            iMaxDay=30;
        } else {
            iMaxDay= 31;
        }
        if(((iDay>=1)&&(iDay<=iMaxDay))&&((iMonth>=1)&&(iMonth<=12))&&((iYear>=2020)&&(iYear<=2100)))
            return true;
        else
            return false;
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
                if(  housings.get(i) instanceof House){
                    jComboBoxHousings.addItem(i+" : "+(String) ((House) housings.get(i)).shortDisplay());
                }
                else
                {
                    jComboBoxHousings.addItem(i+" : "+(String) ((Appartment) housings.get(i)).shortDisplay());
                }
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

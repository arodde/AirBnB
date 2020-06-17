package rodde.airbnb.vues;

import org.apache.commons.lang3.StringUtils;
import rodde.airbnb.logements.Appartment;
import rodde.airbnb.logements.Housing;
import rodde.airbnb.util.CheckRegex;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;


public class ViewAppartmentCreation extends JFrame {
    public Host currentHost ;
    public Appartment currentAppartment;
    public JLabel jLabelHost;
    public JComboBox jComboBoxHosts;
    public JLabel jLabelDailyRate;
    public JTextField jTextFieldDailyRate;
    public JLabel jLabelAddress;
    public JTextField jTextFieldAddress;
    public JLabel jLabelArea;
    public JTextField jTextFieldArea;
    public JLabel jLabelTravelersNumber;
    public JTextField jTextFieldTravelersNumber;
    public JLabel jLabelFloorNumber;
    public JTextField jTextFieldFloorNumber;
    public JLabel jLabelBalconyArea;
    private JTextField jTextFieldBalconyArea;

    private  ArrayList<Host> hosts = new ArrayList<Host>();
    private  ArrayList<Housing> housings = new ArrayList<Housing>();
    public AddEltHostListener addEltHost;
    public JButton jButtonValidate;
    //    public JButton jButtonFastImput;
    public ViewAppartmentCreation(ArrayList<Host> hosts, ArrayList<Housing> housings){

        Uti.info("ViewAppartmentCreation","ViewAppartmentCreation","");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter une appartement");
        setName("window for add appartment");
        setResizable(false);
        setBounds(500,200,300,350);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.hosts = hosts;
        this.housings = housings;
        jLabelHost = new JLabel("Hôte :");
        jComboBoxHosts = new JComboBox();
        addEltHost = new AddEltHostListener();
        jComboBoxHosts.addItemListener(addEltHost);
        fillHostComboItem();
        jLabelDailyRate = new JLabel("Tarif journalier :");
        jTextFieldDailyRate = new JTextField();
        jLabelAddress = new JLabel("Adresse :");
        jTextFieldAddress = new JTextField();
        jLabelArea = new JLabel("Superficie :");
        jTextFieldArea = new JTextField();
        jLabelTravelersNumber = new JLabel("Nombre de voyageurs :");
        jTextFieldTravelersNumber = new JTextField();
        jLabelFloorNumber = new JLabel("Numéro de l'étage :");
        jTextFieldFloorNumber= new JTextField();
        jLabelBalconyArea = new JLabel("Superficie du balcon ");
        jTextFieldBalconyArea= new JTextField();
        jButtonValidate = new JButton("Valider");
//        jButtonFastImput = new JButton("Saisie Rapide");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(jLabelHost);
        panel.add(jComboBoxHosts);
        panel.add(jLabelDailyRate);
        panel.add(jTextFieldDailyRate);
        panel.add(jLabelAddress);
        panel.add(jTextFieldAddress);
        panel.add(jLabelArea);
        panel.add(jTextFieldArea);
        panel.add(jLabelTravelersNumber);
        panel.add(jTextFieldTravelersNumber);
        panel.add(jLabelFloorNumber);
        panel.add(jTextFieldFloorNumber);
        panel.add(jLabelBalconyArea);
        panel.add(jTextFieldBalconyArea);
        panel.add(jButtonValidate);
//        panel.add(jButtonFastImput);
        getContentPane().add(panel);
        setVisible(true);
        jButtonValidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean correctAppartment = false;
                if(checkFieldsAppartment(correctAppartment)){
                    inactiveFieldsViewAppartment();
                    jButtonValidate.setEnabled(false);
                    currentAppartment = new Appartment(
                            currentHost,
                            Integer.parseInt(jTextFieldDailyRate.getText()) ,
                            jTextFieldAddress.getText(),
                            Integer.parseInt(jTextFieldArea.getText()),
                            Integer.parseInt(jTextFieldTravelersNumber.getText()),
                            Integer.parseInt(jTextFieldFloorNumber.getText()),
                            Integer.parseInt(jTextFieldBalconyArea.getText())
                    );
                    housings.add(currentAppartment);
                    Uti.mess("longueur liste appartements : "+housings.size());
                } else {
                    Uti.mess("L'appartement ne peut être créé.");
                    activeFieldsViewAppartment();
                    jButtonValidate.setEnabled(true);
//					 jButtonFastImput.setEnabled(false);
                }
            }
            public void inactiveFieldsViewAppartment(){
                Uti.info("jButtonValidate","inactiveFieldsViewAppartment","");
                jComboBoxHosts.setEnabled(false);
                jTextFieldDailyRate.setEnabled(false);
                jTextFieldAddress.setEnabled(false);
                jTextFieldArea.setEnabled(false);
                jTextFieldTravelersNumber.setEnabled(false);
                jTextFieldFloorNumber.setEnabled(false);
                jTextFieldBalconyArea.setEnabled(false);
            }
            public void activeFieldsViewAppartment(){
                Uti.info("jButtonValidate","activeFieldsViewAppartment","");
                jComboBoxHosts.setEnabled(true);
                jTextFieldDailyRate.setEnabled(true);
                jTextFieldAddress.setEnabled(true);
                jTextFieldArea.setEnabled(true);
                jTextFieldTravelersNumber.setEnabled(true);
                jTextFieldFloorNumber.setEnabled(true);
                jTextFieldBalconyArea.setEnabled(true);
            }
        });
//        jButtonFastImput.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Uti.info("ActionListener","actionPerforme","");
//                jTextFieldDailyRate.setText("7");
//                jTextFieldAddress.setText("215 rue de la vulve 75000 PARIS");
//                jTextFieldArea.setText("27");
//                jTextFieldTravelersNumber.setText("4");
//                jTextFieldFloorNumber.setText("0");
////                jTextFieldFloorNumber.setText("1");
////                jTextFieldFloorNumber.setText("2");
//                jTextFieldBalconyArea.setText("4");
//                jButtonValidate.setEnabled(true);
//                jButtonFastImput.setEnabled(false);
//            }
//        });
    }

    // modification
    // author: AR
    // release 1.02
    // date 20200617
    //    public  String stringTestRegex(String sMatcher){
    //        /*
    //           the regular expression below is for a french address.
    //           this method gives a message which show if the
    //           pattern matches with the proposed string or not.
    //           the pattern is composed of four pattern:
    //           the first for the address' number
    //           the second for the street's name
    //           the third for the postal code
    //           the last for the city's name
    //           the return's value is the empty string is the
    //           parameter (the address) doesn't match with the
    //           pattern
    //        */
    //        boolean b = false;
    //        String sPattern1 = "\\s*(\\d*)?(\\s)*(bis|Bis|BIS|ter|Ter|TER)?\\s*(appartement|Appartement|APPARTEMENT|app|App|APP)?\\s*(\\d*)?\\s*";
    //        String sPattern2 = "(\\s)+.*(\\s)";
    //        String sPattern3 = "\\s*(\\d){5}\\s*((cedex|Cedex|CEDEX)\\d{2})?\\s*";
    //        String sPattern4 = "[a-zA-Z\\-\\s]+";
    //        String sPattern = sPattern1 + sPattern2 + sPattern3 + sPattern4;;
    //        Pattern pattern = Pattern.compile(sPattern);
    //        Matcher matcher = pattern.matcher(sMatcher);
    //        b = matcher.matches();
    //        if(b){
    //            System.out.print("OK :)");
    //            return sMatcher;
    //        }
    //        else
    //        {
    //            System.out.print("KO :(");
    //            return "";
    //        }
    //    }

    public boolean checkFieldsAppartmentDailyRate(){
        Uti.info("ViewAppartementCreation","checkFieldsAppartmentDailyRate","");
        if((!jTextFieldDailyRate.getText().isEmpty() &&
                StringUtils.isNumeric(jTextFieldDailyRate.getText()) &&
                Integer.parseInt(jTextFieldDailyRate.getText())>0)){
            jTextFieldDailyRate.setBackground(Color.white);
            return true;
        } else {
            jTextFieldDailyRate.setBackground(Color.red);
            jTextFieldDailyRate.setText("");
            return false;
        }
    }
    public boolean checkFieldsAppartmentAddress(){
        Uti.info("ViewAppartementCreation","checkFieldsAppartmentAddress","");
        // modification
        // author: AR
        // release 1.02
        // date 20200617
        //        if(!(stringTestRegex(jTextFieldAddress.getText())).isEmpty()){
        //        jTextFieldAddress.setBackground(Color.white);
        //        return true;
        //    }
        //todo xxx
        if(!(CheckRegex.stringTestRegexFrenchAddressOfAppartement(jTextFieldAddress.getText())).isEmpty()){
            jTextFieldAddress.setBackground(Color.white);
            return true;
        }
        else
        {
            jTextFieldAddress.setBackground(Color.red);
            jTextFieldAddress.setText("");
            return false;
        }
    }
    // TODO REACTIVER VALIDATION SI ERREUR DANS VIEW APPARTEMENT
    public boolean checkFieldsAppartmentFieldArea(){
        Uti.info("ViewAppartementCreation","checkFieldsAppartmentFieldArea","");
        if((!jTextFieldArea.getText().isEmpty() &&
                StringUtils.isNumeric(jTextFieldArea.getText()) &&
                Integer.parseInt(jTextFieldArea.getText())>0)){
            jTextFieldArea.setBackground(Color.white);
            return true;
        } else {
            jTextFieldArea.setBackground(Color.red);
            jTextFieldArea.setText("");
            return false;
        }
    }
    public boolean checkFieldsAppartmentTravelersNumber(){
        Uti.info("ViewAppartementCreation","checkFieldsAppartmentTravelersNumber","");
        if((!jTextFieldTravelersNumber.getText().isEmpty() &&
                StringUtils.isNumeric(jTextFieldTravelersNumber.getText()) &&
                Integer.parseInt(jTextFieldTravelersNumber.getText())>0)){
            jTextFieldTravelersNumber.setBackground(Color.white);
            return true;
        } else {
            jTextFieldTravelersNumber.setBackground(Color.red);
            jTextFieldTravelersNumber.setText("");
            return false;
        }
    }
    public boolean checkFieldsAppartmentFloorNumber(){
        Uti.info("ViewAppartementCreation","checkFieldsAppartmentFloorNumber","");
        if((!jTextFieldFloorNumber.getText().isEmpty() &&
                StringUtils.isNumeric(jTextFieldFloorNumber.getText()) &&
                (( Integer.parseInt(jTextFieldFloorNumber.getText())>=0) &&
                        ( Integer.parseInt(jTextFieldFloorNumber.getText())<3)))){
            jTextFieldFloorNumber.setBackground(Color.white);
            if (Integer.parseInt(jTextFieldFloorNumber.getText())==0){
                jTextFieldBalconyArea.setText("0");
            }
            return true;
        } else {
            jTextFieldFloorNumber.setBackground(Color.red);
            jTextFieldFloorNumber.setText("");
            return false;
        }
    }
    public boolean checkFieldsAppartmentBalconyArea(){
        Uti.info("ViewAppartementCreation","checkFieldsAppartmentBalconyArea","");
        if((!jTextFieldBalconyArea.getText().isEmpty() &&
                StringUtils.isNumeric(jTextFieldBalconyArea.getText()) &&
                Integer.parseInt(jTextFieldBalconyArea.getText())>=0)){
            jTextFieldBalconyArea.setBackground(Color.white);
            return true;
        } else {
            jTextFieldBalconyArea.setBackground(Color.red);
            jTextFieldBalconyArea.setText("");
            return false;
        }
    }

    public Boolean checkFieldsAppartment(Boolean correctAppartment){
        /**
         * checks the necessary fields before validation:
         * - present host
         * - correct daylyRate
         * - address not empty
         * - correct area
         * - correct travelersNumber
         * - correct floorNumber
         * - correct balconyArea
         *
         * the function returns true if all checked fields are true.
         */
        Uti.info("ViewAppartmentCreation","checkFieldsAppartment","");
        Boolean verifications[]= new Boolean[7];
        for(int i = 0; i<verifications.length;i++){
            verifications[i]=false;
        }
        verifications[0] = currentHost != null ? true:false;
        if(!verifications[0])
            jComboBoxHosts.setBackground(Color.RED);
        verifications[1]= checkFieldsAppartmentDailyRate();
        verifications[2]= checkFieldsAppartmentAddress();
        verifications[3]= checkFieldsAppartmentFieldArea();
        verifications[4]= checkFieldsAppartmentTravelersNumber();
        verifications[5]= checkFieldsAppartmentFloorNumber();
        verifications[6]= checkFieldsAppartmentBalconyArea();
        for(int i=0; i<(verifications.length);i++){
            // modification
            // author: AR
            // release 1.03
            // date 20200617
            //            if(verifications[i]==true){
            //                correctAppartment = true;
            //                jButtonValidate.setEnabled(true);
            //                System.out.println(verifications[i]);
            //            }
            //            else{
            //                i=verifications.length;
            //                correctAppartment = false;
            //                jButtonValidate.setEnabled(false);
            //                System.out.println(verifications[i]);
            //            }
            if(verifications[i]==true){
                correctAppartment = true;
                jButtonValidate.setEnabled(false);
                System.out.println(verifications[i]);
                System.out.println(i+" pour "+verifications.length+" éléments maximum");
            }
            else{
                i=verifications.length;
                correctAppartment = false;
                jButtonValidate.setEnabled(true);
                System.out.println(verifications[i]);
                System.out.println(i+" pour "+verifications.length+" éléments maximum");
            }
        }
        return correctAppartment;
    }



    public void fillHostComboItem(){
        /**
         * give combo item content
         */
        Uti.info("ViewAppartmentCreation","fillHostComboItem","");
        Uti.mess("dans la liste d'hôtes : "+ hosts.size());
        if(hosts != null){
            for(int i=0;i< hosts.size(); i++){
                jComboBoxHosts.addItem(i+" "+hosts.get(i).getSurname()+ " "+hosts.get(i).getFirstname());
            }
        }
    }


    class AddEltHostListener implements ItemListener {
        /**
         * @param
         */
        @Override
        public void itemStateChanged(ItemEvent e) {
            /**
             * the item's number gives the index of object in the list.
             *  the jComboBox object doesn't support the List or ArrayList Objects
             */
            Uti.info("ViewAppartmentCreation", "itemStateChanged", "");
            // combo
            if (e.getSource() == jComboBoxHosts) {
                jComboBoxHosts.setBackground(Color.white);
                String recup="";
                int index = -1;
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    recup = (String) e.getItem();
                    index = Integer.parseInt(returnFirstWord(recup));
                    currentHost = hosts.get(index);
                }
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
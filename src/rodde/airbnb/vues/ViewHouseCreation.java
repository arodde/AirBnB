package rodde.airbnb.vues;

import org.apache.commons.lang3.StringUtils;
import rodde.airbnb.logements.House;
import rodde.airbnb.logements.Housing;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
 import java.lang.Object;

//import static com.sun.deploy.util.StringUtils.*;


public class ViewHouseCreation extends JFrame {
    public Host currentHost ;
    public House currentHouse;
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
    public JLabel jLabelGardenArea;
    public JTextField jTextFieldGardenArea;
    public JLabel jLabelSwimmingPool;
    private  ArrayList<Host> hosts = new ArrayList<Host>();
    private  ArrayList<Housing> housings = new ArrayList<Housing>();
    public AddEltHostListener addEltHost;
    public JButton jButtonValidate;
    public JButton jButtonFastImput;
    public ViewHouseCreation(ArrayList<Host> hosts, ArrayList<Housing> housings){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter une maison");
        setName("window for add house");
        setResizable(false);
        setBounds(500,200,300,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.hosts = hosts;
        this.housings = housings;
        toRemoveAfter3();
        jLabelHost = new JLabel("Hôte :");
        jComboBoxHosts = new JComboBox();
        fillHostComboItem();
        hosts.toString();
        jLabelDailyRate = new JLabel("Tarif journalier :");
        jTextFieldDailyRate = new JTextField();
        jLabelAddress = new JLabel("Adresse :");
        jTextFieldAddress = new JTextField();
        jLabelArea = new JLabel("Superficie :");
        jTextFieldArea = new JTextField();
        jLabelTravelersNumber = new JLabel("Nombre de voyageurs :");
        jTextFieldTravelersNumber = new JTextField();
        jLabelGardenArea = new JLabel("Superficie Jardin :");
        jTextFieldGardenArea = new JTextField();
        jLabelSwimmingPool = new JLabel("Piscine ");
        JCheckBoxMenuItem jCheckBoxMenuItemGardenArea= new JCheckBoxMenuItem();
        boolean okGarden = jCheckBoxMenuItemGardenArea.getState();
        jButtonValidate = new JButton("Valider");
//        jButtonFastImput = new JButton("Saisie Rapide");
        // ajout d'un conteneur de vues
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
        panel.add(jLabelGardenArea);
        panel.add(jTextFieldGardenArea);
        panel.add(jLabelSwimmingPool);
        panel.add(jCheckBoxMenuItemGardenArea);
        panel.add(jButtonValidate);
        panel.add(jButtonFastImput);
        getContentPane().add(panel);
        addEltHost = new AddEltHostListener();
        jComboBoxHosts.addItemListener(addEltHost);
        setVisible(true);
        jButtonValidate.addActionListener(new ActionListener() {
            // wait parameter get by combo
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean correctHouse = false;
                inactiveFieldsViewHouse();
                if(checkFieldsHouse(correctHouse)){
                    currentHouse= new House(
                            currentHost,
                            Integer.parseInt(jTextFieldDailyRate.getText()) ,
                            jTextFieldAddress.getText(),
                            Integer.parseInt(jTextFieldArea.getText()),
                            Integer.parseInt(jTextFieldTravelersNumber.getText()),
                            Integer.parseInt(jTextFieldGardenArea.getText()),
                            okGarden);
                    housings.add(currentHouse);
                    jButtonValidate.setEnabled(false);
                    Uti.mess("longueur liste maison : "+housings.size());
                } else {
                    Uti.mess("La maison ne peut être créée.");
                    activeFieldsViewHouse();
                    jButtonValidate.setEnabled(true);
                }
            }
            public void inactiveFieldsViewHouse(){
                Uti.info("jButtonValidate","inactiveFieldsViewHouse","");
                jComboBoxHosts.setEnabled(false);
                jTextFieldDailyRate.setEnabled(false);
                jTextFieldAddress.setEnabled(false);
                jTextFieldArea.setEnabled(false);
                jTextFieldTravelersNumber.setEnabled(false);
                jTextFieldGardenArea.setEnabled(false);
                jCheckBoxMenuItemGardenArea.setEnabled(false);
            }
            public void activeFieldsViewHouse(){
                Uti.info("jButtonValidate","activeFieldsViewHouse","");
                jComboBoxHosts.setEnabled(true);
                jTextFieldDailyRate.setEnabled(true);
                jTextFieldAddress.setEnabled(true);
                jTextFieldArea.setEnabled(true);
                jTextFieldTravelersNumber.setEnabled(true);
                jTextFieldGardenArea.setEnabled(true);
                jCheckBoxMenuItemGardenArea.setEnabled(true);
            }
        });
        jButtonFastImput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldDailyRate.setText("5");
                jTextFieldAddress.setText("");//("21 rue de la couille 23000 GUERET");
                jTextFieldArea.setText("27");
                jTextFieldTravelersNumber.setText("4");
                jTextFieldGardenArea.setText("125");
                jCheckBoxMenuItemGardenArea.setState(true);
                jButtonValidate.setEnabled(false);
                jButtonFastImput.setEnabled(false);
            }
        });
    }

    public Boolean checkFieldsHouse(Boolean correctHouse){
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

        Boolean verifications[]= new Boolean[5];
        for(int i = 0; i<verifications.length;i++){
            verifications[i]=false;
        }
        verifications[0] = currentHost != null ? true:false;
        if(!verifications[0])
            jComboBoxHosts.setBackground(Color.RED);

        if((!jTextFieldDailyRate.getText().isEmpty() &&
                StringUtils.isNumeric(jTextFieldDailyRate.getText()) &&
                Integer.parseInt(jTextFieldDailyRate.getText())>0)){
            verifications[1]=true;
            jTextFieldDailyRate.setBackground(Color.white);
        } else {
            jTextFieldDailyRate.setBackground(Color.red);
            jTextFieldDailyRate.setText("");
        }
        if(!jTextFieldAddress.getText().isEmpty()){
            verifications[2]=true;
            jTextFieldAddress.setBackground(Color.white);
        } else {
            jTextFieldAddress.setBackground(Color.red);
            jTextFieldAddress.setText("");
        }
        if((!jTextFieldArea.getText().isEmpty() &&
                StringUtils.isNumeric(jTextFieldArea.getText()) &&
                Integer.parseInt(jTextFieldArea.getText())>0)){
            verifications[3]=true;
            jTextFieldArea.setBackground(Color.white);
        } else {
            jTextFieldArea.setBackground(Color.red);
            jTextFieldArea.setText("");
        }
        if((!jTextFieldTravelersNumber.getText().isEmpty() &&
                StringUtils.isNumeric(jTextFieldTravelersNumber.getText()) &&
                Integer.parseInt(jTextFieldTravelersNumber.getText())>0)){
            verifications[4]=true;
            jTextFieldTravelersNumber.setBackground(Color.white);
        } else {
            jTextFieldTravelersNumber.setBackground(Color.red);
            jTextFieldTravelersNumber.setText("");
        }
        if((!jTextFieldGardenArea.getText().isEmpty() &&
                StringUtils.isNumeric(jTextFieldGardenArea.getText()) &&
                Integer.parseInt(jTextFieldGardenArea.getText())>0)){
            verifications[4]=true;
            jTextFieldGardenArea.setBackground(Color.white);
        } else {
            jTextFieldGardenArea.setBackground(Color.red);
            jTextFieldGardenArea.setText("");
        }
        for(int i=0; i<verifications.length;i++){
            if(verifications[i]==true)
                correctHouse = true;
            else{
                i=verifications.length;
                correctHouse = false;
            }
        }
        return correctHouse;
    }
    public Boolean checkFieldsHouse2(Boolean correctHouse){
        Uti.info("ViewHouseCreation","checkFieldsHouse","");
        correctHouse = currentHost != null ? true:false;
        if (correctHouse){
            correctHouse = Integer.parseInt(jTextFieldDailyRate.getText())>0 ? true:false;
            if (correctHouse){
                correctHouse = jTextFieldAddress.getText() !="" ? true:false;
                if (correctHouse){
                    correctHouse = Integer.parseInt(jTextFieldArea.getText())>0 ? true:false;
                    if (correctHouse){
                        correctHouse = Integer.parseInt(jTextFieldTravelersNumber.getText())>0 ? true:false;
                        if (correctHouse){
                            correctHouse = Integer.parseInt(jTextFieldGardenArea.getText())>0 ? true:false;
                            return correctHouse;
                        }
                    }
                }
            }
        }
        return correctHouse;
    }
    public void toRemoveAfter3(){
        Uti.info("jButtonValidate","toRemoveAfter3","");
        hosts.add(new Host("MOUSE","Mickey",135,12));
        hosts.add(new Host("MOUSE","Minnie",133,6));
        hosts.add(new Host("DUCK","Donald",134,18));
        hosts.add(new Host("DOG","Pluto",137,12));
    }

    public void fillHostComboItem(){
        /**
         * give combo item content
         */
        Uti.info("ViewHouseCreation","fillHostComboItem","");
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
            Uti.info("ViewHouseCreation", "itemStateChanged", "");
            // combo
            if (e.getSource() == jComboBoxHosts) {
                jComboBoxHosts.setBackground(Color.white);
                jButtonValidate.setEnabled(true);
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

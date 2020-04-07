package rodde.airbnb.vues;

import rodde.airbnb.logements.House;
import rodde.airbnb.logements.Housing;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;


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
    //    private JTextField jTextFieldGardenArea;
    public JButton jButtonValidate;
    public JButton jButtonFastImput;
    ArrayList<String> listHostsCombo = new ArrayList<String >() ;
    public ViewHouseCreation(ArrayList<Host> hosts, ArrayList<Housing> housings){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter une maison");
        setName("window for add house House");
        setResizable(false);
        setBounds(500,200,300,400);
//        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.hosts = hosts;
        this.housings = housings;
        toRemoveAfter3();
        jLabelHost = new JLabel("Hôte :");
        jComboBoxHosts = new JComboBox();
        fillHostComboItem();
        hosts.toString();
//--------------------------------------------------------------------------------------------------------
//        Host personne1 = new Host("RODDE", "Alain", 37, 12);
//        Host personne2 = new Host("RODDE", "Léon", 72, 24);
//        Host personne3 = new Host("RODDE", "Emmanuelle", 37, 12);
//        Host personne4 = new Host("RODDE", "Marie-Claude", 72, 24);
//        Host personne5 = new Host("RODDE", "Jean-Louis", 37, 12);
//        Host personne6 = new Host("RODDE", "Marie-Louis", 72, 24);
//        hostArrayList.add(personne1);
//        hostArrayList.add(personne2);
//        hostArrayList.add(personne3);
//        hostArrayList.add(personne4);
//        hostArrayList.add(personne5);
//        hostArrayList.add(personne6);
//        fillHostComboItem();
//--------------------------------------------------------------------------------------------------------

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
        jButtonValidate.setEnabled(false);
        jButtonFastImput = new JButton("Saisie Rapide");
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
        panel.add(jLabelSwimmingPool);
        panel.add(jCheckBoxMenuItemGardenArea);
        panel.add(jButtonValidate);
        panel.add(jButtonFastImput);
        getContentPane().add(panel);
        addEltHost = new AddEltHostListener();
        jComboBoxHosts.addItemListener(addEltHost);
        setVisible(true);
        // gestion du clic du bouton

        jButtonValidate.addActionListener(new ActionListener() {
            // wait parameter get by combo
            @Override
            public void actionPerformed(ActionEvent e) {
                // Création de l'hôte
                Uti.mess("Maison à créer  dans cette méthode un hôte, " +
                        "un tarif journalier, " +
                        "une adresse," +
                        "une aire," +
                        "un nombre de voyageurs," +
                        "une aire de jardin");
                boolean correctHouse = false;
                // todo résultat booléen à verifier à chaque étape

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
                                }
                            }
                        }
                    }
                }
                toRemoveAfter2();
                if(correctHouse){
                    currentHouse= new House(
                            currentHost,
                            Integer.parseInt(jTextFieldDailyRate.getText()) ,
                            jTextFieldAddress.getText(),
                            Integer.parseInt(jTextFieldArea.getText()),
                            Integer.parseInt(jTextFieldTravelersNumber.getText()),
                            Integer.parseInt(jTextFieldGardenArea.getText()),
                            okGarden);
                } else {
                    Uti.mess("La maison ne peut être créée.");
                }
                Uti.mess("item jComboBox sélectionné?");
            }
            public void toRemoveAfter2(){
                Uti.info("jButtonValidate","toRemoveAfter2","");
                jTextFieldDailyRate.setEnabled(false);
                jTextFieldAddress.setEnabled(false);
                jTextFieldArea.setEnabled(false);
                jTextFieldTravelersNumber.setEnabled(false);
                jCheckBoxMenuItemGardenArea.setEnabled(false);
            }

        });
        jButtonFastImput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldDailyRate.setText("5");
                jTextFieldAddress.setText("21 rue de la couille 23000 GUERET");
                jTextFieldArea.setText("27");
                jTextFieldTravelersNumber.setText("8");
                jTextFieldGardenArea.setText("125");
                jCheckBoxMenuItemGardenArea.setState(true);
                jButtonValidate.setEnabled(false);
                jButtonFastImput.setEnabled(false);
            }
        });
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
//            String labelCombo = "";
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
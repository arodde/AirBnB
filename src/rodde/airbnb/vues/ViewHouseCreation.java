package rodde.airbnb.vues;

import rodde.airbnb.logements.House;
import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;


public class ViewHouseCreation extends JFrame {
    private ArrayList<Host> hosts;
    public JLabel jLabelHost;
    public JComboBox jComboBoxHosts;
    public Host currentHost ;
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
//    private  ArrayList<Host> hostArrayList = new ArrayList<Host>();
    public AddEltHost addEltHost;
    //    private JTextField jTextFieldGardenArea;
    public JButton jButtonValidate;
    public ViewHouseCreation(ArrayList<Host> hosts){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter une maison");
        setName("window for add house House");
        setResizable(false);
        setBounds(500,200,300,250);
//        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.hosts = hosts;
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
        JCheckBoxMenuItem jCheckBoxMenuItemGardenArea= new JCheckBoxMenuItem();
        boolean okGarden = jCheckBoxMenuItemGardenArea.getState();
        jButtonValidate = new JButton("Valider");
        // ajout d'un conteneur de vues
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(jLabelHost);
        panel.add(jComboBoxHosts);
        jComboBoxHosts.addItemListener(addEltHost);
        panel.add(jLabelDailyRate);
        panel.add(jTextFieldDailyRate);
        panel.add(jLabelAddress);
        panel.add(jTextFieldAddress);
        panel.add(jLabelArea);
        panel.add(jTextFieldArea);
        panel.add(jLabelTravelersNumber);
        panel.add(jTextFieldTravelersNumber);
        panel.add(jCheckBoxMenuItemGardenArea);
        panel.add(jButtonValidate);
        getContentPane().add(panel);
        addEltHost = new AddEltHost();
        setVisible(true);
        // gestion du clic du bouton
        jButtonValidate.addActionListener(new AbstractAction() {
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
                if(correctHouse){
                    House currentHouse = new House(
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
            }


        });
    }
    public void fillHostComboItem(){
        /**
         * give combo item content
         */
        Uti.info("ViewHouseCreation","fillHostComboItem","");
        String s = "";
        Uti.mess("dans la liste d'hôtes : "+ hosts.size());
        if(hosts != null){
            Uti.mess("hôtes : "+hosts.size());
            for(int j = 0; j < hosts.size(); j++){
                Host h =  hosts.get(j);
                s = h.getSurname()+ " "+ h.getFirstname();
                jComboBoxHosts.addItem(s);
            }
        }

        Uti.mess("dans la liste d'hôtes : "+ hosts.size());
        Uti.mess(s);
        Uti.mess("yy");

    }
    class AddEltHost implements ItemListener {
        /**
         *
         * @param
         */
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Uti.info("AddEltHost","itemStateChanged","");
//
//        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            Uti.info("ViewHouseCreation","itemStateChanged","");
            // combo
//            String s="";
//            Host h = null;
//            for(int i = 0 ; i < hostArrayList.size()-1 ; i++ ){
//                jComboBoxHosts.addItem(hostArrayList.get(i));
//
//            }
            Uti.mess("plop");
            currentHost = (Host) e.getItem();
            Uti.mess(currentHost.getSurname()+" "+currentHost.getFirstname());
        }
    }
}
package experimentations.dateElementaryOperations;

import experimentations.reusables.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;

public class DateElementaries extends JFrame {
    public JPanel jPanel = new JPanel();
    public JPanel jPanelFirst = new JPanel();
    public JPanel jPanelSecond = new JPanel();
    public JLabel jLabel = new JLabel("Date d'envoi:");
    public JLabel jLabel2 = new JLabel("Retour:");
    public MaskFormatter maskFormatter;
    public Font font ;
    public JFormattedTextField jFormattedTextField ;
    public JFormattedTextField jFormattedTextField2 ;
    public JButton jButton = new JButton("Vérifier");
    public JButton jButton2 = new JButton("Vérifier");
    public JButton jButton3 = new JButton("Positionnement temporel");
    public CheckListener checkListener= new CheckListener();
    public CheckListener checkListener2= new CheckListener();
    public TimePositionningListener timePositionningListener= new TimePositionningListener();
    public DateControl dateControl1 = new DateControl();
    public DateControl dateControl2 = new DateControl();

    public static void main(String[] args){
        DateElementaries dateElementaries = new DateElementaries();
    }
    public DateElementaries(){
        initFrame();
        fieldsConception();
        lookJFTF(jFormattedTextField);
        lookJFTF(jFormattedTextField2);
        addComponentListeners();
        buildLayout();
        this.setContentPane(jPanel);
        this.setVisible(true);
    }
    public void initFrame(){
        setTitle("Date");
        setResizable(true);
        setSize(600,400);
        setLocationRelativeTo(null);
    }
    public void lookJFTF(JFormattedTextField jFormattedTextField){
        font = new Font("Arial", Font.BOLD, 14);
        jFormattedTextField.setFont(font);
        jFormattedTextField.setPreferredSize(new Dimension(150, 30));
        jFormattedTextField.setForeground(Color.BLUE);
    }
    public void fieldsConception(){

        try {
            maskFormatter = new MaskFormatter("##-##-####");
            jFormattedTextField = new JFormattedTextField(maskFormatter);
            jFormattedTextField2 = new JFormattedTextField(maskFormatter);
        } catch (ParseException      parseException) {
            parseException.printStackTrace();
        }
    }
    public void addComponentListeners(){
        jButton.addActionListener(checkListener);
        checkListener.init(jFormattedTextField, dateControl1);
        jButton2.addActionListener(checkListener2);
        checkListener2.init(jFormattedTextField2,dateControl2);
        jButton3.addActionListener(timePositionningListener);
        timePositionningListener.init(dateControl1,dateControl2);
    }
    public void buildLayout(){
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        jPanelFirst.add(jLabel);
        jPanelFirst.add(jFormattedTextField);
        jPanelFirst.add(jButton);
        jPanel.add(jPanelFirst);
        jPanelSecond.add(jLabel2);
        jPanelSecond.add(jFormattedTextField2);
        jPanelSecond.add(jButton2);
        jPanelSecond.add(jButton3);
        jPanel.add(jPanelSecond);
    }
    //    public void f3(){
//
//    }
    private class CheckListener implements ActionListener{
        JFormattedTextField jFormattedTextField= new JFormattedTextField();
        DateControl dateControl= new DateControl();
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                if(!jFormattedTextField.getText().trim().isEmpty()){
                    dateControl.controlValidityDate(jFormattedTextField.getText());
                    System.out.println("Date "+ jFormattedTextField.getText() +" is valid.");
                }
            }  catch(IncorrectMonthException incorrectMonthException){
                incorrectMonthException.printStackTrace();
            }catch(IncorrectDayException incorrectDayException){
                incorrectDayException.printStackTrace();
            }catch(IncorrectYearException incorrectYearException){
                incorrectYearException.printStackTrace();
            }catch(VeryOlderYearException veryOlderYearException){
                veryOlderYearException.printStackTrace();
            }
            // todo vérifier qu'une date est avant ou après une autre

        }
        public void init(JFormattedTextField jFormattedTextField,DateControl dateControl){
            this.jFormattedTextField = jFormattedTextField;
            this.dateControl = dateControl;
        }
    }
    private class TimePositionningListener implements ActionListener {
        DateControl dateControl1 = new DateControl();
        DateControl dateControl2 = new DateControl();
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println(dateControl1.yearNumber);
            System.out.println(dateControl1.monthNumber);
            System.out.println(dateControl1.dayNumber);
            System.out.println(dateControl2.yearNumber);
            System.out.println(dateControl2.monthNumber);
            System.out.println(dateControl2.dayNumber);
            LocalDate localDate = LocalDate.of(dateControl1.yearNumber, dateControl1.monthNumber, dateControl1.dayNumber);
            LocalDate localDate2 = LocalDate.of(dateControl2.yearNumber, dateControl2.monthNumber, dateControl2.dayNumber);


            if( localDate != null && localDate2 != null){
                if(localDate.isAfter(localDate2)){
                    System.out.println("Date d'envoi est après Date de retour: ANOMALIE");
                } else {
                    System.out.println("Date d'envoi est avant Date de retour: OK");
                }
            } else {
                System.out.println("la date d'envoi ou la date de retour est nulle.");
            }



        }
        public void init(DateControl dateControl1, DateControl dateControl2){
            this.dateControl1 =dateControl1;
            this.dateControl2 =dateControl2;
        }
    }
}

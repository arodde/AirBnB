package experimentations.dateElementaryOperations;

import experimentations.reusables.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.time.LocalDate;

public class DateElementaries extends JFrame {
    public JPanel jPanel = new JPanel();
    public JPanel jPanelFirst = new JPanel();
    public JPanel jPanelSecond = new JPanel();
    public JPanel jPanelThird = new JPanel();
    public JPanel jPanelError = new JPanel();
    public JLabel jLabel = new JLabel("Date d'envoi:");
    public JLabel jLabel2 = new JLabel("Retour:");
    public JLabel jLabelInfoError = new JLabel();
    public MaskFormatter maskFormatter;
    public Font font ;
    public JFormattedTextField jFormattedTextField1 = new JFormattedTextField();
    public JFormattedTextField jFormattedTextField2 = new JFormattedTextField();
    public JButton jButton3 = new JButton("Positionnement temporel");
    public CheckListener checkListener= new CheckListener();
    public CheckListener checkListener2= new CheckListener();
    public TimePositionningListener timePositionningListener= new TimePositionningListener();
    public Thread thread = new Thread() ;
    public DateControl dateControl1 = new DateControl();
    public DateControl dateControl2 = new DateControl();

    public static void main(String[] args){
        DateElementaries dateElementaries = new DateElementaries();
    }
    public DateElementaries(){
        initFrame();
        jFormattedTextField1 = jFormattedTextFieldsConception(jFormattedTextField1);
        jFormattedTextField2  = jFormattedTextFieldsConception(jFormattedTextField2);
        lookJFormattedTextField(jFormattedTextField1);
        lookJFormattedTextField(jFormattedTextField2);
        addComponentListeners();
        buildLayout();
        this.setContentPane(jPanel);
        this.setVisible(true);
    }
    public void initFrame(){
        setTitle("Date");
        setResizable(true);
        setSize(450,250);
        setLocationRelativeTo(null);
    }
    public void lookJFormattedTextField(JFormattedTextField jFormattedTextField){
        font = new Font("Arial", Font.BOLD, 14);
        jFormattedTextField.setFont(font);
        jFormattedTextField.setPreferredSize(new Dimension(150, 30));
        jFormattedTextField.setForeground(Color.BLUE);
    }
    public JFormattedTextField jFormattedTextFieldsConception(JFormattedTextField jFormattedTextField){

        try {
            maskFormatter = new MaskFormatter("##-##-####");
            jFormattedTextField = new JFormattedTextField(maskFormatter);
        } catch (ParseException      parseException) {
            parseException.printStackTrace();
        }
        return jFormattedTextField;
    }
    public void addComponentListeners(){
        jFormattedTextField1.addFocusListener(checkListener);
        checkListener.init(jFormattedTextField1, dateControl1);
        jFormattedTextField2.addFocusListener(checkListener2);
        checkListener2.init(jFormattedTextField2,dateControl2);
        jButton3.addActionListener(timePositionningListener);
        timePositionningListener.init(dateControl1, jFormattedTextField1, dateControl2,jFormattedTextField2);
    }
    public void buildLayout(){
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        jPanelFirst.add(jLabel);
        jPanelFirst.add(jFormattedTextField1);
        jPanel.add(jPanelFirst);
        jPanelSecond.add(jLabel2);
        jPanelSecond.add(jFormattedTextField2);
        jPanel.add(jPanelSecond);
        jPanelThird.add(jButton3);
        jPanel.add(jPanelThird);
        jLabelInfoError.setForeground(Color.RED);
        jPanelError.add(jLabelInfoError);
        jPanel.add(jPanelError);
    }
    private class CheckListener implements FocusListener {
        JFormattedTextField jFormattedTextField= new JFormattedTextField();
        DateControl dateControl= new DateControl();
        //        @Override
//        public void actionPerformed2(ActionEvent actionEvent) {
//            try {
//                if(!jFormattedTextField.getText().trim().isEmpty()){
//                    dateControl.controlValidityDate(jFormattedTextField.getText());
//                    System.out.println("Date "+ jFormattedTextField.getText() +" is valid.");
//                }
//            }  catch(IncorrectMonthException incorrectMonthException){
//                incorrectMonthException.printStackTrace();
//            }catch(IncorrectDayException incorrectDayException){
//                incorrectDayException.printStackTrace();
//            }catch(IncorrectYearException incorrectYearException){
//                incorrectYearException.printStackTrace();
//            }catch(VeryOlderYearException veryOlderYearException){
//                veryOlderYearException.printStackTrace();
//            }
//
//
//        }
        public void init(JFormattedTextField jFormattedTextField,DateControl dateControl){
            this.jFormattedTextField = jFormattedTextField;
            this.dateControl = dateControl;
        }
        @Override
        public void focusGained(FocusEvent focusEvent) {
            reInitialize();
        }
        @Override
        public void focusLost(FocusEvent focusEvent) {
            checkJFormattedTextField(dateControl,jFormattedTextField);
        }
        public void checkJFormattedTextField(DateControl dateControl,JFormattedTextField jFormattedTextField){
            try {
                if(!jFormattedTextField.getText().trim().isEmpty()){
                    jFormattedTextField.setBackground(Color.white);
                    dateControl.controlValidityDate(jFormattedTextField.getText());
                    System.out.println("Date "+ jFormattedTextField.getText() +" is valid.");
                    jLabelInfoError.setText("");
                }
            }  catch(IncorrectMonthException incorrectMonthException){
                jFormattedTextField.setBackground(Color.RED);
                jLabelInfoError.setText("le mois doit être compris entre 1 et 12");
                incorrectMonthException.printStackTrace();
            } catch(IncorrectDayException incorrectDayException){
                jFormattedTextField.setBackground(Color.RED);
                jLabelInfoError.setText("le jour doit être compris entre 1 et "+ dateControl.maxDay);
                incorrectDayException.printStackTrace();
            }
//            catch(IncorrectYearException incorrectYearException){
//                jFormattedTextField.setBackground(Color.RED);
//                infoError.setText("l'année doit être supérieure à 1980");
//                incorrectYearException.printStackTrace();
//            }
            catch(VeryOlderYearException veryOlderYearException){
                jFormattedTextField.setBackground(Color.RED);
                jLabelInfoError.setText("l'année doit être supérieure à 1980");
                veryOlderYearException.printStackTrace();
            }
        }
        public void reInitialize(){
            jFormattedTextField.setBackground(Color.white);
            jLabelInfoError.setText("");
            // todo comment afficher message d'erreur dans la fenêtre en temps réel
            thread = new Thread();
        }
    }

//    private class CheckListener implements ChangeListener  {
//        JFormattedTextField jFormattedTextField= new JFormattedTextField();
//
//        DateControl dateControl= new DateControl();
//        //        @Override
////        public void actionPerformed2(ActionEvent actionEvent) {
////            try {
////                if(!jFormattedTextField.getText().trim().isEmpty()){
////                    dateControl.controlValidityDate(jFormattedTextField.getText());
////                    System.out.println("Date "+ jFormattedTextField.getText() +" is valid.");
////                }
////            }  catch(IncorrectMonthException incorrectMonthException){
////                incorrectMonthException.printStackTrace();
////            }catch(IncorrectDayException incorrectDayException){
////                incorrectDayException.printStackTrace();
////            }catch(IncorrectYearException incorrectYearException){
////                incorrectYearException.printStackTrace();
////            }catch(VeryOlderYearException veryOlderYearException){
////                veryOlderYearException.printStackTrace();
////            }
////
////
////        }
//        public void init(JFormattedTextField jFormattedTextField,DateControl dateControl){
//            this.jFormattedTextField = jFormattedTextField;
//            this.dateControl = dateControl;
//        }
//
//        //        @Override
////        public void focusGained(FocusEvent focusEvent) {
////           reInitialize();
////        }
////
////        @Override
////        public void focusLost(FocusEvent focusEvent) {
////            checkJFormattedTextField(dateControl,jFormattedTextField);
////        }
//        public void reInitialize(){
//            jFormattedTextField.setBackground(Color.white);
//            // todo comment afficher message d'erreur dans la fenêtre en temps réel
//            thread = new Thread();
//        }
//        public void checkJFormattedTextField(DateControl dateControl,JFormattedTextField jFormattedTextField){
//            try {
//                if(!jFormattedTextField.getText().trim().isEmpty()){
//                    reInitialize();
//                    jFormattedTextField.setBackground(Color.white);
//                    dateControl.controlValidityDate(jFormattedTextField.getText());
//                    System.out.println("Date "+ jFormattedTextField.getText() +" is valid.");
//                    jLabelInfoError.setText("OK");
//                }
//            }  catch(IncorrectMonthException incorrectMonthException){
//                jFormattedTextField.setBackground(Color.RED);
//                jLabelInfoError.setText("le mois doit être compris entre 1 et 12");
//                incorrectMonthException.printStackTrace();
//            } catch(IncorrectDayException incorrectDayException){
//                jFormattedTextField.setBackground(Color.RED);
//                jLabelInfoError.setText("le jour doit être compris entre 1 et "+ dateControl.maxDay);
//                incorrectDayException.printStackTrace();
//            }
////            catch(IncorrectYearException incorrectYearException){
////                jFormattedTextField.setBackground(Color.RED);
////                infoError.setText("l'année doit être supérieure à 1980");
////                incorrectYearException.printStackTrace();
////            }
//            catch(VeryOlderYearException veryOlderYearException){
//                jFormattedTextField.setBackground(Color.RED);
//                jLabelInfoError.setText("l'année doit être supérieure à 1980");
//                veryOlderYearException.printStackTrace();
//            }
//        }
//
//        @Override
//        public void stateChanged(ChangeEvent changeEvent) {
//            checkJFormattedTextField(dateControl,jFormattedTextField);
//        }
//
////        @Override
////        public void stateChanged(ChangeEvent changeEvent) {
////
////        }
//    }
    private class TimePositionningListener implements ActionListener, Runnable {
        DateControl dateControl1 = new DateControl();
        DateControl dateControl2 = new DateControl();
        JFormattedTextField jFormattedTextField1 = new JFormattedTextField();
        JFormattedTextField jFormattedTextField2 = new JFormattedTextField();
        LocalDate localDate1 ;
        LocalDate localDate2 ;
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            run();
            cafteuse();
            localDate1 = LocalDate.of(dateControl1.yearNumber, dateControl1.monthNumber, dateControl1.dayNumber);
            localDate2 = LocalDate.of(dateControl2.yearNumber, dateControl2.monthNumber, dateControl2.dayNumber);
            if(testLocalDatesExist()){
                if(!posteriority()){
                    jFormattedTextField1.setBackground(Color.ORANGE);
                    jFormattedTextField2.setBackground(Color.ORANGE);
                };
            } else {
                System.out.println("la date d'envoi ou la date de retour est nulle.");
            }
            reset();
            cafteuse();
        }
        public void reset(){
            localDate1 = null;
            localDate2 = null;
        }
        public void cafteuse(){
            System.out.println(dateControl1.yearNumber);
            System.out.println(dateControl1.monthNumber);
            System.out.println(dateControl1.dayNumber);
            System.out.println(dateControl2.yearNumber);
            System.out.println(dateControl2.monthNumber);
            System.out.println(dateControl2.dayNumber);
        }
        public boolean posteriority(){
            if(localDate1.isBefore(localDate2)||localDate1.equals(localDate2)){
                System.out.println("Date d'envoi est avant Date de retour: OK");
                return true;
            } else {
                jLabelInfoError.setText("La date d'envoi doit précéder la date de retour.");
                return false;
            }
        }
        public boolean testLocalDatesExist(){
            if(localDate1 != null && localDate2 != null){ // todo && ||
                return true;
            }else{
                return false;
            }
        }
        public void init(
                DateControl dateControl1,JFormattedTextField jFormattedTextField1,
                DateControl dateControl2, JFormattedTextField jFormattedTextField2){
            this.dateControl1 = dateControl1;
            this.jFormattedTextField1 = jFormattedTextField1;
            this.dateControl2 = dateControl2;
            this.jFormattedTextField2 = jFormattedTextField2;
        }
        @Override
        public void run() {
            displayErrorOnFrame();
        }
        public void displayErrorOnFrame(){
            jPanel.remove(jPanelError);
            jPanelError.removeAll();
            jPanelError.add(jLabelInfoError);
            jPanel.add(jPanelError);
            setVisible(true);
            thread = new Thread();
        }
    }
}

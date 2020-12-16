package experimentations.dateElementaryOperations;

import experimentations.reusables.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class DateElementaries extends JFrame {
    public JPanel jPanel = new JPanel();
    public JLabel jLabel = new JLabel("Saisir la date:");
    public  MaskFormatter maskFormatter;
    public JFormattedTextField jFormattedTextField ;
    public Font font ;
    public JButton jButton = new JButton("Vérifier");
    public checkListener checkListener= new checkListener();

    public DateControl dateControl = new DateControl();

    public static void main(String[] args){
        DateElementaries dateElementaries = new DateElementaries();
    }
    public DateElementaries(){
        initFrame();
        fieldsConception();
        lookJFTF();
        addComponentListeners();
        buildLayout();
        this.setContentPane(jPanel);
        this.setVisible(true);
    }
    public void initFrame(){
        setTitle("Date");
        setResizable(false);
        setSize(600,400);
        setLocationRelativeTo(null);
    }
    public void lookJFTF(){
        font = new Font("Arial", Font.BOLD, 14);
        jFormattedTextField.setFont(font);
        jFormattedTextField.setPreferredSize(new Dimension(150, 30));
        jFormattedTextField.setForeground(Color.BLUE);
    }
    public void fieldsConception(){

        try {
            maskFormatter = new MaskFormatter("##-##-####");
            jFormattedTextField = new JFormattedTextField(maskFormatter);
        } catch (ParseException      parseException) {
            parseException.printStackTrace();
        }
    }
    public void addComponentListeners(){
        jButton.addActionListener(checkListener);
    }
    public void buildLayout(){
        jPanel.add(jLabel);
        jPanel.add(jFormattedTextField);
        jPanel.add(jButton);
    }
//    public void f3(){
//
//    }
    private class checkListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                if(!jFormattedTextField.getText().trim().isEmpty()){
                    dateControl.controlValidityDate(jFormattedTextField.getText());
                    System.out.println("Date is valid.");
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
    }
}

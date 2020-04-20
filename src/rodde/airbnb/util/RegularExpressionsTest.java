package rodde.airbnb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsTest {

    public static void main(String args[]){
        example1();
        example2();
        example3();
        example4();
        example5();
    }
    public static void example1(){
        Uti.info("RegularExpressions","example1()","");
        //1st way
        Pattern p01 = Pattern.compile(".*");//. represents single character
        Pattern p02 = Pattern.compile("z*.");//. represents single character
        Matcher m01 = p01.matcher("as");
        Matcher m02 = p02.matcher("zzzzzf");
        boolean b01 = m01.matches();
        boolean b02 = m02.matches();

//2nd way
        boolean b2=Pattern.compile(".s").matcher("as").matches();

//3rd way
        boolean b3 = Pattern.matches(".s", "as");

        System.out.println(b01+" "+b02+" "+b2+" "+b3);
    }
    public static void example2(){
        String s1="12456";
        Uti.info("RegularExpressions","example2()","");
        Pattern frenchPostalCode = Pattern.compile("\\d{5}");//. represents single character
        Matcher testedchunk = frenchPostalCode.matcher(s1);
        boolean b01 = testedchunk.matches();
        if (b01){
            System.out.println(s1 + " est un code postal de 5 chiffres.");
        } else {
            System.out.println("Erreur!!! "+s1+ " n'est pas un code postal de 5 chiffres.");
        }

        String address1 = "Route de Peyrolet 15110 LUGARDE";
        String address2 = "11 rue Georges Clémenceau 36000 CHATEAUROUX";
        String address3 = "13ter Rue de la marinère 37000 TOURS appartement 7";
        List<String> addresses= new ArrayList<String>();
        addresses.add(address1);
        //todo retrouver la bonne expression régulière mais plus c'est pas urgent
        // todo regarder cette video de you tube https://www.youtube.com/watch?v=XdDPEkyiRTs
//        Pattern address = Pattern.compile("\\d*\\s{1}\\D{3}\\s{1}[\\s([A-Za-z0-9])+\\d{5}[\\s[A-Za-z]+); //. represents single character
//        Matcher testedaddress = frenchPostalCode.matcher(addresses.get(0));
//        boolean b02 = testedaddress.matches();
    }
    public static void example3(){
        Uti.info("RegularExpressions","example3()","");

    }
    public static void example4(){
        Uti.info("RegularExpressions","example4()","");

    }
    public static void example5(){
        Uti.info("RegularExpressions","example5()","");

    }
}

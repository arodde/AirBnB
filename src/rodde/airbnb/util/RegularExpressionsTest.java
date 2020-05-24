package rodde.airbnb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsTest {

    public static void main(String args[]){
//        example1();
//        example2();
//        example3();
        example4();
//        example5();
    }
    public static void example1(){
        Uti.info("RegularExpressions","example1()","");
        //1st way
        Pattern p01 = Pattern.compile(".*");//. represents single character
        Pattern p02 = Pattern.compile("z*.");//. represents single character
        Matcher m01 = p01.matcher("");
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
    }
    public static void example3(){
        Uti.info("RegularExpressions","example3()","");
        Uti.sep("-",100);
RegularExpressionsTest regularExpressionsTest = new RegularExpressionsTest();
        String sPattern = "(\\d*)?(\\s)*(\\s)+.*(\\s)+\\d{5}(\\s)";
        System.out.println("L'expression régulière proposée : "+ sPattern);
        Uti.sep("-",100);
        regularExpressionsTest.displayTestRegex(sPattern,"69  impasse de la Chapelle Fistine 80000 DANS-L-OIGNON");
        regularExpressionsTest.displayTestRegex(sPattern,"Château de Poudlard 86000 LA SORCELLERIE");
        regularExpressionsTest.displayTestRegex(sPattern,"224 bis Boulevard de la Métropolitaine 75012 PARIS");
        regularExpressionsTest.displayTestRegex(sPattern,"224ter Boulevard de la Métropolitaine 75012 PARIS");
        regularExpressionsTest.displayTestRegex(sPattern,"7/45 Tour du guet 19000 LA CATAPULTE");

        /*
                69 impasse de la Chapelle Fistine 80000 DANS-L-OIGNON
                Château de Poudlard 86000 LA SORCELLERIE
                224 Boulevard de la Métropolitaine 75012 PARIS
                7 Tour du guet 19000 LACATAPULTE
        */
    }
    public  void displayTestRegex(String sPattern,String sMatcher){
        /*
           this method gives a message which show if the pattern matches with the proposed string or not
        */
        boolean b = false;
        Pattern pattern = Pattern.compile(sPattern);
        Matcher matcher = pattern.matcher(sMatcher);
        b = matcher.matches();
        if(b){
            System.out.print("OK :)");
        }
        else
        {
            System.out.print("KO :(");
        }
        System.out.println(" ---> "+sPattern+"  \""+ sMatcher+"\"" );
    }
    public  String stringTestRegex(String sPattern,String sMatcher){
        /*
           this method gives a message which show if the pattern matches with the proposed string or not
        */
        boolean b = false;
        Pattern pattern = Pattern.compile(sPattern);
        Matcher matcher = pattern.matcher(sMatcher);
        b = matcher.matches();
        if(b){
            System.out.print("OK :)");
        }
        else
        {
            System.out.print("KO :(");
        }
        return sMatcher;
    }
    public  Boolean booleanTestRegex(String sPattern,String sMatcher){
        /*
           this method gives a message which show if the pattern matches with the proposed string or not
        */
        boolean b = false;
        Pattern pattern = Pattern.compile(sPattern);
        Matcher matcher = pattern.matcher(sMatcher);
        b = matcher.matches();
        if(b){
            System.out.print("OK :)");
        }
        else
        {
            System.out.print("KO :(");
        }
        return b;
    }
    public static void example4(){
        Uti.info("RegularExpressions","example4()","");
        RegularExpressionsTest regularExpressionsTest = new RegularExpressionsTest();
        Uti.sep("-",100);
        String sPattern1 = "\\s*(\\d*)?(\\s)*(bis|Bis|BIS|ter|Ter|TER)?\\s*(appartement|Appartement|APPARTEMENT|app|App|APP)?\\s*(\\d*)?\\s*";
        String sPattern2 = "(\\s)+.*(\\s)";
        String sPattern3 = "\\s*(\\d){5}\\s*((cedex|Cedex|CEDEX)\\d{2})?\\s*";
        String sPattern4 = "[a-zA-Z\\-\\s]+";
        System.out.println("L'expression régulière proposée : "+ sPattern1 +" "+ sPattern2 +" "+ sPattern3 +" "+ sPattern4 );

        regularExpressionsTest.displayTestRegex( sPattern1,"69  TER");
        regularExpressionsTest.displayTestRegex(sPattern2," impasse de la Chapelle Fistine ");
        regularExpressionsTest.displayTestRegex(sPattern3,"80000");
        regularExpressionsTest.displayTestRegex(sPattern4,"DANS-L-OIGNON");
        Uti.sep("-",100);
        System.out.println("L'expression régulière proposée : "+ sPattern1 +" "+ sPattern2 +" "+ sPattern3 +" "+ sPattern4 );
        regularExpressionsTest.displayTestRegex( sPattern1,"  ");
        regularExpressionsTest.displayTestRegex(sPattern2," Château de Poudlard  ");
        regularExpressionsTest.displayTestRegex(sPattern3,"86000");
        regularExpressionsTest.displayTestRegex(sPattern4," LA SORCELLERIE ");
        Uti.sep("-",100);
        System.out.println("L'expression régulière proposée : "+ sPattern1 +" "+ sPattern2 +" "+ sPattern3 +" "+ sPattern4 );
        regularExpressionsTest.displayTestRegex( sPattern1,"224 bis");
        regularExpressionsTest.displayTestRegex(sPattern2," Boulevard de la Métropolitaine ");
        regularExpressionsTest.displayTestRegex(sPattern3,"75012 cedex12");
        regularExpressionsTest.displayTestRegex(sPattern4," PARIS");
        Uti.sep("-",100);
        System.out.println("L'expression régulière proposée : "+ sPattern1 +" "+ sPattern2 +" "+ sPattern3 +" "+ sPattern4 );
        regularExpressionsTest.displayTestRegex( sPattern1,"235 Appartement 45");
        regularExpressionsTest.displayTestRegex(sPattern2," Tour du guet ");
        regularExpressionsTest.displayTestRegex(sPattern3," 19000  ");
        regularExpressionsTest.displayTestRegex(sPattern4,"   LA CATAPULTE");
        Uti.sep("-",100);
        /*
      testRegex(sPattern,"69  impasse de la Chapelle Fistine 80000 DANS-L-OIGNON");
        testRegex(sPattern,"Château de Poudlard 86000 LA SORCELLERIE");
        testRegex(sPattern,"224 bis Boulevard de la Métropolitaine 75012 PARIS");
        testRegex(sPattern,"224ter Boulevard de la Métropolitaine 75012 PARIS");
        testRegex(sPattern,"7/45 Tour du guet 19000 LA CATAPULTE");
        */
        /*
                69 impasse de la Chapelle Fistine 80000 DANS-L-OIGNON
                Château de Poudlard 86000 LA SORCELLERIE
                224 Boulevard de la Métropolitaine 75012 PARIS
                7 Tour du guet 19000 LACATAPULTE
        */
    }
    public static void example5(){
        Uti.info("RegularExpressions","example5()","");

    }
}

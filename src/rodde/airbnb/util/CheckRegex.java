package rodde.airbnb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegex {
    public static  String stringTestRegexFrenchAddressOfHouse(String sMatcher){
        Uti.info("TestRegex","stringTestRegexFrenchAddressOfHouse","");
        /*
           the regular expression below is for a french address.
           this method gives a message which show if the
           pattern matches with the proposed string or not.
           the pattern is composed of four pattern:
           the first for the address' number
           the second for the street's name
           the third for the postal code
           the last for the city's name
           the return's value is the empty string is the
           parameter (the address) doesn't match with the
           pattern
        */
        boolean b = false;
        String sPattern1 = "\\s*(\\d*)?(\\s)*(bis|Bis|BIS|ter|Ter|TER)?\\s*";
        String sPattern2 = "(\\s)+.*(\\s)";
        String sPattern3 = "\\s*(\\d){5}\\s*((cedex|Cedex|CEDEX)\\d{2})?\\s*";
        String sPattern4 = "[a-zA-Z\\-'\\s]+";
        String sPattern = sPattern1 + sPattern2 + sPattern3 + sPattern4;;
        Pattern pattern = Pattern.compile(sPattern);
        Matcher matcher = pattern.matcher(sMatcher);
        b = matcher.matches();
        if(b){
            System.out.print("OK :)");
            return sMatcher;
        }
        else
        {
            System.out.print("KO :(");
            return "";
        }
    }

    public static  String stringTestRegexFrenchAddressOfAppartement(String sMatcher){
        /*
           the regular expression below is for a french address.
           this method gives a message which show if the
           pattern matches with the proposed string or not.
           the pattern is composed of four pattern:
           the first for the address' number
           the second for the street's name
           the third for the postal code
           the last for the city's name
           the return's value is the empty string is the
           parameter (the address) doesn't match with the
           pattern
        */
        Uti.info("TestRegex","stringTestRegexFrenchAddressOfAppartement","");
        boolean b = false;
        String sPattern1 = "\\s*(\\d*)?(\\s)*(bis|Bis|BIS|ter|Ter|TER)?\\s*(appartement|Appartement|APPARTEMENT|app|App|APP)?\\s*(\\d*)?\\s*";
        String sPattern2 = "(\\s)+.*(\\s)";
        String sPattern3 = "\\s*(\\d){5}\\s*((cedex|Cedex|CEDEX)\\d{2})?\\s*";
        String sPattern4 = "[a-zA-Z\\-'\\s]+";
        String sPattern = sPattern1 + sPattern2 + sPattern3 + sPattern4;;
        Pattern pattern = Pattern.compile(sPattern);
        Matcher matcher = pattern.matcher(sMatcher);
        b = matcher.matches();
        if(b){
            System.out.print("OK :)");
            return sMatcher;
        }
        else
        {
            System.out.print("KO :(");
            return "";
        }
    }
}

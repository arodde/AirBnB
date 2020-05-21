package rodde.airbnb.logements;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Housing {
    protected  int id =0;
    private static int index =-1;
    protected Host host;
    protected int daylyRate;
    protected String address;
    protected int area;
    protected int maxTravelersNumber;
    public Housing(Host host, int daylyRate, String address, int area, int maxTravelersNumber) {
     /**
          remarque the control ot the address with the regular
          expression is moved in the checking
          of the field in the windows of housing creation

        */
        Uti.info("Housing","Logement","");
        this.id = index + 1;
        index ++;
        this.host = host;
        this.daylyRate = daylyRate;
        this.address = address;
        this.area = area;
        this.maxTravelersNumber = maxTravelersNumber;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getDaylyRate() {
        Uti.info("Housing","getTarifJournalier","");
        return daylyRate;
    }

    public Host getHost() {
        Uti.info("Housing","getHote","");
        return host;
    }



    public int getArea() {
        Uti.info("Housing","getSuperficie","");
        return area;
    }

    public int getMaxTravelersNumber() {
        Uti.info("Housing","getNbVoyageursMax","");
        return maxTravelersNumber;
    }

    public  abstract void display();


    public  abstract String stringDisplay();
    public  abstract String stringItemDisplay();
    public  abstract String shortDisplay();
    public abstract int getTotalArea();
}

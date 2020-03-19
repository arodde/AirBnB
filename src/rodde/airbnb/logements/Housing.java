package rodde.airbnb.logements;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;

public abstract class Housing {
    protected Host host;
    protected int daylyRate;
    protected String address;
    protected int area;
    protected int maxTravelersNumber;
    public Housing(Host hote, int tarifJournalier, String adresse, int superficie, int nbVoyageursMax) {
        Uti.info("Housing","Logement","");
        this.host = hote;
        this.daylyRate = tarifJournalier;
        this.address = adresse;
        this.area = superficie;
        this.maxTravelersNumber = nbVoyageursMax;
    }

    public int getDaylyRate() {
        Uti.info("Housing","getTarifJournalier","");
        return daylyRate;
    }

    public Host getHost() {
        Uti.info("Housing","getHote","");
        return host;
    }

    public String getAddress() {
        Uti.info("Housing","getAdresse","");
        return address;
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
    public abstract int getTotalArea();
}

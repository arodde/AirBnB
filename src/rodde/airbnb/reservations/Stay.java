package rodde.airbnb.reservations;

import rodde.airbnb.util.Uti;
import rodde.airbnb.logements.Housing;

import java.time.LocalDate;

public abstract class Stay implements ServiceInterface {
    //    private LocalDate dateArrivee;
    //    private Date dateArrivee;
    protected LocalDate arrivalDate;
    protected int overnightsNumber;
    protected Housing housing;

    public int getTravelersNumber() {
        Uti.info("Sejour","getNbVoyageurs()","");
        return travelersNumber;
    }

    protected int travelersNumber;
    protected int rate;
    public boolean arrivalDateVerification(){
        Uti.info("Sejour","verificationDateArrivee()","");
        // date arrivée doit etre plus grande que date actuelle
        LocalDate date = LocalDate.now() ;// la date actuelle
        if( arrivalDate.isAfter(date)){
            //            System.out.println("la date d'arrivée est postérieure à la date de réservation.");
            return true;
        }
        else
                        System.out.println(" ***>  La date d'arrivée est antérieure à la date de réservation.");
            return false;
    }

    public boolean overnightsNumberVerification(){
        Uti.info("Sejour","verificationNombreDeNuits()","");
        // nombre jours du séjour entre 1 et 31
        if(overnightsNumber >0 && overnightsNumber <=31){
            return true;
        }
        else
        {
            System.out.println(" ***>  Le nombre de jours du séjour n'est pas compris entre 1 et 31.");
            return false;
        }
    }

    //    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
    public Stay(LocalDate arrivalDate, int nbNuits, Housing logement, int nbVoyageurs) {
       Uti.info("Sejour","Sejour()","");
        //        Uti.info("Sejour", "Sejour()","");
        this.arrivalDate = arrivalDate;
        this.overnightsNumber = nbNuits;
        this.housing = logement;
        this.travelersNumber = nbVoyageurs;
        this.rate = rate;
    }
    public abstract void display();
    public abstract String stringDisplay();

    protected abstract int rateUpdate();
}

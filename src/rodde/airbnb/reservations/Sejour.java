package rodde.airbnb.reservations;

import rodde.airbnb.Main;
import rodde.airbnb.util.Uti;
import rodde.airbnb.logements.Logement;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;

import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.temporal.TemporalQueries.localDate;
import static java.util.Locale.FRANCE;
import static rodde.airbnb.Main.*;

public abstract class Sejour implements ServiceInterface {
    //    private LocalDate dateArrivee;
    //    private Date dateArrivee;
    protected LocalDate dateArrivee;
    protected int nbNuits;
    protected Logement logement;

    public int getNbVoyageurs() {
        Uti.info("Sejour","getNbVoyageurs()","");
        return nbVoyageurs;
    }

    protected int nbVoyageurs;
    protected int tarif;
    public boolean verificationDateArrivee(){
        Uti.info("Sejour","verificationDateArrivee()","");
        // date arrivée doit etre plus grande que date actuelle
        LocalDate date = LocalDate.now() ;// la date actuelle
        if( dateArrivee.isAfter(date)){
            //            System.out.println("la date d'arrivée est postérieure à la date de réservation.");
            return true;
        }
        else
                        System.out.println(" ***>  La date d'arrivée est antérieure à la date de réservation.");
            return false;
    }

    public boolean verificationNombreDeNuits(){
        Uti.info("Sejour","verificationNombreDeNuits()","");
        // nombre jours du séjour entre 1 et 31
        if(nbNuits>0 && nbNuits <=31){
            return true;
        }
        else
        {
            System.out.println(" ***>  Le nombre de jours du séjour n'est pas compris entre 1 et 31.");
            return false;
        }
    }

    //    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
    public Sejour(LocalDate dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
       Uti.info("Sejour","Sejour()","");
        //        Uti.info("Sejour", "Sejour()","");
        this.dateArrivee = dateArrivee;
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
        this.tarif = tarif;
    }
    public abstract void afficher();

    protected abstract int miseAJourDuTarif();
}

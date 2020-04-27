package rodde.airbnb.reservations;

import rodde.airbnb.logements.Housing;
import rodde.airbnb.util.Uti;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;

public class ShortStay extends Stay {

    public ShortStay(LocalDate dateArrivee, int nbNuits, Housing logement, int nbVoyageurs) {

        super(dateArrivee, nbNuits, logement, nbVoyageurs);
        this.rate = rateUpdate();
    }

    protected int rateUpdate(){
        Uti.info("SejourCourt", "miseAJourDuTarif()","");
        return housing.getDaylyRate()* overnightsNumber;
    }
    public boolean checkTravelersNumber(){
       Uti.info("Sejour","verificationNombreDeVoyageurs()","");
        // nombre voyageurs < inférieur ou égal à capacité acceuil et supérieur à 0
        if(travelersNumber >= 1 && travelersNumber <= housing.getMaxTravelersNumber()){
            return true;
        }
        else
        {
            System.out.println(" ***>  nombre voyageurs pas entre 1 et la capacité d'accueil du logement");
            return false;
        }
    }
    public int getRate(){
       Uti.info("SejourCourt","getTarif()","");
        // gestion arrondi
        String masque = new String("#0.00#");
        DecimalFormat form = new DecimalFormat(masque); // import java.text.DecimalFormat;
        form.format(rate);

        System.out.print("Le prix de ce séjour est de " + rate + " € ");


        return rate;
    }
    public boolean benefitPromotion(){
        Uti.info("SejourCourt","beneficiePromotion()","");
        return false;
    }
    public void display() {
       Uti.info("SejourCourt", "afficher()", "");
        // gestion de la date en chaîne de caractères
        double tarif = (double) overnightsNumber * housing.getDaylyRate();

        boolean bOkParamSejour = false;
        int annee = arrivalDate.getYear();
        Month mois = arrivalDate.getMonth();
        int jour = arrivalDate.getDayOfMonth();

        if (arrivalDateVerification() && overnightsNumberVerification() && checkTravelersNumber()) {
            // affichage
            housing.display();
            System.out.println("Avis de réservation");
            System.out.println("La date d'arrivée est le " + jour + "/" + (((mois.ordinal()+1)<10)?("0"+String.valueOf((mois.ordinal()+1))):(mois.ordinal()+1)) + "/" + annee + " pour " + overnightsNumber + " nuits.");
            getRate();
            System.out.print("Le prix de ce séjour est de " + getRate() + " € .");
        }
        else // sinon
        {
            System.out.println("===>  Aucune réservation ne peut être prise en l'état.\\n");
        }
    }
    public String stringDisplay() {

        Uti.info("SejourCourt", "afficher()", "");
        String s="";
        // gestion de la date en chaîne de caractères
        double rate = (double) overnightsNumber * housing.getDaylyRate();

        boolean bOkParamSejour = false;
        int annee = arrivalDate.getYear();
        Month mois = arrivalDate.getMonth();
        int jour = arrivalDate.getDayOfMonth();

        if (arrivalDateVerification() && overnightsNumberVerification() && checkTravelersNumber()) {
            // affichage

           s += housing.stringDisplay();
           s+= "Avis de réservation:\n";
           s+= "La date d'arrivée est le " + jour + "/" +  (((mois.ordinal()+1)<10)?("0"+String.valueOf((mois.ordinal()+1))):(mois.ordinal()+1))  + "/" + annee + " pour " + overnightsNumber + " nuits.";
           s+= "Le prix de ce séjour est de " + getRate() + " € .";
        }
        else // sinon
        {
           s += "===>  Aucune réservation ne peut être prise en l'état.\\n" ;
        }
        return s;
    }
}

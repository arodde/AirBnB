package rodde.airbnb.reservations;
import rodde.airbnb.logements.Housing;
import rodde.airbnb.util.Uti;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;

public class LongStay extends Stay implements PricingConditionsInterface{
      /**
     the long stay has a price minoration
     * @param dateArrivee
     * @param nbNuits
     * @param logement
     * @param nbVoyageurs
     */
    public LongStay(LocalDate dateArrivee, int nbNuits, Housing logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
        this.rate = rateUpdate();
        this.promotion = rate *(100 - PERCENTAGE_PROMOTION)/100;
    }
    private final int PERCENTAGE_PROMOTION = 20;
    private int promotion ;
    @Override
    public int rateUpdate(){

        return overnightsNumber * housing.getDaylyRate();
    }
    @Override
       public boolean checkTravelersNumber(){
        Uti.info("SejourLong","verificationNombreDeVoyageurs()","");
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
    @Override
       public int getRate(){
        Uti.info("SejourLong","getTarif()","");
//        if (beneficiePromotion()){
//           return tarif *(100 - PROMOTION_EN_POURCENTAGE)/100;
//        } else {
//            return 0;
//        }

        // gestion arrondi
        String masque = new String("#0.00#");
        int tarifInitial =0;
        DecimalFormat form = new DecimalFormat(masque); // import java.text.DecimalFormat;
        form.format(rate);
        System.out.print("Le prix de ce séjour est de "+ rate + " € ");
        if (benefitPromotion()){
            tarifInitial = rate;
            rate = rate *(100 - PERCENTAGE_PROMOTION)/100;
            System.out.print(" ("+(tarifInitial- rate)+"€ de promotion)");
        }

        return rate;
    }
    @Override
    public boolean benefitPromotion(){
        Uti.info("SejourLong","beneficiePromotion()","");
        boolean bPromotion= false;
        if(overnightsNumber >=6){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void display() {
        Uti.info("SejourLong", "afficher()", "");
        // gestion de la date en chaîne de caractères
        double rate = (double) overnightsNumber * housing.getDaylyRate();

        boolean bOkParamSejour = false;
        int annee = arrivalDate.getYear();
        Month mois = arrivalDate.getMonth();
        int jour = arrivalDate.getDayOfMonth();
        // si les 3 conditions sont vérifiées
        if (arrivalDateVerification() && overnightsNumberVerification() && checkTravelersNumber()) {
            // affichage
            housing.display();
            System.out.println("Avis de réservation");
            System.out.println("La date d'arrivée est le " + jour + "/" +  (((mois.ordinal()+1)<10)?("0"+String.valueOf((mois.ordinal()+1))):(mois.ordinal()+1))  + "/" + annee + " pour " + overnightsNumber + " nuits.");
            System.out.print("Le prix de ce séjour est de "+ getRate() + " € ");
            System.out.println(".");
        }
        else // sinon
        {
            System.out.println("===>  Aucune réservation ne peut être prise en l'état.\\n");
        }
    }
    @Override
    public String stringDisplay() {
        String s="";
        // gestion de la date en chaîne de caractères
        double rate = (double) overnightsNumber * housing.getDaylyRate();

        boolean bOkParamSejour = false;
        int annee = arrivalDate.getYear();
        Month mois = arrivalDate.getMonth();
        int jour = arrivalDate.getDayOfMonth();
        // si les 3 conditions sont vérifiées
        if (arrivalDateVerification() && overnightsNumberVerification() && checkTravelersNumber()) {
            // affichage
          s+=   housing.stringDisplay();
          s+= "Avis de réservation\n";
          s+= "La date d'arrivée est le " + jour + "/" + (((mois.ordinal()+1)<10)?("0"+String.valueOf((mois.ordinal()+1))):(mois.ordinal()+1)) + "/" + annee + " pour " + overnightsNumber + " nuits.";
          s+= "Le prix de ce séjour est de "+ getRate() + " € .";
        }
        else // sinon
        {
            s+= "===>  Aucune réservation ne peut être prise en l'état.\\n";
        }
        return s;
    }
}
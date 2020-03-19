package rodde.airbnb.reservations;
import rodde.airbnb.logements.Housing;
import rodde.airbnb.util.Uti;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;

public class LongStay extends Stay {
    public LongStay(LocalDate dateArrivee, int nbNuits, Housing logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
        this.rate = rateUpdate();
        this.promotion = rate *(100 - PERCENTAGE_PROMOTION)/100;
    }
    private final int PERCENTAGE_PROMOTION = 20;
    private int promotion ;
    public int rateUpdate(){

        return overnightsNumber * housing.getDaylyRate();
    }
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
    public boolean benefitPromotion(){
        Uti.info("SejourLong","beneficiePromotion()","");
        boolean bPromotion= false;
        if(overnightsNumber >=6){
            return true;
        } else {
            return false;
        }
    }
    public void display() {
        Uti.info("SejourLong", "afficher()", "");
        // gestion de la date en chaîne de caractères
        double tarif = (double) overnightsNumber * housing.getDaylyRate();

        boolean bOkParamSejour = false;
        int annee = dateArrivee.getYear();
        Month mois = dateArrivee.getMonth();
        int jour = dateArrivee.getDayOfMonth();

//        // gestion arrondi
//        String masque = new String("#0.00#");
//        DecimalFormat form = new DecimalFormat(masque); // import java.text.DecimalFormat;
//
//        // le tarif bénéficie-t'il de la promotion?
//        if (nbNuits > 5) {
//            // ristourne
//            System.out.println("Application de la promotion.");
//            tarif *= 0.8;
//        }
        //traitements
        // vérifie que les paramètres du séjour sont corrects
        //les paramètres de séjour doivent comporter
        //  une date de séjour postérieure à la date de réservation
/*        if (!verificationDateArrivee()) {
            System.out.println("----> date d'arrivée incorrecte");
        } else {
            System.out.println("----> date d'arrivée correcte.");
        }
        //   Un nombre de voyageurs inférieur à la capacité d'accueil du logement
        if (!verificationNombreDeVoyageurs()) {
            System.out.println("----> nombre de voyageurs incorrect");
        } else {
            System.out.println("----> nombre de voyageurs correct");
        }
        //   Le nombre du nuits réservé doit être compris entre 1 et 31 inclus
        if (!verificationNombreDeNuits()) {
            System.out.println("----> nombre de nuits incorrect");
        } else {
            System.out.println("----> nombre de nuits correct");
        }*/
        // si les 3 conditions sont vérifiées
        if (arrivalDateVerification() && overnightsNumberVerification() && checkTravelersNumber()) {
            // affichage
            housing.display();
            System.out.println("Avis de réservation");
            System.out.println("La date d'arrivée est le " + jour + "/" + mois.ordinal() + "/" + annee + " pour " + overnightsNumber + " nuits.");
//            System.out.print("Le prix de ce séjour est de " + tarif + " € ");
//            System.out.print("Le prix de ce séjour est de " + form.format(tarif) + " € ");
//            System.out.print("Le prix de ce séjour est de " + getTarif() + " € ");

            getRate();

            System.out.println(".");
        }
        else // sinon
        {
            System.out.println("===>  Aucune réservation ne peut être prise en l'état.\\n");
        }
    }
}
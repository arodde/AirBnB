package rodde.airbnb.reservations;
import rodde.airbnb.logements.Logement;
import rodde.airbnb.util.Uti;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class SejourLong extends Sejour {
    public SejourLong(LocalDate dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
        this.tarif = miseAJourDuTarif();
        this.promotion = tarif *(100 - PROMOTION_EN_POURCENTAGE)/100;
    }
    private final int PROMOTION_EN_POURCENTAGE = 20;
    private int promotion ;
    public int miseAJourDuTarif(){

        return nbNuits*logement.getTarifJournalier();
    }
    public boolean verificationNombreDeVoyageurs(){
        Uti.info("SejourLong","verificationNombreDeVoyageurs()","");
        // nombre voyageurs < inférieur ou égal à capacité acceuil et supérieur à 0
        if(nbVoyageurs >= 1 && nbVoyageurs  <= logement.getNbVoyageursMax()){
            return true;
        }
        else
        {
            System.out.println(" ***>  nombre voyageurs pas entre 1 et la capacité d'accueil du logement");
            return false;
        }
    }
    public int getTarif(){
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
        form.format(tarif);
        System.out.print("Le prix de ce séjour est de "+ tarif + " € ");
        if (beneficiePromotion()){
            tarifInitial = tarif;
            tarif = tarif *(100 - PROMOTION_EN_POURCENTAGE)/100;
            System.out.print(" ("+(tarifInitial-tarif)+"€ de promotion)");
        }

        return tarif;
    }
    public boolean beneficiePromotion(){
        Uti.info("SejourLong","beneficiePromotion()","");
        boolean bPromotion= false;
        if(nbNuits>=6){
            return true;
        } else {
            return false;
        }
    }
    public void afficher() {
        Uti.info("SejourLong", "afficher()", "");
        // gestion de la date en chaîne de caractères
        double tarif = (double) nbNuits * logement.getTarifJournalier();

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
        if (verificationDateArrivee() && verificationNombreDeNuits() && verificationNombreDeVoyageurs()) {
            // affichage
            logement.afficher();
            System.out.println("Avis de réservation");
            System.out.println("La date d'arrivée est le " + jour + "/" + mois.ordinal() + "/" + annee + " pour " + nbNuits + " nuits.");
//            System.out.print("Le prix de ce séjour est de " + tarif + " € ");
//            System.out.print("Le prix de ce séjour est de " + form.format(tarif) + " € ");
//            System.out.print("Le prix de ce séjour est de " + getTarif() + " € ");

            getTarif();

            System.out.println(".");
        }
        else // sinon
        {
            System.out.println("===>  Aucune réservation ne peut être prise en l'état.\\n");
        }
    }
}
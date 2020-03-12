package rodde.airbnb.reservations;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Voyageur;

import java.time.LocalDate;

public class Reservation {

    private static int identifiant=-1;
    private Sejour sejour;
    private Voyageur voyageur;
    private boolean estValidee;
    private LocalDate dateDeReservation;

    public Reservation(/*int identifiant, */Sejour sejour, Voyageur voyageur ) throws InstanciationReservationException {
        Uti.info("Reservation", "Reservation()","2 p");

        // Tests de validation sur le séjour
        if((!sejour.verificationDateArrivee())||(!sejour.verificationNombreDeVoyageurs())||(!sejour.verificationNombreDeNuits())){
            throw new  InstanciationReservationException();
        }
        // si les conditions à la créations d'un séjour sont correctes
        Reservation.identifiant = identifiant++;
        this.sejour = sejour;
        this.voyageur = voyageur;
        this.estValidee = false;
        this.dateDeReservation = LocalDate.now();

    }
    public void afficher(){
        Uti.info("Reservation", "afficher()","");
        voyageur.afficher();
        System.out.print(" a fait une réservation chez ");
        sejour.afficher();
    }


    public int getIdentifiant() {
        Uti.info("Reservation", "getIdentifiant()","");
        return identifiant;
    }
}

package rodde.airbnb.logements;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Hote;
import rodde.airbnb.utilisateurs.Personne;

public abstract class Logement {
    protected Hote hote;
    protected int tarifJournalier;
    protected String adresse;
    protected int superficie;
    protected int nbVoyageursMax;
    public Logement(Hote hote, int tarifJournalier, String adresse, int superficie, int nbVoyageursMax) {
        Uti.info("Logement","Logement","");
        this.hote = hote;
        this.tarifJournalier = tarifJournalier;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbVoyageursMax = nbVoyageursMax;
    }

    public int getTarifJournalier() {
        Uti.info("Logement","getTarifJournalier","");
        return tarifJournalier;
    }

    public Hote getHote() {
        Uti.info("Logement","getHote","");
        return hote;
    }

    public String getAdresse() {
        Uti.info("Logement","getAdresse","");
        return adresse;
    }

    public int getSuperficie() {
        Uti.info("Logement","getSuperficie","");
        return superficie;
    }

    public int getNbVoyageursMax() {
        Uti.info("Logement","getNbVoyageursMax","");
        return nbVoyageursMax;
    }

    public  abstract void afficher();
    public abstract int getSuperficieTotale();
}

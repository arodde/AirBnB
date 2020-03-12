package rodde.airbnb.logements;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Hote;

public class Maison extends Logement {
    private int superficieJardin;
    private boolean possedePiscine;
    public Maison(Hote hote, int tarifJournalier, String adresse, int superficie, int nbVoyageursMax, int superficieJardin, boolean possedePiscine) {
        super(hote, tarifJournalier, adresse, superficie, nbVoyageursMax);
        this.superficieJardin = superficieJardin;
        this.possedePiscine = possedePiscine;
    }
    public void afficher(){
        Uti.info("Maison","afficher","");
        hote.afficher();
        System.out.println("Le logement est une maison située "+ adresse+".");
        System.out.println("Superficie : "+ superficie+"m².");
        if(superficieJardin>0){
            System.out.println("Jardin : Oui ("+superficieJardin+"m²)");
        } else {
            System.out.println("Jardin : Non");
        }
        if(possedePiscine){
            System.out.println("Piscine : Oui");
        } else {
            System.out.println("Piscine : Non");
        }

    }
    @Override
    public int getSuperficieTotale() {
        Uti.info("Maison","getSuperficieTotale","");
        return superficieJardin + getSuperficie();
    }
}

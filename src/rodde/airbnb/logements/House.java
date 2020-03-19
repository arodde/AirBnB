package rodde.airbnb.logements;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;

public class House extends Housing {
    private int gardenArea;
    private boolean ownSwimmingPool;
    public House(Host hote, int tarifJournalier, String adresse, int superficie, int nbVoyageursMax, int superficieJardin, boolean possedePiscine) {
        super(hote, tarifJournalier, adresse, superficie, nbVoyageursMax);
        this.gardenArea = superficieJardin;
        this.ownSwimmingPool = possedePiscine;
    }
    public void display(){
        Uti.info("House","afficher","");
        host.display();
        System.out.println("Le logement est une maison située "+ address +".");
        System.out.println("Superficie : "+ area +"m².");
        if(gardenArea >0){
            System.out.println("Jardin : Oui ("+ gardenArea +"m²)");
        } else {
            System.out.println("Jardin : Non");
        }
        if(ownSwimmingPool){
            System.out.println("Piscine : Oui");
        } else {
            System.out.println("Piscine : Non");
        }

    }
    @Override
    public int getTotalArea() {
        Uti.info("House","getSuperficieTotale","");
        return gardenArea + getArea();
    }
}

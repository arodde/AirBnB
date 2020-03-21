package rodde.airbnb.logements;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;

public class House extends Housing {
    private int gardenArea;
    private boolean ownSwimmingPool;
    public House(Host host, int daylyRate, String address, int area, int maxTravelersNumber, int gardenArea, boolean ownSwimmingPool) {
        super(host, daylyRate, address, area, maxTravelersNumber);
        this.gardenArea = gardenArea;
        this.ownSwimmingPool = ownSwimmingPool;
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

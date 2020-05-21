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
        /**
         * return a house's description for the console
         */
        Uti.info("House","afficher","");
        host.display();
        System.out.println("Le logement est une maison située "+ address +".\n");
        System.out.println("Superficie : "+ area +"m².\n");
        if(gardenArea >0){
            System.out.println("Jardin : Oui ("+ gardenArea +"m²)\n");
        } else {
            System.out.println("Jardin : Non\n");
        }
        if(ownSwimmingPool){
            System.out.println("Piscine : Oui\n");
        } else {
            System.out.println("Piscine : Non\n");
        }
    }

    @Override
    public String stringDisplay() {
        /**
         * returns a house's description as a string
         */
        String s = host.stringDisplay();
        s += "Le logement est une maison située "+ address +".\n";
        s += "Superficie : "+ area +"m².\n";
        if(gardenArea >0){
            s +="Jardin : Oui ("+ gardenArea +"m²)\n" ;
        } else {
            s +="Jardin : Non\n" ;
        }
        if(ownSwimmingPool){
            s+="Piscine : Oui\n";
        } else {
            s+="Piscine : Non\n";
        }
        return s;
    }

    @Override
    public String stringItemDisplay() {
        return this.id +" "+ shortDisplay();
    }

    public   String shortDisplay(){
        /**
         * gives a short house's description for the combo
         */
        Uti.info("House","shortDisplay()","");
        String description= " Maison (";
        description += area +"m²),\n";
        if(gardenArea >0){
            description += "avec jardin ("+ gardenArea+" m²),\n" ;
        }
        if(ownSwimmingPool){
            description += "piscine,\n";
        }
        description += "pour "+getMaxTravelersNumber()+" personnes\n";
        return description;
    }

    @Override
    public int getTotalArea() {
        Uti.info("House","getSuperficieTotale","");
        return gardenArea + getArea();
    }
}

package rodde.airbnb.logements;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;

public class Appartment extends Housing {
    private int balconyArea;
    private int floorNumber;
    public Appartment(Host host, int daylyRate, String address, int Area, int maxTravelersNumber, int floorNumber, int balconyArea) {
        super(host, daylyRate, address, Area, maxTravelersNumber);
        this.floorNumber = floorNumber;
        this.balconyArea =balconyArea;
    }
    public void display(){
        /**
         * display in console the appartement's description
         */
        Uti.info("Appartement","afficher()","");

        host.display();
        System.out.print("Le logement est un appartement situé "+ address + " au ");
        if(floorNumber == 0){
            System.out.println("rez-de-chaussée.\n");
        } else if (floorNumber == 1){
            System.out.println("1ier Etage.\n");
        } else {
            System.out.println(floorNumber +"ème Etage.\n");
        }
        System.out.println("Superficie : "+ area +"m².\n");
        if(balconyArea >0){
            System.out.println("Balcon : Oui ("+ balconyArea +"m²)\n");
        } else {
            System.out.println("Balcon : Non\n");
        }
    }

    @Override
    public String stringDisplay() {
        /**
         * returns a description of the appartment as a string
         */
        String s = host.stringDisplay();
        s += "Le logement est un appartement situé "+ address + " au ";
        if(floorNumber == 0){
            s += "rez-de-chaussée.\n" ;
        } else if (floorNumber == 1){
            s += "1ier Etage.\n" ;
        } else {
            s += floorNumber +"ème Etage\n." ;
        }
        s += "Superficie : "+ area +"m²\n." ;
        if(balconyArea >0){
            s += "Balcon : Oui ("+ balconyArea +"m²)\n" ;
        } else {
            s += "Balcon : Non\n" ;
        }
        return s;
    }

    public   String shortDisplay(){
        /**
         * returns a short appartment's description for the combo
         */
        Uti.info("Appartment","shortDisplay()","");
        String description= " Appartement (";
        description += area +"m²),\n";
        if(floorNumber == 0){
            description += "rez-de-chaussée,\n";
        } else if (floorNumber == 1){
            description += "1ier Etage,\n";
        } else {
            description += floorNumber +"ème Etage,\n";
        }
        if(floorNumber>0){
            description += " balcon ("+balconyArea+" m²),\n";
        }
        description += "pour "+getMaxTravelersNumber()+" personnes\n";
        return description;

    }

    @Override
    public int getTotalArea() {

        Uti.info("Appartement","getSuperficieTotale()","");
        return balconyArea + area;
    }
}

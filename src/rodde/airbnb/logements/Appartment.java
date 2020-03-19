package rodde.airbnb.logements;

        import rodde.airbnb.util.Uti;
        import rodde.airbnb.utilisateurs.Host;

public class Appartment extends Housing {
    private int balconyArea;
    private int floorNumber;
    public Appartment(Host hote, int tarifJournalier, String adresse, int superficie, int nbVoyageursMax, int numeroEtage, int superficieBalcon) {
        super(hote, tarifJournalier, adresse, superficie, nbVoyageursMax);
        this.floorNumber = numeroEtage;
        this.balconyArea =superficieBalcon;
    }
    public   void display(){
        Uti.info("Appartement","afficher()","");

        host.display();
        System.out.print("Le logement est un appartement situé "+ address + " au ");
        if(floorNumber == 0){
            System.out.println("rez-de-chaussée.");
        } else if (floorNumber == 1){
            System.out.println("1ier Etage.");
        } else {
            System.out.println(floorNumber +"ème Etage.");
        }
        System.out.println("Superficie : "+ area +"m².");
        if(balconyArea >0){
            System.out.println("Balcon : Oui ("+ balconyArea +"m²)");
        } else {
            System.out.println("Balcon : Non");
        }
    }
    @Override
    public int getTotalArea() {

        Uti.info("Appartement","getSuperficieTotale()","");
        return balconyArea + area;
    }
}

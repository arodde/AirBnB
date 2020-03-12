package rodde.airbnb.logements;

        import rodde.airbnb.util.Uti;
        import rodde.airbnb.utilisateurs.Hote;

public class Appartement extends Logement {
    private int superficieBalcon;
    private int numeroEtage;
    public Appartement(Hote hote, int tarifJournalier, String adresse, int superficie, int nbVoyageursMax,int numeroEtage, int superficieBalcon) {
        super(hote, tarifJournalier, adresse, superficie, nbVoyageursMax);
        this.numeroEtage = numeroEtage;
        this.superficieBalcon =superficieBalcon;
    }
    public   void afficher(){
        Uti.info("Appartement","afficher()","");

        hote.afficher();
        System.out.print("Le logement est un appartement situé "+ adresse+ " au ");
        if(numeroEtage == 0){
            System.out.println("rez-de-chaussée.");
        } else if (numeroEtage == 1){
            System.out.println("1ier Etage.");
        } else {
            System.out.println(numeroEtage+"ème Etage.");
        }
        System.out.println("Superficie : "+ superficie+"m².");
        if(superficieBalcon>0){
            System.out.println("Balcon : Oui ("+superficieBalcon+"m²)");
        } else {
            System.out.println("Balcon : Non");
        }
    }
    @Override
    public int getSuperficieTotale() {

        Uti.info("Appartement","getSuperficieTotale()","");
        return superficieBalcon+superficie;
    }
}

package rodde.airbnb.utilisateurs;

import rodde.airbnb.util.Uti;

public class Host extends Person {
    public int getResponseTime() {
        Uti.info("Hote","getDelaiReponse()","");
        return responseTime;
    }

    private int responseTime;
    public Host(String surname, String firstname, int age, int responseTime){
        super( surname,firstname , age);// appelle le constructeur de personne
        this.responseTime = responseTime;
    }
    public void display(){
        Uti.info("Hote","afficher()","");
        super.display();
        if(responseTime >1){
            System.out.println( " qui s'engage à répondre dans les "+ responseTime + " heures.");
        }else{
            System.out.println( " qui s'engage à répondre dans l'heure.");
        }
    }
    public String stringDisplay(){
        Uti.info("Hote","afficher()","");
        String s= super.stringDisplay();
        if(responseTime >1){
            s+= " qui s'engage à répondre dans les "+ responseTime + " heures.";
        }else{
            s+= " qui s'engage à répondre dans l'heure.";
        }
        return s;
    }
}


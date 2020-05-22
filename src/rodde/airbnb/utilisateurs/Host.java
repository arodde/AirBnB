package rodde.airbnb.utilisateurs;

import rodde.airbnb.util.Uti;

public class Host extends Person {

    private  int id =0;
    private static int index =-1;
    private int responseTime;
    public int getId() {
        return id;
    }

    public int getResponseTime() {
        Uti.info("Hote","getDelaiReponse()","");
        return responseTime;
    }
    public Host(String surname, String firstname, int age, int responseTime){
        super( surname,firstname , age);// appelle le constructeur de personne
        this.responseTime = responseTime;
        this.id = index + 1;
        index ++;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void display(){
        Uti.info("Hote","afficher()","");
        super.display();
        if(responseTime >1){
            System.out.println( " qui s'engage à répondre dans les "+ responseTime + " heures\n.");
        }else{
            System.out.println( " qui s'engage à répondre dans l'heure.\n");
        }
    }
    public String stringDisplay(){
        Uti.info("Hote","afficher()","");
        String s= super.stringDisplay();
        if(responseTime >1){
            s+= " qui s'engage à répondre dans les "+ responseTime + " heures.\n";
        }else{
            s+= " qui s'engage à répondre dans l'heure.\n";
        }
        return s;
    }
    public String stringItemDisplay(){
        Uti.info("Personne", "afficher()","");
        return this.id +" "+ super.stringDisplay();
    }
}


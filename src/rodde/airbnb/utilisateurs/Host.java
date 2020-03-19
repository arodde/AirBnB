package rodde.airbnb.utilisateurs;

import rodde.airbnb.util.Uti;

public class Host extends Person {
    public int getResponseTime() {
        Uti.info("Hote","getDelaiReponse()","");
        return responseTime;
    }

    private int responseTime;
    public Host(String nom, String prenom, int age, int delaiReponse){
        super( nom,prenom , age);// appelle le constructeur de personne
        this.responseTime = delaiReponse;
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
}


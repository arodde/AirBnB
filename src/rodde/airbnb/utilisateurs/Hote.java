package rodde.airbnb.utilisateurs;

import rodde.airbnb.util.Uti;

public class Hote extends Personne {
    public int getDelaiReponse() {
        Uti.info("Hote","getDelaiReponse()","");
        return delaiReponse;
    }

    private int delaiReponse;
    public Hote(String nom,String prenom,int age,int delaiReponse){
        super( nom,prenom , age);// appelle le constructeur de personne
        this.delaiReponse = delaiReponse;
    }
    public void afficher(){
  Uti.info("Hote","afficher()","");
        super.afficher();
        if(delaiReponse>1){
            System.out.println( " qui s'engage à répondre dans les "+delaiReponse+ " heures.");
        }else{
            System.out.println( " qui s'engage à répondre dans l'heure.");
        }

    }
}


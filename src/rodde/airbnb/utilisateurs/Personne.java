package rodde.airbnb.utilisateurs;

import rodde.airbnb.util.Uti;

public class Personne {
    protected String nom;
    protected String prenom;
    protected int age;
    public Personne(String nom,String prenom,int age){
       Uti.info("Personne", "Personne()","3 paramètres");
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    public void afficher(){
      Uti.info("Personne", "afficher()","");
        System.out.print(prenom+" "+nom +" ("+ age+" ans)");
    }
}

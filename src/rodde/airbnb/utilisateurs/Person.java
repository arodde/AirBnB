package rodde.airbnb.utilisateurs;

import rodde.airbnb.util.Uti;

public class Person {
    protected String surname;
    protected String firstname;
    protected int age;
    public Person(String nom, String prenom, int age){
       Uti.info("Personne", "Personne()","3 paramètres");
        this.surname = nom;
        this.firstname = prenom;
        this.age = age;
    }
    public void display(){
      Uti.info("Personne", "afficher()","");
        System.out.print(firstname +" "+ surname +" ("+ age+" ans)");
    }
}

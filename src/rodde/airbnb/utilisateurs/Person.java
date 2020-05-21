package rodde.airbnb.utilisateurs;

import rodde.airbnb.util.Uti;

public class Person {

    protected String surname;
    protected String firstname;
    protected int age;
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Person(String surname, String firstname, int age){
//       Uti.info("Personne", "Personne()","3 paramètres");
        this.surname = surname;
        this.firstname = firstname;
        this.age = age;
    }
    public void display(){
      Uti.info("Personne", "afficher()","");
        System.out.print(firstname +" "+ surname +" ("+ age+" ans)");
    }
    public String stringDisplay(){
        Uti.info("Personne", "afficher()","");
        return  firstname +" "+ surname +" ("+ age+" ans)";
    }

}

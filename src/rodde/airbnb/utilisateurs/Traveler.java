package rodde.airbnb.utilisateurs;

import rodde.airbnb.util.Uti;

public class Traveler extends Person {
    private  int id =0;
    private static int index =-1;
    public Traveler(String surname, String firstname, int age){
        super(surname,firstname,age);

        this.id = index + 1;
        index ++;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String stringItemDisplay(){
        Uti.info("Personne", "afficher()","");
        return this.id +" "+ super.stringDisplay();
    }
}

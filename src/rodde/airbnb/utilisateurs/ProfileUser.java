package rodde.airbnb.utilisateurs;

public enum ProfileUser {
    Host("hôte"),
    Traveler("voyageur");
    private String name = "";

    ProfileUser(String name){
        this.name = name;
    }

    public String toString(){
        return " - "+name;
    }
}

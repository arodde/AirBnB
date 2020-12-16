package experimentations.reusables;

public class IncorrectYearException extends Exception{
    public IncorrectYearException(){
        System.out.println("the year is an integer greater than 1980.");
    }
}

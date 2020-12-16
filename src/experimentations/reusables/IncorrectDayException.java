package experimentations.reusables;

public class IncorrectDayException extends Exception{
    public IncorrectDayException(){
        System.out.println("the day is an integer between 1 and the maxDay (28 or 29 or 30 or 31) both included");
    }
}

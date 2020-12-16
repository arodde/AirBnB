package experimentations.reusables;

public class IncorrectMonthException extends Exception{
    public IncorrectMonthException(){
        System.out.println("the month is an integer between 1 and 12 both included");
    }
}

package experimentations.reusables;

public class DateControl {
    String day ;
    String month ;
    String year ;
    int dayNumber ;
    int monthNumber ;
    int yearNumber ;
    int maxDay = 0;
    public  boolean controlValidityDate(String text) throws IncorrectMonthException, IncorrectDayException, IncorrectYearException, VeryOlderYearException {
        /**
         This function checks if the date is possible
         date and returns true if it is the case
         and false in the other case.
         para 1 : String : date dd-MM-yyyy
         */
        day = text.substring(0,2);
        month = text.substring(3,5);
        year = text.substring(6,10);
        dayNumber = Integer.parseInt(day);
        monthNumber = Integer.parseInt(month);
        yearNumber = Integer.parseInt(year);
        maxDay = 0;
        if (controlMonth() && controlDay() && controlYear()){
            return true;
        } else {
            return false;
        }
    }
    private boolean controlMonth() throws IncorrectMonthException {
        /**
         This function checks if the month is a possible value,
         computes the correct maxDay acccording to the month value.
         if the month is correct true is return.
         An exception is throwed in the other case.
         */
        if(monthNumber < 1 || monthNumber > 12){
            throw new IncorrectMonthException();

        } else {
            maxDay = determineMaxDay(monthNumber);
            return true;
        }
    }
    private int determineMaxDay(int monthNumber){
        /**
         This function computes the maxDayNumber of the month
         para 1 : int : monthNumber
         return : maxDay
         */
        int maxDay =0;
        if(monthNumber==2){
            if(LeapYear.isLeap(monthNumber)){
                maxDay = 29;
            } else {
                maxDay = 28;
            }
        } else if (monthNumber == 4 || monthNumber == 6 || monthNumber == 9 || monthNumber == 11 ){
            maxDay = 30;
        } else {
            maxDay = 31;
        }
        return maxDay;
    }
    private boolean controlDay() throws IncorrectDayException {
        /**
         This function checks if the day is a possible value,
         If the month is correct true is return.
         An exception is throwed in the other case.
         */
        if(!isCorrectDayNumber(dayNumber, maxDay)){
            throw new IncorrectDayException();

        } else {
            return true;
        }
    }
    private boolean isCorrectDayNumber(int dayNumber, int maxDay){
        /**
         This function checks if the number value is correct or not.
         It returns true if the value is correct and false in the
         other case.
         */
        if (dayNumber <1 || dayNumber > maxDay){
            return false;
        } else {
            return true;
        }
    }
    private boolean controlYear() throws IncorrectYearException, VeryOlderYearException {
        /**
         This function checks if the year is correct.
         It returns true if the value is correct and false in the
         other case.
         */
        if(!isCorrectYearNumber(yearNumber)){
            throw new IncorrectYearException();
        } else {
            return true;
        }
    }
    private boolean isCorrectYearNumber(int yearNumber) throws VeryOlderYearException {
        /**
         This function checks if the yearNumber is correct or not.
         It returns true if the value is correct and false in the
         other case.
         */
        if (yearNumber > 1980){
            return true;
        } else {
            throw new VeryOlderYearException();
        }
    }
}

package experimentations.reusables;

public  class LeapYear {
    /**
          this static class with the method isLear with one parameter
         @param yearNumber int the year;
         he isLeap method return true if the year is leap and
         false in the other case.
     */
    public static boolean isLeap(int yearNumber){
       return divisibleBy4(yearNumber);
    }
    private static  boolean divisibleBy4(int yearNumber){
        if(yearNumber % 4 == 0){
            return divisibleBy100(yearNumber);
        } else {
            return false;
        }
    }
    private static boolean divisibleBy100(int yearNumber){
        if(yearNumber % 100 == 0){
            return divisibleBy400(yearNumber);
        } else {
            return true;
        }
    }
    private static boolean divisibleBy400(int yearNumber){
        if(yearNumber % 400 == 0){
            return true;
        } else {
            return false;
        }
    }
}

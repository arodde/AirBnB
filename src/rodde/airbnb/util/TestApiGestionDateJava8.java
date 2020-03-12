package rodde.airbnb.util;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
/*
public class TestApiGestionDateJava8 {
    private  final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
    public void apiGestionDateJava8(){
        Uti.info("GestionDateAvecSimpleFormatDate","apiGestionDateJava8","");
        gestionDuTempsMachine();
        gestionDuTempsHumain();
        deJavaApi8VersJavaDate();
        deJavaDateVersJavaApi8();
    }
    public void gestionDuTempsMachine(){
        Uti.info("GestionDateAvecSimpleFormatDate","gestionTempsMachine","");

        System.out.println("Instant.MIN   "+Instant.MIN);
        System.out.println("Instant.EPOCH   "+Instant.EPOCH);
        System.out.println("Instant.now()   "+Instant.now());
        System.out.println("Instant.MAX   "+Instant.MAX);
        Uti.sep("***-",25);
    }
    public void gestionDuTempsHumain(){
        Uti.info("GestionDateAvecSimpleFormatDate","gestionDuTempsHumain","");
        locateDateEtLocateDateTime();
        ajouterOuRetirerDuTemps();
        DurationEtPeriod();
        TemporalAdjusters();
        ZoneIdEtZoneDateTime();
    }
    public void locateDateEtLocateDateTime(){
        Uti.info("GestionDateAvecSimpleFormatDate","LocateDateEtLocateDateTime","");
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Date et heure courante : " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("Date courante : " + date1);

        Month mois = currentTime.getMonth();
        int jour = currentTime.getDayOfMonth();
        int heure = currentTime.getHour();

        System.out.println("Mois : " + mois +", jour : " + jour +", heure : " + heure);

        //Avoir le 25 décembre 2023
        LocalDateTime date2 = currentTime.withDayOfMonth(25).withYear(2023).withMonth(12);
        System.out.println("Date modifiée : " + date2);

        //une autre façon
        LocalDate date3 = LocalDate.of(2023, Month.DECEMBER, 25);
        System.out.println("Autre façon de faire : " + date3);

        //On peut même parser une date depuis un String
        String dateAParser ="20:15:30";
        LocalDateTime parsed = LocalDateTime.now();
        //        LocalDate parsed = LocalTime.parse(dateAParser);
        System.out.println("Date parsée : " + parsed);
        System.out.println("Date parsée : " + parsed.getMonth());
        System.out.println("Date parsée : " + parsed.getYear());
        System.out.println("Date parsée : " + parsed.getDayOfYear());

    }
    public void ajouterOuRetirerDuTemps(){
        Uti.info("GestionDateAvecSimpleFormatDate","ajouterOuRetirerDuTemps","");
        //Le 25 Décembre 2018 a 13H37
        LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER, 25, 13, 37, 0);
        System.out.println("Date de référence : " + ldt);
        //Utilisation de l'objet ChronoUnit pour changer l'objet
        System.out.println("+1 semaine : " + ldt.plus(1, ChronoUnit.WEEKS));
        System.out.println("+2 mois : " + ldt.plus(2, ChronoUnit.MONTHS));
        System.out.println("+3 ans : " + ldt.plus(3, ChronoUnit.YEARS));
        System.out.println("+4 heures : " + ldt.plus(4, ChronoUnit.HOURS));
        System.out.println("-5 secondes : " + ldt.minus(5, ChronoUnit.SECONDS));
        System.out.println("-38 minutes : " + ldt.minusMinutes(38));
    }
    public void DurationEtPeriod(){
        Uti.info("GestionDateAvecSimpleFormatDate","DurationEtPeriod","");
        //Toujours notre 25 Décembre 2018 a 13H37
        LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER, 25, 13, 37, 0);
        LocalDateTime ldt2 = ldt.plus(3, ChronoUnit.YEARS);
        LocalDateTime ldt3 = ldt.minusMinutes(1337);

        Period p = Period.between(ldt.toLocalDate(), ldt2.toLocalDate());
        Duration d = Duration.between(ldt.toLocalTime(), ldt3.toLocalTime());
        System.out.println("Période : " + p);
        System.out.println("Durée : " + d.getSeconds());
        System.out.println("Ecart en jour : " + ChronoUnit.DAYS.between(ldt, ldt2));
    }
    public void TemporalAdjusters(){
        Uti.info("GestionDateAvecSimpleFormatDate","TemporalAdjusters","");
        //Toujours notre 25 Décembre 2018 a 13H37
        LocalDate ldt = LocalDate.of(2019, Month.SEPTEMBER, 18);

        //Le prochain samedi
        LocalDate prochainSamedi = ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("Prochain samedi : "+prochainSamedi);

        //Le troisième mardi du mois suivant
        //On ajoute un mois à notre date
        ldt = ldt.plus(1, ChronoUnit.MONTHS);
        //On en créer une nouvelle au premier jour du mois
        LocalDate ldt2 = LocalDate.of(ldt.getYear(), ldt.getMonth(), 1);
        //On avance de trois mardi
        LocalDate troisiemeMardi = String.valueOf(ldt2.getDayOfWeek()).equals("TUESDAY") ?
                ldt2.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).with(TemporalAdjusters.next(DayOfWeek.TUESDAY)) :
                ldt2.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("Troisième mardi : "+troisiemeMardi);
    }
    public void ZoneIdEtZoneDateTime(){
        Uti.info("GestionDateAvecSimpleFormatDate","ZoneIdEtZoneDateTime","");
        Map<String, String> maps = ZoneId.SHORT_IDS;
        maps.values().stream().forEach((x) -> {System.out.println(x + " -- " + ZoneId.of(x).getRules());});

        //Et connaître notre fuseau
        System.out.println("");
        System.out.println("Fuseau horaire courant : "+ZoneId.systemDefault());
        System.out.println("Règle appliquer aux heures : " + ZoneId.systemDefault().getRules());
    }
    public void deJavaApi8VersJavaDate(){
        Uti.info("GestionDateAvecSimpleFormatDate","deJavaApi8VersJavaDate","");
        //
        ZoneId defaultZoneId = ZoneId.systemDefault();
        System.out.println("System Default TimeZone : " + defaultZoneId);

        //toString() append +8 automatically.
        Date date = new Date();
        System.out.println("date : " + date);

        //1. Convert Date -> Instant
        Instant instant = date.toInstant();
        System.out.println("instant : " + instant); //Zone : UTC+0

        //2. Instant + system default time zone + toLocalDate() = LocalDate
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        System.out.println("localDate : " + localDate);

        //3. Instant + system default time zone + toLocalDateTime() = LocalDateTime
        LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
        System.out.println("localDateTime : " + localDateTime);

        //4. Instant + system default time zone = ZonedDateTime
        ZonedDateTime zonedDateTime = instant.atZone(defaultZoneId);
        System.out.println("zonedDateTime : " + zonedDateTime);
    }
    public void deJavaDateVersJavaApi8(){
        Uti.info("GestionDateAvecSimpleFormatDate","deJavaDateVersJavaApi8","");
        //
        ZoneId defaultZoneId = ZoneId.systemDefault();
        System.out.println("System Default TimeZone : " + defaultZoneId);

        //toString() append +8 automatically.
        Date date = new Date();
        System.out.println("date : " + date);

        //1. Convert Date -> Instant
        Instant instant = date.toInstant();
        System.out.println("instant : " + instant); //Zone : UTC+0

        //2. Instant + system default time zone + toLocalDate() = LocalDate
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        System.out.println("localDate : " + localDate);

        //3. Instant + system default time zone + toLocalDateTime() = LocalDateTime
        LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
        System.out.println("localDateTime : " + localDateTime);

        //4. Instant + system default time zone = ZonedDateTime
        ZonedDateTime zonedDateTime = instant.atZone(defaultZoneId);
        System.out.println("zonedDateTime : " + zonedDateTime);
    }
    public void zoneDateTimeExample(){
        Uti.info("GestionDateAvecSimpleFormatDate","zoneDateTimeExample","");
        String dateInString = "22-1-2015 10:15:55 AM";
        LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));

        ZoneId singaporeZoneId = ZoneId.of("Asia/Singapore");
        System.out.println("TimeZone : " + singaporeZoneId);

        //LocalDateTime + ZoneId = ZonedDateTime
        ZonedDateTime asiaZonedDateTime = ldt.atZone(singaporeZoneId);
        System.out.println("Date (Singapore) : " + asiaZonedDateTime);

        ZoneId newYokZoneId = ZoneId.of("America/New_York");
        System.out.println("TimeZone : " + newYokZoneId);

        ZonedDateTime nyDateTime = asiaZonedDateTime.withZoneSameInstant(newYokZoneId);
        System.out.println("Date (New York) : " + nyDateTime);

        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
        System.out.println("\n---DateTimeFormatter---");
        System.out.println("Date (Singapore) : " + format.format(asiaZonedDateTime));
        System.out.println("Date (New York) : " + format.format(nyDateTime));

    }
    public void avecDate(){
        Uti.info("GestionDateAvecSimpleFormatDate","avecDate","");
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

        String dateInString = "22-01-2015 10:15:55 AM";
        Date date = formatter.parse(dateInString);
        TimeZone tz = TimeZone.getDefault();

        // From TimeZone Asia/Singapore
        System.out.println("TimeZone : " + tz.getID() + " - " + tz.getDisplayName());
        System.out.println("TimeZone : " + tz);
        System.out.println("Date (Singapore) : " + formatter.format(date));

        // To TimeZone America/New_York
        SimpleDateFormat sdfAmerica = new SimpleDateFormat(DATE_FORMAT);
        TimeZone tzInAmerica = TimeZone.getTimeZone("America/New_York");
        sdfAmerica.setTimeZone(tzInAmerica);

        String sDateInAmerica = sdfAmerica.format(date); // Convert to String first
        Date dateInAmerica = formatter.parse(sDateInAmerica); // Create a new Date object

        System.out.println("\nTimeZone : " + tzInAmerica.getID() + " - " + tzInAmerica.getDisplayName());
        System.out.println("TimeZone : " + tzInAmerica);
        System.out.println("Date (New York) (String) : " + sDateInAmerica);
        System.out.println("Date (New York) (Object) : " + formatter.format(dateInAmerica));
    }
    public void avecCalendar(){
        Uti.info("GestionDateAvecSimpleFormatDate","avecCalendar","");
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

        String dateInString = "22-01-2015 10:15:55 AM";
        Date date = formatter.parse(dateInString);
        TimeZone tz = TimeZone.getDefault();

        // From TimeZone Asia/Singapore
        System.out.println("TimeZone : " + tz.getID() + " - " + tz.getDisplayName());
        System.out.println("TimeZone : " + tz);
        System.out.println("Date (Singapore) : " + formatter.format(date));

        // To TimeZone America/New_York
        SimpleDateFormat sdfAmerica = new SimpleDateFormat(DATE_FORMAT);
        TimeZone tzInAmerica = TimeZone.getTimeZone("America/New_York");
        sdfAmerica.setTimeZone(tzInAmerica);

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.setTimeZone(tzInAmerica);

        System.out.println("\nTimeZone : " + tzInAmerica.getID() + " - " + tzInAmerica.getDisplayName());
        System.out.println("TimeZone : " + tzInAmerica);

        //Wrong! It will print the date with the system default time zone
        System.out.println("Date (New York) (Wrong!): " + calendar.getTime());

        //Correct! need formatter
        System.out.println("Date (New York) (Correct!) : " + sdfAmerica.format(calendar.getTime()));

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR); // 12 hour clock
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int ampm = calendar.get(Calendar.AM_PM); //0 = AM , 1 = PM

        //Correct
        System.out.println("\nyear \t\t: " + year);
        System.out.println("month \t\t: " + month + 1);
        System.out.println("dayOfMonth \t: " + dayOfMonth);
        System.out.println("hour \t\t: " + hour);
        System.out.println("minute \t\t: " + minute);
        System.out.println("second \t\t: " + second);
        System.out.println("ampm \t\t: " + ampm);
    }

 // ne fonctionne apparemment pas
    public void jodaTimeExample(){
        Uti.info("GestionDateAvecSimpleFormatDate","jodaTimeExample","");
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

        String dateInString = "22-01-2015 10:15:55 AM";
        Date date = formatter.parse(dateInString);
        TimeZone tz = TimeZone.getDefault();

        // From TimeZone Asia/Singapore
        System.out.println("TimeZone : " + tz.getID() + " - " + tz.getDisplayName());
        System.out.println("TimeZone : " + tz);
        System.out.println("Date (Singapore) : " + formatter.format(date));

        // To TimeZone America/New_York
        SimpleDateFormat sdfAmerica = new SimpleDateFormat(DATE_FORMAT);
        DateTime dt = new DateTime(date);
        DateTimeZone dtZone = DateTimeZone.forID("America/New_York");
        DateTime dtus = dt.withZone(dtZone);
        TimeZone tzInAmerica = dtZone.toTimeZone();
        Date dateInAmerica = dtus.toLocalDateTime().toDate(); //Convert to LocalDateTime first

        sdfAmerica.setTimeZone(tzInAmerica);

        System.out.println("\nTimeZone : " + tzInAmerica.getID() + " - " + tzInAmerica.getDisplayName());
        System.out.println("TimeZone : " + tzInAmerica);
        System.out.println("DateTimeZone : " + dtZone);
        System.out.println("DateTime : " + dtus);

        System.out.println("dateInAmerica (Formatter) : " + formatter.format(dateInAmerica));
        System.out.println("dateInAmerica (Object) : " + dateInAmerica);
    }


    //    public void x(){
    //        Uti.info("GestionDateAvecSimpleFormatDate","x","");
    //
    //    }
}
*/
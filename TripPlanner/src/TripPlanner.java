import java.util.Scanner;

public class TripPlanner {
    public static void main(String[] args) {
        //To separate the question.
        String stars = "**********";

        //To call out the methods.
        greetings();
        System.out.println(stars);
        System.out.println(" ");
        travelBudget();
        System.out.println(stars);
        System.out.println(" ");
        timeDiff();
        System.out.println(stars);
        System.out.println(" ");
        squareArea();
        System.out.println(stars);
    }

    public static void greetings(){
        //Part 01 - Greeting. To ask the user's info.
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = userInput.nextLine();
        String greetings = "Nice to meet you ";
        System.out.print(greetings + name + ", where are you travelling to? ");
        String destination = userInput.nextLine();
        System.out.println("Great ! " + destination + " sounds like a great trip");
    }

    public static void travelBudget(){
        //Part 02 - Travel Time and Budget.
        Scanner userInput = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        int days = userInput.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        double budgets = userInput.nextDouble();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currCode = userInput.next();
        System.out.print("How many " + currCode + " are there in 1 USD? ");
        double convertTo = userInput.nextDouble();
        System.out.println(" ");

        //To change the hours to minutes & to convert double to int.
        double hours = days * 24;
        int intHours = (int) hours;
        double minutes = hours * 60;
        int intMinutes = (int) minutes;
        System.out.println("If you are travelling for " + days + " days that is the same as " + intHours + " hours or " + intMinutes + " minutes");

        //To calculate the average in USD & have the output in 2 decimal place.
        double average = budgets / days;
        int intBudget = (int) budgets;
        String averageAsString = String.format("%.2f", average);
        System.out.println("If you are going to spend $" + intBudget + " USD that means per day you can spend up to $" + averageAsString + " USD");

        //To calculate the average in the currency of the destination.
        double convertFrom = budgets * convertTo;
        double averageConvert = convertFrom / days;
        String averageConvertAsString = String.format("%.2f", averageConvert);
        System.out.println("Your total budget in " + currCode +" is " + convertFrom + " " + currCode + ", which is per day is " + averageConvertAsString + " " + currCode);
    }

    public static void timeDiff(){
        //Part 03 - Time Difference
        Scanner userInput = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        double timeDiff = userInput.nextDouble();

        /*To calculate the time difference.
        Math.abs() --> to return the absolute number. To have a positive output. If the argument is of double or float type:
        If the argument is positive zero or negative zero, the result is positive zero.*/
        double destMidnight = (24 + timeDiff)%24;
        double newDestMidnight = Math.abs(destMidnight);
        double destNoon = (12%24 + timeDiff)%24;
        double newDestNoon = Math.abs(destNoon);

        //To convert double to int to get the hour.
        int midnightHour = (int)newDestMidnight;
        int noonHour = (int)newDestNoon;

        //To get the minutes.
        double midnightMinute = (newDestMidnight - midnightHour)*60;
        double noonMinute = (newDestNoon - noonHour)*60;

        //To convert double to int to get the minutes.
        int newMidnightMinute = (int)midnightMinute;
        int newNoonMinute = (int)noonMinute;

        //To have a leading Zero in the value. --> String.format("%02d",midnightHour);

        System.out.println("That means that when it is midnight at home, it will be " + String.format("%02d",midnightHour) + ":" + String.format("%02d",newMidnightMinute)
                + " in your travel destination and when it is noon at home it will be " + String.format("%02d",noonHour) + ":" + String.format("%02d",newNoonMinute));
    }

    public static void squareArea(){
        //Part 04 & 05 - Country Area & Round
        Scanner userInput = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km2? ");
        double area = userInput.nextDouble();

        //To get the miles2 from km2.
        //Math.round --> to round off the decimal point.
        double miles = area * 0.386102;
        double roundedMiles = Math.round(miles * 10) / 10.0;
        System.out.println("In miles2 that is " + roundedMiles);
    }
}
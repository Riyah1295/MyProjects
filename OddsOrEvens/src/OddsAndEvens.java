import java.util.*;

public class OddsAndEvens {
    public static void main(String[] args){
        String stars = "------------------";
        System.out.println("Let's play a game called \"Odds\" and \"Evens\"");

        //Part 01 - Pick Odds or Evens.
        //To get the user name & their option.
        Scanner userInput = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = userInput.nextLine();
        System.out.print("Hi " + name + ", Which do you choose? (O)dds or (E)ven. ");
        String options = userInput.nextLine();

        //To check if the user choose odds, then the computer would automatically be evens & vice versa.
        if (options.equalsIgnoreCase("O")){
            System.out.println(name + " has picked odds! The computer will be evens.");
        }
        else if (options.equalsIgnoreCase("E")){
            System.out.println(name + " has picked evens! The computer will be odds.");
        }
        else {
            /*In an event that the user did not choose either E or O,
            it would prompt the user the same qns till they choose the correct output before they can play the game.*/
            while(!(options.equalsIgnoreCase("O") || options.equalsIgnoreCase("E"))) {
                System.out.print("Please enter E or O. ");
                options = userInput.nextLine();
            }
            if(options.equalsIgnoreCase("O")){
                System.out.println(name + " has picked odds! The computer will be evens.");
            }
            else {
                System.out.println(name + " has picked evens! The computer will be odds.");
            }
        }
        System.out.println(stars);
        System.out.println();

        //Part 02 - Play the game.
        System.out.print("How many \"fingers\" do you put out? ");
        int fingers = userInput.nextInt();

        //To generate random number for the computer.
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer plays " + computer + " \"fingers\"");
        System.out.println(stars);
        System.out.println();

        //To calculate the total score.
        int totalScore = fingers + computer;
        System.out.println(fingers + " + " + computer + " = " + totalScore);

        //Part 03 - Who won?
        //To determine the winner.
        if (totalScore%2 == 0){
            System.out.println(totalScore + " is ... even.!");
            if(options.equalsIgnoreCase("e")){
                System.out.println("That means " + name + " wins! :)");
            }
            else {
                System.out.println("That means The Computer wins! :)");
            }
        }
        else {
            System.out.println(totalScore + " is ... odd!");
            if(options.equalsIgnoreCase("o")){
                System.out.println("That means " + name + " wins! :)");
            }
            else {
                System.out.println("That means The Computer wins! :)");
            }
        }
        System.out.println(stars);
    }
}
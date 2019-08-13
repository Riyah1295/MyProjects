import java.util.Scanner;
import java.util.Random;

public class BattleShips {
    //To declare Scanner, Random & Array inside of Battleships Class so that it can be use throughout the other methods.
    public static Scanner userInput = new Scanner(System.in);
    public static Random rand = new Random();

    public static int playerShips = 0;
    public static int compShips = 0;

    //Create main ocean map using 2D Array.
    public static String[][] ocean = new String[10][10];
    public static String[][] ocean2 = new String[10][10];

    public static void main(String[] args){
        System.out.println("**** Welcome to Battle Ships Game ****");
        System.out.println("\nRight now, the sea is empty.");
        displayMap(ocean);
        playerLocation(ocean);
        compLocation(ocean);
        battleGround();
    }

    public static void displayMap(String[][] ocean){
        System.out.println("\n  0123456789 ");

        //To create the grid of the Battleships.
        //To create the row of the Battleships.
        for(int row = 0; row < ocean.length; row++){
            //To create the grid on the left.
            System.out.print(row + "|");
            //To create the column of the Battleships.
            for(int col = 0; col < ocean[row].length; col++){
                //To leave space in between of the grid.
                if(ocean[row][col] == null){
                    System.out.print(" ");
                }
                else {
                    System.out.print(ocean[row][col]);
                }
            }
            //To create the grid on the left.
            System.out.println("|" + row);
        }
        System.out.println("  0123456789 ");
    }

    public static void playerLocation (String[][] ocean){
        System.out.println("\nDeploy your ships!");
        //Use WhileLoop to repeat the same qns.
        while (playerShips < 5){
            System.out.print("Enter X coordinate for your " + (playerShips+1) + ". ship: ");
            int row = userInput.nextInt();

            System.out.print("Enter Y coordinate for your " + (playerShips+1) + ". ship: ");
            int col = userInput.nextInt();

            //Prevent placing of ships outside of the Battleships grid.
            if (row > 9 || col > 9){
                System.out.println("The coordinates entered is out of range. Please try again.");
            }
            //Coordinates that is used cannot be use again.
            else if (ocean[row][col] != null){
                System.out.println("The coordinates entered is already been used. Please place your ship on other coordinates.");
            }
            //To place the ship.
            else{
                ocean[row][col] = "@";
                playerShips++;
            }
        }
    }

    public static void compLocation (String[][] ocean){
        System.out.println("\nComputer is deploying ships...");
        while (compShips < 5){
            //Prevent placing of ships outside of the Battleships grid.
            int row = rand.nextInt(10);
            int col = rand.nextInt(10);

            //To prevent placing on the same location as the user.
            if (ocean[row][col] == null && ocean2[row][col] == null){
                System.out.println((compShips + 1) + ". ship DEPLOYED.");
                ocean2[row][col] = "@";
                compShips++;
            }
        }
        System.out.println("-------------------------------------");
    }

    public static void playersTurn(){
        System.out.println("\n*** Let's Play! ***\nPLAYER'S TURN");
        int turn = 0;

        //To let player enter the coordinates.
        while (turn == 0){
            System.out.print("Enter X coordinate: ");
            int row = userInput.nextInt();

            System.out.print("Enter Y coordinate: ");
            int col = userInput.nextInt();

            //If player enter coordinates that is out of range.
            if (row > 9 || col > 9){
                System.out.println("\nThe coordinates entered is out of range. Please try again.");
            }
            //If player enter coordinates that had been used.
            else if (ocean[row][col] == "!" || ocean[row][col] == "x" ||ocean[row][col] == "-"){
                System.out.println("\nThe coordinates entered is already been used. Please use on other coordinates.");
            }
            //If player sink the Computer's ship & change the symbol @ to !.
            else if (ocean2[row][col] == "@"){
                System.out.println("Boom! You sunk The Computer's ship! :)");
                System.out.println("-------------------------------------");
                ocean[row][col] = "!";
                ocean2[row][col] = "!";
                compShips--;
                turn++;
            }
            //If player sink their own ship & change the symbol @ to x.
            else if (ocean[row][col] == "@"){
                System.out.println("Oh no! You sunk your own ship! :(");
                System.out.println("-------------------------------------");
                ocean[row][col] = "x";
                ocean2[row][col] = "x";
                playerShips--;
                turn++;
            }
            //If player did not hit any ship.
            else {
                System.out.println("Sorry, you missed! Better luck next time. :|");
                System.out.println("-------------------------------------");
                ocean[row][col] = "-";
                ocean2[row][col] = "-";
                turn++;
            }
        }
    }

    public static void computersTurn(){
        System.out.println("\nCOMPUTER'S TURN");
        int turn = 0;

        //To generate random coordinates for Computer to attack.
        while (turn == 0){
            int row = rand.nextInt(10);
            int col = rand.nextInt(10);

            //If Computer sink player's ship & change the symbol @ to x.
            if (ocean[row][col] == "@"){
                System.out.println("Oh no! The Computer sunk your ship. :(");
                System.out.println("-------------------------------------");
                ocean[row][col] = "x";
                ocean2[row][col] = "x";
                playerShips--;
                turn++;
            }
            //If Computer sink its own ship & change the symbol @ to !.
            else if (ocean2[row][col] == "@"){
                System.out.println("Boom! The Computer sunk its own ship. :)");
                System.out.println("-------------------------------------");
                ocean[row][col] = "!";
                ocean2[row][col] = "!";
                compShips--;
                turn++;
            }
            //If Computer did not hit any ship.
            else {
                System.out.println("The Computer missed! :|");
                System.out.println("-------------------------------------");
                ocean[row][col] = "-";
                ocean2[row][col] = "-";
                turn++;
            }
        }
    }


    public static void battleGround (){
        //To display updated map.
        displayMap(ocean);

        //To show how many ships are left.
        System.out.println("Your ship: " + playerShips + "| Computer Ships: " + compShips);
        System.out.println("-------------------------------------");

        //The game would continue till the any of the ships is = to 0.
        while (playerShips > 0 && compShips > 0){
            playersTurn();
            computersTurn();
            displayMap(ocean);
            System.out.println("Your ship: " + playerShips + "| Computer Ships: " + compShips);
            System.out.println("-------------------------------------");

            //Player wins when they manage to destroy all the Computer's ship.
            if (compShips == 0){
                System.out.println("\n*** GAME OVER ***");
                System.out.println("Your ship: " + playerShips + "| Computer Ships: " + compShips);
                System.out.println("Hooray! You win the battle! :)");
                System.out.println("-------------------------------------");
            }
            //Player loses when the Computer manage to destroy all the player's ship.
            else if(playerShips == 0){
                System.out.println("\n*** GAME OVER ***");
                System.out.println("Your ship: " + playerShips + "| Computer Ships: " + compShips);
                System.out.println("Sorry, you lost the battle! :(");
                System.out.println("-------------------------------------");
            }
        }
    }
}
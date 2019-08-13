import java.util.Scanner;

public class FractionCalculator {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        intro();

        while (true) {
            //To call out the method.
            String operation = getOperation();
            Fraction frac1 = getFraction();
            Fraction frac2 = getFraction();

            //To get the result from the user input.
            Fraction result = new Fraction(1, 1);
            //To display error message.
            String result2 = "";

            if (operation.equals("=")) {
                System.out.println(frac1 + " " + operation + " " + frac2 + " is " + frac1.equals(frac2));
            }
            else {
                if (operation.equals("+")) {
                    result = frac1.add(frac2);
                }
                else if (operation.equals("-")) {
                    result = frac1.substract(frac2);
                }
                else if (operation.equals("/")) {
                    if (frac2.getNumerator() == 0) {
                        result2 = "Undefined.";
                    }
                    else {
                        result = frac1.divide(frac2);
                    }
                }
                else if (operation.equals("*")) {
                    if (frac2.getNumerator() == 0) {
                        result2 = "0";
                    } else {
                        result = frac1.multiply(frac2);
                    }
                }

                //To print the calculations
                //To print out the error message for invalid division and get "0" if fraction/integer divide by 0.
                if (result2 != ""){
                    System.out.println(frac1 + " " + operation + " " + "0" + " = " + result2);
                }
                //The final result would be printed as integer & does need to change to String since it does not require the "/".
                else if (result.getNumerator() % result.getDenominator() == 0){
                    System.out.println(frac1 + " " + operation + " " + frac2 + " = " + (result.getNumerator()/result.getDenominator()));
                }
                //To print out if the final result is in fraction & make use of the to.String() method to make it in fraction form.
                else {
                    System.out.println(frac1 + " " + operation + " " + frac2 + " = " + result.toString());
                }
            }
        }
    }
    public static void intro() {
        System.out.println("This program is a Fraction Calculator.");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("------------------------------------------------------------------------------");
    }

    //To have the user input their calculation.
    public static String getOperation() {
        System.out.print("Please enter an operation (+, -, /, *, = ) or Q to quit: ");
        String operation = input.nextLine();

        int r = 0;

        //The Fraction Calculator would quit when the user input Q in the menu.
        while (r == 0) {
            if (operation.equalsIgnoreCase("q")) {
                System.exit(0);
            }
            //To check if the user input the correct operation. If correct input, it would continue to getFraction().
            else if (operation.equals("+") || operation.equals("-") || operation.equals("/") || operation.equals("*") || operation.equals("=")) {
                r++;
            }
            //Error message would appear if user input the wrong operation.
            else {
                System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
                operation = input.nextLine();
            }
        }
        return operation;
    }

    public static boolean validFraction(String fraction){
        boolean valid;

        //To remove the negative sign.
        if (fraction.startsWith("-")) {
            fraction = fraction.substring(1);
        }

        //The fraction input have negative sign, space or the denominator = 0, the fraction is not valid.
        if (fraction.contains("-") || fraction.contains(" ") || fraction.charAt(fraction.indexOf("/") + 1) == ('0')) {
            valid = false;
        }
        //If the fraction input have "/", it would be replaced with "".
        else if (fraction.contains("/")) {
            fraction = fraction.replace("/", "");
        }

        //If the fraction input is number from 0-9, it means a valid input.
        if (fraction.matches("[0-9]+")) {
            valid = true;
        }
        //If fraction input is other than numbers, the fraction is not valid.
        else {
            valid = false;
        }
        return valid;
    }

    public static Fraction getFraction() {
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String fracInt = input.nextLine();

        //If the user enter an invalid fraction.
        while (!validFraction(fracInt)) {
            System.out.print("Invalid Fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            fracInt = input.nextLine();
        }
        int num = 0;
        int den = 0;

        //User enter as fraction.
        //Since user input as a string, need to take the value before "/" as the numerator & after "/" as denominator.
        //Integer.parseInt --> to change a string to an integer.
        if (fracInt.contains("/")) {
            num = Integer.parseInt(fracInt.substring(0, fracInt.indexOf("/")));
            den = Integer.parseInt(fracInt.substring((fracInt.indexOf("/") + 1)));
        }
        //User enter as integer.
        //The input value would be the numerator. Denominator would be a default value of 1.
        else {
            num = Integer.parseInt(fracInt);
            den = 1;
        }
        //To return the value after converting String to Integer.
        Fraction convertedFrac = new Fraction(num, den);
        return convertedFrac;
    }
}
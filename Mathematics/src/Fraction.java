import java.lang.IllegalArgumentException;
import java.util.InputMismatchException;

public class Fraction {
    private int numerator;
    private int denominator;

    //Constructor.
    //
    public Fraction(int num, int den){
        //Denominator cannot be zero.
        if (den == 0){
            throw new IllegalArgumentException("It is not possible to use denominator zero.");
        }
        //If user input a negative denominator, it would bump the negative sign to numerator.
        //-3/-2 --> 3/2. 5/-3 --> -5/3.
        else if (den < 0){
            this.numerator = num * -1;
            this.denominator = den * -1;
        }
        else {
            this.numerator = num;
            this.denominator = den;
        }
    }
    //num is the user input.
    //Initializes the object equal in value to the integer parameter.
    //E.g. Fraction myFrac = new Fraction(3), the numerator = 3 & denominator = 1.
    //"this" uses the default value.
    public Fraction (int num){
        this(num,1);
    }

    //Initializes the object to 0, meaning the numerator = 0 & denominator = 1.
    //E.g. Fraction myFrac = new Fraction() --> would create a fraction who's decimal value is 0.
    //"this" uses the default value.
    public Fraction (){
        this(0);
    }

    //Method
    //To get the numerator the user had input.
    public int getNumerator() {
        return numerator;
    }

    //To get the denominator the user had input.
    public int getDenominator() {
        return denominator;
    }

    //To represent the fraction, "numerator/denominator" if the final output is in fraction.
    public String toString(){
        return numerator + "/" + denominator;
    }

    //The result of numerator/denominator.
    public double toDouble(){
        return numerator/denominator;
    }

    public Fraction add(Fraction other){
        Fraction newFrac = new Fraction(((this.numerator*other.denominator)+(other.numerator*this.denominator)),(this.denominator*other.denominator));
        newFrac.toLowestTerms();
        return newFrac;
    }

    public Fraction substract(Fraction other){
        Fraction newFrac = new Fraction(((this.numerator*other.denominator)-(other.numerator*this.denominator)),(this.denominator*other.denominator));
        newFrac.toLowestTerms();
        return newFrac;
    }
    public Fraction multiply(Fraction other){
        Fraction newFrac = new Fraction((this.numerator*other.numerator),(this.denominator*other.denominator));
        newFrac.toLowestTerms();
        return newFrac;
    }

    public Fraction divide(Fraction other){
        if (other.numerator == 0){
            throw new IllegalArgumentException();
        }
        else {
            Fraction newFrac = new Fraction((this.numerator*other.denominator),(this.denominator*other.numerator));
            newFrac.toLowestTerms();
            return newFrac;
        }
    }
    //Force to take in an Object to properly override the Object class's equals method.
    public boolean equals(Object other){
        if (other instanceof Fraction){
            Fraction newOther = (Fraction) other;
            newOther.toLowestTerms();
            Fraction thisFrac = new Fraction(this.numerator,this.denominator);
            thisFrac.toLowestTerms();
            return (thisFrac.numerator == newOther.numerator) && (thisFrac.denominator == newOther.denominator);
        }
        //To check if two fraction is equal.
        else {
            throw new InputMismatchException("Fraction is expected.");
        }
    }

    public void toLowestTerms(){
        int gcd = gcd(this.numerator,this.denominator);
        numerator = this.numerator/gcd;
        denominator = this.denominator/gcd;
    }

    public static int gcd(int num, int den){
        if (num % den == 0){
            return den;
        }
        else {
            return gcd(den,num%den);
        }
    }
}
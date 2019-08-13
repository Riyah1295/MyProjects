
public class FractionDouble {
    private double numerator;
    private double denominator;

    //Constructor.
    //
    public FractionDouble(int num, int den){
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
    public FractionDouble(int den){
        this(1, den);

    }

    //Initializes the object to 0, meaning the numerator = 0 & denominator = 1.
    //E.g. Fraction myFrac = new Fraction() --> would create a fraction who's decimal value is 0.
    //"this" uses the default value.
    public FractionDouble(){
        this(0);
    }

    //Method
    //To exposes the numerator to the user.
    public double getNumerator() {
        return numerator;
    }

    //To exposes the denominator to the user.
    public double getDenominator() {
        return denominator;
    }

    //To represent the fraction, "numerator/denominator".
    public String toString(){
        return numerator + "/" + denominator;
    }

    //The result of numerator/denominator.
    public double toDouble(){
        return numerator/denominator;
    }

    public FractionDouble add(FractionDouble other){
        double a = this.numerator/this.denominator;
        double b = other.numerator/other.denominator;
        double n = (a + b) * 100;
        //System.out.println(n);
        int num = (int)Math.round(n);

        FractionDouble myFrac = new FractionDouble(num,100);
        return myFrac;
    }

    public FractionDouble subtract(FractionDouble other){
        double a = this.numerator/this.denominator;
        double b = other.numerator/other.denominator;
        double n = (a - b) * 100;
        //System.out.println(n);
        int num = (int)Math.round(n);

        FractionDouble myFrac = new FractionDouble(num,100);
        return myFrac;
    }

    public FractionDouble multiply(FractionDouble other){
        double a = this.numerator/this.denominator;
        double b = other.numerator/other.denominator;
        double n = (a * b) * 100;
        //System.out.println(n);
        int num = (int)Math.round(n);

        FractionDouble myFrac = new FractionDouble(num,100);
        return myFrac;
    }


}
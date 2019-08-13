import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Test.*;
import static org.junit.jupiter.api.AfterAll.*;
import static org.junit.jupiter.api.BeforeAll.*;


public class FractionTest {
    Fraction myFrac1 ;
    Fraction myFrac2 ;

    @org.junit.jupiter.api.BeforeEach
    public void setUp()  {
        myFrac1 = new Fraction(2);
        myFrac2 = new Fraction(3);
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown()  {
    }

    @org.junit.jupiter.api.Test

    public void add() {
        Fraction result = new Fraction(5);
        assertEquals(result,myFrac1.add(myFrac2));
    }

    @org.junit.jupiter.api.Test
    public void substract() {
    }

    @org.junit.jupiter.api.Test
    public void multiply() {
    }

    @org.junit.jupiter.api.Test
    public void divide() {
    }
}
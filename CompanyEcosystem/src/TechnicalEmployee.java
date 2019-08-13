public class TechnicalEmployee extends Employee {
    public int checkIns;

    //Has a default base salary of 75000.
    //Use super() as it extends from Employee Class.
    public TechnicalEmployee(String name){

        super(name,75000);
    }
    //To check how many successful check ins they have had.
    public String employeeStatus(){
        return "\t" + this.ID + " " + this.name + " has " + this.checkIns + " successful check ins.\n";
    }
}
public class BusinessEmployee extends Employee{
    private double bonusBudget;

    //Has default base salary of 50000.
    //Use super() as it extends from Employee Class
    public BusinessEmployee(String name){

        super(name,50000);
    }

    //To get the remaining bonusBudget for the team the employee supports.
    //Different bonus budget differ on Business Employee.
    public double getBonusBudget(){

        return this.bonusBudget;
    }

    //To get the size of their currently managed budget.
    public String employeeStatus(){

        return super.employeeStatus() + " with a budget of " + this.bonusBudget + "\n";
    }
}
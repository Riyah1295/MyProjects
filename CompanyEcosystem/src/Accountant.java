public class Accountant extends BusinessEmployee {
    private double bonusBudget;
    private TechnicalLead currSupp;

    //To get the name of the Accountant.
    public Accountant(String name){

        super(name);
    }

    //To check if the Accountant is currently supporting any team.
    public TechnicalLead getTeamSupported(){

        return this.currSupp;
    }

    //To get the budget of the accountant that they are currently supporting.
    public void supportTeam(TechnicalLead lead){
        this.currSupp = lead;
        bonusBudget += lead.team.size() * (lead.getBaseSalary()/1.3)*1.1;
    }

    //To check if there is still room for the budget.
    public boolean approveBonus(double bonus){
        if (bonus > this.bonusBudget){
            this.bonusBudget -= bonus;
            return false;
        }
        else {
            return true;
        }
    }
    //Override from base class (Employee Class)
    public String employeeStatus(){
        double currBudget = this.bonusBudget;
        String currBudgetAsString = String.format("%,.2f", currBudget);
        if (!(currSupp == null)){
            String stat = "\t" + super.getEmployeeID() + " " + super.getName() + " with a budget of $" + currBudgetAsString + " is supporting " + currSupp.getName() + ". \n" ;
            return stat;
        }
        else {
            String stat = "\t" + super.getEmployeeID() + " " + super.getName() + " with a budget of $" + currBudgetAsString + " is currently not supporting anyone." ;
            return stat;
        }
    }
}
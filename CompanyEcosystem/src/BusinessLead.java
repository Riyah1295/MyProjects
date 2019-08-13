import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {
    private double baseSalary;
    private int headCount = 10;
    private ArrayList<Accountant> team = new ArrayList<>();
    private double bonusBudget;

    public BusinessLead(String name){

        super(name);
        this.baseSalary = getBaseSalary() * 2;
    }
    public boolean hasHeadCount(){
        if (team.size() < this.headCount){
            return true;
        }
        else {
            return false;
        }

    }
    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        if (hasHeadCount()){
            this.team.add(e);
            this.bonusBudget = this.bonusBudget + (e.getBaseSalary() + (e.getBaseSalary() * 1.1));
            e.supportTeam(supportTeam);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean requestBonus(Employee e, double bonus){
        if (bonus < this.bonusBudget){
            this.bonusBudget = this.bonusBudget - bonus;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean approveBonus(Employee e, double bonus){
        for (Accountant acc:team){
            if (acc.getTeamSupported().equals(e.getManager())){
                if (acc.approveBonus(bonus)){
                    return true;
                }
            }
        }
        return false;
    }
    public String getTeamStatus(){
        double currBudget = this.bonusBudget;
        String currBudgetAsString = String.format("%,.2f", currBudget);
        String outputTeam = this.ID + " " + this.getName() + " with a budget of $" + currBudgetAsString + " and is managing: \n";
        for (Accountant e:this.team){
            outputTeam += e.employeeStatus();
        }
        return outputTeam;
    }
}
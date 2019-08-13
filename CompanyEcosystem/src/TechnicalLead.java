import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    private int headCount = 4;
    private double baseSalary;
    public ArrayList<SoftwareEngineer> team = new ArrayList<>();
    private int totalCheckIns;

    public TechnicalLead(String name) {
        super(name);
        this.baseSalary = super.getBaseSalary() * 1.3;
    }

    @Override
    public double getBaseSalary(){
        return this.baseSalary;
    }

    //To count whether there are members in the team.
    public boolean hasHeadCOunt() {
        if (team.size() < this.headCount) {
            return true;
        } else {
            return false;
        }
    }

    //Link to TechnicalLead
    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCOunt()) {
            team.add(e);
            e.manager = this;
            return true;
        } else {
            return false;
        }
    }

    //To calculate the total check ins of the approved check ins.
    public boolean approveCheckIn(SoftwareEngineer e) {
        if ((team.contains(e)) && (e.getCodeAccess())) {
            this.totalCheckIns++;
            return true;
        } else {
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus) {

        return false;
    }

    public String getTeamStatus() {
        String outputTeam = this.ID + " " + this.getName() + " has " + this.totalCheckIns + " successful check ins in total, and is managing: \n";
        for (SoftwareEngineer e : this.team) {
            outputTeam += e.employeeStatus();

        }
        return outputTeam;
    }
}
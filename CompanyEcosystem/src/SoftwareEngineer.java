public class SoftwareEngineer extends TechnicalEmployee {
    private boolean codeAccess;

    //To get the name of the SoftwareEngineer.
    public SoftwareEngineer(String name){

        super(name);
    }

    //To check if the SoftwareEngineer have access to make changes to the code base.
    public boolean getCodeAccess() {

        return this.codeAccess;
    }

    //To check if the SoftwareEngineer could update the code changes.
    public void setCodeAccess(boolean access) {

            this.codeAccess = access;
    }

    //To return the current count of successfully checked in code the SoftwareEngineer has.
    public int getSuccessfulCheckIns(){
        super.checkIns++;
        return checkIns;
    }

    //To check if SoftwareEngineer's manager approves of their check in.
    //If approve, the check ins should be updated & return true.
    //If not approve, codes access should be false and this method return false.
    public boolean checkInCode(){
        TechnicalLead manager = (TechnicalLead)this.manager;
        if (manager.approveCheckIn(this)){
            super.checkIns++;
            return true;
        }
        else {
            if (codeAccess){
                codeAccess = false;
            }
            return false;
        }
    }
}
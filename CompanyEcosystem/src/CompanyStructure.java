public class CompanyStructure {
    public static void main(String[] args) {
        TechnicalLead CTO = new TechnicalLead("Satya Nadella");
        SoftwareEngineer seA = new SoftwareEngineer("Kasey");
        SoftwareEngineer seB = new SoftwareEngineer("Breana");
        SoftwareEngineer seC = new SoftwareEngineer("Eric");

        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);

        //To check the name of their manager.
        //System.out.println(seA.manager.name);

        //To check if they have code access.
        CTO.approveCheckIn(seA);
        CTO.approveCheckIn(seB);
        CTO.approveCheckIn(seC);
        seA.setCodeAccess(true);
        seB.setCodeAccess(true);
        seC.setCodeAccess(true);

        seA.checkInCode();
        seA.checkInCode();
        seA.checkInCode();
        seA.checkInCode();
        seB.checkInCode();
        seC.checkInCode();
        seC.checkInCode();

        System.out.println(CTO.getTeamStatus());

        TechnicalLead VPofENG = new TechnicalLead("Bill Gates");
        SoftwareEngineer seD = new SoftwareEngineer("Winter");
        SoftwareEngineer seE = new SoftwareEngineer("Libby");
        SoftwareEngineer seF = new SoftwareEngineer("Gizan");
        SoftwareEngineer seG = new SoftwareEngineer("Zaynah");

        VPofENG.addReport(seD);
        VPofENG.addReport(seE);
        VPofENG.addReport(seF);
        VPofENG.addReport(seG);

        VPofENG.approveCheckIn(seD);
        VPofENG.approveCheckIn(seE);
        VPofENG.approveCheckIn(seF);
        VPofENG.approveCheckIn(seG);
        
        seD.setCodeAccess(true);
        seE.setCodeAccess(true);
        seF.setCodeAccess(true);
        seG.setCodeAccess(true);

        seD.checkInCode();
        seD.checkInCode();
        seE.checkInCode();
        seF.checkInCode();
        seF.checkInCode();
        seG.checkInCode();

        System.out.println(VPofENG.getTeamStatus());

        BusinessLead CFO = new BusinessLead("Amy Hood");
        Accountant actA = new Accountant("Niky");
        Accountant actB = new Accountant("Andrew");
        CFO.addReport(actA, CTO);
        CFO.addReport(actB, VPofENG);
        System.out.println(CFO.getTeamStatus());
    }
}
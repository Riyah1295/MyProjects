public class Employee {
    public String name;
    public double salary;
    public static int employeeID; //To increase the employeeID.
    public int ID; //To set individual ID for the employee.
    public String status;
    public Employee manager;

    //To create new employee.
    //Constructor
    public Employee(String name, double baseSalary){
        this.name = name;
        this.salary = baseSalary;
        employeeID++;
        this.ID = employeeID;
        //System.out.println(ID + name);
    }

    //To return the employee's current salary.
    //Method
    public double getBaseSalary(){

        return salary;
    }

    //To return the employee's current name.
    public String getName(){

        return name;
    }

    //To return the employee's ID.
    public int getEmployeeID(){

        return this.ID;
    }

    //To return the employee's manager.
    //Self-referring to itself.
    public Employee getManager(){

    return this.manager;
    }

    //To check if the two employee ID's are the same.
    public boolean equals (Employee other){
        if (this.ID == other.ID){
            return true;
        }
        else {
            return false;
        }
    }

    //To return a string, combination of their name & ID.
    public String toString(){

        return this.ID + " " + this.name;
    }

    //To return the employee's current status.
    public String employeeStatus(){

        return this.status;
    }
}
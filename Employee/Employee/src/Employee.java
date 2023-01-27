public class Employee implements Employees  {
    String name;
    double baseSalary;
    int EmployeeID;
    String Manager;

    public Employee() {
        System.out.println("employee class ordinary constructor");
    }

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double setBaseSalary(double baseSalary) {

        this.baseSalary = baseSalary;
        return baseSalary;
    }

    public int getEmployeeID() {
        for (int i=1;i<EmployeeID;i++){
            EmployeeID ++;
        }
        return setEmployeeID(12);
    }

    public int setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
        return employeeID;
    }

    public Employee getManager() {
        return new Employee(name,EmployeeID);

    }

    public void setManager(String manager) {
        Manager = manager;
    }

    @Override
    public boolean equals(Employee employees) {
        if (this == employees && getEmployeeID()==getEmployeeID())
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", EmployeeID=" + EmployeeID +
                '}';
    }
    public String EmployeeStatus(){
        return "employee name is : "+getName()+"\n"+ " employee id : "+getEmployeeID()+ "\n"+"employee salary : "+ getBaseSalary();
    }
//    public Employee getManager(Employee object){
//        if (getManager()== object.Manager){
//            System.out.println("this is employees manager :");
//        }
//        return object;
//    }
}

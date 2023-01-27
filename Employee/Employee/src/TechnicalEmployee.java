public class TechnicalEmployee  extends Employee{
    private int nochecks;

    public TechnicalEmployee(String name){
        setBaseSalary(75000);

    }

    public int getNochecks() {
        return nochecks;
    }

    public void setNochecks(int nochecks) {
        this.nochecks = nochecks;
    }

//
//    @Override
//    public String getName() {
//        return super.getName();
//    }
//
//    @Override
//    public void setName(String name) {
//        super.setName(name);
//    }
//
    @Override
    public double getBaseSalary() {
        return super.getBaseSalary();
    }
//
//    @Override
//    public double setBaseSalary(double baseSalary) {
//       return super.setBaseSalary(baseSalary);
//    }
//
//    @Override
//    public int getEmployeeID() {
//        return super.getEmployeeID();
//    }
//
//    @Override
//    public int setEmployeeID(int employeeID) {
//        super.setEmployeeID(employeeID);
//        return employeeID;
//    }
//
//    @Override
//    public Employee getManager() {
//        return super.getManager();
//    }
//
//    @Override
//    public void setManager(String manager) {
//        super.setManager(manager);
//    }

    @Override
    public String EmployeeStatus() {
        return super.EmployeeStatus();

    }

    @Override
    public String toString() {
        return "TechnicalEmployee{" +
                "name='" + name + '\'' +
                ", baseSalary=" + baseSalary +
                ", EmployeeID=" + EmployeeID +
                ", nochecks=" + nochecks +
                '}';
    }
}

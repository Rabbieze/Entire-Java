public class BusinessEmployee extends Employee {
    private double budget;

    public double BusinessEmployee(String name) {
        return setBaseSalary(50000.0);
    }
    @Override
    public double getBaseSalary() {
        return super.getBaseSalary();
    }

    @Override
    public double setBaseSalary(double baseSalary) {
       return super.setBaseSalary(baseSalary);

    }
    @Override
    public String EmployeeStatus() {
        return super.EmployeeStatus();
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBudget() {
        double b=baseSalary-budget;
        return b;
    }
}

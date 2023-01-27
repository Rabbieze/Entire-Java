public class Main  {
    public static void main(String[] args) {
        Employee employee=new Employee("ahsan",200000);
        employee.setEmployeeID(12);
        employee.setName("eman");
        employee.setManager("CEO");
        employee.setBaseSalary(100000);
        System.out.println("the name of the employee is :"+employee.getName());
        System.out.println("the id of the employee is :"+employee.getEmployeeID());
        System.out.println("the manager post of the employee is :"+employee.getManager());
        System.out.println("the salary of the employee is : "+employee.getBaseSalary());
        System.out.println("the employee : " + employee.EmployeeStatus());

        System.out.println("------------------------------------------------------------------------------");
        TechnicalEmployee tech=new TechnicalEmployee("zulki");
        tech.setNochecks(12);
        System.out.println("the employee has drawn : " +tech.getNochecks());
        tech.setBaseSalary(75000.0);
        System.out.println("the salary is :"+tech.getBaseSalary());
        tech.setEmployeeID(49);
        System.out.println("the technical employee status is :"+tech.EmployeeStatus());

        System.out.println("------------------------------------------------------------------------------");

        BusinessEmployee businessEmployee=new BusinessEmployee();
        businessEmployee.setName("awais");
        businessEmployee.setEmployeeID(123);
        businessEmployee.setBaseSalary(120000);
        System.out.println("the name of the business employee is :" +businessEmployee.getName());
        System.out.println("the employee id is :" +businessEmployee.getEmployeeID());
        System.out.println("the base salary of the business employee is :" +businessEmployee.getBaseSalary());
        businessEmployee.setBudget(225000.0);
        System.out.println("the name of the employee is =" +businessEmployee.getName()
        +"has budget of = "+ businessEmployee.getBudget());
        System.out.println("-----------------------------------------------------------------------------------");

        Accountant accountant=new Accountant("awais");
        accountant.setRoom(12);
        System.out.println(accountant.getRoom());
        accountant.approveBonus(20000.0);
        accountant.bonusBudget=12000.3;
        accountant.getBonusBudget();
        accountant.approveBonus(10000);
        System.out.println(accountant.getBonusBudget());


        BusinessLeads leads1=new BusinessLeads("waseem");
        leads1.approvebouns("23423423", 50000);
    }
}

public class BusinessLeads extends Employee {

    int head_Count = 10;
    int no_Of_Reports = 0;

    public BusinessLeads(String name) {
        this.name = name;
    }

    @Override
    public double getBaseSalary() {
        new Accountant(baseSalary * 2);
        return 0;
    }

    public boolean hasHeadCount() {
        if (no_Of_Reports < head_Count)
            return true;
        return hasHeadCount();
    }

    public boolean addReport(Accountant ac, TechnicalLeads leads) {

        return addReport(ac, leads);
    }

    public boolean requestBouns(Employee e, double bonus) {
        return requestBouns(e, bonus);
    }

    public boolean approvebouns(String e, double bonus) {
        String str = e;
//        boolean chk = approvebouns(str,2000);
        Accountant a = new Accountant();
        if (a == a.getTeamSupported())
            return approvebouns(str,2000);
        return false;
    }
}
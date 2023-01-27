public class Accountant extends Employee{
    double bonusBudget = 0;
    boolean teamsupported;
    int room;

    public Accountant(double v) { }

    public Accountant() { }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Accountant(String name) {
        bonusBudget = 0;
        teamsupported = false;
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    @Override
    public Employee getManager() {
        return super.getManager();
    }

    public TechnicalLeads getTeamSupported() {
        if (teamsupported == true) {
            System.out.println("account is currently supporting ");
            getManager();
        } else {
            System.out.println((String) null);
        }
        return null;
    }

    public void supportTeam(TechnicalLeads leads){
        double salary = leads.getBaseSalary();
        int bb = (int) (salary + (salary * 0.1));
        this.bonusBudget = bb;
    }

    public boolean approveBonus(double bonusBudget){
        return true;

    }
}

public class SoftwareEngineer extends Employee {
    boolean AccessCode;
    int successfulCheckins;
    int count;
    boolean chk = false;

    public SoftwareEngineer(String name) {
        successfulCheckins=0;
    }

    public boolean getAccessCode() {
        if (!true) {
            return false;
        }
        return AccessCode;
    }

    public void setAccessCode(boolean accessCode) {

        AccessCode = accessCode;
    }

    public int getSuccessfulCheckins() {
        for (int i=0;i>=count;i++){
            return count;
        }
        return successfulCheckins;
    }
    public boolean condtion() {
        if (getManager().equals(getSuccessfulCheckins())) {
            return true;
        }
            return false;
    }
    public boolean isApproved(){
        return chk;
    }
    public void managerApproval(boolean Approve){
        chk = Approve;
    }
    @Override
    public Employee getManager() {
        return super.getManager();
    }

    @Override
    public double getBaseSalary() {
        return super.getBaseSalary();
    }

    public boolean checkInCode(){
        getManager();{
            new SoftwareEngineer(name);
            condtion();
        }
        return true;
        /*
        if(checkInCode())
            count += 1;
        else{
            AccessCode = false;
        }
        return null;
         */
    }
}

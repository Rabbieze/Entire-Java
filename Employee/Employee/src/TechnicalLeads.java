public class TechnicalLeads extends Accountant  {

    String name;
    int headcount;
    double technicalEmp_salary=setBaseSalary(20000.0);
    int directR;

    public TechnicalLeads(String name) {

        super(name);
        this.name = name;
        this.directR = directR;
        headcount=4;
       // baseS=getBaseSalary();
    }

//    public void TechnicalLead(String Name, int DirectR){
//        name = Name;
//        headcount = 4;
//        baseS = 43000;
//        directR = DirectR;
//    }

    public boolean hasHeadCount(){
        if(directR<headcount){
            return true;
        }
        return false;
    }
    public boolean addReport(SoftwareEngineer e){
        return addReport(e);
    }
    public boolean approveCheckin(SoftwareEngineer e){
        return approveCheckin(e);
    }
    public boolean requestBonous(Employee e,double bounus){
        return requestBonous(e,bounus);
    }
    public void salary(){
       // double s=baseS*1.3;
        //System.out.printf("the salary of the technical lead is :"+ s);
    }
    public String getTeamStatus(String str){
        str = EmployeeStatus();
        return str;
    }
}
//class TechnicalLead{
//    String name;
//    int headcount;
//    int baseS;
//    int directR;
//    public TechnicalLead(String Name,int DirectR){
//        name = Name;
//        headcount = 4;
//        baseS = 43000;
//        directR = DirectR;
//    }
//
//    public boolean hasHeadCount(){
//        if(directR<headcount){
//            return true;
//        }
//        return false;
//    }
//}
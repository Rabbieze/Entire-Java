import java.util.Date;

public class Customer {
    String name;
    int CNIC;
    char Gender;
    int phone_number;
    Date dob;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCNIC() {
        return CNIC;
    }

    public void setCNIC(int CNIC) {
        this.CNIC = CNIC;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char gender) {
        Gender = gender;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", CNIC=" + CNIC +
                ", Gender=" + Gender +
                ", phone_number=" + phone_number +
                ", dob=" + dob +
                '}';
    }
}

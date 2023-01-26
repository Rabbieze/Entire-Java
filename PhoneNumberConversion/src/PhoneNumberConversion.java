import java.util.Scanner;

public class PhoneNumberConversion {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Phone Number :");

        String PhoneNumber=s.next();
        String format_PhoneNumber="(";
        format_PhoneNumber +=PhoneNumber.substring(0,3)+ ")";

        format_PhoneNumber +=PhoneNumber.substring(3,6) + "" +PhoneNumber.substring(6);
        System.out.println("The formatted phone number is : " +format_PhoneNumber);
    }
}

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double tax=0;
        System.out.println("enter the salary");
        int income=s.nextInt();

        if (income<=600000){
            System.out.println("tax is " +(int)(tax*100)/100.0);
        } else if (income>=600001 || income<=1200000) {
            System.out.println("tax is " +(int)(2.5*income)/100.0);
        } else if (income>=1200001 ||income<=2400000) {
            System.out.println("tax is " +(int)(12.5*income+15000)/100.0);
        }
        else if (income>=2400001 ||income<=3600000) {
            System.out.println("tax is " +(int)(20.0*income+165000)/100.0);
        }
        else if (income>=3600001 ||income<=6000000) {
            System.out.println("tax is " +(int)(25.0*income+405000)/100.0);
        }
        else if (income>=6000001 ||income<=12000000) {
            System.out.println("tax is " +(int)(32.5*income+1005000)/100.0);
        }
        else if (income>=12000001) {
            System.out.println("tax is " +(int)(35*income+2955000)/100.0);
        }
        else {
            System.out.println("end");
        }
    }
}

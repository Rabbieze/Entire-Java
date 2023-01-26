import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter first number: ");
        double num1=s.nextDouble();
        System.out.println("enter the second number: ");
        double num2=s.nextDouble();
        System.out.println("enter the third number: ");
        double num3=s.nextDouble();
        s.close();
        System.out.println("the average of  " + num1 + ", " + num2  + " and " + num3 + " is " + average(num1 , num2 , num3));
    }
    public static double average(double num1,double num2, double num3){
        return (num1+num2+num3)/3;
    }
}

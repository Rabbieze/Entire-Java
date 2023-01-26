import java.util.Scanner;

public class Rooter {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int start;
        int i;
        System.out.println("enter a positive integer ");
        start=s.nextInt();
        if (start<0){
            System.out.println("error enter a positive number ");
        }
        else {
            for (i=start;i!=0;i--){
                double sqrt=Math.sqrt(start);
                start--;
                System.out.println(sqrt);
            }
        }
    }

}

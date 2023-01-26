import java.util.Scanner;

public class RecursiveTriangle {
    public static void main(String[] args) {
        int numlines = getNumber();
        String pattern = getString();
        printTriangle(numlines, pattern);
    }

    public static void printTriangle(int numlines, String pattern) {
        if (numlines == 0) {
            return;
        } else

        printRowPattern(numlines, pattern);
        System.out.println();
        printTriangle(numlines - 1, pattern);
    }
static  void printRowPattern(int numlines,String pattern){
        if (numlines==0){
            return;
        }
        else {
            System.out.print(pattern);
            printRowPattern(numlines-1, pattern);
        }
}
    public static int getNumber(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of lines (between 1 and 10):");
        return s.nextInt();
    }
    public static  String getString(){
        Scanner s=new Scanner(System.in);
        System.out.println("enter the string");
        return s.next();
    }

}

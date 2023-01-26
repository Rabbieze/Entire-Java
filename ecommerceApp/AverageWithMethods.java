import java.util.Scanner;
public class AverageWithMethods {
    public static String readNumbers() {
        Scanner sc = new Scanner(System.in);
        String in;
        System.out.println("Enter ive to ten numbers, all on one line, and separated by spaces: ");
        in = sc.nextLine();
        return in;
    }
    public static double average(String in) {
        String numbers[] = in.split(" ");
        double sum = 0;
        for (int i=0; i<numbers.length; i++) {
            sum += Double.parseDouble(numbers[i]);
        }
        return sum / numbers.length;
    }
    public static void print(String in, double average) {
        System.out.printf("The average of the numbers %s is %.2f.", in, average);
    }
    public static void main(String[] args) {
        String input = readNumbers();
        double average = average(input);
        print(input, average);

    }

}

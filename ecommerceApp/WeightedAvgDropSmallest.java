import java.util.*;

public class WeightedAvgDropSmallest {

    public static void main(String[] args) {

        System.out.print("Enter 5 to 10 numbers separated by blank spaces: ");

        Scanner keyboard = new Scanner(System.in);

        String strOfNums=keyboard.nextLine();


        List<Double> numsArray=new ArrayList<>();

        Scanner lineOfNums = new Scanner(strOfNums);

        int count=0;

        while (lineOfNums.hasNextDouble()) {

            double curNum = Double.valueOf(lineOfNums.next());

            numsArray.add(count, curNum);

            count++;

        }

// get number of drop from user

        System.out.println("How many numbers should be dropped: ");

        int number=keyboard.nextInt();


        System.out.println("What is the weight: ");

        double weight=keyboard.nextDouble();


        Collections.sort(numsArray, Collections.reverseOrder());

        double[] finalArray=new double[count-number];

        for(int i=0; i<count-number;i++) {

            finalArray[i]=numsArray.get(i);

        }

        double sum=0;


        for (double object : finalArray) {

            sum+=object*weight;

        }
        System.out.println("The weighted average of the numbers is "+(sum/(count-number))+"\n" +

                "when using the data"+ Arrays.toString(finalArray)+"\n" +

                "where "+weight+" is the weight used,\r\n" +

                "and the average is computed after dropping the lowest "+number+" values."+(sum/(count-number)));

    }

}


import java.util.Scanner;

import java.util.ArrayList;

public class Parser {

    public static void main(String[] args) {

        ArrayList<Integer> nums = getInput();

        for (int num : nums) {

            System.out.println(num);

        }

    }

    public static ArrayList<Integer> getInput() {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter numbers separated by commas: ");

        String userInput = in.nextLine();

        String nums[] = userInput.split(", ");

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {

            arr.add(Integer.parseInt(nums[i]));

        }

        return arr;

    }

}

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class WeightedAvgDataAnalyzer {
    public static LinkedList<LinkedList<Double>> inputDataList = new LinkedList<LinkedList<Double>>();//LinkedList to store input data
    public static LinkedList<String> outputDataList = new LinkedList<String>();//LinkedList to store calculated data

    public static void main(String[] args) {
        Scanner userInput = null;// User Input Scanner
        try {
            userInput = new Scanner(System.in);

            while (true) {
                System.out.println("Pleasee Enter Input File Name:");
                String inFileName = userInput.next();
                File file = new File(inFileName);
                if (file.exists()) {
                    readData(inFileName);
                    break;
                } else {
                    System.out.println("File not Found!");
                }
            }
            System.out.println("Pleasee Enter Output File Name:");
            String outFileName = userInput.next();
            calculateWeightedAvg();
            writeFile(outFileName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (userInput != null) {
                    userInput.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void readData(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextDouble()) {
                String line = scanner.nextLine();
                String[] lineArray = line.trim().split("\\s+");
                LinkedList<Double> subDataList = new LinkedList<Double>();
                subDataList.add(Double.parseDouble(lineArray[0]));
                subDataList.add(Double.parseDouble(lineArray[1]));

                for (int i = 2; i < lineArray.length; i++) {
                    subDataList.add(Double.parseDouble(lineArray[i]));
                }
                inputDataList.add(subDataList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void calculateWeightedAvg() {
        try {
            if (inputDataList != null && inputDataList.size() > 0) {
                for (int i = 0; i < inputDataList.size(); i++) {
                    LinkedList<Double> subDataList = inputDataList.get(i);
                    if (subDataList != null && subDataList.size() > 0) {
                        String outputMsg1 = "The weighted average of the numbers is ";
                        String outputMsg2 = " when using the data ";
                        Double weight = subDataList.get(0);
                        Double dropingValue = subDataList.get(1);
                        Double[] dataArry = new Double[subDataList.size() - 2];
                        int dataCount = 0;
                        for (int j = 2; j < subDataList.size(); j++) {
                            outputMsg2 = outputMsg2 + subDataList.get(j) + ", ";
                            dataArry[dataCount] = subDataList.get(j);
                            dataCount++;
                        }
                        outputMsg2 = outputMsg2 + "where " + weight + " is the weight used, and the average " +
                                "is computed after dropping the lowest " + dropingValue + " values.";//Creating output message
                        Arrays.sort(dataArry);
                        double totalWeightedValue = 0;
                        dataCount = 0;
                        for (double k = (int) dataArry.length - 1; k >= dropingValue; k--) {
                            double data = dataArry[(int) k];
                            double weightedValue = data * weight;
                            totalWeightedValue = totalWeightedValue + weightedValue;
                            dataCount++;
                        }
                        double totalWeightedAvg = totalWeightedValue / dataCount;
                        outputDataList.add(outputMsg1 + totalWeightedAvg + outputMsg2);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeFile(String fileName) {

        if (outputDataList != null && outputDataList.size() > 0) {

            try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {

                for (int i = 0; i < outputDataList.size(); i++) {
                    pw.println(outputDataList.get(i));
                }
            } catch (Exception ioe) {
                ioe.printStackTrace();
            }
            System.out.println("Output File Created!");
        }
    }
}


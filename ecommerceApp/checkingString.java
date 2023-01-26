import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class checkingString{

    public static void checkWord(String word) throws Exception {

        if(Character.isLetter(word.charAt(0))){
            return;
        }else{
            throw new Exception("This is not a word");
        }
    }
    public static String getWord() {

        Scanner sc = new Scanner(System.in);
        boolean st = true;
        String word = null;
        while(st){
            System.out.println("Enter a Word : ");
            word = sc.next();
            try{
                checkWord(word);
                st = false;
            }catch(Exception e){
                System.out.println(e);
                st = true;
            }
        }
        sc.close();
        return word;
    }
    public static void writeFile(String[] arrayToWrite, String filename) throws IOException {
        FileWriter fileWordStream = new FileWriter(filename);

        for(int i = 0;i<arrayToWrite.length;i++){
            fileWordStream.write(arrayToWrite[i]+System.lineSeparator());
        }
        fileWordStream.flush();
        fileWordStream.close();

    }
    public static ArrayList readFile(String filename) throws FileNotFoundException, IOException {

        ArrayList<String> words = new ArrayList<>();

        File file = new File(filename);

        if(!file.exists()){
            throw new FileNotFoundException("File not Found");
        }
        Scanner fsc = new Scanner(file);
        while(fsc.hasNextLine()){
            words.add(fsc.nextLine());
        }
        fsc.close();
        return words;
    }
    public static void main(String[] args) {
        String[] testData = {"cat", "dog", "rabbit"};
        ArrayList<String> words = new ArrayList<>();

        String file = "data.txt";
        String word = getWord();
        System.out.println("The word is : "+word);
        try{
            writeFile(testData,file);
            words = readFile(file);

            for(int i = 0;i<words.size();i++){
                System.out.println(words.get(i));
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println("IOException: error occured in input output");
        }

    }
}
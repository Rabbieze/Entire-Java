import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args) {
        int count=0;
        String inputEntry,inputCharacter;
        Scanner s= new Scanner(System.in);
        System.out.println("enter the value of input Entry ");
        inputEntry=s.next();
        System.out.println("enter the input character ");
        inputCharacter=s.next();
        int length=inputCharacter.length();
        System.out.println("length of inputCharacter is " + length);
        if (length !=1){
            System.out.println("sorry the length of input character is not 1");
            System.exit(0);
        }
        else {
            char ch=inputEntry.charAt(inputEntry.indexOf(inputEntry));
            int i=0;
            while (i<inputEntry.length()){
                if (inputEntry.charAt(i)==ch){
                    count=count+1;
                }
                i++;
            }
            System.out.println("there is " + count + "occurrence(s) of" + inputCharacter + "in test");
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class StringSlicer {
    public static void main(String[] args) {
        String user=input();
        ArrayList<Character> characters=new ArrayList<>();
        process(user,characters);
        output(characters);
    }
    public static String input(){
        Scanner s=new Scanner(System.in);
        System.out.println("enter a string");
        String s1=s.nextLine();
        s.close();
        return s1;
    }
    public static void process(String ast,ArrayList charArray){
        for (int i=0;i<ast.length();i++){
            charArray.add(ast.charAt(i));
        }
    }
    public static void output(ArrayList charArray){
        for (int i=0;i<charArray.size();i++){
            System.out.println(charArray.get(i));
        }
    }
}

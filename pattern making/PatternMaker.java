import java.util.Scanner;

public class PatternMaker {
    public static void main(String[] args) {
        int row;
        int column;
        boolean isFirst = true;
        String first;
        String second;
        String separator;

        Scanner input=new Scanner(System.in);

        row=input.nextInt();

        column=input.nextInt();

        first=input.next();

        second=input.next();

        separator=input.next();

        for(int i = 0; i<row; i++)
        {
            for(int j = 0; j<column; j++)
            {

                if(isFirst)
                {
                    System.out.print(first);

                    isFirst=false;

                } else {

                    System.out.print(second);

                    isFirst=true;
                }
                if(j != column)
                    System.out.print(separator);

            }
            System.out.println(" ");
        }
    }
}

import java.util.Scanner;

public class Login {
    String username=null;
    String password=null;

    public Login(){
        System.out.println("Railway Ticket Booking System Using QR Code ");
    }
    Scanner s=new Scanner(System.in);

    public void permit(){
        while (!"count".equals(username)){
            try {
                System.out.println("enter the username");
                username=s.next();
                if (!"count".equals(username)){
                    throw new Exception("Wrong user name");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (!"hotmail@99".equals(password)){
            try {
                System.out.println("enter the password ");
                password=s.next();
                if (!"hotmail@99".equals(password)){
                    throw new Exception("wrong password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

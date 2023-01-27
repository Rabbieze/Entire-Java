public class Main {
    public static void main(String[] args) {
        IDandPassword obj=new IDandPassword();
        obj.getLoginInfo();
        LoginPage loginpage=new LoginPage(obj.getLoginInfo());

    }
}

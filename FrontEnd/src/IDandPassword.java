import java.util.HashMap;

public class IDandPassword {
    HashMap<String,String> logininfo=new HashMap<>();

    IDandPassword(){
        logininfo.put("Ahsan","momi");
        logininfo.put("ahsans","PASSWORD");
        logininfo.put("anonymous","hotmail@99");
    }
    protected HashMap getLoginInfo(){
        return logininfo;
    }
}

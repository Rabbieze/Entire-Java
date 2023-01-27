import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
public class LoginPage implements ActionListener {

    JFrame frame=new JFrame();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("reset");
    JTextField userIDField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JLabel userIDLabel=new JLabel("userID : ");
    JLabel userPasswordLabel=new JLabel("Password : ");
    JLabel messageLabel=new JLabel("a test");
    HashMap<String,String> logininfo=new HashMap<>();


    LoginPage(HashMap<String,String> logininfoOriginal){

        userIDField.setBounds(125,100,200,25);
        passwordField.setBounds(125,150,200,25);
        messageLabel.setBounds(135,250,250,35);
        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);
        loginButton.setBounds(100,150,75,25);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(messageLabel);


        logininfo=logininfoOriginal;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(400,400);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

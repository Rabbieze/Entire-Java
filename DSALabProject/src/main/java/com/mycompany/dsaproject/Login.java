package com.mycompany.dsaproject;
import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Login {
    
    private String password = null, username=null;

    Scanner sc=new Scanner(System.in);

    public void permit(){

        while(!"counter1".equals(username))
        {
            try {
             System.out.print("Enter username: ");
             username=sc.next();
                if(!"counter1".equals(username))
                {
                   throw new Exception("WRONG USER NAME!");
                }
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }

        }

        while (!"netbeans".equals(password))
        {
            try {
                System.out.print("Enter password: ");
                password = sc.next();
                if (!"netbeans".equals(password)) {
                   System.out.println("The password you entered is incorrect");
                    try {
                        File alarm = new File("Alarm.wav");
                        Clip clip = AudioSystem.getClip();
                        clip.open(AudioSystem.getAudioInputStream(alarm));
                        clip.start();
                        Thread.sleep(clip.getMicrosecondLength() / 1000);
                    } catch (Exception e) {

                    }
                    
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}

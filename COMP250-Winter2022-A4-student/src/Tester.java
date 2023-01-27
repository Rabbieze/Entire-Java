import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tester {

    public static void main (String[] args) {

        //Collision detection = the computational problem of detecting the intersection
        //						of two or more objects.

        MyFrame myFrame = new MyFrame();
    }
}

//************************************************************************************
class MyFrame extends JFrame {

    Image image;
    Graphics graphics;
    Boxx player;
    Boxx enemy;
    boolean gameOver;

    MyFrame(){
        player = new Boxx(100,300,50,50,Color.blue);
        enemy = new Boxx(400,300,50,50,Color.red);
        gameOver = false;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setVisible(true);
        this.addKeyListener(new AL());
    }

    public void paint(Graphics g) {
        image = createImage(this.getWidth(),this.getHeight());
        graphics = image.getGraphics();
        g.drawImage(image,0,0,this);

        player.draw(g);
        enemy.draw(g);

        if(gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("MV Boli",Font.PLAIN,45));
            g.drawString("GAME OVER!", 150, 100);
        }
    }

    public void checkCollision() {
        if(player.intersects(enemy)) {
            gameOver = true;
            System.out.println("GAME OVER!");
        }
    }

    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            checkCollision();
            repaint();
        }
    }
}

//**************************************************************************************

 class Boxx extends Rectangle{

    Color color;

    Boxx(int x, int y, int width, int height, Color color){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.color=color;
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            this.y=y-10;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.y=y+10;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.x=x-10;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.x=x+10;
        }
    }
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
}
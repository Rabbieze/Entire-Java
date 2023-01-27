import java.lang.*;

public class Sleep extends Bakery implements Runnable {
    Thread t;
    public void run()
    {
        for (int i = 0; i < 4; i++) {
            System.out.println(
                    Thread.currentThread().getName() + " "
                            + i);
            try {

                Thread.sleep(100);
            }

            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        Thread t = new Thread(new Sleep());

        t.start();

        Thread t2 = new Thread(new Sleep());

        t2.start();
    }
}


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Counter extends Factory implements Runnable
{
    private final MainApp mainApp;
    private final int loopLimit;
    private final String task;

    public Counter
    (MainApp mainApp, int loopLimit, String task)
    {
        super(mainApp,5,null);
        this.mainApp = mainApp;
        this.loopLimit = loopLimit;
        this.task = task;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < loopLimit; i++)
        {
            System.out.println("Factory  " +
                    Thread.currentThread().getName() + " Counter: "
                    + (i + 1) + " Task: " + task);
            mainApp.pause(Math.random());
        }
    }
}
class MainApp
{

    public void startThread()
    {
        ExecutorService taskList =
                Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++)
        {

            taskList.execute((Runnable) new Factory(this, i + 1,
                    "task " + (i + 1)));
        }

        taskList.shutdown();
    }

    public void pause(double seconds)
    {
        try
        {
            Thread.sleep(Math.round(1000.0 * seconds));
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Factory fact=new Factory(null,5,"customer");
        new MainApp().startThread();
    }
}

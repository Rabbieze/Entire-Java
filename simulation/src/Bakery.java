import jdk.internal.jimage.ImageReaderFactory;

import java.util.concurrent.*;

public class Bakery {


    public static void main(String[] args) throws Exception {
        ScheduledExecutorService bakery = Executors.newScheduledThreadPool(3);

        LinkedBlockingQueue<bun> coolingRack = new LinkedBlockingQueue<>(18);
        LinkedBlockingQueue<bun> shelf = new LinkedBlockingQueue<>(10);

        bakery.scheduleAtFixedRate(new Baker(coolingRack), 0, 5, TimeUnit.SECONDS);
        bakery.scheduleAtFixedRate(new Worker(coolingRack, shelf), 0, 1, TimeUnit.SECONDS);

        ExecutorService cus = Executors.newCachedThreadPool();

        bakery.scheduleAtFixedRate(new custGen(cus, shelf), 0, 10, TimeUnit.SECONDS);

    }
}

class custGen implements Runnable {

    ExecutorService cus;
    LinkedBlockingQueue<bun> shelf;

    public custGen(ExecutorService cus, LinkedBlockingQueue<bun> shelf) {
        this.cus = cus;
        this.shelf = shelf;
    }

    @Override
    public void run() {
        cus.submit(new Customer(shelf));
    }


}

class bun {}

class Baker implements Runnable {
    LinkedBlockingQueue<bun> coolingRack;

    public Baker(LinkedBlockingQueue<bun> coolingRack) {
        this.coolingRack = coolingRack;
    }



    @Override
    public void run() {

        for (int i=0; i<12; i ++){
            try{
                coolingRack.put(new bun());
                System.out.println("BAKER: adding new bun to the cooling rack");
                Thread.sleep(5);
            }
            catch (Exception e) {}
        }
    }

}

class Worker implements Runnable {
    LinkedBlockingQueue<bun> coolingRack;
    LinkedBlockingQueue<bun> shelf;

    public Worker(LinkedBlockingQueue<bun> coolingRack, LinkedBlockingQueue<bun> shelf) {
        this.coolingRack = coolingRack;
        this.shelf = shelf;
    }


    @Override
    public void run() {
        for (int i =0; i<4; i++){
            try{
                bun b = coolingRack.take();
                System.out.println("WORKER: removing bun from cooling rack");
                Thread.sleep(5);
                shelf.put(b);
                System.out.println("WORKER: adding bun to shelf");
                Thread.sleep(5);
            }
            catch (Exception e) {}
        }
    }
}

class Customer implements Runnable {

    LinkedBlockingQueue<bun> shelf;

    public Customer(LinkedBlockingQueue<bun> shelf) {
        this.shelf = shelf;
    }


    @Override
    public void run() {
        try {

            System.out.println("Customer: entered the bakery, going to get a bun");
            Thread.sleep(4);
            bun b = shelf.take();
            System.out.println("Customer: got a bun, leaving the bakery");
            Thread.sleep(4);
        }

        catch (Exception e) {
        }
    }
}
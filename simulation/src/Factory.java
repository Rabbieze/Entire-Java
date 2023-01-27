import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.*;

public class Factory {
    public Factory(MainApp mainApp, int i, String s) {
    }

    public static void main(String[] args) {
        ExecutorService factory = Executors.newCachedThreadPool();
        filling f = new filling();
        sealing s = new sealing();
        labeling l = new labeling();

        while (true) {
            can c = new can();
            try{
                f.setC(c); // set the can in filling
                Future<can> filledCan = factory.submit(f);
                System.out.println("CAN STATUS: filled: " + filledCan.get().isFilled);
                System.out.println("CAN STATUS: sealed: " + filledCan.get().isSealed);
                System.out.println("CAN STATUS: labeled: " + filledCan.get().isLabeled);
                System.out.println("");

                s.setC(filledCan.get());
                Future<can> sealedCan = factory.submit(s);
                System.out.println("CAN STATUS: filled: " + sealedCan.get().isFilled);
                System.out.println("CAN STATUS: sealed: " + sealedCan.get().isSealed);
                System.out.println("CAN STATUS: labeled: " + sealedCan.get().isLabeled);
                System.out.println("");

                l.setC(sealedCan.get());

                Future<can> labeledCan = factory.submit(l);
                System.out.println("CAN STATUS: filled: " + labeledCan.get().isFilled);
                System.out.println("CAN STATUS: sealed: " + labeledCan.get().isSealed);
                System.out.println("CAN STATUS: labeled: " + labeledCan.get().isLabeled);
                System.out.println("");
            }

            catch (Exception e) {}
        }

    }
}

class can {
    boolean isFilled = false;
    boolean isSealed = false;
    boolean isLabeled = false;
}

class filling implements Callable<can> {

    can c;

    public void setC(can c) {
        this.c = c;
    }


    @Override
    public can call() throws Exception {
        System.out.println("FILLING SECTION:  received an empty can... processing...");
        c.isFilled = true;
        Thread.sleep(2);
        System.out.println("FILLING SECTION: empty can is now filled!!");
        return c;
    }


}

class sealing implements Callable<can> {

    can c;

    public void setC(can c) {
        this.c = c;
    }




    @Override
    public can call() throws Exception {
        System.out.println("SEALING SECTION:  received a filled can... processing...");
        c.isSealed = true;
        Thread.sleep(3);
        System.out.println("SEALING SECTION: filled can is now sealed!!");
        return c;
    }


}

class labeling implements Callable<can> {

    can c;

    public void setC(can c) {
        this.c = c;
    }


    @Override
    public can call() throws Exception {
        System.out.println("LABELING SECTION: received a sealed can... processing...");
        c.isLabeled = true;
        Thread.sleep(2);
        System.out.println("LABELING SECTION: sealed can is now labeled!!");
        return c;
    }
}



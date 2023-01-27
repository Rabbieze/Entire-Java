public class ThreadTest  extends Thread {
    public void run() {
        try {
            System.out.println("thread" + Thread.currentThread().getId()
                    + "is running");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("we have found an exception ! fix it ");
        }
    }

    public static void main(String[] args) {
        int n=5;
        for (int i=0;i<n; i++){
            ThreadTest obj=new ThreadTest();
            obj.run();
        }
    }
}
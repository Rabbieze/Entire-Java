public class Join implements Runnable {
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("Current thread: "
                + t.getName());

        // checks if current thread is alive
        System.out.println("Is Alive? " + t.isAlive());
    }

    public static void main(String args[]) throws Exception {
        Thread t = new Thread(new Join());
        t.start();

        t.join(10);

        System.out.println("\nJoining after 10"
                + " milliseconds: \n");
        System.out.println("Current thread: "
                + t.getName());

        // Checks if this thread is alive
        System.out.println("Is alive? " + t.isAlive());
    }
}

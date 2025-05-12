package threads_3;

import java.util.Date;

public class myObjectWithRunnableInterface implements Runnable {
    private boolean isRunning = true;
   private final static Object lockObject = new Object();

    public void requestShutdown() {
        isRunning = false;
    }

    @Override
    public void run() {
        // while(isRunning == true){
        while (Thread.currentThread().isInterrupted() == false) {
            Date d = new Date();

            //warte darauf dass
            //ich als Thread alleine Zugriff auf "mySyncObj"
            // habe
            synchronized (lockObject) {
                System.out.println(Thread.currentThread().getName() +
                        " " + d+ " [");
                System.out.print(", CPUS: ");
                System.out.print(Runtime.getRuntime().availableProcessors());
                System.out.print(", FreeMem: ");
                System.out.print(Runtime.getRuntime().freeMemory());
                System.out.println("]");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("MyThread: my sleep " +
                        "has been disturbed.");
                break;
            }
        }
        System.out.println("MyThread: shutting down.");
    }
}


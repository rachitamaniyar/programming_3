package threads_1;

public class Main implements Runnable{
    public void run() {
        System.out.println("This code is running in a thread");
    }
    public static void main(String[] args) throws InterruptedException {
        Main obj = new Main();
        Thread thread1 = new Thread(obj);
        Thread thread2 = new Thread(obj);
        thread1.start();
        System.out.println("Hello, my name is"+" "+Thread.currentThread().getName());
        thread2.start();
        System.out.println("Hello, my name is"+" "+Thread.currentThread().getName());
        thread2.join(1000);
        thread2.interrupt();
        System.out.println("Thread 2 is interrupted? "+thread2.isInterrupted());
}
}

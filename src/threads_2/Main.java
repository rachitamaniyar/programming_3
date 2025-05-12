package threads_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClockRunnable clock = new ClockRunnable();
        Thread t = new Thread(clock);
        // Wait for user input to stop
        Scanner sc = new Scanner(System.in);
        System.out.println("Press Enter to stop.");
        t.start();
        sc.nextLine();
        // Politely request shutdown
        clock.requestShutDown();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopped.");
    }
}

package threads_2;

import java.util.Date;

class ClockRunnable implements Runnable {
    private boolean isRunning = true;

    public void requestShutDown() {
        isRunning = false;
    }
    @Override
    public void run() {
        while (isRunning) {
            Date d = new Date();
            System.out.println(d.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Ignore
            }
        }
    }
}

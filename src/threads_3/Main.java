package threads_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

        //erstelle ein eindeutiges Objekt, das zur synchronisation verwendet werden kann
        Object mySyncObjFromMain = new Object();

        myObjectWithRunnableInterface mowri1 = new myObjectWithRunnableInterface();
        myObjectWithRunnableInterface mowri2 = new myObjectWithRunnableInterface();

        //gebe das sync-Objekt an beide Thread-Objekte,
        //damit sie nicht gleich
        //zeitig in die kritische Sektion
        //gehen, sondern warten
        mowri1.mySyncObj = mySyncObjFromMain;
        mowri2.mySyncObj = mySyncObjFromMain;

        Thread myThread = new Thread(mowri1);
        Thread myThread2 = new Thread(mowri2);
        myThread.start();
        myThread2.start();

        //auf tastendruck warten
        Scanner scanner = new Scanner(System.in);
        String enterKey = scanner.nextLine(); //warte hier
        if(enterKey.isEmpty())
        {
            System.out.println("Main: requesting Shutdown.");
            //Version 1: eigene Funktion
            //mowri.requestShutdown();
            //Version 2: eingebaute intterupt() Funktion
            myThread.interrupt();
            myThread2.interrupt();
        }
//        myThread.join(); // warte auf Beenden von myThread
        System.out.println("Main: terminating.");
    }
}

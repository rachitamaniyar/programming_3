package exception_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class uebung8 {
    /*
    Schreiben Sie ein Programm, das zeilenweise Tastatureingaben
    auf die Konsole schreibt, bis das Wort „STOP“ eingegeben wird.
    Verwenden Sie dazu den InputStream System.in
    Verwenden Sie weiters die Klassen: InputStreamReader und BufferedReader
     */

    public static void main(String[] args) {
        // Ready to receive user Input
        System.out.println("Übung 8 mit exceptions.");
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);

            // legt einen BufferedReader über den InputStreamReader.
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
try{
    String line = bufferedReader.readLine();
    //in order to add an exception below, if is needed otherwise the program does not run
    // because the if next to the if below will never reach "Unreachable"
//    if (true)
    //This is added to test the catch clause below.
//        throw new IOException("my new exception.");
    if (line == null) {
        System.err.println("Maybe ctrl+d pressed. The program will end.");
        return;
    }
            // Zeile für Zeile wird eingelesen.
            while (!line.equals("STOP")) {
                System.out.println(line);
            }
            System.out.println("Closed");
        } catch (IOException e) {
            System.err.println("Error: IO Exception, Stacktrace.");
        e.printStackTrace();
        }
        finally {
            try {
                bufferedReader.close();
                //Exception chaining here. an exception in another exception.
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

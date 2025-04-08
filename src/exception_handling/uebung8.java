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

            // Zeile für Zeile wird eingelesen.
        try {
            String line;
            while (!(line = bufferedReader.readLine()).equals("STOP")) {
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
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // BR wird wird geschlossen
        // Information, dass das Programm vorbei ist.

    }
}

package netzwerk_1;

import java.io.*;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        String path = "C:\\Users\\rachi\\OneDrive - University of Manitoba\\Desktop\\";
//        File file1 = new File(path+" content.html");
//        file1.createNewFile();
//        Scanner sc = new Scanner(System.in);
//        BufferedWriter bwr = new BufferedWriter(new FileWriter("url.txt"));
//        System.out.println("Enter a URL here");
//        String urlString = sc.nextLine();
//        bwr.write(urlString);
            URL url = new URL(new File("url.txt").toURI().toURL().toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter bw = new BufferedWriter(new FileWriter("content.html"));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage()+" wrong url.");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

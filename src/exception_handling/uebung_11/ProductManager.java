package exception_handling.uebung_11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    List<Product> productList = new ArrayList<>();

    public void add(Product p) {
        productList.add(p);
    }

    public boolean saveToFile(String filepath) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(filepath);
            FileWriter fileWriter = new FileWriter(file);

            bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p : productList) {
                bufferedWriter.write(p.toString());
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            System.err.println("File path not found " + filepath);
            return false;

        } finally {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Product Information successfully saved.");
            return true;
        }
    }

    public void readFromFile(String filepath) {
        try {
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Product Information successfully read.");
        } catch (Exception e) {
            System.err.println("File path not found " + filepath);
        }
    }


}


package exception_handling.retirement;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person(75, "Prakash");
        Scanner sc = new Scanner(System.in);
        boolean correctAge = false;
        do {
        try {
            System.out.println("Enter age: ");
            int age = sc.nextInt();
            p1.setAge(age);
            correctAge = true;
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            sc.nextLine(); //To avoid an endless loop.
        } catch (ZAMException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (NoSuchElementException e){
            System.err.println("Error: ctrl+D pressed. The program will exit. " + e.getMessage());
            return;
        } catch (Exception e) {
            System.err.println("Unknown error: "+ e.getClass());
            System.err.println("Program terminated.");
            return;
        }

        }while (!correctAge);
        System.out.println("Age is " + p1.getAge() + " .Age saved successfully!");
        System.out.println("Program terminated.");
        sc.close();
//            finally{
//                sc.close();
//            }
//
//            sc.close();
//             finally {
//                try {
//                    if (sc.hasNextInt()) {
//                        sc.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
    }

}

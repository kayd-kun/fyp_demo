// Import the JavaWylie package.
import org.rigpa.wylie.Wylie;
import java.util.Scanner;

// Import file handling packages.
import java.io.File;
import java.io.IOException;

public class Dzo_Wylie {
    public static void main(String[] args) {
        // Get the Wylie conversion Object
        Wylie wl = new Wylie();

        // Get the input filename
        String input_file = args[0];
        System.out.println("argument = " + input_file);
        input_file = "input.txt";
        convert(input_file, wl);

        // Write the result to a file:
        /*try {
            File file = new File("result.txt");
            java.io.PrintWriter output = new java.io.PrintWriter(file);
            System.out.println(result);
            output.println(result);
            System.out.println("1");
            output.close();
        } catch (IOException ex) {
            System.out.println("0");
            System.out.println("Error writing to file.");
            ex.printStackTrace();
        } */

    }

    // define a new function and save it to output.txt file
    static void convert(String input_file, Wylie wl) {
        // Read the input file
        try {
            File file = new File(input_file);
            // The result file:
            File output_file = new File("output.txt");
            Scanner input = new Scanner(file);
            java.io.PrintWriter output = new java.io.PrintWriter(output_file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String result = wl.toWylie(line, null, true);
                // Save the result to the output file
                output.println(result);
                System.out.println(result);
            }
            input.close();
            output.close();
        } catch (IOException ex) {
            System.out.println("Error reading from file.");
            ex.printStackTrace();
        }
    }
}
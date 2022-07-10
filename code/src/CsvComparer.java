import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvComparer {

    public static void main(String[] args) {
//        Scanner userInput = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter File 1 : ");
//        // Add a check for file avaliability
//
//        String filepath1 = userInput.nextLine();

        try {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            ArrayList file1 = CsvUtils.readCSV("\\\\wsl$\\Ubuntu-20.04\\home\\yk09\\Code\\Github\\sch\\Java-Data-Reconcillation\\code/src/csv-files/sample_file_1.csv");
            System.out.println(file1);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

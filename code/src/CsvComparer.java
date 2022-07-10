import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CsvComparer {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter File 1 : ");
//        // Add a check for file avaliability
//
        String filepath1 = userInput.nextLine();

        try {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            HashMap file1 = CsvUtils.readFirstCSV("C:\\Users\\Yk\\Documents\\GitHub\\Java-Data-Reconcillation\\code\\src\\csv-files\\sample_file_1.csv");
//            System.out.println(file1);
            ArrayList<ArrayList<String>> differences = CsvUtils.compareCSV("C:\\Users\\Yk\\Documents\\GitHub\\Java-Data-Reconcillation\\code\\src\\csv-files\\sample_file_3.csv",file1);
            System.out.println(differences);
            String csvFile = "C:\\Users\\Yk\\Documents\\GitHub\\Java-Data-Reconcillation\\code\\src\\csv-files\\compare_1_3.csv";
            CsvUtils.writeCSV(differences,csvFile);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

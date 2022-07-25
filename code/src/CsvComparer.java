import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CsvComparer {

    public static void main(String[] args) {
        String filepath1 = CsvUtils.inputFilePath(1);
        String filepath2 = CsvUtils.inputFilePath(2);

        try {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            HashMap<String, ArrayList<String>> file1 = CsvUtils.readFirstCSV(filepath1);
            ArrayList<ArrayList<String>> differences = CsvUtils.compareCSV(filepath2, file1);
            System.out.println(differences);

            // get current working directory /src/csv-files
            String csvFileString = System.getProperty("user.dir") + "/code/src/csv-files/compare.csv";
        
            CsvUtils.writeCSV(differences, csvFileString);
        } catch (IOException e) {
            System.out.println("Error Proceeding, please try again!");
            e.printStackTrace();
        }
    }
}

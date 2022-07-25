import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CsvUtils {

    /**
     * Reads and returns CSV in array format
     * 
     * @param filename String filename
     * @return ArrayList CSV
     */
    public static HashMap<String, ArrayList<String>> readFirstCSV(String filename) throws IOException {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        BufferedReader CSVFile1 = new BufferedReader(new FileReader(filename));
        String dataRow1 = CSVFile1.readLine(); // skip header
        dataRow1 = CSVFile1.readLine();

        while (dataRow1 != null) {
            String[] dataArray1 = dataRow1.split(",");
            String key = dataArray1[0].replace("\"", "");
            ArrayList data = new ArrayList();
            for (int i = 0; i < dataArray1.length; i++) {
                data.add(dataArray1[i].replace("\"", ""));
            }
            hashMap.put(key, data);

            dataRow1 = CSVFile1.readLine(); // Read next line of data.
        }

        CSVFile1.close();
        return hashMap;
    }

    public static ArrayList<ArrayList<String>> compareCSV(String filename, HashMap<String, ArrayList<String>> hashMap)
            throws IOException {
        BufferedReader CsvFile2 = new BufferedReader(new FileReader(filename));
        String dataRow1 = CsvFile2.readLine(); // skip header
        dataRow1 = CsvFile2.readLine();

        // Stores the difference in an array list
        ArrayList<ArrayList<String>> difference = new ArrayList<>();
        while (dataRow1 != null) {
            String[] dataArray = dataRow1.split(",");
            String key = dataArray[0].replace("\"", "");
            ArrayList<String> data = new ArrayList<>();
            for (String s : dataArray) {
                data.add(s.replace("\"", ""));
            }
            // compare the datahow to com from hashmap with data
            ArrayList<String> data1 = hashMap.get(key);
            if (!data1.equals(data)) {
                difference.add(data);
                difference.add(data1);
            }

            dataRow1 = CsvFile2.readLine(); // Read next line of data.
        }

        return difference;

    }

    public static void writeCSV(ArrayList<ArrayList<String>> array, String filename) {
        // create and write the array to a csv file
        
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filename));
            for (ArrayList<String> array1 : array) {
                for (String s : array1) {
                    writer.write(s);
                    writer.write(",");
                }
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String inputFilePath(int fileNumber) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter File " + fileNumber + " : ");

        // Take input from user
        String filepath = input.nextLine();

        // Error Handling for input using checkCsvFilePath()
        if (!checkCsvFilePath(filepath)) {
            System.out.println("Error Proceeding, please try again!");
            inputFilePath(fileNumber);
        }
        // close input
//        input.close();

        return filepath;

    }

    public static boolean checkCsvFilePath(String filePath) {
        // check if the file is a csv file

        // If it does not end with .csv, return false
        if (!filePath.endsWith(".csv")) {
            return false;
        }

        // if file does not exist, return false
        FileReader fr = null;
        try {
            fr = new FileReader(filePath);
        } catch (IOException e) {
            return false;
        } finally {
            try {
                fr.close();
            } catch (IOException | NullPointerException e) {
                return false;
            }
        }
        return true;

    }

    public static boolean checkCsvFormat() {
        return false;
    }
}

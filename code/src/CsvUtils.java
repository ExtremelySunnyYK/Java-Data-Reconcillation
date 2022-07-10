import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CsvUtils {

    /**
     * Reads and returns CSV in array format
     * @param  filename String filename
     * @return ArrayList CSV
     */
    public static HashMap<String,ArrayList<String>> readFirstCSV(String filename) throws IOException {
        HashMap<String,ArrayList<String>> hashMap=new HashMap<>();
        BufferedReader CSVFile1 = new BufferedReader(new FileReader(filename));
        String dataRow1 = CSVFile1.readLine(); // skip header
        dataRow1 = CSVFile1.readLine();

        while (dataRow1 != null)
        {
            String[] dataArray1 = dataRow1.split(",");
            String key = dataArray1[0].replace("\"","");
            ArrayList data = new ArrayList();
            for (int i = 1; i < dataArray1.length; i++){
                data.add(dataArray1[i].replace("\"",""));
            }
            hashMap.put(key,data);

            dataRow1 = CSVFile1.readLine(); // Read next line of data.
        }

        CSVFile1.close();
        return hashMap;
    }

    public static ArrayList<ArrayList<String>> compareCSV(String filename, HashMap<String,ArrayList<String>> hashMap) throws IOException {
        BufferedReader CSVFile1 = new BufferedReader(new FileReader(filename));
        String dataRow1 = CSVFile1.readLine(); // skip header
        dataRow1 = CSVFile1.readLine();
        ArrayList<ArrayList<String>> difference = new ArrayList<>();
        while (dataRow1 != null) {
            String[] dataArray1 = dataRow1.split(",");
            String key = dataArray1[0].replace("\"","");
            ArrayList<String> data = new ArrayList<>();
            for (int i = 1; i < dataArray1.length; i++) {
                data.add(dataArray1[i].replace("\"",""));
            }
            // compare the data from hashmap with data
            ArrayList<String> data1 = hashMap.get(key);
            if (data1 != data) {
                difference.add(data);
                difference.add(data1);
            }
            
            dataRow1 = CSVFile1.readLine(); // Read next line of data.
        }

        return difference;

    }

    public static void writeCSV(ArrayList<ArrayList<String>> array, String filename){
        // write the array to a csv file
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

    public static boolean checkCsvFormat(){

        return false;
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvUtils {

    /**
     * Reads and returns CSV in array format
     * @param  filename String filename
     * @return ArrayList CSV
     */
    public static ArrayList readCSV(String filename) throws IOException {
        ArrayList al1=new ArrayList();
        BufferedReader CSVFile1 = new BufferedReader(new FileReader(filename));
        String dataRow1 = CSVFile1.readLine();
        while (dataRow1 != null)
        {
            String[] dataArray1 = dataRow1.split(",");
            for (String item1:dataArray1)
            {
                al1.add(item1);
            }

            dataRow1 = CSVFile1.readLine(); // Read next line of data.
        }

        CSVFile1.close();
        return al1;
    }

    public static boolean checkCsvFormat(){

        return false;
    }
}

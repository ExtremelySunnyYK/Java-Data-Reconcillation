import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestCsvUtils {
    // UNIT Tests

    // CSV File Path
    @Test
    void testCheckCsvFilePath_ValidCsvPath_ShouldPass() {
        String filePath1 = System.getProperty("user.dir") + "/code/src/csv-files/sample_file_3.csv";
        assertTrue(CsvUtils.checkCsvFilePath(filePath1));
        String filePath2 = System.getProperty("user.dir") + "/code/src/csv-files/sample_file_1.csv";
        assertTrue(CsvUtils.checkCsvFilePath(filePath2));
    }

    @Test
    void testCheckCsvFilePath_InvalidCsvPath_ShouldFail() {
        String filePath = System.getProperty("user.dir") + "/code/src/csv-files/sample_file_.csv";
        assertFalse(CsvUtils.checkCsvFilePath(filePath));

        String filePath2 = System.getProperty("user.dir") + "/code/src/csv-files/sample_file_.txt";
        assertFalse(CsvUtils.checkCsvFilePath(filePath2));

        String filePath3 = System.getProperty("user.dir") + "/code/src/csv-files/sample_file_1.xlsx";
        assertFalse(CsvUtils.checkCsvFilePath(filePath3));

        String filePath4 = "Ljava.lang.String;@6293abcc";
        assertFalse(CsvUtils.checkCsvFilePath(filePath4));

    }

    @Test
    void testwriteCSV_ShouldCreateCsv() {

        ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
        ArrayList<String> array1 = new ArrayList<String>();
        array1.add("ID99");
        array1.add("BOS8059799");
        array1.add("SGD");
        array1.add("CURRENT");
        array1.add("208043");
        array.add(array1);
        ArrayList<String> array2 = new ArrayList<String>();
        array2.add("ID99");
        array2.add("BOS8059799");
        array2.add("SGD");
        array2.add("CURRENT");
        array2.add("208045");
        array.add(array2);

        String filePath = System.getProperty("user.dir") + "/code/src/csv-files/sample_file_x.csv";
        CsvUtils.writeCSV(array, filePath);
        assertTrue(CsvUtils.checkCsvFilePath(filePath));        
    }

    @Test
    void testreadFirstCSV_ShouldCreateHashMap() {

        ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
        ArrayList<String> array1 = new ArrayList<String>();
        array1.add("ID99");
        array1.add("BOS8059799");
        array1.add("SGD");
        array1.add("CURRENT");
        array1.add("208043");
        array.add(array1);
        ArrayList<String> array2 = new ArrayList<String>();
        array2.add("ID99");
        array2.add("BOS8059799");
        array2.add("SGD");
        array2.add("CURRENT");
        array2.add("208045");
        array.add(array2);

        String filePath = System.getProperty("user.dir") + "/code/src/csv-files/sample_file_x.csv";
        CsvUtils.writeCSV(array, filePath);
        assertTrue(CsvUtils.checkCsvFilePath(filePath));
    }
    //    readFirstCSV

    @Test
    void testprocessCsvLine_validParams_shouldPass() {
        String line = "ID99,BOS8059799,SGD,CURRENT,208043";
        ArrayList<String> array = CsvUtils.processCsvLine(line);
        assertEquals(5, array.size());
        assertEquals("ID99", array.get(0));
        assertEquals("BOS8059799", array.get(1));
        assertEquals("SGD", array.get(2));
        assertEquals("CURRENT", array.get(3));
        assertEquals("208043", array.get(4));
    }

    @Test
    void testprocessCsvLine_validParams_shouldPass() {
        String line = "ID99,BOS8059799,SGD,Savings,208043";
        ArrayList<String> array = CsvUtils.processCsvLine(line);
        assertEquals(5, array.size());
        assertEquals("ID99", array.get(0));
        assertEquals("BOS8059799", array.get(1));
        assertEquals("SGD", array.get(2));
        assertEquals("Savings", array.get(3));
        assertEquals("208043", array.get(4));
    }

    @Test
    void testprocessCsvLine_invalidParams_shouldFail() {
        String line = "ID99,BOS8059799,SGD,CURRENT,208043,208045";
        // Expect an exception to be thrown
        assertThrows(Exception.class, () -> {
            CsvUtils.processCsvLine(line);
        });
    }
}

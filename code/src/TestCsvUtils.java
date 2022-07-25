import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestCsvUtils {
    // UNIT Tests

    // CSV File Path
    @Test
    void testCheckCsvFilePath_ValidCsvPath_ShouldPass(){
        String filePath1 = System.getProperty("user.dir") + "/code/src/csv-files/sample_file_3.csv";
        assertTrue(CsvUtils.checkCsvFilePath(filePath1));
        String filePath2 = System.getProperty("user.dir") + "/code/src/csv-files/sample_file_1.csv";
        assertTrue(CsvUtils.checkCsvFilePath(filePath2));
    }

    @Test
    void testCheckCsvFilePath_InvalidCsvPath_ShouldFail(){
        String filePath = System.getProperty("user.dir") + "/code/src/csv-files/sample_file_.csv";
        assertFalse(CsvUtils.checkCsvFilePath(filePath));

        String filePath2 = System.getProperty("user.dir") + "/code/src/csv-files/sample_file_.txt";
        assertFalse(CsvUtils.checkCsvFilePath(filePath2));

        String filePath3 = System.getProperty("user.dir") + "/code/src/csv-files/sample_file_1.xlsx";
        assertFalse(CsvUtils.checkCsvFilePath(filePath3));

    }


    // Systems test of reading the CSV Files
    @Test
    @DisplayName("Read CSV Sample 1 and Sample 2 and return exceptions")
    void testReadAndProcessCSV(){

    }
}

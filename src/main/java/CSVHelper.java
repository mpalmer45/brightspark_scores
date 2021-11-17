import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    public static List<String[]> readCsv(File file) throws IOException {
        List<String[]> csvList = new ArrayList<>();

        // load file
        CSVReader reader = new CSVReader(new FileReader(file), ',', '"', 1);

        // load each line as array and place in a list for easy access
        String[] nextCSVLine;
        while((nextCSVLine = reader.readNext()) != null) {
            csvList.add(nextCSVLine);
        }

        return csvList;
    }
}

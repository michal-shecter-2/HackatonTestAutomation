package utilities;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

public class DDT extends CommonOps{
    private static Object[][] data = null;

    @DataProvider(name = "data-provider")
    public static Object[][] createData() {
        getFromCsvData(getExternalData("DDT"));
        return data;
    }

    private static void getFromCsvData(String fileName) {

        try {
            data = new Object[1][4];
            CSVReader reader = new CSVReader(new FileReader(fileName));

            // this will load content into list
            List<String[]> li = reader.readAll();
            System.out.println("Total rows which we have is " + li.size());

            // create Iterator reference
            Iterator<String[]> i1 = li.iterator();

            // Iterate all values
            for (int j = 0 ; i1.hasNext() ; j++) {
                String[] str = i1.next();
                for (int i = 0; i < str.length; i++)
                    data[j][i] =  str[i];

            }

        } catch (Exception fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}

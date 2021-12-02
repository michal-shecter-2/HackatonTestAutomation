package workflow;

import extensions.DBActions;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class DBFlow {

    @Step("returns the data in the cell at coordinates (row,col)")
    public static String getCellData(String row,String col)
    {
        return DBActions.getCell(row,col);
    }

    @Step("Closes the connection")
    public static void close()
    {
        DBActions.closeDB();
    }

    public static List<String> getTestParams()
    {
        List<String> actual = new ArrayList<>();
        actual.add(getCellData("2","responseCode"));
        actual.add(getCellData("2","responseMessage"));
        actual.add(getCellData("3","responseMessage"));
        return actual;
    }
}

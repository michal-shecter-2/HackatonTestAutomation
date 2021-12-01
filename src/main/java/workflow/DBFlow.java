package workflow;

import extensions.DBActions;
import io.qameta.allure.Step;

public class DBFlow {

    private DBActions dbActions;
    private static DBFlow dbFlow;
    public static DBFlow getInstance()
    {
        if (dbFlow == null)
            dbFlow = new DBFlow();
        return dbFlow;
    }

    private DBFlow()
    {
        dbActions = DBActions.getInstance();
    }

    @Step("returns the data in the cell at coordinates (row,col)")
    public String getCellData(String row,String col)
    {
        return dbActions.getCell(row,col);
    }

    @Step("Closes the connection")
    public void close()
    {
        dbActions.close();
    }
}

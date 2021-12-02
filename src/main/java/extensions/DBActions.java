package extensions;

import utilities.CommonOps;


public class DBActions extends CommonOps {

    private static DBActions dbActions;
    public static DBActions getInstance()
    {
        if (dbActions == null)
            dbActions = new DBActions();
        return dbActions;
    }

    private DBActions()
    {

    }

    public static String getRow(String rowNum)
    {
        String query = "select id,name,responseCode,responseMessage from " + db.getTableName() + " where id = " + rowNum;
        return db.getRowData(query);
    }

    public static String getCell(String rowNum,String colNum)
    {
        String query = "select id,name,responseCode,responseMessage from " + db.getTableName() + " where id = " + rowNum;
        return db.getColumnData(query,colNum);
    }

    public static void closeDB()
    {
        db.close();
    }

    public void printDB(){db.printData();}
}

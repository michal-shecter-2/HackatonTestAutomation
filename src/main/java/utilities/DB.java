package utilities;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.*;

public class DB {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String tableName ;
    private final String column0 = "id",column1 = "name",column2 = "responseCode",column3 = "responseMessage";

    private static DB db;//singleton pattern for database
    public static DB getInstance()
    {
        if (db==null)
            db = new DB();
        return db;
    }

    private DB()
    {
        try {
            String driver = getExternalData("Driver");
            String JDBC_URL = getExternalData("URL");
            Class.forName(driver);
            connection = DriverManager.getConnection(JDBC_URL);

            statement = connection.createStatement();
            tableName = getExternalData("TableName");
            if(!isTableExists()) {
                String createTable = "CREATE TABLE " + tableName + " (" + column0 + " int not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " + column1 + " varchar(255), " + column2 + " varchar(255), " + column3 + " varchar(255), PRIMARY KEY (id))";
                executeQuery(createTable);
            }
            String insertData = "insert into grafana (name, responseCode, responseMessage) values ('keys', '200', '1')";
            String insertData1 = "insert into grafana (name, responseCode, responseMessage) values ('create', '200', 'newApiKey')";
            String insertData2 = "insert into grafana (name, responseCode, responseMessage) values ('delete', '200', 'API key deleted')";

            executeQuery(insertData);
            executeQuery(insertData1);
            executeQuery(insertData2);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean isTableExists()
    {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null,null,tableName.toUpperCase(),null);
            if (resultSet.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void executeQuery(String query)
    {
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getRowData(String query)
    {
        try {
            resultSet = statement.executeQuery(query);
            resultSet.next();
            return resultSet.getString(column0) + " " + resultSet.getString(column1) + " " + resultSet.getString(column2) + " " + resultSet.getString(column3);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getColumnData(String query,String columnName)
    {
        try {
            resultSet = statement.executeQuery(query);
            resultSet.next();
            switch (columnName) {
                case column0:
                    return resultSet.getString(column0);
                case column1:
                    return resultSet.getString(column1);
                case column2:
                    return resultSet.getString(column2);
                case column3:
                    return resultSet.getString(column3);
                default:return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTableName()
    {
        return tableName;
    }

    public void printData()
    {
        try{
            resultSet = statement.executeQuery("SELECT * FROM " + tableName);
            while (resultSet.next())
            {
                String result =  resultSet.getString(column0) + resultSet.getString(column1) + resultSet.getString(column2) + resultSet.getString(column3);
                System.out.println("the results: " + result);
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public void close()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getExternalData(String nodeName)
    {
        DocumentBuilder documentBuilder;
        Document doc = null;
        File xmlFile = new File("D:\\Automation\\ness\\Hackathon\\Hackathon\\src\\main\\java\\config.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try{
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            doc = documentBuilder.parse(xmlFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(doc!=null) {
            doc.getDocumentElement().normalize();
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
        else return null;
    }
}

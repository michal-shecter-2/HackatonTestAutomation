package testCase;

import utilities.CommonOps;
import workflow.DBFlow;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

public class DBTest extends CommonOps {

    private DBFlow flow;
    private Verifications verifications;

    public DBTest()
    {
        flow = DBFlow.getInstance();
        verifications = Verifications.getInstance();
    }

    @Test(description = "checks data in cell")
    @Description("checks if a sample of the data in the table is correct")
    private void t1_checkCell()
    {
        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        expected.add("200");
        expected.add("newApiKey");
        expected.add("API key deleted");
        actual.add(flow.getCellData("2","responseCode"));
        actual.add(flow.getCellData("2","responseMessage"));
        actual.add(flow.getCellData("3","responseMessage"));
        verifications.verifyStrings(actual,expected);
        flow.close();
    }


}

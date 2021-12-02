package testCase;

import utilities.CommonOps;
import workflow.DBFlow;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

public class DBTest extends CommonOps {


    @Test(description = "checks data in cell")
    @Description("checks if a sample of the data in the table is correct")
    private void t1_checkCell()
    {
        List<String> expected = new ArrayList<>();
        expected.add("200");
        expected.add("newApiKey");
        expected.add("API key deleted");
        Verifications.verifyStrings(DBFlow.getTestParams(), expected);
        DBFlow.close();
    }


}

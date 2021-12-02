package testCase;

import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflow.AppiumFlow;
import org.testng.annotations.Test;

public class AppiumTest extends CommonOps {

    @Test(description = "testAppium",priority = 1)
    @Description("calculate repayment and verify repayment" )
    public void testAppium01() {
        AppiumFlow.submitDetails("10", "20","20");
        Verifications.verifyText(AppiumFlow.sumRep(),"£.40");
    }
    @Test(description = "testAppium02",priority = 2, dependsOnMethods = {"testAppium01"})
    @Description("verify interest" )
    public void testAppium02() {
        Verifications.verifyText(AppiumFlow.sumInt(), "£.33");
    }
}

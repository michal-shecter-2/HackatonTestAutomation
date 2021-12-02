package testCase;

import utilities.CommonOps;
import workflow.AppiumFlow;
import org.testng.annotations.Test;

public class AppiumTest extends CommonOps {
    @Test
    public void testAppuim() {
        AppiumFlow.submitDetails("10", "20","20");
        softAssertion.assertEquals(AppiumFlow.sumRep(), "£.40");
        softAssertion.assertEquals(AppiumFlow.sumInt(), "£.33");
        softAssertion.assertAll();
    }
}

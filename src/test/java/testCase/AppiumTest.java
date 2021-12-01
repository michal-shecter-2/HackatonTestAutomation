package testCase;

import utilities.CommonOps;
import workflow.Appium;
import org.testng.annotations.Test;

public class AppiumTest extends CommonOps {
    @Test
    public void testAppuim() {
        Appium.submitDetails("10", "20","20");
        softAssertion.assertEquals(Appium.sumRep(), "£.40");
        softAssertion.assertEquals(Appium.sumInt(), "£.33");
        softAssertion.assertAll();
    }
}

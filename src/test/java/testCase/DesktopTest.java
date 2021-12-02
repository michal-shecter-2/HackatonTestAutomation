package testCase;

import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflow.DesktopFlow;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class DesktopTest extends CommonOps {

    @Test (description = "Addition")
    @Description("Verify single digit Addition on Calculator App")
    public void Addition() {
        DesktopFlow.addCalc();
        Verifications.verifyText(DesktopFlow.Results(),"3");
    }
}
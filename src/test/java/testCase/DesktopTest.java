package testCase;

import utilities.CommonOps;
import workflow.DesktopFlow;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class DesktopTest extends CommonOps {

    @Test
    public void Addition() {
        DesktopFlow.addCalc();
        assertEquals("3", DesktopFlow.Results());
    }
}
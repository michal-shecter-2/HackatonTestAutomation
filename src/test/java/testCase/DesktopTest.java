package testCase;

import utilities.CommonOps;
import workflow.Desktop;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class DesktopTest extends CommonOps {
    @BeforeMethod
    public void Clear() {
        Desktop.clearCalc();
    }
    @Test
    public void Addition() {
        Desktop.addCalc();
        assertEquals("3",Desktop.Results());
    }
}
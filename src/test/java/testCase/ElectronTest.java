package testCase;

import utilities.CommonOps;
import workflow.ElectronFlow;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.concurrent.TimeUnit;

public class ElectronTest extends CommonOps {
    @Test(priority = 1)
    public void electronTest01() {
        ElectronFlow.inputTodo(item);
        action.sendKeys(Keys.ENTER).build().perform();
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        assertEquals(ElectronFlow.todoList(),item);
    }
    @Test(priority = 2)
    public void electronTest02() {
        assertEquals( ElectronFlow.allCompleted(),completed);
    }
}

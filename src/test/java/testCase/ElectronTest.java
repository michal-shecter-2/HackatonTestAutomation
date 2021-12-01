package testCase;

import utilities.CommonOps;
import workflow.Electron;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.concurrent.TimeUnit;

public class ElectronTest extends CommonOps {
    @Test()
    public void electronTest01() {
        Electron.inputTodo(item);
        action.sendKeys(Keys.ENTER).build().perform();
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        assertEquals(Electron.todoList(),item);
    }
    @Test()
    public void electronTest02() {
        assertEquals( Electron.allCompleted(),completed);
    }
}

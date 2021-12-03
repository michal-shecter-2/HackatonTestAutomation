package testCase;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflow.ElectronFlow;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.concurrent.TimeUnit;

public class ElectronTest extends CommonOps {
    @Test (description = "electronTest01", priority = 1)
    @Description("Verify todo list")
    public void electronTest01() {
        ElectronFlow.inputTodo(getExternalData("item"));
        UIActions.send();
        Verifications.verifyText(ElectronFlow.todoList(),getExternalData("item"));

    }
    @Test (description = "electronTest02", priority = 2,dependsOnMethods = {"electronTest01"})
    @Description("Verify Toggle all completed")
    public void electronTest02() {
        Verifications.verifyText(ElectronFlow.allCompleted(),getExternalData("completed"));
    }
}

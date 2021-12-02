package workflow;

import extensions.UIActions;
import utilities.CommonOps;
import io.qameta.allure.Step;

public class ElectronFlow extends CommonOps {

    @Step
    public static void inputTodo(String Input) {
      UIActions.SendKeys(ElctronPO.getInput(),Input);
    }

    @Step
    public static String allCompleted() {
        return UIActions.getText(ElctronPO.getAllCompleted());
    }

    @Step
    public static String todoList() {
        return UIActions.getText(ElctronPO.getInputRes());
    }
}

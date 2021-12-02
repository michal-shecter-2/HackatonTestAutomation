package workflow;

import extensions.UIActions;
import utilities.CommonOps;
import io.qameta.allure.Step;

public class DesktopFlow extends CommonOps {
@Step
    public static void clearCalc() {
    UIActions.click(windowsPO.getClear());
    }
    public static void addCalc() {
        UIActions.click(windowsPO.getOne());
        UIActions.click(windowsPO.getPlus());
        UIActions.click(windowsPO.getTwo());
        UIActions.click(windowsPO.getEquals());
    }
    @Step
    public static String Results() {
        return UIActions.getText(windowsPO.getRes()).replace("Display is", "").trim();
    }

}

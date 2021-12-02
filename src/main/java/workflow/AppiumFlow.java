package workflow;

import extensions.UIActions;
import utilities.CommonOps;
import io.qameta.allure.Step;

public class AppiumFlow extends CommonOps {

    @Step
    public static String sumRep() {
        return  UIActions.getText(appuimPO.getRepayment());
    }
    @Step
    public static String sumInt() {
        return UIActions.getText(appuimPO.getInterest());
    }
    @Step
    public static void submitDetails(String term, String rate, String amount) {
        appuimPO.getAmount().sendKeys(amount);
        UIActions.SendKeys(appuimPO.getAmount(),amount);
        UIActions.SendKeys(appuimPO.getTerm(),term);
        UIActions.SendKeys(appuimPO.getRate(),rate);
        UIActions.click(appuimPO.getCalculate());
    }
}

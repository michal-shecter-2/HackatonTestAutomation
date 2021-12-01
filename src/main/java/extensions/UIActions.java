package extensions;

import utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;



public class UIActions extends CommonOps {
    @Step
    public static String getText(WebElement element){
        return element.getText();
    }

    @Step
    public static void SendKeys(WebElement element,String value){
        element.sendKeys(value);
    }
    @Step
    public static void click(WebElement element){
        element.click();
    }

}

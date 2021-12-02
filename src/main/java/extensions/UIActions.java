package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Keys;
import utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


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
    @Step
    public static void send(){
        action.sendKeys(Keys.ENTER).build().perform();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

}

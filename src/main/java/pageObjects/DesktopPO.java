package pageObjects;


import io.appium.java_client.windows.WindowsElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DesktopPO {

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='clearButton']")
    private WebElement clear ;

    @FindBy(how = How.NAME, using = "One")
    private WebElement One ;

    @FindBy(how = How.NAME, using = "Two")
    private WebElement Two ;

    @FindBy(how = How.NAME, using = "Plus")
    private WebElement Plus ;

    @FindBy(how = How.NAME, using = "Equals")
    private WebElement Equals;

    @FindBy(how = How.NAME, using = "Multiply by")
    private WebElement Multiply;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    private WebElement Res ;
    @Step
    public WebElement getClear() {
        return clear;
    }
    @Step
    public WebElement getOne() {
        return One;
    }
    @Step
    public WebElement getTwo() {
        return Two;
    }
    @Step
    public WebElement getPlus() {
        return Plus;
    }
    @Step
    public WebElement getEquals() {
        return Equals;
    }
    @Step
    public WebElement getMultiply() {
        return Multiply;
    }
    @Step
    public WebElement getRes() {
        return Res;
    }
}

package pageObjects;


import io.appium.java_client.windows.WindowsElement;
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

    public WebElement getClear() {
        return clear;
    }

    public WebElement getOne() {
        return One;
    }

    public WebElement getTwo() {
        return Two;
    }

    public WebElement getPlus() {
        return Plus;
    }

    public WebElement getEquals() {
        return Equals;
    }

    public WebElement getMultiply() {
        return Multiply;
    }

    public WebElement getRes() {
        return Res;
    }
}

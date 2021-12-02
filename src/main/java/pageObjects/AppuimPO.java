package pageObjects;

import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AppuimPO {
    @FindBy(how = How.XPATH, using = "//*[@id='etAmount']")
    private WebElement Amount ;

    @FindBy(how = How.XPATH, using = "//*[@id='etTerm']")
    private WebElement Term ;

    @FindBy(how = How.XPATH, using = "//*[@id='etRate']")
    private WebElement Rate ;

    @FindBy(how = How.XPATH, using = "//*[@id='btnCalculate']")
    private WebElement Calculate ;

    @FindBy(how = How.XPATH, using = "//*[@id='tvRepayment']")
    private WebElement Repayment ;

    @FindBy(how = How.XPATH, using = "//*[@id='tvInterestOnly']")
    private WebElement Interest ;
    @Step
    public WebElement getAmount() {
        return Amount;
    }
    @Step
    public WebElement getTerm() {
        return Term;
    }
    @Step
    public WebElement getRate() {
        return Rate;
    }
    @Step
    public WebElement getCalculate() {
        return Calculate;
    }
    @Step
    public WebElement getRepayment() {
        return Repayment;
    }
    @Step
    public WebElement getInterest() {
        return Interest;
    }
}

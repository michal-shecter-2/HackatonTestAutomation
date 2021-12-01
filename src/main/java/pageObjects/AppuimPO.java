package pageObjects;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AppuimPO {
    @FindBy(how = How.XPATH, using = "//*[@id='etAmount']")
    private AndroidElement Amount ;

    @FindBy(how = How.XPATH, using = "//*[@id='etTerm']")
    private AndroidElement Term ;

    @FindBy(how = How.XPATH, using = "//*[@id='etRate']")
    private AndroidElement Rate ;

    @FindBy(how = How.XPATH, using = "//*[@id='btnCalculate']")
    private AndroidElement Calculate ;

    @FindBy(how = How.XPATH, using = "//*[@id='tvRepayment']")
    private AndroidElement Repayment ;

    @FindBy(how = How.XPATH, using = "//*[@id='tvInterest']")
    private AndroidElement Interest ;

    public AndroidElement getAmount() {
        return Amount;
    }

    public AndroidElement getTerm() {
        return Term;
    }

    public AndroidElement getRate() {
        return Rate;
    }

    public AndroidElement getCalculate() {
        return Calculate;
    }

    public AndroidElement getRepayment() {
        return Repayment;
    }

    public AndroidElement getInterest() {
        return Interest;
    }
}

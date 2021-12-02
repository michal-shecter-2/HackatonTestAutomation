package pageObjects;

import io.qameta.allure.Step;
import utilities.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ElectronPO extends Base {
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div[2]/input")
    private WebElement input ;

    @FindBy(how = How.XPATH, using = "//*[@class=\"label_5i8SP\"]")
    private WebElement inputRes ;

    @FindBy(how = How.XPATH, using = "//*[@class=\"allCompletedText_1Vjqr\"]")
    private WebElement allCompleted ;
    @Step
    public WebElement getInput() {
        return input;
    }
    @Step
    public WebElement getInputRes() {
        return inputRes;
    }
    @Step
    public WebElement getAllCompleted() {
        return allCompleted;
    }
}

package pageObjects.WebPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPO  {
    @FindBy(how = How.NAME, using = "user")
    private WebElement username;

    @FindBy(how = How.NAME, using = "password")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[2]/div/div/form/button")
    private WebElement button;

    @FindBy(how = How.CLASS_NAME, using = "css-1tbo7ox-button")
    private WebElement button_skip;

    @FindBy(how = How.CLASS_NAME, using = "css-1aanzv4")
    private WebElement assert_login;

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getButton() {
        return button;
    }

    public WebElement getButton_skip() {
        return button_skip;
    }

    public WebElement getAssert_login() {
        return assert_login;
    }
}

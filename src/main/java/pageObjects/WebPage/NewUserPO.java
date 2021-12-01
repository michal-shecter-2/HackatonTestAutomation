package pageObjects.WebPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewUserPO {

    @FindBy(how = How.XPATH   ,using = "//*[@id=\"reactRoot\"]/div/nav/div[2]/div[7]/a")
    private WebElement button_ServerAdmin;

    @FindBy(how = How.XPATH  ,using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[1]/a/span")
    private WebElement button_NewUser;

    @FindBy(how = How.XPATH  ,using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/form/div[1]/div[2]/div[1]/div/input")
    private WebElement t_newUser;

    @FindBy(how = How.XPATH  ,using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/form/div[2]/div[2]/div/div/input")
    private WebElement t_newEmail;

    @FindBy(how = How.XPATH  ,using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/form/div[3]/div[2]/div/div/input")
    private WebElement t_newUsername;

    @FindBy(how = How.XPATH  ,using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/form/div[4]/div[2]/div/div/input")
    private WebElement t_newPassword;

    @FindBy(how = How.XPATH  ,using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/form/button/span")
    private WebElement CreateNewUser;

    @FindBy(how = How.XPATH  ,using = "//*[@id=\"reactRoot\"]/div/main/div[2]")
    private WebElement checkUsers;

    public WebElement getButton_ServerAdmin() {
        return button_ServerAdmin;
    }

    public WebElement getButton_NewUser() {
        return button_NewUser;
    }

    public WebElement getT_newUser() {
        return t_newUser;
    }

    public WebElement getT_newEmail() {
        return t_newEmail;
    }

    public WebElement getT_newUsername() {
        return t_newUsername;
    }

    public WebElement getT_newPassword() {
        return t_newPassword;
    }

    public WebElement getCreateNewUser() {
        return CreateNewUser;
    }

    public WebElement getCheckUsers() {
        return checkUsers;
    }
}

package pageObjects.WebPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FilteringPO {

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/nav/div[2]/div[6]/a")
    private WebElement definitions;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div/a")
    private WebElement addData;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/div/input")
    private WebElement filter;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[2]/ul/li/div/div[1]/span[1]")
    private WebElement spanMySQL;

    public WebElement getDefinitions() {
        return definitions;
    }

    public WebElement getAddData() {
        return addData;
    }

    public WebElement getFilter() {
        return filter;
    }

    public WebElement getSpanMySQL() {
        return spanMySQL;
    }
}

package testCase;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflow.WebFlow;
import org.junit.Assert;
import org.testng.annotations.Test;
public class WebTest extends CommonOps {

    @Test(priority = 1)
    @Description("Login")
    public void test1_Login(){
        WebFlow.Login();
        Assert.assertEquals(login.getAssert_login().getText(), getExternalData("textWelcome"));
    }
    @Test(priority = 2,dependsOnMethods = "test1_Login")
    @Description("Filter the data base record")
    public void test2_filter(){
        WebFlow.Synchronization(5);
        actions.moveToElement(filtering.getDefinitions());
        WebFlow.Filter();
        Verifications.verifyText((UIActions.getText(filtering.getSpanMySQL())),getExternalData("textFilterResult"));
    }
    @Test(priority = 3,dataProviderClass = utilities.DDT.class,dataProvider="data-provider",dependsOnMethods = "test1_Login")
    @Description("Create a new user")
    public void test3_newUser(String userName,String email,String newName,String password){
        actions.moveToElement(newUser.getButton_ServerAdmin());
        WebFlow.NewUser(userName,email,newName,password);
        WebFlow.Synchronization(3);
        Verifications.verifyDisplayed(newUser.getCheckUsers());
}

@Test(priority = 4, dependsOnMethods = "test1_Login")
    @Description("sikuli")
    public void test4(){
    Assert.assertEquals(WebFlow.Sikuli(),true);
}
}

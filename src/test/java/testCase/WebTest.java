package testCase;

import org.testng.annotations.Parameters;
import utilities.CommonOps;
import workflow.GrafanaWeb;
import org.junit.Assert;
import org.testng.annotations.Test;
public class WebTest extends CommonOps {

    @Test()
    public void test1(){
        GrafanaWeb.Login();
        Assert.assertEquals(login.getAssert_login().getText(), textWelcome);
    }
    @Test
    public void test2(){
        GrafanaWeb.Synchronization(5);
        actions.moveToElement(filtering.getDefinitions());
        GrafanaWeb.Filter();
        Assert.assertEquals(filtering.getSpanMySQL().getText(),textFilterResult);
    }
    @Test(dataProviderClass = utilities.DDT.class,dataProvider="data-provider")
    public void test3(String a,String b,String c,String d){
        actions.moveToElement(newUser.getButton_ServerAdmin());
        GrafanaWeb.NewUser(a,b,c,d);
        GrafanaWeb.Synchronization(3);
       Assert.assertTrue(newUser.getCheckUsers().isDisplayed());
}

//@Test
//    public void test4(){
//    Assert.assertEquals(GrafanaWeb.Sikuli(),true);
//}
}

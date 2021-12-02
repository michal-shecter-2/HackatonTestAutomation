package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.CommonOps;

import java.util.List;

public class Verifications extends CommonOps {

    @Step("verifies int value")
    public static void verifyInt(int actual,int expected)
    {
        Assert.assertEquals(actual,expected);
    }

    public static void verifyStrings(List<String> actual,List<String>expected)
    {
        if (actual.size()!=expected.size())
            Assert.fail("lists sizes don't match");
        SoftAssert softAssert = new SoftAssert();
        for(int i = 0;i<actual.size();i++)
        {
            softAssert.assertEquals(actual.get(i),expected.get(i));
        }
        softAssert.assertAll();
    }

    @Step("verifies isDisplayed")
    public static void verifyDisplayed(WebElement elem)
    {
        Assert.assertTrue(elem.isDisplayed());
    }

    @Step("verifies isDisplayed")
    public static void verifyText(String elem,String text)
    {
        Assert.assertEquals(elem,text);
    }
}

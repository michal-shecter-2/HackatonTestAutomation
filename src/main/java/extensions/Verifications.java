package extensions;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Verifications {

    private static Verifications verifications;

    public static Verifications getInstance()
    {
        if (verifications == null)
            verifications = new Verifications();
        return verifications;
    }
    private Verifications()
    {

    }

    @Step("verifies int value")
    public void verifyInt(int actual,int expected)
    {
        Assert.assertEquals(actual,expected);
    }

    public void verifyStrings(List<String> actual,List<String>expected)
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
}

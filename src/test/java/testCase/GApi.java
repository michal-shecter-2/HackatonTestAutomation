package testCase;

import utilities.CommonOps;
import workflow.ApiFlow;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.HashMap;

public class GApi extends CommonOps {

    private ApiFlow apiFlow;
    private Verifications verifications;

    public GApi()
    {
        apiFlow = ApiFlow.getInstance();
        verifications = Verifications.getInstance();
    }

    @BeforeMethod
    private void setHeaders()
    {
        apiFlow.setHeaders();
    }

    @Test(description = "checks if request for all keys passes")
    @Description("the test verifies that the get request response code is 200")
    private void t1_verifyKeysExist()
    {
        int code = apiFlow.get("/api/auth/keys");
        verifications.verifyInt(code, HttpStatus.SC_OK);
    }

    @Test(description = "creates a new key")
    @Description("verifies that a key was created by the response code")
    private void t2_keyCreator()
    {
        HashMap<String,String>map = new HashMap<>();
        map.put("name","admin " + System.currentTimeMillis());//a unique name is provided each time
        map.put("role","Admin");
        int code = apiFlow.post("/api/auth/keys",map);
        verifications.verifyInt(code,HttpStatus.SC_OK);
    }

    @Test(description = "deletes a key", dependsOnMethods = "t2_keyCreator")
    @Description("deletes the key that was created in t2_keyCreator test")
    private void t3_key_B_Gone()
    {
        int code = apiFlow.delete("/api/auth/keys/" + apiFlow.getNewKey());
        verifications.verifyInt(code,HttpStatus.SC_OK);
    }
}

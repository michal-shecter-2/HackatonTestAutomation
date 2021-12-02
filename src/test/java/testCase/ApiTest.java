package testCase;

import utilities.CommonOps;
import workflow.ApiFlow;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.HashMap;

public class ApiTest extends CommonOps {

    @BeforeMethod
    private void setHeaders()
    {
        ApiFlow.setHeaders();
    }

    @Test(description = "checks if request for all keys passes")
    @Description("the test verifies that the get request response code is 200")
    private void t1_verifyKeysExist()
    {
        int code = ApiFlow.get("/api/auth/keys");
        Verifications.verifyInt(code, HttpStatus.SC_OK);
    }

    @Test(description = "creates a new key")
    @Description("verifies that a key was created by the response code")
    private void t2_keyCreator()
    {
        HashMap<String,String>map = new HashMap<>();
        map.put("name","admin " + System.currentTimeMillis());//a unique name is provided each time
        map.put("role","Admin");
        int code = ApiFlow.post("/api/auth/keys",map);
        Verifications.verifyInt(code,HttpStatus.SC_OK);
    }

    @Test(description = "deletes a key", dependsOnMethods = "t2_keyCreator")
    @Description("deletes the key that was created in t2_keyCreator test")
    private void t3_deleteKey()
    {
        int code = ApiFlow.delete("/api/auth/keys/" + ApiFlow.getNewKey());
        Verifications.verifyInt(code,HttpStatus.SC_OK);
    }
}

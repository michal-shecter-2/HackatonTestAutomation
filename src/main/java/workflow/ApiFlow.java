package workflow;

import utilities.CommonOps;
import extensions.ApiActions;
import io.qameta.allure.Step;

import java.util.HashMap;

public class ApiFlow extends CommonOps {


    @Step("FLOW: sends a get request to grafana asking for all the keys")
    public static int get(String apiLink)
    {
        return ApiActions.get(apiLink);
    }

    @Step("FLOW: sends a post request to grafana to create new Api key")
    public static int post(String apiLink, HashMap<String,String>map)
    {
        return ApiActions.post(apiLink, map);
    }

    @Step("FLOW: sends a delete request to grafana to delete an api key")
    public static int delete(String apiLink)
    {
        return ApiActions.delete(apiLink);
    }

    @Step("FLOW: setting headers")
    public static void setHeaders()
    {
        ApiActions.setHeaders();
    }

    public static String getNewKey()
    {
        return ApiActions.getNewAdminID();
    }
}

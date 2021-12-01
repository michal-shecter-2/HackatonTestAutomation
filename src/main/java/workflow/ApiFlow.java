package workflow;

import utilities.CommonOps;
import extensions.ApiActions;
import io.qameta.allure.Step;

import java.util.HashMap;

public class ApiFlow extends CommonOps {

    private static ApiActions apiActions;
    private static ApiFlow apiFlow;

    public static ApiFlow getInstance()
    {
        if (apiFlow == null)
            apiFlow = new ApiFlow();
        return apiFlow;
    }

    private ApiFlow(){
        apiActions = ApiActions.getInstance();
    }

    @Step("FLOW: sends a get request to grafana asking for all the keys")
    public int get(String apiLink)
    {
        return apiActions.get(apiLink);
    }

    @Step("FLOW: sends a post request to grafana to create new Api key")
    public int post(String apiLink, HashMap<String,String>map)
    {
        return apiActions.post(apiLink, map);
    }

    @Step("FLOW: sends a delete request to grafana to delete an api key")
    public int delete(String apiLink)
    {
        return apiActions.delete(apiLink);
    }

    @Step("FLOW: setting headers")
    public void setHeaders()
    {
        apiActions.setHeaders();
    }

    public String getNewKey()
    {
        return apiActions.getNewAdminID();
    }
}

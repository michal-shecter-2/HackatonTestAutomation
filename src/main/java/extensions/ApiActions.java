package extensions;

import utilities.CommonOps;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import java.util.HashMap;

public class ApiActions extends CommonOps {


    @Step("sends a get request")
    public static int get(String apiLink)
    {
        response = request.get(apiLink);
        response.prettyPrint();
        return response.getStatusCode();
    }

    @Step("send a post request")
    public static int post(String apiLink, HashMap<String,String>map)
    {
        if (map.isEmpty())
            return -1;
        JSONObject params = new JSONObject(map);
        request.body(params);
        response = request.post(apiLink);
        jsonPath = response.jsonPath();
        newAdminID = jsonPath.getString("id");
        return response.getStatusCode();
    }

    @Step("sends a delete request")
    public static int delete(String apiLink)
    {
        response = request.delete(apiLink);
        return response.getStatusCode();
    }

    @Step("set headers for request")
    public static void setHeaders()
    {
        request.headers("Accept","application/json");
        request.headers("Content-Type", "application/json");
        request.headers("Authorization","Bearer " + getExternalData("adminApiKey"));
    }

    public static String getNewAdminID()
    {
        return newAdminID;
    }
}

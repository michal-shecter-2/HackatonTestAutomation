package utilities;

import org.sikuli.script.Screen;
import pageObjects.*;
import pageObjects.WebPage.FilteringPO;
import pageObjects.WebPage.LoginPO;
import pageObjects.WebPage.NewUserPO;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.asserts.SoftAssert;

public class Base {

//Web
    protected static WebDriver driver;
    protected static Actions actions;
   protected static Screen screen;
    protected static LoginPO login;
    protected static FilteringPO filtering;
    protected static NewUserPO newUser;
    protected static String textWelcome="Welcome to Grafana";
    protected static String textFilter="my";
    protected static String textPassword_Username="admin";
    protected static String textFilterResult="MySQL";
    protected static String serverAdmin = "C:\\automation\\Hackathon\\src\\sikuli\\serverAdmin.PNG";
    protected static String orgs = "C:\\automation\\Hackathon\\src\\sikuli\\orgs.PNG";
    protected static String settings = "C:\\automation\\Hackathon\\src\\sikuli\\settings.PNG";
    protected static String plug = "C:\\automation\\Hackathon\\src\\sikuli\\plug.PNG";

    //Windows
    protected static WebDriver windowsDriver;
    protected static DesiredCapabilities capabilities;
    protected static DesktopPO windowsPO;
    protected static String calcApp = "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";

    //Appium
    protected  SoftAssert softAssertion = new SoftAssert();
    protected static AppuimPO appuimPO;
    protected static String reportDirectory = "reports";
    protected static  String reportFormat = "xml";
    protected static String testName = "appuim";
    protected static AndroidDriver<AndroidElement> appuimDriver = null;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //api
    protected static RequestSpecification request;
 protected static Response response;
 protected static String newAdminID;
 protected static JsonPath jsonPath;
 protected static JSONObject params;
 protected static final String adminApiKey = "eyJrIjoiOHozWlpFaUdrYXdnak0ybDNDMDhtdzM4bmp1RXEzcTUiLCJuIjoiQVBJS2V5IiwiaWQiOjF9";
 //db
 protected static DB db;


    //Electron
    //main base
    protected static ElectronPO ElctronPO;
    protected static  Actions action;
    protected static  WebDriver ElectronDriver;
    protected static  ChromeOptions opt;
    protected static  DesiredCapabilities ElctronCapabilities;
    protected static  String item= "test01";
    protected static  String completed= "Toggle all completed";

}

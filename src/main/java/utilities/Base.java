package utilities;

import extensions.Verifications;
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
    protected static Verifications verifications;
    protected static LoginPO login;
    protected static FilteringPO filtering;
    protected static NewUserPO newUser;
    protected static String textWelcome="Welcome to Grafana";
    protected static String textFilter="my";
    protected static String textPassword_Username="admin";
    protected static String textFilterResult="MySQL";
    protected static String serverAdmin = "D:\\Automation\\Hackathon\\sikuli\\serverAdmin.PNG";
    protected static String orgs = "D:\\Automation\\Hackathon\\sikuli\\orgs.PNG";
    protected static String settings = "D:\\Automation\\Hackathon\\sikuli\\settings.PNG";
    protected static String plug = "D:\\Automation\\Hackathon\\sikuli\\plug.PNG";

    //Windows
    protected static WebDriver windowsDriver;
    protected static DesiredCapabilities capabilities;
    protected static DesktopPO windowsPO;
    protected static String calcApp = "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";

    //Appium
    protected static AppuimPO appuimPO;
    protected static AndroidDriver<AndroidElement> appuimDriver = null;
    protected static DesiredCapabilities dc = new DesiredCapabilities();
    protected static String url="http://localhost:4723";
    protected static String app="com.shivgadhia.android.ukMortgageCalc";

    //api
    protected static RequestSpecification request;
    protected static Response response;
    protected static String urlApi = "http://localhost:3000";
    protected static String newAdminID;
    protected static JsonPath jsonPath;
    protected static final String adminApiKey = "eyJrIjoiOHozWlpFaUdrYXdnak0ybDNDMDhtdzM4bmp1RXEzcTUiLCJuIjoiQVBJS2V5IiwiaWQiOjF9";
    //db
    protected static DB db;

    //Electron
    protected static ElectronPO ElctronPO;
    protected static  Actions action;
    protected static  WebDriver ElectronDriver;
    protected static  ChromeOptions opt;
    protected static  DesiredCapabilities ElctronCapabilities;
    protected static  String item= "test01";
    protected static  String completed= "Toggle all completed";
    protected static  String electronExe = "C:\\Hackathon\\electron\\electrondriver.exe";
    protected static  String electronApp="C:\\Users\\bechor\\AppData\\Local\\Programs\\todolist\\Todolist.exe";

}

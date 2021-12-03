package utilities;

import extensions.Verifications;
import io.appium.java_client.AppiumDriver;
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
    //Windows
    protected static WebDriver windowsDriver;
    protected static DesiredCapabilities capabilities;
    protected static DesktopPO windowsPO;


    //Appium
    protected static AppuimPO appuimPO;
    protected static AppiumDriver<?> appuimDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();
    //api
    protected static RequestSpecification request;
    protected static Response response;
    protected static String newAdminID;
    protected static JsonPath jsonPath;
    //db
    protected static DB db;
    //Electron
    protected static ElectronPO ElctronPO;
    protected static  Actions action;
    protected static  WebDriver ElectronDriver;
    protected static  ChromeOptions opt;
    protected static  DesiredCapabilities ElctronCapabilities;
}

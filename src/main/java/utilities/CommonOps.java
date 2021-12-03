package utilities;
import io.qameta.allure.Description;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.w3c.dom.Document;
import pageObjects.*;
import pageObjects.WebPage.FilteringPO;
import pageObjects.WebPage.LoginPO;
import pageObjects.WebPage.NewUserPO;
import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import workflow.DesktopFlow;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {
    @BeforeClass
    @Parameters({"PlatformType", "BrowserType"})
    public void setUp(String platform,String browser)
    {
        if(platform.equals("api"))
            initApi();
        else if(platform.equals("DB"))
            initDB();
        else if(platform.equals("web"))
        {
            initWeb();
        }
        else if(platform.equals("app"))
            try {
                    initAppuim();
                }
                catch (MalformedURLException e){
                    e.printStackTrace();
                }
        else if (platform.equals("el"))
                    initElectrom();
        else if (platform.equals("de"))
            try {
                    initWindows();
                }
               catch (IOException e){
                    e.printStackTrace();
            }
    }
    @Step("Init api")
    protected void initApi()
    {
        RestAssured.baseURI = getExternalData("urlApi");
        request = RestAssured.given();
        request.header("Content-Type","application/json");
    }
    @Step("Init db")
    public void initDB()
    {
        db = DB.getInstance();
    }

    @Step("Init appium driver")
    public void initAppuim() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "12541cf8");
    dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getExternalData("app"));
    dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
    appuimDriver = new AndroidDriver<>(new URL(getExternalData("urlA")), dc);
    appuimPO = PageFactory.initElements(appuimDriver, AppuimPO.class);
    }

    @AfterMethod
    public void tearDown() {
        if (appuimDriver!=null)
        appuimDriver.quit();
    }

    @Step("Init windows driver")
    public void initWindows() throws IOException {
    capabilities = new DesiredCapabilities();
    capabilities.setCapability("app", getExternalData("calcApp"));
    windowsDriver = new WindowsDriver<>(new URL(getExternalData("urlW")), capabilities);
    windowsPO = PageFactory.initElements(windowsDriver, DesktopPO.class);
}
    @BeforeMethod
    public void Clear() {
        if (windowsDriver!=null)
        DesktopFlow.clearCalc();
    }
    @AfterClass
    public void close(){
        if (windowsDriver!=null)
            windowsDriver.quit();
    }

    @Step("Init electron driver")
    public void initElectrom() {
    System.setProperty("webdriver.chrome.driver", getExternalData("electronExe"));
    opt = new ChromeOptions();
    opt.setBinary(getExternalData("electronApp"));
    ElctronCapabilities = new DesiredCapabilities();
    ElctronCapabilities.setCapability("chromeOptions", opt);
    ElctronCapabilities.setBrowserName("chrome");
    opt.merge(ElctronCapabilities);
    ElectronDriver = new ChromeDriver(opt);
    action = new Actions(ElectronDriver);
    Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
    ElctronPO = PageFactory.initElements(ElectronDriver, ElectronPO.class);
    }
    @Step("Init web driver")
    private  void initWeb() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getExternalData("urlApi"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         actions=new Actions(driver);
         screen = new Screen();
        login = PageFactory.initElements(driver, LoginPO.class);
        filtering = PageFactory.initElements(driver, FilteringPO.class);
        newUser = PageFactory.initElements(driver, NewUserPO.class);

    }
    @AfterClass
    public static void closeBrowser() {
        if(driver!=null)
        driver.quit();
    }
    public static String getExternalData(String nodeName)
    {
        DocumentBuilder documentBuilder;
        Document doc = null;
        File xmlFile = new File("C:\\HackatonTestAutomation\\src\\main\\java\\ExternalData.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try{
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            doc = documentBuilder.parse(xmlFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(doc!=null) {
            doc.getDocumentElement().normalize();
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
        else return null;
    }
}

package utilities;
import io.qameta.allure.Description;
import org.testng.annotations.*;
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
        RestAssured.baseURI = urlApi;
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
    dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, app);
    dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
    appuimDriver = new AndroidDriver<>(new URL(url+"/wd/hub"), dc);
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
    capabilities.setCapability("app", calcApp);
    windowsDriver = new WindowsDriver<>(new URL(url), capabilities);
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
    System.setProperty("webdriver.chrome.driver", electronExe);
    opt = new ChromeOptions();
    opt.setBinary(electronApp);
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
        driver.get(urlApi);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         actions=new Actions(driver);
        // screen = new Screen();
        login = PageFactory.initElements(driver, LoginPO.class);
        filtering = PageFactory.initElements(driver, FilteringPO.class);
        newUser = PageFactory.initElements(driver, NewUserPO.class);

    }
    @AfterClass
    public static void closeBrowser() {
        if(driver!=null)
        driver.quit();
    }
}

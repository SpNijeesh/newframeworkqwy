package nijeeshqwy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import io.github.bonigarcia.wdm.WebDriverManager;
import nijeeshqwy.pageobjects.ShopMerchantCategoryPage;
import nijeeshqwy.pageobjects.ShopMerchantInventoryPage;
import nijeeshqwy.pageobjects.ShopMerchantLoginPage;

public class ShopMerchantOverAll{

    private final String user = "9999888999";
    private final String pass = "111111111111111";
    private String filePath = "C:\\Users\\Niju\\Downloads\\HyperSport.jpg";
    private String categorynametorequest = "Cars and Bikes";
    private String expectedurl= "https://stage-shop-merchant.qwqer.in/category";
    public WebDriver driver;
    ShopMerchantLoginPage loginPage;
    ShopMerchantCategoryPage categoryPage;
    ShopMerchantInventoryPage inventorypage;
    ExtentReports extent;
    

    @BeforeTest
    public void setup() throws Throwable {    	
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", "\"C:\\Users\\Niju\\Downloads\\");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        loginPage = new ShopMerchantLoginPage(driver);
        categoryPage = new ShopMerchantCategoryPage(driver);
        inventorypage=new ShopMerchantInventoryPage(driver);
        loginPage.goTo();
        
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        loginPage.login(user, pass);
        String url= driver.getCurrentUrl();
        Assert.assertTrue(url.equals(expectedurl), "URLs do not match");
        
    }
    @Test(priority = 2)
    public void categoryListsTest() {
        categoryPage.printCategoryLists();
        String url= driver.getCurrentUrl();
        Assert.assertTrue(url.equals(expectedurl), "URLs do not match");
    }
    @Test(priority = 3)
    public void categorySearchTest() {
 
        categoryPage.performCategorySearch("IOS PRIVATE-L2");
    }

    @Test(priority = 4)
    public void categoryRequestTest() throws InterruptedException {

        categoryPage.performCategoryRequest(categorynametorequest, filePath);
    }
    @Test(priority = 5)
    public void shopInventory() throws InterruptedException {
  
    	inventorypage.inventoryPage();
       
    }
    @Test(priority = 6)
    public void shopInventorySearch()
    {
  
    	inventorypage.performInventorySearch("Cadbury Chocobakes ChocFilled Cookies Cream Filled");

    }
    @Test(priority = 7)
    public void shopInventoryEdit() throws InterruptedException
    {
    	inventorypage.performInventoryEdit("30");
    	Thread.sleep(6000);
    

    }
    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	File file= new File(System.getProperty("user.dir")+"//reports//"+ testCaseName +".png");
    	FileUtils.copyFile(source,file);
    	return System.getProperty("user.dir")+"//reports//"+ testCaseName +".png";
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

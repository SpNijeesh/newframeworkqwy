package nijeeshqwy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import nijeeshqwy.pageobjects.PromotionPage;
import nijeeshqwy.pageobjects.ShopAdminLoginPage;


public class ShopAdminPromotions {
	private ChromeDriver driver;
    
    //Object creation for Pages
    
		private ShopAdminLoginPage shopAdminPage;
		private PromotionPage promotionpage;
		private String RegionName = "Trivandrum";
		ExtentReports extent;
	
	//Promotions
	
		private String promotionnamesearch="DEMOAPR07";
	
	//Add Promotions- Region
		private String Regionpromotiontitle="CODEREGION52";
		private String Regionpromotiondescribtion="Nijeesh";
		private String Regionpromotioncode="CODEREGION52";
	
	//Add Promotions- Single Shop
	
		private String singlespromotiontitle="CODESINGLESHOP52";
		private String singlespromotiondescribtion="Nijeesh";
		private String singlespromotioncode="CODESINGLESHOP52";
	
	//Add Promotions- Multiple Shop
	
		private String multipleromotiontitle="CODEMULTISHOP51";
		private String multiplepromotiondescribtion="Nijeesh";
		private String multiplepromotioncode="CODEMULTISHOP51";
	
	//Add Promotions- Single product Shop
	
		private String productpromotiontitle="CODEPRODUCT51";
		private String productpromotiondescribtion="Nijeesh";
		private String productpromotioncode="CODEPRODUCT51";
		private String productname="Icecream - 500g";
		
	//Add Promotions- Single category Shop
		
		private String categorypromotiontitle="CODECAT51";
		private String categorypromotiondescribtion="Nijeesh";
		private String categorypromotioncode="CODECAT51";
		private String categoryname="Shop SKU Category";

		//Add Promotions- Shop param
		
		private String parampromotiontitle="CODEPARAM51";
		private String parampromotiondescribtion="Nijeesh";
		private String parampromotioncode="CODEPARAM51";
		
		//Assert expected message
		
		private String expectedMessage = "Promotion Added Successfully";

	
    @BeforeTest
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", "\"C:\\Users\\Niju\\Downloads\\");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        shopAdminPage = new ShopAdminLoginPage(driver);
        promotionpage= new PromotionPage(driver);
        driver.get("https://stage-shop-admin.qwqer.in/");
        shopAdminPage.login("Nijeesh", "123456789");
      //  Thread.sleep(2000);
        promotionpage.promotionpageselect();
    }
    @Test(priority = 1)
   	public void PromotionRegionfilter() throws InterruptedException
   	{
    	promotionpage.promotionsFilter(RegionName);
    	
   	}
    @Test(priority = 2)
   	public void PromotionNameSearch() throws InterruptedException
   	{
    	promotionpage.promotionsnamesearch(promotionnamesearch);
   	}
    
    @Test(priority = 3)
   	public void PromotionAddRegion() throws InterruptedException
   	{
    	promotionpage.addregionpromotions(Regionpromotiontitle,Regionpromotiondescribtion,Regionpromotioncode,RegionName);
    	WebElement tostermessage= driver.findElement(By.id("toast-container"));
    	String Tostermessagerecived = tostermessage.getText();
    	System.out.println("PromotionAddRegion"+Tostermessagerecived);
        Assert.assertTrue(Tostermessagerecived.contains(expectedMessage), "Promotion Added Successfully");
   	}
    
    @Test(priority = 4)
   	public void PromotionAddSingleShop() throws InterruptedException
   	{
    	promotionpage.singleShopPromotion(singlespromotiontitle,singlespromotiondescribtion,singlespromotioncode);
    	WebElement tostermessage= driver.findElement(By.id("toast-container"));
    	String Tostermessagerecived = tostermessage.getText();
    	System.out.println("PromotionAddSingleShop"+Tostermessagerecived);
        Assert.assertTrue(Tostermessagerecived.contains(expectedMessage), "Promotion Added Successfully");
   	}
    
    @Test(priority = 5)
   	public void PromotionAddMultipleShop() throws InterruptedException
   	{
    	promotionpage.MultipleShoppromotion(multipleromotiontitle,multiplepromotiondescribtion,multiplepromotioncode);
    	WebElement tostermessage= driver.findElement(By.id("toast-container"));
    	String Tostermessagerecived = tostermessage.getText();
    	System.out.println("PromotionAddMultipleShop"+Tostermessagerecived);
        Assert.assertTrue(Tostermessagerecived.contains(expectedMessage), "Promotion Added Successfully");
   	}
    @Test(priority = 6)
   	public void PromotionAddProduct() throws InterruptedException
   	{
    	promotionpage.productpromotion(productpromotiontitle, productpromotiondescribtion, productpromotioncode,productname);
    	WebElement tostermessage= driver.findElement(By.id("toast-container"));
    	String Tostermessagerecived = tostermessage.getText();
    	System.out.println("PromotionAddProduct"+Tostermessagerecived);
        Assert.assertTrue(Tostermessagerecived.contains(expectedMessage), "Promotion Added Successfully");
   	}
    @Test(priority = 7)
   	public void PromotionAddCategory() throws InterruptedException
   	{
    	promotionpage.catpromotion(categorypromotiontitle, categorypromotiondescribtion, categorypromotioncode, categoryname);
    	WebElement tostermessage= driver.findElement(By.id("toast-container"));
    	String Tostermessagerecived = tostermessage.getText();
    	System.out.println("PromotionAddProduct"+Tostermessagerecived);
        Assert.assertTrue(Tostermessagerecived.contains(expectedMessage), "Promotion Added Successfully");
   	}
    @Test(priority = 8)
   	public void PromotionAddShopParam() throws InterruptedException
   	{
    	promotionpage.parampromotion(parampromotiontitle, parampromotiondescribtion, parampromotioncode);
    	WebElement tostermessage= driver.findElement(By.id("toast-container"));
    	String Tostermessagerecived = tostermessage.getText();
    	System.out.println("PromotionAddShopParam"+Tostermessagerecived);
        Assert.assertTrue(Tostermessagerecived.contains(expectedMessage), "Promotion Added Successfully");	
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

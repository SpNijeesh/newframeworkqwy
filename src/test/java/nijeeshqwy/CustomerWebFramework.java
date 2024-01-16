package nijeeshqwy;
import io.github.bonigarcia.wdm.WebDriverManager;
import nijeeshqwy.pageobjects.Landingpage;
import nijeeshqwy.pageobjects.PaymentPage;
import nijeeshqwy.pageobjects.ShoppingCartPage;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 public class CustomerWebFramework 
{
    ChromeDriver driver;
    private String mobile = "9037342807";
    private String password = "123456789";
    private String expectedText = "Nijeesh_Trivandrum";
    private Landingpage landingpage;
    ShoppingCartPage shoppingCartPage;
    PaymentPage paymentPage;
    @BeforeClass
    public void setUp() {
    	
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://stage-customer.qwqer.in/home");
        landingpage = new Landingpage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        paymentPage = new PaymentPage(driver);
        
    }

    @Test(priority = 1)
    public void performLogin() throws Throwable{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	landingpage.clickTrivandrumImage();
    	landingpage.clickCartItemName();
    	landingpage.enterCustomerPhone(mobile);
    	landingpage.enterPassword(password);
    	landingpage.clickSubmitButton();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("toast-container"))); 
        String loginValidationText = landingpage.getToastMessage();
        if (loginValidationText.contains("Success")) {
            System.out.println("Customer Web Login Success");
        } else {
            System.out.println("Customer Web Login Failed");
        }
        Thread.sleep(2000);
    }
  @Test(priority = 2)
   public void performAddToCart() {
	  shoppingCartPage.selectAddressAndShop(expectedText);
	  shoppingCartPage.addToCart();
	  
  }
@Test(priority = 3)
public void performPayment() {
	paymentPage.proceedToPayment();
    paymentPage.selectPaymentMethod("COD");
    paymentPage.confirmOrder();
    String orderID = paymentPage.getOrderID();
    System.out.println("Order ID: " + orderID);
}

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
 }

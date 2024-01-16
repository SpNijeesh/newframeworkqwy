package nijeeshqwy.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ShopMerchantLoginPage {
    WebDriver driver;

    // Locators
    private final By phoneInput = By.id("customerPhone");
    private final By passwordInput = By.xpath("//input[@placeholder='Password']");
    private final By loginButton = By.xpath("//span[@class='login-text']");

    // Constructor
    public ShopMerchantLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void goTo()
    {
    	driver.get("https://stage-shop-merchant.qwqer.in/");
    }
    public void login(String username, String password) throws InterruptedException {
        
        driver.findElement(phoneInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        Thread.sleep(3000);
    }
}

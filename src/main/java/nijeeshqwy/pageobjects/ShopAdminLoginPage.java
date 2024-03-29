package nijeeshqwy.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopAdminLoginPage {
	 private final WebDriver driver;

	    // Constructor
	    public ShopAdminLoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Page Elements
	    By usernameInput = By.name("username");
	    By passwordInput = By.name("password");
	    By signInButton = By.xpath("//button[@id='kt_sign_in_submit']");

	    // Page Methods
	    public void login(String username, String password) {
	        WebElement usernameElement = driver.findElement(usernameInput);
	        WebElement passwordElement = driver.findElement(passwordInput);
	        WebElement signInButtonElement = driver.findElement(signInButton);

	        usernameElement.sendKeys(username);
	        passwordElement.sendKeys(password);
	        signInButtonElement.click();
	    }
	}

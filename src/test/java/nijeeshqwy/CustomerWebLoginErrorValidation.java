package nijeeshqwy;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerWebLoginErrorValidation {
	private String validmobile = "9037342807";
	private String validpassword = "123456789";
	private String Invalidpassword = "12345678";
	private String Invalidmobile = "7655555555";

	ChromeDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://stage-customer.qwqer.in/home");
		driver.findElement(By.xpath("//img[@alt='Trivandrum']")).click();
		driver.findElement(By.xpath("//span[@class='cart-item-name']")).click();

	}

	@Test(priority = 1)
	public void testEmptyCredentials() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("customerPhone")));
		WebElement user = driver.findElement(By.id("customerPhone"));
		user.click();
		user.sendKeys("");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.sendKeys("");
		WebElement loginbutton = driver.findElement(By.xpath("//span[normalize-space()='Login Now']"));
		boolean isButtonEnabled = loginbutton.isSelected();
		Assert.assertFalse(isButtonEnabled);
		System.out.println("Test case for Empty Credentials is passed");
	}

	@Test(priority = 2)
	public void testInvalidCredentials() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("customerPhone")));
		WebElement user = driver.findElement(By.id("customerPhone"));
		user.click();
		user.sendKeys(Invalidmobile);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.sendKeys(Invalidpassword);
		WebElement loginbutton = driver.findElement(By.xpath("//span[normalize-space()='Login Now']"));
		loginbutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("toast-container")));
		String toastMessage = driver.findElement(By.id("toast-container")).getText();
		String messageToPrint = toastMessage.substring(2);
		System.out.println("Test case for Invalid Credentials ");
		Thread.sleep(5000);
		Assert.assertTrue(toastMessage.contains("Username does not exist"));
		System.out.println(messageToPrint);
		user.clear();
		password.clear();

	}

	@Test(priority = 3)
	public void testIncorrectUsername() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("customerPhone")));
		WebElement user = driver.findElement(By.id("customerPhone"));
		user.click();
		user.sendKeys(Invalidmobile);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.sendKeys(validpassword);
		WebElement loginbutton = driver.findElement(By.xpath("//span[normalize-space()='Login Now']"));
		loginbutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("toast-container")));
		String toastMessage = driver.findElement(By.id("toast-container")).getText();
		String messageToPrint = toastMessage.substring(2);
		System.out.println("Test case for Invalid Mobile Number ");
		Assert.assertTrue(toastMessage.contains("Username does not exist"));
		System.out.println(messageToPrint);
		Thread.sleep(5000);
		user.clear();
		password.clear();
	}

	@Test(priority = 4)
	public void testIncorrectPassword() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("customerPhone")));
		WebElement user = driver.findElement(By.id("customerPhone"));
		user.click();
		user.sendKeys(validmobile);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.sendKeys(Invalidpassword);
		WebElement loginbutton = driver.findElement(By.xpath("//span[normalize-space()='Login Now']"));
		loginbutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("toast-container")));
		String toastMessage = driver.findElement(By.id("toast-container")).getText();
		String messageToPrint = toastMessage.substring(2);
		System.out.println("Testcase for Invalid Password");
		Thread.sleep(5000);
		Assert.assertTrue(toastMessage.contains("Password is incorrect"));
		System.out.println(messageToPrint);
		user.clear();
		password.clear();
	}

	@Test(priority = 5)
	public void testAcceptingChar() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("customerPhone")));
		WebElement user = driver.findElement(By.id("customerPhone"));
		user.click();
		user.sendKeys("abcdefghij");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.sendKeys(Invalidpassword);
		WebElement loginbutton = driver.findElement(By.xpath("//span[normalize-space()='Login Now']"));
		boolean isButtonEnabled = loginbutton.isSelected();
		Assert.assertFalse(isButtonEnabled);
		System.out.println("Test case for user not accepting character is passed");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
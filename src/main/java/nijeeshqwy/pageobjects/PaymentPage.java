package nijeeshqwy.pageobjects;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nijeeshqwy.AbstractComponents.AbstractWaitFunctions;

public class PaymentPage extends AbstractWaitFunctions{
	

	private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public PaymentPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Page actions/methods
    public void proceedToPayment() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void selectPaymentMethod(String paymentMethod) {
    
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), '" + paymentMethod + "')]"))).click();
    }

    public void confirmOrder() {
        driver.findElement(By.xpath("//button[contains(text(), 'CONFIRM ORDER')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='order-id-text']")));
    }

    public String getOrderID() {
        WebElement orderID = driver.findElement(By.xpath("//div[@class='order-id-text']"));
        return orderID.getText();
    }
}

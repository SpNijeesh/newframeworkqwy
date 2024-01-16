package nijeeshqwy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {
	private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Page actions/methods
    public void selectAddressAndShop(String expectedText) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='address']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Trivandrum']"))).click();

        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='shop-details-name ng-star-inserted']")));

        for (WebElement element : elements) {
            String text = element.getText();
            if (text.equals(expectedText)) {
                System.out.println("The shop Selected is " + element.getText());
                element.click();
                break;
            }
        }
    }

    public void addToCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='shop-detail-container']//div[1]//app-product-card[1]//div[1]//div[1]//div[3]//div[3]//button[1]//div[1]")));
        addToCartButton.click();
    }
}

package nijeeshqwy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShopMerchantInventoryPage {

	WebDriver driver;
    WebDriverWait wait;
	
    @FindBy(xpath = "//label[normalize-space()='Inventory']")
    WebElement InventoryPage;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement Inventorysearch;

    @FindBy(xpath = "//button[@class='button'][1]")
    private WebElement inventoryedit;

    @FindBy(xpath = "//div[@class='select-shop-wrap']//input[@formcontrolname='price']")
    private WebElement inventoryprice;

    @FindBy(xpath = "//button[normalize-space()='Update']")
    private WebElement inventorudatebutton;
   @FindBy(xpath = "//div[@id='toast-container']")
   	private WebElement successtoster;

    @FindBy(xpath = "//td[@class='price-block']")
    private WebElement updatedprice;
    
    @FindBy(css = "td:nth-child(4)")
    private WebElement shopsku;
    

    // Constructor
    public ShopMerchantInventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // Method to get inventoryPage
    public void inventoryPage() {
    	wait.until(ExpectedConditions.elementToBeClickable(this.InventoryPage)).click();
        
    }

    // Method to perform Inventory Search
    public void performInventorySearch(String searchTerm) throws InterruptedException {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(this.Inventorysearch));
        searchField.click();
        searchField.sendKeys(searchTerm);
        Thread.sleep(4000);

    }

     //Method to perform InventoryEdit
     
    public void  performInventoryEdit(String pricetoupdate) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(inventoryedit)).click();
        wait.until(ExpectedConditions.elementToBeClickable(inventoryprice)).click();
        inventoryprice.clear();
        inventoryprice.sendKeys(pricetoupdate);
        inventorudatebutton.click();
        wait.until(ExpectedConditions.elementToBeClickable(successtoster));
        wait.until(ExpectedConditions.elementToBeClickable(updatedprice));
      
    	}


    // Method to perform InventoryCSV download
    public void performInventoryCSV()
    {
    	
    }
}

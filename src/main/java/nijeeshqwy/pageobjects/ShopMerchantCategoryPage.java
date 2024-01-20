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

public class ShopMerchantCategoryPage {

	WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//div[contains(@class, 'p-paginator-bottom')]//span//button")
    private List<WebElement> categoryNextPages;

    @FindBy(xpath = "//tbody[@class='p-element p-datatable-tbody']//tr//td[1]")
    private List<WebElement> categoryListItems;

    @FindBy(xpath = "//input[@placeholder='Search Category']")
    private WebElement searchField;

    @FindBy(xpath = "//button[normalize-space()='Request Category']")
    private WebElement requestCategoryButton;

    @FindBy(xpath = "//input[@placeholder='Enter Category Name']")
    private WebElement categoryNameInput;

    @FindBy(xpath = "//div[3]//div[2]//label[1]//span[1]")
    private WebElement publicPrivateSelection;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileInput;

    @FindBy(xpath = "//button[normalize-space()='Request']")
    private WebElement requestButton;

    @FindBy(xpath = "//div[@id='toast-container']")
    private WebElement submissionMessage;

    // Constructor
    public ShopMerchantCategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }
    public void printCategoryLists() {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) this.categoryNextPages));
        for (WebElement categoryNextPage : categoryNextPages) {
            System.out.println("Page No: " + categoryNextPage.getText());

            for (WebElement categoryList : categoryListItems) {
                String categoryNames = categoryList.getText();
                System.out.println(categoryNames);
             
            }

            try {
                categoryNextPage.click();
            } catch (StaleElementReferenceException e) {
                // Handle the exception (e.g., re-fetch the element or skip to the next iteration)
            }
        }
    }

    // Method to perform category search
    public void performCategorySearch(String searchTerm) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(this.searchField));
        searchField.click();
        searchField.sendKeys(searchTerm);
    }

    // Method to perform category request
    public void performCategoryRequest(String categoryName, String filePath) throws InterruptedException {
        WebElement requestCat = wait.until(ExpectedConditions.elementToBeClickable(requestCategoryButton));
        requestCat.click();

        WebElement categoryInput = wait.until(ExpectedConditions.elementToBeClickable(categoryNameInput));
        categoryInput.sendKeys(categoryName);

        publicPrivateSelection.click();

        WebElement fileInput = wait.until(ExpectedConditions.elementToBeClickable(this.fileInput));
        fileInput.sendKeys(filePath);

        requestButton.click();
        Thread.sleep(5000);
        WebElement submissionMessage = wait.until(ExpectedConditions.elementToBeClickable(this.submissionMessage));
        String text = submissionMessage.getText();
        System.out.println(text);
    }
}
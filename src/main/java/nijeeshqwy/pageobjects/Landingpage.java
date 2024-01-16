package nijeeshqwy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nijeeshqwy.AbstractComponents.AbstractComponent;



public class Landingpage{
	
	 WebDriver driver;
	 
	 public Landingpage(WebDriver driver) {
			this.driver= driver;
			PageFactory.initElements(driver, this);
		}

    @FindBy(xpath = "//img[@alt='Trivandrum']")
    private WebElement trivandrumImage;

    @FindBy(xpath = "//span[@class='cart-item-name']")
    private WebElement cartItemName;

    @FindBy(id = "customerPhone")
    private WebElement customerPhone;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "toast-container")
    private WebElement toastContainer;

    public void clickTrivandrumImage() {
        trivandrumImage.click();
    }

    public void clickCartItemName() {
        cartItemName.click();
    }

    public void enterCustomerPhone(String mobile) {
        customerPhone.sendKeys(mobile);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getToastMessage() {
        return toastContainer.getText();
    }
}
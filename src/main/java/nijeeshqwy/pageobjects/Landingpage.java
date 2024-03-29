package nijeeshqwy.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




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

    @FindBy(xpath = "//input[@formcontrolname='username']")
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

    public void customerlogin(String mobile,String password) throws InterruptedException
    {
    	Thread.sleep(2000);
    	customerPhone.sendKeys(mobile);
    	passwordInput.sendKeys(password);
    	submitButton.click();
    }
   

    public String getToastMessage() {
        return toastContainer.getText();
    }
}
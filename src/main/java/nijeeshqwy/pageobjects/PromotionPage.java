package nijeeshqwy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class PromotionPage {
    private WebDriver driver;
    
    //Promotion page common elements
    
    
    @FindBy(xpath = "//span[normalize-space()='Promotions']")
    private WebElement promotionpageselect;

    @FindBy(xpath = "//div[@class='p-multiselect-label p-placeholder']")
    private WebElement regionoption;
    
    @FindBy(xpath = "//input[@role='textbox']")
    private WebElement regiontext;

    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    private WebElement selectregion;

    @FindBy(xpath = "//input[@placeholder='Search by Title, Code']")
    private WebElement promotionnamesearch;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm ng-star-inserted']")
    private WebElement promotionaddbutton;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;
    
    @FindBy(xpath = "//button[@type='reset']")
    private WebElement clearsearch;

    
    //Promotion Add Common elements

    @FindBy(xpath = "//input[@formcontrolname='title']")
    private WebElement promotiontitle;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    private WebElement promotiondescription;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    private WebElement promotioncode;
    
    @FindBy(xpath = "//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted']")
    private WebElement promotiontypedropdown;
    
    @FindBy(xpath = "//input[@class='select-class mt-2 ng-untouched ng-pristine ng-invalid']")
    private WebElement priority;
    
    @FindBy(xpath = "//input[@placeholder='No date selected']")
    private WebElement startdate;
    
    @FindBy(xpath = "(//span[normalize-space()='25'])[2]")
    private WebElement startday;
    
    @FindBy(xpath = "(//input[@placeholder='No date selected'])[2]")
    private WebElement enddate;
    
    @FindBy(xpath = "(//span[normalize-space()='25'])[2]")
    private WebElement endday;
    
    @FindBy(xpath = "//div[@class='content ng-star-inserted']/input[@type='file']")
    private WebElement fileInput;
    
    @FindBy(xpath = "//button[@id='kt_modal_add_customer_submit']")
    private WebElement submitpromotion;
    
    
    //Promotion types
    
    @FindBy(xpath = "//li[@aria-label='Single Region']")
    private WebElement SingleRegion;
    
    @FindBy(xpath = "//li[@aria-label='Single Shop']")
    private WebElement SingleShop;
    
    @FindBy(xpath = "//li[@aria-label='Multiple Shop']")
    private WebElement MultipleShop;
    
    @FindBy(xpath = "//li[@aria-label='Single Product']")
    private WebElement SingleProduct;
    
    @FindBy(xpath = "//li[@aria-label='Single Category']")
    private WebElement SingleCategory;
    
    @FindBy(xpath = "//li[@aria-label='Shop Parameterized']")
    private WebElement ShopParameterized;
 
    //Product element 

    
    //Dropdown Selection 
    
    @FindBy(xpath = "//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted']")
    private WebElement selectregionforpromotion;
 
    
    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    private WebElement regionenter;
    
    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    private WebElement selregion;
    
    @FindBy(xpath = "//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted']")
    private WebElement shopdropdown;
    
    @FindBy(xpath = "//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted']")
    private WebElement shopparamdropdown;
      
    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    private WebElement shopenter;
  
  
    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    private WebElement shopenterselect;
    
  //span[@class='ng-star-inserted']
    
    @FindBy(xpath = "(//div[@class='p-multiselect-label p-placeholder'])[2]")
    private WebElement multipleshopdrop;
    
    @FindBy(xpath = "(//input[@role='textbox'])")
    private WebElement multipleshopenter;
    
    @FindBy(xpath = "//button[@type='button']//timesicon[@class='p-element p-icon-wrapper ng-star-inserted']//*[name()='svg']")
    private WebElement multipleshopclose;
      
    
    
    //Product elements
    
    @FindBy(xpath = "//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted']")
    private WebElement productdropdown;
    
    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    private WebElement productenter;
    				//input[@class='p-dropdown-filter p-inputtext p-component']
    
    @FindBy(xpath = "//li[@aria-label='Icecream - 500g']")
    private WebElement productsel;
    
    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    private WebElement productselectparam;
    
  //span[@class='ng-star-inserted']
    
  
  //Category Elements
    
    @FindBy(xpath = "//div[@class='p-treeselect-label p-placeholder']")
    private WebElement categorydropdown;
    
  //div[@class='p-treeselect-label p-placeholder']
    
    @FindBy(xpath = "//input[@class='p-treeselect-filter p-inputtext p-component']")
    private WebElement categoryenter;
    
    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    private WebElement categorysel;
    
    @FindBy(xpath = "//span[contains(text(),'100 products')]")
    private WebElement categoryforshopparam;
    
    
  //ngx-spinner[@type='square-jelly-box']
    

    public PromotionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void promotionpageselect()throws InterruptedException
	{
    	promotionpageselect.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));
    	
	}
	public void promotionsFilter(String regionname)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(regionoption));
	    regionoption.click();
	    wait.until(ExpectedConditions.elementToBeClickable(regiontext));
		regiontext.sendKeys(regionname);
	    wait.until(ExpectedConditions.elementToBeClickable(selectregion));
		selectregion.click();
	    wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		//Thread.sleep(1000);
		clearsearch.click();
		Thread.sleep(1000);
		}
	
	public void promotionsnamesearch(String promotionname)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    wait.until(ExpectedConditions.elementToBeClickable(promotionnamesearch));
		promotionnamesearch.click();
		promotionnamesearch.sendKeys(promotionname);
		searchButton.click();
		clearsearch.click();
		Thread.sleep(1000);
	}
	

	public void addregionpromotions(String title,String descrpition,String code, String regionname)throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); 	
		promotionaddbutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='title']")));
		promotiontitle.sendKeys(title);	
		promotiondescription.sendKeys(descrpition);	
		promotioncode.sendKeys(code);
		promotiontypedropdown.click();
		SingleRegion.click();
	    selectregionforpromotion.click();
	    regionenter.click();
	    regionenter.sendKeys(regionname);
	    selregion.click();   
	    wait.until(ExpectedConditions.elementToBeClickable(startdate));
	    startdate.click();
		wait.until(ExpectedConditions.elementToBeClickable(startday));
		 Thread.sleep(1000);
	    startday.click();
	    wait.until(ExpectedConditions.elementToBeClickable(enddate));
	    enddate.click();
	    wait.until(ExpectedConditions.elementToBeClickable(endday));
	    Thread.sleep(1000);
	    endday.click();
	    wait.until(ExpectedConditions.elementToBeClickable(priority));
	    priority.sendKeys("0");
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInput);
		String projectpath= System.getProperty("user.dir");
		fileInput.sendKeys(projectpath+"\\files\\promotionsample.png");
	    submitpromotion.click();
	    WebElement tostermessage= driver.findElement(By.id("toast-container"));
	    wait.until(ExpectedConditions.elementToBeClickable(tostermessage));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));
	}

	public void singleShopPromotion(String tiltle,String des,String code)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(promotionaddbutton));
		promotionaddbutton.click();       
		wait.until(ExpectedConditions.elementToBeClickable(promotiontitle));
		promotiontitle.sendKeys(tiltle);	
		promotiondescription.sendKeys(des);	
		promotioncode.sendKeys(code);
		wait.until(ExpectedConditions.elementToBeClickable(promotiontypedropdown));
		promotiontypedropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(SingleShop));
		SingleShop.click();
		wait.until(ExpectedConditions.elementToBeClickable(selectregionforpromotion));
		selectregionforpromotion.click();
		wait.until(ExpectedConditions.elementToBeClickable(regionenter));
		regionenter.sendKeys("Trivandrum");
		wait.until(ExpectedConditions.elementToBeClickable(selregion));
		selregion.click();
		wait.until(ExpectedConditions.elementToBeClickable(shopdropdown));
		shopdropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(shopenter));
		shopenter.sendKeys("Nijeesh_Trivandrum");
		wait.until(ExpectedConditions.elementToBeClickable(shopenterselect));
		shopenterselect.click();
		wait.until(ExpectedConditions.elementToBeClickable(startdate));
		startdate.click();
		wait.until(ExpectedConditions.elementToBeClickable(startday));
	    startday.click();
	    wait.until(ExpectedConditions.elementToBeClickable(enddate));
	    enddate.click();
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(endday));
	    endday.click();
	    wait.until(ExpectedConditions.elementToBeClickable(priority));
	    priority.sendKeys("0");
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInput);
       Thread.sleep(2000);
		String projectpath= System.getProperty("user.dir");
		fileInput.sendKeys(projectpath+"\\files\\shop.png");
		
	    Thread.sleep(3000);
	    submitpromotion.click();
	    WebElement tostermessage= driver.findElement(By.id("toast-container"));
	    wait.until(ExpectedConditions.elementToBeClickable(tostermessage));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));	
        
	}
	public void MultipleShoppromotion(String tiltle,String des,String code)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(promotionaddbutton));
		promotionaddbutton.click();
	
		wait.until(ExpectedConditions.elementToBeClickable(promotiontitle));
		promotiontitle.sendKeys(tiltle);	
		promotiondescription.sendKeys(des);	
		promotioncode.sendKeys(code);
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(promotiontypedropdown));
		promotiontypedropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(MultipleShop));
		MultipleShop.click();	
		wait.until(ExpectedConditions.elementToBeClickable(selectregionforpromotion));
		selectregionforpromotion.click();
		wait.until(ExpectedConditions.elementToBeClickable(regionenter));
		regionenter.sendKeys("Trivandrum");
		wait.until(ExpectedConditions.elementToBeClickable(selregion));
		selregion.click();
		Thread.sleep(3000);
		multipleshopdrop.click();
		wait.until(ExpectedConditions.elementToBeClickable(multipleshopenter));
		multipleshopenter.click();
		multipleshopenter.sendKeys("Nijeesh_Trivandrum");
		wait.until(ExpectedConditions.elementToBeClickable(shopenterselect));	
		shopenterselect.click();
		wait.until(ExpectedConditions.elementToBeClickable(multipleshopenter));
		multipleshopenter.clear();
		wait.until(ExpectedConditions.elementToBeClickable(multipleshopenter));
		multipleshopenter.sendKeys("Devuzz");
		wait.until(ExpectedConditions.elementToBeClickable(shopenterselect));		
		shopenterselect.click();	
		wait.until(ExpectedConditions.elementToBeClickable(multipleshopclose));
		multipleshopclose.click();
		wait.until(ExpectedConditions.elementToBeClickable(startdate));
		Thread.sleep(1000);
		startdate.click();
		wait.until(ExpectedConditions.elementToBeClickable(startday));
	    Thread.sleep(1000);
	    startday.click();
	    Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(enddate));
	    enddate.click();
	   Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(endday));
	    endday.click();
	    Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(priority));
	    priority.sendKeys("0");
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInput);
       Thread.sleep(1000);
		String projectpath= System.getProperty("user.dir");
		fileInput.sendKeys(projectpath+"\\files\\shop.png");
	    Thread.sleep(3000);
	    submitpromotion.click();
	    WebElement tostermessage= driver.findElement(By.id("toast-container"));
	    wait.until(ExpectedConditions.elementToBeClickable(tostermessage));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));	
	}
	
	
	public void productpromotion(String tiltle,String des,String code,String product)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(promotionaddbutton));
		promotionaddbutton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(promotiontitle));
		promotiontitle.sendKeys(tiltle);	
		promotiondescription.sendKeys(des);	
		promotioncode.sendKeys(code);	
		promotiontypedropdown.click();
		SingleProduct.click();
		selectregionforpromotion.click();
		wait.until(ExpectedConditions.elementToBeClickable(regionenter));
		regionenter.sendKeys("Trivandrum");	
		wait.until(ExpectedConditions.elementToBeClickable(selregion));
		selregion.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(promotiontypedropdown));
		productdropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(productenter));
		productenter.sendKeys(product);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(productsel));
		productsel.click();
		Thread.sleep(2000);
		startdate.click();
	    Thread.sleep(1000);
	    startday.click();
	    Thread.sleep(1000);
	    enddate.click();
	    Thread.sleep(1000);
	    endday.click();
	    Thread.sleep(1000);
	    priority.sendKeys("0");
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInput);
       Thread.sleep(1000);
		String projectpath= System.getProperty("user.dir");
		fileInput.sendKeys(projectpath+"\\files\\product.png");
	    Thread.sleep(1000);
	    submitpromotion.click();
	    WebElement tostermessage= driver.findElement(By.id("toast-container"));
	    wait.until(ExpectedConditions.elementToBeClickable(tostermessage));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));	
	}
	public void catpromotion(String tiltle,String des,String code,String category)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));	
		wait.until(ExpectedConditions.elementToBeClickable(promotionaddbutton));
		promotionaddbutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(promotiontitle));
		promotiontitle.sendKeys(tiltle);	
		promotiondescription.sendKeys(des);	
		promotioncode.sendKeys(code);
		wait.until(ExpectedConditions.elementToBeClickable(promotiontypedropdown));
		Thread.sleep(1000);
		promotiontypedropdown.click();
		SingleCategory.click();
		selectregionforpromotion.click();
		wait.until(ExpectedConditions.elementToBeClickable(regionenter));
		regionenter.sendKeys("Trivandrum");	
		wait.until(ExpectedConditions.elementToBeClickable(selregion));
		selregion.click();
		Thread.sleep(3000);
		categorydropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(categoryenter));
		categoryenter.sendKeys(category);
		categorysel.click();
		Thread.sleep(2000);
		startdate.click();
	    Thread.sleep(1000);
	    startday.click();
	    Thread.sleep(1000);
	    enddate.click();
	    Thread.sleep(1000);
	    endday.click();
	    Thread.sleep(1000);
	    priority.sendKeys("0");
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInput);
       Thread.sleep(2000);
		String projectpath= System.getProperty("user.dir");
		fileInput.sendKeys(projectpath+"\\files\\category.png");
	    Thread.sleep(2000);
	    submitpromotion.click();
	    WebElement tostermessage= driver.findElement(By.id("toast-container"));
	    wait.until(ExpectedConditions.elementToBeClickable(tostermessage));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));	
		
	}
	public void parampromotion(String tiltle,String des,String code)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(promotionaddbutton));
		promotionaddbutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(promotiontitle));
		promotiontitle.sendKeys(tiltle);	
		promotiondescription.sendKeys(des);	
		promotioncode.sendKeys(code);
		wait.until(ExpectedConditions.elementToBeClickable(promotiontypedropdown));
		Thread.sleep(1000);
		promotiontypedropdown.click();
		ShopParameterized.click();
		selectregionforpromotion.click();
		wait.until(ExpectedConditions.elementToBeClickable(regionenter));
		regionenter.sendKeys("Trivandrum");	
		wait.until(ExpectedConditions.elementToBeClickable(selregion));
		selregion.click();
		Thread.sleep(3000);
		shopparamdropdown.click();
		shopenter.sendKeys("Nijeesh_Trivandrum");
		shopenterselect.click();
		categorydropdown.click();
		categoryforshopparam.click();
		productdropdown.click();
		productenter.sendKeys("100P-01");
		productselectparam.click();
		Thread.sleep(2000);
		startdate.click();
	    Thread.sleep(1000);
	    startday.click();
	    Thread.sleep(1000);
	    enddate.click();
	    Thread.sleep(1000);
	    endday.click();
	    Thread.sleep(1000);
	    priority.sendKeys("0");
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInput);
       Thread.sleep(1000);
		String projectpath= System.getProperty("user.dir");
		fileInput.sendKeys(projectpath+"\\files\\param.png");
	    Thread.sleep(1000);
	    submitpromotion.click();
	    WebElement tostermessage= driver.findElement(By.id("toast-container"));
	    wait.until(ExpectedConditions.elementToBeClickable(tostermessage));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));	
	}
	
}
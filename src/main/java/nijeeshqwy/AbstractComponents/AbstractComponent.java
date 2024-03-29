package nijeeshqwy.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver= driver;
		// TODO Auto-generated constructor stub
	}

	public void visibilityOfElementsLocate(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));

	}
}

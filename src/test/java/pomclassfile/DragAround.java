package pomclassfile;

import org.openqa.selenium.By;
import static com.qait.utility.WebElementlocator.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class DragAround {
	WebDriver driver;

	public DragAround(WebDriver driver) {

		this.driver = driver;
	}

	
	public void drag_element_to_box() {
//		WebElement from=driver.findElement(By.id("dragbox"));
//		WebElement to=driver.findElement(By.id("dropbox"));
//		Actions act=new Actions(driver);
//		act.dragAndDrop(from, to).build().perform();
//		driver.findElement(By.linkText("Proceed")).click();
//		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().equals("Popup Windows"));

		
		WebElement from=(WebElement) find_webelement(driver,"dragbox", "id").get(0);
		WebElement to=(WebElement) find_webelement(driver,"dropbox", "id").get(0);
		Actions act=new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
	    ((WebElement) find_webelement(driver,"Proceed", "linktext").get(0)).click();
	    WebElement verification=(WebElement) find_webelement(driver,"h1","tagname").get(0);
		Assert.assertTrue(verification.getText().equals("Popup Windows"));

		
		
	}
	public void donot_drag_element_and_click() throws InterruptedException {
//		driver.findElement(By.linkText("Proceed")).click();
//		Assert.assertTrue(driver.findElement(By.cssSelector("h1.error")).isDisplayed());
		((WebElement) find_webelement(driver,"Proceed", "linktext").get(0)).click();
		Thread.sleep(5000);
		driver.navigate().back();
	}

}

package pomclassfile;

import org.openqa.selenium.By;
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
		WebElement from=driver.findElement(By.id("dragbox"));
		WebElement to=driver.findElement(By.id("dropbox"));
		Actions act=new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().equals("Popup Windows"));

	}
	public void donot_drag_element_and_click() {
		driver.findElement(By.linkText("Proceed")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("h1.error")).isDisplayed());

	}

}

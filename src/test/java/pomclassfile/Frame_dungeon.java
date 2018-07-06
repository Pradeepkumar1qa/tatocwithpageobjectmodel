package pomclassfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import static com.qait.utility.WebElementlocator.*;

public class Frame_dungeon {
	WebDriver driver;

	public Frame_dungeon(WebDriver driver) {
		this.driver = driver;
	}

	public void match_both_box_color_and_click() {

		WebElement element1 = (WebElement) find_webelement((driver.switchTo().frame("main")), "answer", "id").get(0);
		String box_color = element1.getAttribute("class");
		System.out.println(box_color);

		WebElement element2 = (WebElement) find_webelement((driver.switchTo().frame("child")), "answer", "id").get(0);
		String box_color2 = element2.getAttribute("class");
		
		
		//System.out.println(box_color2);
		// String box_color =
		// driver.switchTo().frame("main").findElement(By.id("answer")).getAttribute("class");
		// String box_color2 =
		// driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");
		
		while (!box_color.equals(box_color2)) {
			
			((WebElement) find_webelement(driver.switchTo().parentFrame(), "Repaint Box 2", "linktext").get(0)).click();
			element2 = (WebElement) find_webelement((driver.switchTo().frame("child")), "answer", "id").get(0);
			box_color2 = element2.getAttribute("class");

			// driver.switchTo().parentFrame().findElement(By.linkText("Repaint Box
			// 2")).click();
			// box_color2 =
			// driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");

		}

		((WebElement)find_webelement(driver.switchTo().parentFrame(),"Proceed","linktext").get(0)).click();
		 WebElement verification=(WebElement) find_webelement(driver, "h1", "tagname").get(0);
		
		//Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().equals("Drag Around"));

	}

	/*
	 * do negative testing when unmatched boxes are clicked
	 */
	public void unmatched_color_click() {
		
		WebElement element1 = (WebElement) find_webelement((driver.switchTo().frame("main")), "answer", "id").get(0);
		String box_color = element1.getAttribute("class");
		System.out.println(box_color);

		WebElement element2 = (WebElement) find_webelement((driver.switchTo().frame("child")), "answer", "id").get(0);
		String box_color2 = element2.getAttribute("class");
		
		
		
		
		
		
//		
//		String box_color = driver.switchTo().frame("main").findElement(By.id("answer")).getAttribute("class");
//		String box_color2 = driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");
		while (box_color.equals(box_color2)) {
			
			((WebElement) find_webelement(driver.switchTo().parentFrame(), "Repaint Box 2", "linktext").get(0)).click();
			 element2 = (WebElement) find_webelement((driver.switchTo().frame("child")), "answer", "id").get(0);
			 box_color2 = element2.getAttribute("class");
			
			 
			 //driver.switchTo().parentFrame().findElement(By.linkText("Repaint Box 2")).click();
			//box_color2 = driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");

		}

		
		((WebElement)find_webelement(driver.switchTo().parentFrame(), "Proceed","linktext").get(0)).click();;
		WebElement verification=(WebElement) find_webelement(driver, "h1.error","cssselector").get(0);
		Assert.assertTrue("unable to display error page on frame dungeon",verification.isDisplayed());
		
		//driver.switchTo().parentFrame().findElement(By.linkText("Proceed")).click();
		//Assert.assertTrue(driver.findElement(By.cssSelector("h1.error")).isDisplayed());
		driver.navigate().back();
	}
}

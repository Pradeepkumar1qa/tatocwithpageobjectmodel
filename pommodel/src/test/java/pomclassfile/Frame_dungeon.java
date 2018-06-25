package pomclassfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class Frame_dungeon {
	WebDriver driver;

	public Frame_dungeon(WebDriver driver) {
		this.driver = driver;
	}

	public void match_both_box_color_and_click() {
		String box_color = driver.switchTo().frame("main").findElement(By.id("answer")).getAttribute("class");
		String box_color2 = driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");
		while (!box_color.equals(box_color2)) {
			driver.switchTo().parentFrame().findElement(By.linkText("Repaint Box 2")).click();
			box_color2 = driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");

		}

		driver.switchTo().parentFrame().findElement(By.linkText("Proceed")).click();
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().equals("Drag Around"));

	}

	
	/*do negative testing 
	when unmatched boxes are clicked*/
	public void unmatched_color_click() {
		String box_color = driver.switchTo().frame("main").findElement(By.id("answer")).getAttribute("class");
		String box_color2 = driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");
		while (box_color.equals(box_color2)) {
			driver.switchTo().parentFrame().findElement(By.linkText("Repaint Box 2")).click();
			box_color2 = driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");

		}

		driver.switchTo().parentFrame().findElement(By.linkText("Proceed")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("h1.error")).isDisplayed());
        driver.navigate().back();
	}
	}

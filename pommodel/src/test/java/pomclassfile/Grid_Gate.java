package pomclassfile;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Grid_Gate {
  WebDriver driver;
  By greenbox=By.className("greenbox");
  By redbox=By.className("redbox");
  
  public Grid_Gate(WebDriver driver) {
	this.driver=driver;
}

 public void click_greenbox() {
	 assertTrue(driver.findElement(By.className("greenbox")).isDisplayed());
	 driver.findElement(By.className("greenbox")).click();
	 }
 
 public void click_redbox() {
	 //for negative testing
	
	 List<WebElement> red_boxes= driver.findElements(By.className("redbox"));
	red_boxes.get(0).click();
	boolean is_displayed=driver.findElement(By.cssSelector("h1.error")).isDisplayed();
	assertTrue(is_displayed);
	driver.navigate().back();
	
	 
 }
	
}

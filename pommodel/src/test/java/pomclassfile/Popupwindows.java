package pomclassfile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class Popupwindows {
	WebDriver driver;
    ArrayList tabs;
	public Popupwindows(WebDriver driver) {
		this.driver = driver;
	}
	
	public void donegativetestingwhenclickedonproceedirectly() {
		driver.findElement(By.linkText("Proceed")).click();
		assertTrue(driver.findElement(By.cssSelector("h1.error")).isDisplayed());
		driver.navigate().back();
	}
	public void donegativetestingwhenwelaunchwindowandclickproceedwithoutsendinganykey() {
		driver.findElement(By.partialLinkText("Launch")).click();
		tabs = new ArrayList(driver.getWindowHandles());
        process_popup_and_returnto_main_page(1,-1);
        driver.switchTo().window((String) tabs.get(0));
		driver.findElement(By.linkText("Proceed")).click();
		assertTrue(driver.findElement(By.cssSelector("h1.error")).isDisplayed());
		driver.navigate().back();
        }
	
	public void fillinputwithwordandclicktoproceed() {
		driver.findElement(By.partialLinkText("Launch")).click();
		tabs = new ArrayList(driver.getWindowHandles());
        process_popup_and_returnto_main_page(1,1);
        driver.switchTo().window((String) tabs.get(0));
		driver.findElement(By.linkText("Proceed")).click();
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().equals("Cookie Handling"));

		
	}
	public void process_popup_and_returnto_main_page(int tab_number, int type){
		   
		driver.switchTo().window((String) tabs.get(tab_number));
		if(type==1)
		{driver.findElement(By.id("name")).sendKeys("pradeep");}
		else if(type==-1)	{}
	
        driver.findElement(By.id("submit")).click();
	
	
}
	

}

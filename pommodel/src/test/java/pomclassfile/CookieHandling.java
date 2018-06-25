package pomclassfile;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class CookieHandling {
   WebDriver driver;

public CookieHandling(WebDriver driver) {
	 this.driver = driver;
}

public void clickonproceedwithousettingcookie() {
	driver.findElement(By.linkText("Proceed")).click();
	assertTrue(driver.findElement(By.cssSelector("h1.error")).isDisplayed());
	driver.navigate().back();
	
}

public void clickonporceedaftersettingcookie() {
	driver.findElement(By.linkText("Generate Token")).click();
	String Token = driver.findElement(By.id("token")).getText();
	String value = Token.replace("Token: ", "");
	Cookie ck = new Cookie("Token", value);
	driver.manage().addCookie(ck);
	driver.findElement(By.linkText("Proceed")).click();
	Assert.assertTrue(driver.findElement(By.className("finish")).getText().equals("End"));

	
}
   
   
	
}

package pomclassfile;

import static com.qait.utility.WebElementlocator.find_webelement;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class CookieHandling {
	WebDriver driver;

	public CookieHandling(WebDriver driver) {
		this.driver = driver;
	}

	public void clickonproceedwithousettingcookie() {
		((WebElement) find_webelement(driver, "Proceed", "linktext").get(0)).click();
		Assert.assertTrue("unable to set cookies",
				((WebElement) find_webelement(driver, "h1.error", "cssselector").get(0)).isDisplayed());

		driver.navigate().back();

	}

	public void clickonporceedaftersettingcookie() {
		((WebElement) find_webelement(driver, "Generate Token", "linktext").get(0)).click();
		String Token = ((WebElement) find_webelement(driver, "token", "id").get(0)).getText();
		String value = Token.replace("Token: ", "");
		Cookie ck = new Cookie("Token", value);
		driver.manage().addCookie(ck);
		((WebElement) find_webelement(driver, "Proceed", "linktext").get(0)).click();
		WebElement verification = (WebElement) find_webelement(driver, "finish", "classname").get(0);

		Assert.assertTrue(verification.getText().equals("End"));

	}

}

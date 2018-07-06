package pomclassfile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import static com.qait.utility.WebElementlocator.*;

public class Popupwindows {
	WebDriver driver;
	ArrayList tabs;

	public Popupwindows(WebDriver driver) {
		this.driver = driver;

	}

	public void donegativetestingwhenclickedonproceedirectly() {

		((WebElement) find_webelement(driver, "Proceed", "linktext").get(0)).click();
		assertTrue(((WebElement) find_webelement(driver, "h1.error", "cssselector").get(0)).isDisplayed(),
				"unable to verifdy popup window");
		driver.navigate().back();
	}

	public void donegativetestingwhenwelaunchwindowandclickproceedwithoutsendinganykey() {

		((WebElement) find_webelement(driver, "Launch", "partiallinktext").get(0)).click();

		tabs = new ArrayList(driver.getWindowHandles());
		process_popup_and_returnto_main_page(1, -1);
		driver.switchTo().window((String) tabs.get(0));

		((WebElement) find_webelement(driver, "Proceed", "linktext").get(0)).click();
		assertTrue(((WebElement) find_webelement(driver, "h1.error", "cssselector").get(0)).isDisplayed(),
				"unable to verifdy popup window");

		driver.navigate().back();
	}

	public void fillinputwithwordandclicktoproceed() {
		((WebElement) find_webelement(driver, "Launch", "partiallinktext").get(0)).click();

		tabs = new ArrayList(driver.getWindowHandles());
		process_popup_and_returnto_main_page(1, 1);
		driver.switchTo().window((String) tabs.get(0));
		((WebElement) find_webelement(driver, "Proceed", "linktext").get(0)).click();
		WebElement verification = (WebElement) find_webelement(driver, "h1", "tagname").get(0);
		assertTrue(verification.getText().equals("Cookie Handling"),
				"verification failed on popup page popupwindows 56");

	}

	public void process_popup_and_returnto_main_page(int tab_number, int type) {

		driver.switchTo().window((String) tabs.get(tab_number));
		if (type == 1) {
			WebElement input = (WebElement) find_webelement(driver, "name", "id").get(0);
			input.sendKeys("nice");

		} else if (type == -1) {
		}
		WebElement submit = (WebElement) find_webelement(driver, "submit", "id").get(0);
		submit.click();

	}

}

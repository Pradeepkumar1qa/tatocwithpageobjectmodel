package pomclassfile;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.qait.utility.WebElementlocator.*;

public class Tatoc_First_Page {
	WebDriver driver;

	public Tatoc_First_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void click_on_basiccourse() {

		((WebElement) find_webelement(driver, "Basic Course", "linktext").get(0)).click();
	}

	public boolean is_sucess() {
		assertEquals(driver.getTitle(), "Grid Gate - Basic Course - T.A.T.O.C");
		return true;
	}

}

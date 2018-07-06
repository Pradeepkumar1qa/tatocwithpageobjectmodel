package pomclassfile;

import static org.testng.Assert.assertTrue;
import static com.qait.utility.WebElementlocator.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Grid_Gate {
	WebDriver driver;

	public Grid_Gate(WebDriver driver) {
		this.driver = driver;

	}

	public void click_greenbox() {
		WebElement greenbox = (WebElement) find_webelement(driver, "greenbox", "classname").get(0);
		assertTrue(greenbox.isDisplayed(), "unable to display he greenbox");
		greenbox.click();

	}

	public void click_redbox() {

		WebElement redbox = (WebElement)find_webelement(driver,"redbox","classname").get(0);
		redbox.click();
		WebElement verification = (WebElement) find_webelement(driver, "h1.error", "cssselector").get(0);
		assertTrue(verification.isDisplayed(), "unable to load error page");
		driver.navigate().back();

	}

}

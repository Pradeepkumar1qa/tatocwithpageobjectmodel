package pomclassfile;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tatoc_First_Page {
	WebDriver driver;
	
	By basic_course_link=By.linkText("Basic Course");
	
	public Tatoc_First_Page( WebDriver driver) {
        this.driver=driver;		
	}
	public void click_on_basiccourse() {
		driver.findElement(basic_course_link).click();
	}
	public boolean is_sucess() {
		assertEquals(driver.getTitle(),"Grid Gate - Basic Course - T.A.T.O.C");
	       return true;
	}
	
}

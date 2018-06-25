package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pomclassfile.CookieHandling;
import pomclassfile.DragAround;
import pomclassfile.Frame_dungeon;
import pomclassfile.Grid_Gate;
import pomclassfile.Popupwindows;
import pomclassfile.Tatoc_First_Page;

public class Test_the_tatoc {
	WebDriver driver;
	
	Tatoc_First_Page tatocfirstpage;
	Grid_Gate gridgate;
	Frame_dungeon framedungeon;
	DragAround dragaround;
	Popupwindows popupwindow;
	CookieHandling cookiehandle;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pradeepkumar1\\Downloads\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		
	}
	@Test
	public void is_basic_course_clickable() {
		tatocfirstpage=new Tatoc_First_Page(driver);
		tatocfirstpage.click_on_basiccourse();
		}
  
	@Test(dependsOnMethods= {"is_basic_course_clickable"})
	    public void is_redbox_leads_to_error_page() {
		gridgate=new Grid_Gate(driver);
		gridgate.click_redbox();
		
	}
	
	@Test(dependsOnMethods= {"is_redbox_leads_to_error_page"})
	public void check_for_green_box() {
		
		gridgate.click_greenbox();
		
	}
	@Test(dependsOnMethods= {"check_for_green_box"})
	public void click_on_unmatched_box_leads_to_errorpage() {
		framedungeon=new Frame_dungeon(driver);
		framedungeon.unmatched_color_click();
		
	}
	@Test(dependsOnMethods= {"click_on_unmatched_box_leads_to_errorpage"})
	public void matchtheboxcolor() {
		
		framedungeon.match_both_box_color_and_click();
		
	}
	
	@Test(dependsOnMethods= {"matchtheboxcolor"})
	public void dragfunctionality() {
		dragaround=new DragAround(driver);
		dragaround.drag_element_to_box();
		
		
	}
	@Test(dependsOnMethods= {"dragfunctionality"})
	public void proceedingwithoulaunching() {
		popupwindow=new Popupwindows(driver);
		popupwindow.donegativetestingwhenclickedonproceedirectly();
	}
	@Test(dependsOnMethods= {"proceedingwithoulaunching"})
	public void proceedwithlaunchbutemptyinput()
	{
		popupwindow.donegativetestingwhenwelaunchwindowandclickproceedwithoutsendinganykey();
	}
	
	@Test(dependsOnMethods={"proceedwithlaunchbutemptyinput"})
	public void dopositivetestingonlauncwindow() {
		popupwindow.fillinputwithwordandclicktoproceed();
		
	}
	@Test(dependsOnMethods= {"dopositivetestingonlauncwindow"})
	public void do_negative_test_on_cookieseeter_page() {
		cookiehandle=new CookieHandling(driver);
		cookiehandle.clickonproceedwithousettingcookie();
	}
	
	@Test(dependsOnMethods= {"do_negative_test_on_cookieseeter_page"})
	public void do_positive_test_on_cookiesetter_page() {
		cookiehandle.clickonporceedaftersettingcookie();
	}
	
    @AfterClass
    public void end() {
    	System.out.println("you did the basic  challenge successfully thanks");
    }
	

}

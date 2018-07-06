package com.qait.utility;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementlocator {

	public static ArrayList find_webelement(WebDriver driver, String webelementname, String by_type) {
		ArrayList<WebElement> webelements = new ArrayList<WebElement>();
		if (by_type.equals("linktext"))
			return (ArrayList<WebElement>) driver.findElements(By.linkText(webelementname));
		else if (by_type.equals("partiallinktext"))
			return (ArrayList) driver.findElements(By.partialLinkText(webelementname));
		else if (by_type.equals("id"))
			return (ArrayList) driver.findElements(By.id(webelementname));
		else if (by_type.equals("classname"))
			return (ArrayList) driver.findElements(By.className(webelementname));
		else if (by_type.equals("cssselector"))
			return (ArrayList<WebElement>) driver.findElements(By.cssSelector(webelementname));
		else if(by_type.equals("tagname"))
			return (ArrayList<WebElement>) driver.findElements(By.tagName(webelementname));
		else {
			System.out.println("nothing has been found on this page");
			return webelements;
		}

	}

}

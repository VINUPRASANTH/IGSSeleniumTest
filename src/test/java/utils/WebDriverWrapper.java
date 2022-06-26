package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWrapper {
	
public static WebElement getWebElement(WebDriver driver, By by) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	try {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}catch(Exception e) {
		System.out.println(e.toString());
	}
	return null;
}

public static WebElement getWebElement(WebDriver driver, By by, int timeout) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	try {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}catch(Exception e) {
		System.out.println(e.toString());
	}
	return null;
}
public static boolean verifyTextToBePresentInElement(WebDriver driver, By by, String value,int timeout) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	try {
		boolean element = wait.until(ExpectedConditions.textToBe(by, value));
		return element;
	}catch(Exception e) {
		System.out.println(e.toString());
	}
	return false;
}

public static void clickButton(WebDriver driver, By by, int timeout) {
	try {
		WebElement element = getWebElement(driver,by,timeout);
		if(element != null) {
			element.click();
		}
		
	}catch(Exception e) {
		System.out.println(e.toString());
		//soft assertion needs to be added
	}
}
public static void sendKeys(WebDriver driver, By by, String value, int timeout) {
	try {
		WebElement element = getWebElement(driver,by,timeout);
		if(element != null) {
			element.sendKeys(value);
		}
		
	}catch(Exception e) {
		System.out.println(e.toString());
		//soft assertion needs to be added
	}
}

public static void selectDropDownByValue(WebDriver driver, By by, String value, int timeout){
	try {
		Select dropDown = new Select(getWebElement(driver,by,timeout));
		dropDown.selectByVisibleText(value);
	}catch(Exception e) {
		System.out.println(e.toString());
		//soft assertion needs to be added
	}
}

public static WebElement getDropDownSelectedValue(WebDriver driver, By by, int timeout){
	try {
		Select dropDown = new Select(getWebElement(driver,by,timeout));
		WebElement option = dropDown.getFirstSelectedOption();
		return option;
	}catch(Exception e) {
		System.out.println(e.toString());
		//soft assertion needs to be added
	}
	return null;
}

public static String getElementText(WebDriver driver, By by, int timeout) {
	try {
		WebElement element = getWebElement(driver,by,timeout);
		if(element != null) 
			return element.getText();
		
	}catch(Exception e) {
		System.out.println(e.toString());
		//soft assertion needs to be added
	}
	return null;
}

}

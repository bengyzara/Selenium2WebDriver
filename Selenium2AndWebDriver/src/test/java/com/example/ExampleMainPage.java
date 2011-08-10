package com.example;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExampleMainPage {

	WebDriver p_driver = null;

	public ExampleMainPage(WebDriver driver, String url) {
		p_driver = driver;
		try {
			p_driver.get(url);
		} catch (RuntimeException e) {
			System.out.println(e.getCause().getMessage());
		}
	}

	public String inputField_old(String ElementIDOrName,String username) {
		
		WebElement element = getElementByIDOrName(ElementIDOrName);
		try {
			element.sendKeys(username);
			return "Sucess";
		} catch (RuntimeException e) {
			System.out.println("input action error!" + "\r\n"
					+ e.getCause().getMessage());
			return null;
		}
	}
	
	public WebElement InputField(String ElementIDOrName) {
		
		return null;
	}
	public WebElement Button_InputField(String valueOfElement)
	{
		WebElement element = p_driver.findElement((By.cssSelector("input[value='" + valueOfElement + "']")));
		return element;
	}
	
	private WebElement getElementByIDOrName(String ElementIDOrName) {
		WebElement element = null;
		try {
			element = p_driver.findElement(By.id(ElementIDOrName));
			if(element == null){
				element = p_driver.findElement(By.name(ElementIDOrName));
			}
			return element;
		} catch (RuntimeException e) {
			System.out.println("Can't find element by id {username} " + "\r\n"
					+ e.getCause().getMessage());
			return null;
		}	
	}

	public int getElementScreenLeft(WebElement element) {
		if (p_driver != null){
			throw new RuntimeException("There's not WebDriver Instance"); 
		}
		JavascriptExecutor js = (JavascriptExecutor) p_driver;
		int screenLeft = Integer.parseInt(js.executeScript("return window.screenLeft").toString()) + element.getLocation().getX();
		return screenLeft;
	}
	
	public int getElementScreenTop(WebElement element) {
		if (p_driver != null){
			throw new RuntimeException("There's not WebDriver Instance"); 
		}
		JavascriptExecutor js = (JavascriptExecutor) p_driver;
		int ScreenTop = Integer.parseInt(js.executeScript("return window.screenTop").toString()) + element.getLocation().getY();
		return ScreenTop;
	}
	
	public List<WebElement> getElementByClass(String ClassName) {
		List<WebElement> elements = null;
		try{
			elements = p_driver.findElements(By.className(ClassName));
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println(e.getCause().getMessage());
		}
		return elements;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

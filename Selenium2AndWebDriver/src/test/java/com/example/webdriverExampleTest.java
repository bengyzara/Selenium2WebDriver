package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class webdriverExampleTest {

	String mainURL = "";
	WebDriver driver = null;

	@BeforeTest
	public void startBrowser() {
		// TODO Auto-generated method stub
		mainURL = "http://192.168.1.130:28899/stdpm/";
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		driver = new InternetExplorerDriver(capabilities);
	}

	@Test
	public void login() {
		ExampleMainPage mainPage = new ExampleMainPage(driver, mainURL);
		mainPage.inputField("username", "sysadmin");
		mainPage.inputField("password", "1");
		long startTime = System.nanoTime();
		mainPage.ClickButton("登 录");
		System.out.println("打开登录页面耗时" + (System.nanoTime() - startTime)
				/ 1000000000.0 + "s");
		System.out.println("登录后页面的标题为：" + driver.getTitle());

	}

	@AfterTest
	public void colseBrowser() {
		driver.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * String mainURL = "http://192.168.1.55:8080/stdpm/";
		 * webdriverExampleTest exam = new webdriverExampleTest();
		 * 
		 * DesiredCapabilities capabilities =
		 * DesiredCapabilities.internetExplorer();
		 * capabilities.setCapability(InternetExplorerDriver
		 * .INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); WebDriver
		 * driver = new InternetExplorerDriver(capabilities); ExampleMainPage
		 * mainPage = new ExampleMainPage(driver, mainURL);
		 * 
		 * mainPage.inputField("username", "sysadmin");
		 * mainPage.inputField("password", "1"); long startTime =
		 * System.nanoTime(); mainPage.ClickButton("登录"); // long elapsedTime =
		 * TimeUnit.SECONDS.convert(System.nanoTime()-startTime,
		 * TimeUnit.NANOSECONDS);
		 * System.out.println((System.nanoTime()-startTime)/1000000000.0 + "s");
		 * exam.println(driver.getTitle()); //driver.close();
		 */
	}

}

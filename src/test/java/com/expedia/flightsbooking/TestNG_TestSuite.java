package com.expedia.flightsbooking;

import page.classes.HomePage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_TestSuite {
	private WebDriver driver;
	private String baseURL;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		baseURL = "https://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() {
		HomePage.navigateToFlightTab(driver);
		HomePage.fillOriginTextBox(driver, "New York");
		HomePage.fillDestinationTextBox(driver, "Chicago");
		HomePage.fillDepartureDateTextBox(driver, "09/04/2017");
		HomePage.returnDateTextBox(driver).clear();
		HomePage.fillReturnDateTextBox(driver, "10/08/2017");;
		HomePage.clickOnSearchButton(driver);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}

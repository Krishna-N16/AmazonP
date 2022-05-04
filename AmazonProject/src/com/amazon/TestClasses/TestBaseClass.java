package com.amazon.TestClasses;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class TestBaseClass {

	WebDriver driver;
	@BeforeMethod
	public void setUpMethod()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kk\\Desktop\\chromedriver.exe");
		System.out.println("Properties are set for chrome driver");
	
	    driver =  new ChromeDriver();
	    System.out.println("Browser is opened");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		System.out.println("Amazon homepage is opened");
		driver.manage().window().maximize();
		
	}
	@AfterMethod 
	public void tearDown()
	{
		driver.quit();
		System.out.println("Browser is closed");
	}
	
	@DataProvider(name="LinkName")
	public String [][] name()
	{
		String[][] linkName = {
				{"COVID-19 and Amazon"},
				{"Your Account"},
				{"Returns Centre"},
				{"100% Purchase Protection"},
				{"Amazon App Download"},
				{"Amazon Assistant Download"},
				{"Help"}
		                      };
		return linkName;
	}
	}
























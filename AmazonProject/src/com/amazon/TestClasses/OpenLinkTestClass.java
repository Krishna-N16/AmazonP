package com.amazon.TestClasses;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import com.amazon.POMClasses.HomePage;
import graphql.Assert;

public class OpenLinkTestClass extends TestBaseClass {

	@Test(dataProvider="LinkName")
	public void linkOpen(String lName) throws AWTException, InterruptedException
	{
		HomePage h = new HomePage(driver);
		h.openLink(lName);
		System.out.println("Link in new tab is opened");
		List <String> handles= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(1));
		System.out.println("Focus is switched to link tab");
		System.out.println("Title of link page = "+driver.getTitle());
		driver.switchTo().window(handles.get(0));
		System.out.println("Focus switched back to homepage");
		String exp = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String act = driver.getTitle();
		
		if (exp.equals(act))
		{
			System.out.println("Returned to homepage");
			System.out.println("Title = "+act);
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Test is failed");
			Assert.assertTrue(false);
		}
	}
	
	
}

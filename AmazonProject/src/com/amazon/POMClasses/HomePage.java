package com.amazon.POMClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	private Actions act;
	private Robot rob;
	
	@FindBy(xpath="//div[text()='Let Us Help You']//parent::div[01]//child::ul//child::li//child::a")
	private List <WebElement> links;
	
	
	public HomePage(WebDriver driver) throws AWTException
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		act= new Actions(driver);
		rob = new Robot();
	}

	public void openLink(String linkName) throws InterruptedException
	{
		for (int i= 0; i<links.size();i++)
		{
			String s= links.get(i).getText();
			if (s.equals(linkName))
			{
				act.moveToElement(links.get(i)).build().perform();
				act.contextClick(links.get(i)).build().perform();
				rob.keyPress(KeyEvent.VK_DOWN);
				rob.keyPress(KeyEvent.VK_ENTER);
			}
			s="";
		}
	}
	
}






















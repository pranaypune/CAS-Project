package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TestCase01 extends BaseClass {
	
	@Test  
	void test1() {
		
		WebDriverWait wait  =  new WebDriverWait(driver,Duration.ofSeconds(30));
		
		//Clicking on the profile icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("O365_MainLink_Help_container")));
		WebElement ele = driver.findElement(By.id("meInitialsButton"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).perform();
		ac.doubleClick(ele).perform();
		
		
		//Capturing the user information
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mectrl_currentAccount_primary")));
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"\\ScreenShot\\Photo1.png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(driver.findElement(By.id("mectrl_currentAccount_primary")).getText(),"Datta, Pranay (Contractor)");
		Assert.assertEquals(driver.findElement(By.id("mectrl_currentAccount_secondary")).getText(),"2318211@cognizant.com");
		
	}
	
	
}

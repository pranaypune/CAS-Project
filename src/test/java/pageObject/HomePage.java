package pageObject;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import testBase.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[@name='Company']") WebElement company;
	@FindBy(xpath="//div/span[text()='Acronyms']") WebElement acronym;
	@FindBy(xpath="//div[@class='stockValue_60e60a8c']") WebElement ctsprice;
	@FindBy(xpath="//span[@class='stockInfoDetailElement_60e60a8c'][1]")WebElement ctsprice1;
	@FindBy(xpath="//span[@class='stockInfoDetailElement_60e60a8c'][2]")WebElement ctsprice2;
	
	
	public void clickcom() {
		company.click();
	}
	
	public void clickacro() {
		acronym.click();
	}
	
	public String[] getstock() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.querySelector(\"[data-is-scrollable='true']\").scrollBy(0,4000)");
		//js.executeScript("document.getElementsByClassName('c_a_beed2cf1 b_a_beed2cf1 f_a_beed2cf1 g_a_beed2cf1')[0].scrollBy(0,1800)");
		Thread.sleep(1000);
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"\\ScreenShot\\Photo3.png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String pricee=ctsprice.getText();
		String pricee1=ctsprice1.getText();
	    String pricee2=ctsprice2.getText();
	    String arr1[] = new String[3];
	    arr1[0] = pricee;
	    arr1[1] = pricee1;
	    arr1[2] = pricee2;
	    return arr1;
	     
		
	}

}

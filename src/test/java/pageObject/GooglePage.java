package pageObject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.BasePage;


public class GooglePage  extends BasePage{
    
	  
	 public GooglePage(WebDriver driver){
	
		super(driver);
		
	}
	 	
	   
	@FindBy(xpath="//span[contains(@class,'IsqQVc NprOob')]")WebElement stockGo;
	@FindBy(xpath="//span[@class='WlRRw IsqQVc fw-price-dn']/span[@jsname=\"qRSVye\"]")WebElement stockGo1;
	@FindBy(xpath="//div[@class='wGt0Bc']//span[@jsname='rfaVEf']")WebElement stockGo2;
	
	

		
		
		public String[] getgprice()  
		{
		 
		 driver.get("https://www.google.com/search?q=ctsh+share+price+opening&rlz=1C1GCEU_enIN1094IN1094&oq=ctsh&gs_lcrp=EgZjaHJvbWUqBggAEEUYOzIGCAAQRRg7Mg8IARBFGDsYgwEYsQMYgAQyBggCEEUYOzINCAMQABiDARixAxiABDIHCAQQABiABDIHCAUQABiABDIHCAYQABiABDINCAcQABiDARixAxiABDIHCAgQABiABDIHCAkQABiABNIBCDIzNjBqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8");
		 
		 TakesScreenshot ts = ((TakesScreenshot) driver);
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(System.getProperty("user.dir")+"\\ScreenShot\\Photo4.png");
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
//		 Thread.sleep(5000);
	     String price=stockGo.getText();
	     String price1=stockGo1.getText();
	     String price2=stockGo2.getText();
	     String arr[] = {price,price1,price2};
	     return arr;
	     
	     
	     
			
	     
		}
		
		
	
}

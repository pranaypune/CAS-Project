package testCases;

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import pageObject.HomePage;
import testBase.BaseClass;

public class TestCase02 extends BaseClass{

	@Test   
	public void test2() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.clickcom();
		hp.clickacro();
		Thread.sleep(3000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.querySelector(\"[data-is-scrollable='true']\").scrollBy(0,2000)");
		
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"\\ScreenShot\\Photo2.png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

 //storing all the data into Excel
		List<WebElement>list = driver.findElements(By.xpath("//tr/td"));
		File file = new File(System.getProperty("user.dir")+"\\CASPROJECT.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		 XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		 XSSFSheet sheet=wb.getSheet("Sheet1");
		int j=0;   
	for(int i=0;i<list.size()/2;i++) {
			 XSSFRow row=sheet.createRow(i);
			 row.createCell(0).setCellValue(list.get(j).getText());
			 row.createCell(1).setCellValue(list.get(j+1).getText());
			 System.out.println(list.get(j).getText()+list.get(j+1).getText());
			 j=j+2;
	}
		FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"\\CASPROJECT.xlsx");
		  wb.write(outputStream);
		  wb.close();
	}

}

















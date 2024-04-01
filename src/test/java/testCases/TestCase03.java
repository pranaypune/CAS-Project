package testCases;

import pageObject.HomePage;
import testBase.BaseClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.GooglePage;

public class TestCase03 extends BaseClass{
    
	@Test  
	void test1() throws Exception {
		HomePage hp=new HomePage(driver);
		GooglePage gp=new GooglePage(driver);

		String[] cogprice=hp.getstock();
		String cogprice1=cogprice[0];
		String cogprice2= cogprice[1];
		String cogprice3= cogprice[2];
		
		
		String[] googprice=gp.getgprice();
		String googprice1= googprice[0];
		String googprice2=googprice[1];
		String googprice3=googprice[2];
		
				
		
		SoftAssert Assert = new SoftAssert();
		Assert.assertEquals(cogprice1,googprice1,"Not updated with the Google Data");
		Assert.assertEquals(cogprice2,googprice2,"Not updated with the Google Data");
		Assert.assertEquals(cogprice3,googprice3,"Not updated with the Google Data");
		 
				
	}
	

	

}

package TestNgTestcases;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelUtility.ExcelUtility;
import JavaUtlity.JavaUtility;
import POM.CampaignPage;
import POM.HomePage;
import WebDriverUtlity.WebDriverUtlity;
@Listeners(ListenersUtility.ListenersImplementation.class)

public class createStatus  extends BaseClass {
	

@Test(groups="Regression")
	public void createStatus() throws EncryptedDocumentException, IOException, InterruptedException {
		
		ExcelUtility eutil = new ExcelUtility();
		WebDriverUtlity wutil= new WebDriverUtlity();
		JavaUtility jutil = new JavaUtility();
//Read data from excel
		String campname = eutil.getDataFromExcel("Campaign", 1, 2);
		String size = eutil.getDataFromExcel("Campaign", 1, 3);
		String status = eutil.getDataFromExcel("Campaign", 1, 4);
		//click on create Campaign button
		HomePage hp = new HomePage(driver);
		hp.getCreateCampaign().click();
		//enter mandatory fields
		CampaignPage cp = new CampaignPage(driver);
		cp.getCampiagnName().sendKeys(campname);//+ jutil.getRandomNumber());
		cp.getTargetSize().sendKeys(size);
		cp.getCampaignStatus().sendKeys(status);
		cp.getCreateCampaign().click();
		
		 //validation
		Thread.sleep(2000);
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		Thread.sleep(2000);
		
		wutil.waitforVisibilityofElement(driver, toast);
		String msg = toast.getText();
		Assert.assertEquals(msg,"Campaign "+campname+" Successfully Added");
		Assert.assertTrue(msg.contains(campname));
		/*if(msg.contains(campname)) {
		System.out.println("campaign is created");
		}
		else{
		System.out.println("campaign not created");
		Thread.sleep(2000);
		}*/
		//driver.findElement(By.xpath("//button[@arialabel='close']")).click();
		 

	}

}

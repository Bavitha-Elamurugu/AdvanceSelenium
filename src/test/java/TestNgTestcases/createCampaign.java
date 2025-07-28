package TestNgTestcases;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelUtility.ExcelUtility;
import JavaUtlity.JavaUtility;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtlity.WebDriverUtlity;
@Listeners(ListenersUtility.ListenersImplementation.class)

public class createCampaign extends BaseClass {
       @Test(groups="Smoke")

	   public void createCampaign() throws EncryptedDocumentException, IOException, InterruptedException {
			
			ExcelUtility eutil = new ExcelUtility();
			WebDriverUtlity wutil= new WebDriverUtlity();
			JavaUtility jutil = new JavaUtility();
			
			String campname = eutil.getDataFromExcel("Campaign", 1, 2);
			String size = eutil.getDataFromExcel("Campaign", 1, 3);
			
	
			//click on home page
			HomePage hp = new HomePage(driver);
			//create Campaign
			hp.getCreateCampaign().click();
		
			//enter mandatory details
			
			CampaignPage cp = new CampaignPage(driver);
			cp.getCampiagnName().sendKeys(campname);//+ jutil.getRandomNumber());
			cp.getTargetSize().sendKeys(size);
			cp.getCreateCampaign().click();
			
			
			//validation
			Thread.sleep(2000);
			WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));

			Thread.sleep(2000);
			wutil.waitforVisibilityofElement(driver, toast);
			String msg = toast.getText();
			
			Thread.sleep(4000);
			Assert.assertTrue(msg.contains(campname));
			//Assert.assertTrue(msg.contains(campname));
			driver.findElement(By.xpath("//button[@arialabel='close']")).click();

			}
			//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
			
		}
		
	


;
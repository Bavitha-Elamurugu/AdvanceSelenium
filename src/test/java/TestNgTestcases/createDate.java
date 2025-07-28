package TestNgTestcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
public class createDate extends BaseClass {
@Test(groups="Smoke")
	public void createDate() throws EncryptedDocumentException, IOException, InterruptedException{
		// TODO Auto-generated method stub
		
		
		
		ExcelUtility eutil = new ExcelUtility();
		WebDriverUtlity wutil= new WebDriverUtlity();
		JavaUtility jutil = new JavaUtility();
		
		String campname = eutil.getDataFromExcel("Campaign", 1, 2);
		String size = eutil.getDataFromExcel("Campaign", 1, 3);
		String status = eutil.getDataFromExcel("Campaign", 1, 4);
		String dateReq = jutil.togetRequired(30);
	
		
		HomePage hp = new HomePage(driver);
		hp.getCreateCampaign().click();
		
		CampaignPage cp = new CampaignPage(driver);
		cp.getCampiagnName().sendKeys(campname);//+ jutil.getRandomNumber());
		cp.getTargetSize().sendKeys(size);
		WebElement closeDate = cp.getExpectedCloseDate();
		wutil.passinput(driver, closeDate, dateReq);
		
		cp.getCreateCampaign().click();
		
		
		//validation
		Thread.sleep(2000);
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));

		Thread.sleep(2000);
		wutil.waitforVisibilityofElement(driver, toast);
		String msg = toast.getText();
		Thread.sleep(2000);
		Assert.assertTrue(msg.contains(campname));
		/*if(msg.contains(campname)) {
		System.out.println("campaign is created");
		}
		else{
		System.out.println("campaign not created");
		Thread.sleep(2000);*/
		
		}
	//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	
	

}

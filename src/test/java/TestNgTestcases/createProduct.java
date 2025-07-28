package TestNgTestcases;

import java.io.IOException;

import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelUtility.ExcelUtility;
import JavaUtlity.JavaUtility;
import POM.AddProduct;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtlity.WebDriverUtlity;
@Listeners(ListenersUtility.ListenersImplementation.class)

public class createProduct extends BaseClass {
	@Test

	public void createProduct() throws EncryptedDocumentException, IOException, InterruptedException{
		// TODO Auto-generated method stub
		
		
		ExcelUtility eutil = new ExcelUtility();
		WebDriverUtlity wutil= new WebDriverUtlity();
		JavaUtility jutil = new JavaUtility();
		//Read data from excel
		String pname = eutil.getDataFromExcel("Product", 1, 2);
		String psize = eutil.getDataFromExcel("Product", 1, 3);
		String pprice = eutil.getDataFromExcel("Product", 1, 4);
		
		//click on home page
		HomePage hp = new HomePage(driver);
		hp.getProducts().click();
	
		
		//Create Product
        hp.getAddProduct().click();
       
        
		AddProduct ap=new AddProduct(driver);
		
		ap.getProductName().sendKeys(pname);//+jutil.getRandomNumber());
		
       
        
        wutil.select(ap.getProductCategory(),2);
        wutil.select(ap.getVendorId(), 3);
       
        ap.getQuantity().clear();
        ap.getQuantity().sendKeys(psize);
       
         ap.getPrice().clear();
         ap.getPrice().sendKeys(pprice);
         ap.getAddButton().click();
         Thread.sleep(2000);
        
      //Validation
         hp.getCloseButton().click();
      		
      		/*WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
      		wutil.waitforVisibilityofElement(driver, toast);
      		String msg = toast.getText();
		
		if(msg.contains(pname))
		{
			System.out.println("Product  is Added");
		}
		else
		{
			System.out.println("Product  is not Added");
		}
		
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		*/
	}

}

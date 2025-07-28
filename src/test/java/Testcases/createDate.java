package Testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelUtility.ExcelUtility;
import JavaUtlity.JavaUtility;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtlity.WebDriverUtlity;

public class createDate {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PropertiesUtility putil = new PropertiesUtility();
		String BROWSER = putil.getdatafrompropertiesfile("Browser");
		String URL = putil.getdatafrompropertiesfile("URL");
		String USERNAME = putil.getdatafrompropertiesfile("Username");
		String PASSWORD= putil.getdatafrompropertiesfile("Password");
		
		ExcelUtility eutil = new ExcelUtility();
		String campname = eutil.getDataFromExcel("Campaign", 1, 2);
		String size = eutil.getDataFromExcel("Campaign", 1, 3);
		String status = eutil.getDataFromExcel("Campaign", 1, 4);
		
		WebDriverUtlity wutil= new WebDriverUtlity();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		wutil.waitForPageToload(driver);
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPW().sendKeys(PASSWORD);
		lp.getLOGINBUTTON().click();
		/*driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		*/
		
		//Random ran=new Random();
		//int rancount = ran.nextInt(1000);
		JavaUtility jutil = new JavaUtility();
		
		/*Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("MM-dd-YYYY");
		sim.format(date);
		Calendar cal = sim.getCalendar();
		jutil.getCurrentDate();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String dateReq = sim.format(cal.getTime());*/
		String dateReq = jutil.togetRequired(30);
		
		//Create campign
		//click on home page
		HomePage hp = new HomePage(driver);
		hp.getCreateCampaign().click();
		//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		CampaignPage cp = new CampaignPage(driver);
		cp.getCampiagnName().sendKeys(campname+ jutil.getRandomNumber());
		cp.getTargetSize().sendKeys(size);
		
		/*driver.findElement(By.name("campaignName")).sendKeys(campname+jutil.getRandomNumber());
		WebElement targerSize = driver.findElement(By.name("targetSize"));
		targerSize.clear();
		targerSize.sendKeys(size);*/
		//WebElement closeDate = driver.findElement(By.name("expectedCloseDate"));
		WebElement closeDate = cp.getExpectedCloseDate();
		
		//Actions act1=new Actions(driver);
		//act1.click(closeDate).sendKeys(dateReq).perform();
		wutil.passinput(driver, closeDate, dateReq);
		//closeDate.sendKeys(dateReq).perform();
		cp.getCreateCampaign().click();
		//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		//Validation
		//hp.getToastmsg();
		// hp.getClosemsg();
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(toast));
		wutil.waitforVisibilityofElement(driver, toast);
		String msg = toast.getText();
		if(msg.contains(campname))
		{
			System.out.println("campign is creatred");
		}
		else {
	
		System.out.println("campaign not created");
	}
	driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	//logout
	
	hp.getUserIcon().click();
	hp.getLogOut().click();
	
	/*WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
	wutil.mouseHoverOnWebElement(driver, icon);
	//Actions act = new Actions(driver);
	// act.moveToElement(icon).perform();
	WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
	 // act.moveToElement(logout).click().perform();
	wutil.clickonWebElement(driver, logout);
	*/
}
}

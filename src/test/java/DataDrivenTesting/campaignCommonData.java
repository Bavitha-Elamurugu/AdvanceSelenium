package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class campaignCommonData {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Sathish\\Desktop\\CampaignData.properties");
		//FileInputStream fis=new FileInputStream("./configData/ninzacrmCommonData.properties");
		//Create object
		Properties prop=new Properties();
		//load
		prop.load(fis);
		//get properties
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("URL");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");
		String CAMPAIGNNAME = prop.getProperty("CampaignName");
		String CAMPAIGNSTATUS = prop.getProperty("CampaignStatus");
		String TARGETSIZE = prop.getProperty("TargetSize");
		String CLOASEDATE = prop.getProperty("CloaseDate");
		
		WebDriver driver=null;
		if(BROWSER.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		if(BROWSER.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		if(BROWSER.equals("FireFox"))
		{
			driver=new FirefoxDriver();
		}
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		//Create campign
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(CAMPAIGNNAME);
		driver.findElement(By.name("campaignStatus")).sendKeys(CAMPAIGNSTATUS);
		WebElement targerSize = driver.findElement(By.name("targetSize"));
		targerSize.clear();
		targerSize.sendKeys(TARGETSIZE);
		WebElement closeDate = driver.findElement(By.name("expectedCloseDate"));
		closeDate.sendKeys(CLOASEDATE);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		//Validation
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toast));
		String msg = toast.getText();
		
		if(msg.contains("TN23"))
		{
			System.out.println("campign is creatred");
		}
		else
		{
			System.out.println("campign is creatred");
		}
		
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		//logout
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions action=new Actions(driver);
		action.moveToElement(icon).perform();
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		action.moveToElement(logout).click().perform();

	}

}

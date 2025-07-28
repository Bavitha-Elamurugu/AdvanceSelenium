package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class propertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	FileInputStream fis=new FileInputStream("C:\\Users\\Sathish\\Desktop\\ninzacrmCommonData.properties");
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
		
		//Actual Script
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		

	}

}

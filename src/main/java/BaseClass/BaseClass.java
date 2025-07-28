package BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;

public class BaseClass {
 public WebDriver driver=null;
 public static WebDriver sdriver=null;
 public PropertiesUtility putil=new PropertiesUtility();
 
 @BeforeSuite(groups= {"Smoke","Regression"})
 public void beforesuite() {
 Reporter.log("DB Connectivity open",true);
}
 @BeforeTest(groups= {"Smoke","Regression"})
 public void beforetest() {
 Reporter.log("pre conditions",true);
 }
// @Parameters("BROWSER")(String BROWSER)
 @BeforeClass(groups= {"Smoke","Regression"})
 public void beforeclass() throws IOException {
 String BROWSER = putil.getdatafrompropertiesfile("Browser");
   if(BROWSER.equals("Edge")) {
	driver=new EdgeDriver();
}
   if(BROWSER.equals("Chrome")) {
	driver=new ChromeDriver();
}
   if(BROWSER.equals("Firefox")) {
		driver=new FirefoxDriver();
	}
   sdriver=driver;
   System.out.println("lauching Browser");
   driver.manage().window().maximize();
 }
 @BeforeMethod(groups= {"Smoke","Regression"})
 public void beforemethod() throws IOException {
	    String BROWSER = putil.getdatafrompropertiesfile("Browser");
		String URL = putil.getdatafrompropertiesfile("URL");
		String USERNAME = putil.getdatafrompropertiesfile("Username");
		String PASSWORD= putil.getdatafrompropertiesfile("Password");
		driver.get(URL);

	 LoginPage lp=new LoginPage(driver);
	 lp.getUN().sendKeys(USERNAME);
	 lp.getPW().sendKeys(PASSWORD);
	 lp.getLOGINBUTTON().click();
	 System.out.println("LOGIN DONE");
}
 @AfterMethod
 public void aftermethod() {
HomePage hp=new HomePage(driver);
hp.getUserIcon().click();
hp.getLogOut().click();
System.out.println("LOGOUT DONE");
 }
 @AfterClass
 public void afterclass() {
 Reporter.log("closing browser",true);
 }
 @AfterTest
 public void aftertest() {
 Reporter.log("post conditions",true);
 }
 @AfterSuite
 public void aftersuite() {
 Reporter.log("DB connectivity close",true);
 }
 
 
 
 
 
 }
 

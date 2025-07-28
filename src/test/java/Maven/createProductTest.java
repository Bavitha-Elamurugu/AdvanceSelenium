package Maven;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;

import ExcelUtility.ExcelUtility;
import JavaUtlity.JavaUtility;
import POM.AddProduct;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtlity.WebDriverUtlity;
@Listeners(ListenersUtility.ListenersImplementation.class)


public class createProductTest {

public static void main(String[] args) throws IOException, InterruptedException {
	// TODO Auto-generated method stub
	PropertiesUtility putil = new PropertiesUtility();
	String BROWSER = putil.getdatafrompropertiesfile("Browser");
	String URL = putil.getdatafrompropertiesfile("URL");
	String USERNAME = putil.getdatafrompropertiesfile("Username");
	String PASSWORD= putil.getdatafrompropertiesfile("Password");
	
	ExcelUtility eutil = new ExcelUtility();
	String pname = eutil.getDataFromExcel("Product", 1, 2);
	String psize = eutil.getDataFromExcel("Product", 1, 3);
	String pprice = eutil.getDataFromExcel("Product", 1, 4);
	
	
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(URL);
	LoginPage lp = new LoginPage(driver);
	lp.getUN().sendKeys(USERNAME);
	lp.getPW().sendKeys(PASSWORD);
	lp.getLOGINBUTTON().click();
	/*driver.findElement(By.id("username")).sendKeys(USERNAME);
	driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	*/
	
	////click on home page
	HomePage hp = new HomePage(driver);
	hp.getProducts().click();
	//driver.findElement(By.linkText("Products")).click()
	
	//Create Product
	
	JavaUtility jutil=new JavaUtility();
	
	
	hp.getAddProduct().click();
   // driver.findElement(By.xpath("//span[text()='Add Product']")).click();
	
    //driver.findElement(By.name("productName")).sendKeys(pname+jutil.getRandomNumber());
    
	AddProduct ap=new AddProduct(driver);
	//WebElement prodCategory = ap.getProductCategory();
	ap.getProductName().sendKeys(pname);//+jutil.getRandomNumber());
	
   
    WebDriverUtlity wutil=new WebDriverUtlity();
    
    wutil.select(ap.getProductCategory(),2);
    wutil.select(ap.getVendorId(), 3);
   
    ap.getQuantity().clear();
    ap.getQuantity().sendKeys(psize);
   
     ap.getPrice().clear();
     ap.getPrice().sendKeys(pprice);
     ap.getAddButton().click();
    
  //Validation
  		//hp.getToastmsg();
  		// hp.getClosemsg();
     Thread.sleep(2000);
  		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
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
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	
	//logout
	hp.getUserIcon().click();
	hp.getLogOut().click();
	
}
}


package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
  WebDriver driver;
 public HomePage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 
 @FindBy(linkText="Campaigns")
 private WebElement Campaigns;

 @FindBy(linkText="Products")
 private WebElement Products;

 @FindBy(linkText="Contacts")
 private WebElement Contacts;
 
 @FindBy(xpath="//span[text()='Create Campaign']")
 private WebElement createCampaign;

 @FindBy(className="user-icon")
 private WebElement userIcon;
 
 @FindBy(xpath="//div[text()='Logout ']")
 private WebElement LogOut;
 
 @FindBy(xpath="//div[@role='alert']")
 private WebElement toastmsg;
 
 @FindBy(xpath="//button[@aria-label='close']")
 private WebElement closeButton;
 
@FindBy(xpath="//span[text()='Add Product']")
 private WebElement AddProduct;

 public WebElement getCampaigns() {
	return Campaigns;
}

public WebElement getProducts() {
	return Products;
}

public WebElement getContacts() {
	return Contacts;
}

public WebElement getCreateCampaign() {
	return createCampaign;
}

public WebElement getAddProduct() {
	return AddProduct;
}

public WebElement getUserIcon() {
	return userIcon;
}

public WebElement getLogOut() {
	return LogOut;
}

public WebElement getToastmsg() {
	return toastmsg;
}

public WebElement getCloseButton() {
	return closeButton;
}
 
}

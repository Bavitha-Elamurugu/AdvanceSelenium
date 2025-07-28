package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	WebDriver driver;
	public CampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="campaignName")
	private WebElement campiagnName;
	
	@FindBy(name="campaignStatus")
	private WebElement campaignStatus;
	
	@FindBy(name="targetSize")
	private WebElement targetSize;
	
	@FindBy(name="expectedCloseDate")
	private WebElement expectedCloseDate;
	
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement CreateCampaignButton;
	public WebElement getCampiagnName() {
		return campiagnName;
	}


	public WebElement getCampaignStatus() {
		return campaignStatus;
	}


	public WebElement getTargetSize() {
		return targetSize;
	}


	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}


	public WebElement getCreateCampaign() {
		return CreateCampaignButton;
	}
	
	
	
	
	

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contactuspage extends PageBase {

	public Contactuspage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id="FullName")
	public WebElement fullnametxt;
	
	@FindBy(id="Email")
	public WebElement emailtxt;
	
	@FindBy(id="Enquiry")
	public WebElement enquirytxt;
	
	@FindBy(name="send-email")
	public WebElement submitbtn;
	
	@FindBy(css="div.result")
	public WebElement sucessmess;
	
	public void contactus(String fullname,String email,String message)
	{
		SetTextElementText(fullnametxt, fullname);
		SetTextElementText(emailtxt, email);
		SetTextElementText(enquirytxt, message);
		clickbutton(submitbtn);
	}
	
	
	
	

}

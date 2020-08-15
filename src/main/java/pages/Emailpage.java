package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Emailpage extends PageBase {

	public Emailpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id="FriendEmail")
	WebElement EmailfriendTxt;
	
	@FindBy(id="PersonalMessage")
	WebElement personalmessageTxt;
	
	@FindBy(name="send-email")
	WebElement sendemailBtn;
	
	@FindBy(css="div.result")
	public WebElement messageNotification;
	
	public void sendemailtofriend(String emailfriend,String personalMessage)
	{
		SetTextElementText(EmailfriendTxt, emailfriend);
		SetTextElementText(personalmessageTxt, personalMessage);
		clickbutton(sendemailBtn);
	}

}

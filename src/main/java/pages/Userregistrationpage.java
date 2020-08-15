package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Userregistrationpage extends PageBase {

	public Userregistrationpage(WebDriver driver) {
		super(driver);
		
	}
@FindBy(id="gender-male")
WebElement GenderRdoBtn;

@FindBy(id="FirstName")
WebElement fnTextBox;

@FindBy(id="LastName")
WebElement LnTxtBox;

@FindBy(id="Email")
WebElement emailTxtBox;

@FindBy(id="Password")
WebElement passwordTxtBox;

@FindBy(id="ConfirmPassword")
WebElement confirmpasswordTextbox;

@FindBy(id="register-button")
WebElement registerBtn;

@FindBy(css="div.result")
public WebElement sucessmessage;

@FindBy(linkText="Log out")
public WebElement logoutlink;

@FindBy (linkText="My account")
WebElement Myaccountlink;

public void userregistration(String firstname,String Lastname,String email,String password)
{
	
	clickbutton(GenderRdoBtn);
	SetTextElementText(fnTextBox, firstname);
	SetTextElementText(LnTxtBox, Lastname);
	SetTextElementText(emailTxtBox, email);
	SetTextElementText(passwordTxtBox, password);
	SetTextElementText(confirmpasswordTextbox, password);
	
	clickbutton(registerBtn);
}
public void userlogout()
{
	clickbutton(logoutlink);

}
public void openMyaccountpage()
{
	clickbutton(Myaccountlink);
}

}

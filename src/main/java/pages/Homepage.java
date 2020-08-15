package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Homepage extends PageBase {

	public Homepage(WebDriver driver) {
		super(driver);
		
		js=(JavascriptExecutor) driver;
		action=new Actions(driver)  ;
		
	}
	@FindBy(linkText="Register")
	WebElement registerlink;
	
	@FindBy(linkText="Log in")
	WebElement LoginLink;
	
	@FindBy(linkText="Contact us")
	WebElement contactus;
	
    @FindBy(id="customerCurrency")
    WebElement currencydropdown;
    
    @FindBy(linkText="Computers")
    WebElement computerMenu;
    
    @FindBy(linkText="Notebooks")
    WebElement NotebooksMenu;
	
	public void openregistrationpage()
	{
		
		clickbutton(registerlink);
	}
	public void openloginpage()
	{
		clickbutton(LoginLink);
	}
	
	public void opencontactuspage()
	{
		scrollToBottom();
		clickbutton(contactus);
	}
	public void changecurrency()
	{
		select=new Select(currencydropdown);
		select.selectByVisibleText("Euro");
	}
	
	public void selectnotebooksmenu()
	
	{
	action.moveToElement(computerMenu)
	.moveToElement(NotebooksMenu).
	click()
	.build()
	.perform();	
	}
	
	}
	



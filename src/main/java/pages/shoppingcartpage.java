package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shoppingcartpage extends PageBase {

	public shoppingcartpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id="removefromcart11225")
	WebElement removecheck;
	
	@FindBy(name="updatecart")
	WebElement updatecartbtn;
	
	@FindBy(id="itemquantity11222")
	WebElement quantitytxt;
	
	@FindBy(css="span.product-subtotal")
	public WebElement total;
	
	@FindBy(css="div.no-data")
	public WebElement Notificationmessage;
	
	@FindBy(id="termsofservice")
	WebElement agreecheckbox;
	
	@FindBy(id="checkout")
	WebElement checkoutbtn;
	@FindBy(css="input.button-1.checkout-as-guest-button")
	public WebElement guestbtn;
	
	
	public void removeproductfromcart()
	{
		clickbutton(removecheck);
		clickbutton(updatecartbtn);
	}
public void updateproductquantityincart(String quantity)
{
	//clear quantity textbox
	cleartxt(quantitytxt);
	SetTextElementText(quantitytxt, quantity);
	clickbutton(updatecartbtn);
}
public void opencheckoutpage()
{
	clickbutton(agreecheckbox);
	clickbutton(checkoutbtn);
	}

public void checkoutpageasaguest() throws InterruptedException
{
	clickbutton(agreecheckbox);
clickbutton(checkoutbtn);
Thread.sleep(1000);
	clickbutton(guestbtn);
}
}

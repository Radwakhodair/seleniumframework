package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Productdetailspage extends PageBase {

	public Productdetailspage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(css="strong.current-item")
	public WebElement productnamebreadcrumb;
	
	@FindBy(css="input.button-2.email-a-friend-button")
	public WebElement emailfriendbtn;
	
	@FindBy(css="span.price-value-4")
	public WebElement productpricelabel;
	
	@FindBy(linkText="Add your review")
	WebElement addreviewlink;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addtowishlistbtn;
	
	@FindBy(css="input.button-2.add-to-compare-list-button")
	WebElement addtocomparelistbtn;
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addtocartbtn;
	
	public void opensendemail()
	{
		clickbutton(emailfriendbtn);
	}
	public void addreviewpage()
	{
		clickbutton(addreviewlink);
	}
public void addproducttowishlist()
{
	clickbutton(addtowishlistbtn);
}
public void addproducttocomparelist()
{
	clickbutton(addtocomparelistbtn);
}
public void addproducttocart()
{
	clickbutton(addtocartbtn);
}
}

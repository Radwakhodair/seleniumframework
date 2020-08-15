package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Wishlistpage extends PageBase{

	public Wishlistpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(css="td.product")
	public WebElement productcall;
	
	@FindBy(css="h1")
	public WebElement wishlistheader;
	
	@FindBy(name="updatecart")
	public WebElement updatewishlistBtn;
	
	@FindBy(name="removefromcart")
    public WebElement removefromcartcheck;
	
	@FindBy(css="div.no-data")
	public WebElement Emtycartlb;
	public void removeproductfromcart()
	{
		clickbutton(removefromcartcheck);
		clickbutton(updatewishlistBtn);
		
	}
}

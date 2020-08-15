package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchpage extends PageBase {

	public searchpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id="small-searchterms")
	WebElement searchtxtbox;
	
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchbtn;
	
	@FindBy(id="ui-id-1")
    List<WebElement> productlist;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement producttitle;
	
	public void productsearch(String productName)
	{
		SetTextElementText(searchtxtbox, productName);
		clickbutton(searchbtn);
	}
	public void openproductdetailspage()
	{
		clickbutton(producttitle);
	}
	public void productsearchusingautosuggest(String searchtxt) throws InterruptedException
	{
	SetTextElementText(searchtxtbox, searchtxt);	
	Thread.sleep(3000);
	productlist.get(0).click();
	}
}

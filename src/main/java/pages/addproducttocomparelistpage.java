package pages;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class addproducttocomparelistpage extends PageBase {

	public addproducttocomparelistpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(css="h1")
	public WebElement comparelistheader;
	
	@FindBy(css="tr.product-name")
	public WebElement productname;
	
	@FindBy(css="a.clear-list")
	public WebElement clearlistbtn;
	
	@FindBy(css="input.button-2.remove-button")
	public WebElement removebtn;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement firstname;
	
	@FindBy(linkText="Asus N551JK-XO076H Laptop")
	public WebElement secondname;
	
	@FindBy(css="div.no-data")
	WebElement nodatatbl;
	
	@FindBy(css="table.compare-products-table")
	WebElement comparetable;
	
	@FindBy(tagName="tr")
	List <WebElement> allrows;
	
	@FindBy(tagName="td")
	List <WebElement> allcol;
	
	
	public void clearcomparelist()
	{
		clickbutton(clearlistbtn);
	}
	
	public void compareproducts()
	{
		//get all rows
		System.out.print(allrows.size());
	}
	

}


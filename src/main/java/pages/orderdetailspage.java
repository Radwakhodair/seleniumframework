package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class orderdetailspage extends PageBase {

	public orderdetailspage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="a.button-2.pdf-invoice-button")
	WebElement pdfinvoicelink;
	
	@FindBy(css="a.button-2.print-order-button")
	WebElement printinvoicelink;
	public void printorderdetails()
	{
		clickbutton(printinvoicelink);
	}
	
	public void downloadinvoicelink() throws InterruptedException
	{
		clickbutton(pdfinvoicelink);
		Thread.sleep(1000);
	}

}

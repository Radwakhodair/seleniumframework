package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class Checkoutpage extends PageBase{

	public Checkoutpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(css="input.button-1.checkout-as-guest-button")
	public WebElement guestbtn;
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement fstTxt;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lsTxt;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTxt;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countrylist;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement citytxt;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement addresstxt;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postalcodetxt;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phnumtxt;
	
	@FindBy(css="input.button-1.new-address-next-step-button")
	WebElement continuebtn;
	
	@FindBy(id="shippingoption_1")
	WebElement shipmentrdbtn;
	
	@FindBy(css="input.button-1.shipping-method-next-step-button")
	WebElement shipcontinuerdbtn;
	
	@FindBy(id="paymentmethod_0")
	WebElement contpaymbtn;
	
	@FindBy(css="input.button-1.payment-method-next-step-button")
	WebElement contpaymentbtn;
	
	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement continfbtn;
	
	@FindBy(xpath="//*[@id=\"confirm-order-buttons-container\"]/input")
	WebElement confirmbtn;
	
	@FindBy(css="a.product-name")
	WebElement productname;
	
	@FindBy(css="h1")
	public WebElement thanlb;
	
	@FindBy(css="div.title")
	public WebElement sucessmess;
	
	@FindBy(linkText="Click here for order details.")
	WebElement orderdetailslink;
	
	public void registeredusercheckoutproduct(String countryName,String address,String city,
			String postcode,String phone,String productname) throws InterruptedException
	{
		select=new Select(countrylist);
		select.selectByVisibleText(countryName);
		SetTextElementText(citytxt, city);
		SetTextElementText(addresstxt, address);
		SetTextElementText(postalcodetxt, postcode);
		SetTextElementText(phnumtxt, phone);
		clickbutton(continuebtn);
		clickbutton(shipmentrdbtn);
		clickbutton(shipcontinuerdbtn);
		Thread.sleep(1000);
		clickbutton(contpaymbtn);
		clickbutton(contpaymentbtn);
		Thread.sleep(1000);
		clickbutton(continfbtn);
	}
	//Assert.assertTrue(productname.contains("Apple MacBook Pro 13-inch"));
		public void confirmorder() throws InterruptedException
		{
			Thread.sleep(1000);
			clickbutton(confirmbtn);
		}
		
		//Assert.assertTrue(thanlb.isDisplayed());
		//Assert.assertTrue(sucessmess.getText().contains("Your order has been successfully processed!"));
		public void vieworderdetails()
		{
			clickbutton(orderdetailslink);
		}
		
		public void checkoutproduct(String firstname,String lastname,String countryName,
				String email,String city,String address,String postalcode,String phone,String productname) throws InterruptedException
		{
			SetTextElementText(fstTxt, firstname);
			SetTextElementText(lsTxt, lastname);
			SetTextElementText(emailTxt, email);
			select=new Select(countrylist);
			select.selectByVisibleText(countryName);
			SetTextElementText(citytxt, city);
			SetTextElementText(addresstxt, address);
			SetTextElementText(postalcodetxt, postalcode);
			SetTextElementText(phnumtxt, phone);
			clickbutton(continuebtn);
			clickbutton(shipmentrdbtn);
			clickbutton(shipcontinuerdbtn);
			Thread.sleep(1000);
			clickbutton(contpaymbtn);
			clickbutton(contpaymentbtn);
			Thread.sleep(1000);
			clickbutton(continfbtn);
			
		}
}

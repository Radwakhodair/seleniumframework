package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Checkoutpage;
import pages.Homepage;
import pages.Loginpage;
import pages.Productdetailspage;
import pages.Userregistrationpage;
import pages.orderdetailspage;
import pages.searchpage;
import pages.shoppingcartpage;

public class Registeredusercheckoutproduct extends TestBase {
	/*
	 * 1-register user
	 * 2-search for product
	 * 3-add to cart
	 * 4-checkout
	 * 5-logout
	 */
	Homepage homeobject;
	Userregistrationpage registerobject;
	public Loginpage loginobject;
	public Loginpage logoutobject;
	String productName="Apple MacBook Pro 13-inch";
	searchpage searchobject;
	Productdetailspage detailsobject;
	shoppingcartpage shoppingcartobject;
	Checkoutpage checkoutobject;
	orderdetailspage orderobj;
	
	
	
	@Test(priority=1)
	public void usercanregistersuccessfully()
	{
		
		homeobject=new Homepage(driver);
		homeobject.openregistrationpage();
		registerobject=new Userregistrationpage(driver);
		registerobject.userregistration("radwa2", "khodair4", "radwptest888@gmail.com", "12345678");
	Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
	
	}
	
	@Test(priority=2)
	public void addproducttoshoppingcart() throws InterruptedException
	{
		searchobject=new searchpage(driver);
		detailsobject =new Productdetailspage(driver);
		shoppingcartobject=new shoppingcartpage(driver);
		
		searchobject.productsearchusingautosuggest("Mac");

		Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName);
		detailsobject.addproducttocart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		Assert.assertTrue(shoppingcartobject.total.getText().equals("$3,600.00"));
	}
	
	@Test(priority=3)
	public void usercheckoutproduct() throws InterruptedException
	{
		checkoutobject =new Checkoutpage(driver);
		shoppingcartobject.opencheckoutpage();
		checkoutobject.registeredusercheckoutproduct("Egypt", "testaddress", "Alex"
				, "1234", "0123456789", productName);
		Assert.assertTrue(productName.contains("Apple MacBook Pro 13-inch"));
		checkoutobject.confirmorder();
		Assert.assertTrue(checkoutobject.thanlb.getText().equals("Thank you"));
		Assert.assertTrue(checkoutobject.sucessmess.getText().equals("Your order has been successfully processed!"));
		
		checkoutobject.vieworderdetails();
		Thread.sleep(1000);
		//Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/orderdetails"));
		orderobj=new orderdetailspage(driver);
		orderobj.downloadinvoicelink();
		orderobj.printorderdetails();
	}
	@Test(priority=4)
	public void registeredusercanlogout()
	{
		registerobject.userlogout();
	}
}

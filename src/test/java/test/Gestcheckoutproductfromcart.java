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

public class Gestcheckoutproductfromcart extends TestBase {
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
	
	@Test(priority=2)
	public void checkoutproduct() throws InterruptedException
	{
		checkoutobject=new Checkoutpage(driver);
		shoppingcartobject.checkoutpageasaguest();
		checkoutobject.checkoutproduct("test", "test2", "Egypt", "rd123@gmail.com", "alex", "rewtwa", "1234", "012345678",productName );
		Assert.assertTrue(productName.contains("Apple MacBook Pro 13-inch"));
		checkoutobject.confirmorder();
		Thread.sleep(1000);
		Assert.assertTrue(checkoutobject.thanlb.getText().contains("Thank you"));
	
	}
	@Test(priority=3)
	public void usercanvieworderdetails()
	{
		orderobj=new orderdetailspage(driver);
		checkoutobject.vieworderdetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderobj=new orderdetailspage(driver);
		orderobj.printorderdetails();
	}
	
	
}

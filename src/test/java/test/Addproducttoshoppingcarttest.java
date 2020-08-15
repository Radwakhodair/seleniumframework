package test;



import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.Productdetailspage;
import pages.searchpage;
import pages.shoppingcartpage;

public class Addproducttoshoppingcarttest extends TestBase {
	String productName1="Apple MacBook Pro 13-inch";
	Homepage homeobject;
	searchpage searchobject;
	Productdetailspage detailsobject;
	shoppingcartpage shoppingcartobject;
	@Test(priority=1)
	public void addproducttoshoppingcart() throws InterruptedException
	{
		searchobject=new searchpage(driver);
		detailsobject =new Productdetailspage(driver);
		shoppingcartobject=new shoppingcartpage(driver);
		searchobject.productsearchusingautosuggest("Mac");

		Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName1);
		detailsobject.addproducttocart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		Assert.assertTrue(shoppingcartobject.total.getText().equals("$3,600.00"));
		shoppingcartobject.removeproductfromcart();
		Assert.assertTrue(shoppingcartobject.Notificationmessage.getText().contains("Your Shopping Cart is empty!"));
	}

}

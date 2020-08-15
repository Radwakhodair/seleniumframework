package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Productdetailspage;
import pages.Wishlistpage;
import pages.searchpage;

public class Addproducttowishlisttest extends TestBase {
	String productName="Apple MacBook Pro 13-inch";
	searchpage searchobject;
	Productdetailspage detailsobject;
	Wishlistpage wishobject;
	
	@Test(priority=1)
	public void usercansearchforproducts()
	{
		searchobject=new searchpage(driver);
		detailsobject =new Productdetailspage(driver);
		searchobject.productsearch(productName);
		searchobject.openproductdetailspage();
		//Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName);
	}
	@Test(priority=2)
	public void addproducttowishlist()
	{
		detailsobject=new Productdetailspage(driver);
		detailsobject.addproducttowishlist();
		driver.navigate().to("https://demo.nopcommerce.com"+"/wishlist");
		wishobject=new Wishlistpage(driver);
		Assert.assertTrue(wishobject.wishlistheader.isDisplayed());
		Assert.assertTrue(wishobject.productcall.getText().contains(productName));
		
	}
	@Test(priority=3)
	public void usercanremoveproductfromcard()
	{
		wishobject=new Wishlistpage(driver);
		wishobject.removeproductfromcart();
		Assert.assertTrue(wishobject.Emtycartlb.getText().contains("The wishlist is empty!"));
		
	}


}

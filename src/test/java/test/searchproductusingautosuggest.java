package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Productdetailspage;
import pages.searchpage;

public class searchproductusingautosuggest extends TestBase {
	String productName="Apple MacBook Pro 13-inch";
	searchpage searchobject;
	Productdetailspage detailsobject;
	@Test
	public void usercansearchwithautosuggest() throws InterruptedException
	{
		searchobject=new searchpage(driver);
		searchobject.productsearchusingautosuggest("MacB");
		detailsobject =new Productdetailspage(driver);
		Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName);
	}

}

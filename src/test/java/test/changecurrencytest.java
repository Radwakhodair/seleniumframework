package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.Productdetailspage;
import pages.searchpage;

public class changecurrencytest extends TestBase {
	Homepage homeobject;
	Productdetailspage detailsobject;
	String productName="Apple MacBook Pro 13-inch";
	searchpage searchobject;
	
	@Test
	public void usercanchangecurrency()
	{
		homeobject=new Homepage(driver);
		homeobject.changecurrency();
		
	}
	
	@Test
	public void usercansearchwithautosuggest() throws InterruptedException
	{
		searchobject=new searchpage(driver);
		searchobject.productsearchusingautosuggest("MacB");
		detailsobject =new Productdetailspage(driver);
		Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName);
		Assert.assertTrue(detailsobject.productpricelabel.getText().contains("Ђ"));
	}

}

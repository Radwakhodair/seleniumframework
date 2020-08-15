package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Productdetailspage;
import pages.searchpage;

public class Searchproducttest extends TestBase {
String productName="Apple MacBook Pro 13-inch";
searchpage searchobject;
Productdetailspage detailsobject;

@Test
public void usercansearchforproducts()
{
	searchobject=new searchpage(driver);
	detailsobject =new Productdetailspage(driver);
	searchobject.productsearch(productName);
	searchobject.openproductdetailspage();
	//Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productName));
	Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName);
}

}

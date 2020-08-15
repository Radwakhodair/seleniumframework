package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.Productdetailspage;
import pages.addproducttocomparelistpage;
import pages.searchpage;

public class addproducttocomparetest extends TestBase {
	String productName1="Apple MacBook Pro 13-inch";
	String productName2="Asus N551JK-XO076H Laptop";
	Homepage homeobject;
	searchpage searchobject;
	Productdetailspage detailsobject;
	addproducttocomparelistpage compareobject;
	
	@Test(priority=1)
	public void usercansearchforfirstproduct() throws InterruptedException
	{
		searchobject=new searchpage(driver);
		detailsobject =new Productdetailspage(driver);
		compareobject=new addproducttocomparelistpage(driver);
		
		searchobject.productsearchusingautosuggest("Mac");
		
		Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName1);
		detailsobject.addproducttocomparelist();
		
		searchobject.productsearchusingautosuggest("ASUS");
	
		Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName2);
		detailsobject.addproducttocomparelist();
		
		Thread.sleep(1000);
		
		driver.navigate().to("https://demo.nopcommerce.com"+"/compareproducts");
		Assert.assertTrue(compareobject.secondname.getText().equals("Asus N551JK-XO076H Laptop"));
		Assert.assertTrue(compareobject.firstname.getText().equals("Apple MacBook Pro 13-inch"));
		
              compareobject.compareproducts();
		
	}
	@Test(priority=2)
	public void usercanclearcomparelist()
	{
		compareobject.clearcomparelist();
	}
	}
	


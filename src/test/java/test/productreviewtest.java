package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Emailpage;
import pages.Homepage;
import pages.Loginpage;
import pages.Productdetailspage;
import pages.Userregistrationpage;
import pages.addproductreview;
import pages.searchpage;

public class productreviewtest extends TestBase {
	    //1-user registration
		//2-search
		//3-add product review
	//4-logout
	
	Homepage homeobject;
	Userregistrationpage registerobject;
	public Loginpage loginobject;
	public Loginpage logoutobject;
	String productName="Apple MacBook Pro 13-inch";
	searchpage searchobject;
	Productdetailspage detailsobject;
	Emailpage emailobject;
	addproductreview reviewobject;
	
	
	
	@Test(priority=1,alwaysRun=true)
	public void usercanregistersuccessfully()
	{
		
		homeobject=new Homepage(driver);
		homeobject.openregistrationpage();
		registerobject=new Userregistrationpage(driver);
		registerobject.userregistration("radwa", "khodair", "radwptest0102@gmail.com", "12345678");
	Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
	
	}
	
	//2-search product
	
	@Test(priority=2)
	public void usercansearchwithautosuggest() throws InterruptedException
	{
		searchobject=new searchpage(driver);
		searchobject.productsearchusingautosuggest("MacB");
		detailsobject =new Productdetailspage(driver);
		Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName);
	}
	
	//3-add product review
	@Test(priority=3)
	public void useraddproductreview()
	{
		detailsobject.addreviewpage();
		reviewobject =new addproductreview(driver);
		reviewobject.writereview("reviewtitle"," reviewtxt");
		Assert.assertTrue(reviewobject.ReviewNotification.getText().contains("Product review is successfully added"));
	}
	@Test(priority=4)
	public void registeredusercanlogout()
	{
		registerobject.userlogout();
	}
	

}

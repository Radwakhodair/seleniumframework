package test;

import org.apache.http.MessageConstraintException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Emailpage;
import pages.Homepage;
import pages.Loginpage;
import pages.Productdetailspage;
import pages.Userregistrationpage;
import pages.searchpage;

public class Emailfriendtest extends TestBase {
	//1-user registration
	//2-search
	//3-email to friend
	Homepage homeobject;
	Userregistrationpage registerobject;
	public Loginpage loginobject;
	public Loginpage logoutobject;
	String productName="Apple MacBook Pro 13-inch";
	searchpage searchobject;
	Productdetailspage detailsobject;
	Emailpage emailobject;
	
	
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
	
	//3-email to friend
	@Test(priority=3)
	public void registeredusercansendproducttofriend()
	{
		detailsobject.opensendemail();
		emailobject =new Emailpage(driver);
		emailobject.sendemailtofriend("hg@gmail.com", "jkjkhskhskf");
		Assert.assertTrue(emailobject.messageNotification.getText().contains("Your message has been sent."));
	}
	
	
	//4-user logout
	
	//---------------------------------------//
	@Test(priority=4)
	public void registeredusercanlogout()
	{
		registerobject.userlogout();
	}
	
	
	
	


}

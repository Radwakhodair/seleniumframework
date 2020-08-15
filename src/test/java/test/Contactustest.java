package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Contactuspage;
import pages.Homepage;

public class Contactustest extends TestBase {
	Homepage home;
	Contactuspage contactusobject;
	
	String email="rd@gmail.com";
	String fullname="testuser";
	String enquiry="hello admin,hello world";
	
	@Test
	public void Usercancontactus()
	{
		home=new Homepage(driver);
		home.opencontactuspage();
		contactusobject=new Contactuspage(driver);
		contactusobject.contactus(fullname, email, enquiry);
		Assert.assertTrue(contactusobject.sucessmess.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}

}

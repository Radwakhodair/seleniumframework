package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.Loginpage;
import pages.Myaccountpage;
import pages.Userregistrationpage;

public class MyaccountTest extends TestBase {
	Homepage homeobject;
	Userregistrationpage registerobject;
	Myaccountpage myaccountobject;
	public Loginpage loginobject;
	public Loginpage logoutobject;

	String oldpassword="12345678";
	String newpassword="123456";
	String firstname="radwa";
	String lastname="khodair";
	String email= "radwpitest0102@gmail.com";
	
	
	
	
	@Test(priority=1)
	public void usercanregistersuccessfully()
	{
		
		homeobject=new Homepage(driver);
		homeobject.openregistrationpage();
		registerobject=new Userregistrationpage(driver);
		registerobject.userregistration(firstname, lastname, email, oldpassword);
	Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
	
	}
	@Test(priority=2)
	public void registeredusercanchangepassword()
	{
		myaccountobject=new Myaccountpage(driver);
		registerobject.openMyaccountpage();
		myaccountobject.openchangepasswordpage();
		myaccountobject.changepassword(oldpassword, newpassword);
		Assert.assertTrue(myaccountobject.resultlab.getText().contains("Password was changed"));
		
	}
	@Test(priority=3)
	public void registeredusercanlogout()
	{
		registerobject.userlogout();
	}
	//-------------------------------------//
	@Test(priority=4)
	public void Registeredusercanlogin()
	{
	 homeobject.openloginpage();
	 loginobject=new Loginpage(driver);
	 loginobject.userlogin(email, newpassword);
	 
	 Assert.assertTrue(registerobject.logoutlink.isDisplayed());
	}
	

}

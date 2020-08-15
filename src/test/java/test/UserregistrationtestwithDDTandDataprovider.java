package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bytecode.StackSize;
import pages.Homepage;
import pages.Loginpage;
import pages.Userregistrationpage;

public class UserregistrationtestwithDDTandDataprovider extends TestBase {
	Homepage homeobject;
	Userregistrationpage registerobject;
	public Loginpage loginobject;
	public Loginpage logoutobject;
	
	@DataProvider(name="testData")
	public static Object[][] userdata()
	{
		return new Object[][] {
			{"radwa","kh","radwakh@gmail.com","123456"},
			{"ahmed","ali","ahmedali@gmail.com","1234567"}};
			
			
		}
	
	
	@Test(priority=1,alwaysRun=true,dataProvider="testData")
	public void usercanregistersuccessfully(String fname,String lname,String email,String password)
	{
		
		homeobject=new Homepage(driver);
		homeobject.openregistrationpage();
		registerobject=new Userregistrationpage(driver);
		registerobject.userregistration(fname,lname,email,password);
	Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
	registerobject.userlogout();
	homeobject.openloginpage();
	 loginobject=new Loginpage(driver);
	 loginobject.userlogin(email, password);
	}
	//---------------------------------------//
	/*@Test(dependsOnMethods= {"usercanregistersuccessfully"})
	public void registeredusercanlogout()
	{
		registerobject.userlogout();
	}*/
	//-------------------------------------//
	/*@Test(dependsOnMethods= {"registeredusercanlogout"})
	public void Registeredusercanlogin()
	{
	 homeobject.openloginpage();
	 loginobject=new Loginpage(driver);
	 loginobject.userlogin("radwptest0102@gmail.com", "12345678");
	 
	 Assert.assertTrue(registerobject.logoutlink.isDisplayed());
	}*/
	

}

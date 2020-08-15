package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.Excelreader;
import pages.Homepage;
import pages.Loginpage;
import pages.Userregistrationpage;

public class UserregistrationtestwithDDTandExcel extends TestBase {
	Homepage homeobject;
	Userregistrationpage registerobject;
	public Loginpage loginobject;
	public Loginpage logoutobject;
	@DataProvider(name="ExcelData")
	public Object [][] useerregisterData() throws IOException
	{
		//get data from excel reader
		Excelreader er=new Excelreader();
		
			return er.getexceldata();
		
	}
	
	@Test(priority=1,alwaysRun=true,dataProvider="ExcelData")
	public void usercanregistersuccessfully(String firstname,String lastname,String email,String password)
	{
		
		homeobject=new Homepage(driver);
		homeobject.openregistrationpage();
		registerobject=new Userregistrationpage(driver);
		registerobject.userregistration(firstname,lastname,email,password);
	//Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
	registerobject.userlogout();
	homeobject.openloginpage();
	 loginobject=new Loginpage(driver);
	 loginobject.userlogin(email, password);
	 
	 Assert.assertTrue(registerobject.logoutlink.getText().contains("log out"));
	 registerobject.userlogout();
	}
	//---------------------------------------//
	
	//-------------------------------------//
	

}

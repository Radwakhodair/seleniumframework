package test;


import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.Homepage;
import pages.Loginpage;
import pages.Userregistrationpage;

public class UserregistrationtestwithDDTAndCSV extends TestBase {
	Homepage homeobject;
	Userregistrationpage registerobject;
	public Loginpage loginobject;
	
	
	CSVReader reader;
	
	@Test(priority=1,alwaysRun=true)
	public void usercanregistersuccessfully() throws IOException, CsvValidationException 
	{
		//get path of CSV file
		String CSV_file=System.getProperty("user.dir")+"/src/test/java/data/USERDATA.CSV.csv";
		reader =new CSVReader(new FileReader(CSV_file));
		
		String[] csvcell;
		while ((csvcell=reader.readNext())!=null)
		{
			
			String firstname=csvcell[0];
			String lastname=csvcell[1];
			String email=csvcell[2];
			String password=csvcell[3];
			
			homeobject=new Homepage(driver);
			homeobject.openregistrationpage();
			registerobject=new Userregistrationpage(driver);
			registerobject.userregistration(firstname, lastname, email, password);
		//Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
		registerobject.userlogout();
		homeobject.openloginpage();
		 loginobject=new Loginpage(driver);
		 loginobject.userlogin(email, password);
		 
		 //Assert.assertTrue(registerobject.logoutlink.getText().contains("logout"));
		 registerobject.userlogout();
			
			
		}
		
		
	
	}
	
	

}

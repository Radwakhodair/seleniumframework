package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;

public class producthovermenutest extends TestBase {
	Homepage homeobject;
	@Test
	public void usercanselectsubcategoryfrommainmenu()
	{
		homeobject=new Homepage(driver);
		homeobject.selectnotebooksmenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}

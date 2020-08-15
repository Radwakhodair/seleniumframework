package utility;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper {
	//method to take screenschoot when testcase fail
	public static void capturescreenschoot(WebDriver driver,String screenshootname)
	
	{
		Path des=Paths.get("./screenshots", screenshootname+".png");
	    try {
			Files.createDirectories(des.getParent());
			FileOutputStream out=new FileOutputStream(des.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			
			System.out.println("exception while taking screenshoot"+e.getMessage());
		}
		
	}

}

package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class loadproperities {
	//load the properities file from the folder
	public static Properties userData=loadproperities(System.getProperty("user.dir")+"\\src\\main\\java\\properities\\userdata.properities");
	private static Properties loadproperities(String path)
	{
		Properties pro =new Properties();
		//stream for reading file
		FileInputStream stream;
		try {
			stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("error occured : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("error occured : "+e.getMessage());
		}
		return pro;
	}

}

package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;





public class jsondatareader {
public String firstname,lastname,email,password;
public void jasonReader() throws  IOException, ParseException
{
	String filepath=System.getProperty("user.dir")+"/src/test/java/data/UserData.jason";
	File srcfile=new File(filepath);
	JSONParser parser=new JSONParser();
	JSONArray jarray=(JSONArray)parser.parse(new FileReader(srcfile));
	for(Object jsonobj:jarray)
	{
		JSONObject person=(JSONObject) jsonobj;
		firstname= (String)person.get("firstname");
		System.out.println(firstname);
		lastname=(String)person.get("lastname");
		email=(String)person.get("email");
		System.out.println(email);
		password=(String)person.get(password);
		
	}
}
}

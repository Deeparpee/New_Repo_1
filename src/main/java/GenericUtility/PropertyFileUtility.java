package GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/main/resources/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
	    String URL = pobj.getProperty("url");
	}
}

package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	public static void main(String[] args) throws IOException
	{
		FileReader fr=new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\data\\data.properties");
		Properties p =new Properties();
		p.load(fr);
		System.out.println(p.getProperty("URL"));
		
	
	}

}

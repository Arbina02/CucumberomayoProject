package com.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	private Properties prop;

	public Properties init_prop()
	{
		prop = new Properties();
		try {
			FileInputStream ip= new FileInputStream("./src/test/resource/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}

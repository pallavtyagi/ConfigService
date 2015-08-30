package com.pallav.concheck.configservice.init;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class AppLoader {
	
	private Properties properties;
	private static AppLoader instance=null;

	private AppLoader() {}
	
	public static AppLoader getInstance()
	{
		if(instance==null)
		{
			instance=new AppLoader();
		}
		return instance;
	}
	
	// loading the properties from the final file...
	public boolean loadProperties() {
		boolean flag = false;
		InputStream fileStream = null;
		properties = new Properties();
		
		String propFileName = System.getProperty("propValue")+".properties";
		
		try {
			if (propFileName != null) {
				fileStream = getClass().getClassLoader().getResourceAsStream(
						propFileName);
				if (fileStream != null) {
					System.out.println("Loading properties...");
					properties.load(fileStream);
				} else {
					throw new FileNotFoundException(
							"Property File not found - " + propFileName);
				}

				for (Entry<Object, Object> keySet : properties.entrySet()) {
					System.out.println(keySet.getKey() + "-->"
							+ keySet.getValue());
				}
				flag=true;
			} else
				System.out.println("Env variable is not configured!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;

	}
	
	public Map<Object, Object> getConfigs()
	{
		return properties;
		
	}
}

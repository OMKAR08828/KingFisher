package config;

import java.util.Properties;

public class ConfigReader {
	
	  private static Properties properties = new Properties();
	  
	public static String get(String key) {
        return properties.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

	

}

package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties properties = new Properties();
	
	public ConfigReader() throws IOException {
		File file = new File("/Users/saurabhverma/Downloads/TalkyWebAutomation/src/main/resources/config.Properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		properties.load(fileInputStream);
	}
	
	public String getBaseUrl(){
		return properties.getProperty("baseUrl");
	}
	
}

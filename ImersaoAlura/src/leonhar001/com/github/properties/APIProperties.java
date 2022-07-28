package leonhar001.com.github.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class APIProperties {
	
	private Properties apiProperties = new Properties();;
	
	public APIProperties() throws FileNotFoundException, IOException {
		apiProperties.load(new FileInputStream("../ImersaoAlura/src/api.properties"));
	}
	
	public String getProperties(Url url) throws FileNotFoundException, IOException {
		
		switch (url) {
			case imdb: 
				return apiProperties.getProperty("urlIMDB");
			default:
				return "Not found.";
		}
	}
	
}

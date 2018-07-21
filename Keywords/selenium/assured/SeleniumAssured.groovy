package selenium.assured

import selenium.configuration.Configuration

public class SeleniumAssured {

	public static SeleniumAssured given(){
		return new SeleniumAssured();
	}

	public static Configuration withConfiguration(){
		return new Configuration()
	}
}

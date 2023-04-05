package Maven_Package;

import org.testng.annotations.Test;

public class ParameterTest {

	
	@Test
	public void test()
	{
		String URL = System.getProperty("url");
		String ENV = System.getProperty("Env");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		System.out.println(URL);
		System.out.println(ENV);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		
		
		
		
		
	}
	
	
}

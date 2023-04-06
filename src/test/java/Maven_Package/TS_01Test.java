package Maven_Package;

import org.testng.annotations.Test;

public class TS_01Test {
	
	@Test(groups = "smoke")
	public void test1()
	{
		System.out.println("----TS_01 Executed----");
	}
	
	@Test(groups = "regression")
	public void test2()
	{
		System.out.println("----TS_02 Executed----");
		
		
		
		
	}

}

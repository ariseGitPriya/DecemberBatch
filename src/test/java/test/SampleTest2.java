package test;
import org.testng.annotations.Test;

public class SampleTest2 {
	
	@Test
	public void Test()
	{
		System.out.println("Test method");
	}
	
	@Test
	public void Test1()
	{
		System.out.println("Test1 method");
	}
	@Test()
	public void Test0()
	{
		System.out.println("Test0 method");
	}
	
	@Test(timeOut = 0)
	public void test()
	{
		System.out.println("test method");
	}
	
	
	
	

}

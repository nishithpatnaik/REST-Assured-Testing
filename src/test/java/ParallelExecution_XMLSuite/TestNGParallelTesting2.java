package ParallelExecution_XMLSuite;

import org.testng.annotations.Test;

public class TestNGParallelTesting2 {
	
	@Test
	//threadPoolSize and invocationCount executes Test1 in 3 threads in parallel
	public void Test4()
	{
		System.out.println("I am Test1 in Class 2 - " +Thread.currentThread().getId());
	}
	
	@Test
	public void Test5()
	{
		System.out.println("I am Test2 in Class 2 - " +Thread.currentThread().getId());
	}
	
	@Test
	public void Test6()
	{
		System.out.println("I am Test3 in Class 2 - " +Thread.currentThread().getId());
	}
	
	

}

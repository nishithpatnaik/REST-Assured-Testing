package ParallelExecution_XMLSuite;

import org.testng.annotations.Test;

public class TestNGParallelTesting1 {
	
	@Test(threadPoolSize = 2, invocationCount = 2, timeOut = 1000)
	//threadPoolSize and invocationCount executes Test1 in 3 threads in parallel
	public void Test1()
	{
		System.out.println("I am Test1 in Class 1 - " +Thread.currentThread().getId());
	}
	
	@Test
	public void Test2()
	{
		System.out.println("I am Test2 in Class 1 - " +Thread.currentThread().getId());
	}
	
	@Test
	public void Test3()
	{
		System.out.println("I am Test3 in Class 1 - " +Thread.currentThread().getId());
	}
	
	

}

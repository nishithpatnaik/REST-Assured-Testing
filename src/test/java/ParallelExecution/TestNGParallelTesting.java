package ParallelExecution;

import org.testng.annotations.Test;

public class TestNGParallelTesting {
	
	@Test(threadPoolSize = 2, invocationCount = 3, timeOut = 1000)
	//threadPoolSize and invocationCount executes Test1 in 3 threads in parallel
	public void Test1()
	{
		System.out.println("I am Test1 - " +Thread.currentThread().getId());
	}
	
	@Test
	public void Test2()
	{
		System.out.println("I am Test2 - " +Thread.currentThread().getId());
	}
	
	@Test
	public void Test3()
	{
		System.out.println("I am Test3 - " +Thread.currentThread().getId());
	}
	
	

}

package selenium;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListner extends BaseClass implements ITestListener {

	

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Testcase Execution started");
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		try {
		    System.out.println("TestCase Failed and Screenshot captured for " + result.getName());
			takeScreenshot(result.getName());
		

			
		//takeScreenshot("error");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void onFinish(ITestContext context) {
		
        
		System.out.println("Testcase Execution finished");
	}

}

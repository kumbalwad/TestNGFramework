package config;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listner extends UtilityPage implements ITestListener {

	public void onTestFailure(ITestResult result) {

		String testCaseName = result.getMethod().getMethodName();
		System.out.println(testCaseName + " got failed ");

		takeScreenShot(testCaseName);
	}

}

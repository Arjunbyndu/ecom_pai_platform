package rsPractice.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retest implements IRetryAnalyzer {

	int count = 0;
	int maxTry =1;
	public boolean retry(ITestResult result) {
		if(count<maxTry)
		{
			count++;
			return true;
		}
		return false;
	}

}

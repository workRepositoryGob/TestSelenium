package ecommerce.listeners;


import ecommerce.utils.Log;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomerListener implements ITestListener, ISuiteListener {

  @Override
  public void onTestStart(ITestResult result) {
      Log.info("Test started: " + result.getName());
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    Log.info("Test passed: " + result.getName());
  }

  @Override
  public void onTestFailure(ITestResult result) {
    Log.info("Test failed: " + result.getName());
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    Log.info("Test skipped: " + result.getName());
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
  }

  @Override
  public void onTestFailedWithTimeout(ITestResult result) {
    ITestListener.super.onTestFailedWithTimeout(result);
  }

  @Override
  public void onStart(ISuite suite) {
    Log.info("Suite started: " + suite.getName());
  }

  @Override
  public void onFinish(ISuite suite) {
    Log.info("Suite finished: " + suite.getName());
  }
}

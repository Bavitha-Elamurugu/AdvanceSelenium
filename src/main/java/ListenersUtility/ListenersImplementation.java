package ListenersUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.reporters.Files;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.BaseClass;


public class ListenersImplementation implements ITestListener,ISuiteListener {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
	Reporter.log("report configuration",true);
	Date d=new Date();
	String newDate = d.toString().replace(" ","_").replace(":", "_");
	spark= new ExtentSparkReporter("./AdvanceReports/report_"+newDate+".html");
	spark.config().setDocumentTitle("NinzaCRM TTest results");
	spark.config().setReportName(" CRM Report");
	spark.config().setTheme(Theme.DARK);
	 report=new ExtentReports();
	 report.attachReporter(spark);
	 report.setSystemInfo("os","windows11");
	 report.setSystemInfo("Browser", "Edge");
	//spark=new ExtendSparkReporter("./AdvanceReports/report_"+newDate+".html");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		String testname = result.getMethod().getMethodName();
	   Reporter.log("==="+testname+"FAILURE===",true);
	Date d=new Date();
	String newdate = d.toString().replace(" ","_").replace(":", "_");
	TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
	//TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
	String temp = ts.getScreenshotAs(OutputType.BASE64);
test.addScreenCaptureFromBase64String(temp,testname+newdate);
test.log(Status.FAIL,"===="+ testname+"FAILURE====");
	
	
	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

}

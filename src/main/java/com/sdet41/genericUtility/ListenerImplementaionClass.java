package com.sdet41.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementaionClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
	
		 test = report.createTest(MethodName);
			Reporter.log(MethodName+"--testScript execution Started--");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"---->passed");
		Reporter.log(MethodName+"--testScript execution Successful--");
	}

	/*public void onTestFailure(ITestResult result) {
		
		String FailedScript = result.getMethod().getMethodName();
		
	//	String FScript = FailedScript + new JavaUtility().systemDate();
		
		EventFiringWebDriver eDriver =  new EventFiringWebDriver(BaseClass.sDriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		String path = ".\\Screenshot\\"+FailedScript+".png";
		File dst = new File(path);
		try 
		{
			FileUtils.copyFile(src, dst);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);
		
	}*/

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"----->skipped");
		//it will capture the exception and log it in report
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"--testScript execution Skipped--");
	}

	public void onStart(ITestContext context) {
		//Execution starts here
		//Configure the Report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report.html");
		htmlReport.config().setDocumentTitle("SDET-41 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTiger Execution Report");
		
		 report = new ExtentReports();
		 
		 report.attachReporter(htmlReport);
		 report.setSystemInfo("Base Browser", "Chrome");
		 report.setSystemInfo("OS", "Windows");
		 report.setSystemInfo("Base-URL", "https://localhost:8888");
		 report.setSystemInfo("Report Name", "Vijayalaxmi");
		
	}

	public void onFinish(ITestContext context) {
		
		//Consilidate all the parameters and generate the report
		report.flush();
		
	}

	
}

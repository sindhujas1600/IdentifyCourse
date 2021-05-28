package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportManager {

	public static ExtentReports report;                  //creates the report in html format
	public static ExtentHtmlReporter htmlReporter;            //creates the report
	
	public static ExtentReports getReportInstance()
	{
		if(report==null)
		{
			String reportName=DateUtils.getTimeStamp();
			htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reportName+".html");
			report=new ExtentReports();
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("Browser", "Chrome");
			
			htmlReporter.config().setDocumentTitle("UAT UI Automations Results");
			htmlReporter.config().setReportName("All Headlines UI Test Reports");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd,yyy HH:mm:ss");
		}
		return report;
	}

}

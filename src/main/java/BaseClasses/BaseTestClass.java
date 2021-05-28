package BaseClasses;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import IdentifyCourse.CourseraHomePage;
import Utilities.ExtentReportManager;


public class BaseTestClass {

	public static WebDriver driver;
	public ExtentReports report=ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public Properties prop=new Properties();
	
	
	/***************** Invoking the Browser ***********************/
	public void invokeBrowser(String browserKey)
	{
		try 
		{
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//ObjectRepository//projectConfg.properties");
			prop.load(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try
		{
			if(prop.getProperty(browserKey).equalsIgnoreCase("Chrome"))
		    {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//drivers//chromedriver.exe");
				driver=new ChromeDriver();
		    }
			else if(prop.getProperty(browserKey).equalsIgnoreCase("Firefox") || prop.getProperty(browserKey).equalsIgnoreCase("Mozilla"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//drivers//geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else
			{
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//src//test//resources//drivers//IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		
		//
		
		
	}
	
	/***************** Opening the website ***********************/
	public CourseraHomePage openURL(String websiteURLKey)
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    driver.get(prop.getProperty(websiteURLKey));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		CourseraHomePage chome= new CourseraHomePage(driver,logger);
		PageFactory.initElements(driver,chome);
	    return chome;
	}
	
}

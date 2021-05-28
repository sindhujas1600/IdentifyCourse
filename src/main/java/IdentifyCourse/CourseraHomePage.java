package IdentifyCourse;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;


public class CourseraHomePage extends PageBaseClass{

	
	public CourseraHomePage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
	}
	
	public LangSearchPage doLangSearch()
	{
		//Reading Language Learning from inputs.xlsx & performing  Search on Homepage
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		PageFactory.initElements(driver, ElementsClass.class);
		logger.log(Status.INFO,"Entering Language Learning in the SearchBox");
		ElementsClass.searchBox.click();
		readExcelFile(2);
		ElementsClass.searchBox.sendKeys(inputs[0]);
		logger.log(Status.PASS,"Entered text in the SearchBox successfully");
		logger.log(Status.INFO,"Selecting the language learning option ");
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(ElementsClass.course));
		
		ElementsClass.course.click();
		try
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		String currentPageTitle=driver.getTitle();
		if(currentPageTitle.equals("Coursera | Build Skills with Online Courses from Top Institutions"))
		{
			Assert.fail("Search Failed");
		}
		
		LangSearchPage lgsearch=new LangSearchPage(driver,logger);
		PageFactory.initElements(driver,lgsearch);
		return lgsearch;
	}

	
	public WebDevSearchPage doWebSearch()
	{
		//Reading WebDevelopmentCourses from inputs.xlsx & performing  Search on Homepage
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		PageFactory.initElements(driver, ElementsClass.class);
		logger.log(Status.INFO,"Entering WebDevelopment courses in the SearchBox");
		ElementsClass.searchBox.click();
		readExcelFile(1);
		ElementsClass.searchBox.sendKeys(inputs[0]);
		logger.log(Status.PASS,"Entered WebDevelopment courses in the SearchBox successfully");
		logger.log(Status.INFO,"Clicking the the Search icon ");
		ElementsClass.webcourse.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentPageTitle=driver.getTitle();
		if(currentPageTitle.equals("Coursera | Build Skills with Online Courses from Top Institutions"))
		{
			Assert.fail("Search Failed");
		}
		
		WebDevSearchPage wbsearch=new WebDevSearchPage(driver,logger);
		PageFactory.initElements(driver,wbsearch);
		return wbsearch;
		
	}
	
	public void getTitle(String expectedTitle)
	{
		
	}
	
	public ForEnterprise forEnterprise()
	{
		//Going to For Enterprise>ForCampus
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, ElementsClass.class);
		driver.get("https://www.coursera.org/campus/?utm_campaign=website&utm_content=product-dropdown-coursera-for-campus&utm_medium=coursera&utm_source=enterprise");
		
		ForEnterprise fe=new ForEnterprise(driver,logger);
		PageFactory.initElements(driver,fe);
		return fe;
	}
}

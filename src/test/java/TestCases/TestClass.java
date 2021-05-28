package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.Status;
import BaseClasses.BaseTestClass;
import BaseClasses.PageBaseClass;
import IdentifyCourse.CourseraHomePage;
import IdentifyCourse.LangSearchPage;
import IdentifyCourse.WebCourse_1;
import IdentifyCourse.WebCourse_2;
import IdentifyCourse.WebDevSearchPage;
import IdentifyCourse.ForEnterprise;

public class TestClass extends BaseTestClass{

	CourseraHomePage ch;
	LangSearchPage ls;
	WebDevSearchPage wbpage;
	WebCourse_1 wc1;
	WebCourse_2 wc2;
	ForEnterprise fe;
	
/***************** Test Scenario 1 **************/
	
	// Classes used:{ CourseraHomePage, WebDevSearchPage }
	@Test(priority=0,groups={"Regression","Smoke"})
	public void webDevSearch()
	{
		try
		{
			logger=report.createTest("Searching Web Development Courses");
			
			logger.log(Status.INFO,"Opening the Browser");
			invokeBrowser("Browser");
			logger.log(Status.INFO,"Opening the Coursera website");
			ch=openURL("websiteURL");
			ch.getTitle("Coursera | Build Skills with Online Courses from Top Institutions");
			System.out.println("Test Scenario 1:");
			wbpage=ch.doWebSearch();
			logger.log(Status.PASS,"Successfully displaying the results for Web Development ");
			wbpage.lanEnglish();
			wbpage.levelBeg();
			logger.log(Status.PASS,"Successfully filtered the courses for English and Beginner Level ");
			PageBaseClass.writeExcelFile("Pass",1);
		}
		catch(Exception e)
		{
			PageBaseClass.writeExcelFile("Fail",1);
			PageBaseClass.reportFail(e.getMessage());
		}
	}
	
	// Classes used:{ WebDevSearchPage, WebCourse_1, WebCourse_2 }
	@Test(priority=1,groups="Regression")
	public void webDevDetails()
	{
		try
		{
			logger=report.createTest(" Details for Web Development Courses");
			wc1=wbpage.DisplayingDetails_1();
			wc1.details_1();
			logger.log(Status.PASS,"Successfully displayed the details for Course 1 ");
			wc2=wbpage.DisplayingDetails_2();
			wc2.details_2();
			logger.log(Status.PASS,"Successfully displayed the details for Course 2 ");
			PageBaseClass.reportPass("TestCase 1 Executed Successfully");
			PageBaseClass.writeExcelFile("Pass",2);
		}
		catch(Exception e)
		{
			PageBaseClass.writeExcelFile("Fail",2);
			PageBaseClass.reportFail(e.getMessage());
		}
	}
	
	/***************** Test Scenario 2 **************/
	
	// Classes used:{ CourseraHomePage }
	@Test(priority=2,groups={"Regression","Smoke"})
	public void langLearningSearch()
	{
		try
		{
			
			logger=report.createTest("Searching for Language Learning");
			
			logger.log(Status.INFO,"Opening the Browser");
			invokeBrowser("Browser");
			logger.log(Status.INFO,"Opening the Coursera website");
			ch=openURL("websiteURL");
			ch.getTitle("Coursera | Build Skills with Online Courses from Top Institutions");
			System.out.println("Test Scenario 2:");
			ls=ch.doLangSearch();
			logger.log(Status.PASS,"Successfully displaying the results for Language Learning ");
			ls.getTitle("Top Lang Courses - Learn Lang Online | Coursera");
			PageBaseClass.writeExcelFile("Pass",3);
		}
		catch(Exception e)
		{
			PageBaseClass.writeExcelFile("Fail",3);
			PageBaseClass.reportFail(e.getMessage());
		}
		
	}
	
	// Classes used:{ LangSearchPage }
	@Test(priority=3,groups="Regression")
	public void langLearningLangDetails()
	{
		try
		{
			logger=report.createTest("Displaying Language in Language Learning");
			
			ls.displayingLang();
			logger.log(Status.PASS,"Successfully displayed all the Languages ");
			PageBaseClass.writeExcelFile("Pass",4);
		}
		catch(Exception e)
		{
			PageBaseClass.writeExcelFile("Fail",4);
			PageBaseClass.reportFail(e.getMessage());
		}
		
	}
	
	// Classes used:{ LangSearchPage }
	@Test(priority=4,groups="Regression")
	public void langLearningLevelCount()
	{
		try
		{
			logger=report.createTest("Displaying Level Count for Language Learning");
			
			ls.displayLevelCount();
			logger.log(Status.PASS,"Successfully displayed the Level Count ");
			PageBaseClass.reportPass("TestCase 2 Executed Successfully");
			PageBaseClass.writeExcelFile("Pass",5);
		}
		catch(Exception e)
		{
			PageBaseClass.writeExcelFile("Fail",5);
			PageBaseClass.reportFail(e.getMessage());
		}
		
	}
	
	/***************** Test Scenario 3 **************/
	
	// Classes used:{ CourseraHomePage, ForEnterprise }
	@Test(priority=5,groups={"Regression","Smoke"})
	public void forEnterprise()
	{
		try
		{
			logger=report.createTest("For Enterprise Section");
			logger.log(Status.INFO,"Opening the Browser");
			invokeBrowser("Browser");
			logger.log(Status.INFO,"Opening the Coursera website");
			ch=openURL("websiteURL");
			ch.getTitle("Coursera | Build Skills with Online Courses from Top Institutions");
			System.out.println("Test Scenario 3:");
			fe=ch.forEnterprise();
			logger.log(Status.PASS,"Successfully clicked For Enterprise on the Homepage ");
			logger.log(Status.PASS,"Successfully clicked Coursera for Campus from Products");
			logger.log(Status.INFO,"Giving data to the form with wrong email and clicking submit. ");
			fe.fillForm();
			fe.getTitle("Thank you - Coursera for Campus");
			logger.log(Status.PASS,"Successfully displayed and captured the error. ");
			PageBaseClass.reportPass("TestCase 3 Executed Successfully");
			PageBaseClass.writeExcelFile("Pass",6);
		}
		catch(Exception e)
		{
			PageBaseClass.writeExcelFile("Fail",6);
			PageBaseClass.reportFail(e.getMessage());
		}
			
	    	
	}
	
	/***************** End Report **************/
	
	@AfterTest
	public void endReport()
	{
		report.flush();
	}
	
}

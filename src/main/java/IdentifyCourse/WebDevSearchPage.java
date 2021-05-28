package IdentifyCourse;

import java.util.Set;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class WebDevSearchPage extends PageBaseClass{

	static String parent;
	public WebDevSearchPage(WebDriver driver, ExtentTest logger)
	{
		super(driver,logger);
	}
	
	public void lanEnglish()
	{
		//Selecting English from Language Box.
		logger.log(Status.INFO,"Selecting English From Languages");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		PageFactory.initElements(driver, ElementsClass.class);
		
		ElementsClass.Language.click();
		ElementsClass.English.click();
	}
	
	public void levelBeg()
	{
		//Selecting Beginner from Level Box.
		PageFactory.initElements(driver, ElementsClass.class);
		logger.log(Status.INFO,"Selecting Beginner Level from Levels");
		ElementsClass.Level.click();
		ElementsClass.Beginner.click();
		
	}
	
	public WebCourse_1 DisplayingDetails_1()
	{
		//Clicking & Switching to first course
		PageFactory.initElements(driver, ElementsClass.class);
		ElementsClass.Courses.get(0).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
        String parent=driver.getWindowHandle();
		while(I1.hasNext())
		{
			String child_window=I1.next();
            if(!parent.equals(child_window))
		    {
		        driver.switchTo().window(child_window);
		        break;
		    }
		}
		WebCourse_1 wbCourse1=new WebCourse_1(driver,logger);
		PageFactory.initElements(driver,wbCourse1);
		return wbCourse1;
	}
	
	public WebCourse_2 DisplayingDetails_2()
	{
		//Clicking & Switching to second course
		PageFactory.initElements(driver, ElementsClass.class);
		ElementsClass.Courses.get(1).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
        parent=driver.getWindowHandle();
		while(I1.hasNext())
		{
            String child_window=I1.next();
            if(!parent.equals(child_window))
		    {
		        driver.switchTo().window(child_window);
		        break;
		    }
		}
		WebCourse_2 wbCourse2=new WebCourse_2(driver,logger);
		PageFactory.initElements(driver,wbCourse2);
		return wbCourse2;
	}
}

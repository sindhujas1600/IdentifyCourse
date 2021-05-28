package IdentifyCourse;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClasses.PageBaseClass;


public class WebCourse_1 extends PageBaseClass{

	public WebCourse_1(WebDriver driver, ExtentTest logger) 
	{
		super(driver,logger);
	}
	
	public WebDevSearchPage details_1()
	{
		//Extracting details of 1st course
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageFactory.initElements(driver, ElementsClass.class);
		System.out.println("Course 1:");
		System.out.println("Course Name - " + ElementsClass.courseName.getText());
		String ratings =(ElementsClass.courseRatings.getText().substring(0, 3))+" "+(ElementsClass.courseRatings.getText().substring(4,9));
		System.out.println("Course Rating - " + ratings);
		System.out.println("Course Duration - " + ElementsClass.courseDuration.get(1).getText());
		System.out.println();
		String parent=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
            if(!parent.equals(child_window))
		    {
            	driver.close();
		        driver.switchTo().window(child_window);
		        break;
		    }
		}
		
		WebDevSearchPage wbsearch=new WebDevSearchPage(driver,logger);
		PageFactory.initElements(driver,wbsearch);
		return wbsearch;
    	
	}

}

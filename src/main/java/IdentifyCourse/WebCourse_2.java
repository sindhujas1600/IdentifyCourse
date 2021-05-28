package IdentifyCourse;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClasses.PageBaseClass;


public class WebCourse_2 extends PageBaseClass{

	public WebCourse_2(WebDriver driver, ExtentTest logger) 
	{
		super(driver,logger);
	}

	
	public void details_2()
	{
		//Extracting details of 2nd course
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		PageFactory.initElements(driver, ElementsClass.class);
		System.out.println("Course 2:");
		System.out.println("Course Name - " + ElementsClass.courseName.getText());
		String ratings =(ElementsClass.courseRatings.getText().substring(0, 3))+" "+(ElementsClass.courseRatings.getText().substring(4,9));
		System.out.println("Course Rating - " + ratings);
		System.out.println("Course Duration - " + ElementsClass.courseDuration.get(1).getText());
		System.out.println();
		driver.switchTo().window(WebDevSearchPage.parent);
		driver.quit();
	}
	
}

package IdentifyCourse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;
public class ForEnterprise extends PageBaseClass{

	
	public ForEnterprise(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
	}
	
	public void fillForm()
	{
		/**
		 * Look into Courses for Campus under Product Fill the "Ready to transform"
		 * form with any one input invalid (example: email) Capture the error
		 * message & display
		 */
		
		readExcelFile(3);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		PageFactory.initElements(driver, ElementsClass.class);
		ElementsClass.ready.click();
		logger.log(Status.INFO,"Filling the form");
		ElementsClass.Fname.sendKeys(inputs[0]);
		ElementsClass.Lname.sendKeys(inputs[1]);
		
		Select select = new Select(ElementsClass.JobFunction);
		select.selectByIndex(1);
		
		ElementsClass.Jobtitle.sendKeys(inputs[2]);
		ElementsClass.Email.sendKeys(inputs[3]);
		ElementsClass.Phone.sendKeys(inputs[4]);
		
		ElementsClass.Institutename.sendKeys(inputs[5]);
		Select select1 = new Select(ElementsClass.InstituteType);
		select1.selectByVisibleText("Government");

		Select select2 = new Select(ElementsClass.PrimaryDisipline);
		select2.selectByVisibleText("Computer Science");

		Select select3 = new Select(ElementsClass.Country);
		select3.selectByVisibleText("India");

		Select select4 = new Select(ElementsClass.State);
		select4.selectByVisibleText("Tamil Nadu");
		logger.log(Status.PASS,"Form filled ");
		logger.log(Status.INFO,"Clicking Submit Button");
		ElementsClass.Submit.click();
		logger.log(Status.INFO,"Displaying Error Message");
		
		//Capture the error message & display
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(ElementsClass.ErrorMessage));
		String Error = ElementsClass.ErrorMessage.getText();
        System.out.println(Error);
       
        //takeScreenShotOnFailure();
        logger.log(Status.INFO,"Error Message displayed successfully");
        
        JavascriptExecutor js1=(JavascriptExecutor)driver;
        js1.executeScript("arguments[0].scrollIntoView(true)",ElementsClass.Fname);
        
        takeScreenShotOnFailure();
		driver.quit();
		
	}
	
	public void getTitle(String expectedtitle)
	{
		
	}

}

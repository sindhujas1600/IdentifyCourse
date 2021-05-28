package IdentifyCourse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;


public class LangSearchPage extends PageBaseClass{

	
	public LangSearchPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
	}
	
	public void displayingLang() 
	{
		//Displaying Languages for Language Learning
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		PageFactory.initElements(driver, ElementsClass.class);
		logger.log(Status.INFO,"Clicking the Language Box");
		ElementsClass.langBox.click();
		ElementsClass.showAll.click();
		logger.log(Status.INFO,"Displaying all the Languages");
		System.out.println("Languages : ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for(WebElement option:ElementsClass.langOptions)
		{
			System.out.print(option.getText()+" , ");
		}
		System.out.println();
		System.out.println();
		ElementsClass.cross.click();
	}
	
	public void displayLevelCount()
	{
		//Displaying LevelCount for Language Learning
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		PageFactory.initElements(driver, ElementsClass.class);
		
		//.....Beginner Level.....//
		logger.log(Status.INFO,"Clicking the Level Box");
		ElementsClass.levelBox.click();
		ElementsClass.Beg.click();
		logger.log(Status.PASS,"Successfully selected the Beginner Level");
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		String[] lang_lst=null;
		lang_lst=ElementsClass.count.getText().split(" ");
		String Beg_count=lang_lst[1];
		System.out.println("Beginner Level Count : "+Beg_count);
		logger.log(Status.PASS,"Successfully displayed the count for Beginner Level");
		ElementsClass.levelUnselect.click();
		logger.log(Status.INFO,"Unselected the Beginner Level");
		
		//.....Mixed Level.....//
		ElementsClass.levelBox.click();
		ElementsClass.Mix.click();
		logger.log(Status.PASS,"Successfully selected the Mixed Level");
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		String[] lang_lst1=null;
		lang_lst1=ElementsClass.count.getText().split(" ");
		String Mix_count=lang_lst1[1];
		System.out.println("Mixed Level Count : "+Mix_count);
		logger.log(Status.PASS,"Successfully displayed the count for Mixed Level");
		ElementsClass.levelUnselect.click();
		logger.log(Status.INFO,"Unselected the Mixed Level");
		
		//.....Intermediate Level.....//
		ElementsClass.levelBox.click();
		ElementsClass.Int.click();
		logger.log(Status.PASS,"Successfully selected the Intermediate Level");
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		String[] lang_lst2=null;
		lang_lst2=ElementsClass.count.getText().split(" ");
		String Int_count=lang_lst2[1];
		System.out.println("Intermediate Level Count : "+Int_count);
		logger.log(Status.PASS,"Successfully displayed the count for Intermediate Level");
		ElementsClass.levelUnselect.click();
		logger.log(Status.INFO,"Unselected the Intermediate Level");
		
		//.....Advanced Level.....//
		ElementsClass.levelBox.click();
		ElementsClass.Adv.click();
		logger.log(Status.PASS,"Successfully selected the Advanced Level");
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		String[] lang_lst3=null;
		lang_lst3=ElementsClass.count.getText().split(" ");
		String Adv_count=lang_lst3[1];
		System.out.println("Advanced Level Count : "+Adv_count);
		logger.log(Status.PASS,"Successfully displayed the count for Advanced Level");
		ElementsClass.levelUnselect.click();
		logger.log(Status.INFO,"Unselected the Advanced Level");
		driver.quit();
	}
	
	
	public void getTitle(String expectedTitle)
	{
		
	}
	
}

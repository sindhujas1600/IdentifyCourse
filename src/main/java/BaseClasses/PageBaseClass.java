package BaseClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Utilities.DateUtils;


public class PageBaseClass extends BaseTestClass{

	public Properties prop=new Properties();
	public static ExtentTest logger;
	protected String[] inputs=new String[10];
	static int n=0;
	static XSSFWorkbook workbook = new XSSFWorkbook();
    static XSSFSheet sheet2 = workbook.createSheet("Test Scenarios");
    static XSSFSheet sheet3 = workbook.createSheet("Test Cases");

	public PageBaseClass(WebDriver driver, ExtentTest logger) 
	{
		this.driver=driver;
		this.logger=logger;
	}
	
	
	/****************Reading Excel File *************************/
	
	public void readExcelFile(int testnumber)
	{
		try
		{
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\inputs.xlsx");
			XSSFWorkbook wk=new XSSFWorkbook(fis);
			XSSFSheet sheet=wk.getSheet("Sheet1");
			if(testnumber==1)
			{
				inputs[0]=String.valueOf(sheet.getRow(1).getCell(0));    
			}
			else if (testnumber==2)
			{
				inputs[0]=String.valueOf(sheet.getRow(4).getCell(0));     
			}
			else
			{
				
				for(int i=0;i<7;i++)                                        
				{
					inputs[i]=String.valueOf(sheet.getRow(7).getCell(i));          
				}
				wk.close();
			}	
			
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	/****************Writing results in Excel File *************************/
	
	public static void writeExcelFile(String status,int testno)
	{
		try 
		{
			while(n<1)
			{
				//..............Creating Test Scenario Sheet in results.xlsx...........//
				sheet2.createRow(0).createCell(0).setCellValue("Module");
			    sheet2.getRow(0).createCell(1).setCellValue("Test Scenario Id");
			    sheet2.getRow(0).createCell(2).setCellValue("Scenario Name");
			    sheet2.getRow(0).createCell(3).setCellValue("Scenario Description");
			    sheet2.getRow(0).createCell(4).setCellValue("Requirement Id");
			    
			    sheet2.createRow(1).createCell(0).setCellValue("Identify Courses");
			    sheet2.getRow(1).createCell(1).setCellValue("TS_01");
			    sheet2.getRow(1).createCell(2).setCellValue("WebDevelopment Courses");
			    sheet2.getRow(1).createCell(3).setCellValue("Searching and fetching deatails of first two WebDevelopment Courses ");
			    sheet2.getRow(1).createCell(4).setCellValue("R01");
			    
			    sheet2.createRow(2).createCell(1).setCellValue("TS_02");
			    sheet2.getRow(2).createCell(2).setCellValue("Language Learning");
			    sheet2.getRow(2).createCell(3).setCellValue("Searching and displaying languages as well as level count");
			    sheet2.getRow(2).createCell(4).setCellValue("R02");
			    
			    sheet2.createRow(3).createCell(1).setCellValue("TS_03");
			    sheet2.getRow(3).createCell(2).setCellValue("For Enterprise");
			    sheet2.getRow(3).createCell(3).setCellValue("Filling for Campus for in For Enterprise Section and capturing the error message.");
			    sheet2.getRow(3).createCell(4).setCellValue("R03");
			    
				n++;
			}
			
			//..............Creating Test Cases Sheet in results.xlsx...........
			
			//...Test Scenario 1 starts..
			if(testno==1)
			{
				sheet3.createRow(0).createCell(0).setCellValue("Test Scenario Id");
			    sheet3.getRow(0).createCell(1).setCellValue("Test Case Id");
			    sheet3.getRow(0).createCell(2).setCellValue("Test Case Name");
			    sheet3.getRow(0).createCell(3).setCellValue("Steps To Execute");
				sheet3.getRow(0).createCell(4).setCellValue("Result (Pass/Fail)");
				
				sheet3.createRow(1).createCell(0).setCellValue("TS_01");
				sheet3.getRow(1).createCell(1).setCellValue("TC_01");
				sheet3.getRow(1).createCell(2).setCellValue("Searching Web Development Courses");
			    sheet3.getRow(1).createCell(3).setCellValue("1.0 Search for Web Development Courses.");
			    sheet3.getRow(1).createCell(4).setCellValue(status);
			    sheet3.createRow(2).createCell(3).setCellValue("1.1 Select Begineer from Levels.");
			    sheet3.createRow(3).createCell(3).setCellValue("1.2 Select English from Languages.");
			    
			    FileOutputStream fos1=new FileOutputStream(new File("results.xlsx"));
			    workbook.write(fos1);
			}
			else if(testno==2)
			{
				sheet3.createRow(5).createCell(1).setCellValue("TC_02");
				sheet3.getRow(5).createCell(2).setCellValue("Details for Web Development Courses");
				sheet3.getRow(5).createCell(3).setCellValue("2.0 Fetch the details of first two courses.");
				sheet3.getRow(5).createCell(4).setCellValue(status);
				
				FileOutputStream fos1=new FileOutputStream(new File("results.xlsx"));
				workbook.write(fos1);
				
			}
			
			//...Test Scenario 2 starts..
			else if(testno==3)
			{
				sheet3.createRow(7).createCell(0).setCellValue("TS_02");
				sheet3.getRow(7).createCell(1).setCellValue("TC_03");
				sheet3.getRow(7).createCell(2).setCellValue("Searching for Language Learning");
			    sheet3.getRow(7).createCell(3).setCellValue("3.0 Search for Language Learning.");
			    sheet3.getRow(7).createCell(4).setCellValue(status);
			    
				FileOutputStream fos1=new FileOutputStream(new File("results.xlsx"));
				workbook.write(fos1);
				
			}
			else if(testno==4)
			{
				sheet3.createRow(9).createCell(1).setCellValue("TC_04");
				sheet3.getRow(9).createCell(2).setCellValue("Displaying Language in Language Learning");
			    sheet3.getRow(9).createCell(3).setCellValue("4.0 Selecting the show on option from language dropdown.");
			    sheet3.getRow(9).createCell(4).setCellValue(status);
			    sheet3.createRow(10).createCell(3).setCellValue("4.1 Display all the languages from language dropdown.");
				
				FileOutputStream fos1=new FileOutputStream(new File("results.xlsx"));
				workbook.write(fos1);
			}
			else if(testno==5)
			{
				sheet3.createRow(12).createCell(1).setCellValue("TC_05");
				sheet3.getRow(12).createCell(2).setCellValue("Displaying Level Count for Language Learning");
				sheet3.getRow(12).createCell(3).setCellValue("5.0 Select each level from the level dropdown and display its coresponding count.");
				sheet3.getRow(12).createCell(4).setCellValue(status);
				
				FileOutputStream fos1=new FileOutputStream(new File("results.xlsx"));
				workbook.write(fos1);
			}
			
			//...Test Scenario 3 starts..
			else
			{
				sheet3.createRow(14).createCell(0).setCellValue("TS_03");
				sheet3.getRow(14).createCell(1).setCellValue("TC_06");
				sheet3.getRow(14).createCell(2).setCellValue("For Enterprise Section");
				sheet3.getRow(14).createCell(3).setCellValue("6.0 Going to For Enterprise");
				sheet3.getRow(14).createCell(4).setCellValue(status);
				sheet3.createRow(15).createCell(3).setCellValue("6.1 Look into Courses for Campus under Product");
				sheet3.createRow(16).createCell(3).setCellValue("6.2 Filling the Ready to transform form with any one input invalid (example: email) and Capturing the error message.");
				
				FileOutputStream fos1=new FileOutputStream(new File("results.xlsx"));
				workbook.write(fos1);
				workbook.close();
			}

			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	    
	/***************** Verifying The Title ***********************/
	public void getTitle(String expectedTitle)
	{
		try
		{
		Assert.assertEquals(driver.getTitle(),expectedTitle);
		reportPass("Actual Title: "+driver.getTitle()+" - equals expected title");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
    /***************** Reporting Functions ***********************/
	
	public static void reportFail(String reportString)
	{
		logger.log(Status.FAIL, "Test Failed");
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}
	
	public static void reportPass(String reportString) 
	{
		logger.log(Status.PASS,reportString);
	}
	
	/***************** Capturing Screenshot ***********************/
	
	public static void takeScreenShotOnFailure()
	{
		TakesScreenshot sc=(TakesScreenshot) driver;
		File src=sc.getScreenshotAs(OutputType.FILE);
		File destn=new File(System.getProperty("user.dir")+"/Screenshots/" + DateUtils.getTimeStamp() +".png");
		try 
		{
			FileUtils.copyFile(src,destn);
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"/Screenshots/" + DateUtils.getTimeStamp()+".png");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	/***************** Closing the Browser ***********************/
	
	public void closeBrowser()
	{
		driver.quit();
	}
}

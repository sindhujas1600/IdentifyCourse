package IdentifyCourse;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BaseClasses.BaseTestClass;
import BaseClasses.PageBaseClass;


public class ElementsClass extends BaseTestClass{

/**********CourseraHomePage Elements************/
	
	@FindBy(xpath="//input[@role='textbox']")
	public static  WebElement searchBox;
	
	@FindBy(xpath="//span[text()='language learning']")
	public static WebElement course;
	
	@FindBy(xpath="//*[@id=\"__next\"]/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div")
	public static WebElement webcourse;
	
	@FindBy(xpath="//a[contains(text(),'For Enterprise')]")
	public static WebElement Enterprise;
	
	
	/********** WebDevSearchPage ************/
	
	@FindBy(xpath= "//*[@id=\"react-select-2--value\"]/div[1]")
	public static WebElement Language;
	
	@FindBy(xpath= "//*[@id=\"react-select-2--option-0\"]/div/button/label/input")     
	public static WebElement English;
	
	@FindBy(xpath= "//*[@id=\"react-select-3--value\"]/div[1]")
	public static WebElement Level;
	
	@FindBy(xpath= "//input[@value='Beginner']")
	public static WebElement Beginner;
	
	@FindBy(xpath="//li[@class='ais-InfiniteHits-item']")
	public static List<WebElement> Courses=null;
	
	
	/********** WebCourse_1 n WebCourse_2 ************/
	
	@FindBy(xpath="//h1[contains(@class,'banner-title')]")
	public static WebElement courseName;
	
	@FindBy(xpath="//div[@class='_1srkxe1s XDPRating']/span")
	public static WebElement courseRatings;
	
	@FindBy(xpath="//span[contains(text(),'to complete')]")  
	public static List<WebElement> courseDuration;
	
	
	/**********LangSearchPage Elements************/
	
	 @FindBy(xpath="//div[@id='react-select-2--value']")
	 public static WebElement langBox;
		
		@FindBy(xpath="//div[@id='react-select-2--option-9']//button[2]")
		public static WebElement showAll;
		
		@FindBy(xpath="//label[@class='_1oyudm1w cui-Checkbox cui-active']//div")
		public static List<WebElement> langOptions=null;
		
		//langOptions=null;
		@FindBy(xpath="//a[@class='nostyle']")
		public static WebElement cross;
		
		//..............................................................
		
		@FindBy(xpath="//div[@id='react-select-3--value']")
		public static WebElement levelBox;
		
		@FindBy(xpath="//div[@aria-label='Beginner']")
		public static WebElement Beg;
		
		@FindBy(xpath="//div[@aria-label='Mixed']")
		public static WebElement Mix;
		
		@FindBy(xpath="//div[@aria-label='Intermediate']")
		public static WebElement Int;
		
		@FindBy(xpath="//div[@aria-label='Advanced']")
		public static WebElement Adv;
		
		@FindBy(xpath="//button/h6")
		public static WebElement levelUnselect;
		
		@FindBy(xpath="//h2/span")
		public static WebElement count;	
	
		/**********Products_Enterprise Elements************/
		
		@FindBy(xpath="//ul[contains(@id,'main-menu')]//li[3]/a[contains(text(),'For Campus')]")
		static WebElement forCampus;
		
		@FindBy(xpath="//a[text()='Products']")
		static WebElement productHover;
		
		/**********ForEnterprise Elements************/
		
		@FindBy(id = "FirstName")
		public static WebElement Fname;

		@FindBy(id = "LastName")
		public static WebElement Lname;

		@FindBy(id = "C4C_Job_Title__c")
		public static WebElement JobFunction;

		@FindBy(id = "Title")
		public static WebElement Jobtitle;

		@FindBy(id = "Email")
		public static WebElement Email;

		@FindBy(id = "Phone")
		public static WebElement Phone;

		@FindBy(id = "Company")
		public static WebElement Institutename;

		@FindBy(id = "Institution_Type__c")
		public static WebElement InstituteType;

		@FindBy(id = "Primary_Discipline__c")
		public static WebElement PrimaryDisipline;

		@FindBy(id = "Country")
		public static WebElement Country;

		@FindBy(id = "State")
		public static WebElement State;

		@FindBy(xpath = "//*[@id=\"mktoForm_1512\"]/div[20]/span/button")
		public static WebElement Submit;

		@FindBy(id = "ValidMsgEmail")
		public static WebElement ErrorMessage;
		
		@FindBy(xpath="/html/body/main/section[3]/div/div[2]/div[1]/p[1]/a")
		public static WebElement ready;

}

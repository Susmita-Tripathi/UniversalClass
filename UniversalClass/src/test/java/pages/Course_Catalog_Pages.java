/* Author: Amruta
  * Functionality: Catalog course from universal class & search the course from catalog
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.SignIn_base;

public class Course_Catalog_Pages extends SignIn_base{
	
	static @FindBy(xpath="//button[@id='clssicon']") WebElement menubutton;        //page factory element for menu
	static @FindBy(xpath="//*[@id=\"clssmnucontent\"]/div/a[2]/span") WebElement coursecatalogoption;  //page factory element for course catalog option 
	static @FindBy(xpath="//input[@name='SearchString']") WebElement findcourse;  //page factory element for find course or search text box
	
	
	public Course_Catalog_Pages()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void home_page() throws Exception              //method for open universal class home page
	{
		driver.get(prop.getProperty("url"));
		Thread.sleep(1000);
	}
	public void click_on_course_catalog() throws Exception          //method to find catalog course option from menu
	{
		menubutton.click();
		Thread.sleep(1000);
		coursecatalogoption.click();
	}
	public void coursecatalog_page() throws Exception            //method to verify catalog course page
	{
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div[1]/div[1]/div/h1")).getText();
		System.out.println(s1);
		takescreenshot("CourseCatalogPage.png");
	}
	public void find_search_text_box() throws Exception               //method to find search text box on catalog course page
	{
		Thread.sleep(1000);
		System.out.println("search text box is visible");
	}
	public void search_for_course(String name) throws Exception      ///method for find courses
	{
		findcourse.clear();
		findcourse.sendKeys(name);
		findcourse.sendKeys(Keys.ENTER);
	}
	public void available_courses(String coursestatus) throws Exception         //method to get available courses
	{
		Thread.sleep(1000);
		if(coursestatus.matches("available"))
		{
		String s2=driver.findElement(By.xpath("//*[@id=\"searchresults\"]/div/ul/li[1]/a[2]")).getText();
		System.out.println(s2);
		if(s2.contains("Business"))
		{
			log=ext.createTest("CourseFound");
			log.log(Status.PASS, "Course is availabel");
			takescreenshot("CourseFound.png");
		}
		else
		{
			log=ext.createTest("WrongName");
			log.log(Status.FAIL, "Course name is wrong");
			takescreenshot("WrongName.png");
		}
		}
		if(coursestatus.matches("notavailable"))
		{
		String s3=driver.findElement(By.xpath("//*[@id=\"searchresults\"]/div/div/h2")).getText();
		System.out.println(s3);
		if(s3.contains("No records matched your search criteria."))
		{
			log=ext.createTest("CourseNotFound");
			log.log(Status.PASS, "Course is  not availabel");
			takescreenshot("CourseNotFound.png");
		}
		else
		{
			log=ext.createTest("WrongName");
			log.log(Status.FAIL, "Course name is wrong");
			takescreenshot("WrongName.png");
		}
		}
	}
}

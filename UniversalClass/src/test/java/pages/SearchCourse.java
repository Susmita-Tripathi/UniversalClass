/* Author: Akanksha Yadav
 * Date:08/01/2020
 * Description: Implementation for Search Course scenario from feature file
 * */

package pages;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import base.UniversalClass_Base;


public class SearchCourse extends UniversalClass_Base {

	//Page Factory Element for Search Course Object
	static @FindBy(id="SearchString") WebElement search;
	static @FindBy(xpath="//div[@class='listheader']/h2") WebElement course_unavailable_msg;
	static @FindBy(linkText="Learn HTML - Create Webpages Using HTML5") WebElement access_specific_course;
	static @FindBy(xpath="//h1[text()='Learn HTML - Create Webpages Using HTML5']") WebElement course_header;
	static @FindBy(name="JoinClassButton1") WebElement btn_join_course;
	static @FindBy(xpath="//h2[text()='Join this Course!']") WebElement hdr_join_course;
	static @FindBy(linkText="Sign In here") WebElement signIn_link;
	
	public SearchCourse() {
		PageFactory.initElements(driver,this);
	}
	
	//method to open url for UniversalClass Homepage
	public void openurl() {
		driver.get(prop.getProperty("url"));
	}
	
	//poi implementation for searching different course
	public void course_search() throws Exception {
		
		FileInputStream fin = new FileInputStream("src/test/resources/SearchCourse.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet ws = wb.getSheet("Sheet1");
		Row row;
		String course_name;
		for(int i=1;i<=ws.getLastRowNum();i++) {
			row = ws.getRow(i);
			course_name = row.getCell(0).getStringCellValue();	
			search.sendKeys(course_name);
			search.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			display_search_details(course_name);
			search.clear();
			Thread.sleep(3000);
		}
	}
	
	//Search field for blank input data
	public void blank_input_details() {
		search.sendKeys(Keys.ENTER);
	}
	
	public void blank_input_error_details() {
		if(driver.getTitle().contains("Search")) {
			log=ext.createTest("Search Course Result");
			log.log(Status.FAIL, "Redirected to Search Page when entered blank input");
			takescreenshot("SearchCourseResult.png");		
		}
		else {
			log=ext.createTest("Search Course Result");
			log.log(Status.PASS, "Not Redirected to Search Page, Error message should display: Search field should not be blank");
			takescreenshot("SearchCourseResult.png");
		}
	}
	
	//Search course result page for different course
	public void display_search_details(String coursename) {
		if(driver.getTitle().contains("Search")) {
			log=ext.createTest("Search Course Result "+coursename);
			log.log(Status.PASS, "Search Course Result is displayed based on serach for "+coursename);
			takescreenshot("SearchCourseResult "+coursename+" .png");		
		}
		else {
			log=ext.createTest("Search Course Result "+coursename);
			log.log(Status.FAIL, "Search Course Result Page is not displayed ");
			takescreenshot("SearchCourseResult.png");
		}
	}
	
	//to join a specific course
	public void enter_coursename() {
		
		String cname = prop.getProperty("coursename");
		search.sendKeys(cname);
		search.sendKeys(Keys.ENTER);
	}
	
	public void navigate_to_specific_course_page() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Learn HTML - Create Webpages Using HTML5")));		
		access_specific_course.click();
		if(course_header.getText().equals("Learn HTML - Create Webpages Using HTML5")) {
			log=ext.createTest("Search Course Result for specific course");
			log.log(Status.PASS, "Search Course Result is displayed based on specific course serach");
			takescreenshot("SearchCoursePageForSpecificCourse.png");
		}
		else {
			log=ext.createTest("Search Course Result for specific course");
			log.log(Status.FAIL, "Search Course Result is not displayed based on specific course serach");
			takescreenshot("SearchCoursePageForSpecificCourse.png");
		}
	}
	
	public void join_course() throws Exception {
		btn_join_course.click();
		if(hdr_join_course.getText().equals("Join this Course!")) {
			log=ext.createTest("Join Course Pop Up");
			log.log(Status.PASS, "Join Course pop_up is displayed");
			takescreenshot("JoinCoursePopUp.png");
			signIn_page();
		}
		else{
			log=ext.createTest("Join Course Pop Up");
			log.log(Status.FAIL, "Join Course pop_up is not displayed");
			takescreenshot("JoinCoursePopUp.png");
		}
	}
	
	public void signIn_page() throws Exception {
		Point point = signIn_link.getLocation();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,"+point.getY()+")", "");
		Thread.sleep(3000);
		signIn_link.click();
	}
	
}

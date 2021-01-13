/* Author: Jyoita Roy
 * Date: 09-jan-2021
 * Description: below code to
 *              open the url
 *              go to forgot password page and check the functionality(valid & invalid)
 */
package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Base;


public class ForgotPass extends Base
{
	 //PageFactory elements for forgot password page
	@FindBy(xpath="//button[@class='dropbtn']") WebElement dropbutton;                
	@FindBy(xpath="//span[text()='Sign In']") WebElement sign;
	@FindBy(xpath="//a[text()='Forgot your password?']") WebElement forgotbutton;
    @FindBy(xpath="//input[@name='Email']") WebElement Email;
    @FindBy(xpath="//input[@name='SubmitButton']") WebElement passReset;
    
	public ForgotPass()
	{
	    PageFactory.initElements(driver,this);      
	}
	
	public void openforgotpage()
	{
		driver.get(prop.getProperty("url"));    //open the url
		dropbutton.click();                         
        sign.click();                           //open signin page
		forgotbutton.click();                   //click forgot password button
	}
	
	public void putmail() throws Exception
	{
		FileInputStream fin=new FileInputStream("D:\\Demoeclipse\\data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet ws=wb.getSheet("Sheet4");
		Thread.sleep(1000);
		Row row;
		String uid;
	   	   for(int i=1;i<=ws.getLastRowNum();i++)
	   	   {
	   		   row=ws.getRow(i);
	   				  
	   			uid=row.getCell(0).getStringCellValue();
	   			Email.clear();
	   			Email.sendKeys(uid);
	   			passReset.click();
	   			verifyMessage();
	   			Thread.sleep(1000);
	   			driver.navigate().back();
	   	   }
        	wb.close();
        	fin.close();
        	
		Thread.sleep(1000);
		
	}
	public void verifyMessage() throws Exception
	{
	Thread.sleep(3000);
	String message=driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div/div[2]/div/div/div")).getText();
	String errormsg=driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div/div[2]/div/div/div[1]")).getText();
	
	if(message.contains("Successfully sent password"))
	{
		System.out.println(message);
		log=ext.createTest("ValidMail");
		log.log(Status.PASS, "Email is correct");
		takescreenshot("ValidMail.png");
		
	}
	else if(errormsg.contains("There is no match"))
	{
		System.out.println(errormsg);
		log=ext.createTest("InValidMail");
		log.log(Status.PASS, "Email is not correct");
		takescreenshot("InValidMail.png");
		
	}
	

	}
}



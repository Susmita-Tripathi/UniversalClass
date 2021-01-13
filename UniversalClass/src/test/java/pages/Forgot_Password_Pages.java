/* Author: Amruta
  * Functionality: Forgot password for universal class 
 */
package pages;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.SignIn_base;

public class Forgot_Password_Pages extends SignIn_base{
	
	static @FindBy(xpath="//input[@name='Email']") WebElement Email;  //page factory element for Forgot Password(email)
	static @FindBy(xpath="//input[@name='SubmitButton']") WebElement resetpasswordbutton; //page factory element for Forgot Password(resetpassword)
	static @FindBy(xpath="//*[@id=\"clssicon\"]") WebElement menuclick;   //Page factory element for menu click
	
	public Forgot_Password_Pages()
	{
		PageFactory.initElements(driver, this);
		
	}
	public void go_to_forgotpass_page() throws Exception        //method to find forgot password page
	{
		Thread.sleep(1000);
		driver.get(prop.getProperty("url"));
		
		
		menuclick.click();   //menu click
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='clssmnucontent']/div/a[1]/span")).click();   //signIn
		Thread.sleep(1000);
		takescreenshot("SignInPage.png");
		
		driver.findElement(By.xpath("//*[@id=\"LoginForm2020\"]/div[4]/a")).click();//forgotpassword link
		
	}
	
	public void enter_email() throws Exception          //method to put an email  from excel sheet
	{
		Thread.sleep(1000);
		FileInputStream fin=new FileInputStream("C:\\Users\\kolek\\Downloads\\Universal.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Thread.sleep(3000);
		Row row;
		String email;
			for(int i=1;i<ws.getLastRowNum();i++)
			{
				row=ws.getRow(i);
				
				email=row.getCell(0).getStringCellValue();
				Email.clear();
				Email.sendKeys(email);
				resetpasswordbutton.click();
				verify_error_message();
	
				driver.navigate().back();
			}
			wb.close();
			fin.close();
	}
	public void verify_error_message() throws Exception              //method to verify alert message
	{
		Thread.sleep(1000);
		String string1=driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div/div[2]/div/div/div")).getText();
	
		String string2=driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div/div[2]/div/div/div[1]")).getText();
		
		if(string2.contains("Successfully sent password reset information to rjyoita@gmail.com!"))
		{
			log=ext.createTest("Email Sent");
			log.log(Status.PASS, "Successful message has been verified");
			takescreenshot("EmailSent.png");
		}
		else if(string1.contains("There is no match for an account with that email address."))
		{
			log=ext.createTest("Wrong Email");
			log.log(Status.PASS, "Error message is verified");
			takescreenshot("WrongEmail.png");
		}
		
	}
	
}

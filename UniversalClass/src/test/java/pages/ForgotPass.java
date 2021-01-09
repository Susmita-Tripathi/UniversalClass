package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.ForgotPassword_base;

public class ForgotPass extends ForgotPassword_base {

	@FindBy(xpath="//button[@class='dropbtn']") WebElement dropbutton;
	@FindBy(xpath="//*[@id='clssmnucontent']/div/a[1]/span") WebElement sign;
	@FindBy(xpath="//*[@id=\"LoginForm2020\"]/div[4]/a") WebElement forgotbutton;
	
	public ForgotPass()
	{
	    PageFactory.initElements(driver,this);
     //   driver.get(prop.getProperty("url"));
        
	}
	
	public void openforgotpage()
	{
		driver.get(prop.getProperty("url"));    
		dropbutton.click();
        sign.click();
		forgotbutton.click();
	}
	
	public void putmail(String email) throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div/div[2]/div/div/form/div[2]/input")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div/div[2]/div/div/form/div[3]/input")).click();
	}
	public void verifyMassage() throws Exception
	{
		Thread.sleep(3000);
	String massage=driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div/div[2]/div/div/div[1]/div")).getText();
	System.out.println(massage);
	if(massage.contains("Successfully sent password"))
	{
		log=ext.createTest("SubscribedMail");
		log.log(Status.PASS, "Email is correct");
		takescreenshot("subValidMail.png");
	}
	else
	{
		log=ext.createTest("SubscribedMail");
		log.log(Status.FAIL, "Email is not correct");
		takescreenshot("SUbValidMail.png");
	}
	//driver.navigate().back();
	}
	public void errmassage() throws Exception
	{
		Thread.sleep(5000);
		String massage=driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div/div[2]/div/div/div")).getText();
		System.out.println(massage);
		if(massage.contains("There is no match"))
		{
			log=ext.createTest("UnSubscridedValidMail");
			log.log(Status.PASS, "Email is correct");
			takescreenshot("ValidMail.png");
		}
		else
		{
			log=ext.createTest("UnSubscridedValidMail");
			log.log(Status.FAIL, "Email is not correct");
			takescreenshot("ValidMail.png");
		}
	}
	public void error() throws Exception
	{

		Thread.sleep(5000);
		String massage=driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div/div[2]/div/div/div")).getText();
		System.out.println(massage);
		if(massage.contains("The email is invalid"))
		{
			log=ext.createTest("unsubInValidMail");
			log.log(Status.PASS, "Email is correct");
			takescreenshot("InValidMail.png");
		}
		else
		{
			log=ext.createTest("UnSubInvalidMail");
			log.log(Status.FAIL, "Email is not correct");
			takescreenshot("InValidMail.png");
		}
	}
}

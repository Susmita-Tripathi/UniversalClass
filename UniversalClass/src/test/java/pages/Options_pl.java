package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import base.Base_pl;

public class Options_pl extends Base_pl {
	
	public void login() throws Exception {
		page_setup(driver);
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//*[@id=\"clssicon\"]")).click();
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		driver.findElement(By.xpath("//*[@id=\"bodyid\"]/div[1]/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("04sayali.patil@gmail.com");
		driver.findElement(By.name("password")).sendKeys("sayali04");
		driver.findElement(By.name("SubmitButton")).click();
		Thread.sleep(3000);
	}
	
	public void menu_click() throws Exception {
		driver.findElement(By.id("clssicon")).click();
	}
	
	public void verify_message() throws Exception
	{
		//*[@id="clssmnucontent"]/span
		String message = driver.findElement(By.xpath("//*[@id=\"clssmnucontent\"]/span")).getText();
		System.out.print(message);
	}
	
}

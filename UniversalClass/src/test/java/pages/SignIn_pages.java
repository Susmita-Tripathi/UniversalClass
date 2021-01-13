/* Author: Amruta
  * Functionality: Sign in from home page of universal class 
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

public class SignIn_pages extends SignIn_base{
	
	static @FindBy(xpath="//button[@id='clssicon']") WebElement menubutton;        //page factory element for menu click
	static @FindBy(xpath="//input[@name='username']") WebElement username;        //page factory element for SignIn page(email)
	static @FindBy(xpath="//input[@name='password']") WebElement passwordtext;    //page factory element for SignIn page(password)
	static @FindBy(xpath="//input[@name='SubmitButton']") WebElement SubmitButton;            //page factory element for SignIn page(SignIn button)
	                                
	
	public SignIn_pages()
	{
		PageFactory.initElements(driver, this);
		
	}
	public void universalclass() throws Exception          //method for open the universal class website
	{	
		Thread.sleep(3000);
		driver.get(prop.getProperty("url"));
		System.out.println("url opened");
		
	}
	public void click_on_signin() throws Exception          //method for find the sign in option on home page
	{	menubutton.click();
	    Thread.sleep(3000);
	    System.out.println("uc page");
		
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();   //signIn option 
		Thread.sleep(1000);
		takescreenshot("MemberSignInPage.png");
		System.out.println("home page");
	}
	public void enter_invalid_credentials() throws Exception     //when user enters invalid input credentials the it gives an error message
	{
		FileInputStream fin=new FileInputStream("C:\\Users\\kolek\\Downloads\\Universal.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet ws=wb.getSheet("Sheet3");
		Thread.sleep(3000);
		Row row;
		String email;
		String password;
			for(int i=1;i<ws.getLastRowNum();i++)
			{
				row=ws.getRow(i);
				
				email=row.getCell(0).getStringCellValue();
				password=row.getCell(1).getStringCellValue();
				username.clear();
				username.sendKeys(email);
				passwordtext.clear();
				passwordtext.sendKeys(password);
				SubmitButton.click();
				verify_error_message();
				Thread.sleep(1000);
				//driver.navigate().back();
			}
			wb.close();
			fin.close();
		
	}
	public void verify_error_message() throws Exception   //method to verify the error message
	{
		Thread.sleep(3000);
		String message=driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div[1]/div[1]/div/div")).getText();  //read or verify error message
		System.out.println(message);
		
		if(message.contains("You've entered an invalid Username/Email or Password."))
		{
			log=ext.createTest("Invalid credentials");
			log.log(Status.PASS, "Error message is correct");
			takescreenshot("Invalidcredentials.png");
		}
		else
		{
			log=ext.createTest("Invalid credentials");
			log.log(Status.FAIL, "Error message is not correct");
			takescreenshot("Invalidcredentials.png");
		}
	}
	public void valid_signin() throws Exception    //method for giving valid input manually
	{
		Thread.sleep(1000);
		username.sendKeys("amrutakolekar191@gmail.com"); 
		passwordtext.sendKeys("Amruta@1010");
		Thread.sleep(1000);
		SubmitButton.click();
	}
	public void welcome_window() throws Exception            //method to verify successful sign in
	{
		System.out.println("Welcome to UniversalClass");
		
		Thread.sleep(3000);
		String msg=driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div[1]/div/div/div/div[2]/h1")).getText();
		
		if(msg.contains("Classes I'm Taking"))
		{
			log=ext.createTest("User has Signed in successfully");
			log.log(Status.PASS, "Successful");
			takescreenshot("SignedInSuccessful.png");
		}
		else
		{
			log=ext.createTest("User not Signed in");
			log.log(Status.FAIL, "Unsuccessful");
			takescreenshot("SignedInUnsuccessful.png");
		}
	}	
}
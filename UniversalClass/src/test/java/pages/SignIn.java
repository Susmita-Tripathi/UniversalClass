package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.UniversalClass_Base;

public class SignIn extends UniversalClass_Base {

	static @FindBy(id="clssicon") WebElement menu_icon;
	static @FindBy(xpath="//span[text()='Sign In']") WebElement signIn;
	static @FindBy(name="username") WebElement uname;
	static @FindBy(name="password") WebElement pass;
	static @FindBy(name="SubmitButton") WebElement signIn_button;
	static @FindBy(xpath="//button[@class='spobutton']") WebElement post_signIn_button;
	static @FindBy(linkText="Log Off") WebElement log_off;
	
	public SignIn()
	{
		PageFactory.initElements(driver,this);

	}
	
	public void open_signInPage() {
		
		//driver.get(prop.getProperty("url"));
		menu_icon.click();
		signIn.click();
		String title = driver.getTitle();
		if(title.equals("Member Sign In | UniversalClass.com")) {
			log=ext.createTest("Sign In Homepage");
			log.log(Status.PASS, "Sign In page is displayed");
			takescreenshot("SignIn.png");
		}
		else {
			log=ext.createTest("Sign In Homepage");
			log.log(Status.FAIL, "Sign In page is not displayed");
			takescreenshot("SignIn.png");
		}
		
	}
	
	public void input_details(String username, String password) {	
		uname.sendKeys(username);
		pass.sendKeys(password);
		signIn_button.click();
	}
	
	public void signIn_success() throws Exception {
	 
		String title = driver.getTitle();
		Thread.sleep(5000);
		if(title.equals("UniversalClass.com")) {
			log=ext.createTest("Sign In Success");
			log.log(Status.PASS, "Sign In Success");
			takescreenshot("SignInSuccess.png");
			menu_icon.click();
			log_off.click();
			menu_icon.click();
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",	log_off );
			//log_off.click();
			
		}
		else {
			log=ext.createTest("Sign In Success");
			log.log(Status.FAIL, "Sign In Unsuccess");
			takescreenshot("SignInUnsuccess.png");
		}
		
	}
	
	public void signIn_Error() throws Exception {
		
		String title = driver.getTitle();
		Thread.sleep(5000);
		if(title.equals("Member Sign In | UniversalClass.com")) {
			log=ext.createTest("Sign In");
			log.log(Status.PASS, "Error message is displayed for SignIn");
			takescreenshot("SignInError.png");
		}
		else {
			log=ext.createTest("Sign In");
			log.log(Status.FAIL, "Error message is not displayed for SignIn");
			takescreenshot("SignInError.png");
		}
	}
}

/* Author: Akanksha Yadav
 * Date:09/01/2020
 * Description: Implementation for ForgotPassword scenario from feature file
 * */

package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.UniversalClass_Base;

public class ForgotPassword extends UniversalClass_Base {

	//PageFactory Element for MenuIcon Object
	static @FindBy(id="clssicon") WebElement menu_icon;
	static @FindBy(xpath="//span[text()='Sign In']") WebElement signInIcon;
	
	//PageFactory Element for ForgotPassword Object
	static @FindBy(linkText="Forgot your password?") WebElement forgot_passLink;
	static @FindBy(name="Email") WebElement mail;
	static @FindBy(name="SubmitButton") WebElement rest_pass;
	static @FindBy(xpath="//div[@class='loginform']/h1") WebElement forgot_passPage;
	static @FindBy(xpath="//div[@class='zoomIn errorscreen']") WebElement error_details;
	static @FindBy(xpath="//div[@class='zoomIn errorscreen']/div") WebElement resetPass_mailSent;
	
	public ForgotPassword()
	{
		PageFactory.initElements(driver,this);

	}
	
	//method to open forgotPassword homepage
	public void open_forgotPassPage() {
		
		menu_icon.click();
		signInIcon.click();
		forgot_passLink.click();
		if(forgot_passPage.getText().contains("Forgot Your Password?")) {
			log=ext.createTest("Forgot Password Homepage");
			log.log(Status.PASS, "Forgot Password page is displayed");
			takescreenshot("ForgotPasswordHomepage.png");
		}
		else {
			log=ext.createTest("Forgot Password Homepage");
			log.log(Status.FAIL, "Forgot Password page is not displayed");
			takescreenshot("ForgotPasswordHomepage.png");
		}
	}
	
	/*method to enter input details*/
	public void blank_input() {
		rest_pass.click();
	}
	
	public void input_details(String email) {
		mail.sendKeys(email);
		mail.sendKeys(Keys.ENTER);
	}
	
	//method to verify if link is sent to rest password
	public void ResetPass_MailSent() {
		
		if(resetPass_mailSent.isDisplayed()==true) {
			log=ext.createTest("Forgot Password Link Sent");
			log.log(Status.PASS, "Forgot Password link is sent to respective mail id");
			takescreenshot("ForgotPasswordLinkSent.png");
		}
		else {
			log=ext.createTest("Forgot Password Link Sent");
			log.log(Status.FAIL, "Forgot Password link is not sent to respective mail id");
			takescreenshot("ForgotPasswordLinkSent.png");
		}
	}
	
	/*method to verify error details when entered invalid data*/
	public void blank_input_error_details() {
		
		if(error_details.equals("Sorry, that email address was not found.")) {
			log=ext.createTest("ForgotPassword Error Message for Blank Input");
			log.log(Status.PASS, "Error message is displayed for blank input");
			takescreenshot("ForgotPasswordBlankInputError.png");
		}
		else {
			log=ext.createTest("ForgotPassword Error Message for Blank Input");
			log.log(Status.PASS, "Error message is not displayed for blank input");
			takescreenshot("ForgotPasswordBlankInputError.png");
		}
	}
	
	public void error_details() {
		
		if(error_details.isDisplayed()==true) {
			log=ext.createTest("ForgotPassword Error Message for Invalid Data");
			log.log(Status.PASS, "Error message is displayed when entered invalid email id");
			takescreenshot("ForgotPasswordError.png");
		}
		else {
			log=ext.createTest("ForgotPassword Error Message for Invalid Data");
			log.log(Status.FAIL, "Error message is not displayed when entered invalid email id");
			takescreenshot("ForgotPasswordInvalidEmailError.png");
		}
	}
}

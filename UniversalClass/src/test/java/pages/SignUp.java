/* Author: Akanksha Yadav
 * Date:10/01/2020
 * Description: Implementation for SignUp scenario from feature file
 * */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.UniversalClass_Base;


public class SignUp extends UniversalClass_Base {
	
	//PageFactory Element for MenuIcon Object
	static @FindBy(xpath="//*[@id=\"clssicon\"]/img") WebElement menu_icon;
	static @FindBy(xpath="//span[text()='Subscribe']") WebElement subscribe;
	
	//PageFactory Element for Payment Details
	static @FindBy(xpath="//div[@class='planarea']/div[4]/div[5]/a[text()='Start Now']") WebElement payment_plan;
	
	//PageFactory Element for SignUp Object
	static @FindBy(id="givenname") WebElement fname;
	static @FindBy(id="sn") WebElement lname;
	static @FindBy(xpath="//*[@id=\"mail\"]") WebElement mail;
	static @FindBy(id="userpassword") WebElement pass;
	static @FindBy(xpath="//*[@id=\"PubRegisterForm\"]/div[5]/input[@type='checkbox']") WebElement tos;
	static @FindBy(xpath="//*[@id=\"PubRegisterForm\"]/div[6]/input[@class='spobutton']") WebElement sign_up;
	static @FindBy(id="PopUpContent") WebElement signUp_popUpWindow;
	static @FindBy(xpath="//*[@id=\"myClosePopUpWindow\"]") WebElement popup_close;
	static @FindBy(xpath="//*[@id=\"popbdy\"]/div[1]/div") WebElement error_field;
	
	//PageFactory Element after sucessfully signing in 
	static @FindBy(xpath="//*[@id=\"SendVerifyEmailForm\"]/input[3]") WebElement verify_email;
	static @FindBy(xpath="//*[@id=\"mainbody\"]/div[1]/div/div/h1") WebElement verifyemail_page;
	static @FindBy(xpath="//*[@id=\"mainbody\"]/div[3]/div/div[2]/div[1]") WebElement verificationlink;
	static @FindBy(xpath="//*[@id=\"clssmnucontent\"]/span") WebElement signin_welcome;
	static @FindBy(xpath="//*[@id=\"clssmnucontent\"]/div/a[3]/span[text()='My Classes']") WebElement my_class;
	static @FindBy(xpath="//*[@id=\"clssmnucontent\"]/div/a[7]/span") WebElement log_off;
	
	public SignUp()
	{
		PageFactory.initElements(driver,this);
	}
	
	//method to open url of signUp page
	public void openSignUpPAge() throws Exception
	{	
		driver.navigate().to(prop.getProperty("url"));
		menu_icon.click();
		subscribe.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",payment_plan );
		System.out.println("User is on Sign Up page");
		Thread.sleep(5000);
		if(signUp_popUpWindow.isDisplayed()==true) {
			log=ext.createTest("Sign Up");
			log.log(Status.PASS, "Sign Up page is displayed");
			takescreenshot("SignUp.png");
		}
		else {
			log=ext.createTest("Sign Up");
			log.log(Status.FAIL, "Sign Up page is not displayed");
			takescreenshot("SignUp.png");
		}
	}
	
	/*method for entering input details for signUp*/
	public void enter_input_details(String firstname, String lastname, String email, String password ) {
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		mail.sendKeys(email);
		pass.sendKeys(password);
	}
	
	public void select_checkbox_and_click_SignUp() {
		tos.click();
		sign_up.click();
		
	}
	
	/*method to check if signUp is success or fail */
	public void verify_email() throws Exception {
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("UniversalClass.com")){
			log=ext.createTest("Verify Email");
			log.log(Status.PASS, "Verify Email page is displayed");
			takescreenshot("VerifyEmail.png");
			signup_furtherprocess();
	        menu_icon.click();
	        log_off.click();
	        menu_icon.click();
	        log_off.click();
		}
		else {
			log=ext.createTest("Verify Email");
			log.log(Status.FAIL, "Verify Email page is not displayed, user is not signed in");
			takescreenshot("VerifyEmail.png");	
			popup_close.click();
		}
		
	}
	public void signup_furtherprocess() throws Exception {
		Thread.sleep(5000);
		verify_email.click();
		Thread.sleep(1000);
		String verifylink = verificationlink.getText();
		if(verifylink.contains("Successfully Sent")) {
			log=ext.createTest("Send Verification link");
			log.log(Status.PASS, "Email verification link successfully sent");
			takescreenshot("Verificationlink.png");
		}
		Thread.sleep(3000);	
		menu_icon.click();
		my_class.click();
		String msg = driver.findElement(By.xpath("//*[@id=\"CloseThisWindow1\"]/div/div[2]/div/button")).getText();
		String welcome_msg = signin_welcome.getText();
		Thread.sleep(5000);
		if(msg.contains("I want to")) {
			log=ext.createTest("SignIn Successfully");
			log.log(Status.PASS, "SignIn Successfully "+welcome_msg);
			takescreenshot("SignIn.png");
		}
		else {
			log=ext.createTest("SignIn Unsuccess");
			log.log(Status.FAIL, "SignIn Unsuccess expected: "+welcome_msg);
			takescreenshot("SignIn.png");
		}
	}
	
	/*method to display error details when terms of service is not selected*/
	public void checkbox_unchecked() throws Exception {
		sign_up.click();
		Thread.sleep(5000);
	}
	
	public void checkbox_unchecked_error() throws Exception {
		Thread.sleep(5000);
		String error_msg = error_field.getText();
		if(error_msg.contains("Please correct")) {
			log=ext.createTest("Terms of service not selected");
			log.log(Status.PASS, "Error message is displayed when we terms of service is not selected "+error_msg);
			takescreenshot("TOS_Unchecked.png");
		}
		else {
			log=ext.createTest("Terms of service");
			log.log(Status.FAIL, "Error message is not displayed "+error_msg);
			takescreenshot("TOS_Unchecked.png");
		}
		Thread.sleep(5000);
		popup_close_button();
	}
	
	public void popup_close_button() {
		popup_close.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",payment_plan );
	}
	
	/*method to display error details when enter blank input*/
	public void blank_input() throws Exception {
		fname.sendKeys(Keys.ALT);
		sign_up.click();
	}
	
	public void blank_input_error() throws Exception {
		Thread.sleep(5000);
		String error_msg = error_field.getText();
		if(error_msg.contains("Please correct")) {
			log=ext.createTest("Input Field Blank");
			log.log(Status.PASS, "Error message is displayed when we don't enter any input "+error_msg);
			takescreenshot("InputFieldBlank.png");
		}
		else {
			log=ext.createTest("Input Field Blank");
			log.log(Status.FAIL, "Error message  is not displayed "+error_msg);
			takescreenshot("InputFieldBlank.png");
		}
			Thread.sleep(5000);
	}
	
	//method to display error details for entering invalid email
	public void invalid_email_error() throws Exception {
		Thread.sleep(5000);
		String error_msg = error_field.getText();
		if(error_msg.contains("Please correct")) {
			log=ext.createTest("Invalid Email");
			log.log(Status.PASS, "Error message is displayed when entered invalid email "+error_msg);
			takescreenshot("InvalidEmail.png");
		}
		else {
			log=ext.createTest("Invalid Email");
			log.log(Status.FAIL, "Error message is not displayed "+ error_msg);
			takescreenshot("InvalidEmail.png");
		}
			Thread.sleep(5000);
			popup_close_button();
	}
	
	//method to display error details for entering invalid password
	public void invalid_password_error() throws Exception {
		Thread.sleep(5000);
		String error_msg = error_field.getText();
		if(error_msg.contains("Please correct")) {
			log=ext.createTest("Invalid Password");
			log.log(Status.PASS, "Error message is displayed when enetered invalid password "+error_msg);
			takescreenshot("InvalidPassword.png");
		}
		else {
			log=ext.createTest("Invalid Password");
			log.log(Status.FAIL, "Error message is not displayed "+error_msg);
			takescreenshot("InvalidPassword.png");
		}
			Thread.sleep(5000);
			popup_close_button();
	}
	
	//method to display error details for entering email id which is already subscribe
	public void duplicate_email_error() throws Exception {
		Thread.sleep(5000);
		String error_msg = error_field.getText();
		if(error_msg.contains("Please correct")) {
			log=ext.createTest("Email already registered");
			log.log(Status.PASS, "Error message is displayed when entered duplicate email "+error_msg);
			takescreenshot("DuplicateEmailError.png");
		}
		else {
			log=ext.createTest("Email already registered");
			log.log(Status.FAIL, "Error message is not displayed "+error_msg);
			takescreenshot("DuplicateEmailError.png");
		}
			Thread.sleep(5000);
			popup_close_button();
	}

	//method to display error details for entering invalid character
	public void invalid_character_error() throws Exception {
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("UniversalClass.com"))  {
			menu_icon.click();
			Thread.sleep(3000);
			log=ext.createTest("Invalid Characters in first name and last name");
			log.log(Status.FAIL, "Error message should be displayed when entered invalid characters in first name and last name");
			takescreenshot("InvalidCharacters.png");
			log_off.click();
			menu_icon.click();
			log_off.click();
		}
		else if(title.equals("My Shopping Cart | UniversalClass.com")){
	
			if(error_field.getText().contains("Your firstname and lastname should not contain invalid characters")){
				log=ext.createTest("Invalid Characters in first name and last name");
				log.log(Status.PASS, "Error message is displayed when entered invalid characters in first name and last name");
				takescreenshot("InvalidCharacters.png");
				Thread.sleep(5000);
				popup_close_button();
			}
			else {
				log=ext.createTest("Invalid Characters in first name and last name");
				log.log(Status.FAIL, "Error message is displayed, but is not the valid error message");
				takescreenshot("InvalidCharacters.png");
				Thread.sleep(5000);
				popup_close_button();
			}
		}
	}
}

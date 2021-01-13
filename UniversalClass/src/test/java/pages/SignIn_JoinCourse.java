/* Author: Akanksha Yadav
 * Date:09/01/2020
 * Description: Implementation for SignIn scenario from feature file
 * */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.UniversalClass_Base;

public class SignIn_JoinCourse extends UniversalClass_Base {

	//PageFactory Element for MenuIcon Object	
	static @FindBy(id="clssicon") WebElement menu_icon;
	static @FindBy(xpath="//span[text()='Sign In']") WebElement signIn;
	static @FindBy(linkText="Log Off") WebElement log_off;
	
	//PageFactory Element for SignIn popUp Window
	static @FindBy(name="username") WebElement uname;
	static @FindBy(name="password") WebElement pass;
	static @FindBy(name="SubmitButton") WebElement signIn_button;
	static @FindBy(xpath="//h2[text()='Sign In with your UniversalClass Account']") WebElement popup_header;
	
	//PageFactory Element for post signIn Object
	static @FindBy(xpath="//div[@class='planbubble']/a") WebElement courseplan_header;
	static @FindBy(xpath="//div[@class='planarea fadeslide']/div/div[5]/a[text()='Add to Cart']") WebElement add_to_cart;
	static @FindBy(xpath="//div[@class='frontdroptitle']") WebElement shoppingCart;	
	static @FindBy(id="frontdropclosebutton") WebElement close_popUp;
	static @FindBy(xpath="//div[@class='zoomIn errorscreen']") WebElement error_field;
	
	public SignIn_JoinCourse()
	{
		PageFactory.initElements(driver,this);

	}
	
	//method to verify signIn popUp window 
	public void open_signInPage() throws InterruptedException {
		
		Thread.sleep(3000);
		if(popup_header.getText().contains("Sign In with your UniversalClass Account")) {
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
	
	//method to enter input details for signIn
	public void input_details(String username, String password) {	
		uname.sendKeys(username);
		pass.sendKeys(password);
		signIn_button.click();
	}
	
	//method to verify if signIn is success or not
	public void signIn_success() throws Exception {
	 
		Thread.sleep(5000);
		if(courseplan_header.isDisplayed()==true) {
			log=ext.createTest("Sign In Success");
			log.log(Status.PASS, "Sign In success");
			takescreenshot("SignInSuccess.png");
			add_to_cart.click();
			
			if(shoppingCart.isDisplayed()==true) {
				log=ext.createTest("User can proceed with payment process");
				log.log(Status.PASS, "Payment details is displayed");
				takescreenshot("PaymentProcess.png");
				close_popUp.click();
				log_off_account();
			}	
			else {
				log=ext.createTest("User can proceed with payment process");
				log.log(Status.FAIL, "Payment details is not displayed");
				takescreenshot("PaymentProcess.png");
				log_off_account();
			}
		}
		/*else if(driver.getTitle().contains("UniversalClass.com")) {
			log=ext.createTest("Sign In Success");
			log.log(Status.PASS, "Sign In success");
			takescreenshot("SignInSuccess.png");
			
			WebElement verifyEmail = driver.findElement(By.tagName("h1"));
			if(verifyEmail.isDisplayed()==true) {
				log=ext.createTest("Verify Email Page is Displayed post sign in when user want to join course");
				log.log(Status.PASS, "User cannot proceed with payment process, email need to be verified first");
				takescreenshot("VerifyEmail_BeforePaymentProcess.png");
				log_off_account();
			}		
			
		}*/
		else {
			log=ext.createTest("Sign In Success");
			log.log(Status.FAIL, "Sign In Unsuccess");
			takescreenshot("SignInUnsuccess.png");
		}
		Thread.sleep(3000);
		
	}
	
	//method to logOff from account
	public void log_off_account() {
		menu_icon.click();
		log_off.click();
		menu_icon.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",	log_off );
	}
	
	//method to check error details for signIn when entered invalid input
	public void signIn_Error() throws Exception {
		
		Thread.sleep(5000);
		if(error_field.isDisplayed()==true) {
			log=ext.createTest("Sign In Error Details");
			log.log(Status.PASS, "Error message is displayed for SignIn when entered invalid input "+error_field.getText());
			takescreenshot("SignInError.png");
		}
		else {
			log=ext.createTest("Sign In Error Details");
			log.log(Status.FAIL, "Error message is not displayed for SignIn");
			takescreenshot("SignInError.png");
		}
		Thread.sleep(3000);
	}
}

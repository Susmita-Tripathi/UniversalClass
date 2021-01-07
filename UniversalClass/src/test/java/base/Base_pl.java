package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Base_pl {
	public static WebDriver driver = new ChromeDriver();
	public static Properties prop;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports ext;
	public static ExtentTest log;
	
	@Before("@welcome_message")
	public void before_scenario()
	{
		prop = new Properties();
		try 
		{
			prop.load(new FileInputStream("src/test/resources/config.properties"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		htmlreport = new ExtentHtmlReporter(prop.getProperty("reportslocation")+ "postlogin.html");
		ext = new ExtentReports();
		ext.attachReporter(htmlreport);
		ext.setSystemInfo("Host Name", "sustripa-sysname");
		ext.setSystemInfo("Environment", "Test Env");
		ext.setSystemInfo("User Name", "Susmita-testername");   
		htmlreport.config().setDocumentTitle("Google");
		htmlreport.config().setReportName("Google Functional Testing");
		htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreport.config().setTheme(Theme.STANDARD);		
	}
	
	public void page_setup(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void takescreenshot(String imagename)
	{
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	//takescreenshot of the webpage
		try
		{
		FileUtils.copyFile(f, new File(prop.getProperty("screens")+"\\"+imagename));	//save thefile in the system
		log.addScreenCaptureFromPath(prop.getProperty("screens")+"\\"+imagename);	//add image to the report
		}catch(Exception e) {}	
	}
	
	@After("@logout_message")
	public void after_scenario()
	{
		ext.flush();//save the report
		driver.quit();//close if anyall browsers which are open
		try
		{
		Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");//kill the geckodriver process
		}catch(Exception e) {}
		
	}
}

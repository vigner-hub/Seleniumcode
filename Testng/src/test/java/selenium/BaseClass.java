package selenium;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(CustomListner.class)
public class BaseClass {

	protected static  WebDriver driver;
	ExtentSparkReporter reporter;
	static ExtentReports extent;
	static ExtentTest test;
	static File file;

	 public static ExtentTest getTest() {
	        return test;
	    }

	    public static void setTest(ExtentTest test) {
	    	BaseClass.test = test;
	    }
	@BeforeSuite
	public void extentReportSetUp() {
		extent = new ExtentReports();
		File file = new File(
				System.getProperty("user.dir") + "/ExtentReport/report2.html");
		reporter = new ExtentSparkReporter(file);
		reporter.config().setReportName("Automation Report_Sprint1");
		reporter.config().setDocumentTitle("Automation");
		reporter.config().setTheme(Theme.DARK);
		extent.attachReporter(reporter);

	}

	@BeforeClass
	public void browserSetup() {
	//	WebDriverManager.edgedriver().setup();
	//	driver = new EdgeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
	//	WebDriverManager.chromedriver().setup();
	//	driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		System.out.println("Driver initialized.");
	}


	@BeforeMethod
	public void checkStart() {
		System.out.println("Checking Before Method");
	}

	

	public String takeScreenshot(String methodname) throws IOException {
		if (driver != null) {
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String destination = "D:\\Vignesh\\workspace\\Testng\\ScreenShots\\" + methodname + ".jpg";
		//	File destination = new File("D:\\Vignesh\\workspace\\Testng\\ScreenShots\\" + methodname + ".jpg");
			FileUtils.copyFile(source, new File(destination));
			return destination;
		} else {
			System.out.println("Driver is null. Cannot take screenshot.");
			return null;
		}
	}
	
	@AfterMethod
	public void checkEnd(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			
				String methodName = result.getName();
		        String screenshotPath = takeScreenshot(methodName);
		   //     BaseClass.getTest().fail(result.getThrowable());
		        BaseClass.getTest().addScreenCaptureFromPath(screenshotPath);
			
			}
		}
	



	@AfterClass
	public void quit() {
		if (driver != null) {
			driver.quit();
			System.out.println("Driver quit.");
		}
	}

	@AfterSuite
	public void extentReportTearDown() throws Exception {
		extent.flush();
		 try {
	            Desktop.getDesktop().browse(file.toURI());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}


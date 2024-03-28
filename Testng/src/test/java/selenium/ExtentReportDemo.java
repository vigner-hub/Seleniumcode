package selenium;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportDemo extends BaseClass {
	
	
   		@Test
		 public void navigateToUrl() throws IOException {
		        driver.get("https://www.saucedemo.com");
		        driver.findElement(By.id("user-name")).sendKeys("standard_user");
		        driver.findElement(By.id("password")).sendKeys("secret_sauce");
		        driver.findElement(By.id("login-button")).click();
		        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		        driver.findElement(By.className("shopping_cart_link")).click();
                driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		        driver.findElement(By.id("checkout")).click();
   		}
		   @Test     
		 public void report() throws IOException {
		        ExtentReports extent=new ExtentReports();
				File file=new File(System.getProperty("user.dir")+"/ExtentReport/report.html");
				ExtentSparkReporter report= new ExtentSparkReporter(file);	
				report.config().setReportName("Automation Report_Sprint1");
				report.config().setDocumentTitle("Automation");
				report.config().setTheme(Theme.DARK);
				extent.attachReporter(report);
				
				ExtentTest etest1 = extent.createTest("navigateToUrl");
				etest1.pass("testcase1 passed");
				etest1.log(Status.PASS, "Testcase Passed");
				etest1.log(Status.INFO,"URL Opened");
				etest1.log(Status.INFO,"Navigated to expected page");
				
				
				ExtentTest etest2 = extent.createTest("Homepage");
				etest2.log(Status.FAIL, "Testcase Failed");
				etest2.log(Status.INFO,"URL not Opened");
				etest2.log(Status.INFO,"Does not able to navigate to expected page");
			
				
				
				extent.flush();
				
	
		}
}
		

	

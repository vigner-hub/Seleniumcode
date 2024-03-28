package selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgPractice {
static  WebDriver driver;
	
	@Test(priority=2,enabled=true)
	public void welcome() throws IOException {
		 WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	    driver.get("https://www.google.com/");
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File sourcefile=screenshot.getScreenshotAs(OutputType.FILE);
		File Destinationfile=new File("D:\\Vignesh\\workspace\\Testng\\ScreenShots\\file.png");
		FileHandler.copy(sourcefile, Destinationfile);
		System.out.println("screenshot taken");
		
		
		
		
		
		
	}
	@Test(enabled=false)
public void namasthy() {
		
		System.out.println("welcome to mumbai");  
				
		
	}
	@Test(priority=1,enabled=true)
	 @Parameters({"postalCode","Firstname","Lastname"})
public void vanakam(String postalCode ,String Firstname ,String Lastname) {
		
		System.out.println("welcome to chennai");
		System.out.println(postalCode);
		System.out.println(Firstname);
		System.out.println(Lastname);
		
	}
	
}

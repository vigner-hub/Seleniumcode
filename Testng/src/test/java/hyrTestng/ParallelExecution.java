package hyrTestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecution {
	static WebDriver driver;
@Test
	public void browserSetup() {
		    WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			System.out.println("Driver initialized.");
		}
	
	
}

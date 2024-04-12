package hyrTestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DatadrivenTechnique {

	
	@Test(dataProvider="excelData",priority = 1,enabled = true,dataProviderClass = DataDriven.class)
	public void datadriven(String username,String password) throws InterruptedException {

	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\vigu2\\Supporting downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
     WebDriver driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
     Thread.sleep(5000);
     driver.findElement(By.name("username")).sendKeys(username);
     driver.findElement(By.name("password")).sendKeys(password);
     Thread.sleep(5000);
     driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
 
    	}
	



}

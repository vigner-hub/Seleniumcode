package hyrTestng;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngBasicPractice {
	
	
	/*
	 * 1. Is it mandatory to return Object[][] from the dataprovider? 
	 * 2. What are the return types of a dataprovider?
	 *  3. How do we specify the parameters in the method signature of a test method?
	 *  
	 *  
	 *  
	 *  Object[](single dimentional array)
	 *  Object[][](twi diemtional array)
	 *  iterator<object>
	 *  iterrator<object[]>
	 */



@Test(dataProvider = "provider"   ,    priority = 1,enabled = true,timeOut =20000)
	public void datadriven(String username,String password)throws InterruptedException {

	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\vigu2\\Supporting downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
     WebDriver driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
     Thread.sleep(5000);
     driver.findElement(By.name("username")).sendKeys(username);
     driver.findElement(By.name("password")).sendKeys(password);
     Thread.sleep(5000);
     driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
     driver.quit();
 
    	}

@DataProvider(name="provider", indices = {},parallel = true)
public Object[][]  provider() {
	
	Object[][] data = new Object[][] {
		{"Admin","admin123"},
		{"admin","password"},
	};
	
	
	/*
	 * data[0][0] ="Admin"; data[0][1]="admin123";
	 * 
	 * 
	 * data[1][0] ="Admin"; data[1][1]="admin123";
	 */
	
	return data;
	
	
}


	}


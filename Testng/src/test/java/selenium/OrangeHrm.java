package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class OrangeHrm  extends BaseClass{

	@Test
	@Parameters({"username","password"})
	public void hrmLogin(String username ,String password) throws Exception {
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys(username);
	
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-userdropdown-name']")));
		String userid=element.getText();
		System.out.println(userid);
		
	}

	@Test
	public void getAdmin() {

		driver.findElement(By.className("oxd-input")).sendKeys("Admin");
		driver.findElement(By.xpath("//span[text()='Admin']")).click();  
	}


	@Test	
	public void addUser() {

		driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--secondary")).click();
		Select select = new Select(driver.findElement(By.className("oxd-select-text-input")));
		select.selectByVisibleText("ESS");
		



	}
	public void verifyUser() {





	}
}

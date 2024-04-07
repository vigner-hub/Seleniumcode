package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {
	static WebDriver driver;
	static WebDriverWait wait;
	static WebElement button; 

	@Test
	public void explicit() {


		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		driver.findElement(By.xpath("//button[@id='alert']")).click();
		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();



	}
	@Test

	public void explicitWait1() {

        driver.findElement(By.xpath("//*[@id=\"display-other-button\"]")).click();
		WebElement  button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hidden\"]")));
		String text=button.getText();
		System.out.println(text);
		driver.quit();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(button);




	}

	public void frames() {
		WebElement fame=driver.findElement(By.id("frame1"));
		driver.switchTo().frame(fame);
		//do operation and switch to default to perform operation on another frame
		driver.switchTo().defaultContent();
		
		
	





	}


}


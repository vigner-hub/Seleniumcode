package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GitHub  extends BaseClass{

	public void sample() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		driver.switchTo().frame(1);
		driver.switchTo().frame("id");
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().sendKeys("heffjkfjk");
		List<WebElement> gaja =driver.findElements(By.className("bdjjdf"));
		String name=driver.getCurrentUrl(); 
		System.out.println(name);
		String name1=driver.getTitle();
		System.out.println(name);
		Select vig= new Select(driver.findElement(By.id("aarav")));
		vig.selectByIndex(1);
		driver.findElement(By.xpath("hjebjdb")).sendKeys("j dfj jf");
		boolean ret=driver.findElement(By.className("nskcn")).isEnabled();
		System.out.println(ret);
		
		
	}


	}


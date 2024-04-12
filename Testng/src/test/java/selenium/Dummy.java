package selenium;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy {
	static WebDriver driver;


	@Test
	public  void launch() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/droppable/");
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement destination=driver.findElement(By.id("droppable"));
		Actions act=new Actions(driver);
		/*
		 * //Building a drag and drop action Action dragAndDrop =
		 * act.clickAndHold(source) .moveToElement(destination)
		 * .release(destination) .build();
		 * 
		 * //Performing the drag and drop action dragAndDrop.perform();
		 */
		
		   act.dragAndDrop(source, destination).build().perform();
		 
		
	}}
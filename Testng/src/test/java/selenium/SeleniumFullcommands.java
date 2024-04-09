package selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFullcommands {
	static WebDriver driver;

	public void browserHandling() {

		// launching browsers Using WebDriver manager
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		WebDriverManager.edgedriver().setup();
		WebDriver driver1 = new EdgeDriver();

		WebDriverManager.chromedriver().setup();
		WebDriver driver2 = new ChromeDriver();

		// launching browsers using system.setproperty
		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		WebDriver chromedriver = new ChromeDriver();

		System.setProperty("webdriver.gecko.driver", "/path/to/firefoxdriver");
		WebDriver firefoxdriver = new FirefoxDriver();

		System.setProperty("webdriver.edge.driver", "/path/to/edgedriver");
		WebDriver edgedriver = new EdgeDriver();

		// window maximize
		driver.manage().window().maximize();

		// window fullscreen
		driver.manage().window().fullscreen();

		// window minimize
		driver.manage().window().minimize();

		// delete all cookies
		driver.manage().deleteAllCookies();

		// close - closes the current browser window
		driver.close();

		// quit - closes all opened browser windows
		driver.quit();

		driver.getTitle();

		driver.get("https://the-internet.herokuapp.com");
	}
	public void webelementsHandling() {
		// Findelement
		driver.findElement(By.id("id value"));
		driver.findElement(By.className("classvalue"));
		driver.findElement(By.cssSelector("css value"));
		WebElement xpath = driver.findElement(By.xpath("xpathvalue"));
		xpath.click();
		xpath.clear();
		xpath.getTagName();
		xpath.getText();
		xpath.getCssValue("colour");
		xpath.getSize();
		xpath.sendKeys("null");

		// Find Elements
		driver.findElements(By.className("classvalue"));
		List<WebElement> element = driver.findElements(By.xpath("Value"));
		System.out.println(element);
		/*
		 * 
		 * pending
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

	}
	public void textboxHandling() {
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		WebElement textbox = driver.findElement(By.className("bcTextBox"));
		textbox.isDisplayed();
		textbox.isEnabled();
		textbox.clear();
		textbox.sendKeys("aarav");
		textbox.getText();
		textbox.getSize();
		textbox.clear();
		/*
		
		
		
		 */
	}
	public void checkboxHandling() {

		driver.get("https://the-internet.herokuapp.com/checkboxes");
		WebElement checkBoxElement1 = driver
				.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		boolean isDisplayed = checkBoxElement1.isDisplayed();

		if (isDisplayed == true) {
			System.out.println("checkbox1 is displayed, hence clicking");
			checkBoxElement1.click();
		}

		WebElement checkBoxElement2 = driver
				.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		boolean isDisplayed1 = checkBoxElement2.isDisplayed();
		boolean isEnabled = checkBoxElement2.isEnabled();
		boolean isSelected = checkBoxElement2.isSelected();

		if (isDisplayed1 == true) {

			System.out.println("checkbox2 is displayed");
			if (isEnabled == true) {

				System.out.println("checkbox2 is enabled");
				if (isSelected == false) {
					System.out.println(
							"checkbox2 is already selected hence so i didnot perform any ");
				} else {
					System.out.println(
							"checkbox2 is selected so i'm cliking here");
					checkBoxElement2.click();
					checkBoxElement2.click();
				}
			}

		} else
			System.out.println("element not displayed");
	}

	public void buttonsHandling() {

		WebElement btn = driver.findElement(By.id("myBtn"));
		if (btn.isDisplayed()) {

			if (btn.isEnabled()) {

				btn.click();
			}
		}
	}
	public void linksHandling() {

		driver.get("https://omayo.blogspot.com/");
		// handling single link
		WebElement link = driver
				.findElement(By.xpath("//a[text()='compendiumdev']"));
		link.click();
		String text = link.getText();
		System.out.println(text);
		String url = link.getAttribute("href");
		System.out.println(url);

		// handling multiple links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size()); // count of links
		for (WebElement link1 : links) {
			String linksurl = link1.getAttribute("href");
			System.out.println("Link Text: " + link1.getText());// text of links
			System.out.println("Link url: " + linksurl); // urls of links
			// broken links
			if (linksurl != null && !linksurl.isEmpty()) {
				try {
					HttpURLConnection connection = (HttpURLConnection) new URL(
							linksurl).openConnection();
					connection.setRequestMethod("HEAD");
					connection.connect();
					int responseCode = connection.getResponseCode();
					if (responseCode >= 400) {
						System.out.println("Broken Link: " + url
								+ " - Response Code: " + responseCode);
					}
					connection.disconnect();
				} catch (Exception e) {
					System.out.println("Error occurred while checking link: "
							+ url + " - " + e.getMessage());
				}
			}
		}
	}

	public void dropdownsHandling() {

		// single dropdown
		driver.get("https://omayo.blogspot.com/");
		WebElement dropdown = driver.findElement(By.id("drop1"));
		Select select = new Select(dropdown);
		select.selectByIndex(3);
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText());

		}

		// Multidropdown

		driver.get("https://omayo.blogspot.com/");
		WebElement multidropdown = driver.findElement(By.id("multiselect1"));
		Select multiselect = new Select(multidropdown);

		multiselect.selectByIndex(0);
		multiselect.selectByIndex(1);
		multiselect.selectByIndex(2);
		List<WebElement> selected = multiselect.getAllSelectedOptions();
		for (WebElement ele : selected) {

			System.out.println("Intital values" + "" + ele.getText());
		}

		multiselect.deselectByIndex(1);
		List<WebElement> selected1 = multiselect.getAllSelectedOptions();
		for (WebElement ele1 : selected1) {

			System.out.println("deselected value" + "" + ele1.getText());
		}
		multiselect.deselectAll();

	}

	public void navigationHandling() {
		driver.get("https://omayo.blogspot.com/");
		driver.findElement(By.id("link1")).click();
		driver.navigate().back();
		String omayo = driver.getCurrentUrl();
		System.out.println(omayo);
		driver.navigate().forward();
		String selenium143 = driver.getCurrentUrl();
		System.out.println(selenium143);
		driver.navigate().to("https://www.google.com/");
		driver.navigate().refresh();
	}
	public void inputsHandling() throws InterruptedException {
		// Preloaded text
		driver.get("https://omayo.blogspot.com/");
		WebElement textbox = driver.findElement(By.id("textbox1"));
		textbox.clear();
		textbox.sendKeys("gajuluma");
		textbox.clear();
		textbox.sendKeys("Aaravma");
		// Disabled Text Box
		WebElement textbox1 = driver.findElement(By.id("tb2"));
		boolean visible = textbox1.isDisplayed();
		System.out.println(visible);
		boolean enabled = textbox1.isEnabled();
		System.out.println(enabled);
		// pre text area
		WebElement textarea = driver.findElement(By.xpath(
				"//textarea[contains(text(),'The cat was playing in the garden.')]"));
		System.out.println(textarea.getText());
		textarea.clear();
		textarea.sendKeys("gaja va kanoum");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"HTML31\"]/div[1]/form/input[1]"))
				.sendKeys("Vignesh");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"HTML31\"]/div[1]/form/input[2]"))
				.sendKeys("vigu4252");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"HTML31\"]/div[1]/form/button"))
				.click(); // this method works only on that particular element
		driver.findElement(By.xpath("//*[@id=\"HTML31\"]/div[1]/form/input[1]"))
				.submit();// this method works on entire DOM , to submit form to
							// server

	}
	public void alertsHandling() {
		driver.get("https://demoqa.com/alerts");

		// Normal alert
		driver.findElement(By.id("alertButton")).click();
		driver.switchTo().alert().accept();
		// timer alert
		driver.findElement(By.id("timerAlertButton")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		// alert for confirmation
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		String message = driver.findElement(By.id("confirmResult")).getText();
		System.out.println(message);
		// prompt alert
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys("vignesh");
		driver.switchTo().alert().accept();
		String result = driver.findElement(By.id("promptResult")).getText();
		System.out.println(result.substring(11, 19));

	}

	public void waitsHandling() {
		// implicit wait

		// implicit wait - sets timer globally for all the webelements

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://cosmocode.io/automation-practice-handling-waits/");
		driver.findElement(By.name("displayInput")).click();

		// Explicit wait

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("firstName")))
				.sendKeys("Vignesh");

		// WebElement color = driver.findElement(By.id("changeColor"));
		// System.out.println(color.getCssValue("color"));
		// color.click();
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("changeColor"))).click();

		WebElement element = driver.findElement(By.id("changeColor"));
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

		WebElement text = driver.findElement(By.id("changeText"));
		System.out.println(text.getText());
		text.click();
		driver.findElement(By.xpath("//*[@id=\"post-2361\"]/div/div/p[5]/a"))
				.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")))
				.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

	}
	public void exceptionHandling() {

	}

	public void tabsHandling() {
	}
	public void windowsHandling() {
	}
	public void framesHandling() {
	}
	public void javascriptsHandling() {
	}

	public void readAndWriteHandling() {
	}
	public void screenshotHandling() {
	}

	public void draganddropHandling() {
	}
	public void mouseActionHandling() {
	}
	public void keyboardHandling() {
	}
	public void webtableHandling() {
	}
	public void excelFileHandling() {
	}
	public void fileUploadHandling() {
	}
	public void fileDownloadHandling() {
	}

}

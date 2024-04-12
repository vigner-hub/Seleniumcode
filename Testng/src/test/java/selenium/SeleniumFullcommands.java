package selenium;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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
		/*
		 * All Conditions that Can be Used in Explicit Wait:
		 * 
		 * 1.elementToBeClickable(By locator): Waits for the element specified
		 * by the locator to be clickable. 2.elementSelectionStateToBe(By
		 * locator, boolean selected): Waits for the element specified by the
		 * locator to have the specified selection state (selected or not
		 * selected). 3.presenceOfElementLocated(By locator): Waits for the
		 * presence of the element specified by the locator.
		 * 4.visibilityOfElementLocated(By locator): Waits for the element
		 * specified by the locator to be visible.
		 * 5.textToBePresentInElementLocated(By locator, String text): Waits for
		 * the element specified by the locator to contain the given text.
		 * 6.textToBePresentInElementValue(By locator, String text): Waits for
		 * the element specified by the locator to have the given text in its
		 * value attribute. 7.titleContains(String title): Waits for the page
		 * title to contain the given text. 8.titles (String title): Waits for
		 * the page title to be the given title.
		 * 9.frameToBeAvailableAndSwitchToIt(By locator): Waits for the frame
		 * specified by the locator to be available and switches to it.
		 * 10.invisibilityOfElementLocated(By locator): Waits for the element
		 * specified by the locator to be invisible. 11.elementToBeSelected(By
		 * locator): Waits for the element specified by the locator to be
		 * selected. 12.numberOfWindowsToBe(int number): Waits for the number of
		 * windows to be the specified number. 13.attributeContains(By locator,
		 * String attribute, String value): Waits for the element specified by
		 * the locator to have the attribute containing the specified value.
		 * 14.stalenessOf(WebElement element): Waits for the element to become
		 * stale (no longer attached to the DOM).
		 * 15.elementToBeSelected(WebElement element): Waits for the element to
		 * be selected. 16.elementToBeClickable(WebElement element): Waits for
		 * the element to be clickable. 17.visibilityOf(WebElement element):
		 * Waits for the element to be visible.
		 * 
		 * 
		 */

		// fluentwait

		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(10));
		fluent.pollingEvery(Duration.ofSeconds(2));
		fluent.ignoring(NoSuchElementException.class);

	}
	public void exceptionHandling() {

		driver.get("https://the-internet.herokuapp.com/status_codes");
		WebElement element = driver.findElement(By.xpath("//a[text()='200']"));

		// try-catch
		try {
			element.click();
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			System.out.println("element not found");
			e.printStackTrace();
		}

		// multiple catch

		driver.get("https://omayo.blogspot.com/");
		WebElement btn = driver.findElement(By.id("myBtn"));
		if (btn.isEnabled()) {
			System.out.println("My button is enabled");
			driver.findElement(By.xpath("//button[text()='Try it']")).click();

			try {
				Thread.sleep(5000);
				boolean value = btn.isEnabled();

				if (value == true) {
					System.out.println("Element is enabled");
				} else {
					System.out.println("Element is disabled");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// throw- approach1

		try {
			element.click();
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			System.out.println("element not found");
			e.printStackTrace();
			throw (e);
		}

		// throw approach2 - throw new
		try {
			Thread.sleep(2000);
			boolean value = btn.isEnabled();

			if (!value) {
				throw new Exception("Element is disabled");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		// finally

		try {
			Thread.sleep(2000);
			boolean value = btn.isEnabled();

			if (!value) {
				throw new Exception("Element is disabled");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			System.out.println("end of code");
		}

		// Nested try-catch

		try {

			try {

				try {

				}

				catch (Exception e1) {

				}

			} catch (Exception e2) {

			}

		} catch (Exception e3) {

		}

	}

	/*
	 * 
	 * Types of Exceptions in Selenium Webdriver
	 *****************************************
	 * 1. ElementNotVisibleException: This type of Selenium exception occurs
	 * when an existing element in DOM has a feature set as hidden.
	 * 
	 * 2. ElementNotSelectableException: This Selenium exception occurs when an
	 * element is presented in the DOM, but you can be able to select.
	 * Therefore, it is not possible to interact.
	 * 
	 * 3. NoSuchElementException: This Exception occurs if an element could not
	 * be found.
	 * 
	 * 4. NoSuchFrameException: This Exception occurs if the frame target to be
	 * switched to does not exist.
	 * 
	 * 5. NoAlertPresentException: This Exception occurs when you switch to no
	 * presented alert.
	 * 
	 * 6. NoSuchWindowException: This Exception occurs if the window target to
	 * be switch does not exist.
	 * 
	 * 7. StaleElementReferenceException: This Selenium exception occurs happens
	 * when the web element is detached from the current DOM.
	 * 
	 * 8. SessionNotFoundException: The WebDriver is acting after you quit the
	 * browser.
	 * 
	 * 9. TimeoutException: Thrown when there is not enough time for a command
	 * to be completed. For Example, the element searched wasn’t found in the
	 * specified time.
	 * 
	 * 10. WebDriverException: This Exception takes place when the WebDriver is
	 * acting right after you close the browser.
	 * 
	 * 11. ConnectionClosedException: This type of Exception takes place when
	 * there is a disconnection in the driver.
	 * 
	 * 12. ElementClickInterceptedException: The command may not be completed as
	 * the element receiving the events is concealing the element which was
	 * requested clicked.
	 * 
	 * 13. ElementNotInteractableException: This Selenium exception is thrown
	 * when any element is presented in the DOM. However, it is impossible to
	 * interact with such an element.
	 * 
	 * 14. ErrorInResponseException: This happens while interacting with the
	 * Firefox extension or the remote driver server.
	 * 
	 * 15. ErrorHandler.UnknownServerException: Exception is used as a
	 * placeholder in case if the server returns an error without a stack trace.
	 * 
	 * 16. ImeActivationFailedException: This expectation will occur when IME
	 * engine activation has failed.
	 * 
	 * 17. ImeNotAvailableException: It takes place when IME support is
	 * unavailable.
	 * 
	 * 18. InsecureCertificateException: Navigation made the user agent to hit a
	 * certificate warning. This can cause by an invalid or expired TLS
	 * certificate.
	 * 
	 * 19. InvalidArgumentException: It occurs when an argument does not belong
	 * to the expected type.
	 * 
	 * 20. InvalidCookieDomainException: This happens when you try to add a
	 * cookie under a different domain instead of current URL.
	 * 
	 * 21. InvalidCoordinatesException: This type of Exception matches an
	 * interacting operation that is not valid.
	 * 
	 * 22. InvalidElementStateException: It occurs when command can’t be
	 * finished when the element is invalid.
	 * 
	 * 23. InvalidSessionIdException: This Exception took place when the given
	 * session ID is not included in the list of active sessions. It means the
	 * session does not exist or is inactive either.
	 * 
	 * 24. InvalidSwitchToTargetException: This occurs when the frame or window
	 * target to be switched does not exist.
	 * 
	 * 25. JavascriptException: This issue occurs while executing JavaScript
	 * given by the user.
	 * 
	 * 26. JsonException: It occurs when you afford to get the session when the
	 * session is not created.
	 * 
	 * 27. NoSuchAttributeException: This kind of Exception occurs when the
	 * attribute of an element could not be found.
	 * 
	 * 28. MoveTargetOutOfBoundsException: It takes place if the target provided
	 * to the ActionChains move() methodology is not valid. For Example, out of
	 * the document.
	 * 
	 * 29. NoSuchContextException: ContextAware does mobile device testing.
	 * 
	 * 30. NoSuchCookieException: This Exception occurs when no cookie matching
	 * with the given pathname found for all the associated cookies of the
	 * currently browsing document.
	 * 
	 * 31. NotFoundException: This Exception is a subclass of
	 * WebDriverException. This will occur when an element on the DOM does not
	 * exist.
	 * 
	 * 32. RemoteDriverServerException: This Selenium exception is thrown when
	 * the server is not responding because of the problem that the capabilities
	 * described are not proper.
	 * 
	 * 33. ScreenshotException: It is not possible to capture a screen.
	 * 
	 * 34. SessionNotCreatedException: It happens when a new session could not
	 * be successfully created.
	 * 
	 * 35. UnableToSetCookieException: This occurs if a driver is unable to set
	 * a cookie.
	 * 
	 * 36. UnexpectedTagNameException: Happens if a support class did not get a
	 * web element as expected.
	 * 
	 * 37. UnhandledAlertException: This expectation occurs when there is an
	 * alert, but WebDriver is not able to perform Alert operation.
	 * 
	 * 38. UnexpectedAlertPresentException: It occurs when there is the
	 * appearance of an unexpected alert.
	 * 
	 * 39. UnknownMethodException: This Exception happens when the requested
	 * command matches with a known URL but and not matching with a methodology
	 * for a specific URL.
	 * 
	 * 40. UnreachableBrowserException: This Exception occurs only when the
	 * browser is not able to be opened or crashed because of some reason.
	 * 
	 * 41. UnsupportedCommandException: This occurs when remote WebDriver
	 * doesn’t send valid commands as expected.
	 * 
	 */




	public void windowsHandling() throws InterruptedException {
		
		
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.findElement(By.id("newWindowBtn")).click();
		System.out.println(driver.getCurrentUrl());
        String parent=driver.getWindowHandle();
        System.out.println("parent window id "+parent);
		
		  Set<String> windowhandle1= driver.getWindowHandles();
		  System.out.println("All opened window ids "+ windowhandle1);
		 /*
		 It is used to get the handle of a multiple window, it returns the Set of Strings- Set<String>
I
Take note that the 'Set' structure does not permit duplicates and does not support the index method. So, to obtain the desired window handle from the set, it is necessary to use a looping statement or we can convert this to list.
		  * 
		  */
		
		  List<String> list1 = new ArrayList<String>(windowhandle1);
		  driver.switchTo().window(list1.get(1));
		  driver.manage().window().maximize(); String
		  url=driver.getCurrentUrl(); System.out.println("Child window URL"
		  +url); driver.findElement(By.id("firstName")).sendKeys("gaja");
		  driver.findElement(By.id("lastName")).sendKeys("Aarav");
		  Thread.sleep(5000); driver.switchTo().window(list1.get(0));
		  driver.close(); Set<String> windowhandle2= driver.getWindowHandles();
		  
		  list1.clear(); list1.addAll(windowhandle2);
		  driver.switchTo().window(list1.get(0));
		  System.out.println(driver.getCurrentUrl());
		 
		
		// using for each loop
        
        Set<String> windowhandles= driver.getWindowHandles();
       for (String windowhand : windowhandles) {
    	   driver.switchTo().window(windowhand);
    	   driver.findElement(By.id("email")).sendKeys("gaja");
         
           Thread.sleep(5000);
           driver.switchTo().window(parent);
           
           
           
           
           
			
			/*
			 * public void switchToThirdChildWindow() throws
			 * InterruptedException { driver.get(
			 * "https://www.hyrtutorials.com/p/window-handles-practice.html");
			 * driver.findElement(By.id("newWindowBtn")).click();
			 * System.out.println("Parent window URL: " +
			 * driver.getCurrentUrl()); parentWindowHandle =
			 * driver.getWindowHandle();
			 * 
			 * // Switching to third child window switchToChildWindowByIndex(2);
			 * 
			 * // Perform actions in the third child window
			 * driver.findElement(By.id("firstName")).sendKeys("gaja");
			 * driver.findElement(By.id("lastName")).sendKeys("Aarav");
			 * Thread.sleep(5000);
			 * driver.findElement(By.id("email")).sendKeys("gaja@example.com");
			 * // Enter email in child window Thread.sleep(5000);
			 * driver.close(); // Close child window
			 * 
			 * // Switch back to parent window
			 * driver.switchTo().window(parentWindowHandle);
			 * System.out.println("Parent window URL after handling child: " +
			 * driver.getCurrentUrl()); }
			 * 
			 * // Method to switch to child window by index public void
			 * switchToChildWindowByIndex(int index) { Set<String> windowHandles
			 * = driver.getWindowHandles(); int count = 0; for (String
			 * windowHandle : windowHandles) { if
			 * (!windowHandle.equals(parentWindowHandle)) { count++; if (count
			 * == index) { driver.switchTo().window(windowHandle);
			 * System.out.println("Switched to child window with URL: " +
			 * driver.getCurrentUrl()); break; } } } }
			 */
		
	}

		
	
	}
	public void framesHandling() {
		
		
		
		
	}
	public void javascriptsHandling() {
	}

	public void screenshotHandling(String methodname) throws IOException {
		
		// hardcoded type no need of parameter to the method
		driver.get("https://www.google.com/");
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination =new File( "C:\\Users\\vigu2\\git\\SeleniumTestNG\\Testng\\ScreenShots\\error.jpg");
		FileUtils.copyFile(source,destination);
		
		// reusable code //here we give parameter
		  driver.get("https://www.google.com/"); File
		  source1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE
		  ); File destination1 =new File(System.getProperty("user.dir")+
		  "Testng\\ScreenShots\\" + methodname + ".jpg");
		  FileUtils.copyFile(source1,destination1);

		
	}

	public void draganddropHandling() {
		
		driver.get("https://demoqa.com/droppable/");
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement destination=driver.findElement(By.id("droppable"));
		Actions act=new Actions(driver);
		/*  
		 * //Building a drag and drop action 
		 * Action dragAndDrop =act.clickAndHold(source)
		 * .moveToElement(destination)
		 * .release(destination) 
		 * .build();
		 * //Performing the drag and drop action 
		 * dragAndDrop.perform();
		 */
		
		   act.dragAndDrop(source, destination).build().perform();
	}
	public void mouseActionHandling() {
		//https://demo.guru99.com/
		//https://www.guru99.com/keyboard-mouse-events-files-webdriver.html
		//https://demo.guru99.com/test/newtours/support.php
		//Tooltip in Selenium
		driver.get("https://demoqa.com/menu/");
		driver.findElement(By.xpath("//a[text()='Main Item 2']"));
	}
	public void keyboardHandling() {
	}
	public void webtableHandling() {
		//https://www.guru99.com/handling-dynamic-selenium-webdriver.html
	}
	public void excelFileHandling() {
		
	}
	public void fileUploadHandling() {
		//https://www.guru99.com/upload-download-file-selenium-webdriver.html
	}
	public void fileDownloadHandling() {
		//https://www.guru99.com/upload-download-file-selenium-webdriver.html
		}
}
			


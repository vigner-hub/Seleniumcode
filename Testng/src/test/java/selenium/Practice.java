package selenium;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice extends BaseClass {

	

	@Test(priority = 1)
	public void navigateToUrl() {
		
		test = extent.createTest("navigateToUrl");
		test.info("open browser");
		driver.get("https://www.saucedemo.com");
		test.info("navitated to saus demo");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		test.info("Entered vaild  user name and password");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		test.pass("Test case Passed");

	}

	@Test(priority = 2)
	public void addToCart() {

		test = extent.createTest("addToCart");

		test.info("added products to cart");
		driver.findElement(By.id("add-to-cart-sauce-labs-backpk")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"))
				.click();
		driver.findElement(By.className("shopping_cart_link")).click();
		test.fail("testcase failed");

	}

	@Test(priority = 3)
	public void removeItems() {
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		driver.findElement(By.id("checkout")).click();
	}

	@Test(priority = 4)
	@Parameters({"postalCode", "Firstname", "Lastname"})
	public void shippingInformation(String postalCode, String Firstname,
			String Lastname) {
		driver.findElement(By.id("first-name")).sendKeys(Firstname);
		driver.findElement(By.id("last-name")).sendKeys(Lastname);
		driver.findElement(By.id("postal-code")).sendKeys(postalCode);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		String greetings = driver
				.findElement(
						By.xpath("//*[@id=\"checkout_complete_container\"]/h2"))
				.getText();
		System.out.println(greetings);
	}

}

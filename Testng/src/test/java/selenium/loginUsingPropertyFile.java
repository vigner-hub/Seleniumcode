package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginUsingPropertyFile implements ITestListener{

     static WebDriver driver;
     static String URL; 
     static  String username;
     static  String password;

    @Test
    public static void login() throws IOException {
        Properties property = new Properties();
        String projectpath = System.getProperty("user.dir");

        FileInputStream input = new FileInputStream(projectpath + "/src/test/java/propertyfiles/config.properties");

        property.load(input);

        String browser = property.getProperty("browser");
        URL = property.getProperty("URL"); 
        username = property.getProperty("uenv1");
        password = property.getProperty("penv1");

        if (browser.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\vigu2\\Supporting downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    @Test
    public void openswas() {
        driver.get(URL);
        
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        
    }
}


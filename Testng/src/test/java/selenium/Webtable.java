package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Webtable {
	
	@Test
	public void dynamicTable() {
		
		/*
		 * driver.get("https://practice.expandtesting.com/dropdown");
		 * driver.manage().window().maximize();
		 * 
		 * WebElement drop=
		 * driver.findElement(By.xpath("//select[@id='dropdown']")); Select
		 * obj=new Select(drop); //obj.deselectAll();
		 * obj.selectByVisibleText("Option 2");
		 * obj.selectByVisibleText("Option 1");
		 * 
		 * 
		 * WebElement drop1=
		 * driver.findElement(By.xpath("//select[@class='form-control']"));
		 * //obj.deselectAll(); Select dob=new Select(drop1); List<WebElement>
		 * totalList = dob.getOptions(); for(WebElement option :totalList) {
		 * System.out.println(option.getText());
		 * 
		 * 
		 * }
		 * 
		 * dob.selectByVisibleText("100"); dob.selectByVisibleText("50");
		 */
		
		String s="vigneshgaja";
		int l=s.length();
		System.out.println(l);
		System.out.println("welcome".length());
		
		
		String a="vig";
		String b="nesh";
		String c="gaja";
		System.out.println(a+b);
		String gaja=a.concat(b).concat(c);
		System.out.println(gaja);
		
		
;			
		
		
		
	}

}

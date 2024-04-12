package hyrTestng;

import org.testng.annotations.DataProvider;

public class Datasupply {
	
	
	@DataProvider(name="provider", indices = {0,2})
	public Object[][]  provider() {
		
		Object[][] data = new Object[][] {
			{"Admin","admin123"},
			{"admin","password"},
			{"admin","password"},
			{"admin","password"}
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

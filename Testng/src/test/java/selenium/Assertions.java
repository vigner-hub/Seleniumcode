package selenium;

import org.testng.Assert;

public class Assertions {
	
	
	public void hardAssert() {
		
		
		Assert.assertEquals(0, 0);
		
		Assert.assertTrue(false);
		
		Assert.assertFalse(false);
		
		Assert.assertNotNull(getClass(), null);
		
		Assert.assertNull(getClass());
		
		Assert.fail();
		
		
	}
	
	
	public void softAssert() {
		
		
		
	}

}

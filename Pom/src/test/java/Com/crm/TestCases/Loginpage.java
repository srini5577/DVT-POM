package Com.crm.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Loginpage {
	
	WebDriver driver;
	
	@Test
	public void LoginPage() {
		driver.findElement(By.id("abc")).sendKeys("UID");
		driver.findElement(By.xpath("")).sendKeys("");
		driver.findElement(By.xpath("")).click();
		
	}
	

}

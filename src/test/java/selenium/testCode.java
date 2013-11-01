package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testCode {
	WebDriver driver = new FirefoxDriver();

	@Before
	public void setUp() throws Exception {
		driver.get("http://www.google.com");
	}

	@Test
	public void testAdvancedSearch() throws Exception {
		driver.findElement(By.name("q")).sendKeys("Selenium 2.0 WebDriver");
		driver.findElement(By.name("q")).submit();
		System.out.println("Page title is: " + driver.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}

package selenium;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;
import pages.HomePage;
import pages.LoginPage;

public class AuthTestCase {

	private final WebDriver driver = new FirefoxDriver();
	
	@Ignore
	public void testLoginPageMsg() throws Exception {
		LoginPage lPage = new LoginPage(driver);
		assertTrue(lPage.getTitle().contains("A Google approach to email"));
	}
	
	@Test
	public void testHomePage() throws Exception {
		HomePage hPage = new LoginPage(driver).loginWith("dgoncharenko@selectica.com","24t92m19");
		assertEquals("inbox", hPage.getMsg());
		assertEquals("title", hPage.getTitle());
	}
}

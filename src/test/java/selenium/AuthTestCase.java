package selenium;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junitx.framework.StringAssert;
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
	
	/*
	 * Тестирование логирования с неверным логином и паролем
	 */
	@Test
	public void testLogginWithWrongCredentials() throws Exception {
		HomePage hPage = new LoginPage(driver).loginWith("dmitriy@mail.com","wrongpasswd");	
		
		assertEquals("Sign in · GitHub", hPage.getTitle());			
	    StringAssert.assertContains("Incorrect username or password.", hPage.getPageText());
	}
	
	/*
	 * Тестирование логирования с корректным логином и паролем
	 */
	@Test
	public void testLoginWithValidCredentials() throws Exception {
        HomePage hPage = new LoginPage(driver).loginWith("dmitrii-goncharenko@mail.ru","dima24051992");	
		
		assertEquals("Sign in · GitHub", hPage.getTitle());			
	    StringAssert.assertContains("Incorrect username or password.", hPage.getPageText());
	}
	
}

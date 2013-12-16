package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.*;

import junitx.framework.StringAssert;
import static org.junit.Assert.*;
import pages.NewRepositoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RepositoryHomePage;

public class GithubTests {

	private final WebDriver driver = new FirefoxDriver();

	
       
	public GithubTests() {
		//http://www.seleniumhq.org/docs/04_webdriver_advanced.jsp
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	@Ignore
	public void testLoginPageMsg() throws Exception {
		LoginPage lPage = new LoginPage(driver);
		assertTrue(lPage.getTitle().contains("A Google approach to email"));
	}
	
	/*
	 * ������������ ����������� � �������� ������� � �������
	 */
	@Ignore
	public void testLogginWithWrongCredentials() throws Exception {
		HomePage hPage = new LoginPage(driver).loginWith("dmitriy@mail.com","wrongpasswd");	
		
		assertEquals("Sign in � GitHub", hPage.getTitle());			
	    StringAssert.assertContains("Incorrect username or password.", hPage.getPageText());
		
	}
	
	/*
	 * ������������ ����������� � ���������� ������� � �������
	 */
	@Ignore
	public void testLoginWithValidCredentials() throws Exception {
        HomePage hPage = new LoginPage(driver).loginWith("dmitriy@mail.com","rightpassw");	
		
		assertEquals("GitHub", hPage.getTitle());	
		assertTrue(hPage.containsSignOut());
	   
	}
	
	/*
	 * ������������ �������� ������ �����������
	 */
	@Test
	public void testCreateNewRepository() {
		HomePage hPage = new LoginPage(driver).loginWith("dmitriy@mail.com","rightpassw");	
		NewRepositoryPage repPage = hPage.newRepository();
		RepositoryHomePage repHome = repPage.addRepository("MyRepository");
		assertTrue(repHome.containsRepositoryName("MyRepository"));
	}
}

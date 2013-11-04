package pages;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private final WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	   super();
	   this.driver = driver;	  
       driver.get("http://www.google.com");
		
	} 
	
	public HomePage loginWith(String username, String password) {
	   executeLogin(username, password);
	   return new HomePage(driver);
	}
	
	private void executeLogin(String username, String password) {
		driver.findElement(By.id("gb_70")).click();
		driver.findElement(By.id("Email")).click();
	    driver.findElement(By.id("Email")).sendKeys(username);
	    driver.findElement(By.id("Passwd")).click();
		driver.findElement(By.id("Passwd")).sendKeys(password);
		driver.findElement(By.id("signIn")).submit();
		
	}
	
	public String getTitle() throws Exception {
		return driver.getTitle();
	}
}

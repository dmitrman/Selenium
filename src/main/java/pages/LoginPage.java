package pages;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private String url = "https://github.com";
	private final WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	   super();
	   this.driver = driver;	  
       driver.get(url);		
	} 
	
	public HomePage loginWith(String username, String password) {
		driver.findElement(By.cssSelector("a.button:nth-child(2)")).click();		
		driver.findElement(By.cssSelector("#login_field")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);		
		driver.findElement(By.name("commit")).click(); 		
	    return new HomePage(driver);
	}
		
	public String getTitle() throws Exception {
		return driver.getTitle();
	}
}

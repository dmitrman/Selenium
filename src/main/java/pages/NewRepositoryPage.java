package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewRepositoryPage {
	private String url = "https://github.com";
	private final WebDriver driver;
	
	public NewRepositoryPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public RepositoryHomePage addRepository(String repName) {
		driver.findElement(By.cssSelector("#repository_name")).sendKeys(repName);
		driver.findElement(By.cssSelector("#repository_description")).sendKeys("Desc");
		driver.findElement(By.cssSelector(".button")).click();
		
		return new RepositoryHomePage(driver);
	}
	
}

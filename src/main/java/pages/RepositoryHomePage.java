package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoryHomePage {
	private final WebDriver driver;

	public RepositoryHomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
    
	public boolean containsRepositoryName(String name) {
		String text = driver.findElement(By.tagName("html")).getText();
		return text.contains(name);
	}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private final WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String getMsg() throws Exception {
		return driver.findElement(By.id("h1")).getText();
	}

	public String getTitle() throws Exception {
		return driver.getTitle();
	}

	public String getPageText() {
		return (driver.findElement(By.tagName("html")).getText());
	}
}
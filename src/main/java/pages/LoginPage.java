package pages;

public class LoginPage {

	private final WebDriver;
	
	public LoginPage() {
	   super();
	   this.driver = driver;
	} 
	
	public HomePage loginWith(String username, String password) {
	   exucuteLogin(username, password);
	   return new HomePage(driver);
	}
	
	private void executeLogin(String username, String password) {
		drivaer
	}
}

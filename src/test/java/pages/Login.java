package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	private WebDriver driver;
	private By loginClick;
	private By email;
	private By pass;
	private By ok;
	
	public Login(WebDriver driver)
	{
	     this.driver = driver;
	     loginClick =By.className("login");
	     email = By.id("email");
	     pass = By.id("passwd");
	     ok = By.id("SubmitLogin");
	}
	
	public void loginCompl(String val1, String val2)
	{
		driver.findElement(loginClick).click();
		driver.findElement(email).sendKeys(val1);			
		driver.findElement(pass).sendKeys(val2);
		driver.findElement(ok).click();
	}
	

}

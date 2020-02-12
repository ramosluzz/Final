package EjercicioFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Configuracion.Config;
import WaitSleep.StaticSleep;
import pages.Index;
import pages.Item;
import pages.Login;

public class TestFinal {
	WebDriver driver;
	StaticSleep stop = new StaticSleep();
	Index index;
	Item item;
	Login log;
	
	@BeforeMethod
	public void inicio()
	{
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(Config.url);
		stop.wait(3000);
		index = new Index(driver);
		item = new Item(driver);
		log = new Login(driver);
	}

	@AfterMethod
	public void fin()
	{
		driver.close();
		driver.quit();
	}
	
	@Test(description="Ejercicio 1.1 - Exis, con PO", enabled = true)
	public void searchExis()
	{
		index.SearchAndClickById("Printed");
		Assert.assertEquals(index.TextResult(), "5 results have been found.");
		stop.wait(5000);
	}
		
	@Test(description="Ejercicio 1.2 - Inex, con PO", enabled = true)
	public void searchInex()
	{
		index.SearchAndClickById("Tennis");
		Assert.assertEquals(index.TextResult(), "0 results have been found.");
		stop.wait(5000);
	}
		
	@Test (description = "Ejercicio 2.1 > DRESSES" , enabled = true)
	public void clickDress()
	{
		index.SearchClickDressByXpath();
		stop.wait(3000);
		String result = driver.findElement(By.className("cat-name")).getText();
		Assert.assertEquals(result, "SUMMER DRESSES ",">> SECCION INCORRECTA <<");
	    stop.wait(2000);
	}
		
	@Test (description = "Ejercicio 2.2 > WOMEN", enabled = true)
	public void clickWomen()
	{
		index.SearchClickWomenByXpath();
		stop.wait(3000);
		String result = driver.findElement(By.className("cat-name")).getText();
		Assert.assertEquals(result,"TOPS ",">> SECCION INCORRECTA <<");
		stop.wait(3000);
	}
		
	@Test (description = "Ejercicio 3 > Dropdowns", enabled = true)
	public void selectTShirt()
	{
		index.SelectTShirtClick();
		index.SelectOrder("Price: Lowest first");
		stop.wait(3000);
		index.SelectOrder("Price: Highest first");
		stop.wait(3000);
		index.SelectOrder("Product Name: A to Z");
		stop.wait(3000);
		index.SelectOrder("Product Name: Z to A");
		stop.wait(3000);
		index.SelectOrder("In stock");
		stop.wait(3000);
		index.SelectOrder("Reference: Lowest first");
		stop.wait(3000);
		index.SelectOrder("Reference: Highest first");
		stop.wait(3000);
	}
	@Test (description = "Ejercicio 4-Autentificación Erronea" , enabled = true)
    public void loginIncorrecto()
	{
		log.loginCompl("luz.ramos97@hotmail.com", ".....adasdsaw{{");
		String result = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li")).getText();
		Assert.assertEquals(result,"Authentication failed.","MENSAJES DISTINTOS");
		stop.wait(3000);
	}
}

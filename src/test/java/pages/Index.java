package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Index {
	private WebDriver driver;
	private By search;
	private By submit;
	private By heading;
	private By dressesMenu;
	private By dressesCategory;
	private By womenMenu;
	private By womenCategory;
	private By selectOrder;
	private By selectProd;
	
	public Index (WebDriver driver)
	{
		this.driver = driver;
		search  =By.id ("search_query_top");
		submit = By.name("submit_search");
		heading = By.className("heading-counter");
		dressesMenu = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
		dressesCategory = By.xpath("//*[@id='categories_block_left']/div/ul/li[3]/a");
		womenMenu = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
		womenCategory = By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a");
		selectOrder = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");
		selectProd =By.id("selectProductSort");
	}

	public void SearchAndClickById(String value)
	{
		driver.findElement(search).sendKeys(value);
		driver.findElement(submit).click();
	}
	
	public String TextResult()
	{
		return driver.findElement(heading).getText();
	}
	
	public void SearchClickDressByXpath()
	{
		driver.findElement(dressesMenu).click();
		driver.findElement(dressesCategory).click();
	}
	public void SearchClickWomenByXpath()
	{
		driver.findElement(womenMenu).click();
		driver.findElement(womenCategory).click();
	}
	
	public void SelectTShirtClick()
	{
		driver.findElement(selectOrder).click();
	}
	public void SelectOrder(String value)
	{
		Select order  = new Select(driver.findElement(selectProd));
		order.selectByVisibleText(value);
	}

}

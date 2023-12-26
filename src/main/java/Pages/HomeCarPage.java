package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import BasePage.Base;

public class HomeCarPage extends Base
{

	public HomeCarPage(WebDriver driver) 
	{
		super(driver);
		
	}

		
	public void usedCar()
	{
		
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div[1]/header/div/nav/ul/li[1]/div")
	WebElement menu;
	
	@FindBy(xpath="//*[@id=\"root\"]/div[1]/header/div/nav/ul/li[1]/div[2]/div[1]/ul/a[1]/div/div ")
	WebElement findnewcars;
	public void newCar()
	{
		
		Actions action= new Actions(driver);
		action.moveToElement(menu).perform();
		findnewcars.click();
		
		
	}
	
	public void searchCar()
	{
		
		
	}
	
	
}

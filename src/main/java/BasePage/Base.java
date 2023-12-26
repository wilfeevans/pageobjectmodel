package BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base
{

	public WebDriver driver;
	
	public Base(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	
	
	
}

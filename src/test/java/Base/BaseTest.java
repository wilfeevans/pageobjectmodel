package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import Utilities.DbManager;
import Utilities.ExcelReader;
import Utilities.MonitoringMail;

public class BaseTest
{
	//Base file
	public static WebDriver driver;
	public Properties OR=new Properties();
	public Properties config=new Properties();
	public ExcelReader excel=new ExcelReader("./src/test/resources/Excel/Exceldata.xlsx");
	DbManager db;
	MonitoringMail mail= new MonitoringMail();
	FileInputStream fis;
	public WebDriverWait wait;
	public Logger log= Logger.getLogger(BaseTest.class);
	public WebElement dropdown;
	
	public void setUp(String browser) throws IOException, ClassNotFoundException, SQLException
	{
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		
		fis= new FileInputStream("./src/test/resources/properties/OR.properties");
		OR.load(fis);
		
		fis= new FileInputStream("./src/test/resources/properties/Config.properties");
		config.load(fis);
		
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		
		else if(browser.equals("firefox"))
		{
			driver= new FirefoxDriver();			
		}
		
		
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wait= new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(config.getProperty("implicity_wait"))));
		db.setMysqlDbConnection();
		log.info("Database Connection Established");
		}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("Test Execution Completed! ");
		
	}
	
	

}

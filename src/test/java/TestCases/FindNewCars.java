package TestCases;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomeCarPage;
import Utilities.ExcelUtil;

public class FindNewCars extends BaseTest
{
	@Test(dataProviderClass = ExcelUtil.class, dataProvider = "dp")
	public void newCar(String browser) throws ClassNotFoundException, IOException, SQLException
	{
		
		setUp(browser);
		HomeCarPage home= new HomeCarPage(driver);
		home.newCar();
	}

}

package searchcollege1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup 
{
	public static WebDriver setupChromeDriver() throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Excel.getUrl());
		return driver;
	}
	public static WebDriver setupEdgeDriver() throws Exception
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(Excel.getUrl());
		return driver;
	}
}

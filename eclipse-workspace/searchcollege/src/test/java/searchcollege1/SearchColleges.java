package searchcollege1;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchColleges {
		


		public static void mainFunction(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			System.out.println("Testing has been initiated");
			
			//Proceeding to the website
			driver.findElement(By.id("details-button")).click();
			driver.findElement(By.id("proceed-link")).click();
			
			//Click on "Colleges" link in the Menu bar
			driver.findElement(By.cssSelector("a[href='/Colleges-in-India.aspx']")).click();
			
			//Create a List of WebElements of all options in drop down
			Select s=new Select(driver.findElement(By.id("ddl_Category")));
			List<WebElement> list = s.getOptions();
			
			//Click on "City" dropdown and select “Chennai” as city
			Select c=new Select(driver.findElement(By.id("ddl_City")));
			c.selectByVisibleText("Chennai");
			
			//Prints all the available courses
			System.out.println("Courses available :");
			Map<Integer,String> optionMap = new HashMap<Integer,String>();
			for(int j=0;j<list.size();j++) 
			{
				
				//System.out.println("Option "+j+" is "+list.get(j).getText());
				optionMap.put(j,list.get(j).getText());
				
			}
			
			for(int i = 0 ;i<list.size();i++)
			{
				//Selecting the option in course dropdown of 'i'th index
				Select se=new Select(driver.findElement(By.id("ddl_Category")));
				se.selectByIndex(i);
				
				//Click the search button after selecting the course and city
				driver.findElement(By.id("btnSearch")).click();
				
				//Store the search results in a list
				List<WebElement> w= driver.findElements(By.xpath("//div[@class='detail-list']/ul/li"));
				
				
				if(w.size()>0)//If search results are shown then print 'successfull'
				{
					//Thread.sleep(5000);
					System.out.println("All Colleges available for course "+optionMap.get(i)+" in Chennai are displayed");
					
				}
				else// If search results are not shown then print'Search results are not displayed'
				{
					//Thread.sleep(5000);
					System.out.println("No Colleges are availabele for course "+optionMap.get(i)+" in Chennai");
				}
				
				//navigate back after search results are shown
				driver.navigate().back();
			}
			
				//Close the browser
				driver.quit();
				
			System.out.println("Testing has been successfully performed");
			
		}
		public static void main(String args[]) throws Exception
		{
			System.out.println("------------------Chrome---------------------------");
			mainFunction(DriverSetup.setupChromeDriver());
			System.out.println("------------------Edge---------------------------");
			mainFunction(DriverSetup.setupEdgeDriver());
		}

	}



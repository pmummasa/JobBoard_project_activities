package job_Board_Team;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;


public class Activity_5 {
	
	 WebDriver driver;
			 @BeforeClass 
			 public void beforeClass () {					  			
			driver = new FirefoxDriver();			 
			 driver.get("https://alchemy.hguy.co/jobs");
						      		      
		 }
		      @Test 		
		public void headingtestcase () {			  
		driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
		String heading = driver.getTitle();
		System.out.println("Page heading is: " + heading);
		
		String Expectedheading = "Jobs – Alchemy Jobs";
		Assert.assertEquals(Expectedheading,heading);
		System.out.println("The heading of web page is:" +heading);
		
		      }
      	    	        
		  @AfterClass
	    	
	        public void afterClass() {
	    	
	      	
	            driver.close();
		}

}


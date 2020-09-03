package job_Board_Team;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_2 {

	WebDriver driver;
	 @BeforeClass 
	 public void beforeClass () {					  			
	driver = new FirefoxDriver();			 
	 driver.get("https://alchemy.hguy.co/jobs");
				      		      
}
     @Test 		
public void headingtestcase () {			  
    	    String heading1 = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/header/h1")).getText();    	
	        System.out.println("Heading of page: " + heading1);;

String Expectedheading = "Welcome to Alchemy Jobs";
Assert.assertEquals(Expectedheading,heading1);
System.out.println("The heading of web page is:" +heading1);

     }
	    	        
 @AfterClass
	
   public void afterClass() {
	
 	
       driver.close();
}

}
	
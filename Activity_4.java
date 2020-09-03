package job_Board_Team;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_4 {
	
	 WebDriver driver;
	 @BeforeClass 
	 public void beforeClass () {					  			
	driver = new FirefoxDriver();			 
	 driver.get("https://alchemy.hguy.co/jobs");
				      		      
}
     @Test 		
public void headingtestcase () {			  
    	  String heading2 = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/h2")).getText();
	      System.out.println("The heading is: " + heading2);;

	      String Expectedheading = "Quia quis non";
          Assert.assertEquals(Expectedheading,heading2);
          System.out.println("The heading of web page is:" +heading2);

     }
	    	        
 @AfterClass
	
   public void afterClass() {
	
 	
       driver.close();
}

}
	
	
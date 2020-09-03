package job_Board_Team;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity_14 {
  
	WebDriver driver;	
    WebDriverWait wait;
   
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();    	
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }
    
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "root", "pa$$w0rd" }};
    
    }
    
        
    @Test (dataProvider = "Authentication",priority = 1)
	
    public void loginTestCase(String username, String password) {
	
        //Find username and password fields	
    	WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"user_pass\"]"));
        
        //Enter values    	
        usernameField.sendKeys("root");	
        passwordField.sendKeys("pa$$w0rd");
        
        //Click Log in    	
        driver.findElement(By.id("wp-submit")).click();
        
      driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[11]/a/div[3]")).click();
  	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
        
    }    
    
    @DataProvider(name = "usercreation")
    public static Object[][] usercreation() {
        return new Object[][] { { "Venkatpallu123Chinnu", "pallavireport13442@gmail.com" , "Chinnu", "Venkateddy", "Www.alchemy.com"}}; 
        
    }        
    
            @Test (dataProvider = "usercreation", priority = 2) 
        
        public void usercreation(String username, String email, String firstname, String lastname, String url) {
            	 
            	//Find username,email,firstname,lastname,url fields	            	
            	WebElement usernameField =  driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
                WebElement emailField =  driver.findElement(By.xpath("//*[@id=\"email\"]"));
                WebElement firstnameField =driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
                WebElement lastnameField = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
                WebElement urlField =  driver.findElement(By.xpath("//*[@id=\"url\"]"));
    
                //Enter values    	
                usernameField.sendKeys("Venkatpallu123Chinnu");	
                emailField.sendKeys("pallavireport13442@gmail.com");
                firstnameField.sendKeys("Chinnu");
                lastnameField.sendKeys("Venkateddy");
                urlField.sendKeys("Www.alchemy.com");
                
                //Create the user
                driver.findElement(By.xpath("//*[@id=\"createusersub\"]")).click();
                
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 driver.findElement(By.xpath("//*[@id=\"user-search-input\"]")).sendKeys("Venkatpallu123Chinnu");
			 driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
			 
			 String title = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr[1]/td[1]")).getText();
			 Assert.assertEquals("Venkatpallu123Chinnu", title);
			 System.out.println("The user is:" +title);
			 
	 }
			 

	 @AfterClass
		
	   public void afterClass() {
		
	 	
	       driver.close();
			
			 	}

    
    }

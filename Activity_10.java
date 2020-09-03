package job_Board_Team;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	public class Activity_10 {

		WebDriver driver;
		 @BeforeClass 
		 public void beforeClass () {					  			
		driver = new FirefoxDriver();	

			driver.get("https://alchemy.hguy.co/jobs/wp-admin");
			
			 driver.findElement(By.id("user_login")).sendKeys("root");
			 driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
			 
			 driver.findElement(By.id("wp-submit")).click();
			 
		 }

	 @Test 		
	public void Usercreation () {	
			 
			 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[11]/a/div[3]")).click();
			 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
			 
			 driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("pallaviqa109");
			 driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("pallavitest6478@gmail.com");
			 driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Pallavi Reddy");
			 driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Mummasani");
			 driver.findElement(By.xpath("//*[@id=\"url\"]")).sendKeys("www.alchemy.com");
			 driver.findElement(By.xpath("//*[@id=\"createusersub\"]")).click();
			 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 driver.findElement(By.xpath("//*[@id=\"user-search-input\"]")).sendKeys("pallaviqa109");
			 driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
			 
			 String title = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr[1]/td[1]")).getText();
			 Assert.assertEquals("pallaviqa109", title);
			 System.out.println("The user is:" +title);
			 
	 }
			 

	 @AfterClass
		
	   public void afterClass() {
		
	 	
	       driver.close();
			
			 	}

	}

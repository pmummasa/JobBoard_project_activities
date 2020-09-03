package job_Board_Team;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_9 {

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
public void Jobcreation () {	
	 
	 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/a/div[3]")).click();
	 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
	 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	 driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/div/div[2]/div[1]"));
	 
	 driver.findElement(By.xpath("//*[@id=\"post-title-0\"]")).sendKeys("Test Engineer");
	 			
	 driver.findElement(By.xpath("//*[@id=\"_application\"]")).sendKeys("pallavi123@gmail.com");
	 driver.findElement(By.xpath("//*[@id=\"_company_website\"]")).sendKeys("www.alchemy.com");
	 driver.findElement(By.xpath("//*[@id=\"_company_twitter\"]")).sendKeys("@alchemy");
	 driver.findElement(By.xpath("//*[@id=\"_job_location\"]")).sendKeys("Germany");
	 driver.findElement(By.xpath("//*[@id=\"_company_name\"]")).sendKeys("Alchemy");
	 driver.findElement(By.xpath("//*[@id=\"_company_tagline\"]")).sendKeys("Best Training");
	 
	 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")).click();
	 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();
	 		 
	 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")).click();
	 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	 String title = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/header/div/h1")).getText();
	 Assert.assertEquals("Test Engineer", title);
	 System.out.println("The job published:" +title);

}

@AfterClass
	
  public void afterClass() {
	
	
      driver.close();

}

}
package job_Board_Team;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_7 {
	WebDriver driver;
	 @BeforeClass 
	 public void beforeClass () {
		 
		 driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
}

@Test 		
public void JobPost () {
		
		driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[3]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"create_account_email\"]")).sendKeys("Test5786pallavi@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"job_title\"]")).sendKeys("Test Special Engineer");
		driver.findElement(By.xpath("//*[@id=\"job_location\"]")).sendKeys("USA");
		Select JobType = new Select(driver.findElement(By.name("job_type")));
		JobType.selectByVisibleText("Freelance");
		
		driver.switchTo().frame(driver.findElement(By.id("job_description_ifr")));
	    driver.findElement(By.id("tinymce")).sendKeys("Need 4 years experienced Automation Engineer");
	    driver.switchTo().parentFrame();
		
		driver.findElement(By.xpath("//*[@id=\"application\"]")).sendKeys("https://alchemy.hguy.co/jobs");
		driver.findElement(By.xpath("//*[@id=\"company_name\"]")).sendKeys("Alchemy");
		driver.findElement(By.xpath("//*[@id=\"company_website\"]")).sendKeys("www.alchemy.com");
		driver.findElement(By.xpath("//*[@id=\"company_tagline\"]")).sendKeys("Special Training");
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/form/p/input[4]")).click();
		
		 driver.findElement(By.xpath("//*[@id=\"job_preview_submit_button\"]")).click();
		 String message = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div")).getText();
		 System.out.println("Job submitted message is: " + message);
		 
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/a")).click();
		 
		 String message1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/div/div/ul/li[3]/time")).getText();
		 System.out.println("Job posted message is: " + message1);
				 
		 driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
		 driver.findElement(By.id("search_keywords")).sendKeys("Test Special Engineer");	
		 driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/form/div[1]/div[4]/input")).click();
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 String title = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/div/ul/li[1]/a/div[1]/h3")).getText();
		 Assert.assertEquals("Test Special Engineer", title);
		 System.out.println("The job posted is:" +title);

}


@AfterClass
	
 public void afterClass() {
	
	
     driver.close();
		
		}

}

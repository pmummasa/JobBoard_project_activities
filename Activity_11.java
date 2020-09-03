package job_Board_Team;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity_11 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
		
		driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();		
		driver.findElement(By.xpath("//*[@id=\"search_keywords\"]")).sendKeys("Senior");
		
		driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/form/div[1]/div[4]/input")).click();
			
		// Unchecking the checkboxes as predefaulted checked
		
		driver.findElement(By.id("job_type_freelance")).click();
		driver.findElement(By.id("job_type_internship")).click();
		driver.findElement(By.id("job_type_part-time")).click();
		driver.findElement(By.id("job_type_temporary")).click();
		
		driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/form/div[1]/div[4]/input")).click();
		
 		String title = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li[4]/a/div[1]/h3")).getText();
		 System.out.println("The title of the job is:" +title);
		 
		 driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li[5]/a/div[1]/h3")).click();
		 
		 driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/input")).click();
		 
		 driver.close();
	}

}

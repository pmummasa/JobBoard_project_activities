package job_Board_Team;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
		
		 List<WebElement>links=driver.findElements(By.tagName("img"));
		 
		 for(WebElement ele:links){
             System.out.println(ele.getAttribute("src"));
				
	        driver.close();

	}

}
	
}

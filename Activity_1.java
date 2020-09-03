package job_Board_Team;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity_1 {
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
		
		String actualtitle = driver.getTitle();
		 System.out.println("Page title is: " + actualtitle);
		 
		 String expectedTitle = "Alchemy Jobs – Job Board Application"	;
				 if (actualtitle.equalsIgnoreCase(expectedTitle))
				System.out.println("Title Matched");
			else
				System.out.println("Title didn't match");
		
		driver.close();
	}

}

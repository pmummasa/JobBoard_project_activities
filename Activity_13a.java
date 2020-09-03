package job_Board_Team;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Activity_13a {
    public static void main(String args[]) {
    	
    	WebDriver driver = new FirefoxDriver();
    	
    	String filePath = "src/test/resources/JobPost.xlsx";
    	
        //Create an object of current class
    	Activity_13a srcExcel = new Activity_13a();
    	
        //Call read file method of the class to read data
		  List<List<String>> data = srcExcel.readExcel(filePath);
	      List<String> row ;
	     
	      driver.get("https://alchemy.hguy.co/jobs/");
	     
	      row = data.get(1);
	     
	      //post a job
	      driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[3]/a")).click();
		 
		  driver.findElement(By.id("create_account_email")).sendKeys(row.get(1));
		 
		  driver.findElement(By.id("job_title")).sendKeys(row.get(2));
		 
		  driver.findElement(By.id("job_location")).sendKeys(row.get(3));
		 
		  Select dropdown = new Select(driver.findElement(By.id("job_type")));
		  dropdown.selectByVisibleText("Freelance");
		 
		  driver.findElement(By.id("job_description_ifr")).sendKeys(row.get(4));
		 
		  driver.findElement(By.id("application")).sendKeys(row.get(5));
		 
		  driver.findElement(By.id("company_name")).sendKeys(row.get(6));
		 
		  driver.findElement(By.id("company_website")).sendKeys(row.get(7));
		 
		  driver.findElement(By.id("company_tagline")).sendKeys("IBM");
		 
		  driver.findElement(By.id("company_video")).sendKeys("www.test.com");
		 
		  driver.findElement(By.id("company_twitter")).sendKeys("test");
		 
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/form/p/input[4]")).click();
		  
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 
		  driver.findElement(By.id("job_preview_submit_button")).click();
		 
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 
		//Navigation job list page
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/a")).click();

			//Apply for job
	                driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/div/div/div[3]/input")).click();

			//Navigating job listing page
	                 driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();

			//search
			 WebElement search = driver.findElement(By.id("search_keywords"));
			 search.sendKeys(row.get(2));
			 driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/form/div[1]/div[4]/input")).click();
					 		 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 String title = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/div/ul/li[1]/a/div[1]/h3")).getText();
			 Assert.assertEquals("Testing software Engineer", title);
			 System.out.println("The job posted is:" +title);
			
			 driver.close();
	    }
        	
    public List<List<String>> readExcel(String filePath) {
        List<List<String>> data = new ArrayList<List<String>>();
        try {
            FileInputStream file = new FileInputStream(filePath);
            //Create Workbook instance holding reference to Excel file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                //Temp variable
                List<String> rowData = new ArrayList<String>();
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if(row.getLastCellNum() == 8) {
                        //Store row data
                        rowData.add(cell.getStringCellValue());
                    }
                }
                //Store row data in List
                data.add(rowData);
            }
            file.close();
            workbook.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
         
		
		System.setProperty("webdriver.chrome.driver", "/Users/carlosrosendo/Documents/Automation/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	    
	    String[]itemsNeeded = {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
		
	    driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	   
	    
	    driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
	    driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
	    driver.findElement(By.xpath("//span[text()=' User']")).click();
	    //Thread.sleep(3000);
	    
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
	    driver.findElement(By.id("okayBtn")).click();
	    driver.findElement(By.cssSelector("select[class='form-control']")).click();
	    WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
	    Select dropdown = new Select(staticDropdown);
	    dropdown.selectByIndex(2);
	    driver.findElement(By.id("terms")).click();
	    
	    driver.findElement(By.id("signInBtn")).click();
	   
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
	
	    addItems(driver, itemsNeeded);
		
	   // Thread.sleep(10000);
		//driver.close();
		
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded)
	{
		// TODO Auto-generated method stub
		
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));
		
		for(int i=0; i<products.size(); i++)
		{
			//System.out.println(i);
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			
			//System.out.println(name);
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(formattedName))
			{
			j++;
			driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
			
			if(j == itemsNeeded.length)
			{
			break;
			}
			
		}
		
		
		
		
		
	}
	
	

}
}
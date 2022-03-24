package week4.day1.assignments;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 *Alerts and Window handling
---------------------------
1. Load https://www.irctc.co.in/
2. Click on OK button in the dialog  
3. Click on FLIGHTS link            
4. Go to the Flights tab
5. Print the customer care email id
6. Close the First tab(Train ticket booking) alone

		 */
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("https://www.irctc.co.in/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

//driver.switchTo().alert();
driver.findElement(By.xpath("//button[text()='OK']")).click();
driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();

Set<String> windowhandles = driver.getWindowHandles();
List<String> newwindow=new LinkedList<String>(windowhandles);
driver.switchTo().window(newwindow.get(1));
String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);//print current url
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='Later']")).click();
	driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
	String email = driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[3]")).getText();
	System.out.println("customer care email id="+email);
	driver.switchTo().defaultContent();
	
	
driver.close();

		
		
		
	}

}
